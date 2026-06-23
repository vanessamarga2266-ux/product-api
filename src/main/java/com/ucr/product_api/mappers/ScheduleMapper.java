package com.ucr.product_api.mappers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ucr.product_api.Entities.Schedule;
import com.ucr.product_api.dtos.ScheduleDto;
import com.ucr.product_api.dtos.ScheduleRequestDto;
import com.ucr.product_api.models.ScheduleRequestModel;
import com.ucr.product_api.models.ScheduleResponseModel;

@Component
public class ScheduleMapper {

    public ScheduleDto toScheduleDto(Schedule schedule) {
        if (schedule == null) {
            return null;
        }

        return new ScheduleDto(
                schedule.getResourceId(),
                schedule.getTrainerId(),
                schedule.getDayWeek(),
                schedule.getStartTime(),
                schedule.getEndTime());
    }

    public List<ScheduleDto> toScheduleDtoList(List<Schedule> schedules) {
        if (schedules == null) {
            return null;
        }

        return schedules.stream()
                .map(this::toScheduleDto)
                .collect(Collectors.toList());
    }

    public ScheduleResponseModel toScheduleResponseModel(ScheduleDto dto) {
        if (dto == null) {
            return null;
        }

        return new ScheduleResponseModel(
                dto.resourceId(),
                dto.trainerId(),
                dto.dayWeek(),
                dto.startTime(),
                dto.endTime());
    }

    public List<ScheduleResponseModel> toScheduleResponseModelList(List<ScheduleDto> dtos) {
        if (dtos == null) {
            return null;
        }

        return dtos.stream()
                .map(this::toScheduleResponseModel)
                .collect(Collectors.toList());
    }

    public ScheduleRequestDto toScheduleRequestDto(ScheduleRequestModel model) {
        if (model == null) {
            return null;
        }

        ScheduleRequestDto dto = new ScheduleRequestDto();
        dto.setTrainerId(model.trainerId());
        dto.setDayWeek(model.dayWeek());
        dto.setStartTime(model.startTime());
        dto.setEndTime(model.endTime());
        return dto;
    }

    public Schedule toScheduleEntity(ScheduleRequestDto dto) {
        if (dto == null) {
            return null;
        }

        return Schedule.builder()
        .trainerId(dto.getTrainerId())
        .dayWeek(dto.getDayWeek())
        .startTime(dto.getStartTime())
        .endTime(dto.getEndTime())
        .resourceId(UUID.randomUUID())
        .build();
    }
}
