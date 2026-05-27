package com.rapido.rideservice.surge;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class SurgePricingService {

    public double calculateSurgeMultiplier(int nearbyDrivers, int demandCount) {

        double multiplier = 1.0;

        LocalTime now = LocalTime.now();

        boolean morningPeak =
                now.isAfter(LocalTime.of(8, 0)) &&
                now.isBefore(LocalTime.of(10, 0));

        boolean eveningPeak =
                now.isAfter(LocalTime.of(18, 0)) &&
                now.isBefore(LocalTime.of(21, 0));

        if (morningPeak || eveningPeak) {
            multiplier = multiplier + 0.5;
        }

        if (demandCount > nearbyDrivers) {
            multiplier = multiplier + 0.5;
        }

        if (nearbyDrivers <= 2) {
            multiplier = multiplier + 0.3;
        }

        return multiplier;
    }

    public double calculateFare(double baseFare, double surgeMultiplier) {
        return baseFare * surgeMultiplier;
    }
}