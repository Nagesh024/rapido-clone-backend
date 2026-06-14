package com.rapido.driverservice.event;

import java.time.LocalDateTime;

public class RideRequestedEvent {

    private String eventId;
    private String rideId;
    private String userId;

    private double pickupLatitude;
    private double pickupLongitude;
    private double dropLatitude;
    private double dropLongitude;

    private String requestedAt;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getPickupLatitude() {
        return pickupLatitude;
    }

    public void setPickupLatitude(double pickupLatitude) {
        this.pickupLatitude = pickupLatitude;
    }

    public double getPickupLongitude() {
        return pickupLongitude;
    }

    public void setPickupLongitude(double pickupLongitude) {
        this.pickupLongitude = pickupLongitude;
    }

    public double getDropLatitude() {
        return dropLatitude;
    }

    public void setDropLatitude(double dropLatitude) {
        this.dropLatitude = dropLatitude;
    }

    public double getDropLongitude() {
        return dropLongitude;
    }

    public void setDropLongitude(double dropLongitude) {
        this.dropLongitude = dropLongitude;
    }

    public String getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(String requestedAt) {
        this.requestedAt = requestedAt;
    }
}