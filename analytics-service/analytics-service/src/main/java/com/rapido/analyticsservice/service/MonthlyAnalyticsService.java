package com.rapido.analyticsservice.service;

import com.rapido.analyticsservice.dto.MonthlyAnalyticsResponse;
import com.rapido.analyticsservice.repository.FactRideRepository;
import org.springframework.stereotype.Service;

@Service
public class MonthlyAnalyticsService {

    private final FactRideRepository factRideRepository;

    public MonthlyAnalyticsService(
            FactRideRepository factRideRepository) {

        this.factRideRepository =
                factRideRepository;
    }

    public MonthlyAnalyticsResponse generateMonthlyAnalytics() {

        MonthlyAnalyticsResponse response =
                new MonthlyAnalyticsResponse();

        response.setMonthlyRevenue(
                factRideRepository.getMonthlyRevenue());

        response.setMonthlyRideCount(
                factRideRepository.getMonthlyRideCount());

        return response;
    }
}