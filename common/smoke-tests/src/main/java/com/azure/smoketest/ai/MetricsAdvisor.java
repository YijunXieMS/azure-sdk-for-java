package com.azure.smoketest.ai;

import com.azure.ai.metricsadvisor.MetricsAdvisorClient;
import com.azure.ai.metricsadvisor.MetricsAdvisorClientBuilder;
import com.azure.ai.metricsadvisor.models.MetricsAdvisorKeyCredential;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetricsAdvisor {
    private static String METRICS_ADVISOR_ENDPOINT = System.getenv("AZURE_METRICS_ADVISOR_ENDPOINT");
    private static String METRICS_ADVISOR_SUBSCRIPTION_KEY = System.getenv("AZURE_METRICS_ADVISOR_SUBSCRIPTION_KEY");
    private static String AZURE_METRICS_ADVISOR_API_KEY = System.getenv("AZURE_METRICS_ADVISOR_API_KEY");

    private static MetricsAdvisorClient advisorClient;
    private static final Logger LOGGER = LoggerFactory.getLogger(MetricsAdvisor.class);

    public static void main(String[] args) {
        LOGGER.info("---------------------");
        LOGGER.info("METRICS ADVISOR");
        LOGGER.info("---------------------");
        advisorClient = new MetricsAdvisorClientBuilder()
            .endpoint(METRICS_ADVISOR_ENDPOINT)
            .credential(new MetricsAdvisorKeyCredential(METRICS_ADVISOR_SUBSCRIPTION_KEY,
                AZURE_METRICS_ADVISOR_API_KEY))
            .buildClient();

        //TODO: Add some code to run after administration package is exported.
    }
}
