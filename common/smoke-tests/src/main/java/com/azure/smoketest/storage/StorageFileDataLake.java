package com.azure.smoketest.storage;

import com.azure.core.util.Configuration;
import com.azure.storage.common.StorageSharedKeyCredential;
import com.azure.storage.file.datalake.DataLakeDirectoryClient;
import com.azure.storage.file.datalake.DataLakeFileClient;
import com.azure.storage.file.datalake.DataLakeFileSystemClient;
import com.azure.storage.file.datalake.DataLakeServiceClient;
import com.azure.storage.file.datalake.DataLakeServiceClientBuilder;

import java.io.ByteArrayInputStream;

public class StorageFileDataLake {
    private static final String ENDPOINT = Configuration.getGlobalConfiguration().get("AZURE_STORAGE_DATALAKE_ENDPOINT");
    private static final String ACCOUNT_NAME = Configuration.getGlobalConfiguration().get("AZURE_STORAGE_ACCOUNT_NAME");
    private static final String ACCOUNT_KEY = Configuration.getGlobalConfiguration().get("AZURE_STORAGE_ACCOUNT_KEY");
    private static DataLakeServiceClient dataLakeServiceClient;

    private static void directoryOperations() {
        DataLakeFileSystemClient fileSystemClient = dataLakeServiceClient.createFileSystem("smokeTestDirectory");
        fileSystemClient.create();
        DataLakeDirectoryClient directoryClient = fileSystemClient.createDirectory("dir");
        final String subDir = "subdir";
        directoryClient.createSubdirectory(subDir);
        DataLakeDirectoryClient subDirectoryClient = directoryClient.getSubdirectoryClient(subDir);
        final String fileName = "file1";
        subDirectoryClient.createFile(fileName, true);

        subDirectoryClient.deleteFile(fileName);
        directoryClient.delete();
        fileSystemClient.delete();
    }

    private static void fileOperations() {
        DataLakeFileSystemClient fileSystemClient = dataLakeServiceClient.createFileSystem("smokeTestFile");
        fileSystemClient.create();
        DataLakeFileClient fileClient = fileSystemClient.createFile("file2");
        final byte[] toUpload = "Hello DataLake File".getBytes();
        fileClient.upload(new ByteArrayInputStream(toUpload), toUpload.length);

        fileClient.delete();
        fileSystemClient.delete();
    }

    public static void main(String[] args) {
        dataLakeServiceClient = new DataLakeServiceClientBuilder()
            .endpoint(ENDPOINT)
            .credential(new StorageSharedKeyCredential(ACCOUNT_NAME, ACCOUNT_KEY))
            .buildClient();
        directoryOperations();
        fileOperations();
    }
}
