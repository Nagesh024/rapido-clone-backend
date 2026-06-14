package com.rapido.analyticsservice.service;

import com.rapido.analyticsservice.dto.DriverUtilizationResponse;
import com.rapido.analyticsservice.repository.FactRideRepository;
import org.springframework.stereotype.Service;

@Service
public class DriverAnalyticsService {

    private final FactRideRepository factRideRepository;

    public DriverAnalyticsService(
            FactRideRepository factRideRepository) {

        this.factRideRepository =
                factRideRepository;
    }

    public DriverUtilizationResponse
    getDriverUtilization() {

        DriverUtilizationResponse response =
                new DriverUtilizationResponse();

        long totalRides =
                factRideRepository.count();

        double completedRideHours =
                (totalRides * 15.0) / 60.0;

        double onlineHours = 10.0;

        double utilization =
                (completedRideHours
                        / onlineHours) * 100;

        response.setOnlineHours(
                onlineHours);

        response.setCompletedRideHours(
                completedRideHours);

        response.setUtilizationPercentage(
                utilization);

        return response;
    }
}