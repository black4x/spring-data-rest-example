package com.example.tenant.model.type;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum CategoryType {

    /**
     * Can be deleted by power user.
     */
    @JsonProperty("temporary") TEMPORARY,

    /**
     * Impossible to delete.
     */
    @JsonProperty("permanent") PERMANENT

}
