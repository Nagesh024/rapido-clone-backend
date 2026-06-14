package com.rapido.search.controller;

import com.rapido.search.dto.SearchMetricsResponse;
import com.rapido.search.service.SearchMetricsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchMetricsController {

    private final SearchMetricsService service;

    public SearchMetricsController(
            SearchMetricsService service) {
        this.service = service;
    }

    @GetMapping("/search/metrics")
    public SearchMetricsResponse metrics() {

        return service.metrics();
    }
}