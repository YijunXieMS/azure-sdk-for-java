package com.azure.smoketest.messaging;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.messaging.eventgrid.CloudEvent;
import com.azure.messaging.eventgrid.EventGridEvent;
import com.azure.messaging.eventgrid.EventGridPublisherClient;
import com.azure.messaging.eventgrid.EventGridPublisherClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EventGrid {
    private static final String AZURE_EVENTGRID_ENDPOINT = System.getenv("AZURE_EVENTGRID_ENDPOINT");
    private static final String AZURE_EVENTGRID_KEY = System.getenv("AZURE_EVENTGRID_KEY");

    private static EventGridPublisherClient publisherClient;
    private static final Logger LOGGER = LoggerFactory.getLogger(EventGrid.class);


    private static void publishCloudEvents() {
        LOGGER.info("Publishing cloud events");
        CloudEvent ce = new CloudEvent("test", "test_type")
            .setSubject("test subject")
            .setId("test id")
            .setData("{\"key\": \"value\"}".getBytes(), "application/json");
        publisherClient.sendCloudEvents(List.of(ce));
        LOGGER.info("DONE: publishing");
    }

    private static void publishEventGridEvents() {
        LOGGER.info("Publishing cloud events");
        EventGridEvent ege = new EventGridEvent("testSubject", "testEventType",
            "testData", "v1");
        publisherClient.sendEvents(List.of(ege));
        LOGGER.info("DONE: publishing");
    }

    private static void decodeCloudEvents() {
        //TODO: SDK will be changed soon
    }

    private static void decodeEventGridEvents() {
        //TODO: SDK will be changed soon
    }

    public static void main(String[] args) {
        LOGGER.info("---------------------");
        LOGGER.info("Event Grid");
        LOGGER.info("---------------------");
        publisherClient = new EventGridPublisherClientBuilder()
            .endpoint(AZURE_EVENTGRID_ENDPOINT)
            .credential(new AzureKeyCredential(AZURE_EVENTGRID_KEY))
            .buildClient();

        publishCloudEvents();
        publishEventGridEvents();
    }
}
