package com.azure.smoketest.ai;

import com.azure.ai.textanalytics.TextAnalyticsClient;
import com.azure.ai.textanalytics.TextAnalyticsClientBuilder;
import com.azure.core.credential.AzureKeyCredential;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextAnalytics {
    private static final String AZURE_TEXT_ANALYTICS_KEY = System.getenv("AZURE_TEXT_ANALYTICS_KEY");
    private static final String AZURE_TEXT_ANALYTICS_ENDPOINT = System.getenv("AZURE_TEXT_ANALYTICS_ENDPOINT");

    private static TextAnalyticsClient client;
    private static final Logger LOGGER = LoggerFactory.getLogger(TextAnalytics.class);

    private static void extractKeyPhrases() {
        LOGGER.info("Extracting key phrases...");
        String document = "My cat might need to see a veterinarian.";
        System.out.println("Extracted phrases:");
        client.extractKeyPhrases(document).forEach(keyPhrase -> System.out.printf("%s.%n", keyPhrase));
        LOGGER.info("DONE: extracting key phrases");
    }

    public static void main(String[] args) {
        LOGGER.info("---------------------");
        LOGGER.info("TEXT ANALYTICS");
        LOGGER.info("---------------------");
        client = new TextAnalyticsClientBuilder()
            .credential(new AzureKeyCredential(AZURE_TEXT_ANALYTICS_KEY))
            .endpoint(AZURE_TEXT_ANALYTICS_ENDPOINT)
            .buildClient();
        extractKeyPhrases();
    }
}
