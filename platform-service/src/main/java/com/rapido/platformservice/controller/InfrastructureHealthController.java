package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.InfrastructureHealthResponse;
import com.rapido.platformservice.service.InfrastructureHealthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfrastructureHealthController {

    private final InfrastructureHealthService service;

    public InfrastructureHealthController(InfrastructureHealthService service) {
        this.service = service;
    }

    @GetMapping("/infrastructure/health")
    public InfrastructureHealthResponse health() {
        return service.calculateHealth();
    }
}