package com.rapido.search.controller;

import com.rapido.search.dto.RideRecommendationResponse;
import com.rapido.search.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    private final RecommendationService service;

    public RecommendationController(
            RecommendationService service) {
        this.service = service;
    }

    @GetMapping("/rides")
    public RideRecommendationResponse getRecommendations(
            @RequestParam Long userId) {

        return service.recommend(userId);
    }
}