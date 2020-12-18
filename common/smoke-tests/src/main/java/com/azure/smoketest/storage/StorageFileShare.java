package com.azure.smoketest.storage;

import com.azure.storage.file.share.ShareClient;
import com.azure.storage.file.share.ShareFileClient;
import com.azure.storage.file.share.ShareServiceClient;
import com.azure.storage.file.share.ShareServiceClientBuilder;
import com.azure.storage.file.share.models.ShareFileUploadInfo;

import java.io.ByteArrayInputStream;

public class StorageFileShare {
    private static final String STORAGE_CONNECTION_STRING = System.getenv("AZURE_STORAGE_CONNECTION_STRING");

    private static ShareServiceClient shareServiceClient;

    private static void createShareFileAndUpload() {
        ShareClient shareClient = shareServiceClient.createShare("SmokeTestShare");
        ShareFileClient fileClient = shareClient.createFile("SmokeTestFile", 1024);
        final byte[] toUpload = "Hello DataLake File".getBytes();
        ShareFileUploadInfo uploadInfo = fileClient.upload(new ByteArrayInputStream(toUpload), toUpload.length);
        System.out.println("Share file is uploaded: " + uploadInfo.getETag());
        fileClient.delete();
        shareClient.delete();
    }

    public static void main(String[] args) {
        shareServiceClient = new ShareServiceClientBuilder()
            .connectionString(STORAGE_CONNECTION_STRING)
            .buildClient();
        createShareFileAndUpload();
    }
}
