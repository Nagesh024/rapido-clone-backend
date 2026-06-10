package com.rapido.analyticsservice.dto;

import java.math.BigDecimal;

public class WeeklyAnalyticsResponse {

    private BigDecimal weeklyRevenue;
    private Long weeklyRideCount;

    public BigDecimal getWeeklyRevenue() {
        return weeklyRevenue;
    }

    public void setWeeklyRevenue(BigDecimal weeklyRevenue) {
        this.weeklyRevenue = weeklyRevenue;
    }

    public Long getWeeklyRideCount() {
        return weeklyRideCount;
    }

    public void setWeeklyRideCount(Long weeklyRideCount) {
        this.weeklyRideCount = weeklyRideCount;
    }
}