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

    // getters y setters
}
