/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.compute;

import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceResponseBuilder;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.management.compute.models.PageImpl;
import com.microsoft.azure.management.compute.models.VirtualMachineScaleSet;
import com.microsoft.azure.management.compute.models.VirtualMachineScaleSetInstanceView;
import com.microsoft.azure.management.compute.models.VirtualMachineScaleSetSku;
import com.microsoft.azure.management.compute.models.VirtualMachineScaleSetVMInstanceIDs;
import com.microsoft.azure.management.compute.models.VirtualMachineScaleSetVMInstanceRequiredIDs;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.serializer.CollectionFormat;
import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.ServiceResponseCallback;
import com.microsoft.rest.Validator;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.HTTP;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.Url;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * An instance of this class provides access to all the operations defined
 * in VirtualMachineScaleSetsOperations.
 */
public final class VirtualMachineScaleSetsOperationsImpl implements VirtualMachineScaleSetsOperations {
    /** The Retrofit service to perform REST calls. */
    private VirtualMachineScaleSetsService service;
    /** The service client containing this operation class. */
    private ComputeManagementClient client;

    /**
     * Initializes an instance of VirtualMachineScaleSetsOperations.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public VirtualMachineScaleSetsOperationsImpl(Retrofit retrofit, ComputeManagementClient client) {
        this.service = retrofit.create(VirtualMachineScaleSetsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for VirtualMachineScaleSetsOperations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface VirtualMachineScaleSetsService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @PUT("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/virtualMachineScaleSets/{name}")
        Call<ResponseBody> createOrUpdate(@Path("resourceGroupName") String resourceGroupName, @Path("name") String name, @Path("subscriptionId") String subscriptionId, @Body VirtualMachineScaleSet parameters, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @Headers("Content-Type: application/json; charset=utf-8")
        @PUT("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/virtualMachineScaleSets/{name}")
        Call<ResponseBody> beginCreateOrUpdate(@Path("resourceGroupName") String resourceGroupName, @Path("name") String name, @Path("subscriptionId") String subscriptionId, @Body VirtualMachineScaleSet parameters, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/virtualMachineScaleSets/{vmScaleSetName}/deallocate")
        Call<ResponseBody> deallocate(@Path("resourceGroupName") String resourceGroupName, @Path("vmScaleSetName") String vmScaleSetName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Body VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/virtualMachineScaleSets/{vmScaleSetName}/deallocate")
        Call<ResponseBody> beginDeallocate(@Path("resourceGroupName") String resourceGroupName, @Path("vmScaleSetName") String vmScaleSetName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Body VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs);

        @Headers("Content-Type: application/json; charset=utf-8")
        @HTTP(path = "subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/virtualMachineScaleSets/{vmScaleSetName}", method = "DELETE", hasBody = true)
        Call<ResponseBody> delete(@Path("resourceGroupName") String resourceGroupName, @Path("vmScaleSetName") String vmScaleSetName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @Headers("Content-Type: application/json; charset=utf-8")
        @HTTP(path = "subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/virtualMachineScaleSets/{vmScaleSetName}", method = "DELETE", hasBody = true)
        Call<ResponseBody> beginDelete(@Path("resourceGroupName") String resourceGroupName, @Path("vmScaleSetName") String vmScaleSetName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/virtualMachineScaleSets/{vmScaleSetName}")
        Call<ResponseBody> get(@Path("resourceGroupName") String resourceGroupName, @Path("vmScaleSetName") String vmScaleSetName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/virtualMachineScaleSets/{vmScaleSetName}/delete")
        Call<ResponseBody> deleteInstances(@Path("resourceGroupName") String resourceGroupName, @Path("vmScaleSetName") String vmScaleSetName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Body VirtualMachineScaleSetVMInstanceRequiredIDs vmInstanceIDs);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/virtualMachineScaleSets/{vmScaleSetName}/delete")
        Call<ResponseBody> beginDeleteInstances(@Path("resourceGroupName") String resourceGroupName, @Path("vmScaleSetName") String vmScaleSetName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Body VirtualMachineScaleSetVMInstanceRequiredIDs vmInstanceIDs);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/virtualMachineScaleSets/{vmScaleSetName}/instanceView")
        Call<ResponseBody> getInstanceView(@Path("resourceGroupName") String resourceGroupName, @Path("vmScaleSetName") String vmScaleSetName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/virtualMachineScaleSets")
        Call<ResponseBody> list(@Path("resourceGroupName") String resourceGroupName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("subscriptions/{subscriptionId}/providers/Microsoft.Compute/virtualMachineScaleSets")
        Call<ResponseBody> listAll(@Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/virtualMachineScaleSets/{vmScaleSetName}/skus")
        Call<ResponseBody> listSkus(@Path("resourceGroupName") String resourceGroupName, @Path("vmScaleSetName") String vmScaleSetName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/virtualMachineScaleSets/{vmScaleSetName}/poweroff")
        Call<ResponseBody> powerOff(@Path("resourceGroupName") String resourceGroupName, @Path("vmScaleSetName") String vmScaleSetName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Body VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/virtualMachineScaleSets/{vmScaleSetName}/poweroff")
        Call<ResponseBody> beginPowerOff(@Path("resourceGroupName") String resourceGroupName, @Path("vmScaleSetName") String vmScaleSetName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Body VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/virtualMachineScaleSets/{vmScaleSetName}/restart")
        Call<ResponseBody> restart(@Path("resourceGroupName") String resourceGroupName, @Path("vmScaleSetName") String vmScaleSetName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Body VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/virtualMachineScaleSets/{vmScaleSetName}/restart")
        Call<ResponseBody> beginRestart(@Path("resourceGroupName") String resourceGroupName, @Path("vmScaleSetName") String vmScaleSetName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Body VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/virtualMachineScaleSets/{vmScaleSetName}/start")
        Call<ResponseBody> start(@Path("resourceGroupName") String resourceGroupName, @Path("vmScaleSetName") String vmScaleSetName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Body VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/virtualMachineScaleSets/{vmScaleSetName}/start")
        Call<ResponseBody> beginStart(@Path("resourceGroupName") String resourceGroupName, @Path("vmScaleSetName") String vmScaleSetName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Body VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/virtualMachineScaleSets/{vmScaleSetName}/manualupgrade")
        Call<ResponseBody> updateInstances(@Path("resourceGroupName") String resourceGroupName, @Path("vmScaleSetName") String vmScaleSetName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Body VirtualMachineScaleSetVMInstanceRequiredIDs vmInstanceIDs);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/virtualMachineScaleSets/{vmScaleSetName}/manualupgrade")
        Call<ResponseBody> beginUpdateInstances(@Path("resourceGroupName") String resourceGroupName, @Path("vmScaleSetName") String vmScaleSetName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Body VirtualMachineScaleSetVMInstanceRequiredIDs vmInstanceIDs);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/virtualMachineScaleSets/{vmScaleSetName}/reimage")
        Call<ResponseBody> reimage(@Path("resourceGroupName") String resourceGroupName, @Path("vmScaleSetName") String vmScaleSetName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/virtualMachineScaleSets/{vmScaleSetName}/reimage")
        Call<ResponseBody> beginReimage(@Path("resourceGroupName") String resourceGroupName, @Path("vmScaleSetName") String vmScaleSetName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET
        Call<ResponseBody> listNext(@Url String nextPageLink, @Header("accept-language") String acceptLanguage);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET
        Call<ResponseBody> listAllNext(@Url String nextPageLink, @Header("accept-language") String acceptLanguage);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET
        Call<ResponseBody> listSkusNext(@Url String nextPageLink, @Header("accept-language") String acceptLanguage);

    }

    /**
     * The operation to create or update a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param name Parameters supplied to the Create Virtual Machine Scale Set operation.
     * @param parameters Parameters supplied to the Create Virtual Machine Scale Set operation.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the VirtualMachineScaleSet object wrapped in ServiceResponse if successful.
     */
    public ServiceResponse<VirtualMachineScaleSet> createOrUpdate(String resourceGroupName, String name, VirtualMachineScaleSet parameters) throws CloudException, IOException, IllegalArgumentException, InterruptedException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (name == null) {
            throw new IllegalArgumentException("Parameter name is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (parameters == null) {
            throw new IllegalArgumentException("Parameter parameters is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(parameters);
        Response<ResponseBody> result = service.createOrUpdate(resourceGroupName, name, this.client.getSubscriptionId(), parameters, this.client.getApiVersion(), this.client.getAcceptLanguage()).execute();
        return client.getAzureClient().getPutOrPatchResult(result, new TypeToken<VirtualMachineScaleSet>() { }.getType());
    }

    /**
     * The operation to create or update a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param name Parameters supplied to the Create Virtual Machine Scale Set operation.
     * @param parameters Parameters supplied to the Create Virtual Machine Scale Set operation.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    public ServiceCall createOrUpdateAsync(String resourceGroupName, String name, VirtualMachineScaleSet parameters, final ServiceCallback<VirtualMachineScaleSet> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (name == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter name is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (parameters == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter parameters is required and cannot be null."));
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
        }
        Validator.validate(parameters, serviceCallback);
        Call<ResponseBody> call = service.createOrUpdate(resourceGroupName, name, this.client.getSubscriptionId(), parameters, this.client.getApiVersion(), this.client.getAcceptLanguage());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                serviceCallback.failure(t);
            }
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                client.getAzureClient().getPutOrPatchResultAsync(response, new TypeToken<VirtualMachineScaleSet>() { }.getType(), serviceCall, serviceCallback);
            }
        });
        return serviceCall;
    }

    /**
     * The operation to create or update a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param name Parameters supplied to the Create Virtual Machine Scale Set operation.
     * @param parameters Parameters supplied to the Create Virtual Machine Scale Set operation.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the VirtualMachineScaleSet object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<VirtualMachineScaleSet> beginCreateOrUpdate(String resourceGroupName, String name, VirtualMachineScaleSet parameters) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (name == null) {
            throw new IllegalArgumentException("Parameter name is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (parameters == null) {
            throw new IllegalArgumentException("Parameter parameters is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(parameters);
        Call<ResponseBody> call = service.beginCreateOrUpdate(resourceGroupName, name, this.client.getSubscriptionId(), parameters, this.client.getApiVersion(), this.client.getAcceptLanguage());
        return beginCreateOrUpdateDelegate(call.execute());
    }

    /**
     * The operation to create or update a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param name Parameters supplied to the Create Virtual Machine Scale Set operation.
     * @param parameters Parameters supplied to the Create Virtual Machine Scale Set operation.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall beginCreateOrUpdateAsync(String resourceGroupName, String name, VirtualMachineScaleSet parameters, final ServiceCallback<VirtualMachineScaleSet> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (name == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter name is required and cannot be null."));
            return null;
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (parameters == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter parameters is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(parameters, serviceCallback);
        Call<ResponseBody> call = service.beginCreateOrUpdate(resourceGroupName, name, this.client.getSubscriptionId(), parameters, this.client.getApiVersion(), this.client.getAcceptLanguage());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<VirtualMachineScaleSet>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(beginCreateOrUpdateDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<VirtualMachineScaleSet> beginCreateOrUpdateDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<VirtualMachineScaleSet, CloudException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<VirtualMachineScaleSet>() { }.getType())
                .register(201, new TypeToken<VirtualMachineScaleSet>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * The operation to deallocate virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the ServiceResponse object if successful.
     */
    public ServiceResponse<Void> deallocate(String resourceGroupName, String vmScaleSetName) throws CloudException, IOException, IllegalArgumentException, InterruptedException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        final String instanceIdsConverted = null;
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
        vmInstanceIDs = null;
        Response<ResponseBody> result = service.deallocate(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs).execute();
        return client.getAzureClient().getPostOrDeleteResult(result, new TypeToken<Void>() { }.getType());
    }

    /**
     * The operation to deallocate virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    public ServiceCall deallocateAsync(String resourceGroupName, String vmScaleSetName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
        }
        final String instanceIdsConverted = null;
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
        vmInstanceIDs = null;
        Call<ResponseBody> call = service.deallocate(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                serviceCallback.failure(t);
            }
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                client.getAzureClient().getPostOrDeleteResultAsync(response, new TypeToken<Void>() { }.getType(), serviceCall, serviceCallback);
            }
        });
        return serviceCall;
    }
    /**
     * The operation to deallocate virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the ServiceResponse object if successful.
     */
    public ServiceResponse<Void> deallocate(String resourceGroupName, String vmScaleSetName, List<String> instanceIds) throws CloudException, IOException, IllegalArgumentException, InterruptedException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(instanceIds);
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = null;
        if (instanceIds != null) {
            vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
            vmInstanceIDs.setInstanceIds(instanceIds);
        }
        Response<ResponseBody> result = service.deallocate(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs).execute();
        return client.getAzureClient().getPostOrDeleteResult(result, new TypeToken<Void>() { }.getType());
    }

    /**
     * The operation to deallocate virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    public ServiceCall deallocateAsync(String resourceGroupName, String vmScaleSetName, List<String> instanceIds, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
        }
        Validator.validate(instanceIds, serviceCallback);
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = null;
        if (instanceIds != null) {
            vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
            vmInstanceIDs.setInstanceIds(instanceIds);
        }
        Call<ResponseBody> call = service.deallocate(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                serviceCallback.failure(t);
            }
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                client.getAzureClient().getPostOrDeleteResultAsync(response, new TypeToken<Void>() { }.getType(), serviceCall, serviceCallback);
            }
        });
        return serviceCall;
    }

    /**
     * The operation to deallocate virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    public ServiceResponse<Void> beginDeallocate(String resourceGroupName, String vmScaleSetName) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        final String instanceIdsConverted = null;
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
        vmInstanceIDs = null;
        Call<ResponseBody> call = service.beginDeallocate(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        return beginDeallocateDelegate(call.execute());
    }

    /**
     * The operation to deallocate virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall beginDeallocateAsync(String resourceGroupName, String vmScaleSetName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
            return null;
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        final String instanceIdsConverted = null;
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
        vmInstanceIDs = null;
        Call<ResponseBody> call = service.beginDeallocate(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(beginDeallocateDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * The operation to deallocate virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    public ServiceResponse<Void> beginDeallocate(String resourceGroupName, String vmScaleSetName, List<String> instanceIds) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(instanceIds);
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = null;
        if (instanceIds != null) {
            vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
            vmInstanceIDs.setInstanceIds(instanceIds);
        }
        Call<ResponseBody> call = service.beginDeallocate(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        return beginDeallocateDelegate(call.execute());
    }

    /**
     * The operation to deallocate virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall beginDeallocateAsync(String resourceGroupName, String vmScaleSetName, List<String> instanceIds, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
            return null;
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(instanceIds, serviceCallback);
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = null;
        if (instanceIds != null) {
            vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
            vmInstanceIDs.setInstanceIds(instanceIds);
        }
        Call<ResponseBody> call = service.beginDeallocate(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(beginDeallocateDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<Void> beginDeallocateDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Void, CloudException>(this.client.getMapperAdapter())
                .register(202, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * The operation to delete a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the ServiceResponse object if successful.
     */
    public ServiceResponse<Void> delete(String resourceGroupName, String vmScaleSetName) throws CloudException, IOException, IllegalArgumentException, InterruptedException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Response<ResponseBody> result = service.delete(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage()).execute();
        return client.getAzureClient().getPostOrDeleteResult(result, new TypeToken<Void>() { }.getType());
    }

    /**
     * The operation to delete a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    public ServiceCall deleteAsync(String resourceGroupName, String vmScaleSetName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
        }
        Call<ResponseBody> call = service.delete(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                serviceCallback.failure(t);
            }
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                client.getAzureClient().getPostOrDeleteResultAsync(response, new TypeToken<Void>() { }.getType(), serviceCall, serviceCallback);
            }
        });
        return serviceCall;
    }

    /**
     * The operation to delete a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    public ServiceResponse<Void> beginDelete(String resourceGroupName, String vmScaleSetName) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Call<ResponseBody> call = service.beginDelete(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        return beginDeleteDelegate(call.execute());
    }

    /**
     * The operation to delete a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall beginDeleteAsync(String resourceGroupName, String vmScaleSetName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
            return null;
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.beginDelete(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(beginDeleteDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<Void> beginDeleteDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Void, CloudException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<Void>() { }.getType())
                .register(202, new TypeToken<Void>() { }.getType())
                .register(204, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * The operation to get a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the VirtualMachineScaleSet object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<VirtualMachineScaleSet> get(String resourceGroupName, String vmScaleSetName) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Call<ResponseBody> call = service.get(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        return getDelegate(call.execute());
    }

    /**
     * The operation to get a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getAsync(String resourceGroupName, String vmScaleSetName, final ServiceCallback<VirtualMachineScaleSet> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
            return null;
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.get(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<VirtualMachineScaleSet>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<VirtualMachineScaleSet> getDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<VirtualMachineScaleSet, CloudException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<VirtualMachineScaleSet>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * The operation to delete virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the ServiceResponse object if successful.
     */
    public ServiceResponse<Void> deleteInstances(String resourceGroupName, String vmScaleSetName, List<String> instanceIds) throws CloudException, IOException, IllegalArgumentException, InterruptedException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        if (instanceIds == null) {
            throw new IllegalArgumentException("Parameter instanceIds is required and cannot be null.");
        }
        Validator.validate(instanceIds);
        VirtualMachineScaleSetVMInstanceRequiredIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceRequiredIDs();
        vmInstanceIDs.setInstanceIds(instanceIds);
        Response<ResponseBody> result = service.deleteInstances(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs).execute();
        return client.getAzureClient().getPostOrDeleteResult(result, new TypeToken<Void>() { }.getType());
    }

    /**
     * The operation to delete virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    public ServiceCall deleteInstancesAsync(String resourceGroupName, String vmScaleSetName, List<String> instanceIds, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
        }
        if (instanceIds == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter instanceIds is required and cannot be null."));
        }
        Validator.validate(instanceIds, serviceCallback);
        VirtualMachineScaleSetVMInstanceRequiredIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceRequiredIDs();
        vmInstanceIDs.setInstanceIds(instanceIds);
        Call<ResponseBody> call = service.deleteInstances(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                serviceCallback.failure(t);
            }
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                client.getAzureClient().getPostOrDeleteResultAsync(response, new TypeToken<Void>() { }.getType(), serviceCall, serviceCallback);
            }
        });
        return serviceCall;
    }

    /**
     * The operation to delete virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    public ServiceResponse<Void> beginDeleteInstances(String resourceGroupName, String vmScaleSetName, List<String> instanceIds) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        if (instanceIds == null) {
            throw new IllegalArgumentException("Parameter instanceIds is required and cannot be null.");
        }
        Validator.validate(instanceIds);
        VirtualMachineScaleSetVMInstanceRequiredIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceRequiredIDs();
        vmInstanceIDs.setInstanceIds(instanceIds);
        Call<ResponseBody> call = service.beginDeleteInstances(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        return beginDeleteInstancesDelegate(call.execute());
    }

    /**
     * The operation to delete virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall beginDeleteInstancesAsync(String resourceGroupName, String vmScaleSetName, List<String> instanceIds, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
            return null;
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        if (instanceIds == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter instanceIds is required and cannot be null."));
            return null;
        }
        Validator.validate(instanceIds, serviceCallback);
        VirtualMachineScaleSetVMInstanceRequiredIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceRequiredIDs();
        vmInstanceIDs.setInstanceIds(instanceIds);
        Call<ResponseBody> call = service.beginDeleteInstances(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(beginDeleteInstancesDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<Void> beginDeleteInstancesDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Void, CloudException>(this.client.getMapperAdapter())
                .register(202, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * The operation to get a virtual machine scale set instance view.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the VirtualMachineScaleSetInstanceView object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<VirtualMachineScaleSetInstanceView> getInstanceView(String resourceGroupName, String vmScaleSetName) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Call<ResponseBody> call = service.getInstanceView(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        return getInstanceViewDelegate(call.execute());
    }

    /**
     * The operation to get a virtual machine scale set instance view.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getInstanceViewAsync(String resourceGroupName, String vmScaleSetName, final ServiceCallback<VirtualMachineScaleSetInstanceView> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
            return null;
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.getInstanceView(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<VirtualMachineScaleSetInstanceView>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getInstanceViewDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<VirtualMachineScaleSetInstanceView> getInstanceViewDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<VirtualMachineScaleSetInstanceView, CloudException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<VirtualMachineScaleSetInstanceView>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * The operation to list virtual machine scale sets under a resource group.
     *
     * @param resourceGroupName The name of the resource group.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;VirtualMachineScaleSet&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<PagedList<VirtualMachineScaleSet>> list(final String resourceGroupName) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Call<ResponseBody> call = service.list(resourceGroupName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        ServiceResponse<PageImpl<VirtualMachineScaleSet>> response = listDelegate(call.execute());
        PagedList<VirtualMachineScaleSet> result = new PagedList<VirtualMachineScaleSet>(response.getBody()) {
            @Override
            public Page<VirtualMachineScaleSet> nextPage(String nextPageLink) throws CloudException, IOException {
                return listNext(nextPageLink).getBody();
            }
        };
        return new ServiceResponse<>(result, response.getResponse());
    }

    /**
     * The operation to list virtual machine scale sets under a resource group.
     *
     * @param resourceGroupName The name of the resource group.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall listAsync(final String resourceGroupName, final ListOperationCallback<VirtualMachineScaleSet> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.list(resourceGroupName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<List<VirtualMachineScaleSet>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    ServiceResponse<PageImpl<VirtualMachineScaleSet>> result = listDelegate(response);
                    serviceCallback.load(result.getBody().getItems());
                    if (result.getBody().getNextPageLink() != null
                            && serviceCallback.progress(result.getBody().getItems()) == ListOperationCallback.PagingBahavior.CONTINUE) {
                        listNextAsync(result.getBody().getNextPageLink(), serviceCall, serviceCallback);
                    } else {
                        serviceCallback.success(new ServiceResponse<>(serviceCallback.get(), result.getResponse()));
                    }
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<PageImpl<VirtualMachineScaleSet>> listDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<VirtualMachineScaleSet>, CloudException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<PageImpl<VirtualMachineScaleSet>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets the list of Virtual Machine Scale Sets in the subscription. Use nextLink property in the response to get the next page of Virtual Machine Scale Sets. Do this till nextLink is not null to fetch all the Virtual Machine Scale Sets.
     *
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;VirtualMachineScaleSet&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<PagedList<VirtualMachineScaleSet>> listAll() throws CloudException, IOException, IllegalArgumentException {
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Call<ResponseBody> call = service.listAll(this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        ServiceResponse<PageImpl<VirtualMachineScaleSet>> response = listAllDelegate(call.execute());
        PagedList<VirtualMachineScaleSet> result = new PagedList<VirtualMachineScaleSet>(response.getBody()) {
            @Override
            public Page<VirtualMachineScaleSet> nextPage(String nextPageLink) throws CloudException, IOException {
                return listAllNext(nextPageLink).getBody();
            }
        };
        return new ServiceResponse<>(result, response.getResponse());
    }

    /**
     * Gets the list of Virtual Machine Scale Sets in the subscription. Use nextLink property in the response to get the next page of Virtual Machine Scale Sets. Do this till nextLink is not null to fetch all the Virtual Machine Scale Sets.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall listAllAsync(final ListOperationCallback<VirtualMachineScaleSet> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.listAll(this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<List<VirtualMachineScaleSet>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    ServiceResponse<PageImpl<VirtualMachineScaleSet>> result = listAllDelegate(response);
                    serviceCallback.load(result.getBody().getItems());
                    if (result.getBody().getNextPageLink() != null
                            && serviceCallback.progress(result.getBody().getItems()) == ListOperationCallback.PagingBahavior.CONTINUE) {
                        listAllNextAsync(result.getBody().getNextPageLink(), serviceCall, serviceCallback);
                    } else {
                        serviceCallback.success(new ServiceResponse<>(serviceCallback.get(), result.getResponse()));
                    }
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<PageImpl<VirtualMachineScaleSet>> listAllDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<VirtualMachineScaleSet>, CloudException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<PageImpl<VirtualMachineScaleSet>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * The operation to list available skus for a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;VirtualMachineScaleSetSku&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<PagedList<VirtualMachineScaleSetSku>> listSkus(final String resourceGroupName, final String vmScaleSetName) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Call<ResponseBody> call = service.listSkus(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        ServiceResponse<PageImpl<VirtualMachineScaleSetSku>> response = listSkusDelegate(call.execute());
        PagedList<VirtualMachineScaleSetSku> result = new PagedList<VirtualMachineScaleSetSku>(response.getBody()) {
            @Override
            public Page<VirtualMachineScaleSetSku> nextPage(String nextPageLink) throws CloudException, IOException {
                return listSkusNext(nextPageLink).getBody();
            }
        };
        return new ServiceResponse<>(result, response.getResponse());
    }

    /**
     * The operation to list available skus for a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall listSkusAsync(final String resourceGroupName, final String vmScaleSetName, final ListOperationCallback<VirtualMachineScaleSetSku> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
            return null;
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.listSkus(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<List<VirtualMachineScaleSetSku>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    ServiceResponse<PageImpl<VirtualMachineScaleSetSku>> result = listSkusDelegate(response);
                    serviceCallback.load(result.getBody().getItems());
                    if (result.getBody().getNextPageLink() != null
                            && serviceCallback.progress(result.getBody().getItems()) == ListOperationCallback.PagingBahavior.CONTINUE) {
                        listSkusNextAsync(result.getBody().getNextPageLink(), serviceCall, serviceCallback);
                    } else {
                        serviceCallback.success(new ServiceResponse<>(serviceCallback.get(), result.getResponse()));
                    }
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<PageImpl<VirtualMachineScaleSetSku>> listSkusDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<VirtualMachineScaleSetSku>, CloudException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<PageImpl<VirtualMachineScaleSetSku>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * The operation to power off (stop) virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the ServiceResponse object if successful.
     */
    public ServiceResponse<Void> powerOff(String resourceGroupName, String vmScaleSetName) throws CloudException, IOException, IllegalArgumentException, InterruptedException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        final String instanceIdsConverted = null;
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
        vmInstanceIDs = null;
        Response<ResponseBody> result = service.powerOff(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs).execute();
        return client.getAzureClient().getPostOrDeleteResult(result, new TypeToken<Void>() { }.getType());
    }

    /**
     * The operation to power off (stop) virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    public ServiceCall powerOffAsync(String resourceGroupName, String vmScaleSetName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
        }
        final String instanceIdsConverted = null;
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
        vmInstanceIDs = null;
        Call<ResponseBody> call = service.powerOff(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                serviceCallback.failure(t);
            }
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                client.getAzureClient().getPostOrDeleteResultAsync(response, new TypeToken<Void>() { }.getType(), serviceCall, serviceCallback);
            }
        });
        return serviceCall;
    }
    /**
     * The operation to power off (stop) virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the ServiceResponse object if successful.
     */
    public ServiceResponse<Void> powerOff(String resourceGroupName, String vmScaleSetName, List<String> instanceIds) throws CloudException, IOException, IllegalArgumentException, InterruptedException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(instanceIds);
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = null;
        if (instanceIds != null) {
            vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
            vmInstanceIDs.setInstanceIds(instanceIds);
        }
        Response<ResponseBody> result = service.powerOff(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs).execute();
        return client.getAzureClient().getPostOrDeleteResult(result, new TypeToken<Void>() { }.getType());
    }

    /**
     * The operation to power off (stop) virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    public ServiceCall powerOffAsync(String resourceGroupName, String vmScaleSetName, List<String> instanceIds, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
        }
        Validator.validate(instanceIds, serviceCallback);
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = null;
        if (instanceIds != null) {
            vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
            vmInstanceIDs.setInstanceIds(instanceIds);
        }
        Call<ResponseBody> call = service.powerOff(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                serviceCallback.failure(t);
            }
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                client.getAzureClient().getPostOrDeleteResultAsync(response, new TypeToken<Void>() { }.getType(), serviceCall, serviceCallback);
            }
        });
        return serviceCall;
    }

    /**
     * The operation to power off (stop) virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    public ServiceResponse<Void> beginPowerOff(String resourceGroupName, String vmScaleSetName) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        final String instanceIdsConverted = null;
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
        vmInstanceIDs = null;
        Call<ResponseBody> call = service.beginPowerOff(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        return beginPowerOffDelegate(call.execute());
    }

    /**
     * The operation to power off (stop) virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall beginPowerOffAsync(String resourceGroupName, String vmScaleSetName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
            return null;
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        final String instanceIdsConverted = null;
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
        vmInstanceIDs = null;
        Call<ResponseBody> call = service.beginPowerOff(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(beginPowerOffDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * The operation to power off (stop) virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    public ServiceResponse<Void> beginPowerOff(String resourceGroupName, String vmScaleSetName, List<String> instanceIds) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(instanceIds);
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = null;
        if (instanceIds != null) {
            vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
            vmInstanceIDs.setInstanceIds(instanceIds);
        }
        Call<ResponseBody> call = service.beginPowerOff(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        return beginPowerOffDelegate(call.execute());
    }

    /**
     * The operation to power off (stop) virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall beginPowerOffAsync(String resourceGroupName, String vmScaleSetName, List<String> instanceIds, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
            return null;
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(instanceIds, serviceCallback);
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = null;
        if (instanceIds != null) {
            vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
            vmInstanceIDs.setInstanceIds(instanceIds);
        }
        Call<ResponseBody> call = service.beginPowerOff(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(beginPowerOffDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<Void> beginPowerOffDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Void, CloudException>(this.client.getMapperAdapter())
                .register(202, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * The operation to restart virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the ServiceResponse object if successful.
     */
    public ServiceResponse<Void> restart(String resourceGroupName, String vmScaleSetName) throws CloudException, IOException, IllegalArgumentException, InterruptedException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        final String instanceIdsConverted = null;
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
        vmInstanceIDs = null;
        Response<ResponseBody> result = service.restart(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs).execute();
        return client.getAzureClient().getPostOrDeleteResult(result, new TypeToken<Void>() { }.getType());
    }

    /**
     * The operation to restart virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    public ServiceCall restartAsync(String resourceGroupName, String vmScaleSetName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
        }
        final String instanceIdsConverted = null;
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
        vmInstanceIDs = null;
        Call<ResponseBody> call = service.restart(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                serviceCallback.failure(t);
            }
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                client.getAzureClient().getPostOrDeleteResultAsync(response, new TypeToken<Void>() { }.getType(), serviceCall, serviceCallback);
            }
        });
        return serviceCall;
    }
    /**
     * The operation to restart virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the ServiceResponse object if successful.
     */
    public ServiceResponse<Void> restart(String resourceGroupName, String vmScaleSetName, List<String> instanceIds) throws CloudException, IOException, IllegalArgumentException, InterruptedException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(instanceIds);
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = null;
        if (instanceIds != null) {
            vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
            vmInstanceIDs.setInstanceIds(instanceIds);
        }
        Response<ResponseBody> result = service.restart(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs).execute();
        return client.getAzureClient().getPostOrDeleteResult(result, new TypeToken<Void>() { }.getType());
    }

    /**
     * The operation to restart virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    public ServiceCall restartAsync(String resourceGroupName, String vmScaleSetName, List<String> instanceIds, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
        }
        Validator.validate(instanceIds, serviceCallback);
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = null;
        if (instanceIds != null) {
            vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
            vmInstanceIDs.setInstanceIds(instanceIds);
        }
        Call<ResponseBody> call = service.restart(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                serviceCallback.failure(t);
            }
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                client.getAzureClient().getPostOrDeleteResultAsync(response, new TypeToken<Void>() { }.getType(), serviceCall, serviceCallback);
            }
        });
        return serviceCall;
    }

    /**
     * The operation to restart virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    public ServiceResponse<Void> beginRestart(String resourceGroupName, String vmScaleSetName) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        final String instanceIdsConverted = null;
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
        vmInstanceIDs = null;
        Call<ResponseBody> call = service.beginRestart(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        return beginRestartDelegate(call.execute());
    }

    /**
     * The operation to restart virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall beginRestartAsync(String resourceGroupName, String vmScaleSetName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
            return null;
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        final String instanceIdsConverted = null;
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
        vmInstanceIDs = null;
        Call<ResponseBody> call = service.beginRestart(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(beginRestartDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * The operation to restart virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    public ServiceResponse<Void> beginRestart(String resourceGroupName, String vmScaleSetName, List<String> instanceIds) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(instanceIds);
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = null;
        if (instanceIds != null) {
            vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
            vmInstanceIDs.setInstanceIds(instanceIds);
        }
        Call<ResponseBody> call = service.beginRestart(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        return beginRestartDelegate(call.execute());
    }

    /**
     * The operation to restart virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall beginRestartAsync(String resourceGroupName, String vmScaleSetName, List<String> instanceIds, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
            return null;
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(instanceIds, serviceCallback);
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = null;
        if (instanceIds != null) {
            vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
            vmInstanceIDs.setInstanceIds(instanceIds);
        }
        Call<ResponseBody> call = service.beginRestart(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(beginRestartDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<Void> beginRestartDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Void, CloudException>(this.client.getMapperAdapter())
                .register(202, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * The operation to start virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the ServiceResponse object if successful.
     */
    public ServiceResponse<Void> start(String resourceGroupName, String vmScaleSetName) throws CloudException, IOException, IllegalArgumentException, InterruptedException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        final String instanceIdsConverted = null;
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
        vmInstanceIDs = null;
        Response<ResponseBody> result = service.start(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs).execute();
        return client.getAzureClient().getPostOrDeleteResult(result, new TypeToken<Void>() { }.getType());
    }

    /**
     * The operation to start virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    public ServiceCall startAsync(String resourceGroupName, String vmScaleSetName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
        }
        final String instanceIdsConverted = null;
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
        vmInstanceIDs = null;
        Call<ResponseBody> call = service.start(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                serviceCallback.failure(t);
            }
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                client.getAzureClient().getPostOrDeleteResultAsync(response, new TypeToken<Void>() { }.getType(), serviceCall, serviceCallback);
            }
        });
        return serviceCall;
    }
    /**
     * The operation to start virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the ServiceResponse object if successful.
     */
    public ServiceResponse<Void> start(String resourceGroupName, String vmScaleSetName, List<String> instanceIds) throws CloudException, IOException, IllegalArgumentException, InterruptedException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(instanceIds);
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = null;
        if (instanceIds != null) {
            vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
            vmInstanceIDs.setInstanceIds(instanceIds);
        }
        Response<ResponseBody> result = service.start(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs).execute();
        return client.getAzureClient().getPostOrDeleteResult(result, new TypeToken<Void>() { }.getType());
    }

    /**
     * The operation to start virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    public ServiceCall startAsync(String resourceGroupName, String vmScaleSetName, List<String> instanceIds, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
        }
        Validator.validate(instanceIds, serviceCallback);
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = null;
        if (instanceIds != null) {
            vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
            vmInstanceIDs.setInstanceIds(instanceIds);
        }
        Call<ResponseBody> call = service.start(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                serviceCallback.failure(t);
            }
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                client.getAzureClient().getPostOrDeleteResultAsync(response, new TypeToken<Void>() { }.getType(), serviceCall, serviceCallback);
            }
        });
        return serviceCall;
    }

    /**
     * The operation to start virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    public ServiceResponse<Void> beginStart(String resourceGroupName, String vmScaleSetName) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        final String instanceIdsConverted = null;
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
        vmInstanceIDs = null;
        Call<ResponseBody> call = service.beginStart(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        return beginStartDelegate(call.execute());
    }

    /**
     * The operation to start virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall beginStartAsync(String resourceGroupName, String vmScaleSetName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
            return null;
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        final String instanceIdsConverted = null;
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
        vmInstanceIDs = null;
        Call<ResponseBody> call = service.beginStart(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(beginStartDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * The operation to start virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    public ServiceResponse<Void> beginStart(String resourceGroupName, String vmScaleSetName, List<String> instanceIds) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(instanceIds);
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = null;
        if (instanceIds != null) {
            vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
            vmInstanceIDs.setInstanceIds(instanceIds);
        }
        Call<ResponseBody> call = service.beginStart(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        return beginStartDelegate(call.execute());
    }

    /**
     * The operation to start virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall beginStartAsync(String resourceGroupName, String vmScaleSetName, List<String> instanceIds, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
            return null;
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(instanceIds, serviceCallback);
        VirtualMachineScaleSetVMInstanceIDs vmInstanceIDs = null;
        if (instanceIds != null) {
            vmInstanceIDs = new VirtualMachineScaleSetVMInstanceIDs();
            vmInstanceIDs.setInstanceIds(instanceIds);
        }
        Call<ResponseBody> call = service.beginStart(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(beginStartDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<Void> beginStartDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Void, CloudException>(this.client.getMapperAdapter())
                .register(202, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * The operation to manually upgrade virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the ServiceResponse object if successful.
     */
    public ServiceResponse<Void> updateInstances(String resourceGroupName, String vmScaleSetName, List<String> instanceIds) throws CloudException, IOException, IllegalArgumentException, InterruptedException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        if (instanceIds == null) {
            throw new IllegalArgumentException("Parameter instanceIds is required and cannot be null.");
        }
        Validator.validate(instanceIds);
        VirtualMachineScaleSetVMInstanceRequiredIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceRequiredIDs();
        vmInstanceIDs.setInstanceIds(instanceIds);
        Response<ResponseBody> result = service.updateInstances(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs).execute();
        return client.getAzureClient().getPostOrDeleteResult(result, new TypeToken<Void>() { }.getType());
    }

    /**
     * The operation to manually upgrade virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    public ServiceCall updateInstancesAsync(String resourceGroupName, String vmScaleSetName, List<String> instanceIds, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
        }
        if (instanceIds == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter instanceIds is required and cannot be null."));
        }
        Validator.validate(instanceIds, serviceCallback);
        VirtualMachineScaleSetVMInstanceRequiredIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceRequiredIDs();
        vmInstanceIDs.setInstanceIds(instanceIds);
        Call<ResponseBody> call = service.updateInstances(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                serviceCallback.failure(t);
            }
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                client.getAzureClient().getPostOrDeleteResultAsync(response, new TypeToken<Void>() { }.getType(), serviceCall, serviceCallback);
            }
        });
        return serviceCall;
    }

    /**
     * The operation to manually upgrade virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    public ServiceResponse<Void> beginUpdateInstances(String resourceGroupName, String vmScaleSetName, List<String> instanceIds) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        if (instanceIds == null) {
            throw new IllegalArgumentException("Parameter instanceIds is required and cannot be null.");
        }
        Validator.validate(instanceIds);
        VirtualMachineScaleSetVMInstanceRequiredIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceRequiredIDs();
        vmInstanceIDs.setInstanceIds(instanceIds);
        Call<ResponseBody> call = service.beginUpdateInstances(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        return beginUpdateInstancesDelegate(call.execute());
    }

    /**
     * The operation to manually upgrade virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param instanceIds Gets or sets the virtual machine scale set instance ids.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall beginUpdateInstancesAsync(String resourceGroupName, String vmScaleSetName, List<String> instanceIds, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
            return null;
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        if (instanceIds == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter instanceIds is required and cannot be null."));
            return null;
        }
        Validator.validate(instanceIds, serviceCallback);
        VirtualMachineScaleSetVMInstanceRequiredIDs vmInstanceIDs = new VirtualMachineScaleSetVMInstanceRequiredIDs();
        vmInstanceIDs.setInstanceIds(instanceIds);
        Call<ResponseBody> call = service.beginUpdateInstances(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), vmInstanceIDs);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(beginUpdateInstancesDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<Void> beginUpdateInstancesDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Void, CloudException>(this.client.getMapperAdapter())
                .register(202, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * The operation to re-image virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the ServiceResponse object if successful.
     */
    public ServiceResponse<Void> reimage(String resourceGroupName, String vmScaleSetName) throws CloudException, IOException, IllegalArgumentException, InterruptedException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Response<ResponseBody> result = service.reimage(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage()).execute();
        return client.getAzureClient().getPostOrDeleteResult(result, new TypeToken<Void>() { }.getType());
    }

    /**
     * The operation to re-image virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    public ServiceCall reimageAsync(String resourceGroupName, String vmScaleSetName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
        }
        Call<ResponseBody> call = service.reimage(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                serviceCallback.failure(t);
            }
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                client.getAzureClient().getPostOrDeleteResultAsync(response, new TypeToken<Void>() { }.getType(), serviceCall, serviceCallback);
            }
        });
        return serviceCall;
    }

    /**
     * The operation to re-image virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    public ServiceResponse<Void> beginReimage(String resourceGroupName, String vmScaleSetName) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vmScaleSetName == null) {
            throw new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Call<ResponseBody> call = service.beginReimage(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        return beginReimageDelegate(call.execute());
    }

    /**
     * The operation to re-image virtual machines in a virtual machine scale set.
     *
     * @param resourceGroupName The name of the resource group.
     * @param vmScaleSetName The name of the virtual machine scale set.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall beginReimageAsync(String resourceGroupName, String vmScaleSetName, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (vmScaleSetName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter vmScaleSetName is required and cannot be null."));
            return null;
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.beginReimage(resourceGroupName, vmScaleSetName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(beginReimageDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<Void> beginReimageDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Void, CloudException>(this.client.getMapperAdapter())
                .register(202, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * The operation to list virtual machine scale sets under a resource group.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;VirtualMachineScaleSet&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<PageImpl<VirtualMachineScaleSet>> listNext(final String nextPageLink) throws CloudException, IOException, IllegalArgumentException {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        Call<ResponseBody> call = service.listNext(nextPageLink, this.client.getAcceptLanguage());
        return listNextDelegate(call.execute());
    }

    /**
     * The operation to list virtual machine scale sets under a resource group.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall listNextAsync(final String nextPageLink, final ServiceCall serviceCall, final ListOperationCallback<VirtualMachineScaleSet> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (nextPageLink == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter nextPageLink is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.listNext(nextPageLink, this.client.getAcceptLanguage());
        serviceCall.newCall(call);
        call.enqueue(new ServiceResponseCallback<List<VirtualMachineScaleSet>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    ServiceResponse<PageImpl<VirtualMachineScaleSet>> result = listNextDelegate(response);
                    serviceCallback.load(result.getBody().getItems());
                    if (result.getBody().getNextPageLink() != null
                            && serviceCallback.progress(result.getBody().getItems()) == ListOperationCallback.PagingBahavior.CONTINUE) {
                        listNextAsync(result.getBody().getNextPageLink(), serviceCall, serviceCallback);
                    } else {
                        serviceCallback.success(new ServiceResponse<>(serviceCallback.get(), result.getResponse()));
                    }
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<PageImpl<VirtualMachineScaleSet>> listNextDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<VirtualMachineScaleSet>, CloudException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<PageImpl<VirtualMachineScaleSet>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets the list of Virtual Machine Scale Sets in the subscription. Use nextLink property in the response to get the next page of Virtual Machine Scale Sets. Do this till nextLink is not null to fetch all the Virtual Machine Scale Sets.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;VirtualMachineScaleSet&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<PageImpl<VirtualMachineScaleSet>> listAllNext(final String nextPageLink) throws CloudException, IOException, IllegalArgumentException {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        Call<ResponseBody> call = service.listAllNext(nextPageLink, this.client.getAcceptLanguage());
        return listAllNextDelegate(call.execute());
    }

    /**
     * Gets the list of Virtual Machine Scale Sets in the subscription. Use nextLink property in the response to get the next page of Virtual Machine Scale Sets. Do this till nextLink is not null to fetch all the Virtual Machine Scale Sets.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall listAllNextAsync(final String nextPageLink, final ServiceCall serviceCall, final ListOperationCallback<VirtualMachineScaleSet> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (nextPageLink == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter nextPageLink is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.listAllNext(nextPageLink, this.client.getAcceptLanguage());
        serviceCall.newCall(call);
        call.enqueue(new ServiceResponseCallback<List<VirtualMachineScaleSet>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    ServiceResponse<PageImpl<VirtualMachineScaleSet>> result = listAllNextDelegate(response);
                    serviceCallback.load(result.getBody().getItems());
                    if (result.getBody().getNextPageLink() != null
                            && serviceCallback.progress(result.getBody().getItems()) == ListOperationCallback.PagingBahavior.CONTINUE) {
                        listAllNextAsync(result.getBody().getNextPageLink(), serviceCall, serviceCallback);
                    } else {
                        serviceCallback.success(new ServiceResponse<>(serviceCallback.get(), result.getResponse()));
                    }
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<PageImpl<VirtualMachineScaleSet>> listAllNextDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<VirtualMachineScaleSet>, CloudException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<PageImpl<VirtualMachineScaleSet>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * The operation to list available skus for a virtual machine scale set.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;VirtualMachineScaleSetSku&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<PageImpl<VirtualMachineScaleSetSku>> listSkusNext(final String nextPageLink) throws CloudException, IOException, IllegalArgumentException {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        Call<ResponseBody> call = service.listSkusNext(nextPageLink, this.client.getAcceptLanguage());
        return listSkusNextDelegate(call.execute());
    }

    /**
     * The operation to list available skus for a virtual machine scale set.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall listSkusNextAsync(final String nextPageLink, final ServiceCall serviceCall, final ListOperationCallback<VirtualMachineScaleSetSku> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (nextPageLink == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter nextPageLink is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.listSkusNext(nextPageLink, this.client.getAcceptLanguage());
        serviceCall.newCall(call);
        call.enqueue(new ServiceResponseCallback<List<VirtualMachineScaleSetSku>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    ServiceResponse<PageImpl<VirtualMachineScaleSetSku>> result = listSkusNextDelegate(response);
                    serviceCallback.load(result.getBody().getItems());
                    if (result.getBody().getNextPageLink() != null
                            && serviceCallback.progress(result.getBody().getItems()) == ListOperationCallback.PagingBahavior.CONTINUE) {
                        listSkusNextAsync(result.getBody().getNextPageLink(), serviceCall, serviceCallback);
                    } else {
                        serviceCallback.success(new ServiceResponse<>(serviceCallback.get(), result.getResponse()));
                    }
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<PageImpl<VirtualMachineScaleSetSku>> listSkusNextDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<VirtualMachineScaleSetSku>, CloudException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<PageImpl<VirtualMachineScaleSetSku>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
