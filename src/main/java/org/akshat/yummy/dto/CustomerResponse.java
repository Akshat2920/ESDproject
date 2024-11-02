package org.akshat.yummy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CustomerResponse (
        @JsonProperty("first_name")
        String firstName,

        @JsonProperty("last_name")
        String lastName,

        @JsonProperty("email")
        String email,

        @JsonProperty("address_line1")
        String addressLine1,

        @JsonProperty("address_line2")
        String addressLine2,

        @JsonProperty("city")
        String city,

        @JsonProperty("pincode")
        String pincode
) {
}
