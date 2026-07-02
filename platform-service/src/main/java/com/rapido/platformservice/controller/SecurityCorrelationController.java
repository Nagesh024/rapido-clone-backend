package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.SecurityIncidentResponse;
import com.rapido.platformservice.service.SecurityCorrelationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityCorrelationController {

    private final SecurityCorrelationService service;

    public SecurityCorrelationController(SecurityCorrelationService service) {
        this.service = service;
    }

    @GetMapping("/soc/correlated-incidents")
    public SecurityIncidentResponse incidents() {
        return service.correlateEvents();
    }
}