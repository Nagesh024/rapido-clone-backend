package com.rapido.analyticsservice.dto;

import java.math.BigDecimal;

public class MonthlyAnalyticsResponse {

    private BigDecimal monthlyRevenue;
    private Long monthlyRideCount;

    public BigDecimal getMonthlyRevenue() {
        return monthlyRevenue;
    }

    public void setMonthlyRevenue(BigDecimal monthlyRevenue) {
        this.monthlyRevenue = monthlyRevenue;
    }

    public Long getMonthlyRideCount() {
        return monthlyRideCount;
    }

    public void setMonthlyRideCount(Long monthlyRideCount) {
        this.monthlyRideCount = monthlyRideCount;
    }
}