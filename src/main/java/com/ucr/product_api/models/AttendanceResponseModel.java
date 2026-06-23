package com.ucr.product_api.models;

import java.sql.Timestamp;
import java.util.UUID;

public class AttendanceResponseModel {

    private UUID resourceId;
    private Integer clientId;
    private Timestamp entryTime;
    private String notes;

    public AttendanceResponseModel() {
    }

    public AttendanceResponseModel(UUID resourceId,
            Integer clientId,
            Timestamp entryTime,
            String notes) {

        this.resourceId = resourceId;
        this.clientId = clientId;
        this.entryTime = entryTime;
        this.notes = notes;
    }

    public UUID getResourceId() {
        return resourceId;
    }

    public void setResourceId(UUID resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Timestamp getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Timestamp entryTime) {
        this.entryTime = entryTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "AttendanceResponseModel [resourceId=" + resourceId + ", clientId=" + clientId
                + ", entryTime=" + entryTime + ", notes=" + notes + "]";
    }
}
