package com.rapido.authserver.model;

public class Ride {

    private Long rideId;
    private String driverUsername;
    private String riderUsername;

    public Ride(Long rideId, String driverUsername, String riderUsername) {
        this.rideId = rideId;
        this.driverUsername = driverUsername;
        this.riderUsername = riderUsername;
    }

    public Long getRideId() {
        return rideId;
    }

    public String getDriverUsername() {
        return driverUsername;
    }

    public String getRiderUsername() {
        return riderUsername;
    }
}