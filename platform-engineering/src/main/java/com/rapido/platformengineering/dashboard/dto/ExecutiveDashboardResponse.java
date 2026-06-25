package com.rapido.platformengineering.dashboard.dto;

public class ExecutiveDashboardResponse {

    private String systemHealth;

    private long technicalDebtCount;

    private long riskExposureCount;

    private long compliantServices;

    private long nonCompliantServices;

    public String getSystemHealth() {
        return systemHealth;
    }

    public void setSystemHealth(String systemHealth) {
        this.systemHealth = systemHealth;
    }

    public long getTechnicalDebtCount() {
        return technicalDebtCount;
    }

    public void setTechnicalDebtCount(long technicalDebtCount) {
        this.technicalDebtCount = technicalDebtCount;
    }

    public long getRiskExposureCount() {
        return riskExposureCount;
    }

    public void setRiskExposureCount(long riskExposureCount) {
        this.riskExposureCount = riskExposureCount;
    }

    public long getCompliantServices() {
        return compliantServices;
    }

    public void setCompliantServices(long compliantServices) {
        this.compliantServices = compliantServices;
    }

    public long getNonCompliantServices() {
        return nonCompliantServices;
    }

    public void setNonCompliantServices(long nonCompliantServices) {
        this.nonCompliantServices = nonCompliantServices;
    }
}