package com.azure.messaging.eventhubs;

import com.azure.core.amqp.implementation.ErrorContextProvider;
import com.azure.core.amqp.implementation.TracerProvider;
import com.azure.messaging.eventhubs.models.CreateBatchOptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicReference;

public class EventDataBatchTransformer {
    private EventHubProducerAsyncClient client;
    private CreateBatchOptions options;

    public EventDataBatchTransformer(EventHubProducerAsyncClient client, CreateBatchOptions options) {
        this.client = client;
        this.options = options;
    }
    public Flux<EventDataBatch> bufferEventDataBatch(Flux<EventData> flux) {
        AtomicReference<EventDataBatch> batchReference = new AtomicReference<>();
        batchReference.set(client.createBatchSync(options));
        return flux.handle(
            (eventData, sink) -> {
                EventDataBatch batch = batchReference.get();
                if (!batch.tryAdd(eventData)) {
                    if (batch.getCount() == 0) {
                        Mono.error(new IllegalArgumentException(
                            "An EventData is larger than the max allowed size of the EventDataBatch"));
                    }
                    sink.next(batch);
                    batchReference.set(client.createBatchSync(options));
                }
            });
    }

    public Flux<EventDataBatch> bufferEventDataBatch2(Flux<EventData> flux) {
        AtomicReference<EventDataBatch> batchReference = new AtomicReference<>();
        batchReference.set(client.createBatchSync(options));
        return flux.handle(
            (eventData, sink) -> {
                EventDataBatch batch = batchReference.get();
                if (!batch.tryAdd(eventData)) {
                    if (batch.getCount() == 0) {
                        Mono.error(new IllegalArgumentException(
                            "An EventData is larger than the max allowed size of the EventDataBatch"));
                    }
                    sink.next(batch);
                    batchReference.set(client.createBatchSync(options));
                }
            });
    }
}
