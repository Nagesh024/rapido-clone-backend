package com.rapido.adminservice.dashboard.dto;

public class DashboardSummaryResponse {

    private Long totalRides;
    private Long activeDrivers;
    private Long activeRiders;
    private Double dailyRevenue;
    private Long failedRides;
    private Long ongoingRides;

    public DashboardSummaryResponse(Long totalRides, Long activeDrivers, Long activeRiders,
                                    Double dailyRevenue, Long failedRides, Long ongoingRides) {
        this.totalRides = totalRides;
        this.activeDrivers = activeDrivers;
        this.activeRiders = activeRiders;
        this.dailyRevenue = dailyRevenue;
        this.failedRides = failedRides;
        this.ongoingRides = ongoingRides;
    }

    public Long getTotalRides() { return totalRides; }
    public Long getActiveDrivers() { return activeDrivers; }
    public Long getActiveRiders() { return activeRiders; }
    public Double getDailyRevenue() { return dailyRevenue; }
    public Long getFailedRides() { return failedRides; }
    public Long getOngoingRides() { return ongoingRides; }
}