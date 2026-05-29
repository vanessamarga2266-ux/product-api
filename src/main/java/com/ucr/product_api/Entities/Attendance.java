package com.ucr.product_api.Entities;

import java.sql.Timestamp;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
 
@Entity
@Table(name = "attendance")
 
@Getter
@Setter
 
public class Attendance {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(name = "client_id", nullable = false)
    private Integer clientId;
 
    @Column(name = "entry_time", nullable = false)
    private Timestamp entryTime;
 
    @Column(name = "notes", length = 255)
    private String notes;
}