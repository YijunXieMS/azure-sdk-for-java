// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.compute;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for StorageAccountType. */
public final class StorageAccountType extends ExpandableStringEnum<StorageAccountType> {
    /** Static value Standard_LRS for StorageAccountType. */
    public static final StorageAccountType STANDARD_LRS = fromString("Standard_LRS");

    /** Static value Standard_ZRS for StorageAccountType. */
    public static final StorageAccountType STANDARD_ZRS = fromString("Standard_ZRS");

    /**
     * Creates or finds a StorageAccountType from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding StorageAccountType.
     */
    @JsonCreator
    public static StorageAccountType fromString(String name) {
        return fromString(name, StorageAccountType.class);
    }

    /** @return known StorageAccountType values. */
    public static Collection<StorageAccountType> values() {
        return values(StorageAccountType.class);
    }
}
