package com.rapido.platformservice.dto;

public class SecurityIncidentResponse {

    private String incidentId;
    private String severity;
    private String incidentType;

    private int authenticationLogs;
    private int applicationLogs;
    private int firewallLogs;
    private int kubernetesLogs;
    private int apiGatewayLogs;

    private String description;
    private String status;
    private String timestamp;

    public String getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public int getAuthenticationLogs() {
        return authenticationLogs;
    }

    public void setAuthenticationLogs(int authenticationLogs) {
        this.authenticationLogs = authenticationLogs;
    }

    public int getApplicationLogs() {
        return applicationLogs;
    }

    public void setApplicationLogs(int applicationLogs) {
        this.applicationLogs = applicationLogs;
    }

    public int getFirewallLogs() {
        return firewallLogs;
    }

    public void setFirewallLogs(int firewallLogs) {
        this.firewallLogs = firewallLogs;
    }

    public int getKubernetesLogs() {
        return kubernetesLogs;
    }

    public void setKubernetesLogs(int kubernetesLogs) {
        this.kubernetesLogs = kubernetesLogs;
    }

    public int getApiGatewayLogs() {
        return apiGatewayLogs;
    }

    public void setApiGatewayLogs(int apiGatewayLogs) {
        this.apiGatewayLogs = apiGatewayLogs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}