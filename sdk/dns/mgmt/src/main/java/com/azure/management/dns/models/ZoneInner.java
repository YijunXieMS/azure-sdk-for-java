// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.dns.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.JsonFlatten;
import com.azure.core.management.Resource;
import com.azure.core.management.SubResource;
import com.azure.core.util.logging.ClientLogger;
import com.azure.management.dns.ZoneType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The Zone model. */
@JsonFlatten
@Fluent
public class ZoneInner extends Resource {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(ZoneInner.class);

    /*
     * The etag of the zone.
     */
    @JsonProperty(value = "etag")
    private String etag;

    /*
     * The maximum number of record sets that can be created in this DNS zone.
     * This is a read-only property and any attempt to set this value will be
     * ignored.
     */
    @JsonProperty(value = "properties.maxNumberOfRecordSets", access = JsonProperty.Access.WRITE_ONLY)
    private Long maxNumberOfRecordSets;

    /*
     * The current number of record sets in this DNS zone.  This is a read-only
     * property and any attempt to set this value will be ignored.
     */
    @JsonProperty(value = "properties.numberOfRecordSets", access = JsonProperty.Access.WRITE_ONLY)
    private Long numberOfRecordSets;

    /*
     * The name servers for this DNS zone. This is a read-only property and any
     * attempt to set this value will be ignored.
     */
    @JsonProperty(value = "properties.nameServers", access = JsonProperty.Access.WRITE_ONLY)
    private List<String> nameServers;

    /*
     * The type of this DNS zone (Public or Private).
     */
    @JsonProperty(value = "properties.zoneType")
    private ZoneType zoneType;

    /*
     * A list of references to virtual networks that register hostnames in this
     * DNS zone. This is a only when ZoneType is Private.
     */
    @JsonProperty(value = "properties.registrationVirtualNetworks")
    private List<SubResource> registrationVirtualNetworks;

    /*
     * A list of references to virtual networks that resolve records in this
     * DNS zone. This is a only when ZoneType is Private.
     */
    @JsonProperty(value = "properties.resolutionVirtualNetworks")
    private List<SubResource> resolutionVirtualNetworks;

    /**
     * Get the etag property: The etag of the zone.
     *
     * @return the etag value.
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Set the etag property: The etag of the zone.
     *
     * @param etag the etag value to set.
     * @return the ZoneInner object itself.
     */
    public ZoneInner withEtag(String etag) {
        this.etag = etag;
        return this;
    }

    /**
     * Get the maxNumberOfRecordSets property: The maximum number of record sets that can be created in this DNS zone.
     * This is a read-only property and any attempt to set this value will be ignored.
     *
     * @return the maxNumberOfRecordSets value.
     */
    public Long maxNumberOfRecordSets() {
        return this.maxNumberOfRecordSets;
    }

    /**
     * Get the numberOfRecordSets property: The current number of record sets in this DNS zone. This is a read-only
     * property and any attempt to set this value will be ignored.
     *
     * @return the numberOfRecordSets value.
     */
    public Long numberOfRecordSets() {
        return this.numberOfRecordSets;
    }

    /**
     * Get the nameServers property: The name servers for this DNS zone. This is a read-only property and any attempt to
     * set this value will be ignored.
     *
     * @return the nameServers value.
     */
    public List<String> nameServers() {
        return this.nameServers;
    }

    /**
     * Get the zoneType property: The type of this DNS zone (Public or Private).
     *
     * @return the zoneType value.
     */
    public ZoneType zoneType() {
        return this.zoneType;
    }

    /**
     * Set the zoneType property: The type of this DNS zone (Public or Private).
     *
     * @param zoneType the zoneType value to set.
     * @return the ZoneInner object itself.
     */
    public ZoneInner withZoneType(ZoneType zoneType) {
        this.zoneType = zoneType;
        return this;
    }

    /**
     * Get the registrationVirtualNetworks property: A list of references to virtual networks that register hostnames in
     * this DNS zone. This is a only when ZoneType is Private.
     *
     * @return the registrationVirtualNetworks value.
     */
    public List<SubResource> registrationVirtualNetworks() {
        return this.registrationVirtualNetworks;
    }

    /**
     * Set the registrationVirtualNetworks property: A list of references to virtual networks that register hostnames in
     * this DNS zone. This is a only when ZoneType is Private.
     *
     * @param registrationVirtualNetworks the registrationVirtualNetworks value to set.
     * @return the ZoneInner object itself.
     */
    public ZoneInner withRegistrationVirtualNetworks(List<SubResource> registrationVirtualNetworks) {
        this.registrationVirtualNetworks = registrationVirtualNetworks;
        return this;
    }

    /**
     * Get the resolutionVirtualNetworks property: A list of references to virtual networks that resolve records in this
     * DNS zone. This is a only when ZoneType is Private.
     *
     * @return the resolutionVirtualNetworks value.
     */
    public List<SubResource> resolutionVirtualNetworks() {
        return this.resolutionVirtualNetworks;
    }

    /**
     * Set the resolutionVirtualNetworks property: A list of references to virtual networks that resolve records in this
     * DNS zone. This is a only when ZoneType is Private.
     *
     * @param resolutionVirtualNetworks the resolutionVirtualNetworks value to set.
     * @return the ZoneInner object itself.
     */
    public ZoneInner withResolutionVirtualNetworks(List<SubResource> resolutionVirtualNetworks) {
        this.resolutionVirtualNetworks = resolutionVirtualNetworks;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}