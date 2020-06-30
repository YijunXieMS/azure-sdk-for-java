/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.azure.digitaltwins.core.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Additional parameters for list operation.
 */
public class EventRoutesListOptions {
    /**
     * The maximum number of items to retrieve per request. The server may
     * choose to return less than the requested max.
     */
    @JsonProperty(value = "")
    private Integer maxItemCount;

    /**
     * Get the maximum number of items to retrieve per request. The server may choose to return less than the requested max.
     *
     * @return the maxItemCount value
     */
    public Integer maxItemCount() {
        return this.maxItemCount;
    }

    /**
     * Set the maximum number of items to retrieve per request. The server may choose to return less than the requested max.
     *
     * @param maxItemCount the maxItemCount value to set
     * @return the EventRoutesListOptions object itself.
     */
    public EventRoutesListOptions withMaxItemCount(Integer maxItemCount) {
        this.maxItemCount = maxItemCount;
        return this;
    }

}
