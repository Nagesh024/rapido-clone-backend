package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.PerformanceAnalyticsResponse;
import com.rapido.platformservice.service.PerformanceAnalyticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerformanceAnalyticsController {

    private final PerformanceAnalyticsService service;

    public PerformanceAnalyticsController(
            PerformanceAnalyticsService service) {
        this.service = service;
    }

    @GetMapping("/performance/analytics")
    public PerformanceAnalyticsResponse analytics() {
        return service.getPerformanceMetrics();
    }
}