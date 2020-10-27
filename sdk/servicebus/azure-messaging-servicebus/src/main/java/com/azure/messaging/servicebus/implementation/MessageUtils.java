// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.servicebus.implementation;

import com.azure.core.amqp.implementation.AmqpConstants;
import com.azure.core.amqp.implementation.TracerProvider;
import com.azure.core.util.Context;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.tracing.ProcessKind;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusReceivedMessage;
import com.azure.messaging.servicebus.ServiceBusTransactionContext;
import org.apache.qpid.proton.amqp.Binary;
import org.apache.qpid.proton.amqp.Symbol;
import org.apache.qpid.proton.amqp.messaging.Accepted;
import org.apache.qpid.proton.amqp.messaging.Modified;
import org.apache.qpid.proton.amqp.messaging.Outcome;
import org.apache.qpid.proton.amqp.messaging.Rejected;
import org.apache.qpid.proton.amqp.transaction.TransactionalState;
import org.apache.qpid.proton.amqp.transport.DeliveryState;
import org.apache.qpid.proton.amqp.transport.ErrorCondition;
import reactor.core.publisher.Signal;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static com.azure.core.util.tracing.Tracer.AZ_TRACING_NAMESPACE_KEY;
import static com.azure.core.util.tracing.Tracer.DIAGNOSTIC_ID_KEY;
import static com.azure.core.util.tracing.Tracer.ENTITY_PATH_KEY;
import static com.azure.core.util.tracing.Tracer.HOST_NAME_KEY;
import static com.azure.core.util.tracing.Tracer.MESSAGE_ENQUEUED_TIME;
import static com.azure.core.util.tracing.Tracer.SCOPE_KEY;
import static com.azure.core.util.tracing.Tracer.SPAN_CONTEXT_KEY;
import static com.azure.messaging.servicebus.implementation.ServiceBusConstants.AZ_TRACING_SERVICE_NAME;
import static com.azure.messaging.servicebus.implementation.ServiceBusConstants.AZ_TRACING_NAMESPACE_VALUE;


/**
 * Contains helper methods for message conversions, reading status codes, and getting delivery state.
 */
public final class MessageUtils {
    static final UUID ZERO_LOCK_TOKEN = new UUID(0L, 0L);
    static final int LOCK_TOKEN_SIZE = 16;

    private static final Symbol DEAD_LETTER_OPERATION = Symbol.getSymbol(AmqpConstants.VENDOR + ":dead-letter");
    private static final String DEAD_LETTER_REASON = "DeadLetterReason";
    private static final String DEAD_LETTER_ERROR_DESCRIPTION = "DeadLetterErrorDescription";
    private static final long EPOCH_IN_DOT_NET_TICKS = 621355968000000000L;
    private static final int GUID_SIZE = 16;

    private MessageUtils() {
    }

    // Pass little less than client timeout to the server so client doesn't time out before server times out
    public static Duration adjustServerTimeout(Duration clientTimeout) {
        return clientTimeout.minusMillis(1000);
    }

    /**
     * Converts a .NET GUID to its Java UUID representation.
     *
     * @param dotNetBytes .NET GUID to convert.
     *
     * @return the equivalent UUID.
     */
    static UUID convertDotNetBytesToUUID(byte[] dotNetBytes) {
        // First 4 bytes are in reverse order, 5th and 6th bytes are in reverse order,
        // 7th and 8th bytes are also in reverse order
        if (dotNetBytes == null || dotNetBytes.length != GUID_SIZE) {
            return ZERO_LOCK_TOKEN;
        }

        final byte[] reOrderedBytes = reorderBytes(dotNetBytes);

        final ByteBuffer buffer = ByteBuffer.wrap(reOrderedBytes);
        final long mostSignificantBits = buffer.getLong();
        final long leastSignificantBits = buffer.getLong();
        return new UUID(mostSignificantBits, leastSignificantBits);
    }

    /**
     * Converts a Java UUID to its byte[] representation.
     *
     * @param uuid UUID to convert to .NET bytes.
     *
     * @return The .NET byte representation.
     */
    static byte[] convertUUIDToDotNetBytes(UUID uuid) {
        if (uuid == null || uuid.equals(ZERO_LOCK_TOKEN)) {
            return new byte[GUID_SIZE];
        }

        ByteBuffer buffer = ByteBuffer.allocate(GUID_SIZE);
        buffer.putLong(uuid.getMostSignificantBits());
        buffer.putLong(uuid.getLeastSignificantBits());
        byte[] javaBytes = buffer.array();

        return reorderBytes(javaBytes);
    }

    /**
     * Gets the {@link OffsetDateTime} representation of .NET epoch ticks. .NET ticks are measured from 0001/01/01.
     * Java {@link OffsetDateTime} is measured from 1970/01/01.
     *
     * @param dotNetTicks long measured from 01/01/0001
     *
     * @return The instant represented by the ticks.
     */
    static OffsetDateTime convertDotNetTicksToOffsetDateTime(long dotNetTicks) {
        long ticksFromEpoch = dotNetTicks - EPOCH_IN_DOT_NET_TICKS;
        long millisecondsFromEpoch = Double.valueOf(ticksFromEpoch * 0.0001).longValue();
        long fractionTicks = ticksFromEpoch % 10000;

        return Instant.ofEpochMilli(millisecondsFromEpoch).plusNanos(fractionTicks * 100).atOffset(ZoneOffset.UTC);
    }

    /**
     * Given the disposition state, returns its associated delivery state.
     *
     * @return The corresponding DeliveryState, or null if the disposition status is unknown.
     */
    public static DeliveryState getDeliveryState(DispositionStatus dispositionStatus, String deadLetterReason,
        String deadLetterErrorDescription, Map<String, Object> propertiesToModify,
        ServiceBusTransactionContext transactionContext) {

        boolean hasTransaction = transactionContext != null && transactionContext.getTransactionId() != null;

        final DeliveryState state;
        switch (dispositionStatus) {
            case COMPLETED:
                if (hasTransaction) {
                    state = getTransactionState(transactionContext.getTransactionId(), Accepted.getInstance());
                } else {
                    state = Accepted.getInstance();
                }
                break;
            case SUSPENDED:
                final Rejected rejected = new Rejected();
                final ErrorCondition error = new ErrorCondition(DEAD_LETTER_OPERATION, null);
                final Map<String, Object> errorInfo = new HashMap<>();
                if (!CoreUtils.isNullOrEmpty(deadLetterReason)) {
                    errorInfo.put(DEAD_LETTER_REASON, deadLetterReason);
                }
                if (!CoreUtils.isNullOrEmpty(deadLetterErrorDescription)) {
                    errorInfo.put(DEAD_LETTER_ERROR_DESCRIPTION, deadLetterErrorDescription);
                }
                if (propertiesToModify != null) {
                    errorInfo.putAll(propertiesToModify);
                }
                error.setInfo(errorInfo);
                rejected.setError(error);

                if (hasTransaction) {
                    state = getTransactionState(transactionContext.getTransactionId(), rejected);
                } else {
                    state = rejected;
                }
                break;
            case ABANDONED:
                final Modified outcome = new Modified();
                if (propertiesToModify != null) {
                    outcome.setMessageAnnotations(propertiesToModify);
                }

                if (hasTransaction) {
                    state = getTransactionState(transactionContext.getTransactionId(), outcome);
                } else {
                    state = outcome;
                }
                break;
            case DEFERRED:
                final Modified deferredOutcome = new Modified();
                deferredOutcome.setUndeliverableHere(true);
                if (propertiesToModify != null) {
                    deferredOutcome.setMessageAnnotations(propertiesToModify);
                }

                if (hasTransaction) {
                    state = getTransactionState(transactionContext.getTransactionId(), deferredOutcome);
                } else {
                    state = deferredOutcome;
                }
                break;
            default:
                state = null;
        }

        return state;
    }

    /**
     * Gets the primitive value or {@code false} if there is no value.
     *
     * @param value The value.
     * @return It's primitive type.
     */
    public static boolean toPrimitive(Boolean value) {
        return value != null ? value : false;
    }

    /**
     * Gets the primitive value or 0 if there is no value.
     *
     * @param value The value.
     * @return It's primitive type.
     */
    public static int toPrimitive(Integer value) {
        return value != null ? value : 0;
    }

    /**
     * Gets the primitive value or {@code 0L} if there is no value.
     *
     * @param value The value.
     * @return It's primitive type.
     */
    public static long toPrimitive(Long value) {
        return value != null ? value : 0L;
    }

    private static byte[] reorderBytes(byte[] javaBytes) {
        byte[] reorderedBytes = new byte[GUID_SIZE];
        for (int i = 0; i < GUID_SIZE; i++) {
            int indexInReorderedBytes;
            switch (i) {
                case 0:
                    indexInReorderedBytes = 3;
                    break;
                case 1:
                    indexInReorderedBytes = 2;
                    break;
                case 2:
                    indexInReorderedBytes = 1;
                    break;
                case 3:
                    indexInReorderedBytes = 0;
                    break;
                case 4:
                    indexInReorderedBytes = 5;
                    break;
                case 5:
                    indexInReorderedBytes = 4;
                    break;
                case 6:
                    indexInReorderedBytes = 7;
                    break;
                case 7:
                    indexInReorderedBytes = 6;
                    break;
                default:
                    indexInReorderedBytes = i;
            }

            reorderedBytes[indexInReorderedBytes] = javaBytes[i];
        }

        return reorderedBytes;
    }

    private static TransactionalState getTransactionState(ByteBuffer transactionId, Outcome outcome) {
        TransactionalState transactionalState = new TransactionalState();
        transactionalState.setTxnId(new Binary(transactionId.array()));
        transactionalState.setOutcome(outcome);
        return transactionalState;
    }

    public static ServiceBusMessage traceMessageSpan(ServiceBusMessage serviceBusMessage,
        Context messageContext, String hostname, String entityPath, TracerProvider tracerProvider) {
        Optional<Object> eventContextData = messageContext.getData(SPAN_CONTEXT_KEY);
        if (eventContextData.isPresent()) {
            // if message has context (in case of retries), don't start a message span or add a new context
            return serviceBusMessage;
        } else {
            // Starting the span makes the sampling decision (nothing is logged at this time)
            Context newMessageContext = messageContext
                .addData(AZ_TRACING_NAMESPACE_KEY, AZ_TRACING_NAMESPACE_VALUE)
                .addData(ENTITY_PATH_KEY, entityPath)
                .addData(HOST_NAME_KEY, hostname);
            Context eventSpanContext = tracerProvider.startSpan(AZ_TRACING_SERVICE_NAME, newMessageContext,
                ProcessKind.MESSAGE);
            Optional<Object> eventDiagnosticIdOptional = eventSpanContext.getData(DIAGNOSTIC_ID_KEY);
            if (eventDiagnosticIdOptional.isPresent()) {
                serviceBusMessage.getApplicationProperties().put(DIAGNOSTIC_ID_KEY, eventDiagnosticIdOptional.get()
                    .toString());
                tracerProvider.endSpan(eventSpanContext, Signal.complete());
                serviceBusMessage.addContext(SPAN_CONTEXT_KEY, eventSpanContext);
            }
        }
        return serviceBusMessage;
    }

    /*
     * Starts a new process tracing span and attaches the returned context to the ServiceBusReceivedMessage object for users.
     */
    public static Context startProcessTracingSpan(ServiceBusReceivedMessage receivedMessage,
        String hostname, String entityPath, TracerProvider tracerProvider, ProcessKind processKind) {
        Object diagnosticId = receivedMessage.getApplicationProperties().get(DIAGNOSTIC_ID_KEY);
        if (diagnosticId == null || !tracerProvider.isEnabled()) {
            return Context.NONE;
        }

        Context spanContext = tracerProvider.extractContext(diagnosticId.toString(), Context.NONE)
            .addData(ENTITY_PATH_KEY, entityPath)
            .addData(HOST_NAME_KEY, hostname)
            .addData(AZ_TRACING_NAMESPACE_KEY, AZ_TRACING_NAMESPACE_VALUE);
        spanContext = receivedMessage.getEnqueuedTime() == null
            ? spanContext
            : spanContext.addData(MESSAGE_ENQUEUED_TIME, receivedMessage.getEnqueuedTime().toEpochSecond());
        return tracerProvider.startSpan(AZ_TRACING_SERVICE_NAME, spanContext, processKind);
    }

    /*
     * Ends the process tracing span and the scope of that span.
     */
    public static void endProcessTracingSpan(Context processSpanContext, Signal<Void> signal,
        TracerProvider tracerProvider, ClientLogger logger) {
        if (processSpanContext != null) {
            Optional<Object> spanScope = processSpanContext.getData(SCOPE_KEY);
            // Disposes of the scope when the trace span closes.
            if (tracerProvider.isEnabled() && spanScope.isPresent()) {
                if (spanScope.get() instanceof Closeable) {
                    Closeable close = (Closeable) spanScope.get();
                    try {
                        close.close();
                        tracerProvider.endSpan(processSpanContext, signal);
                    } catch (IOException ioException) {
                        logger.error(Messages.MESSAGE_PROCESSOR_RUN_END, ioException);
                    }

                } else {
                    logger.warning(String.format(Locale.US,
                        Messages.PROCESS_SPAN_SCOPE_TYPE_ERROR, spanScope.getClass()));
                }
            }
        }
    }
}
