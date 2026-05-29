package com.ucr.product_api.Entities;

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
@Table(name = "clients")
 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
 
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(name = "User_id", nullable = false)
    private Integer userId;
 
    @Column(name = "Membership_id", nullable = false)
    private Integer membershipId;
 
    @Column(name = "Phone", length = 20)
    private String phone;
 
    @Column(name = "Next_payment_date", nullable = false)
    private Date nextPaymentDate;
 
    @Column(name = "Status", length = 20)
    private String status;
}