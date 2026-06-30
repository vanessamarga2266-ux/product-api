package com.ucr.product_api.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucr.product_api.Entities.Attendance;
/**
Interfaces que extienden JpaRepository, encapsulan el acceso a la base de datos.

Contienen métodos CRUD ya implementados y consultas personalizadas 

Separan la lógica de acceso a datos de la lógica de negocio.

Facilitan pruebas y mantenimiento al aislar detalles de interacción con la base. 
*/

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