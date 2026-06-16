package com.ucr.product_api.facade;

import java.util.List;
import java.util.UUID;

import com.ucr.product_api.dtos.AttendanceDto;
import com.ucr.product_api.dtos.AttendanceRequestDto;

public interface IAttendanceFacade {

    List<AttendanceDto> getAll();

    AttendanceDto create(AttendanceDto attendanceDto);

    AttendanceDto addAttendance(
            AttendanceRequestDto attendanceDto);

    AttendanceDto updateAttendance(
            UUID resourceId,
            AttendanceRequestDto attendanceDto);

    AttendanceDto getByResourceId(UUID resourceId);

    void removeAttendance(UUID resourceId);
}
