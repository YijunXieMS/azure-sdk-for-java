package com.azure.smoketest.ai;

import com.azure.ai.textanalytics.TextAnalyticsClient;
import com.azure.ai.textanalytics.TextAnalyticsClientBuilder;
import com.azure.core.credential.AzureKeyCredential;

public class TextAnalytics {
    private static TextAnalyticsClient client;

    private static void extractKeyPhrases() {
        String document = "My cat might need to see a veterinarian.";
        System.out.println("Extracted phrases:");
        client.extractKeyPhrases(document).forEach(keyPhrase -> System.out.printf("%s.%n", keyPhrase));
    }

    public static void main(String[] args) {
        client = new TextAnalyticsClientBuilder()
            .credential(new AzureKeyCredential(System.getenv("AZURE_TEXT_ANALYTICS_KEY")))
            .endpoint(System.getenv("AZURE_TEXT_ANALYTICS_ENDPOINT"))
            .buildClient();
        extractKeyPhrases();
    }
}
