package com.rapido.platformservice.dto;

import java.time.LocalDateTime;

public class GlobalOperationsResponse {

    private String region;

    private String country;

    private String regionHealth;

    private double countryRevenue;

    private int countryDemand;

    private int countryIncidents;

    private String overallStatus;

    private String timestamp;

    public GlobalOperationsResponse() {
        this.timestamp = LocalDateTime.now().toString();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegionHealth() {
        return regionHealth;
    }

    public void setRegionHealth(String regionHealth) {
        this.regionHealth = regionHealth;
    }

    public double getCountryRevenue() {
        return countryRevenue;
    }

    public void setCountryRevenue(double countryRevenue) {
        this.countryRevenue = countryRevenue;
    }

    public int getCountryDemand() {
        return countryDemand;
    }

    public void setCountryDemand(int countryDemand) {
        this.countryDemand = countryDemand;
    }

    public int getCountryIncidents() {
        return countryIncidents;
    }

    public void setCountryIncidents(int countryIncidents) {
        this.countryIncidents = countryIncidents;
    }

    public String getOverallStatus() {
        return overallStatus;
    }

    public void setOverallStatus(String overallStatus) {
        this.overallStatus = overallStatus;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}