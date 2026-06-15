package com.rapido.analyticsservice.dto;

public class HeatmapResponse {

    private Double latitude;
    private Double longitude;
    private Long rideCount;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getRideCount() {
        return rideCount;
    }

    public void setRideCount(Long rideCount) {
        this.rideCount = rideCount;
    }
}