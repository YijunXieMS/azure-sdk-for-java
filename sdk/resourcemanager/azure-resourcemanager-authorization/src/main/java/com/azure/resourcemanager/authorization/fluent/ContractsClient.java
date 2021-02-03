// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.authorization.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.authorization.fluent.models.ContractsCheckMemberGroupsRequestBody;
import com.azure.resourcemanager.authorization.fluent.models.ContractsCheckMemberObjectsRequestBody;
import com.azure.resourcemanager.authorization.fluent.models.ContractsGetAvailableExtensionPropertiesRequestBody;
import com.azure.resourcemanager.authorization.fluent.models.ContractsGetByIdsRequestBody;
import com.azure.resourcemanager.authorization.fluent.models.ContractsGetMemberGroupsRequestBody;
import com.azure.resourcemanager.authorization.fluent.models.ContractsGetMemberObjectsRequestBody;
import com.azure.resourcemanager.authorization.fluent.models.ContractsValidatePropertiesRequestBody;
import com.azure.resourcemanager.authorization.fluent.models.MicrosoftGraphDirectoryObjectInner;
import com.azure.resourcemanager.authorization.fluent.models.MicrosoftGraphExtensionPropertyInner;
import java.util.List;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in ContractsClient. */
public interface ContractsClient {
    /**
     * Invoke action checkMemberGroups.
     *
     * @param contractId key: id of contract.
     * @param body Action parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of String.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<List<String>>> checkMemberGroupsWithResponseAsync(
        String contractId, ContractsCheckMemberGroupsRequestBody body);

    /**
     * Invoke action checkMemberGroups.
     *
     * @param contractId key: id of contract.
     * @param body Action parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of String.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<List<String>> checkMemberGroupsAsync(String contractId, ContractsCheckMemberGroupsRequestBody body);

    /**
     * Invoke action checkMemberGroups.
     *
     * @param contractId key: id of contract.
     * @param body Action parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of String.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    List<String> checkMemberGroups(String contractId, ContractsCheckMemberGroupsRequestBody body);

    /**
     * Invoke action checkMemberGroups.
     *
     * @param contractId key: id of contract.
     * @param body Action parameters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of String.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<List<String>> checkMemberGroupsWithResponse(
        String contractId, ContractsCheckMemberGroupsRequestBody body, Context context);

    /**
     * Invoke action checkMemberObjects.
     *
     * @param contractId key: id of contract.
     * @param body Action parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of String.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<List<String>>> checkMemberObjectsWithResponseAsync(
        String contractId, ContractsCheckMemberObjectsRequestBody body);

    /**
     * Invoke action checkMemberObjects.
     *
     * @param contractId key: id of contract.
     * @param body Action parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of String.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<List<String>> checkMemberObjectsAsync(String contractId, ContractsCheckMemberObjectsRequestBody body);

    /**
     * Invoke action checkMemberObjects.
     *
     * @param contractId key: id of contract.
     * @param body Action parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of String.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    List<String> checkMemberObjects(String contractId, ContractsCheckMemberObjectsRequestBody body);

    /**
     * Invoke action checkMemberObjects.
     *
     * @param contractId key: id of contract.
     * @param body Action parameters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of String.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<List<String>> checkMemberObjectsWithResponse(
        String contractId, ContractsCheckMemberObjectsRequestBody body, Context context);

    /**
     * Invoke action getMemberGroups.
     *
     * @param contractId key: id of contract.
     * @param body Action parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of String.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<List<String>>> getMemberGroupsWithResponseAsync(
        String contractId, ContractsGetMemberGroupsRequestBody body);

    /**
     * Invoke action getMemberGroups.
     *
     * @param contractId key: id of contract.
     * @param body Action parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of String.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<List<String>> getMemberGroupsAsync(String contractId, ContractsGetMemberGroupsRequestBody body);

    /**
     * Invoke action getMemberGroups.
     *
     * @param contractId key: id of contract.
     * @param body Action parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of String.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    List<String> getMemberGroups(String contractId, ContractsGetMemberGroupsRequestBody body);

    /**
     * Invoke action getMemberGroups.
     *
     * @param contractId key: id of contract.
     * @param body Action parameters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of String.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<List<String>> getMemberGroupsWithResponse(
        String contractId, ContractsGetMemberGroupsRequestBody body, Context context);

    /**
     * Invoke action getMemberObjects.
     *
     * @param contractId key: id of contract.
     * @param body Action parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of String.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<List<String>>> getMemberObjectsWithResponseAsync(
        String contractId, ContractsGetMemberObjectsRequestBody body);

    /**
     * Invoke action getMemberObjects.
     *
     * @param contractId key: id of contract.
     * @param body Action parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of String.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<List<String>> getMemberObjectsAsync(String contractId, ContractsGetMemberObjectsRequestBody body);

    /**
     * Invoke action getMemberObjects.
     *
     * @param contractId key: id of contract.
     * @param body Action parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of String.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    List<String> getMemberObjects(String contractId, ContractsGetMemberObjectsRequestBody body);

    /**
     * Invoke action getMemberObjects.
     *
     * @param contractId key: id of contract.
     * @param body Action parameters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of String.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<List<String>> getMemberObjectsWithResponse(
        String contractId, ContractsGetMemberObjectsRequestBody body, Context context);

    /**
     * Invoke action restore.
     *
     * @param contractId key: id of contract.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents an Azure Active Directory object.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<MicrosoftGraphDirectoryObjectInner>> restoreWithResponseAsync(String contractId);

    /**
     * Invoke action restore.
     *
     * @param contractId key: id of contract.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents an Azure Active Directory object.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<MicrosoftGraphDirectoryObjectInner> restoreAsync(String contractId);

    /**
     * Invoke action restore.
     *
     * @param contractId key: id of contract.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents an Azure Active Directory object.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    MicrosoftGraphDirectoryObjectInner restore(String contractId);

    /**
     * Invoke action restore.
     *
     * @param contractId key: id of contract.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents an Azure Active Directory object.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<MicrosoftGraphDirectoryObjectInner> restoreWithResponse(String contractId, Context context);

    /**
     * Invoke action getAvailableExtensionProperties.
     *
     * @param body Action parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of microsoft.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<List<MicrosoftGraphExtensionPropertyInner>>> getAvailableExtensionPropertiesWithResponseAsync(
        ContractsGetAvailableExtensionPropertiesRequestBody body);

    /**
     * Invoke action getAvailableExtensionProperties.
     *
     * @param body Action parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of microsoft.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<List<MicrosoftGraphExtensionPropertyInner>> getAvailableExtensionPropertiesAsync(
        ContractsGetAvailableExtensionPropertiesRequestBody body);

    /**
     * Invoke action getAvailableExtensionProperties.
     *
     * @param body Action parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of microsoft.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    List<MicrosoftGraphExtensionPropertyInner> getAvailableExtensionProperties(
        ContractsGetAvailableExtensionPropertiesRequestBody body);

    /**
     * Invoke action getAvailableExtensionProperties.
     *
     * @param body Action parameters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of microsoft.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<List<MicrosoftGraphExtensionPropertyInner>> getAvailableExtensionPropertiesWithResponse(
        ContractsGetAvailableExtensionPropertiesRequestBody body, Context context);

    /**
     * Invoke action getByIds.
     *
     * @param body Action parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of microsoft.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<List<MicrosoftGraphDirectoryObjectInner>>> getByIdsWithResponseAsync(
        ContractsGetByIdsRequestBody body);

    /**
     * Invoke action getByIds.
     *
     * @param body Action parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of microsoft.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<List<MicrosoftGraphDirectoryObjectInner>> getByIdsAsync(ContractsGetByIdsRequestBody body);

    /**
     * Invoke action getByIds.
     *
     * @param body Action parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of microsoft.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    List<MicrosoftGraphDirectoryObjectInner> getByIds(ContractsGetByIdsRequestBody body);

    /**
     * Invoke action getByIds.
     *
     * @param body Action parameters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of microsoft.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<List<MicrosoftGraphDirectoryObjectInner>> getByIdsWithResponse(
        ContractsGetByIdsRequestBody body, Context context);

    /**
     * Invoke action validateProperties.
     *
     * @param body Action parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<Void>> validatePropertiesWithResponseAsync(ContractsValidatePropertiesRequestBody body);

    /**
     * Invoke action validateProperties.
     *
     * @param body Action parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Void> validatePropertiesAsync(ContractsValidatePropertiesRequestBody body);

    /**
     * Invoke action validateProperties.
     *
     * @param body Action parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void validateProperties(ContractsValidatePropertiesRequestBody body);

    /**
     * Invoke action validateProperties.
     *
     * @param body Action parameters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> validatePropertiesWithResponse(ContractsValidatePropertiesRequestBody body, Context context);
}
