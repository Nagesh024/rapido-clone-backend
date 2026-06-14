package com.rapido.driverservice.event;

import java.io.Serializable;

public class RideAssignedEvent implements Serializable {

    private String rideId;
    private String driverId;
    private String status;

    // default constructor (required for Kafka deserialization)
    public RideAssignedEvent() {
    }

    public RideAssignedEvent(String rideId, String driverId, String status) {
        this.rideId = rideId;
        this.driverId = driverId;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}