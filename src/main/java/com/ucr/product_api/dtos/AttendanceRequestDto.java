package com.ucr.product_api.dtos;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceRequestDto {

    private Integer clientId;
    private Timestamp entryTime;
    private String notes;
}
