package com.ucr.product_api.Entities;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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
@Table(name = "users")
 
@Setter
@Getter
 
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_user_id", nullable = false)
    private Integer tipoUserId;
 
    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;
 
    @Column(name = "email", nullable = false, length = 100)
    private String email;
 
    @Column(name = "password", nullable = false, length = 255)
    private String password;
 
    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

     @Column(name = "resource_id", nullable = false, unique = true, length = 36)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID resourceId;
}