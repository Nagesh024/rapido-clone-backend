package com.rapido.analyticsservice.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "fact_rides")
public class FactRide {

    @Id
    @Column(name = "ride_id")
    private Long rideId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private DimUser user;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private DimDriver driver;

    @ManyToOne
    @JoinColumn(name = "pickup_location_id")
    private DimLocation pickupLocation;

    @ManyToOne
    @JoinColumn(name = "drop_location_id")
    private DimLocation dropLocation;

    private BigDecimal fare;

    private BigDecimal distance;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;

    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public FactRide() {
    }

    public Long getRideId() {
        return rideId;
    }

    public void setRideId(Long rideId) {
        this.rideId = rideId;
    }

    public DimUser getUser() {
        return user;
    }

    public void setUser(DimUser user) {
        this.user = user;
    }

    public DimDriver getDriver() {
        return driver;
    }

    public void setDriver(DimDriver driver) {
        this.driver = driver;
    }

    public DimLocation getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(DimLocation pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public DimLocation getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(DimLocation dropLocation) {
        this.dropLocation = dropLocation;
    }

    public BigDecimal getFare() {
        return fare;
    }

    public void setFare(BigDecimal fare) {
        this.fare = fare;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}