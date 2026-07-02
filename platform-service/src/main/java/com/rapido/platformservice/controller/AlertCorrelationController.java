package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.AlertCorrelationResponse;
import com.rapido.platformservice.service.AlertCorrelationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlertCorrelationController {

    private final AlertCorrelationService service;

    public AlertCorrelationController(AlertCorrelationService service) {
        this.service = service;
    }

    @GetMapping("/alerts/correlation")
    public AlertCorrelationResponse correlation() {
        return service.correlateAlerts();
    }
}