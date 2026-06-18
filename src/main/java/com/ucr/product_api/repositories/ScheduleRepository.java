package com.ucr.product_api.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.ucr.product_api.Entities.Schedule;
 
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    default List<Schedule> getAll() {
 
        return findAll();
    }

    default Schedule addSchedule(Schedule schedule){
        return save(schedule);
    }

    Optional<Schedule> findByResourceId(UUID resourceId);

    default Schedule updateSchedule(Schedule schedule){
        return save(schedule);
    };
}