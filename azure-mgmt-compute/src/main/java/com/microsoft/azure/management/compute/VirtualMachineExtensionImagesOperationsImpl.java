/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.compute;

import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceResponseBuilder;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.management.compute.models.VirtualMachineExtensionImage;
import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.ServiceResponseCallback;
import com.microsoft.rest.Validator;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * An instance of this class provides access to all the operations defined
 * in VirtualMachineExtensionImagesOperations.
 */
public final class VirtualMachineExtensionImagesOperationsImpl implements VirtualMachineExtensionImagesOperations {
    /** The Retrofit service to perform REST calls. */
    private VirtualMachineExtensionImagesService service;
    /** The service client containing this operation class. */
    private ComputeManagementClient client;

    /**
     * Initializes an instance of VirtualMachineExtensionImagesOperations.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public VirtualMachineExtensionImagesOperationsImpl(Retrofit retrofit, ComputeManagementClient client) {
        this.service = retrofit.create(VirtualMachineExtensionImagesService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for VirtualMachineExtensionImagesOperations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface VirtualMachineExtensionImagesService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("subscriptions/{subscriptionId}/providers/Microsoft.Compute/locations/{location}/publishers/{publisherName}/artifacttypes/vmextension/types/{type}/versions/{version}")
        Call<ResponseBody> get(@Path("location") String location, @Path("publisherName") String publisherName, @Path("type") String type, @Path("version") String version, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("subscriptions/{subscriptionId}/providers/Microsoft.Compute/locations/{location}/publishers/{publisherName}/artifacttypes/vmextension/types")
        Call<ResponseBody> listTypes(@Path("location") String location, @Path("publisherName") String publisherName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("subscriptions/{subscriptionId}/providers/Microsoft.Compute/locations/{location}/publishers/{publisherName}/artifacttypes/vmextension/types/{type}/versions")
        Call<ResponseBody> listVersions(@Path("location") String location, @Path("publisherName") String publisherName, @Path("type") String type, @Path("subscriptionId") String subscriptionId, @Query("$filter") VirtualMachineExtensionImage filter, @Query("$top") Integer top, @Query("$orderby") String orderby, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

    }

    /**
     * Gets a virtual machine extension image.
     *
     * @param location the String value
     * @param publisherName the String value
     * @param type the String value
     * @param version the String value
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the VirtualMachineExtensionImage object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<VirtualMachineExtensionImage> get(String location, String publisherName, String type, String version) throws CloudException, IOException, IllegalArgumentException {
        if (location == null) {
            throw new IllegalArgumentException("Parameter location is required and cannot be null.");
        }
        if (publisherName == null) {
            throw new IllegalArgumentException("Parameter publisherName is required and cannot be null.");
        }
        if (type == null) {
            throw new IllegalArgumentException("Parameter type is required and cannot be null.");
        }
        if (version == null) {
            throw new IllegalArgumentException("Parameter version is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Call<ResponseBody> call = service.get(location, publisherName, type, version, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        return getDelegate(call.execute());
    }

    /**
     * Gets a virtual machine extension image.
     *
     * @param location the String value
     * @param publisherName the String value
     * @param type the String value
     * @param version the String value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getAsync(String location, String publisherName, String type, String version, final ServiceCallback<VirtualMachineExtensionImage> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (location == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter location is required and cannot be null."));
            return null;
        }
        if (publisherName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter publisherName is required and cannot be null."));
            return null;
        }
        if (type == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter type is required and cannot be null."));
            return null;
        }
        if (version == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter version is required and cannot be null."));
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
        Call<ResponseBody> call = service.get(location, publisherName, type, version, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<VirtualMachineExtensionImage>(serviceCallback) {
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

    private ServiceResponse<VirtualMachineExtensionImage> getDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<VirtualMachineExtensionImage, CloudException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<VirtualMachineExtensionImage>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets a list of virtual machine extension image types.
     *
     * @param location the String value
     * @param publisherName the String value
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;VirtualMachineExtensionImage&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<List<VirtualMachineExtensionImage>> listTypes(String location, String publisherName) throws CloudException, IOException, IllegalArgumentException {
        if (location == null) {
            throw new IllegalArgumentException("Parameter location is required and cannot be null.");
        }
        if (publisherName == null) {
            throw new IllegalArgumentException("Parameter publisherName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Call<ResponseBody> call = service.listTypes(location, publisherName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        return listTypesDelegate(call.execute());
    }

    /**
     * Gets a list of virtual machine extension image types.
     *
     * @param location the String value
     * @param publisherName the String value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall listTypesAsync(String location, String publisherName, final ServiceCallback<List<VirtualMachineExtensionImage>> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (location == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter location is required and cannot be null."));
            return null;
        }
        if (publisherName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter publisherName is required and cannot be null."));
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
        Call<ResponseBody> call = service.listTypes(location, publisherName, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<List<VirtualMachineExtensionImage>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(listTypesDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<List<VirtualMachineExtensionImage>> listTypesDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<List<VirtualMachineExtensionImage>, CloudException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<List<VirtualMachineExtensionImage>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets a list of virtual machine extension image versions.
     *
     * @param location the String value
     * @param publisherName the String value
     * @param type the String value
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;VirtualMachineExtensionImage&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<List<VirtualMachineExtensionImage>> listVersions(String location, String publisherName, String type) throws CloudException, IOException, IllegalArgumentException {
        if (location == null) {
            throw new IllegalArgumentException("Parameter location is required and cannot be null.");
        }
        if (publisherName == null) {
            throw new IllegalArgumentException("Parameter publisherName is required and cannot be null.");
        }
        if (type == null) {
            throw new IllegalArgumentException("Parameter type is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        final VirtualMachineExtensionImage filter = null;
        final Integer top = null;
        final String orderby = null;
        Call<ResponseBody> call = service.listVersions(location, publisherName, type, this.client.getSubscriptionId(), filter, top, orderby, this.client.getApiVersion(), this.client.getAcceptLanguage());
        return listVersionsDelegate(call.execute());
    }

    /**
     * Gets a list of virtual machine extension image versions.
     *
     * @param location the String value
     * @param publisherName the String value
     * @param type the String value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall listVersionsAsync(String location, String publisherName, String type, final ServiceCallback<List<VirtualMachineExtensionImage>> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (location == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter location is required and cannot be null."));
            return null;
        }
        if (publisherName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter publisherName is required and cannot be null."));
            return null;
        }
        if (type == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter type is required and cannot be null."));
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
        final VirtualMachineExtensionImage filter = null;
        final Integer top = null;
        final String orderby = null;
        Call<ResponseBody> call = service.listVersions(location, publisherName, type, this.client.getSubscriptionId(), filter, top, orderby, this.client.getApiVersion(), this.client.getAcceptLanguage());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<List<VirtualMachineExtensionImage>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(listVersionsDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Gets a list of virtual machine extension image versions.
     *
     * @param location the String value
     * @param publisherName the String value
     * @param type the String value
     * @param filter The filter to apply on the operation.
     * @param top the Integer value
     * @param orderby the String value
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;VirtualMachineExtensionImage&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<List<VirtualMachineExtensionImage>> listVersions(String location, String publisherName, String type, VirtualMachineExtensionImage filter, Integer top, String orderby) throws CloudException, IOException, IllegalArgumentException {
        if (location == null) {
            throw new IllegalArgumentException("Parameter location is required and cannot be null.");
        }
        if (publisherName == null) {
            throw new IllegalArgumentException("Parameter publisherName is required and cannot be null.");
        }
        if (type == null) {
            throw new IllegalArgumentException("Parameter type is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(filter);
        Call<ResponseBody> call = service.listVersions(location, publisherName, type, this.client.getSubscriptionId(), filter, top, orderby, this.client.getApiVersion(), this.client.getAcceptLanguage());
        return listVersionsDelegate(call.execute());
    }

    /**
     * Gets a list of virtual machine extension image versions.
     *
     * @param location the String value
     * @param publisherName the String value
     * @param type the String value
     * @param filter The filter to apply on the operation.
     * @param top the Integer value
     * @param orderby the String value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall listVersionsAsync(String location, String publisherName, String type, VirtualMachineExtensionImage filter, Integer top, String orderby, final ServiceCallback<List<VirtualMachineExtensionImage>> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (location == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter location is required and cannot be null."));
            return null;
        }
        if (publisherName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter publisherName is required and cannot be null."));
            return null;
        }
        if (type == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter type is required and cannot be null."));
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
        Validator.validate(filter, serviceCallback);
        Call<ResponseBody> call = service.listVersions(location, publisherName, type, this.client.getSubscriptionId(), filter, top, orderby, this.client.getApiVersion(), this.client.getAcceptLanguage());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<List<VirtualMachineExtensionImage>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(listVersionsDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<List<VirtualMachineExtensionImage>> listVersionsDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<List<VirtualMachineExtensionImage>, CloudException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<List<VirtualMachineExtensionImage>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
