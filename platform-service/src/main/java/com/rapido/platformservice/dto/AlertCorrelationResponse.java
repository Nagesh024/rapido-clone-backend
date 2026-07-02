package com.rapido.platformservice.dto;

import java.time.LocalDateTime;
import java.util.List;

public class AlertCorrelationResponse {

    private List<String> alertSources;

    private int totalAlerts;

    private int duplicateAlerts;

    private int correlatedIncidents;

    private String correlationStatus;

    private String timestamp;

    public AlertCorrelationResponse() {
        this.timestamp = LocalDateTime.now().toString();
    }

    public List<String> getAlertSources() {
        return alertSources;
    }

    public void setAlertSources(List<String> alertSources) {
        this.alertSources = alertSources;
    }

    public int getTotalAlerts() {
        return totalAlerts;
    }

    public void setTotalAlerts(int totalAlerts) {
        this.totalAlerts = totalAlerts;
    }

    public int getDuplicateAlerts() {
        return duplicateAlerts;
    }

    public void setDuplicateAlerts(int duplicateAlerts) {
        this.duplicateAlerts = duplicateAlerts;
    }

    public int getCorrelatedIncidents() {
        return correlatedIncidents;
    }

    public void setCorrelatedIncidents(int correlatedIncidents) {
        this.correlatedIncidents = correlatedIncidents;
    }

    public String getCorrelationStatus() {
        return correlationStatus;
    }

    public void setCorrelationStatus(String correlationStatus) {
        this.correlationStatus = correlationStatus;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}