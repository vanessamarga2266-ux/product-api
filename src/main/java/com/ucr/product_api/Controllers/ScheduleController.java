package com.ucr.product_api.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucr.product_api.dtos.ScheduleDto;
import com.ucr.product_api.facade.IScheduleFacade;
import com.ucr.product_api.mappers.ScheduleMapper;
import com.ucr.product_api.models.ScheduleRequestModel;
import com.ucr.product_api.models.ScheduleResponseModel;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    @Autowired
    private IScheduleFacade scheduleFacade;

    @Autowired
    private ScheduleMapper scheduleMapper;

    @GetMapping
    public ResponseEntity<List<ScheduleResponseModel>> findAll() {
        return ResponseEntity.ok(scheduleMapper.toScheduleResponseModelList(scheduleFacade.getAll()));
    }

    @PostMapping
    public ScheduleDto save(@RequestBody ScheduleRequestModel scheduleRequestModel) {
        var dto = scheduleMapper.toScheduleRequestDto(scheduleRequestModel);

        return scheduleFacade.addSchedule(dto);
    }

    @PutMapping(path = "/{resourceId}")
    public ScheduleDto update(@PathVariable("resourceId") UUID resourceId,
            @RequestBody ScheduleRequestModel scheduleRequestModel) {

        var dto = scheduleMapper.toScheduleRequestDto(scheduleRequestModel);

        return scheduleFacade.updateSchedule(resourceId, dto);
    }

    @GetMapping(path = "/{resourceId}")
    public ScheduleDto findById(@PathVariable("resourceId") UUID resourceId) {
        return scheduleFacade.getByResourceId(resourceId);
    }

    @DeleteMapping(path = "/{resourceId}")
    public void remove(@PathVariable("resourceId") UUID resourceId) {
        scheduleFacade.removeSchedule(resourceId);
    }
}
