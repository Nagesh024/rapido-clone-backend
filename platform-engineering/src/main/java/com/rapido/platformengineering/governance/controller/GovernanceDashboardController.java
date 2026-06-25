package com.rapido.platformengineering.governance.controller;

import com.rapido.platformengineering.governance.dto.GovernanceDashboardResponse;
import com.rapido.platformengineering.governance.service.GovernanceDashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GovernanceDashboardController {

    private final GovernanceDashboardService service;

    public GovernanceDashboardController(
            GovernanceDashboardService service) {

        this.service = service;
    }

    @GetMapping("/api/v1/governance/dashboard")
    public GovernanceDashboardResponse dashboard() {

        return service.getDashboard();
    }
}