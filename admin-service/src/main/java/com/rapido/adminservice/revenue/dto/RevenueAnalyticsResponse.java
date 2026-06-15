package com.rapido.adminservice.revenue.dto;

public class RevenueAnalyticsResponse {

    private Double dailyRevenue;
    private Double weeklyRevenue;
    private Double monthlyRevenue;
    private Double driverPayouts;
    private Double platformCommission;

    public RevenueAnalyticsResponse(Double dailyRevenue, Double weeklyRevenue,
                                    Double monthlyRevenue, Double driverPayouts,
                                    Double platformCommission) {
        this.dailyRevenue = dailyRevenue;
        this.weeklyRevenue = weeklyRevenue;
        this.monthlyRevenue = monthlyRevenue;
        this.driverPayouts = driverPayouts;
        this.platformCommission = platformCommission;
    }

    public Double getDailyRevenue() { return dailyRevenue; }
    public Double getWeeklyRevenue() { return weeklyRevenue; }
    public Double getMonthlyRevenue() { return monthlyRevenue; }
    public Double getDriverPayouts() { return driverPayouts; }
    public Double getPlatformCommission() { return platformCommission; }
}