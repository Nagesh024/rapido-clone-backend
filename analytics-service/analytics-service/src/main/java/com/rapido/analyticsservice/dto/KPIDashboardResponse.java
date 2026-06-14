package com.rapido.analyticsservice.dto;

import java.math.BigDecimal;

public class KPIDashboardResponse {

    private Long totalRides;
    private Long completedRides;
    private Long cancelledRides;
    private BigDecimal totalRevenue;
    private Double averageRideDuration;

    public Long getTotalRides() {
        return totalRides;
    }

    public void setTotalRides(Long totalRides) {
        this.totalRides = totalRides;
    }

    public Long getCompletedRides() {
        return completedRides;
    }

    public void setCompletedRides(Long completedRides) {
        this.completedRides = completedRides;
    }

    public Long getCancelledRides() {
        return cancelledRides;
    }

    public void setCancelledRides(Long cancelledRides) {
        this.cancelledRides = cancelledRides;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public Double getAverageRideDuration() {
        return averageRideDuration;
    }

    public void setAverageRideDuration(Double averageRideDuration) {
        this.averageRideDuration = averageRideDuration;
    }
}