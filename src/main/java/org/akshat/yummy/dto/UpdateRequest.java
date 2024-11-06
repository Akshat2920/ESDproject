package org.akshat.yummy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record UpdateRequest
        (
                @Size(min = 1, max = 1)
                @JsonProperty("firstname")
                String firstName,

                @JsonProperty("lastname")
                String lastName,

                //@JsonProperty("email")
                //String email,

                //@NotNull(message = "Password should be present")
                //@NotEmpty(message = "Password should be present")
                //@NotBlank(message = "Password should be present")
                //@Size(min = 6, max = 12)
                //@JsonProperty("password")
                //String password,


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
