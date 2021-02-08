package com.azure.smoketest.ai;

import com.azure.ai.anomalydetector.AnomalyDetectorClient;
import com.azure.ai.anomalydetector.AnomalyDetectorClientBuilder;
import com.azure.ai.anomalydetector.models.DetectRequest;
import com.azure.ai.anomalydetector.models.EntireDetectResponse;
import com.azure.ai.anomalydetector.models.TimeGranularity;
import com.azure.ai.anomalydetector.models.TimeSeriesPoint;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.http.ContentType;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.policy.AddHeadersPolicy;
import com.azure.core.http.policy.AzureKeyCredentialPolicy;
import com.azure.core.http.policy.HttpPipelinePolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AnomalyDetector {
    private static final String AZURE_ANOMALY_DETECTOR_ENDPOINT = System.getenv("AZURE_ANOMALY_DETECTOR_ENDPOINT");
    private static final String AZURE_ANOMALY_DETECTOR_API_KEY = System.getenv("AZURE_ANOMALY_DETECTOR_API_KEY");
    private static AnomalyDetectorClient anomalyDetectorClient;
    private static final Logger LOGGER = LoggerFactory.getLogger(AnomalyDetector.class);

    private static void timeSeries() throws IOException {
        LOGGER.info("Detecting time series...");
        // Read the time series from csv file and organize the time series into list of TimeSeriesPoint.
        // The sample csv file has no header, and it contains 2 columns, namely timestamp and value.
        // The following is a snippet of the sample csv file:
        //      2018-03-01T00:00:00Z,32858923
        //      2018-03-02T00:00:00Z,29615278
        //      2018-03-03T00:00:00Z,22839355
        //      2018-03-04T00:00:00Z,25948736
        Path path = Paths.get("./src/java/data/anomaly-detection-request-data.csv");
        List<String> requestData = Files.readAllLines(path);
        List<TimeSeriesPoint> series = requestData.stream()
            .map(line -> line.trim())
            .filter(line -> line.length() > 0)
            .map(line -> line.split(",", 2))
            .filter(splits -> splits.length == 2)
            .map(splits -> {
                TimeSeriesPoint timeSeriesPoint = new TimeSeriesPoint();
                timeSeriesPoint.setTimestamp(OffsetDateTime.parse(splits[0]));
                timeSeriesPoint.setValue(Float.parseFloat(splits[1]));
                return timeSeriesPoint;
            })
            .collect(Collectors.toList());

        System.out.println("Detecting anomalies as a batch...");
        DetectRequest request = new DetectRequest();
        request.setSeries(series);
        // Set the granularity to be DAILY since the minimal interval in time of the sample data is one day.
        request.setGranularity(TimeGranularity.DAILY);
        EntireDetectResponse response = anomalyDetectorClient.detectEntireSeries(request);
        if (response.getIsAnomaly().contains(true)) {
            LOGGER.info("Anomalies found in the following data positions:");
            for (int i = 0; i < request.getSeries().size(); ++i) {
                if (response.getIsAnomaly().get(i)) {
                    System.out.print(i + " ");
                }
            }
        } else {
            LOGGER.info("No anomalies were found in the series.");
        }
        LOGGER.info("DONE: detecting anomalies");
    }

    public static void main(final String[] args) throws IOException {
        LOGGER.info("---------------------");
        LOGGER.info("ANOMALY DETECTOR");
        LOGGER.info("---------------------");
        HttpHeaders headers = new HttpHeaders()
            .put("Accept", ContentType.APPLICATION_JSON);

        HttpPipelinePolicy authPolicy = new AzureKeyCredentialPolicy("Ocp-Apim-Subscription-Key",
            new AzureKeyCredential(AZURE_ANOMALY_DETECTOR_API_KEY));
        AddHeadersPolicy addHeadersPolicy = new AddHeadersPolicy(headers);
        HttpPipeline httpPipeline = new HttpPipelineBuilder().httpClient(HttpClient.createDefault())
            .policies(authPolicy, addHeadersPolicy).build();
        // Instantiate a client that will be used to call the service.
        anomalyDetectorClient = new AnomalyDetectorClientBuilder()
            .pipeline(httpPipeline)
            .endpoint(AZURE_ANOMALY_DETECTOR_ENDPOINT)
            .buildClient();

        timeSeries();
    }
}
