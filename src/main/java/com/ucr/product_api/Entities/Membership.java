package com.ucr.product_api.Entities;

import java.math.BigDecimal;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


import java.sql.Timestamp;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "memberships")
 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Membership {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(name = "name", nullable = false, length = 50)
    private String name;
 
    @Column(name = "descripcion", nullable = true, length = 500)
    private String description;
 
    @Column(name = "price", precision = 30, scale = 2, nullable = false)
    private BigDecimal price;
 
    @Column(name = "duration_days", nullable = false)
    private Integer durationDays;

     @Column(name = "resource_id", nullable = false, unique = true, length = 36)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID resourceId;
}
 