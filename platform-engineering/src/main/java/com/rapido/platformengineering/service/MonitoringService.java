package com.rapido.platformengineering.service;

import com.rapido.platformengineering.dto.MonitoringDashboardResponse;
import org.springframework.stereotype.Service;

@Service
public class MonitoringService {

    public MonitoringDashboardResponse getDashboard() {

        return new MonitoringDashboardResponse(
                42.5,
                68.3,
                120.0,
                2,
                15
        );
    }
}