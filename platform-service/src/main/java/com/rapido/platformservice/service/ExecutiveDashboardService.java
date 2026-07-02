package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.ExecutiveDashboardResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ExecutiveDashboardService {

    public ExecutiveDashboardResponse getDashboard() {

        ExecutiveDashboardResponse response = new ExecutiveDashboardResponse();

        response.setPlatformName("Rapido Enterprise Platform");
        response.setPlatformStatus("HEALTHY");

        response.setTotalServices(12);
        response.setActiveServices(12);

        response.setTotalUsers(15000);
        response.setActiveDrivers(2400);

        response.setTotalRides(9200);

        response.setDailyRevenue(785450.50);

        response.setSystemAvailability(99.98);

        response.setTimestamp(LocalDateTime.now().toString());

        return response;
    }
}