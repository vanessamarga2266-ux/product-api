package com.ucr.product_api.models;

import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ScheduleRequestModel(
    @NotNull(message = "El entrenador es requerido") Integer trainerId,
    @NotBlank(message = "El día de la semana es requerido") String dayWeek,
    @NotNull(message = "La hora de inicio es requerida") LocalTime startTime,
    @NotNull(message = "La hora de fin es requerida") LocalTime endTime
) {
}
