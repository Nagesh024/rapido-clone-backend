package com.rapido.analyticsservice.dto;

import java.math.BigDecimal;

public class DashboardResponse {

    private Long activeRides;
    private Long activeDrivers;
    private BigDecimal dailyRevenue;
    private Double rideSuccessRate;
    private Double averageEta;

    public Long getActiveRides() {
        return activeRides;
    }

    public void setActiveRides(Long activeRides) {
        this.activeRides = activeRides;
    }

    public Long getActiveDrivers() {
        return activeDrivers;
    }

    public void setActiveDrivers(Long activeDrivers) {
        this.activeDrivers = activeDrivers;
    }

    public BigDecimal getDailyRevenue() {
        return dailyRevenue;
    }

    public void setDailyRevenue(BigDecimal dailyRevenue) {
        this.dailyRevenue = dailyRevenue;
    }

    public Double getRideSuccessRate() {
        return rideSuccessRate;
    }

    public void setRideSuccessRate(Double rideSuccessRate) {
        this.rideSuccessRate = rideSuccessRate;
    }

    public Double getAverageEta() {
        return averageEta;
    }

    public void setAverageEta(Double averageEta) {
        this.averageEta = averageEta;
    }
}