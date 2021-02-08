package com.azure.smoketest;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.search.documents.SearchClient;
import com.azure.search.documents.SearchClientBuilder;
import com.azure.search.documents.SearchDocument;
import com.azure.search.documents.indexes.SearchIndexClient;
import com.azure.search.documents.indexes.SearchIndexClientBuilder;
import com.azure.search.documents.indexes.models.SearchField;
import com.azure.search.documents.indexes.models.SearchFieldDataType;
import com.azure.search.documents.indexes.models.SearchIndex;
import com.azure.search.documents.models.IndexDocumentsResult;
import com.azure.search.documents.models.IndexingResult;
import com.azure.search.documents.models.SearchResult;
import com.azure.search.documents.util.SearchPagedIterable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Search {
    private static SearchIndexClient searchIndexClient;
    private static SearchClient searchClient;

    private static final String ENDPOINT = System.getenv("AZURE_COGNITIVE_SEARCH_ENDPOINT");
    private static final String ADMIN_KEY = System.getenv("AZURE_COGNITIVE_SEARCH_API_KEY");
    private static final String INDEX_NAME = "good-food";
    private static final Logger LOGGER = LoggerFactory.getLogger(Search.class);

    private static void createIndex() {
        SearchIndex newIndex = new SearchIndex(INDEX_NAME,
            Arrays.asList(new SearchField("foodId", SearchFieldDataType.STRING)
                    .setKey(Boolean.TRUE),
                new SearchField("foodName", SearchFieldDataType.STRING)));
        searchIndexClient.createIndex(newIndex);
    }

    private static void uploadDocument() {
        SearchDocument searchDocument = new SearchDocument();
        searchDocument.put("foodId", "1");
        searchDocument.put("foodName", "Orange Chicken");
        IndexDocumentsResult result = searchClient.uploadDocuments(Collections.singletonList(searchDocument));
        for (IndexingResult indexingResult : result.getResults()) {
            LOGGER.info("Uploaded document with key {} upload successfully?", indexingResult.getKey());
        }
    }

    private static void searchDocument() {
        SearchPagedIterable searchResults = searchClient.search("Chicken");
        for (SearchResult searchResult : searchResults) {
            System.out.println(searchResult.getScore());
            SearchDocument searchDocument = searchResult.getDocument(SearchDocument.class);
            String foodId = (String) searchDocument.get("foodId");
            String foodName = (String) searchDocument.get("foodName");
            LOGGER.info("Searched out document foodId: '{}', foodName: '{}'", foodId, foodName);
            searchClient.deleteDocuments(List.of(searchDocument));
            LOGGER.info("Deleted the searched out document");
        }
    }

    private static void deleteIndex() {
        LOGGER.info("Deleting index...");
        searchIndexClient.deleteIndex(INDEX_NAME);
        LOGGER.info("DONE: delete index");
    }


    public static void main(String[] args) {
        LOGGER.info("---------------------");
        LOGGER.info("AZURE SEARCH");
        LOGGER.info("---------------------");

        AzureKeyCredential searchApiKeyCredential = new AzureKeyCredential(ADMIN_KEY);

        searchIndexClient = new SearchIndexClientBuilder()
            .endpoint(ENDPOINT)
            .credential(searchApiKeyCredential)
            .buildClient();

        searchClient = new SearchClientBuilder()
            .endpoint(ENDPOINT)
            .credential(new AzureKeyCredential(ADMIN_KEY))
            .indexName(INDEX_NAME)
            .buildClient();
        createIndex();
        uploadDocument();
        searchDocument();
        deleteIndex();
    }
}
