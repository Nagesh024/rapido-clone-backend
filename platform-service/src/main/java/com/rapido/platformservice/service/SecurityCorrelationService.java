package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.SecurityIncidentResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SecurityCorrelationService {

    public SecurityIncidentResponse correlateEvents() {

        SecurityIncidentResponse response = new SecurityIncidentResponse();

        response.setIncidentId("INC-2026-0001");
        response.setSeverity("HIGH");
        response.setIncidentType("Coordinated Authentication Attack");

        response.setAuthenticationLogs(156);
        response.setApplicationLogs(48);
        response.setFirewallLogs(22);
        response.setKubernetesLogs(9);
        response.setApiGatewayLogs(74);

        response.setDescription(
                "Multiple failed login attempts detected across API Gateway, Authentication Service and Firewall."
        );

        response.setStatus("OPEN");

        response.setTimestamp(LocalDateTime.now().toString());

        return response;
    }
}