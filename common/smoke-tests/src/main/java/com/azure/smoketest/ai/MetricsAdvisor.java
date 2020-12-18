package com.azure.smoketest.ai;

import com.azure.ai.metricsadvisor.MetricsAdvisorClient;
import com.azure.ai.metricsadvisor.MetricsAdvisorClientBuilder;
import com.azure.ai.metricsadvisor.models.MetricsAdvisorKeyCredential;

public class MetricsAdvisor {
    private static String METRICS_ADVISOR_ENDPOINT = System.getenv("AZURE_METRICS_ADVISOR_ENDPOINT");
    private static String METRICS_ADVISOR_SUBSCRIPTION_KEY = System.getenv("AZURE_METRICS_ADVISOR_SUBSCRIPTION_KEY");
    private static String AZURE_METRICS_ADVISOR_API_KEY = System.getenv("AZURE_METRICS_ADVISOR_API_KEY");

    private static MetricsAdvisorClient advisorClient;

    public static void main(String[] args) {
        advisorClient = new MetricsAdvisorClientBuilder()
            .endpoint(METRICS_ADVISOR_ENDPOINT)
            .credential(new MetricsAdvisorKeyCredential(METRICS_ADVISOR_SUBSCRIPTION_KEY, AZURE_METRICS_ADVISOR_API_KEY))
            .buildClient();

        //TODO: Add some code to run after administration package is exported.
    }


}
