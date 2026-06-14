package com.rapido.search.dto;

public class RideAnalyticsResponse {

    private long totalRides;
    private String mostVisitedLocation;

    public RideAnalyticsResponse() {}

    public RideAnalyticsResponse(
            long totalRides,
            String mostVisitedLocation) {

        this.totalRides = totalRides;
        this.mostVisitedLocation = mostVisitedLocation;
    }

    public long getTotalRides() {
        return totalRides;
    }

    public void setTotalRides(long totalRides) {
        this.totalRides = totalRides;
    }

    public String getMostVisitedLocation() {
        return mostVisitedLocation;
    }

    public void setMostVisitedLocation(
            String mostVisitedLocation) {
        this.mostVisitedLocation = mostVisitedLocation;
    }
}