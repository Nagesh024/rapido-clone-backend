package com.rapido.analyticsservice.controller;

import com.rapido.analyticsservice.dto.MonthlyAnalyticsResponse;
import com.rapido.analyticsservice.service.MonthlyAnalyticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonthlyAnalyticsController {

    private final MonthlyAnalyticsService
            monthlyAnalyticsService;

    public MonthlyAnalyticsController(
            MonthlyAnalyticsService monthlyAnalyticsService) {

        this.monthlyAnalyticsService =
                monthlyAnalyticsService;
    }

    @GetMapping("/analytics/monthly")
    public MonthlyAnalyticsResponse getMonthlyAnalytics() {

        return monthlyAnalyticsService
                .generateMonthlyAnalytics();
    }
}