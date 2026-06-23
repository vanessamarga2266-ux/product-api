package com.ucr.product_api.services;

import java.util.List;
import java.util.UUID;

import com.ucr.product_api.Entities.Schedule;
import com.ucr.product_api.dtos.ScheduleRequestDto;

public interface IScheduleService{
    List<Schedule> getAll();

    public Schedule create(Schedule schedule);

    Schedule addSchedule(ScheduleRequestDto scheduleDto);

    Schedule updateSchedule(UUID resourceId, ScheduleRequestDto scheduleDto);

    Schedule getByResourceId (UUID resourceId);

    void removeSchedule(UUID resourceId);
}