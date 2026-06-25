package com.rapido.platformengineering.technicaldebt.dto;

public class TechnicalDebtDashboardResponse {

    private long totalDebts;
    private long openDebts;
    private long resolvedDebts;

    private long architectureDebts;
    private long securityDebts;
    private long performanceDebts;
    private long infrastructureDebts;
    private long codeQualityDebts;
    private long documentationDebts;

    private long totalRiskScore;

    private long lowSeverity;
    private long mediumSeverity;
    private long highSeverity;
    private long criticalSeverity;

    public long getTotalDebts() {
        return totalDebts;
    }

    public void setTotalDebts(long totalDebts) {
        this.totalDebts = totalDebts;
    }

    public long getOpenDebts() {
        return openDebts;
    }

    public void setOpenDebts(long openDebts) {
        this.openDebts = openDebts;
    }

    public long getResolvedDebts() {
        return resolvedDebts;
    }

    public void setResolvedDebts(long resolvedDebts) {
        this.resolvedDebts = resolvedDebts;
    }

    public long getArchitectureDebts() {
        return architectureDebts;
    }

    public void setArchitectureDebts(long architectureDebts) {
        this.architectureDebts = architectureDebts;
    }

    public long getSecurityDebts() {
        return securityDebts;
    }

    public void setSecurityDebts(long securityDebts) {
        this.securityDebts = securityDebts;
    }

    public long getPerformanceDebts() {
        return performanceDebts;
    }

    public void setPerformanceDebts(long performanceDebts) {
        this.performanceDebts = performanceDebts;
    }

    public long getInfrastructureDebts() {
        return infrastructureDebts;
    }

    public void setInfrastructureDebts(long infrastructureDebts) {
        this.infrastructureDebts = infrastructureDebts;
    }

    public long getCodeQualityDebts() {
        return codeQualityDebts;
    }

    public void setCodeQualityDebts(long codeQualityDebts) {
        this.codeQualityDebts = codeQualityDebts;
    }

    public long getDocumentationDebts() {
        return documentationDebts;
    }

    public void setDocumentationDebts(long documentationDebts) {
        this.documentationDebts = documentationDebts;
    }

    public long getTotalRiskScore() {
        return totalRiskScore;
    }

    public void setTotalRiskScore(long totalRiskScore) {
        this.totalRiskScore = totalRiskScore;
    }

    public long getLowSeverity() {
        return lowSeverity;
    }

    public void setLowSeverity(long lowSeverity) {
        this.lowSeverity = lowSeverity;
    }

    public long getMediumSeverity() {
        return mediumSeverity;
    }

    public void setMediumSeverity(long mediumSeverity) {
        this.mediumSeverity = mediumSeverity;
    }

    public long getHighSeverity() {
        return highSeverity;
    }

    public void setHighSeverity(long highSeverity) {
        this.highSeverity = highSeverity;
    }

    public long getCriticalSeverity() {
        return criticalSeverity;
    }

    public void setCriticalSeverity(long criticalSeverity) {
        this.criticalSeverity = criticalSeverity;
    }
}