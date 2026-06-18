package com.ucr.product_api.dtos;

import java.sql.Timestamp;
import java.util.UUID;

public record ScheduleDto(
    UUID resourceId,
    String trainerId,
    String dayWeek,
    String startTime,
    String endTime
) {
}
