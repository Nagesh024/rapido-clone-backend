package com.rapido.platformengineering.governance.dto;

public class GovernanceDashboardResponse {

    private long totalTechnicalDebt;
    private long totalRisks;
    private long totalComplianceChecks;
    private long compliantServices;
    private long nonCompliantServices;
    private long productionReadyServices;
    private long notReadyServices;

    public long getTotalTechnicalDebt() {
        return totalTechnicalDebt;
    }

    public void setTotalTechnicalDebt(long totalTechnicalDebt) {
        this.totalTechnicalDebt = totalTechnicalDebt;
    }

    public long getTotalRisks() {
        return totalRisks;
    }

    public void setTotalRisks(long totalRisks) {
        this.totalRisks = totalRisks;
    }

    public long getTotalComplianceChecks() {
        return totalComplianceChecks;
    }

    public void setTotalComplianceChecks(long totalComplianceChecks) {
        this.totalComplianceChecks = totalComplianceChecks;
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

    public long getProductionReadyServices() {
        return productionReadyServices;
    }

    public void setProductionReadyServices(long productionReadyServices) {
        this.productionReadyServices = productionReadyServices;
    }

    public long getNotReadyServices() {
        return notReadyServices;
    }

    public void setNotReadyServices(long notReadyServices) {
        this.notReadyServices = notReadyServices;
    }
}