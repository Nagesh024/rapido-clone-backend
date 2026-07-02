package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.ExecutiveKpiResponse;
import org.springframework.stereotype.Service;

@Service
public class ExecutiveKpiService {

    public ExecutiveKpiResponse getExecutiveKpis() {

        ExecutiveKpiResponse response = new ExecutiveKpiResponse();

        response.setDailyActiveUsers(84250);
        response.setMonthlyActiveUsers(1245600);

        response.setRevenueGrowth(18.75);
        response.setRideGrowth(14.60);

        response.setDriverRetention(92.80);
        response.setCustomerRetention(95.40);

        if (response.getRevenueGrowth() >= 15 &&
                response.getCustomerRetention() >= 90) {

            response.setBusinessStatus("EXCELLENT");

        } else if (response.getRevenueGrowth() >= 10) {

            response.setBusinessStatus("GOOD");

        } else {

            response.setBusinessStatus("WARNING");

        }

        return response;
    }
}