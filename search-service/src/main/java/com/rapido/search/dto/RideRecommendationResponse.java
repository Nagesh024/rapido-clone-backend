package com.rapido.search.dto;

public class RideRecommendationResponse {

    private String pickup;
    private String destination;
    private String rideType;

    public RideRecommendationResponse() {}

    public RideRecommendationResponse(
            String pickup,
            String destination,
            String rideType) {

        this.pickup = pickup;
        this.destination = destination;
        this.rideType = rideType;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getRideType() {
        return rideType;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }
}