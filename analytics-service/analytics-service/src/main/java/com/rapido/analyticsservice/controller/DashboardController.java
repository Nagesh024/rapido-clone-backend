package com.rapido.analyticsservice.controller;

import com.rapido.analyticsservice.dto.DashboardResponse;
import com.rapido.analyticsservice.service.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    private final DashboardService
            dashboardService;

    public DashboardController(
            DashboardService dashboardService) {

        this.dashboardService =
                dashboardService;
    }

    @GetMapping("/analytics/dashboard")
    public DashboardResponse
    getDashboard() {

        return dashboardService
                .getDashboard();
    }
}