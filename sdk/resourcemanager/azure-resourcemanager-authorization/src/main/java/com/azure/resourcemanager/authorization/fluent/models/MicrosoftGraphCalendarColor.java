// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.authorization.fluent.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for MicrosoftGraphCalendarColor. */
public final class MicrosoftGraphCalendarColor extends ExpandableStringEnum<MicrosoftGraphCalendarColor> {
    /** Static value auto for MicrosoftGraphCalendarColor. */
    public static final MicrosoftGraphCalendarColor AUTO = fromString("auto");

    /** Static value lightBlue for MicrosoftGraphCalendarColor. */
    public static final MicrosoftGraphCalendarColor LIGHT_BLUE = fromString("lightBlue");

    /** Static value lightGreen for MicrosoftGraphCalendarColor. */
    public static final MicrosoftGraphCalendarColor LIGHT_GREEN = fromString("lightGreen");

    /** Static value lightOrange for MicrosoftGraphCalendarColor. */
    public static final MicrosoftGraphCalendarColor LIGHT_ORANGE = fromString("lightOrange");

    /** Static value lightGray for MicrosoftGraphCalendarColor. */
    public static final MicrosoftGraphCalendarColor LIGHT_GRAY = fromString("lightGray");

    /** Static value lightYellow for MicrosoftGraphCalendarColor. */
    public static final MicrosoftGraphCalendarColor LIGHT_YELLOW = fromString("lightYellow");

    /** Static value lightTeal for MicrosoftGraphCalendarColor. */
    public static final MicrosoftGraphCalendarColor LIGHT_TEAL = fromString("lightTeal");

    /** Static value lightPink for MicrosoftGraphCalendarColor. */
    public static final MicrosoftGraphCalendarColor LIGHT_PINK = fromString("lightPink");

    /** Static value lightBrown for MicrosoftGraphCalendarColor. */
    public static final MicrosoftGraphCalendarColor LIGHT_BROWN = fromString("lightBrown");

    /** Static value lightRed for MicrosoftGraphCalendarColor. */
    public static final MicrosoftGraphCalendarColor LIGHT_RED = fromString("lightRed");

    /** Static value maxColor for MicrosoftGraphCalendarColor. */
    public static final MicrosoftGraphCalendarColor MAX_COLOR = fromString("maxColor");

    /**
     * Creates or finds a MicrosoftGraphCalendarColor from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding MicrosoftGraphCalendarColor.
     */
    @JsonCreator
    public static MicrosoftGraphCalendarColor fromString(String name) {
        return fromString(name, MicrosoftGraphCalendarColor.class);
    }

    /** @return known MicrosoftGraphCalendarColor values. */
    public static Collection<MicrosoftGraphCalendarColor> values() {
        return values(MicrosoftGraphCalendarColor.class);
    }
}
