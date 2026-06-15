package com.rapido.multitenantservice.service;

import com.rapido.multitenantservice.dto.TenantDashboardResponse;
import org.springframework.stereotype.Service;

@Service
public class TenantDashboardService {

    public TenantDashboardResponse getDashboard(
            String tenantId) {

        TenantDashboardResponse response =
                new TenantDashboardResponse();

        if ("TENANT_100".equals(tenantId)) {

            response.setTotalDrivers(500L);
            response.setTotalRides(10000L);
            response.setTotalCustomers(7000L);
            response.setTotalRevenue(250000.0);

        } else {

            response.setTotalDrivers(0L);
            response.setTotalRides(0L);
            response.setTotalCustomers(0L);
            response.setTotalRevenue(0.0);
        }

        return response;
    }
}