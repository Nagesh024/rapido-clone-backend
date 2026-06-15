package com.rapido.analyticsservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "dim_drivers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DimDriver {

    @Id
    @Column(name = "driver_id")
    private Long driverId;

    @Column(name = "driver_name")
    private String driverName;

    private String city;

    @Column(name = "vehicle_type")
    private String vehicleType;

    private BigDecimal rating;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}