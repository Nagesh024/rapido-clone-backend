package com.rapido.search.controller;

import com.rapido.search.service.SearchAnalyticsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analytics/search")
public class SearchAnalyticsController {

    private final SearchAnalyticsService service;

    public SearchAnalyticsController(
            SearchAnalyticsService service) {
        this.service = service;
    }

    @PostMapping("/track")
    public String trackSearch(
            @RequestParam String searchTerm,
            @RequestParam Long userId,
            @RequestParam String selectedResult,
            @RequestParam Long responseTime,
            @RequestParam String eventType) {

        service.saveEvent(
                searchTerm,
                userId,
                selectedResult,
                responseTime,
                eventType
        );

        return "Search Event Saved";
    }
}