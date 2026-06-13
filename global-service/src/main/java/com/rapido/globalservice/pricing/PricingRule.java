package com.rapido.globalservice.pricing;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "pricing_rules")
public class PricingRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_code", nullable = false)
    private String countryCode;

    @Column(name = "city_code", nullable = false)
    private String cityCode;

    @Column(name = "vehicle_type", nullable = false)
    private String vehicleType;

    @Column(name = "base_fare", precision = 19, scale = 2)
    private BigDecimal baseFare;

    @Column(name = "city_adjustment", precision = 19, scale = 2)
    private BigDecimal cityAdjustment;

    @Column(name = "tax_percentage", precision = 10, scale = 2)
    private BigDecimal taxPercentage;

    @Column(name = "peak_surge_multiplier", precision = 10, scale = 2)
    private BigDecimal peakSurgeMultiplier;

    public PricingRule() {
    }

    public Long getId() {
        return id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

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

    public BigDecimal getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(BigDecimal taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public BigDecimal getPeakSurgeMultiplier() {
        return peakSurgeMultiplier;
    }

    public void setPeakSurgeMultiplier(BigDecimal peakSurgeMultiplier) {
        this.peakSurgeMultiplier = peakSurgeMultiplier;
    }
}