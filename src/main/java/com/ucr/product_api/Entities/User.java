package com.ucr.product_api.Entities;

import java.math.BigDecimal;
import java.sql.Date;

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
 
    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;
 
    @Column(name = "email", nullable = false, length = 50)
    private String email;
 
    @Column(name = "password", nullable = false, length = 255)
    private String password;
 
    @Column(name = "role", nullable = false, length = 25)
    private String role;
 
    @Column(name = "created_at", nullable = false)
    private Date createdAt;
}