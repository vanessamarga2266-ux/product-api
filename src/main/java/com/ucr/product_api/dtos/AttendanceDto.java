package com.ucr.product_api.dtos;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * Objetos diseñados para transferir datos entre backend y frontend o entre capas internas sin exponer entidades.

Se usan diferentes DTOs para peticiones (request) y respuestas (response) para mayor control.

Aseguran que sólo la información necesaria viaje, optimizando y haciendo más seguro el API.
 */
public record AttendanceDto(
    UUID resourceId,
    Integer clientId,
    Timestamp entryTime,
    String notes
) {
}
