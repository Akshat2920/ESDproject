package org.akshat.yummy.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record ProductRequest (
    @NotNull(message = "Product should be present")
    @NotEmpty(message = "Product should be present")
    @NotBlank(message = "Product should be present")
    @JsonProperty("pname")
    String Name,

    @NotNull(message = "Product should be present")
    @NotEmpty(message = "Product should be present")
    @NotBlank(message = "Product should be present")
    @JsonProperty("price")
    String Price
){}
