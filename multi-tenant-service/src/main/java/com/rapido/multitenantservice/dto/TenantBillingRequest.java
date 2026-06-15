package com.rapido.multitenantservice.dto;

public class TenantBillingRequest {

    private String plan;
    private Double monthlyCharge;

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public Double getMonthlyCharge() {
        return monthlyCharge;
    }

    public void setMonthlyCharge(Double monthlyCharge) {
        this.monthlyCharge = monthlyCharge;
    }
}