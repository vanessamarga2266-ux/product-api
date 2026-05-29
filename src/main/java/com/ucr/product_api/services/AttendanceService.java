package com.ucr.product_api.services;

import java.util.List;

import com.ucr.product_api.Entities.Attendance;
import com.ucr.product_api.repositories.AttendanceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AttendanceService implements IAttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public List<Attendance> getAll() {
        return attendanceRepository.findAll();
    }
}