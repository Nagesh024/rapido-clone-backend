package com.rapido.rideservice.traffic;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class TrafficEtaService {

    public double calculateEtaMinutes(double distanceKm) {

        double averageSpeedKmPerHour = 35.0;

        double trafficFactor = 1.0;

        LocalTime now = LocalTime.now();

        boolean morningPeak =
                now.isAfter(LocalTime.of(8, 0)) &&
                now.isBefore(LocalTime.of(10, 0));

        boolean eveningPeak =
                now.isAfter(LocalTime.of(18, 0)) &&
                now.isBefore(LocalTime.of(21, 0));

        if (morningPeak || eveningPeak) {
            trafficFactor = 1.5;
        }

        double etaHours =
                distanceKm /
                (averageSpeedKmPerHour / trafficFactor);

        return etaHours * 60;
    }
}