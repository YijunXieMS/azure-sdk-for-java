// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.monitor;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The Baseline model. */
@Fluent
public final class Baseline {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(Baseline.class);

    /*
     * the sensitivity of the baseline.
     */
    @JsonProperty(value = "sensitivity", required = true)
    private Sensitivity sensitivity;

    /*
     * The low thresholds of the baseline.
     */
    @JsonProperty(value = "lowThresholds", required = true)
    private List<Double> lowThresholds;

    /*
     * The high thresholds of the baseline.
     */
    @JsonProperty(value = "highThresholds", required = true)
    private List<Double> highThresholds;

    /**
     * Get the sensitivity property: the sensitivity of the baseline.
     *
     * @return the sensitivity value.
     */
    public Sensitivity sensitivity() {
        return this.sensitivity;
    }

    /**
     * Set the sensitivity property: the sensitivity of the baseline.
     *
     * @param sensitivity the sensitivity value to set.
     * @return the Baseline object itself.
     */
    public Baseline withSensitivity(Sensitivity sensitivity) {
        this.sensitivity = sensitivity;
        return this;
    }

    /**
     * Get the lowThresholds property: The low thresholds of the baseline.
     *
     * @return the lowThresholds value.
     */
    public List<Double> lowThresholds() {
        return this.lowThresholds;
    }

    /**
     * Set the lowThresholds property: The low thresholds of the baseline.
     *
     * @param lowThresholds the lowThresholds value to set.
     * @return the Baseline object itself.
     */
    public Baseline withLowThresholds(List<Double> lowThresholds) {
        this.lowThresholds = lowThresholds;
        return this;
    }

    /**
     * Get the highThresholds property: The high thresholds of the baseline.
     *
     * @return the highThresholds value.
     */
    public List<Double> highThresholds() {
        return this.highThresholds;
    }

    /**
     * Set the highThresholds property: The high thresholds of the baseline.
     *
     * @param highThresholds the highThresholds value to set.
     * @return the Baseline object itself.
     */
    public Baseline withHighThresholds(List<Double> highThresholds) {
        this.highThresholds = highThresholds;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (sensitivity() == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException("Missing required property sensitivity in model Baseline"));
        }
        if (lowThresholds() == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException("Missing required property lowThresholds in model Baseline"));
        }
        if (highThresholds() == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException("Missing required property highThresholds in model Baseline"));
        }
    }
}