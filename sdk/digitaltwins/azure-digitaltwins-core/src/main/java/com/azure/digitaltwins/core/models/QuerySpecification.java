/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.azure.digitaltwins.core.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A query specification containing either a query statement or a continuation
 * token from a previous query result.
 */
public class QuerySpecification {
    /**
     * The query to execute. This value is ignored if a continuation token is
     * provided.
     */
    @JsonProperty(value = "query")
    private String query;

    /**
     * A token which is used to retrieve the next set of results from a
     * previous query.
     */
    @JsonProperty(value = "continuationToken")
    private String continuationToken;

    /**
     * Get the query to execute. This value is ignored if a continuation token is provided.
     *
     * @return the query value
     */
    public String query() {
        return this.query;
    }

    /**
     * Set the query to execute. This value is ignored if a continuation token is provided.
     *
     * @param query the query value to set
     * @return the QuerySpecification object itself.
     */
    public QuerySpecification withQuery(String query) {
        this.query = query;
        return this;
    }

    /**
     * Get a token which is used to retrieve the next set of results from a previous query.
     *
     * @return the continuationToken value
     */
    public String continuationToken() {
        return this.continuationToken;
    }

    /**
     * Set a token which is used to retrieve the next set of results from a previous query.
     *
     * @param continuationToken the continuationToken value to set
     * @return the QuerySpecification object itself.
     */
    public QuerySpecification withContinuationToken(String continuationToken) {
        this.continuationToken = continuationToken;
        return this;
    }

}
