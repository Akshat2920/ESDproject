package org.akshat.yummy.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record ProductUpdate (
        @JsonProperty("Name")
        String Name,

        @JsonProperty("price")
        String Price
){}
