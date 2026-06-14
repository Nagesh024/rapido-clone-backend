package com.rapido.paymentservice.event;

import java.io.Serializable;

public class RideAssignedEvent implements Serializable {

    private String rideId;
    private String driverId;
    private String userId;

    public RideAssignedEvent() {}

    public RideAssignedEvent(String rideId, String driverId, String userId) {
        this.rideId = rideId;
        this.driverId = driverId;
        this.userId = userId;
    }

    public String getRideId() { return rideId; }
    public void setRideId(String rideId) { this.rideId = rideId; }

    public String getDriverId() { return driverId; }
    public void setDriverId(String driverId) { this.driverId = driverId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
}