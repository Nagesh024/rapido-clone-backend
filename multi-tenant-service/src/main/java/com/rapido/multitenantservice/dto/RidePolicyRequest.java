package com.rapido.multitenantservice.dto;

public class RidePolicyRequest {

    private String rideType;
    private Double baseFare;
    private Double maxDistance;
    private Double cancellationFee;
    private Boolean active;

    public String getRideType() {
        return rideType;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }

    public Double getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(Double baseFare) {
        this.baseFare = baseFare;
    }

    public Double getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(Double maxDistance) {
        this.maxDistance = maxDistance;
    }

    public Double getCancellationFee() {
        return cancellationFee;
    }

    public void setCancellationFee(Double cancellationFee) {
        this.cancellationFee = cancellationFee;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}