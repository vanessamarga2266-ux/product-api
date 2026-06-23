package com.ucr.product_api.models;

import java.time.LocalTime;
import java.util.UUID;

public class ScheduleResponseModel {

    private UUID resourceId;
    private Integer trainerId;
    private String dayWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public ScheduleResponseModel() {
    }

    public ScheduleResponseModel(UUID resourceId, Integer trainerId, String dayWeek, LocalTime startTime,
            LocalTime endTime) {
        this.resourceId = resourceId;
        this.trainerId = trainerId;
        this.dayWeek = dayWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public UUID getResourceId() {
        return resourceId;
    }

    public void setResourceId(UUID resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    public String getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(String dayWeek) {
        this.dayWeek = dayWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "ScheduleResponseModel [resourceId=" + resourceId + ", trainerId=" + trainerId + ", dayWeek="
                + dayWeek + ", startTime=" + startTime + ", endTime=" + endTime + "]";
    }
}
