package com.rapido.analyticsservice.service;

import com.rapido.analyticsservice.dto.CityAnalyticsResponse;
import com.rapido.analyticsservice.repository.FactRideRepository;
import org.springframework.stereotype.Service;

@Service
public class CityAnalyticsService {

    private final FactRideRepository factRideRepository;

    public CityAnalyticsService(
            FactRideRepository factRideRepository) {

        this.factRideRepository =
                factRideRepository;
    }

    public CityAnalyticsResponse getCityAnalytics() {

        CityAnalyticsResponse response =
                new CityAnalyticsResponse();

        response.setTopCity(
                "Hyderabad");

        response.setRideDemand(
                factRideRepository.count());

        response.setCityRevenue(
                factRideRepository.getTotalRevenue());

        return response;
    }
}