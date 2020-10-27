// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.servicebus;

import com.azure.core.amqp.implementation.MessageSerializer;
import com.azure.core.amqp.implementation.TracerProvider;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.messaging.servicebus.implementation.MessagingEntityType;
import com.azure.messaging.servicebus.implementation.ServiceBusConnectionProcessor;
import com.azure.messaging.servicebus.implementation.ServiceBusConstants;
import reactor.core.publisher.Mono;

import java.util.Objects;

import static com.azure.core.util.FluxUtil.monoError;

/**
 * This session receiver client is used to acquire session locks from a queue or topic and create
 * {@link ServiceBusReceiverAsyncClient} instances that are tied to the locked sessions.
 * <ul>
 *     <li>
 *         Use {@link #acceptSession(String)} to acquire the lock of a session if you know the session id.
 *         <p>
 *         {@codesnippet com.azure.messaging.servicebus.servicebusasyncreceiverclient.instantiation#nextsession}
 *         </p>
 *    </li>
 *    <li>
 *        Use {@link #acceptNextSession()} to acquire the lock of the next availabe session
 *        without specifying the session id.
 *        <p>
 *        {@codesnippet com.azure.messaging.servicebus.servicebusasyncreceiverclient.instantiation#sessionId}
 *        </p>
 *    </li>
 * </ul>
 *
 */
public final class ServiceBusSessionReceiverAsyncClient implements AutoCloseable {
    private final String fullyQualifiedNamespace;
    private final String entityPath;
    private final MessagingEntityType entityType;
    private final ReceiverOptions receiverOptions;
    private final ServiceBusConnectionProcessor connectionProcessor;
    private final TracerProvider tracerProvider;
    private final MessageSerializer messageSerializer;
    private final Runnable onClientClose;
    private final ServiceBusSessionManager unNamedSessionManager;  // for acceptNextSession()
    private final ClientLogger logger = new ClientLogger(ServiceBusSessionReceiverAsyncClient.class);

    ServiceBusSessionReceiverAsyncClient(String fullyQualifiedNamespace, String entityPath,
        MessagingEntityType entityType, ReceiverOptions receiverOptions,
        ServiceBusConnectionProcessor connectionProcessor, TracerProvider tracerProvider,
        MessageSerializer messageSerializer, Runnable onClientClose) {
        this.fullyQualifiedNamespace = Objects.requireNonNull(fullyQualifiedNamespace,
            "'fullyQualifiedNamespace' cannot be null.");
        this.entityPath = Objects.requireNonNull(entityPath, "'entityPath' cannot be null.");
        this.entityType = Objects.requireNonNull(entityType, "'entityType' cannot be null.");
        this.receiverOptions = Objects.requireNonNull(receiverOptions, "'receiveOptions cannot be null.'");
        this.connectionProcessor = Objects.requireNonNull(connectionProcessor, "'connectionProcessor' cannot be null.");
        this.tracerProvider = Objects.requireNonNull(tracerProvider, "'tracerProvider' cannot be null.");
        this.messageSerializer = Objects.requireNonNull(messageSerializer, "'messageSerializer' cannot be null.");
        this.onClientClose = Objects.requireNonNull(onClientClose, "'onClientClose' cannot be null.");
        this.unNamedSessionManager = new ServiceBusSessionManager(entityPath, entityType, connectionProcessor,
            tracerProvider, messageSerializer, receiverOptions);
    }

    /**
     * Acquires a session lock for the next available session and create a {@link ServiceBusReceiverAsyncClient}
     * to receive messages from the session.
     * <p>Accept next available session</p>
     * {@codesnippet com.azure.messaging.servicebus.servicebusasyncreceiverclient.instantiation#nextsession}
     * </p>
     * @return A {@link ServiceBusReceiverAsyncClient} that is tied to the available session.
     * @throws UnsupportedOperationException if the queue or topic subscription is not session-enabled.
     */
    public Mono<ServiceBusReceiverAsyncClient> acceptNextSession() {
        return unNamedSessionManager.getActiveLink().flatMap(receiveLink -> receiveLink.getSessionId()
            .map(sessionId -> {
                final ReceiverOptions newReceiverOptions = new ReceiverOptions(receiverOptions.getReceiveMode(),
                    receiverOptions.getPrefetchCount(), sessionId, null, receiverOptions.getMaxLockRenewDuration());
                final ServiceBusSessionManager sessionSpecificManager = new ServiceBusSessionManager(entityPath,
                    entityType, connectionProcessor, tracerProvider, messageSerializer, newReceiverOptions,
                    receiveLink);
                return new ServiceBusReceiverAsyncClient(fullyQualifiedNamespace, entityPath,
                    entityType, newReceiverOptions, connectionProcessor, ServiceBusConstants.OPERATION_TIMEOUT,
                    tracerProvider, messageSerializer, () -> { }, sessionSpecificManager);
            }));
    }

    /**
     * Acquires a session lock for {@code sessionId} and create a {@link ServiceBusReceiverAsyncClient}
     * to receive messages from the session.
     * <p>
     * {@codesnippet com.azure.messaging.servicebus.servicebusasyncreceiverclient.instantiation#sessionId}
     * </p>
     * @param sessionId The session Id.
     * @return A {@link ServiceBusReceiverAsyncClient} that is tied to the specified session.
     * @throws NullPointerException if {@code sessionId} is null.
     * @throws IllegalArgumentException if {@code sessionId} is empty.
     * @throws UnsupportedOperationException if the queue or topic subscription is not session-enabled.
     * @throws com.azure.core.amqp.exception.AmqpException if the session has been locked by another session receiver.
     */
    public Mono<ServiceBusReceiverAsyncClient> acceptSession(String sessionId) {
        sessionId = Objects.requireNonNull(sessionId, "'sessionId' cannot be null");
        if (CoreUtils.isNullOrEmpty(sessionId)) {
            return monoError(logger, new IllegalArgumentException("'sessionId' cannot be empty"));
        }
        final ReceiverOptions newReceiverOptions = new ReceiverOptions(receiverOptions.getReceiveMode(),
            receiverOptions.getPrefetchCount(), sessionId, null, receiverOptions.getMaxLockRenewDuration());
        final ServiceBusSessionManager sessionSpecificManager = new ServiceBusSessionManager(entityPath, entityType,
            connectionProcessor, tracerProvider, messageSerializer, newReceiverOptions);

        return sessionSpecificManager.getActiveLink().map(receiveLink -> new ServiceBusReceiverAsyncClient(
            fullyQualifiedNamespace, entityPath, entityType, newReceiverOptions, connectionProcessor,
            ServiceBusConstants.OPERATION_TIMEOUT, tracerProvider, messageSerializer, () -> { },
            sessionSpecificManager));
    }

    @Override
    public void close() {
        this.onClientClose.run();
    }
}
