package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.FinancialDashboardResponse;
import com.rapido.platformservice.service.FinancialDashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinancialDashboardController {

    private final FinancialDashboardService financialDashboardService;

    public FinancialDashboardController(FinancialDashboardService financialDashboardService) {
        this.financialDashboardService = financialDashboardService;
    }

    @GetMapping("/finance/dashboard")
    public FinancialDashboardResponse getFinancialDashboard() {
        return financialDashboardService.getFinancialDashboard();
    }
}