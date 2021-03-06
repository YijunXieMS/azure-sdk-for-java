// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.anomalydetector.implementation;

import com.azure.ai.anomalydetector.models.AnomalyDetectorErrorException;
import com.azure.ai.anomalydetector.models.ChangePointDetectRequest;
import com.azure.ai.anomalydetector.models.ChangePointDetectResponse;
import com.azure.ai.anomalydetector.models.DetectRequest;
import com.azure.ai.anomalydetector.models.EntireDetectResponse;
import com.azure.ai.anomalydetector.models.LastDetectResponse;
import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.Post;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.policy.CookiePolicy;
import com.azure.core.http.policy.RetryPolicy;
import com.azure.core.http.policy.UserAgentPolicy;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.serializer.JacksonAdapter;
import com.azure.core.util.serializer.SerializerAdapter;
import reactor.core.publisher.Mono;

/** Initializes a new instance of the AnomalyDetectorClient type. */
public final class AnomalyDetectorClientImpl {
    /** The proxy service used to perform REST calls. */
    private final AnomalyDetectorClientService service;

    /**
     * Supported Cognitive Services endpoints (protocol and hostname, for example:
     * https://westus2.api.cognitive.microsoft.com).
     */
    private final String endpoint;

    /**
     * Gets Supported Cognitive Services endpoints (protocol and hostname, for example:
     * https://westus2.api.cognitive.microsoft.com).
     *
     * @return the endpoint value.
     */
    public String getEndpoint() {
        return this.endpoint;
    }

    /** The HTTP pipeline to send requests through. */
    private final HttpPipeline httpPipeline;

    /**
     * Gets The HTTP pipeline to send requests through.
     *
     * @return the httpPipeline value.
     */
    public HttpPipeline getHttpPipeline() {
        return this.httpPipeline;
    }

    /** The serializer to serialize an object into a string. */
    private final SerializerAdapter serializerAdapter;

    /**
     * Gets The serializer to serialize an object into a string.
     *
     * @return the serializerAdapter value.
     */
    public SerializerAdapter getSerializerAdapter() {
        return this.serializerAdapter;
    }

    /** Initializes an instance of AnomalyDetectorClient client. */
    public AnomalyDetectorClientImpl(String endpoint) {
        this(
                new HttpPipelineBuilder()
                        .policies(new UserAgentPolicy(), new RetryPolicy(), new CookiePolicy())
                        .build(),
                JacksonAdapter.createDefaultSerializerAdapter(),
                endpoint);
    }

    /**
     * Initializes an instance of AnomalyDetectorClient client.
     *
     * @param httpPipeline The HTTP pipeline to send requests through.
     */
    public AnomalyDetectorClientImpl(HttpPipeline httpPipeline, String endpoint) {
        this(httpPipeline, JacksonAdapter.createDefaultSerializerAdapter(), endpoint);
    }

    /**
     * Initializes an instance of AnomalyDetectorClient client.
     *
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param serializerAdapter The serializer to serialize an object into a string.
     */
    public AnomalyDetectorClientImpl(HttpPipeline httpPipeline, SerializerAdapter serializerAdapter, String endpoint) {
        this.httpPipeline = httpPipeline;
        this.serializerAdapter = serializerAdapter;
        this.endpoint = endpoint;
        this.service =
                RestProxy.create(AnomalyDetectorClientService.class, this.httpPipeline, this.getSerializerAdapter());
    }

    /**
     * The interface defining all the services for AnomalyDetectorClient to be used by the proxy service to perform REST
     * calls.
     */
    @Host("{Endpoint}/anomalydetector/v1.0")
    @ServiceInterface(name = "AnomalyDetectorClien")
    private interface AnomalyDetectorClientService {
        @Post("/timeseries/entire/detect")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(AnomalyDetectorErrorException.class)
        Mono<Response<EntireDetectResponse>> detectEntireSeries(
                @HostParam("Endpoint") String endpoint,
                @BodyParam("application/json") DetectRequest body,
                Context context);

        @Post("/timeseries/last/detect")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(AnomalyDetectorErrorException.class)
        Mono<Response<LastDetectResponse>> detectLastPoint(
                @HostParam("Endpoint") String endpoint,
                @BodyParam("application/json") DetectRequest body,
                Context context);

        @Post("/timeseries/changepoint/detect")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(AnomalyDetectorErrorException.class)
        Mono<Response<ChangePointDetectResponse>> detectChangePoint(
                @HostParam("Endpoint") String endpoint,
                @BodyParam("application/json") ChangePointDetectRequest body,
                Context context);
    }

    /**
     * This operation generates a model using an entire series, each point is detected with the same model. With this
     * method, points before and after a certain point are used to determine whether it is an anomaly. The entire
     * detection can give user an overall status of the time series.
     *
     * @param body Time series points and period if needed. Advanced model parameters can also be set in the request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws AnomalyDetectorErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<EntireDetectResponse>> detectEntireSeriesWithResponseAsync(DetectRequest body) {
        return FluxUtil.withContext(context -> service.detectEntireSeries(this.getEndpoint(), body, context));
    }

    /**
     * This operation generates a model using an entire series, each point is detected with the same model. With this
     * method, points before and after a certain point are used to determine whether it is an anomaly. The entire
     * detection can give user an overall status of the time series.
     *
     * @param body Time series points and period if needed. Advanced model parameters can also be set in the request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws AnomalyDetectorErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<EntireDetectResponse>> detectEntireSeriesWithResponseAsync(
            DetectRequest body, Context context) {
        return service.detectEntireSeries(this.getEndpoint(), body, context);
    }

    /**
     * This operation generates a model using an entire series, each point is detected with the same model. With this
     * method, points before and after a certain point are used to determine whether it is an anomaly. The entire
     * detection can give user an overall status of the time series.
     *
     * @param body Time series points and period if needed. Advanced model parameters can also be set in the request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws AnomalyDetectorErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<EntireDetectResponse> detectEntireSeriesAsync(DetectRequest body) {
        return detectEntireSeriesWithResponseAsync(body)
                .flatMap(
                        (Response<EntireDetectResponse> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * This operation generates a model using an entire series, each point is detected with the same model. With this
     * method, points before and after a certain point are used to determine whether it is an anomaly. The entire
     * detection can give user an overall status of the time series.
     *
     * @param body Time series points and period if needed. Advanced model parameters can also be set in the request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws AnomalyDetectorErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<EntireDetectResponse> detectEntireSeriesAsync(DetectRequest body, Context context) {
        return detectEntireSeriesWithResponseAsync(body, context)
                .flatMap(
                        (Response<EntireDetectResponse> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * This operation generates a model using an entire series, each point is detected with the same model. With this
     * method, points before and after a certain point are used to determine whether it is an anomaly. The entire
     * detection can give user an overall status of the time series.
     *
     * @param body Time series points and period if needed. Advanced model parameters can also be set in the request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws AnomalyDetectorErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public EntireDetectResponse detectEntireSeries(DetectRequest body) {
        return detectEntireSeriesAsync(body).block();
    }

    /**
     * This operation generates a model using an entire series, each point is detected with the same model. With this
     * method, points before and after a certain point are used to determine whether it is an anomaly. The entire
     * detection can give user an overall status of the time series.
     *
     * @param body Time series points and period if needed. Advanced model parameters can also be set in the request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws AnomalyDetectorErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<EntireDetectResponse> detectEntireSeriesWithResponse(DetectRequest body, Context context) {
        return detectEntireSeriesWithResponseAsync(body, context).block();
    }

    /**
     * This operation generates a model using points before the latest one. With this method, only historical points are
     * used to determine whether the target point is an anomaly. The latest point detecting operation matches the
     * scenario of real-time monitoring of business metrics.
     *
     * @param body Time series points and period if needed. Advanced model parameters can also be set in the request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws AnomalyDetectorErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<LastDetectResponse>> detectLastPointWithResponseAsync(DetectRequest body) {
        return FluxUtil.withContext(context -> service.detectLastPoint(this.getEndpoint(), body, context));
    }

    /**
     * This operation generates a model using points before the latest one. With this method, only historical points are
     * used to determine whether the target point is an anomaly. The latest point detecting operation matches the
     * scenario of real-time monitoring of business metrics.
     *
     * @param body Time series points and period if needed. Advanced model parameters can also be set in the request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws AnomalyDetectorErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<LastDetectResponse>> detectLastPointWithResponseAsync(DetectRequest body, Context context) {
        return service.detectLastPoint(this.getEndpoint(), body, context);
    }

    /**
     * This operation generates a model using points before the latest one. With this method, only historical points are
     * used to determine whether the target point is an anomaly. The latest point detecting operation matches the
     * scenario of real-time monitoring of business metrics.
     *
     * @param body Time series points and period if needed. Advanced model parameters can also be set in the request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws AnomalyDetectorErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<LastDetectResponse> detectLastPointAsync(DetectRequest body) {
        return detectLastPointWithResponseAsync(body)
                .flatMap(
                        (Response<LastDetectResponse> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * This operation generates a model using points before the latest one. With this method, only historical points are
     * used to determine whether the target point is an anomaly. The latest point detecting operation matches the
     * scenario of real-time monitoring of business metrics.
     *
     * @param body Time series points and period if needed. Advanced model parameters can also be set in the request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws AnomalyDetectorErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<LastDetectResponse> detectLastPointAsync(DetectRequest body, Context context) {
        return detectLastPointWithResponseAsync(body, context)
                .flatMap(
                        (Response<LastDetectResponse> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * This operation generates a model using points before the latest one. With this method, only historical points are
     * used to determine whether the target point is an anomaly. The latest point detecting operation matches the
     * scenario of real-time monitoring of business metrics.
     *
     * @param body Time series points and period if needed. Advanced model parameters can also be set in the request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws AnomalyDetectorErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LastDetectResponse detectLastPoint(DetectRequest body) {
        return detectLastPointAsync(body).block();
    }

    /**
     * This operation generates a model using points before the latest one. With this method, only historical points are
     * used to determine whether the target point is an anomaly. The latest point detecting operation matches the
     * scenario of real-time monitoring of business metrics.
     *
     * @param body Time series points and period if needed. Advanced model parameters can also be set in the request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws AnomalyDetectorErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LastDetectResponse> detectLastPointWithResponse(DetectRequest body, Context context) {
        return detectLastPointWithResponseAsync(body, context).block();
    }

    /**
     * Evaluate change point score of every series point.
     *
     * @param body Time series points and granularity is needed. Advanced model parameters can also be set in the
     *     request if needed.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws AnomalyDetectorErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<ChangePointDetectResponse>> detectChangePointWithResponseAsync(ChangePointDetectRequest body) {
        return FluxUtil.withContext(context -> service.detectChangePoint(this.getEndpoint(), body, context));
    }

    /**
     * Evaluate change point score of every series point.
     *
     * @param body Time series points and granularity is needed. Advanced model parameters can also be set in the
     *     request if needed.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws AnomalyDetectorErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<ChangePointDetectResponse>> detectChangePointWithResponseAsync(
            ChangePointDetectRequest body, Context context) {
        return service.detectChangePoint(this.getEndpoint(), body, context);
    }

    /**
     * Evaluate change point score of every series point.
     *
     * @param body Time series points and granularity is needed. Advanced model parameters can also be set in the
     *     request if needed.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws AnomalyDetectorErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<ChangePointDetectResponse> detectChangePointAsync(ChangePointDetectRequest body) {
        return detectChangePointWithResponseAsync(body)
                .flatMap(
                        (Response<ChangePointDetectResponse> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * Evaluate change point score of every series point.
     *
     * @param body Time series points and granularity is needed. Advanced model parameters can also be set in the
     *     request if needed.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws AnomalyDetectorErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<ChangePointDetectResponse> detectChangePointAsync(ChangePointDetectRequest body, Context context) {
        return detectChangePointWithResponseAsync(body, context)
                .flatMap(
                        (Response<ChangePointDetectResponse> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * Evaluate change point score of every series point.
     *
     * @param body Time series points and granularity is needed. Advanced model parameters can also be set in the
     *     request if needed.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws AnomalyDetectorErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ChangePointDetectResponse detectChangePoint(ChangePointDetectRequest body) {
        return detectChangePointAsync(body).block();
    }

    /**
     * Evaluate change point score of every series point.
     *
     * @param body Time series points and granularity is needed. Advanced model parameters can also be set in the
     *     request if needed.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws AnomalyDetectorErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ChangePointDetectResponse> detectChangePointWithResponse(
            ChangePointDetectRequest body, Context context) {
        return detectChangePointWithResponseAsync(body, context).block();
    }
}
