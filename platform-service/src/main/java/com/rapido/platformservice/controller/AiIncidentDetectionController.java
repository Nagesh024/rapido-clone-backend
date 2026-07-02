package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.AiIncidentResponse;
import com.rapido.platformservice.service.AiIncidentDetectionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiIncidentDetectionController {

    private final AiIncidentDetectionService service;

    public AiIncidentDetectionController(AiIncidentDetectionService service) {
        this.service = service;
    }

    @GetMapping("/ai/incidents")
    public AiIncidentResponse detectIncidents() {
        return service.detectIncidents();
    }
}