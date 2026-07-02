package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.IncidentTimelineResponse;
import com.rapido.platformservice.service.IncidentTimelineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncidentTimelineController {

    private final IncidentTimelineService service;

    public IncidentTimelineController(
            IncidentTimelineService service) {
        this.service = service;
    }

    @GetMapping("/incidents/timeline")
    public IncidentTimelineResponse timeline() {
        return service.getTimeline();
    }
}