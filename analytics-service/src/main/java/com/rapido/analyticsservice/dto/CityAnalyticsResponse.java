package com.rapido.analyticsservice.dto;

import java.math.BigDecimal;

public class CityAnalyticsResponse {

    private String topCity;
    private Long rideDemand;
    private BigDecimal cityRevenue;

    public String getTopCity() {
        return topCity;
    }

    public void setTopCity(String topCity) {
        this.topCity = topCity;
    }

    public Long getRideDemand() {
        return rideDemand;
    }

    public void setRideDemand(Long rideDemand) {
        this.rideDemand = rideDemand;
    }

    public BigDecimal getCityRevenue() {
        return cityRevenue;
    }

    public void setCityRevenue(BigDecimal cityRevenue) {
        this.cityRevenue = cityRevenue;
    }
}