// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storage.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.JsonFlatten;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.storage.models.AzureEntityResource;
import com.azure.resourcemanager.storage.models.EnabledProtocols;
import com.azure.resourcemanager.storage.models.RootSquashType;
import com.azure.resourcemanager.storage.models.ShareAccessTier;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.Map;

/** Properties of the file share, including Id, resource name, resource type, Etag. */
@JsonFlatten
@Fluent
public class FileShareInner extends AzureEntityResource {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(FileShareInner.class);

    /*
     * Returns the date and time the share was last modified.
     */
    @JsonProperty(value = "properties.lastModifiedTime", access = JsonProperty.Access.WRITE_ONLY)
    private OffsetDateTime lastModifiedTime;

    /*
     * A name-value pair to associate with the share as metadata.
     */
    @JsonProperty(value = "properties.metadata")
    private Map<String, String> metadata;

    /*
     * The maximum size of the share, in gigabytes. Must be greater than 0, and
     * less than or equal to 5TB (5120). For Large File Shares, the maximum
     * size is 102400.
     */
    @JsonProperty(value = "properties.shareQuota")
    private Integer shareQuota;

    /*
     * The authentication protocol that is used for the file share. Can only be
     * specified when creating a share.
     */
    @JsonProperty(value = "properties.enabledProtocols")
    private EnabledProtocols enabledProtocols;

    /*
     * The property is for NFS share only. The default is NoRootSquash.
     */
    @JsonProperty(value = "properties.rootSquash")
    private RootSquashType rootSquash;

    /*
     * The version of the share.
     */
    @JsonProperty(value = "properties.version", access = JsonProperty.Access.WRITE_ONLY)
    private String version;

    /*
     * Indicates whether the share was deleted.
     */
    @JsonProperty(value = "properties.deleted", access = JsonProperty.Access.WRITE_ONLY)
    private Boolean deleted;

    /*
     * The deleted time if the share was deleted.
     */
    @JsonProperty(value = "properties.deletedTime", access = JsonProperty.Access.WRITE_ONLY)
    private OffsetDateTime deletedTime;

    /*
     * Remaining retention days for share that was soft deleted.
     */
    @JsonProperty(value = "properties.remainingRetentionDays", access = JsonProperty.Access.WRITE_ONLY)
    private Integer remainingRetentionDays;

    /*
     * Access tier for specific share. GpV2 account can choose between
     * TransactionOptimized (default), Hot, and Cool. FileStorage account can
     * choose Premium.
     */
    @JsonProperty(value = "properties.accessTier")
    private ShareAccessTier accessTier;

    /*
     * Indicates the last modification time for share access tier.
     */
    @JsonProperty(value = "properties.accessTierChangeTime", access = JsonProperty.Access.WRITE_ONLY)
    private OffsetDateTime accessTierChangeTime;

    /*
     * Indicates if there is a pending transition for access tier.
     */
    @JsonProperty(value = "properties.accessTierStatus", access = JsonProperty.Access.WRITE_ONLY)
    private String accessTierStatus;

    /*
     * The approximate size of the data stored on the share. Note that this
     * value may not include all recently created or recently resized files.
     */
    @JsonProperty(value = "properties.shareUsageBytes", access = JsonProperty.Access.WRITE_ONLY)
    private Long shareUsageBytes;

    /*
     * Creation time of share snapshot returned in the response of list shares
     * with expand param "snapshots".
     */
    @JsonProperty(value = "properties.snapshotTime", access = JsonProperty.Access.WRITE_ONLY)
    private OffsetDateTime snapshotTime;

    /**
     * Get the lastModifiedTime property: Returns the date and time the share was last modified.
     *
     * @return the lastModifiedTime value.
     */
    public OffsetDateTime lastModifiedTime() {
        return this.lastModifiedTime;
    }

    /**
     * Get the metadata property: A name-value pair to associate with the share as metadata.
     *
     * @return the metadata value.
     */
    public Map<String, String> metadata() {
        return this.metadata;
    }

    /**
     * Set the metadata property: A name-value pair to associate with the share as metadata.
     *
     * @param metadata the metadata value to set.
     * @return the FileShareInner object itself.
     */
    public FileShareInner withMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Get the shareQuota property: The maximum size of the share, in gigabytes. Must be greater than 0, and less than
     * or equal to 5TB (5120). For Large File Shares, the maximum size is 102400.
     *
     * @return the shareQuota value.
     */
    public Integer shareQuota() {
        return this.shareQuota;
    }

    /**
     * Set the shareQuota property: The maximum size of the share, in gigabytes. Must be greater than 0, and less than
     * or equal to 5TB (5120). For Large File Shares, the maximum size is 102400.
     *
     * @param shareQuota the shareQuota value to set.
     * @return the FileShareInner object itself.
     */
    public FileShareInner withShareQuota(Integer shareQuota) {
        this.shareQuota = shareQuota;
        return this;
    }

    /**
     * Get the enabledProtocols property: The authentication protocol that is used for the file share. Can only be
     * specified when creating a share.
     *
     * @return the enabledProtocols value.
     */
    public EnabledProtocols enabledProtocols() {
        return this.enabledProtocols;
    }

    /**
     * Set the enabledProtocols property: The authentication protocol that is used for the file share. Can only be
     * specified when creating a share.
     *
     * @param enabledProtocols the enabledProtocols value to set.
     * @return the FileShareInner object itself.
     */
    public FileShareInner withEnabledProtocols(EnabledProtocols enabledProtocols) {
        this.enabledProtocols = enabledProtocols;
        return this;
    }

    /**
     * Get the rootSquash property: The property is for NFS share only. The default is NoRootSquash.
     *
     * @return the rootSquash value.
     */
    public RootSquashType rootSquash() {
        return this.rootSquash;
    }

    /**
     * Set the rootSquash property: The property is for NFS share only. The default is NoRootSquash.
     *
     * @param rootSquash the rootSquash value to set.
     * @return the FileShareInner object itself.
     */
    public FileShareInner withRootSquash(RootSquashType rootSquash) {
        this.rootSquash = rootSquash;
        return this;
    }

    /**
     * Get the version property: The version of the share.
     *
     * @return the version value.
     */
    public String version() {
        return this.version;
    }

    /**
     * Get the deleted property: Indicates whether the share was deleted.
     *
     * @return the deleted value.
     */
    public Boolean deleted() {
        return this.deleted;
    }

    /**
     * Get the deletedTime property: The deleted time if the share was deleted.
     *
     * @return the deletedTime value.
     */
    public OffsetDateTime deletedTime() {
        return this.deletedTime;
    }

    /**
     * Get the remainingRetentionDays property: Remaining retention days for share that was soft deleted.
     *
     * @return the remainingRetentionDays value.
     */
    public Integer remainingRetentionDays() {
        return this.remainingRetentionDays;
    }

    /**
     * Get the accessTier property: Access tier for specific share. GpV2 account can choose between TransactionOptimized
     * (default), Hot, and Cool. FileStorage account can choose Premium.
     *
     * @return the accessTier value.
     */
    public ShareAccessTier accessTier() {
        return this.accessTier;
    }

    /**
     * Set the accessTier property: Access tier for specific share. GpV2 account can choose between TransactionOptimized
     * (default), Hot, and Cool. FileStorage account can choose Premium.
     *
     * @param accessTier the accessTier value to set.
     * @return the FileShareInner object itself.
     */
    public FileShareInner withAccessTier(ShareAccessTier accessTier) {
        this.accessTier = accessTier;
        return this;
    }

    /**
     * Get the accessTierChangeTime property: Indicates the last modification time for share access tier.
     *
     * @return the accessTierChangeTime value.
     */
    public OffsetDateTime accessTierChangeTime() {
        return this.accessTierChangeTime;
    }

    /**
     * Get the accessTierStatus property: Indicates if there is a pending transition for access tier.
     *
     * @return the accessTierStatus value.
     */
    public String accessTierStatus() {
        return this.accessTierStatus;
    }

    /**
     * Get the shareUsageBytes property: The approximate size of the data stored on the share. Note that this value may
     * not include all recently created or recently resized files.
     *
     * @return the shareUsageBytes value.
     */
    public Long shareUsageBytes() {
        return this.shareUsageBytes;
    }

    /**
     * Get the snapshotTime property: Creation time of share snapshot returned in the response of list shares with
     * expand param "snapshots".
     *
     * @return the snapshotTime value.
     */
    public OffsetDateTime snapshotTime() {
        return this.snapshotTime;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
    }
}
