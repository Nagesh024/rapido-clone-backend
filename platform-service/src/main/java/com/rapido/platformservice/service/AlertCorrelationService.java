package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.AlertCorrelationResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AlertCorrelationService {

    public AlertCorrelationResponse correlateAlerts() {

        AlertCorrelationResponse response =
                new AlertCorrelationResponse();

        response.setAlertSources(Arrays.asList(
                "Prometheus",
                "Grafana",
                "Kafka",
                "Redis",
                "PostgreSQL",
                "Spring Boot",
                "Security Platform"
        ));

        response.setTotalAlerts(142);

        response.setDuplicateAlerts(97);

        response.setCorrelatedIncidents(45);

        response.setCorrelationStatus("CORRELATION_ACTIVE");

        return response;
    }
}