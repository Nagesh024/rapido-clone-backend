package com.rapido.multitenantservice.dto;

public class PricingRuleRequest {

    private Double baseFare;
    private Double surgeMultiplier;
    private Double commissionPercentage;

    public Double getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(Double baseFare) {
        this.baseFare = baseFare;
    }

    public Double getSurgeMultiplier() {
        return surgeMultiplier;
    }

    public void setSurgeMultiplier(Double surgeMultiplier) {
        this.surgeMultiplier = surgeMultiplier;
    }

    public Double getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(Double commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }
}