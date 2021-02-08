package com.azure.smoketest;

import com.azure.data.appconfiguration.ConfigurationClient;
import com.azure.data.appconfiguration.ConfigurationClientBuilder;
import com.azure.data.appconfiguration.models.ConfigurationSetting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppConfiguration {
    private static final String APP_CONFIG_CONNECTION_STRING = System.getenv("AZURE_APPCONFIG_CONNECTION_STRING");
    private static ConfigurationClient client;
    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfiguration.class);

    private static void setAndGetConfigSettings() {
        // Name of the key to add to the configuration service.
        final String key = "hello";
        final String value = "world";

        LOGGER.info("Setting configuration setting...");
        ConfigurationSetting setting = client.setConfigurationSetting(key, null, value);
        LOGGER.info(String.format("[SetConfigurationSetting] Key: %s, Value: %s", setting.getKey(), setting.getValue()));
        LOGGER.info("DONE: set");

        LOGGER.info("Getting configuration setting...");
        setting = client.getConfigurationSetting(key, null, null);
        LOGGER.info(String.format("[GetConfigurationSetting] Key: %s, Value: %s", setting.getKey(), setting.getValue()));
        LOGGER.info("DONE: get");

        LOGGER.info("Deleting configuration setting...");
        setting = client.deleteConfigurationSetting(key, null);
        LOGGER.info(String.format("[DeleteConfigurationSetting] Key: %s, Value: %s", setting.getKey(), setting.getValue()));
        LOGGER.info("DONE: delete");
    }

    public static void main(String[] args) {
        LOGGER.info("---------------------");
        LOGGER.info("APP CONFIG");
        LOGGER.info("---------------------");
        client = new ConfigurationClientBuilder()
            .connectionString(APP_CONFIG_CONNECTION_STRING)
            .buildClient();
        setAndGetConfigSettings();
    }
}
