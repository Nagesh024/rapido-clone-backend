package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.ExecutiveKpiResponse;
import com.rapido.platformservice.service.ExecutiveKpiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExecutiveKpiController {

    private final ExecutiveKpiService executiveKpiService;

    public ExecutiveKpiController(ExecutiveKpiService executiveKpiService) {
        this.executiveKpiService = executiveKpiService;
    }

    @GetMapping("/executive/kpis")
    public ExecutiveKpiResponse getExecutiveKpis() {
        return executiveKpiService.getExecutiveKpis();
    }
}