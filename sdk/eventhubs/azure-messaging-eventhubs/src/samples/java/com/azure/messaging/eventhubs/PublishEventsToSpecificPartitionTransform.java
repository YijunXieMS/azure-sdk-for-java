// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.messaging.eventhubs;

import com.azure.core.amqp.AmqpRetryMode;
import com.azure.core.amqp.AmqpRetryOptions;
import com.azure.messaging.eventhubs.models.CreateBatchOptions;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Sample demonstrates how to:
 *
 * <ul>
 * <li>Send events to specific event hub partition by defining partition id using
 * {@link CreateBatchOptions#setPartitionId(String)}.</li>
 * <li>Set a custom retry policy for Event Hub operations.</li>
 * </ul>
 */
public class PublishEventsToSpecificPartitionTransform {
    private static final Duration OPERATION_TIMEOUT = Duration.ofSeconds(30);

    /**
     * Main method to invoke this demo about how to send a batch of events with partition id configured.
     *
     * @param args Unused arguments to the program.
     */
    public static void main(String[] args) {
        String connectionString = System.getenv("EVENT_HUB_CONN_STR");
        AmqpRetryOptions retryOptions = new AmqpRetryOptions()
            .setDelay(Duration.ofSeconds(30))
            .setMaxRetries(2)
            .setMode(AmqpRetryMode.EXPONENTIAL);

        EventHubProducerAsyncClient producer = new EventHubClientBuilder()
            .connectionString(connectionString)
            .retry(retryOptions)
            .buildAsyncProducerClient();

        Flux<EventData> events = Flux.just(
            new EventData("This is the first event.".getBytes(UTF_8)),
            new EventData("This is the second event.".getBytes(UTF_8)),
            new EventData("This is the third event.".getBytes(UTF_8)));

        final CreateBatchOptions options = new CreateBatchOptions()
            .setPartitionId("0");

        EventDataBatchTransformer transformer = new EventDataBatchTransformer(producer, options);
        events.transform(transformer::bufferEventDataBatch).flatMap(producer::send).subscribe();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ignored) {
        } finally {
            // Disposing of our producer.
            producer.close();
        }
    }
}
