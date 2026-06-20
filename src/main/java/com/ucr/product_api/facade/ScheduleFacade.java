package com.ucr.product_api.facade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucr.product_api.Entities.Schedule;
import com.ucr.product_api.dtos.ScheduleDto;
import com.ucr.product_api.dtos.ScheduleRequestDto;
import com.ucr.product_api.mappers.ScheduleMapper;
import com.ucr.product_api.services.IScheduleService;

import jakarta.transaction.Transactional;

@Component
public class ScheduleFacade implements IScheduleFacade {

    @Autowired
    private IScheduleService scheduleService;

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public List<ScheduleDto> getAll() {
        return scheduleMapper.toScheduleDtoList(scheduleService.getAll());
    }

    @Override
    public ScheduleDto create(ScheduleDto scheduleDto) {
        Schedule schedule = Schedule.builder()
                .trainerId(scheduleDto.trainerId())
                .dayWeek(scheduleDto.dayWeek())
                .startTime(scheduleDto.startTime())
                .endTime(scheduleDto.endTime())
                .resourceId(scheduleDto.resourceId() == null ? UUID.randomUUID() : scheduleDto.resourceId())
                .build();

        Schedule saved = scheduleService.create(schedule);

        return scheduleMapper.toScheduleDto(saved);
    }

    @Override
    public ScheduleDto addSchedule(ScheduleRequestDto scheduleDto) {
        var entity = scheduleService.addSchedule(scheduleDto);
        return scheduleMapper.toScheduleDto(entity);
    }

    @Override
    @Transactional
    public ScheduleDto updateSchedule(UUID resourceId, ScheduleRequestDto scheduleDto) {
        var entity = scheduleService.updateSchedule(resourceId, scheduleDto);
        return scheduleMapper.toScheduleDto(entity);
    }

    @Override
    public ScheduleDto getByResourceId(UUID resourceId) {
        var entity = scheduleService.getByResourceId(resourceId);
        return scheduleMapper.toScheduleDto(entity);
    }

    @Override
    @Transactional
    public void removeSchedule(UUID resourceId) {
        scheduleService.removeSchedule(resourceId);
    }
}
