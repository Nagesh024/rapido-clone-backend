package com.rapido.globalservice.analytics;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "international_analytics")
public class InternationalAnalytics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_code", nullable = false)
    private String countryCode;

    @Column(name = "currency_code", nullable = false)
    private String currencyCode;

    @Column(name = "region_code", nullable = false)
    private String regionCode;

    @Column(name = "total_revenue",
            precision = 19,
            scale = 2)
    private BigDecimal totalRevenue;

    @Column(name = "total_rides")
    private Long totalRides;

    @Column(name = "growth_percentage",
            precision = 10,
            scale = 2)
    private BigDecimal growthPercentage;

    @Column(name = "analytics_date")
    private Instant analyticsDate;

    public Long getId() {
        return id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public Long getTotalRides() {
        return totalRides;
    }

    public void setTotalRides(Long totalRides) {
        this.totalRides = totalRides;
    }

    public BigDecimal getGrowthPercentage() {
        return growthPercentage;
    }

    public void setGrowthPercentage(BigDecimal growthPercentage) {
        this.growthPercentage = growthPercentage;
    }

    public Instant getAnalyticsDate() {
        return analyticsDate;
    }

    public void setAnalyticsDate(Instant analyticsDate) {
        this.analyticsDate = analyticsDate;
    }
}