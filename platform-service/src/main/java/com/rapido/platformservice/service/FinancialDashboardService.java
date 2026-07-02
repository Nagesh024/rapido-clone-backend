package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.FinancialDashboardResponse;
import org.springframework.stereotype.Service;

@Service
public class FinancialDashboardService {

    public FinancialDashboardResponse getFinancialDashboard() {

        FinancialDashboardResponse response = new FinancialDashboardResponse();

        response.setTotalRevenue(2458750.75);
        response.setWalletBalance(845230.40);
        response.setTotalRefunds(25340.80);
        response.setSettlements(2384600.50);
        response.setGatewaySuccessRate(99.82);

        if (response.getGatewaySuccessRate() >= 99.5) {
            response.setFinancialStatus("HEALTHY");
        } else if (response.getGatewaySuccessRate() >= 98.0) {
            response.setFinancialStatus("WARNING");
        } else {
            response.setFinancialStatus("CRITICAL");
        }

        return response;
    }
}