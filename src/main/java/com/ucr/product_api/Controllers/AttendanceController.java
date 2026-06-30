package com.ucr.product_api.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucr.product_api.dtos.AttendanceDto;
import com.ucr.product_api.facade.IAttendanceFacade;
import com.ucr.product_api.mappers.AttendanceMapper;
import com.ucr.product_api.models.AttendanceRequestModel;
import com.ucr.product_api.models.AttendanceResponseModel;
/**
Exponen los endpoints REST para que los clientes (frontend, apps) consuman la API.
 
Validan datos de entrada mínimos y devuelven respuestas con códigos HTTP apropiados.

Dependen de la fachada para la lógica, manteniendo el controlador ligero.

Manejan rutas organizadas para cada recurso de la aplicación.

 */
@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private IAttendanceFacade attendanceFacade;

    @Autowired
    private AttendanceMapper attendanceMapper;

    @GetMapping
    public ResponseEntity<List<AttendanceResponseModel>> findAll() {

        return ResponseEntity.ok(
                attendanceMapper.toAttendanceResponseModelList(
                        attendanceFacade.getAll()));
    }

    @PostMapping
    public AttendanceDto save(
            @RequestBody AttendanceRequestModel attendanceRequestModel) {

        var dto =
                attendanceMapper.toAttendanceRequestDto(
                        attendanceRequestModel);

        return attendanceFacade.addAttendance(dto);
    }

    @PutMapping("/{resourceId}")
    public AttendanceDto update(
            @PathVariable("resourceId") UUID resourceId,
            @RequestBody AttendanceRequestModel attendanceRequestModel) {

        var dto =
                attendanceMapper.toAttendanceRequestDto(
                        attendanceRequestModel);

        return attendanceFacade.updateAttendance(
                resourceId,
                dto);
    }

    @GetMapping("/{resourceId}")
    public AttendanceDto findById(
            @PathVariable("resourceId") UUID resourceId) {

        return attendanceFacade.getByResourceId(resourceId);
    }

    @DeleteMapping("/{resourceId}")
    public void remove(
            @PathVariable("resourceId") UUID resourceId) {

        attendanceFacade.removeAttendance(resourceId);
    }
}
