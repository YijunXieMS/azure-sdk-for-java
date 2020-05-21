// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.compute.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The VirtualMachineExtensionsListResult model. */
@Fluent
public final class VirtualMachineExtensionsListResultInner {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(VirtualMachineExtensionsListResultInner.class);

    /*
     * The list of extensions
     */
    @JsonProperty(value = "value")
    private List<VirtualMachineExtensionInner> value;

    /**
     * Get the value property: The list of extensions.
     *
     * @return the value value.
     */
    public List<VirtualMachineExtensionInner> value() {
        return this.value;
    }

    /**
     * Set the value property: The list of extensions.
     *
     * @param value the value value to set.
     * @return the VirtualMachineExtensionsListResultInner object itself.
     */
    public VirtualMachineExtensionsListResultInner withValue(List<VirtualMachineExtensionInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }
}