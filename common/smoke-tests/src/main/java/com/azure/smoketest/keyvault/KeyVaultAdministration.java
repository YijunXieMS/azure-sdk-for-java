package com.azure.smoketest.keyvault;

import com.azure.core.util.polling.SyncPoller;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.administration.KeyVaultAccessControlClient;
import com.azure.security.keyvault.administration.KeyVaultAccessControlClientBuilder;
import com.azure.security.keyvault.administration.KeyVaultBackupClient;
import com.azure.security.keyvault.administration.KeyVaultBackupClientBuilder;
import com.azure.security.keyvault.administration.models.KeyVaultBackupOperation;
import com.azure.security.keyvault.administration.models.KeyVaultRestoreOperation;
import com.azure.security.keyvault.administration.models.KeyVaultRoleAssignment;
import com.azure.security.keyvault.administration.models.KeyVaultRoleDefinition;
import com.azure.security.keyvault.administration.models.KeyVaultRoleScope;

import java.util.ArrayList;
import java.util.List;

public class KeyVaultAdministration {
    private final static String KEY_VAULT_URL = System.getenv("AZURE_KEY_VAULT_URL");
    private final static String SERVICE_PRINCIPLE_ID = System.getenv("AZURE_CLIENT_ID");
    private final static String BACKUP_BLOB_STORAGE_URL = System.getenv("AZURE_STORAGE_CONNECTION_STRING");

    private static KeyVaultAccessControlClient accessControlClient;
    private static KeyVaultBackupClient backupClient;

    private static void createAndDeleteRoleAssignment() {
        List<KeyVaultRoleDefinition> roleDefinitions = new ArrayList<>();

        for (KeyVaultRoleDefinition roleDefinition : accessControlClient.listRoleDefinitions(KeyVaultRoleScope.GLOBAL)) {
            roleDefinitions.add(roleDefinition);
            System.out.printf("Retrieved role definition with name: %s %n", roleDefinition.getName());
        }

        for (KeyVaultRoleAssignment roleAssignment : accessControlClient.listRoleAssignments(KeyVaultRoleScope.GLOBAL)) {
            System.out.printf("Retrieved role assignment with name: %s %n", roleAssignment.getName());
        }

        KeyVaultRoleDefinition roleDefinition = roleDefinitions.get(0);
        KeyVaultRoleAssignment createdRoleAssignment =
            accessControlClient.createRoleAssignment(KeyVaultRoleScope.GLOBAL, roleDefinition.getId(),
                SERVICE_PRINCIPLE_ID);

        System.out.printf("Created role assignment with name: %s %n", createdRoleAssignment.getName());

        /* To get an existing role assignment, we'll need the 'name' property from an existing assignment. Let's use the
        createdAssignment from the previous example. */
        KeyVaultRoleAssignment retrievedRoleAssignment =
            accessControlClient.getRoleAssignment(KeyVaultRoleScope.GLOBAL, createdRoleAssignment.getName());

        System.out.printf("Retrieved role assignment with name: %s %n", retrievedRoleAssignment.getName());

        /* To remove a role assignment from a service principal, the role assignment must be deleted. Let's delete the
        createdAssignment from the previous example. */
        KeyVaultRoleAssignment deletedRoleAssignment =
            accessControlClient.deleteRoleAssignment(KeyVaultRoleScope.GLOBAL, createdRoleAssignment.getName());

        System.out.printf("Deleted role assignment with name: %s %n", deletedRoleAssignment.getName());
    }

    private static void backupAndRestore() {
        String sasToken = "<sas-token>";
        SyncPoller<KeyVaultBackupOperation, String> backupPoller = backupClient.beginBackup(BACKUP_BLOB_STORAGE_URL,
            sasToken);

        backupPoller.waitForCompletion();

        String backupFolderUrl = backupPoller.getFinalResult();

        SyncPoller<KeyVaultRestoreOperation, Void> restorePoller = backupClient.beginRestore(BACKUP_BLOB_STORAGE_URL,
            sasToken);

        restorePoller.waitForCompletion();
    }

    public static void main(String[] args) {
        accessControlClient = new KeyVaultAccessControlClientBuilder()
            .vaultUrl(KEY_VAULT_URL)
            .credential(new DefaultAzureCredentialBuilder().build())
            .buildClient();

        backupClient = new KeyVaultBackupClientBuilder()
            .vaultUrl(KEY_VAULT_URL)
            .credential(new DefaultAzureCredentialBuilder().build())
            .buildClient();

        createAndDeleteRoleAssignment();
        backupAndRestore();
    }
}
