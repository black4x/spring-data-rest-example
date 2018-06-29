/*
 * Copyright (C) Tamedia AG 2018
 */

package com.example.tenant.model.type;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SectionType {
    /**
     * created by user temporary.
     */
    @JsonProperty("temporary") TEMPORARY,
    /**
     * only admins can codify.
     */
    @JsonProperty("permanent") PERMANENT,
    /**
     * Must exist for every category.
     * Can be just one default;
     * impossible to delete;
     */
    @JsonProperty("default") DEFAULT
}
