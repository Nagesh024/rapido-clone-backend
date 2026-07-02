package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.CapacityDashboardResponse;
import com.rapido.platformservice.service.CapacityDashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CapacityDashboardController {

    private final CapacityDashboardService service;

    public CapacityDashboardController(CapacityDashboardService service) {
        this.service = service;
    }

    @GetMapping("/capacity/dashboard")
    public CapacityDashboardResponse dashboard() {
        return service.getDashboard();
    }
}