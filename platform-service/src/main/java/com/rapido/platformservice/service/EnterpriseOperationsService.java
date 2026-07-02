package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.OperationsResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EnterpriseOperationsService {

    public OperationsResponse getDashboard() {

        OperationsResponse response = new OperationsResponse();

        Map<String, Object> data = new HashMap<>();

        data.put("executiveDashboard", "UP");
        data.put("nocDashboard", "UP");
        data.put("socDashboard", "UP");
        data.put("financeDashboard", "UP");
        data.put("engineeringDashboard", "UP");

        response.setStatus("SUCCESS");
        response.setData(data);

        return response;
    }

    public OperationsResponse getIncidents() {

        OperationsResponse response = new OperationsResponse();

        Map<String, Object> data = new HashMap<>();

        data.put("openIncidents", 5);
        data.put("criticalIncidents", 1);
        data.put("resolvedToday", 18);

        response.setStatus("SUCCESS");
        response.setData(data);

        return response;
    }

    public OperationsResponse getMetrics() {

        OperationsResponse response = new OperationsResponse();

        Map<String, Object> data = new HashMap<>();

        data.put("cpu", "61%");
        data.put("memory", "58%");
        data.put("latency", "69 ms");
        data.put("availability", "99.98%");
        data.put("requestsPerSecond", 2850);

        response.setStatus("SUCCESS");
        response.setData(data);

        return response;
    }

    public OperationsResponse getSecurity() {

        OperationsResponse response = new OperationsResponse();

        Map<String, Object> data = new HashMap<>();

        data.put("failedLogins", 14);
        data.put("blockedIPs", 6);
        data.put("oauthAttacks", 0);
        data.put("fraudAlerts", 2);
        data.put("securityStatus", "HEALTHY");

        response.setStatus("SUCCESS");
        response.setData(data);

        return response;
    }
}