package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.OperationsResponse;
import com.rapido.platformservice.service.EnterpriseOperationsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnterpriseOperationsController {

    private final EnterpriseOperationsService service;

    public EnterpriseOperationsController(EnterpriseOperationsService service) {
        this.service = service;
    }

    @GetMapping("/operations/dashboard")
    public OperationsResponse dashboard() {
        return service.getDashboard();
    }

    @GetMapping("/operations/incidents")
    public OperationsResponse incidents() {
        return service.getIncidents();
    }

    @GetMapping("/operations/metrics")
    public OperationsResponse metrics() {
        return service.getMetrics();
    }

    @GetMapping("/operations/security")
    public OperationsResponse security() {
        return service.getSecurity();
    }
}