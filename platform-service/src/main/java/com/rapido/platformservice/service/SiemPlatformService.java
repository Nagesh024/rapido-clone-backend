package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.SiemDashboardResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SiemPlatformService {

    public SiemDashboardResponse getDashboard() {

        SiemDashboardResponse response = new SiemDashboardResponse();

        response.setTotalEvents(1842);
        response.setCorrelatedIncidents(16);

        response.setCriticalAlerts(2);
        response.setHighAlerts(5);
        response.setMediumAlerts(6);
        response.setLowAlerts(3);

        response.setEventSources(Arrays.asList(
                "Authentication Logs",
                "Application Logs",
                "Firewall Logs",
                "Kubernetes Logs",
                "API Gateway Logs"
        ));

        response.setThreatTimeline(Arrays.asList(
                "09:12 Failed Login Burst",
                "09:14 OAuth Token Abuse",
                "09:18 API Gateway Rate Limit Triggered",
                "09:22 Firewall Blocked IP",
                "09:26 Suspicious Payment Detected",
                "09:31 Incident Correlated"
        ));

        response.setStatus("ACTIVE");

        return response;
    }
}