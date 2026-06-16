package com.ucr.product_api.models;

import java.sql.Timestamp;

import jakarta.validation.constraints.NotNull;

public record AttendanceRequestModel(

    @NotNull(message = "El cliente es requerido")
    Integer clientId,

    @NotNull(message = "La fecha es requerida")
    Timestamp entryTime,

    String notes
) {
}
