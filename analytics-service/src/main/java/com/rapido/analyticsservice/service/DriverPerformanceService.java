package com.rapido.analyticsservice.service;

import com.rapido.analyticsservice.dto.DriverAnalyticsResponse;
import com.rapido.analyticsservice.repository.FactRideRepository;
import org.springframework.stereotype.Service;

@Service
public class DriverPerformanceService {

    private final FactRideRepository factRideRepository;

    public DriverPerformanceService(
            FactRideRepository factRideRepository) {

        this.factRideRepository = factRideRepository;
    }

    public DriverAnalyticsResponse getDriverAnalytics() {

        DriverAnalyticsResponse response =
                new DriverAnalyticsResponse();

        long totalRides =
                factRideRepository.count();

        long completedRides =
                factRideRepository.countByStatus(
                        "COMPLETED");

        long cancelledRides =
                factRideRepository.countByStatus(
                        "CANCELLED");

        double completionRate =
                totalRides == 0
                        ? 0
                        : (completedRides * 100.0)
                          / totalRides;

        double cancellationRate =
                totalRides == 0
                        ? 0
                        : (cancelledRides * 100.0)
                          / totalRides;

        double acceptanceRate = 95.0;

        double averageRating = 4.8;

        response.setAcceptanceRate(
                acceptanceRate);

        response.setCompletionRate(
                completionRate);

        response.setCancellationRate(
                cancellationRate);

        response.setAverageRating(
                averageRating);

        return response;
    }
}