package com.rapido.analyticsservice.dto;

public class CustomerAnalyticsResponse {

    private Long totalCustomers;
    private Long returningCustomers;
    private Double retentionRate;
    private Double churnRate;

    public Long getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(Long totalCustomers) {
        this.totalCustomers = totalCustomers;
    }

    public Long getReturningCustomers() {
        return returningCustomers;
    }

    public void setReturningCustomers(Long returningCustomers) {
        this.returningCustomers = returningCustomers;
    }

    public Double getRetentionRate() {
        return retentionRate;
    }

    public void setRetentionRate(Double retentionRate) {
        this.retentionRate = retentionRate;
    }

    public Double getChurnRate() {
        return churnRate;
    }

    public void setChurnRate(Double churnRate) {
        this.churnRate = churnRate;
    }
}