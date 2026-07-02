package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.MultiTenantDashboardResponse;
import org.springframework.stereotype.Service;

@Service
public class MultiTenantDashboardService {

    public MultiTenantDashboardResponse getTenantDashboard() {

        MultiTenantDashboardResponse response =
                new MultiTenantDashboardResponse();

        response.setTenantId("TENANT-001");
        response.setTenantName("Rapido Hyderabad");

        response.setTenantRevenue(2450000.75);

        response.setTenantHealth("HEALTHY");

        response.setTenantUsage(18650);

        response.setTenantErrors(4);

        if(response.getTenantErrors() < 10){
            response.setOverallStatus("NORMAL");
        } else {
            response.setOverallStatus("WARNING");
        }

        return response;
    }
}