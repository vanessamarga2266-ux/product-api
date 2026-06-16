package com.ucr.product_api.mappers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ucr.product_api.Entities.Attendance;
import com.ucr.product_api.dtos.AttendanceDto;
import com.ucr.product_api.dtos.AttendanceRequestDto;
import com.ucr.product_api.models.AttendanceRequestModel;
import com.ucr.product_api.models.AttendanceResponseModel;

@Component
public class AttendanceMapper {

    public AttendanceDto toAttendanceDto(Attendance attendance) {

        if (attendance == null) {
            return null;
        }

        return new AttendanceDto(
                attendance.getResourceId(),
                attendance.getClientId(),
                attendance.getEntryTime(),
                attendance.getNotes());
    }

    public List<AttendanceDto> toAttendanceDtoList(
            List<Attendance> attendances) {

        if (attendances == null) {
            return null;
        }

        return attendances.stream()
                .map(this::toAttendanceDto)
                .collect(Collectors.toList());
    }

    public AttendanceResponseModel toAttendanceResponseModel(
            AttendanceDto dto) {

        if (dto == null) {
            return null;
        }

        return new AttendanceResponseModel(
                dto.resourceId(),
                dto.clientId(),
                dto.entryTime(),
                dto.notes());
    }

    public List<AttendanceResponseModel> toAttendanceResponseModelList(
            List<AttendanceDto> dtos) {

        if (dtos == null) {
            return null;
        }

        return dtos.stream()
                .map(this::toAttendanceResponseModel)
                .collect(Collectors.toList());
    }

    public AttendanceRequestDto toAttendanceRequestDto(
            AttendanceRequestModel model) {

        if (model == null) {
            return null;
        }

        AttendanceRequestDto dto = new AttendanceRequestDto();

        dto.setClientId(model.clientId());
        dto.setEntryTime(model.entryTime());
        dto.setNotes(model.notes());

        return dto;
    }

    public Attendance toAttendanceEntity(
            AttendanceDto dto) {

        if (dto == null) {
            return null;
        }

        Attendance attendance = new Attendance();

        attendance.setClientId(dto.clientId());
        attendance.setEntryTime(dto.entryTime());
        attendance.setNotes(dto.notes());

        UUID resourceId =
                dto.resourceId() == null
                        ? UUID.randomUUID()
                        : dto.resourceId();

        attendance.setResourceId(resourceId);

        return attendance;
    }
}
