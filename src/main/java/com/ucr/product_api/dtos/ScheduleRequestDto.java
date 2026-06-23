package com.ucr.product_api.dtos;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleRequestDto {
    private Integer trainerId;

    private String dayWeek;

    private LocalTime startTime;

    private LocalTime endTime;
}
