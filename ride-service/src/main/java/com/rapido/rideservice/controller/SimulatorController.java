package com.rapido.rideservice.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.rapido.rideservice.util.GeoUtil;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimulatorController {

    private final SimpMessagingTemplate messagingTemplate;

    public SimulatorController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @PostMapping("/ride/tracking/simulate")
    public String simulateDriverMovement() {

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        final double startLat = 17.4401;
        final double startLng = 78.3489;
        final double endLat = 17.3850;
        final double endLng = 78.4867;

        final int totalSteps = 10;
        final int[] step = {0};

        executor.scheduleAtFixedRate(() -> {

            if (step[0] > totalSteps) {
                executor.shutdown();
                return;
            }

            double lat = startLat + ((endLat - startLat) * step[0] / totalSteps);
            double lng = startLng + ((endLng - startLng) * step[0] / totalSteps);

            
            double distanceKm = GeoUtil.calculateDistanceKm(lat, lng, endLat, endLng);
            double etaMinutes = GeoUtil.calculateEtaMinutes(distanceKm, 30);
            
            Map<String, Object> data = new HashMap<>();
            data.put("rideId", 101);
            data.put("driverId", 501);
            data.put("latitude", lat);
            data.put("longitude", lng);
            data.put("status", "MOVING");
            data.put("etaMinutes", etaMinutes);
            data.put("distanceKm", distanceKm);

            messagingTemplate.send(
                    "/topic/ride/101",
                    org.springframework.messaging.support.MessageBuilder.withPayload(data).build()
            );

            System.out.println("Simulated location: " + data);

            step[0]++;

        }, 0, 3, TimeUnit.SECONDS);

        return "Driver Movement Simulation Started";
    }
}