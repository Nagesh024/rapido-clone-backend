package com.rapido.rideservice.event;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RideEventConsumer {

    @KafkaListener(topics = "ride-requested", groupId = "ride-service-group")
    public void consumeRideRequested(RideRequestedEvent event) {

        System.out.println("📩 EVENT RECEIVED");
        System.out.println("Ride ID: " + event.getRideId());
        System.out.println("User ID: " + event.getUserId());
        System.out.println("Pickup Lat: " + event.getPickupLatitude());
    }
}