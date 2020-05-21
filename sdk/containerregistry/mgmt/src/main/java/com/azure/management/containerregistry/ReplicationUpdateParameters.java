// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.containerregistry;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/** The ReplicationUpdateParameters model. */
@Fluent
public final class ReplicationUpdateParameters {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(ReplicationUpdateParameters.class);

    /*
     * The tags for the replication.
     */
    @JsonProperty(value = "tags")
    private Map<String, String> tags;

    /**
     * Get the tags property: The tags for the replication.
     *
     * @return the tags value.
     */
    public Map<String, String> tags() {
        return this.tags;
    }

    /**
     * Set the tags property: The tags for the replication.
     *
     * @param tags the tags value to set.
     * @return the ReplicationUpdateParameters object itself.
     */
    public ReplicationUpdateParameters withTags(Map<String, String> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}