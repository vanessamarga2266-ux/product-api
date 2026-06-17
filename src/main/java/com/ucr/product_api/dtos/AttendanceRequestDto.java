package com.ucr.product_api.dtos;

import java.sql.Timestamp;

import lombok.Getter;
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
