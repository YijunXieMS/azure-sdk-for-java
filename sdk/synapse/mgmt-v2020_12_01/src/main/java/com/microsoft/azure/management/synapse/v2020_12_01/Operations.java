/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.synapse.v2020_12_01;

import rx.Observable;
import com.microsoft.azure.management.synapse.v2020_12_01.implementation.OperationsInner;
import com.microsoft.azure.arm.model.HasInner;
import rx.Completable;

/**
 * Type representing Operations.
 */
public interface Operations extends HasInner<OperationsInner> {
    /**
     * Get operation status.
     * Get the status of an operation.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace
     * @param operationId Operation ID
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<OperationResource> getAzureAsyncHeaderResultAsync(String resourceGroupName, String workspaceName, String operationId);

    /**
     * Get operation result.
     * Get the result of an operation.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace
     * @param operationId Operation ID
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable getLocationHeaderResultAsync(String resourceGroupName, String workspaceName, String operationId);

    /**
     * Check name availability.
     * Check whether a workspace name is available.
     *
     * @param request The check request
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<CheckNameAvailabilityResponse> checkNameAvailabilityAsync(CheckNameAvailabilityRequest request);

    /**
     * All operations.
     * Get all available operations.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<AvailableRpOperation> listAsync();

}
