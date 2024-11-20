package org.akshat.yummy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record CustomerUpdate
        (
                @Size(min = 1)
                @JsonProperty("firstname")
                String firstName,

                @JsonProperty("lastname")
                String lastName,

                @JsonProperty("addresslineone")
                String addressLine1,

                @JsonProperty("addresslinetwo")
                String addressLine2,

                @JsonProperty("city")
                String city,

                @Size(min = 6, max = 6)
                @JsonProperty("pincode")
                String pincode
        ){
}
