package com.ucr.product_api.services;

import java.util.List;
import java.util.UUID;

import com.ucr.product_api.Entities.Attendance;
import com.ucr.product_api.dtos.AttendanceRequestDto;

public interface IAttendanceService {

    List<Attendance> getAll();

    Attendance create(Attendance attendance);

    Attendance addAttendance(AttendanceRequestDto attendanceDto);

    Attendance updateAttendance(UUID resourceId,
            AttendanceRequestDto attendanceDto);

    Attendance getByResourceId(UUID resourceId);

    void removeAttendance(UUID resourceId);
}