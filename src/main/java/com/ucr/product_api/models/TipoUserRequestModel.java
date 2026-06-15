package com.ucr.product_api.models;

import jakarta.validation.constraints.NotBlank;

public record TipoUserRequestModel(
    @NotBlank(message = "El nombre es requerido") String name,
    String description
) {
}