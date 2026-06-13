package com.rapido.globalservice.pricing;

import java.math.BigDecimal;

public class PricingResponse {

    private BigDecimal baseFare;
    private BigDecimal cityAdjustment;
    private BigDecimal surgeAmount;
    private BigDecimal taxAmount;
    private BigDecimal totalFare;

    public BigDecimal getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(BigDecimal baseFare) {
        this.baseFare = baseFare;
    }

    public BigDecimal getCityAdjustment() {
        return cityAdjustment;
    }

    public void setCityAdjustment(BigDecimal cityAdjustment) {
        this.cityAdjustment = cityAdjustment;
    }

    public BigDecimal getSurgeAmount() {
        return surgeAmount;
    }

    public void setSurgeAmount(BigDecimal surgeAmount) {
        this.surgeAmount = surgeAmount;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(BigDecimal totalFare) {
        this.totalFare = totalFare;
    }
}