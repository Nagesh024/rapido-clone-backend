package com.rapido.analyticsservice.service;

import com.rapido.analyticsservice.dto.WeeklyAnalyticsResponse;
import com.rapido.analyticsservice.repository.FactRideRepository;
import org.springframework.stereotype.Service;

@Service
public class WeeklyAnalyticsService {

    private final FactRideRepository factRideRepository;

    public WeeklyAnalyticsService(
            FactRideRepository factRideRepository) {

        this.factRideRepository =
                factRideRepository;
    }

    public WeeklyAnalyticsResponse generateWeeklyAnalytics() {

        WeeklyAnalyticsResponse response =
                new WeeklyAnalyticsResponse();

        response.setWeeklyRevenue(
                factRideRepository.getWeeklyRevenue());

        response.setWeeklyRideCount(
                factRideRepository.getWeeklyRideCount());

        return response;
    }
}