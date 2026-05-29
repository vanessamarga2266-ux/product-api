package com.ucr.product_api.Entities;

import java.math.BigDecimal;
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
@Table(name = "payments")
 
@Getter
@Setter
 
public class Payment {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(name = "client_id", nullable = false)
    private Integer clientId;
 
    @Column(name = "amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;
 
    @Column(name = "payment_date", nullable = false)
    private Timestamp paymentDate;
 
    @Column(name = "payment_method", length = 30)
    private String paymentMethod;
 
    @Column(name = "status", length = 20)
    private String status;
}