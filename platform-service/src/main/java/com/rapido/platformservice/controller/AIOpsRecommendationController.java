package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.AIOpsRecommendationResponse;
import com.rapido.platformservice.service.AIOpsRecommendationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIOpsRecommendationController {

    private final AIOpsRecommendationService service;

    public AIOpsRecommendationController(
            AIOpsRecommendationService service) {
        this.service = service;
    }

    @GetMapping("/aiops/recommendations")
    public AIOpsRecommendationResponse recommendations() {
        return service.analyzePlatform();
    }
}