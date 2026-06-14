package com.rapido.analyticsservice.controller;

import com.rapido.analyticsservice.dto.KPIDashboardResponse;
import com.rapido.analyticsservice.service.KPIAggregationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KPIController {

    private final KPIAggregationService
            kpiAggregationService;

    public KPIController(
            KPIAggregationService
                    kpiAggregationService) {

        this.kpiAggregationService =
                kpiAggregationService;
    }

    @GetMapping("/analytics/kpis")
    public KPIDashboardResponse getKPIs() {

        return kpiAggregationService
                .getKPIs();
    }
}