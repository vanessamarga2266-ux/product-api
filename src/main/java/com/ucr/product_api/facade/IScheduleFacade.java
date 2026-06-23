package com.ucr.product_api.facade;

import java.util.List;
import java.util.UUID;

import com.ucr.product_api.dtos.ScheduleDto;
import com.ucr.product_api.dtos.ScheduleRequestDto;

public interface IScheduleFacade {
    List<ScheduleDto> getAll();
    ScheduleDto create(ScheduleDto scheduleDto);
    ScheduleDto addSchedule(ScheduleRequestDto scheduleDto);
    ScheduleDto updateSchedule(UUID resourceId, ScheduleRequestDto scheduleDto);
    ScheduleDto getByResourceId(UUID resourceId);
    void removeSchedule(UUID resourceId);
}
