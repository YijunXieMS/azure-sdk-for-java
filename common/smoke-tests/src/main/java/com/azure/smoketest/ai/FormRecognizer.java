package com.azure.smoketest.ai;

import com.azure.ai.formrecognizer.FormRecognizerClient;
import com.azure.ai.formrecognizer.FormRecognizerClientBuilder;
import com.azure.ai.formrecognizer.models.FormPage;
import com.azure.ai.formrecognizer.models.FormRecognizerOperationResult;
import com.azure.ai.formrecognizer.models.FormTable;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.util.polling.SyncPoller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;

public class FormRecognizer {
    private static FormRecognizerClient client;

    private static void recognizeContent() throws IOException  {
        File sourceFile = new File("../data/Form_1.jpg");
        byte[] fileContent = Files.readAllBytes(sourceFile.toPath());
        InputStream targetStream = new ByteArrayInputStream(fileContent);

        SyncPoller<FormRecognizerOperationResult, List<FormPage>> recognizeContentPoller =
            client.beginRecognizeContent(targetStream, sourceFile.length());

        List<FormPage> contentPageResults = recognizeContentPoller.getFinalResult();

        for (int i = 0; i < contentPageResults.size(); i++) {
            final FormPage formPage = contentPageResults.get(i);
            System.out.printf("---- Recognized content info for page %d ----%n", i);
            // Table information
            System.out.printf("Has width: %.2f and height: %.2f, measured with unit: %s%n", formPage.getWidth(),
                formPage.getHeight(),
                formPage.getUnit());
            final List<FormTable> tables = formPage.getTables();
            for (int i1 = 0; i1 < tables.size(); i1++) {
                final FormTable formTable = tables.get(i1);
                System.out.printf("Table %d has %d rows and %d columns.%n", i1, formTable.getRowCount(),
                    formTable.getColumnCount());
                formTable.getCells().forEach(formTableCell -> {
                    System.out.printf("Cell has text '%s', within bounding box %s.%n", formTableCell.getText(),
                        formTableCell.getBoundingBox().toString());
                });
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        client = new FormRecognizerClientBuilder()
            .credential(new AzureKeyCredential(System.getenv("AZURE_FORM_RECOGNIZER_KEY")))
            .endpoint(String.format("https://%s.cognitiveservices.azure.com/",
                System.getenv("AZURE_FORM_RECOGNIZER_ENDPOINT"))
            )
            .buildClient();

        recognizeContent();
    }
}
