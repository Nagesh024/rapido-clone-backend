package com.rapido.analyticsservice.dto;

public class DriverUtilizationResponse {

    private Double onlineHours;
    private Double completedRideHours;
    private Double utilizationPercentage;

    public Double getOnlineHours() {
        return onlineHours;
    }

    public void setOnlineHours(Double onlineHours) {
        this.onlineHours = onlineHours;
    }

    public Double getCompletedRideHours() {
        return completedRideHours;
    }

    public void setCompletedRideHours(Double completedRideHours) {
        this.completedRideHours = completedRideHours;
    }

    public Double getUtilizationPercentage() {
        return utilizationPercentage;
    }

    public void setUtilizationPercentage(Double utilizationPercentage) {
        this.utilizationPercentage = utilizationPercentage;
    }
}