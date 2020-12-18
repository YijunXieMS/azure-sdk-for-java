package com.azure.smoketest.messaging;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.messaging.eventgrid.CloudEvent;
import com.azure.messaging.eventgrid.EventGridEvent;
import com.azure.messaging.eventgrid.EventGridPublisherClient;
import com.azure.messaging.eventgrid.EventGridPublisherClientBuilder;

import java.util.List;

public class EventGrid {
    private static EventGridPublisherClient publisherClient;

    private static void publishCloudEvents() {
        CloudEvent ce = new CloudEvent("test", "test_type")
            .setSubject("test subject")
            .setId("test id")
            .setData("{\"key\": \"value\"}".getBytes(), "application/json");
        publisherClient.sendCloudEvents(List.of(ce));
    }

    private static void publishEventGridEvents() {
        EventGridEvent ege = new EventGridEvent("testSubject", "testEventType",
            "testData", "v1");
        publisherClient.sendEvents(List.of(ege));
    }

    private static void decodeCloudEvents() {

    }

    private static void decodeEventGridEvents() {
    }

    public static void main(String[] args) {
        publisherClient = new EventGridPublisherClientBuilder()
            .endpoint(System.getenv("AZURE_EVENTGRID_ENDPOINT"))
            .credential(new AzureKeyCredential(System.getenv("AZURE_EVENTGRID_KEY")))
            .buildClient();

        publishCloudEvents();
        publishEventGridEvents();
    }
}
