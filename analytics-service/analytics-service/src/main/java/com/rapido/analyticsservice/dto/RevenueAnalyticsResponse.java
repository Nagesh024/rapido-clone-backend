package com.rapido.analyticsservice.dto;

import java.math.BigDecimal;

public class RevenueAnalyticsResponse {

    private BigDecimal revenuePerDay;

    private BigDecimal revenuePerDriver;

    private BigDecimal platformCommission;

    public BigDecimal getRevenuePerDay() {
        return revenuePerDay;
    }

    public void setRevenuePerDay(
            BigDecimal revenuePerDay) {

        this.revenuePerDay = revenuePerDay;
    }

    public BigDecimal getRevenuePerDriver() {
        return revenuePerDriver;
    }

    public void setRevenuePerDriver(
            BigDecimal revenuePerDriver) {

        this.revenuePerDriver =
                revenuePerDriver;
    }

    public BigDecimal getPlatformCommission() {
        return platformCommission;
    }

    public void setPlatformCommission(
            BigDecimal platformCommission) {

        this.platformCommission =
                platformCommission;
    }
}