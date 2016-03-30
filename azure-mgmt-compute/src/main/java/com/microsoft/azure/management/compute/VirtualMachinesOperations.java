/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.compute;

import com.microsoft.azure.CloudException;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.management.compute.models.InstanceViewTypes;
import com.microsoft.azure.management.compute.models.PageImpl;
import com.microsoft.azure.management.compute.models.VirtualMachine;
import com.microsoft.azure.management.compute.models.VirtualMachineCaptureParameters;
import com.microsoft.azure.management.compute.models.VirtualMachineCaptureResult;
import com.microsoft.azure.management.compute.models.VirtualMachineSize;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;
import java.util.List;

/**
 * An instance of this class provides access to all the operations defined
 * in VirtualMachinesOperations.
 */
public interface VirtualMachinesOperations {
    /**
     * Captures the VM by copying virtual hard disks of the VM and outputs a template that can be used to create similar VMs.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param parameters Parameters supplied to the Capture Virtual Machine operation.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the VirtualMachineCaptureResult object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<VirtualMachineCaptureResult> capture(String resourceGroupName, String vmName, VirtualMachineCaptureParameters parameters) throws CloudException, IOException, IllegalArgumentException, InterruptedException;

    /**
     * Captures the VM by copying virtual hard disks of the VM and outputs a template that can be used to create similar VMs.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param parameters Parameters supplied to the Capture Virtual Machine operation.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall captureAsync(String resourceGroupName, String vmName, VirtualMachineCaptureParameters parameters, final ServiceCallback<VirtualMachineCaptureResult> serviceCallback) throws IllegalArgumentException;

    /**
     * Captures the VM by copying virtual hard disks of the VM and outputs a template that can be used to create similar VMs.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param parameters Parameters supplied to the Capture Virtual Machine operation.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the VirtualMachineCaptureResult object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<VirtualMachineCaptureResult> beginCapture(String resourceGroupName, String vmName, VirtualMachineCaptureParameters parameters) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Captures the VM by copying virtual hard disks of the VM and outputs a template that can be used to create similar VMs.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param parameters Parameters supplied to the Capture Virtual Machine operation.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall beginCaptureAsync(String resourceGroupName, String vmName, VirtualMachineCaptureParameters parameters, final ServiceCallback<VirtualMachineCaptureResult> serviceCallback) throws IllegalArgumentException;

    /**
     * The operation to create or update a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param parameters Parameters supplied to the Create Virtual Machine operation.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the VirtualMachine object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<VirtualMachine> createOrUpdate(String resourceGroupName, String vmName, VirtualMachine parameters) throws CloudException, IOException, IllegalArgumentException, InterruptedException;

    /**
     * The operation to create or update a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param parameters Parameters supplied to the Create Virtual Machine operation.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall createOrUpdateAsync(String resourceGroupName, String vmName, VirtualMachine parameters, final ServiceCallback<VirtualMachine> serviceCallback) throws IllegalArgumentException;

    /**
     * The operation to create or update a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param parameters Parameters supplied to the Create Virtual Machine operation.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the VirtualMachine object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<VirtualMachine> beginCreateOrUpdate(String resourceGroupName, String vmName, VirtualMachine parameters) throws CloudException, IOException, IllegalArgumentException;

    /**
     * The operation to create or update a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param parameters Parameters supplied to the Create Virtual Machine operation.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall beginCreateOrUpdateAsync(String resourceGroupName, String vmName, VirtualMachine parameters, final ServiceCallback<VirtualMachine> serviceCallback) throws IllegalArgumentException;

    /**
     * The operation to delete a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> delete(String resourceGroupName, String vmName) throws CloudException, IOException, IllegalArgumentException, InterruptedException;

    /**
     * The operation to delete a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall deleteAsync(String resourceGroupName, String vmName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * The operation to delete a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> beginDelete(String resourceGroupName, String vmName) throws CloudException, IOException, IllegalArgumentException;

    /**
     * The operation to delete a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall beginDeleteAsync(String resourceGroupName, String vmName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * The operation to get a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the VirtualMachine object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<VirtualMachine> get(String resourceGroupName, String vmName) throws CloudException, IOException, IllegalArgumentException;

    /**
     * The operation to get a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getAsync(String resourceGroupName, String vmName, final ServiceCallback<VirtualMachine> serviceCallback) throws IllegalArgumentException;
    /**
     * The operation to get a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param expand The expand expression to apply on the operation. Possible values include: 'instanceView'
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the VirtualMachine object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<VirtualMachine> get(String resourceGroupName, String vmName, InstanceViewTypes expand) throws CloudException, IOException, IllegalArgumentException;

    /**
     * The operation to get a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param expand The expand expression to apply on the operation. Possible values include: 'instanceView'
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getAsync(String resourceGroupName, String vmName, InstanceViewTypes expand, final ServiceCallback<VirtualMachine> serviceCallback) throws IllegalArgumentException;

    /**
     * Shuts down the Virtual Machine and releases the compute resources. You are not billed for the compute resources that this Virtual Machine uses.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> deallocate(String resourceGroupName, String vmName) throws CloudException, IOException, IllegalArgumentException, InterruptedException;

    /**
     * Shuts down the Virtual Machine and releases the compute resources. You are not billed for the compute resources that this Virtual Machine uses.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall deallocateAsync(String resourceGroupName, String vmName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Shuts down the Virtual Machine and releases the compute resources. You are not billed for the compute resources that this Virtual Machine uses.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> beginDeallocate(String resourceGroupName, String vmName) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Shuts down the Virtual Machine and releases the compute resources. You are not billed for the compute resources that this Virtual Machine uses.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall beginDeallocateAsync(String resourceGroupName, String vmName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Sets the state of the VM as Generalized.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> generalize(String resourceGroupName, String vmName) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Sets the state of the VM as Generalized.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall generalizeAsync(String resourceGroupName, String vmName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * The operation to list virtual machines under a resource group.
     *
     * @param resourceGroupName The name of the resource group.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;VirtualMachine&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<List<VirtualMachine>> list(String resourceGroupName) throws CloudException, IOException, IllegalArgumentException;

    /**
     * The operation to list virtual machines under a resource group.
     *
     * @param resourceGroupName The name of the resource group.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listAsync(String resourceGroupName, final ServiceCallback<List<VirtualMachine>> serviceCallback) throws IllegalArgumentException;

    /**
     * Gets the list of Virtual Machines in the subscription. Use nextLink property in the response to get the next page of Virtual Machines. Do this till nextLink is not null to fetch all the Virtual Machines.
     *
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;VirtualMachine&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<PagedList<VirtualMachine>> listAll() throws CloudException, IOException, IllegalArgumentException;

    /**
     * Gets the list of Virtual Machines in the subscription. Use nextLink property in the response to get the next page of Virtual Machines. Do this till nextLink is not null to fetch all the Virtual Machines.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listAllAsync(final ListOperationCallback<VirtualMachine> serviceCallback) throws IllegalArgumentException;

    /**
     * Lists all available virtual machine sizes it can be resized to for a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;VirtualMachineSize&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<List<VirtualMachineSize>> listAvailableSizes(String resourceGroupName, String vmName) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Lists all available virtual machine sizes it can be resized to for a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listAvailableSizesAsync(String resourceGroupName, String vmName, final ServiceCallback<List<VirtualMachineSize>> serviceCallback) throws IllegalArgumentException;

    /**
     * The operation to power off (stop) a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> powerOff(String resourceGroupName, String vmName) throws CloudException, IOException, IllegalArgumentException, InterruptedException;

    /**
     * The operation to power off (stop) a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall powerOffAsync(String resourceGroupName, String vmName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * The operation to power off (stop) a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> beginPowerOff(String resourceGroupName, String vmName) throws CloudException, IOException, IllegalArgumentException;

    /**
     * The operation to power off (stop) a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall beginPowerOffAsync(String resourceGroupName, String vmName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * The operation to restart a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> restart(String resourceGroupName, String vmName) throws CloudException, IOException, IllegalArgumentException, InterruptedException;

    /**
     * The operation to restart a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall restartAsync(String resourceGroupName, String vmName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * The operation to restart a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> beginRestart(String resourceGroupName, String vmName) throws CloudException, IOException, IllegalArgumentException;

    /**
     * The operation to restart a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall beginRestartAsync(String resourceGroupName, String vmName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * The operation to start a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> start(String resourceGroupName, String vmName) throws CloudException, IOException, IllegalArgumentException, InterruptedException;

    /**
     * The operation to start a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall startAsync(String resourceGroupName, String vmName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * The operation to start a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> beginStart(String resourceGroupName, String vmName) throws CloudException, IOException, IllegalArgumentException;

    /**
     * The operation to start a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall beginStartAsync(String resourceGroupName, String vmName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * The operation to redeploy a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> redeploy(String resourceGroupName, String vmName) throws CloudException, IOException, IllegalArgumentException, InterruptedException;

    /**
     * The operation to redeploy a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall redeployAsync(String resourceGroupName, String vmName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * The operation to redeploy a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> beginRedeploy(String resourceGroupName, String vmName) throws CloudException, IOException, IllegalArgumentException;

    /**
     * The operation to redeploy a virtual machine.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmName The name of the virtual machine.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall beginRedeployAsync(String resourceGroupName, String vmName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Gets the list of Virtual Machines in the subscription. Use nextLink property in the response to get the next page of Virtual Machines. Do this till nextLink is not null to fetch all the Virtual Machines.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;VirtualMachine&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<PageImpl<VirtualMachine>> listAllNext(final String nextPageLink) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Gets the list of Virtual Machines in the subscription. Use nextLink property in the response to get the next page of Virtual Machines. Do this till nextLink is not null to fetch all the Virtual Machines.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listAllNextAsync(final String nextPageLink, final ServiceCall serviceCall, final ListOperationCallback<VirtualMachine> serviceCallback) throws IllegalArgumentException;

}
