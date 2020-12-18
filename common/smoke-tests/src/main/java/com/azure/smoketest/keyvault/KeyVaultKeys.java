package com.azure.smoketest.keyvault;

import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.core.util.polling.PollResponse;
import com.azure.core.util.polling.SyncPoller;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.keys.KeyClient;
import com.azure.security.keyvault.keys.KeyClientBuilder;
import com.azure.security.keyvault.keys.models.CreateRsaKeyOptions;
import com.azure.security.keyvault.keys.models.DeletedKey;
import com.azure.security.keyvault.keys.models.KeyVaultKey;

import java.time.OffsetDateTime;

public class KeyVaultKeys {
    private final static String KEY_VAULT_URL = System.getenv("AZURE_KEY_VAULT_URL");
    private static KeyClient keyClient;

    private static void createAndDeleteKey() throws InterruptedException {
        // Create the Rsa Key
        Response<KeyVaultKey> createKeyResponse = keyClient.createRsaKeyWithResponse(new CreateRsaKeyOptions("CloudRsaKey")
            .setExpiresOn(OffsetDateTime.now().plusYears(1))
            .setKeySize(2048), new Context("key1", "value1"));

        System.out.printf("Create Key operation succeeded with status code %s \n", createKeyResponse.getStatusCode());

        // Get the Cloud Rsa Key from the key vault.
        KeyVaultKey cloudRsaKey = keyClient.getKey("CloudRsaKey");
        System.out.printf("Key is returned with name %s and type %s \n", cloudRsaKey.getName(),
            cloudRsaKey.getKeyType());

        // Update the Rsa key expiration date
        cloudRsaKey.getProperties().setExpiresOn(cloudRsaKey.getProperties().getExpiresOn().plusYears(1));
        KeyVaultKey updatedKey = keyClient.updateKeyProperties(cloudRsaKey.getProperties());
        System.out.printf("Key's updated expiry time %s \n", updatedKey.getProperties().getExpiresOn());

        // Create a new version of the Rsa key.
        keyClient.createRsaKey(new CreateRsaKeyOptions("CloudRsaKey")
            .setExpiresOn(OffsetDateTime.now().plusYears(1))
            .setKeySize(4096));

        // Delete the RSA key
        SyncPoller<DeletedKey, Void> rsaDeletedKeyPoller = keyClient.beginDeleteKey("CloudRsaKey");

        PollResponse<DeletedKey> pollResponse = rsaDeletedKeyPoller.poll();

        DeletedKey rsaDeletedKey = pollResponse.getValue();
        System.out.println("Deleted Date  %s" + rsaDeletedKey.getDeletedOn().toString());
        System.out.printf("Deleted Key's Recovery Id %s", rsaDeletedKey.getRecoveryId());

        // Key is being deleted on server.
        rsaDeletedKeyPoller.waitForCompletion();

        // To ensure key is deleted on server side.
        Thread.sleep(30000);

        // If the keyvault is soft-delete enabled, then for permanent deletion  deleted keys need to be purged.
        keyClient.purgeDeletedKey("CloudRsaKey");
    }

    public static void main(String[] args) throws InterruptedException {
        keyClient = new KeyClientBuilder()
            .vaultUrl(KEY_VAULT_URL)
            .credential(new DefaultAzureCredentialBuilder().build())
            .buildClient();

        createAndDeleteKey();
    }
}
