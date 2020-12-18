// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.smoketest.storage;

import com.azure.core.http.rest.PagedIterable;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.batch.BlobBatchClient;
import com.azure.storage.blob.batch.BlobBatchClientBuilder;
import com.azure.storage.blob.models.AccessTier;
import com.azure.storage.blob.models.DeleteSnapshotsOptionType;
import com.azure.storage.blob.specialized.BlockBlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.models.BlobItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class StorageBlobBatch {
    private static BlobContainerClient containerClient;
    private static BlobBatchClient batchClient;
    private static BlockBlobClient blockBlobClient;

    private static final String STORAGE_CONNECTION_STRING = System.getenv("AZURE_STORAGE_CONNECTION_STRING");

    private static final String CONTAINER_NAME = "mycontainer"; //This sample needs an existing container
    private static final String BLOB_NAME = "javaSmokeTestBlob-"+ UUID.randomUUID() +".txt";

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageBlobBatch.class);

    private static void uploadBlob() {
        LOGGER.info("Uploading blob... ");
        String text = "This is a sample block blob created for SDK Smoke Test in Java!";
        ByteArrayInputStream data = new ByteArrayInputStream(text.getBytes());
        blockBlobClient.upload(data, text.length());
        LOGGER.info("\tDONE.");
    }

    private static void bulkSetBlobAccessTier() {
        LOGGER.info("Batch setting access tier... ");
        PagedIterable<BlobItem> blobItems = containerClient.listBlobs();
        List<String> blobUrls = blobItems.stream().map(blobItem ->
            containerClient.getBlobContainerUrl() + "/" + blobItem.getName()
        ).collect(Collectors.toList());
        batchClient.setBlobsAccessTier(blobUrls, AccessTier.HOT);
        LOGGER.info("\tDONE.");
    }

    private static void bulkDeleteBlobs() {
        LOGGER.info("Batch deleting blobs... ");
        PagedIterable<BlobItem> blobItems = containerClient.listBlobs();
        List<String> blobUrls = blobItems.stream().map(blobItem ->
            containerClient.getBlobContainerUrl() + "/" + blobItem.getName()
        ).collect(Collectors.toList());
        batchClient.deleteBlobs(blobUrls, DeleteSnapshotsOptionType.INCLUDE);
        LOGGER.info("\tDONE.");
    }

    public static void main(String[] args) throws IOException {
        LOGGER.info("---------------------");
        LOGGER.info("STORAGE - BLOB");
        LOGGER.info("---------------------");

        BlobServiceClient serviceClient = new BlobServiceClientBuilder()
            .connectionString(STORAGE_CONNECTION_STRING)
            .buildClient();
        batchClient = new BlobBatchClientBuilder(serviceClient).buildClient();
        containerClient = serviceClient.getBlobContainerClient(CONTAINER_NAME);
        BlobClient blobClient = containerClient.getBlobClient(BLOB_NAME);
        blockBlobClient = blobClient.getBlockBlobClient();

        uploadBlob();
        bulkSetBlobAccessTier();
        bulkDeleteBlobs();
    }
}
