package com.rapido.analyticsservice.service;

import com.rapido.analyticsservice.dto.DashboardResponse;
import com.rapido.analyticsservice.repository.FactRideRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final FactRideRepository factRideRepository;

    public DashboardService(
            FactRideRepository factRideRepository) {

        this.factRideRepository =
                factRideRepository;
    }

    public DashboardResponse getDashboard() {

        DashboardResponse response =
                new DashboardResponse();

        long totalRides =
                factRideRepository.count();

        long completedRides =
                factRideRepository.countByStatus(
                        "COMPLETED");

        double successRate =
                totalRides == 0
                        ? 0
                        : (completedRides * 100.0)
                          / totalRides;

        response.setActiveRides(
                completedRides);

        response.setActiveDrivers(
                1L);

        response.setDailyRevenue(
                factRideRepository
                        .getTotalRevenue());

        response.setRideSuccessRate(
                successRate);

        response.setAverageEta(
                5.0);

        return response;
    }
}