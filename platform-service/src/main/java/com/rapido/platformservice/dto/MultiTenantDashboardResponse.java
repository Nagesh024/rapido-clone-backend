package com.rapido.platformservice.dto;

import java.time.LocalDateTime;

public class MultiTenantDashboardResponse {

    private String tenantId;

    private String tenantName;

    private double tenantRevenue;

    private String tenantHealth;

    private int tenantUsage;

    private int tenantErrors;

    private String overallStatus;

    private String timestamp;

    public MultiTenantDashboardResponse() {
        this.timestamp = LocalDateTime.now().toString();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public double getTenantRevenue() {
        return tenantRevenue;
    }

    public void setTenantRevenue(double tenantRevenue) {
        this.tenantRevenue = tenantRevenue;
    }

    public String getTenantHealth() {
        return tenantHealth;
    }

    public void setTenantHealth(String tenantHealth) {
        this.tenantHealth = tenantHealth;
    }

    public int getTenantUsage() {
        return tenantUsage;
    }

    public void setTenantUsage(int tenantUsage) {
        this.tenantUsage = tenantUsage;
    }

    public int getTenantErrors() {
        return tenantErrors;
    }

    public void setTenantErrors(int tenantErrors) {
        this.tenantErrors = tenantErrors;
    }

    public String getOverallStatus() {
        return overallStatus;
    }

    public void setOverallStatus(String overallStatus) {
        this.overallStatus = overallStatus;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}