package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.IncidentPriorityResponse;
import com.rapido.platformservice.service.IncidentPriorityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncidentPriorityController {

    private final IncidentPriorityService service;

    public IncidentPriorityController(
            IncidentPriorityService service) {
        this.service = service;
    }

    @GetMapping("/incidents/priority")
    public IncidentPriorityResponse priority() {
        return service.calculatePriority();
    }
}