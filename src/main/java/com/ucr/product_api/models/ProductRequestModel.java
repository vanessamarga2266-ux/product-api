package com.ucr.product_api.models;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequestModel(
    @NotBlank(message = "El nombre es requerido") String name,
    String description,
    @NotNull(message = "El precio es requerido") BigDecimal price
) {
}
