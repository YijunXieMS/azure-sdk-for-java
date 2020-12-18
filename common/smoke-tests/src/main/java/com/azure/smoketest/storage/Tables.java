package com.azure.smoketest.storage;

import com.azure.data.tables.TableClient;
import com.azure.data.tables.TableServiceClient;
import com.azure.data.tables.TableServiceClientBuilder;
import com.azure.data.tables.models.ListEntitiesOptions;
import com.azure.data.tables.models.TableEntity;

import java.util.Map;

public class Tables {
    private static final String partitionKey = "<partition-key>";
    private static final String rowKey = "<row-key>";
    private static final String tableName = "Product";
    private static TableServiceClient tableServiceClient;
    private static TableClient tableClient;

    private static void entityCrud() {
        // Create
        TableEntity entity = new TableEntity(partitionKey, rowKey)
            .addProperty("Product", "Marker Set")
            .addProperty("Price", 5.00)
            .addProperty("Quantity", 21);
        tableClient.createEntity(entity);

        // Read
        TableEntity retrievedEntity = tableClient.getEntity(partitionKey, rowKey);
        System.out.printf("Retrieved Entity: Product(Product: %s, Price: %s, Quantity: %s)",
            retrievedEntity.getProperty("Product"),
            retrievedEntity.getProperty("Price"),
            retrievedEntity.getProperty("Quantity")
        );

        // List
        ListEntitiesOptions options = new ListEntitiesOptions()
            .setFilter(String.format("PartitionKey eq '%s'", partitionKey))
            .setSelect("Product, Price");

        for (TableEntity listedEntity : tableClient.listEntities(options)) {
            Map<String, Object> properties = listedEntity.getProperties();
            System.out.println(String.format("Listed Entity: Product(Product: %s, Price: %.2f)",
                properties.get("Product"), properties.get("Price")));
        }

        // Update
        retrievedEntity.addProperty("Price", 6.00);
        tableClient.updateEntity(retrievedEntity);
        TableEntity updatedEntity = tableClient.getEntity(partitionKey, rowKey);
        System.out.printf("Updated Entity: Product(Product: %s, Price: %s, Quantity: %s)",
            retrievedEntity.getProperty("Product"),
            retrievedEntity.getProperty("Price"),
            retrievedEntity.getProperty("Quantity"));


        // Delete
        tableClient.deleteEntity(partitionKey, rowKey);
    }

    private static void createTable() {
        tableServiceClient.createTable(tableName);
    }

    private static void deleteTable() {
        tableServiceClient.deleteTable(tableName);
    }

    public static void main(String[] args) {
        tableServiceClient = new TableServiceClientBuilder()
            .connectionString(System.getenv("AZURE_TABLE_SERVICE_CONNECTION_STRING"))
            .buildClient();
        tableClient = tableServiceClient.getTableClient(tableName);

        createTable();
        entityCrud();
        deleteTable();
    }
}
