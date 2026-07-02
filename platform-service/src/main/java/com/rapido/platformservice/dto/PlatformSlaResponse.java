package com.rapido.platformservice.dto;

public class PlatformSlaResponse {

    private double availability;
    private double latency;
    private double errorBudget;
    private double sloCompliance;

    private String slaStatus;
    private String timestamp;

    public PlatformSlaResponse() {
    }

    public double getAvailability() {
        return availability;
    }

    public void setAvailability(double availability) {
        this.availability = availability;
    }

    public double getLatency() {
        return latency;
    }

    public void setLatency(double latency) {
        this.latency = latency;
    }

    public double getErrorBudget() {
        return errorBudget;
    }

    public void setErrorBudget(double errorBudget) {
        this.errorBudget = errorBudget;
    }

    public double getSloCompliance() {
        return sloCompliance;
    }

    public void setSloCompliance(double sloCompliance) {
        this.sloCompliance = sloCompliance;
    }

    public String getSlaStatus() {
        return slaStatus;
    }

    public void setSlaStatus(String slaStatus) {
        this.slaStatus = slaStatus;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}