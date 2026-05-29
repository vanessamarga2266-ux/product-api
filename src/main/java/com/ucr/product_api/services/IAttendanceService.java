package com.ucr.product_api.services;

import java.util.List;

import com.ucr.product_api.Entities.Attendance;

public interface IAttendanceService {
    List<Attendance> getAll();
}