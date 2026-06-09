package com.rapido.rideservice.service;

import com.rapido.rideservice.dto.RideRequestDTO;
import com.rapido.rideservice.event.RideEventProducer;
import com.rapido.rideservice.event.RideRequestedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class RideService {

    @Autowired
    private RideEventProducer rideEventProducer;

    public String requestRide(RideRequestDTO requestDTO) {

        // 1. Create Ride ID
        String rideId = UUID.randomUUID().toString();

        // 2. Create Event
        RideRequestedEvent event = new RideRequestedEvent();

        event.setEventId(UUID.randomUUID().toString());
        event.setRideId(rideId);
        event.setUserId(requestDTO.getUserId());

        event.setPickupLatitude(requestDTO.getPickupLatitude());
        event.setPickupLongitude(requestDTO.getPickupLongitude());

        event.setDropLatitude(requestDTO.getDropLatitude());
        event.setDropLongitude(requestDTO.getDropLongitude());

        event.setRequestedAt(LocalDateTime.now());

        // 3. Publish to Kafka
        rideEventProducer.publishRideRequested(event);
        System.out.println("🔥 SERVICE HIT");
        return rideId;
    }
}