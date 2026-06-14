package com.rapido.rideservice.event;

import java.time.LocalDateTime;

public class RideRequestedEvent {

    private String eventId;
    private String rideId;
    private String userId;

    private Double pickupLatitude;
    private Double pickupLongitude;

    private Double dropLatitude;
    private Double dropLongitude;

    private LocalDateTime requestedAt;

    // Constructor
    public RideRequestedEvent() {
    }

    public RideRequestedEvent(String eventId, String rideId, String userId,
                              Double pickupLatitude, Double pickupLongitude,
                              Double dropLatitude, Double dropLongitude,
                              LocalDateTime requestedAt) {
        this.eventId = eventId;
        this.rideId = rideId;
        this.userId = userId;
        this.pickupLatitude = pickupLatitude;
        this.pickupLongitude = pickupLongitude;
        this.dropLatitude = dropLatitude;
        this.dropLongitude = dropLongitude;
        this.requestedAt = requestedAt;
    }

    // Getters and Setters

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

    public Double getPickupLatitude() {
        return pickupLatitude;
    }

    public void setPickupLatitude(Double pickupLatitude) {
        this.pickupLatitude = pickupLatitude;
    }

    public Double getPickupLongitude() {
        return pickupLongitude;
    }

    public void setPickupLongitude(Double pickupLongitude) {
        this.pickupLongitude = pickupLongitude;
    }

    public Double getDropLatitude() {
        return dropLatitude;
    }

    public void setDropLatitude(Double dropLatitude) {
        this.dropLatitude = dropLatitude;
    }

    public Double getDropLongitude() {
        return dropLongitude;
    }

    public void setDropLongitude(Double dropLongitude) {
        this.dropLongitude = dropLongitude;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(LocalDateTime requestedAt) {
        this.requestedAt = requestedAt;
    }
}