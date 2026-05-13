package com.rapido.rideservice.controller;

import com.rapido.rideservice.dto.ApiResponse;
import com.rapido.rideservice.entity.DriverLocationHistory;
import com.rapido.rideservice.entity.RideStatusHistory;
import com.rapido.rideservice.repository.DriverLocationHistoryRepository;
import com.rapido.rideservice.repository.RideStatusHistoryRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class TrackingController {

    private static final Logger log = LoggerFactory.getLogger(TrackingController.class);

    private final SimpMessagingTemplate messagingTemplate;
    private final DriverLocationHistoryRepository historyRepository;
    private final RideStatusHistoryRepository statusHistoryRepository;

    public TrackingController(
            SimpMessagingTemplate messagingTemplate,
            DriverLocationHistoryRepository historyRepository,
            RideStatusHistoryRepository statusHistoryRepository
    ) {
        this.messagingTemplate = messagingTemplate;
        this.historyRepository = historyRepository;
        this.statusHistoryRepository = statusHistoryRepository;
    }

    @PostMapping("/ride/tracking/driver/location/live")
    public ApiResponse updateLocation(@RequestBody Map<String, Object> data) {

        if (!data.containsKey("rideId") ||
                !data.containsKey("driverId") ||
                !data.containsKey("latitude") ||
                !data.containsKey("longitude")) {

            return new ApiResponse(false, "rideId, driverId, latitude and longitude are required", null);
        }

        Object rideId = data.get("rideId");

        DriverLocationHistory history = new DriverLocationHistory();
        history.setRideId(Long.valueOf(data.get("rideId").toString()));
        history.setDriverId(Long.valueOf(data.get("driverId").toString()));
        history.setLatitude(Double.valueOf(data.get("latitude").toString()));
        history.setLongitude(Double.valueOf(data.get("longitude").toString()));
        history.setTimestamp(LocalDateTime.now());

        historyRepository.save(history);

        messagingTemplate.send(
                "/topic/ride/" + rideId,
                MessageBuilder.withPayload(data).build()
        );

        log.info("Driver location saved and broadcasted for rideId: {}", rideId);

        return new ApiResponse(true, "Location Saved and Broadcasted Successfully", data);
    }

    @PostMapping("/ride/tracking/status")
    public ApiResponse updateRideStatus(@RequestBody Map<String, Object> data) {

        if (!data.containsKey("rideId") ||
                !data.containsKey("status") ||
                !data.containsKey("message")) {

            return new ApiResponse(false, "rideId, status and message are required", null);
        }

        Object rideId = data.get("rideId");

        RideStatusHistory statusHistory = new RideStatusHistory();
        statusHistory.setRideId(Long.valueOf(data.get("rideId").toString()));
        statusHistory.setStatus(data.get("status").toString());
        statusHistory.setMessage(data.get("message").toString());
        statusHistory.setTimestamp(LocalDateTime.now());

        statusHistoryRepository.save(statusHistory);

        messagingTemplate.send(
                "/topic/ride-status/" + rideId,
                MessageBuilder.withPayload(data).build()
        );

        log.info("Ride status saved and broadcasted for rideId: {}", rideId);

        return new ApiResponse(true, "Ride Status Saved and Broadcasted Successfully", data);
    }

    @GetMapping("/ride/tracking/history/{rideId}")
    public ApiResponse getTrackingHistory(@PathVariable Long rideId) {

        log.info("Fetching tracking history for rideId: {}", rideId);

        return new ApiResponse(
                true,
                "Tracking history fetched successfully",
                historyRepository.findByRideId(rideId)
        );
    }

    @GetMapping("/ride/tracking/status/history/{rideId}")
    public ApiResponse getRideStatusHistory(@PathVariable Long rideId) {

        log.info("Fetching ride status history for rideId: {}", rideId);

        return new ApiResponse(
                true,
                "Ride status history fetched successfully",
                statusHistoryRepository.findByRideId(rideId)
        );
    }
}