package com.ucr.product_api.Entities;

import java.sql.Timestamp;
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
/**
 Representan las tablas de base de datos con objetos Java usando JPA/Hibernate.
Cada entidad mapea atributos a columnas.
Facilitan la persistencia y recuperación de datos en forma de objetos
Uso de UUID como identificador único global aumenta seguridad y escalabilidad.
 */


@Entity
@Table(name = "attendance")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @Column(name = "resource_id", nullable = false, unique = true, length = 36)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID resourceId;
}