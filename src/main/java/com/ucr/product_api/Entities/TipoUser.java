package com.ucr.product_api.Entities;
 
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
@Table(name = "tipousers")
 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
 
public class TipoUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(name = "name", nullable = false, length = 50)
    private String name;
 
    @Column(name = "Membership_id", nullable = false)
    private Integer membershipId;
 
    @Column(name = "description", length = 150)
    private String description;
}