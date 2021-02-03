/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_08_01;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for ExpressRouteLinkConnectorType.
 */
public final class ExpressRouteLinkConnectorType extends ExpandableStringEnum<ExpressRouteLinkConnectorType> {
    /** Static value LC for ExpressRouteLinkConnectorType. */
    public static final ExpressRouteLinkConnectorType LC = fromString("LC");

    /** Static value SC for ExpressRouteLinkConnectorType. */
    public static final ExpressRouteLinkConnectorType SC = fromString("SC");

    /**
     * Creates or finds a ExpressRouteLinkConnectorType from its string representation.
     * @param name a name to look for
     * @return the corresponding ExpressRouteLinkConnectorType
     */
    @JsonCreator
    public static ExpressRouteLinkConnectorType fromString(String name) {
        return fromString(name, ExpressRouteLinkConnectorType.class);
    }

    /**
     * @return known ExpressRouteLinkConnectorType values
     */
    public static Collection<ExpressRouteLinkConnectorType> values() {
        return values(ExpressRouteLinkConnectorType.class);
    }
}
