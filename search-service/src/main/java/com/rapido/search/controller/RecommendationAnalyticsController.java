package com.rapido.search.controller;

import com.rapido.search.dto.RecommendationAnalyticsResponse;
import com.rapido.search.service.RecommendationAnalyticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationAnalyticsController {

    private final RecommendationAnalyticsService service;

    public RecommendationAnalyticsController(
            RecommendationAnalyticsService service) {
        this.service = service;
    }

    @GetMapping("/search/recommendations/analytics")
    public RecommendationAnalyticsResponse analytics() {

        return service.getAnalytics();
    }
}