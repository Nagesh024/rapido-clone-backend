package com.rapido.analyticsservice.service;

import com.rapido.analyticsservice.dto.KPIDashboardResponse;
import com.rapido.analyticsservice.repository.FactRideRepository;
import org.springframework.stereotype.Service;

@Service
public class KPIAggregationService {

    private final FactRideRepository factRideRepository;

    public KPIAggregationService(
            FactRideRepository factRideRepository) {

        this.factRideRepository = factRideRepository;
    }

    public KPIDashboardResponse getKPIs() {

        KPIDashboardResponse response =
                new KPIDashboardResponse();

        response.setTotalRides(
                factRideRepository.count());

        response.setCompletedRides(
                factRideRepository.countByStatus(
                        "COMPLETED"));

        response.setCancelledRides(
                factRideRepository.countByStatus(
                        "CANCELLED"));

        response.setTotalRevenue(
                factRideRepository.getTotalRevenue());

        response.setAverageRideDuration(
                factRideRepository.getAverageRideDuration());

        return response;
    }
}