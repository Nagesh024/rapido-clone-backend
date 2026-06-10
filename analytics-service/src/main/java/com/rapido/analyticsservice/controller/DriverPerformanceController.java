package com.rapido.analyticsservice.controller;

import com.rapido.analyticsservice.dto.DriverAnalyticsResponse;
import com.rapido.analyticsservice.service.DriverPerformanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverPerformanceController {

    private final DriverPerformanceService
            driverPerformanceService;

    public DriverPerformanceController(
            DriverPerformanceService
                    driverPerformanceService) {

        this.driverPerformanceService =
                driverPerformanceService;
    }

    @GetMapping("/analytics/drivers")
    public DriverAnalyticsResponse
    getDriverAnalytics() {

        return driverPerformanceService
                .getDriverAnalytics();
    }
}