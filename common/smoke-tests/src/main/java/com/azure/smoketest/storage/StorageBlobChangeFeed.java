package com.azure.smoketest.storage;

import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.changefeed.BlobChangefeedClient;
import com.azure.storage.blob.changefeed.BlobChangefeedClientBuilder;
import com.azure.storage.blob.changefeed.models.BlobChangefeedEvent;

public class StorageBlobChangeFeed {
    private static BlobChangefeedClient changefeedClient;

    private static void getEvents() {
        for (BlobChangefeedEvent event : changefeedClient.getEvents()) {
            System.out.printf("Topic: %s, Subject: %s%n", event.getTopic(), event.getSubject());
        }
    }

    public static void main(String[] args) {
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
            .connectionString(System.getenv("AZURE_STORAGE_CONN_STR"))
            .buildClient();
        changefeedClient = new BlobChangefeedClientBuilder(blobServiceClient).buildClient();
    }
}
