package com.rapido.adminservice.driverperformance;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DriverPerformance {

    @Id
    private Long driverId;

    private Double averageRating;

    private Integer completedRides;

    private Integer cancelledRides;

    private Double acceptanceRate;

    private Double earnings;

    private Double performanceScore;

    public DriverPerformance() {
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Integer getCompletedRides() {
        return completedRides;
    }

    public void setCompletedRides(Integer completedRides) {
        this.completedRides = completedRides;
    }

    public Integer getCancelledRides() {
        return cancelledRides;
    }

    public void setCancelledRides(Integer cancelledRides) {
        this.cancelledRides = cancelledRides;
    }

    public Double getAcceptanceRate() {
        return acceptanceRate;
    }

    public void setAcceptanceRate(Double acceptanceRate) {
        this.acceptanceRate = acceptanceRate;
    }

    public Double getEarnings() {
        return earnings;
    }

    public void setEarnings(Double earnings) {
        this.earnings = earnings;
    }

    public Double getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(Double performanceScore) {
        this.performanceScore = performanceScore;
    }
}