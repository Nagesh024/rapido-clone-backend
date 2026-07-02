package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.AiPredictionDashboardResponse;
import com.rapido.platformservice.service.AiPredictionDashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiPredictionDashboardController {

    private final AiPredictionDashboardService service;

    public AiPredictionDashboardController(
            AiPredictionDashboardService service) {
        this.service = service;
    }

    @GetMapping("/ai/predictions")
    public AiPredictionDashboardResponse dashboard() {
        return service.getPredictionDashboard();
    }
}
