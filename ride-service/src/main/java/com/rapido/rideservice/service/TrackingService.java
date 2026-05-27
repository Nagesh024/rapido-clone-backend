package com.rapido.rideservice.service;

import com.rapido.rideservice.dto.DriverLocationEvent;
import com.rapido.rideservice.dto.RideStatusEvent;
import com.rapido.rideservice.util.GeoUtil;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TrackingService {

    private final SimpMessagingTemplate messagingTemplate;

    public TrackingService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void processLocation(DriverLocationEvent event) {

        validateLocation(event);

        event.setTimestamp(LocalDateTime.now());

        // Example destination coordinates
        double destinationLat = 17.3850;
        double destinationLng = 78.4867;

        double distance = GeoUtil.calculateDistanceKm(
                event.getLatitude(),
                event.getLongitude(),
                destinationLat,
                destinationLng
        );

        double eta = GeoUtil.calculateEtaMinutes(distance, 30);
        event.setEtaMinutes(eta);

        messagingTemplate.convertAndSend(
                "/topic/ride/" + event.getRideId(),
                event
        );

        System.out.println("Location broadcasted for ride: " + event.getRideId());
    }

    public void publishRideStatus(RideStatusEvent event) {

        event.setTimestamp(LocalDateTime.now());

        messagingTemplate.convertAndSend(
                "/topic/ride-status/" + event.getRideId(),
                event
        );

        System.out.println("Ride status pushed: " + event.getStatus());
    }

    private void validateLocation(DriverLocationEvent event) {

        if (event.getRideId() == null || event.getDriverId() == null) {
            throw new RuntimeException("Ride ID and Driver ID are required");
        }

        if (event.getLatitude() == null || event.getLongitude() == null) {
            throw new RuntimeException("Latitude and Longitude are required");
        }

        if (event.getLatitude() < -90 || event.getLatitude() > 90) {
            throw new RuntimeException("Invalid latitude");
        }

        if (event.getLongitude() < -180 || event.getLongitude() > 180) {
            throw new RuntimeException("Invalid longitude");
        }
    }
}