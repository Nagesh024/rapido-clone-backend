package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.FraudDashboardResponse;
import com.rapido.platformservice.service.FraudDashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FraudDashboardController {

    private final FraudDashboardService service;

    public FraudDashboardController(FraudDashboardService service) {
        this.service = service;
    }

    @GetMapping("/fraud/dashboard")
    public FraudDashboardResponse dashboard() {
        return service.getDashboard();
    }
}