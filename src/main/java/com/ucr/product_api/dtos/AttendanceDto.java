package com.ucr.product_api.dtos;

import java.sql.Timestamp;
import java.util.UUID;

public record AttendanceDto(
    UUID resourceId,
    Integer clientId,
    Timestamp entryTime,
    String notes
) {
}
