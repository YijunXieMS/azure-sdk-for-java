package com.azure.smoketest;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.util.Configuration;
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

import java.util.Arrays;
import java.util.Collections;

public class Search {
    private static SearchIndexClient searchIndexClient;
    private static SearchClient searchClient;

    private static final String ENDPOINT = System.getenv("AZURE_COGNITIVE_SEARCH_ENDPOINT");
    private static final String ADMIN_KEY = System.getenv("AZURE_COGNITIVE_SEARCH_API_KEY");
    private static final String INDEX_NAME = "good-food";

    private static void createIndex() {
        SearchIndex newIndex = new SearchIndex(INDEX_NAME,
            Arrays.asList(new SearchField("foodId", SearchFieldDataType.STRING)
                    .setKey(Boolean.TRUE),
                new SearchField("foodName", SearchFieldDataType.STRING)));
        searchIndexClient.createIndex(newIndex);
    }

    private static void uploadAndSearchDocument() {
        SearchDocument searchDocument = new SearchDocument();
        searchDocument.put("foodId", "1");
        searchDocument.put("foodName", "Orange Chicken");
        IndexDocumentsResult result = searchClient.uploadDocuments(Collections.singletonList(searchDocument));
        for (IndexingResult indexingResult : result.getResults()) {
            System.out.printf("Does document with key %s upload successfully? %b%n", indexingResult.getKey(),
                indexingResult.isSucceeded());
        }
        SearchPagedIterable searchResults = searchClient.search("Chicken");
        for (SearchResult searchResult : searchResults) {
            System.out.println(searchResult.getScore());
        }
    }

    private static void deleteIndex() {
        searchIndexClient.deleteIndex(INDEX_NAME);
    }
    public static void main(String[] args) {
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
        uploadAndSearchDocument();
        deleteIndex();
    }
}
