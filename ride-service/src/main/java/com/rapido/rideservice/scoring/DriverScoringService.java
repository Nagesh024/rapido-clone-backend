package com.rapido.rideservice.scoring;

import com.rapido.rideservice.entity.Driver;
import org.springframework.stereotype.Service;

@Service
public class DriverScoringService {

    public double calculateScore(Driver driver, double distanceKm) {

        double distanceScore = 100 - (distanceKm * 10);

        double ratingScore =
                driver.getRating() * 10;

        double acceptanceScore =
                driver.getAcceptanceRate() * 0.3;

        double cancellationPenalty =
                driver.getCancellationRate() * 2;

        double loadPenalty =
                driver.getCurrentLoad() * 5;

        return distanceScore
                + ratingScore
                + acceptanceScore
                - cancellationPenalty
                - loadPenalty;
    }
}