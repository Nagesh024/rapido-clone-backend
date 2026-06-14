package com.rapido.analyticsservice.dto;

import java.math.BigDecimal;

public class HealthSummaryResponse {

    private String analyticsStatus;

    private Long totalRides;

    private BigDecimal totalRevenue;

    private Long totalAuditEvents;

    private Boolean reportsEnabled;

    private Boolean auditEnabled;

    public String getAnalyticsStatus() {
        return analyticsStatus;
    }

    public void setAnalyticsStatus(String analyticsStatus) {
        this.analyticsStatus = analyticsStatus;
    }

    public Long getTotalRides() {
        return totalRides;
    }

    public void setTotalRides(Long totalRides) {
        this.totalRides = totalRides;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public Long getTotalAuditEvents() {
        return totalAuditEvents;
    }

    public void setTotalAuditEvents(Long totalAuditEvents) {
        this.totalAuditEvents = totalAuditEvents;
    }

    public Boolean getReportsEnabled() {
        return reportsEnabled;
    }

    public void setReportsEnabled(Boolean reportsEnabled) {
        this.reportsEnabled = reportsEnabled;
    }

    public Boolean getAuditEnabled() {
        return auditEnabled;
    }

    public void setAuditEnabled(Boolean auditEnabled) {
        this.auditEnabled = auditEnabled;
    }
}