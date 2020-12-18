package com.azure.smoketest.storage;

import com.azure.core.cryptography.AsyncKeyEncryptionKey;
import com.azure.security.keyvault.keys.cryptography.LocalKeyEncryptionKeyClientBuilder;
import com.azure.security.keyvault.keys.models.JsonWebKey;
import com.azure.security.keyvault.keys.models.KeyOperation;
import com.azure.storage.blob.specialized.cryptography.EncryptedBlobClient;
import com.azure.storage.blob.specialized.cryptography.EncryptedBlobClientBuilder;

import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

public class StorageBlobCrypography {
    private static EncryptedBlobClient encryptedBlobClient;

    private static void uploadBlob() {
    }

    public static void main(String[] args) {
//        JsonWebKey localKey = JsonWebKey.fromAes(new SecretKeySpec(keyBytes, secretKeyAlgorithm),
//            Arrays.asList(KeyOperation.WRAP_KEY, KeyOperation.UNWRAP_KEY))
//            .setId("my-id");
//        AsyncKeyEncryptionKey akek = new LocalKeyEncryptionKeyClientBuilder()
//            .buildAsyncKeyEncryptionKey(localKey).block();
//
//        encryptedBlobClient = new EncryptedBlobClientBuilder()
//            .key(akek, keyWrapAlgorithm)
//            .connectionString(connectionString)
//            .buildEncryptedBlobClient();
    }
}
