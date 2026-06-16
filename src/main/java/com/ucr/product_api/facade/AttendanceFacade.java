package com.ucr.product_api.facade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucr.product_api.dtos.AttendanceDto;
import com.ucr.product_api.dtos.AttendanceRequestDto;
import com.ucr.product_api.mappers.AttendanceMapper;
import com.ucr.product_api.services.IAttendanceService;

import jakarta.transaction.Transactional;

@Component
public class AttendanceFacade implements IAttendanceFacade {

    @Autowired
    private IAttendanceService attendanceService;

    @Autowired
    private AttendanceMapper attendanceMapper;

    @Override
    public List<AttendanceDto> getAll() {
        return attendanceMapper
                .toAttendanceDtoList(attendanceService.getAll());
    }

    @Override
    public AttendanceDto create(AttendanceDto dto) {

        var entity =
                attendanceMapper.toAttendanceEntity(dto);

        var saved =
                attendanceService.create(entity);

        return attendanceMapper.toAttendanceDto(saved);
    }

    @Override
    public AttendanceDto addAttendance(
            AttendanceRequestDto dto) {

        var entity =
                attendanceService.addAttendance(dto);

        return attendanceMapper.toAttendanceDto(entity);
    }

    @Override
    @Transactional
    public AttendanceDto updateAttendance(
            UUID resourceId,
            AttendanceRequestDto dto) {

        var entity =
                attendanceService.updateAttendance(
                        resourceId,
                        dto);

        return attendanceMapper.toAttendanceDto(entity);
    }

    @Override
    public AttendanceDto getByResourceId(UUID resourceId) {

        var entity =
                attendanceService.getByResourceId(resourceId);

        return attendanceMapper.toAttendanceDto(entity);
    }

    @Override
    @Transactional
    public void removeAttendance(UUID resourceId) {
        attendanceService.removeAttendance(resourceId);
    }
}