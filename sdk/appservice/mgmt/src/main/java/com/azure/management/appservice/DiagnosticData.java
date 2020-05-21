// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.appservice;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The DiagnosticData model. */
@Fluent
public final class DiagnosticData {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(DiagnosticData.class);

    /*
     * Data in table form
     */
    @JsonProperty(value = "table")
    private DataTableResponseObject table;

    /*
     * Properties that describe how the table should be rendered
     */
    @JsonProperty(value = "renderingProperties")
    private Rendering renderingProperties;

    /**
     * Get the table property: Data in table form.
     *
     * @return the table value.
     */
    public DataTableResponseObject table() {
        return this.table;
    }

    /**
     * Set the table property: Data in table form.
     *
     * @param table the table value to set.
     * @return the DiagnosticData object itself.
     */
    public DiagnosticData withTable(DataTableResponseObject table) {
        this.table = table;
        return this;
    }

    /**
     * Get the renderingProperties property: Properties that describe how the table should be rendered.
     *
     * @return the renderingProperties value.
     */
    public Rendering renderingProperties() {
        return this.renderingProperties;
    }

    /**
     * Set the renderingProperties property: Properties that describe how the table should be rendered.
     *
     * @param renderingProperties the renderingProperties value to set.
     * @return the DiagnosticData object itself.
     */
    public DiagnosticData withRenderingProperties(Rendering renderingProperties) {
        this.renderingProperties = renderingProperties;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (table() != null) {
            table().validate();
        }
        if (renderingProperties() != null) {
            renderingProperties().validate();
        }
    }
}