package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.ExecutiveDashboardResponse;
import com.rapido.platformservice.service.ExecutiveDashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExecutiveDashboardController {

    private final ExecutiveDashboardService service;

    public ExecutiveDashboardController(ExecutiveDashboardService service) {
        this.service = service;
    }

    @GetMapping("/executive/dashboard")
    public ExecutiveDashboardResponse dashboard() {
        return service.getDashboard();
    }
}