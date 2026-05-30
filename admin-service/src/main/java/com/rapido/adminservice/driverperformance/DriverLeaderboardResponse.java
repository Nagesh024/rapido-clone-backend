package com.rapido.adminservice.driverperformance;

public class DriverLeaderboardResponse {

    private Long driverId;
    private String driverName;
    private Double performanceScore;
    private String region;

    public DriverLeaderboardResponse(Long driverId, String driverName,
                                     Double performanceScore, String region) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.performanceScore = performanceScore;
        this.region = region;
    }

    public Long getDriverId() { return driverId; }
    public String getDriverName() { return driverName; }
    public Double getPerformanceScore() { return performanceScore; }
    public String getRegion() { return region; }
}