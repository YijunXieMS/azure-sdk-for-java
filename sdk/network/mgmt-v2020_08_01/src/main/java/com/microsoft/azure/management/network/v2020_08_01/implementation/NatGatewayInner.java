/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_08_01.implementation;

import com.microsoft.azure.management.network.v2020_08_01.NatGatewaySku;
import java.util.List;
import com.microsoft.azure.SubResource;
import com.microsoft.azure.management.network.v2020_08_01.ProvisioningState;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.rest.SkipParentValidation;
import com.microsoft.azure.Resource;

/**
 * Nat Gateway resource.
 */
@JsonFlatten
@SkipParentValidation
public class NatGatewayInner extends Resource {
    /**
     * The nat gateway SKU.
     */
    @JsonProperty(value = "sku")
    private NatGatewaySku sku;

    /**
     * The idle timeout of the nat gateway.
     */
    @JsonProperty(value = "properties.idleTimeoutInMinutes")
    private Integer idleTimeoutInMinutes;

    /**
     * An array of public ip addresses associated with the nat gateway
     * resource.
     */
    @JsonProperty(value = "properties.publicIpAddresses")
    private List<SubResource> publicIpAddresses;

    /**
     * An array of public ip prefixes associated with the nat gateway resource.
     */
    @JsonProperty(value = "properties.publicIpPrefixes")
    private List<SubResource> publicIpPrefixes;

    /**
     * An array of references to the subnets using this nat gateway resource.
     */
    @JsonProperty(value = "properties.subnets", access = JsonProperty.Access.WRITE_ONLY)
    private List<SubResource> subnets;

    /**
     * The resource GUID property of the NAT gateway resource.
     */
    @JsonProperty(value = "properties.resourceGuid", access = JsonProperty.Access.WRITE_ONLY)
    private String resourceGuid;

    /**
     * The provisioning state of the NAT gateway resource. Possible values
     * include: 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /**
     * A list of availability zones denoting the zone in which Nat Gateway
     * should be deployed.
     */
    @JsonProperty(value = "zones")
    private List<String> zones;

    /**
     * A unique read-only string that changes whenever the resource is updated.
     */
    @JsonProperty(value = "etag", access = JsonProperty.Access.WRITE_ONLY)
    private String etag;

    /**
     * Resource ID.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * Get the nat gateway SKU.
     *
     * @return the sku value
     */
    public NatGatewaySku sku() {
        return this.sku;
    }

    /**
     * Set the nat gateway SKU.
     *
     * @param sku the sku value to set
     * @return the NatGatewayInner object itself.
     */
    public NatGatewayInner withSku(NatGatewaySku sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get the idle timeout of the nat gateway.
     *
     * @return the idleTimeoutInMinutes value
     */
    public Integer idleTimeoutInMinutes() {
        return this.idleTimeoutInMinutes;
    }

    /**
     * Set the idle timeout of the nat gateway.
     *
     * @param idleTimeoutInMinutes the idleTimeoutInMinutes value to set
     * @return the NatGatewayInner object itself.
     */
    public NatGatewayInner withIdleTimeoutInMinutes(Integer idleTimeoutInMinutes) {
        this.idleTimeoutInMinutes = idleTimeoutInMinutes;
        return this;
    }

    /**
     * Get an array of public ip addresses associated with the nat gateway resource.
     *
     * @return the publicIpAddresses value
     */
    public List<SubResource> publicIpAddresses() {
        return this.publicIpAddresses;
    }

    /**
     * Set an array of public ip addresses associated with the nat gateway resource.
     *
     * @param publicIpAddresses the publicIpAddresses value to set
     * @return the NatGatewayInner object itself.
     */
    public NatGatewayInner withPublicIpAddresses(List<SubResource> publicIpAddresses) {
        this.publicIpAddresses = publicIpAddresses;
        return this;
    }

    /**
     * Get an array of public ip prefixes associated with the nat gateway resource.
     *
     * @return the publicIpPrefixes value
     */
    public List<SubResource> publicIpPrefixes() {
        return this.publicIpPrefixes;
    }

    /**
     * Set an array of public ip prefixes associated with the nat gateway resource.
     *
     * @param publicIpPrefixes the publicIpPrefixes value to set
     * @return the NatGatewayInner object itself.
     */
    public NatGatewayInner withPublicIpPrefixes(List<SubResource> publicIpPrefixes) {
        this.publicIpPrefixes = publicIpPrefixes;
        return this;
    }

    /**
     * Get an array of references to the subnets using this nat gateway resource.
     *
     * @return the subnets value
     */
    public List<SubResource> subnets() {
        return this.subnets;
    }

    /**
     * Get the resource GUID property of the NAT gateway resource.
     *
     * @return the resourceGuid value
     */
    public String resourceGuid() {
        return this.resourceGuid;
    }

    /**
     * Get the provisioning state of the NAT gateway resource. Possible values include: 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     *
     * @return the provisioningState value
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get a list of availability zones denoting the zone in which Nat Gateway should be deployed.
     *
     * @return the zones value
     */
    public List<String> zones() {
        return this.zones;
    }

    /**
     * Set a list of availability zones denoting the zone in which Nat Gateway should be deployed.
     *
     * @param zones the zones value to set
     * @return the NatGatewayInner object itself.
     */
    public NatGatewayInner withZones(List<String> zones) {
        this.zones = zones;
        return this;
    }

    /**
     * Get a unique read-only string that changes whenever the resource is updated.
     *
     * @return the etag value
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Get resource ID.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Set resource ID.
     *
     * @param id the id value to set
     * @return the NatGatewayInner object itself.
     */
    public NatGatewayInner withId(String id) {
        this.id = id;
        return this;
    }

}
