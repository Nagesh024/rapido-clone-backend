package com.rapido.analyticsservice.controller;

import com.rapido.analyticsservice.dto.RevenueAnalyticsResponse;
import com.rapido.analyticsservice.service.RevenueAnalyticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RevenueAnalyticsController {

    private final RevenueAnalyticsService
            revenueAnalyticsService;

    public RevenueAnalyticsController(
            RevenueAnalyticsService
                    revenueAnalyticsService) {

        this.revenueAnalyticsService =
                revenueAnalyticsService;
    }

    @GetMapping(
            "/analytics/revenue")
    public RevenueAnalyticsResponse
    getRevenueAnalytics() {

        return revenueAnalyticsService
                .getRevenueAnalytics();
    }
}