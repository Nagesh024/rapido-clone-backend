package com.rapido.search.controller;

import com.rapido.search.dto.HealthResponse;
import com.rapido.search.service.HealthMonitoringService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchHealthController {

    private final HealthMonitoringService service;

    public SearchHealthController(
            HealthMonitoringService service) {
        this.service = service;
    }

    @GetMapping("/search/health")
    public HealthResponse health() {

        return service.health();
    }
}