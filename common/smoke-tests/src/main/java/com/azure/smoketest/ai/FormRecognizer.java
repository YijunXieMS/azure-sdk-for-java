package com.azure.smoketest.ai;

import com.azure.ai.formrecognizer.FormRecognizerClient;
import com.azure.ai.formrecognizer.FormRecognizerClientBuilder;
import com.azure.ai.formrecognizer.models.FormPage;
import com.azure.ai.formrecognizer.models.FormRecognizerOperationResult;
import com.azure.ai.formrecognizer.models.FormTable;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.util.polling.SyncPoller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;

public class FormRecognizer {
    private static final String AZURE_FORM_RECOGNIZER_KEY = System.getenv("AZURE_FORM_RECOGNIZER_KEY");
    private static final String AZURE_FORM_RECOGNIZER_ENDPOINT = System.getenv("AZURE_FORM_RECOGNIZER_ENDPOINT");
    private static FormRecognizerClient client;
    private static final Logger LOGGER = LoggerFactory.getLogger(FormRecognizer.class);

    private static void recognizeContent() throws IOException  {
        LOGGER.info("Recognizing content...");
        File sourceFile = new File("./src/java/data/Form_1.jpg");
        byte[] fileContent = Files.readAllBytes(sourceFile.toPath());
        InputStream targetStream = new ByteArrayInputStream(fileContent);

        SyncPoller<FormRecognizerOperationResult, List<FormPage>> recognizeContentPoller =
            client.beginRecognizeContent(targetStream, sourceFile.length());

        List<FormPage> contentPageResults = recognizeContentPoller.getFinalResult();

        for (int i = 0; i < contentPageResults.size(); i++) {
            final FormPage formPage = contentPageResults.get(i);
            LOGGER.info("---- Recognized content info for page {} ----", i);
            // Table information
            LOGGER.info("Has width: {} and height: {}, measured with unit: {}", formPage.getWidth(),
                formPage.getHeight(), formPage.getUnit());
            final List<FormTable> tables = formPage.getTables();
            for (int i1 = 0; i1 < tables.size(); i1++) {
                final FormTable formTable = tables.get(i1);
                LOGGER.info("Table {} has {} rows and {} columns.", i1, formTable.getRowCount(),
                    formTable.getColumnCount());
                formTable.getCells().forEach(formTableCell -> {
                    LOGGER.info("Cell has text '{}', within bounding box {}.", formTableCell.getText(),
                        formTableCell.getBoundingBox().toString());
                });
            }
        }
        LOGGER.info("DONE: recognizing content");
    }

    public static void main(String[] args) throws IOException {
        LOGGER.info("---------------------");
        LOGGER.info("FORM RECOGNIZER");
        LOGGER.info("---------------------");
        client = new FormRecognizerClientBuilder()
            .credential(new AzureKeyCredential(AZURE_FORM_RECOGNIZER_KEY))
            .endpoint(String.format("https://%s.cognitiveservices.azure.com/", AZURE_FORM_RECOGNIZER_ENDPOINT))
            .buildClient();

        recognizeContent();
    }
}
