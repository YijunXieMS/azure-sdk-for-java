/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.compute.models;


/**
 * The API entity reference.
 */
public class ApiEntityReference {
    /**
     * Gets or sets ARM resource id in the form of
     * /subscriptions/{SubcriptionId}/resourceGroups/{ResourceGroupName}/...
     */
    private String id;

    /**
     * Get the id value.
     *
     * @return the id value
     */
    public String getId() {
        return this.id;
    }

    /**
     * Set the id value.
     *
     * @param id the id value to set
     */
    public void setId(String id) {
        this.id = id;
    }

}
