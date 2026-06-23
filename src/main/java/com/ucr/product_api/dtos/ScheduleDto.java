package com.ucr.product_api.dtos;

import java.time.LocalTime;
import java.util.UUID;

public record ScheduleDto(
    UUID resourceId,
    Integer trainerId,
    String dayWeek,
    LocalTime startTime,
    LocalTime endTime
) {
}
