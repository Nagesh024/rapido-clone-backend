package com.rapido.rideservice.dto;
public class CreateRideRequest {

    private String pickupLocation;
    private String dropLocation;
    private String userEmail;

    public CreateRideRequest() {
    }

    public CreateRideRequest(String pickupLocation, String dropLocation, String userEmail) {
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.userEmail = userEmail;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}