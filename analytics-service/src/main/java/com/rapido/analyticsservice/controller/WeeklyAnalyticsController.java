package com.rapido.analyticsservice.controller;

import com.rapido.analyticsservice.dto.WeeklyAnalyticsResponse;
import com.rapido.analyticsservice.service.WeeklyAnalyticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeeklyAnalyticsController {

    private final WeeklyAnalyticsService
            weeklyAnalyticsService;

    public WeeklyAnalyticsController(
            WeeklyAnalyticsService weeklyAnalyticsService) {

        this.weeklyAnalyticsService =
                weeklyAnalyticsService;
    }

    @GetMapping("/analytics/weekly")
    public WeeklyAnalyticsResponse getWeeklyAnalytics() {

        return weeklyAnalyticsService
                .generateWeeklyAnalytics();
    }
}