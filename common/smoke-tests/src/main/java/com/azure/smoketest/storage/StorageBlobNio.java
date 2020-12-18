package com.azure.smoketest.storage;

import com.azure.core.util.Configuration;
import com.azure.storage.blob.models.BlobHttpHeaders;
import com.azure.storage.blob.nio.AzureBlobFileAttributeView;
import com.azure.storage.blob.nio.AzureBlobFileAttributes;
import com.azure.storage.blob.nio.AzureFileSystem;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StorageBlobNio {
    private static final String ACCOUNT_NAME = Configuration.getGlobalConfiguration().get("AZURE_STORAGE_ACCOUNT_NAME");
    private static final String ACCOUNT_KEY = Configuration.getGlobalConfiguration().get("AZURE_STORAGE_ACCOUNT_KEY");

    private static FileSystem myFs;
    private static Path dirPath = myFs.getPath("dir");
    private static Path filePath = myFs.getPath("file");

    public StorageBlobNio() throws IOException, URISyntaxException {
    }

    public void createAFileSystem() throws URISyntaxException, IOException {

    }

    public static void run() throws IOException {
        // create directory
        Files.createDirectory(dirPath);

        // write to a file
        OutputStream os = Files.newOutputStream(filePath);
        os.write(0);
        os.close();

        // read the file
        InputStream is = Files.newInputStream(filePath);
        is.read();
        is.close();

        // copy the file
        Path destinationPath = myFs.getPath("destinationFile");
        Files.copy(filePath, destinationPath, StandardCopyOption.COPY_ATTRIBUTES);

        // read the attribute of the file
        AzureBlobFileAttributes attr = Files.readAttributes(filePath, AzureBlobFileAttributes.class);
        BlobHttpHeaders headers = attr.blobHttpHeaders();

        // write file attributes
        AzureBlobFileAttributeView view = Files.getFileAttributeView(filePath, AzureBlobFileAttributeView.class);
        view.setMetadata(Collections.EMPTY_MAP);

        // list files
        for (Path p : Files.newDirectoryStream(dirPath)) {
            System.out.println(p.toString());
        }

        // delete files
        Files.deleteIfExists(filePath);
        Files.deleteIfExists(destinationPath);
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        Map<String, Object> config = new HashMap<>();
        String stores = "NioSmokeContainer";
        config.put(AzureFileSystem.AZURE_STORAGE_ACCOUNT_KEY, ACCOUNT_KEY);
        config.put(AzureFileSystem.AZURE_STORAGE_FILE_STORES, stores);
        myFs = FileSystems.newFileSystem(new URI(String.format("azb://?account=%s", ACCOUNT_NAME)), config);
        run();
        myFs.close();
    }
}
