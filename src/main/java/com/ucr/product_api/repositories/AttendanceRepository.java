package com.ucr.product_api.repositories;

import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.ucr.product_api.Entities.Attendance;
 
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    default List<Attendance> getAll() {
 
        return findAll();
    }
}