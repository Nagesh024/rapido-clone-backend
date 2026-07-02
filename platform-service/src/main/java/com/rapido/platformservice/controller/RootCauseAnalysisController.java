package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.RootCauseAnalysisResponse;
import com.rapido.platformservice.service.RootCauseAnalysisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootCauseAnalysisController {

    private final RootCauseAnalysisService service;

    public RootCauseAnalysisController(RootCauseAnalysisService service) {
        this.service = service;
    }

    @GetMapping("/rca/analyze")
    public RootCauseAnalysisResponse analyze() {
        return service.analyze();
    }
}