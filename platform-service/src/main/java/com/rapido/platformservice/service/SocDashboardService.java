package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.SocDashboardResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SocDashboardService {

    public SocDashboardResponse getDashboard() {

        SocDashboardResponse response = new SocDashboardResponse();

        response.setFailedLogins(28);
        response.setOauthAttacks(3);
        response.setBruteForceAttempts(12);
        response.setSuspiciousPayments(4);
        response.setFraudAlerts(2);
        response.setBlockedIps(18);
        response.setTokenAbuse(6);

        response.setSecurityStatus("SECURE");
        response.setTimestamp(LocalDateTime.now().toString());

        return response;
    }
}