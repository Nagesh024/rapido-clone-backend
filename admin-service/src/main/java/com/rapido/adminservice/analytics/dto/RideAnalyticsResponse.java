package com.rapido.adminservice.analytics.dto;

public class RideAnalyticsResponse {

    private Long dailyRides;
    private String peakBookingHour;
    private Long cancelledRides;
    private String topArea;

    public RideAnalyticsResponse(Long dailyRides,
                                 String peakBookingHour,
                                 Long cancelledRides,
                                 String topArea) {
        this.dailyRides = dailyRides;
        this.peakBookingHour = peakBookingHour;
        this.cancelledRides = cancelledRides;
        this.topArea = topArea;
    }

    public Long getDailyRides() {
        return dailyRides;
    }

    public String getPeakBookingHour() {
        return peakBookingHour;
    }

    public Long getCancelledRides() {
        return cancelledRides;
    }

    public String getTopArea() {
        return topArea;
    }
}