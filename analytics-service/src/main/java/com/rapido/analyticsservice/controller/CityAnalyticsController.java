package com.rapido.analyticsservice.controller;

import com.rapido.analyticsservice.dto.CityAnalyticsResponse;
import com.rapido.analyticsservice.service.CityAnalyticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityAnalyticsController {

    private final CityAnalyticsService cityAnalyticsService;

    public CityAnalyticsController(
            CityAnalyticsService cityAnalyticsService) {

        this.cityAnalyticsService = cityAnalyticsService;
    }

    @GetMapping("/analytics/cities")
    public CityAnalyticsResponse getCityAnalytics() {

        return cityAnalyticsService.getCityAnalytics();
    }
}