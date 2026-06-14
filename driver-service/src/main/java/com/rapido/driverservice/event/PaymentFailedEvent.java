package com.rapido.driverservice.event;

public class PaymentFailedEvent {

    private String rideId;
    private String driverId;
    private String reason;

    public PaymentFailedEvent() {
    }

    public PaymentFailedEvent(String rideId, String driverId, String reason) {
        this.rideId = rideId;
        this.driverId = driverId;
        this.reason = reason;
    }

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}