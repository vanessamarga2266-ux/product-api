package com.ucr.product_api.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucr.product_api.Entities.Schedule;
import com.ucr.product_api.dtos.ScheduleRequestDto;
import com.ucr.product_api.exceptions.ScheduleNotFoundException;
import com.ucr.product_api.repositories.ScheduleRepository;

@Service
public class ScheduleService implements IScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> getAll() {
        return scheduleRepository.getAll();
    }

    @Override
    public Schedule create(Schedule schedule) {
        if (schedule.getResourceId() == null) {
            schedule.setResourceId(UUID.randomUUID());
        }
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule addSchedule(ScheduleRequestDto scheduleDto) {
        var schedule = Schedule
        .builder()
        .trainerId(scheduleDto.getTrainerId())
        .dayWeek(scheduleDto.getDayWeek())
        .startTime(scheduleDto.getStartTime())
        .endTime(scheduleDto.getEndTime())
        .resourceId(UUID.randomUUID())
        .build();

        return scheduleRepository.addSchedule(schedule);
    }

    @Override
    public Schedule updateSchedule(UUID resourceId, ScheduleRequestDto scheduleDto) {
        var schedule = scheduleRepository.findByResourceId(resourceId)
        .orElseThrow(() -> new ScheduleNotFoundException("Schedule no encontrado"));

        schedule.setTrainerId(scheduleDto.getTrainerId());
        schedule.setDayWeek(scheduleDto.getDayWeek());
        schedule.setStartTime(scheduleDto.getStartTime());
        schedule.setEndTime(scheduleDto.getEndTime());

        return scheduleRepository.updateSchedule(schedule);
    }

    @Override
    public Schedule getByResourceId(UUID resourceId) {
        return scheduleRepository.findByResourceId(resourceId)
                .orElseThrow(() -> new ScheduleNotFoundException("Schedule no encontrado con resourceId"));
    }

    @Override
    public void removeSchedule(UUID resourceId) {
        var schedule = scheduleRepository.findByResourceId(resourceId)
                .orElseThrow(() -> new ScheduleNotFoundException("Schedule no encontrado"));

        scheduleRepository.delete(schedule);
    }
}
