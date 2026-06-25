package com.rapido.platformengineering.dashboard.controller;

import com.rapido.platformengineering.dashboard.dto.ExecutiveDashboardResponse;
import com.rapido.platformengineering.dashboard.service.ExecutiveDashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExecutiveDashboardController {

    private final ExecutiveDashboardService service;

    public ExecutiveDashboardController(
            ExecutiveDashboardService service) {

        this.service = service;
    }

    @GetMapping("/api/v1/executive/dashboard")
    public ExecutiveDashboardResponse dashboard() {

        return service.getDashboard();
    }
}