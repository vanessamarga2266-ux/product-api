package com.ucr.product_api.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucr.product_api.Entities.Attendance;

@Repository
public interface AttendanceRepository
        extends JpaRepository<Attendance, Long> {

    Optional<Attendance> findByResourceId(UUID resourceId);

    default List<Attendance> getAll() {
        return findAll();
    }

    default Attendance addAttendance(Attendance attendance) {
        return save(attendance);
    }

    default Attendance updateAttendance(Attendance attendance) {
        return save(attendance);
    }
}