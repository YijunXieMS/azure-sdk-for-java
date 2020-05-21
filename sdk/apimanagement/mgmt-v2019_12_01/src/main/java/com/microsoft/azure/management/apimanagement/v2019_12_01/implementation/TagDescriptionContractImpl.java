/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.apimanagement.v2019_12_01.implementation;

import com.microsoft.azure.management.apimanagement.v2019_12_01.TagDescriptionContract;
import com.microsoft.azure.arm.model.implementation.CreatableUpdatableImpl;
import rx.Observable;
import com.microsoft.azure.management.apimanagement.v2019_12_01.TagDescriptionCreateParameters;
import rx.functions.Func1;

class TagDescriptionContractImpl extends CreatableUpdatableImpl<TagDescriptionContract, TagDescriptionContractInner, TagDescriptionContractImpl> implements TagDescriptionContract, TagDescriptionContract.Definition, TagDescriptionContract.Update {
    private final ApiManagementManager manager;
    private String resourceGroupName;
    private String serviceName;
    private String apiId;
    private String tagDescriptionId;
    private String cifMatch;
    private String uifMatch;
    private TagDescriptionCreateParameters createOrUpdateParameter;

    TagDescriptionContractImpl(String name, ApiManagementManager manager) {
        super(name, new TagDescriptionContractInner());
        this.manager = manager;
        // Set resource name
        this.tagDescriptionId = name;
        //
        this.createOrUpdateParameter = new TagDescriptionCreateParameters();
    }

    TagDescriptionContractImpl(TagDescriptionContractInner inner, ApiManagementManager manager) {
        super(inner.name(), inner);
        this.manager = manager;
        // Set resource name
        this.tagDescriptionId = inner.name();
        // set resource ancestor and positional variables
        this.resourceGroupName = IdParsingUtils.getValueFromIdByName(inner.id(), "resourceGroups");
        this.serviceName = IdParsingUtils.getValueFromIdByName(inner.id(), "service");
        this.apiId = IdParsingUtils.getValueFromIdByName(inner.id(), "apis");
        this.tagDescriptionId = IdParsingUtils.getValueFromIdByName(inner.id(), "tagDescriptions");
        //
        this.createOrUpdateParameter = new TagDescriptionCreateParameters();
    }

    @Override
    public ApiManagementManager manager() {
        return this.manager;
    }

    @Override
    public Observable<TagDescriptionContract> createResourceAsync() {
        ApiTagDescriptionsInner client = this.manager().inner().apiTagDescriptions();
        return client.createOrUpdateAsync(this.resourceGroupName, this.serviceName, this.apiId, this.tagDescriptionId, this.createOrUpdateParameter, this.cifMatch)
            .map(new Func1<TagDescriptionContractInner, TagDescriptionContractInner>() {
               @Override
               public TagDescriptionContractInner call(TagDescriptionContractInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<TagDescriptionContract> updateResourceAsync() {
        ApiTagDescriptionsInner client = this.manager().inner().apiTagDescriptions();
        return client.createOrUpdateAsync(this.resourceGroupName, this.serviceName, this.apiId, this.tagDescriptionId, this.createOrUpdateParameter, this.uifMatch)
            .map(new Func1<TagDescriptionContractInner, TagDescriptionContractInner>() {
               @Override
               public TagDescriptionContractInner call(TagDescriptionContractInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<TagDescriptionContractInner> getInnerAsync() {
        ApiTagDescriptionsInner client = this.manager().inner().apiTagDescriptions();
        return client.getAsync(this.resourceGroupName, this.serviceName, this.apiId, this.tagDescriptionId);
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }

    private void resetCreateUpdateParameters() {
        this.createOrUpdateParameter = new TagDescriptionCreateParameters();
    }

    @Override
    public String description() {
        return this.inner().description();
    }

    @Override
    public String displayName() {
        return this.inner().displayName();
    }

    @Override
    public String externalDocsDescription() {
        return this.inner().externalDocsDescription();
    }

    @Override
    public String externalDocsUrl() {
        return this.inner().externalDocsUrl();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public String tagId() {
        return this.inner().tagId();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

    @Override
    public TagDescriptionContractImpl withExistingApi(String resourceGroupName, String serviceName, String apiId) {
        this.resourceGroupName = resourceGroupName;
        this.serviceName = serviceName;
        this.apiId = apiId;
        return this;
    }

    @Override
    public TagDescriptionContractImpl withIfMatch(String ifMatch) {
        if (isInCreateMode()) {
            this.cifMatch = ifMatch;
        } else {
            this.uifMatch = ifMatch;
        }
        return this;
    }

    @Override
    public TagDescriptionContractImpl withDescription(String description) {
        this.createOrUpdateParameter.withDescription(description);
        return this;
    }

    @Override
    public TagDescriptionContractImpl withExternalDocsDescription(String externalDocsDescription) {
        this.createOrUpdateParameter.withExternalDocsDescription(externalDocsDescription);
        return this;
    }

    @Override
    public TagDescriptionContractImpl withExternalDocsUrl(String externalDocsUrl) {
        this.createOrUpdateParameter.withExternalDocsUrl(externalDocsUrl);
        return this;
    }

}