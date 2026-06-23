package com.ucr.product_api.models;

import jakarta.validation.constraints.NotBlank;

public record UserRequestModel(
    @NotBlank(message = "El nombre es requerido") String name,
    @NotBlank(message = "El correo electrónico es requerido") String email,
    @NotBlank(message = "El teléfono es requerido") String phone,
    @NotBlank(message = "La contraseña es requerida") String password,
    Integer tipoUserId
) {
}