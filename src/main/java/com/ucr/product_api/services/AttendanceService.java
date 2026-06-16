package com.ucr.product_api.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucr.product_api.Entities.Attendance;
import com.ucr.product_api.dtos.AttendanceRequestDto;
import com.ucr.product_api.exceptions.AttendanceNotFoundException;
import com.ucr.product_api.repositories.AttendanceRepository;

@Service
public class AttendanceService implements IAttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public List<Attendance> getAll() {
        return attendanceRepository.getAll();
    }

    @Override
    public Attendance create(Attendance attendance) {

        if (attendance.getResourceId() == null) {
            attendance.setResourceId(UUID.randomUUID());
        }

        return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance addAttendance(AttendanceRequestDto dto) {

        Attendance attendance = new Attendance();

        attendance.setClientId(dto.getClientId());
        attendance.setEntryTime(dto.getEntryTime());
        attendance.setNotes(dto.getNotes());
        attendance.setResourceId(UUID.randomUUID());

        return attendanceRepository.addAttendance(attendance);
    }

    @Override
    public Attendance updateAttendance(
            UUID resourceId,
            AttendanceRequestDto dto) {

        var attendance = attendanceRepository
                .findByResourceId(resourceId)
                .orElseThrow(() -> new AttendanceNotFoundException(
                        "Attendance no encontrado"));

        attendance.setClientId(dto.getClientId());
        attendance.setEntryTime(dto.getEntryTime());
        attendance.setNotes(dto.getNotes());

        return attendanceRepository.updateAttendance(attendance);
    }

    @Override
    public Attendance getByResourceId(UUID resourceId) {

        return attendanceRepository.findByResourceId(resourceId)
                .orElseThrow(() -> new AttendanceNotFoundException(
                        "Attendance no encontrado"));
    }

    @Override
    public void removeAttendance(UUID resourceId) {

        var attendance = attendanceRepository
                .findByResourceId(resourceId)
                .orElseThrow(() -> new AttendanceNotFoundException(
                        "Attendance no encontrado"));

        attendanceRepository.delete(attendance);
    }
}