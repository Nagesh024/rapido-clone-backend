package com.rapido.search.controller;

import com.rapido.search.dto.SearchPerformanceResponse;
import com.rapido.search.service.SearchPerformanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchPerformanceController {

    private final SearchPerformanceService service;

    public SearchPerformanceController(
            SearchPerformanceService service) {
        this.service = service;
    }

    @GetMapping("/search/performance")
    public SearchPerformanceResponse performance() {

        return service.getPerformance();
    }
}