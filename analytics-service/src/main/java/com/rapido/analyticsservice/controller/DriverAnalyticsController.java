package com.rapido.analyticsservice.controller;

import com.rapido.analyticsservice.dto.DriverUtilizationResponse;
import com.rapido.analyticsservice.service.DriverAnalyticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverAnalyticsController {

    private final DriverAnalyticsService
            driverAnalyticsService;

    public DriverAnalyticsController(
            DriverAnalyticsService
                    driverAnalyticsService) {

        this.driverAnalyticsService =
                driverAnalyticsService;
    }

    @GetMapping(
            "/analytics/driver-utilization")
    public DriverUtilizationResponse
    getDriverUtilization() {

        return driverAnalyticsService
                .getDriverUtilization();
    }
}