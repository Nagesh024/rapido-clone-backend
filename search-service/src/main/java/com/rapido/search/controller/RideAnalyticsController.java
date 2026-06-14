package com.rapido.search.controller;

import com.rapido.search.dto.RideAnalyticsResponse;
import com.rapido.search.service.RideAnalyticsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analytics")
public class RideAnalyticsController {

    private final RideAnalyticsService service;

    public RideAnalyticsController(
            RideAnalyticsService service) {
        this.service = service;
    }

    @GetMapping("/rides")
    public RideAnalyticsResponse analytics(
            @RequestParam Long userId) {

        return service.analyze(userId);
    }
}