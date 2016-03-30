/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.website;

import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceResponseBuilder;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.management.website.models.DomainAvailablilityCheckResult;
import com.microsoft.azure.management.website.models.DomainCollection;
import com.microsoft.azure.management.website.models.DomainControlCenterSsoRequest;
import com.microsoft.azure.management.website.models.DomainRecommendationSearchParameters;
import com.microsoft.azure.management.website.models.DomainRegistrationInput;
import com.microsoft.azure.management.website.models.NameIdentifier;
import com.microsoft.azure.management.website.models.NameIdentifierCollection;
import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.ServiceResponseCallback;
import com.microsoft.rest.Validator;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * An instance of this class provides access to all the operations defined
 * in GlobalDomainRegistrationOperations.
 */
public final class GlobalDomainRegistrationOperationsImpl implements GlobalDomainRegistrationOperations {
    /** The Retrofit service to perform REST calls. */
    private GlobalDomainRegistrationService service;
    /** The service client containing this operation class. */
    private WebSiteManagementClient client;

    /**
     * Initializes an instance of GlobalDomainRegistrationOperations.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public GlobalDomainRegistrationOperationsImpl(Retrofit retrofit, WebSiteManagementClient client) {
        this.service = retrofit.create(GlobalDomainRegistrationService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for GlobalDomainRegistrationOperations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface GlobalDomainRegistrationService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("subscriptions/{subscriptionId}/providers/Microsoft.DomainRegistration/domains")
        Call<ResponseBody> getAllDomains(@Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("subscriptions/{subscriptionId}/providers/Microsoft.DomainRegistration/generateSsoRequest")
        Call<ResponseBody> getDomainControlCenterSsoRequest(@Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("subscriptions/{subscriptionId}/providers/Microsoft.DomainRegistration/validateDomainRegistrationInformation")
        Call<ResponseBody> validateDomainPurchaseInformation(@Path("subscriptionId") String subscriptionId, @Body DomainRegistrationInput domainRegistrationInput, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("subscriptions/{subscriptionId}/providers/Microsoft.DomainRegistration/checkDomainAvailability")
        Call<ResponseBody> checkDomainAvailability(@Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Body NameIdentifier identifier);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("subscriptions/{subscriptionId}/providers/Microsoft.DomainRegistration/listDomainRecommendations")
        Call<ResponseBody> listDomainRecommendations(@Path("subscriptionId") String subscriptionId, @Body DomainRecommendationSearchParameters parameters, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

    }

    /**
     * Lists all domains in a subscription.
     *
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the DomainCollection object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<DomainCollection> getAllDomains() throws CloudException, IOException, IllegalArgumentException {
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Call<ResponseBody> call = service.getAllDomains(this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        return getAllDomainsDelegate(call.execute());
    }

    /**
     * Lists all domains in a subscription.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getAllDomainsAsync(final ServiceCallback<DomainCollection> serviceCallback) throws IllegalArgumentException {
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
        Call<ResponseBody> call = service.getAllDomains(this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<DomainCollection>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getAllDomainsDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<DomainCollection> getAllDomainsDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<DomainCollection, CloudException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<DomainCollection>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Generates a single sign on request for domain management portal.
     *
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the DomainControlCenterSsoRequest object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<DomainControlCenterSsoRequest> getDomainControlCenterSsoRequest() throws CloudException, IOException, IllegalArgumentException {
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Call<ResponseBody> call = service.getDomainControlCenterSsoRequest(this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        return getDomainControlCenterSsoRequestDelegate(call.execute());
    }

    /**
     * Generates a single sign on request for domain management portal.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getDomainControlCenterSsoRequestAsync(final ServiceCallback<DomainControlCenterSsoRequest> serviceCallback) throws IllegalArgumentException {
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
        Call<ResponseBody> call = service.getDomainControlCenterSsoRequest(this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<DomainControlCenterSsoRequest>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getDomainControlCenterSsoRequestDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<DomainControlCenterSsoRequest> getDomainControlCenterSsoRequestDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<DomainControlCenterSsoRequest, CloudException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<DomainControlCenterSsoRequest>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Validates domain registration information.
     *
     * @param domainRegistrationInput Domain registration information
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<Object> validateDomainPurchaseInformation(DomainRegistrationInput domainRegistrationInput) throws CloudException, IOException, IllegalArgumentException {
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (domainRegistrationInput == null) {
            throw new IllegalArgumentException("Parameter domainRegistrationInput is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(domainRegistrationInput);
        Call<ResponseBody> call = service.validateDomainPurchaseInformation(this.client.getSubscriptionId(), domainRegistrationInput, this.client.getApiVersion(), this.client.getAcceptLanguage());
        return validateDomainPurchaseInformationDelegate(call.execute());
    }

    /**
     * Validates domain registration information.
     *
     * @param domainRegistrationInput Domain registration information
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall validateDomainPurchaseInformationAsync(DomainRegistrationInput domainRegistrationInput, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (domainRegistrationInput == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter domainRegistrationInput is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(domainRegistrationInput, serviceCallback);
        Call<ResponseBody> call = service.validateDomainPurchaseInformation(this.client.getSubscriptionId(), domainRegistrationInput, this.client.getApiVersion(), this.client.getAcceptLanguage());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Object>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(validateDomainPurchaseInformationDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<Object> validateDomainPurchaseInformationDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Object, CloudException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<Object>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Checks if a domain is available for registration.
     *
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the DomainAvailablilityCheckResult object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<DomainAvailablilityCheckResult> checkDomainAvailability() throws CloudException, IOException, IllegalArgumentException {
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        final String name = null;
        NameIdentifier identifier = new NameIdentifier();
        identifier = null;
        Call<ResponseBody> call = service.checkDomainAvailability(this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), identifier);
        return checkDomainAvailabilityDelegate(call.execute());
    }

    /**
     * Checks if a domain is available for registration.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall checkDomainAvailabilityAsync(final ServiceCallback<DomainAvailablilityCheckResult> serviceCallback) throws IllegalArgumentException {
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
        final String name = null;
        NameIdentifier identifier = new NameIdentifier();
        identifier = null;
        Call<ResponseBody> call = service.checkDomainAvailability(this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), identifier);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<DomainAvailablilityCheckResult>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(checkDomainAvailabilityDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Checks if a domain is available for registration.
     *
     * @param name Name of the object
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the DomainAvailablilityCheckResult object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<DomainAvailablilityCheckResult> checkDomainAvailability(String name) throws CloudException, IOException, IllegalArgumentException {
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        NameIdentifier identifier = new NameIdentifier();
        identifier.setName(name);
        Call<ResponseBody> call = service.checkDomainAvailability(this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), identifier);
        return checkDomainAvailabilityDelegate(call.execute());
    }

    /**
     * Checks if a domain is available for registration.
     *
     * @param name Name of the object
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall checkDomainAvailabilityAsync(String name, final ServiceCallback<DomainAvailablilityCheckResult> serviceCallback) throws IllegalArgumentException {
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
        NameIdentifier identifier = new NameIdentifier();
        identifier.setName(name);
        Call<ResponseBody> call = service.checkDomainAvailability(this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage(), identifier);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<DomainAvailablilityCheckResult>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(checkDomainAvailabilityDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<DomainAvailablilityCheckResult> checkDomainAvailabilityDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<DomainAvailablilityCheckResult, CloudException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<DomainAvailablilityCheckResult>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Lists domain recommendations based on keywords.
     *
     * @param parameters Domain recommendation search parameters
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the NameIdentifierCollection object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<NameIdentifierCollection> listDomainRecommendations(DomainRecommendationSearchParameters parameters) throws CloudException, IOException, IllegalArgumentException {
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
        Call<ResponseBody> call = service.listDomainRecommendations(this.client.getSubscriptionId(), parameters, this.client.getApiVersion(), this.client.getAcceptLanguage());
        return listDomainRecommendationsDelegate(call.execute());
    }

    /**
     * Lists domain recommendations based on keywords.
     *
     * @param parameters Domain recommendation search parameters
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall listDomainRecommendationsAsync(DomainRecommendationSearchParameters parameters, final ServiceCallback<NameIdentifierCollection> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
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
        Call<ResponseBody> call = service.listDomainRecommendations(this.client.getSubscriptionId(), parameters, this.client.getApiVersion(), this.client.getAcceptLanguage());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<NameIdentifierCollection>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(listDomainRecommendationsDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<NameIdentifierCollection> listDomainRecommendationsDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<NameIdentifierCollection, CloudException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<NameIdentifierCollection>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
