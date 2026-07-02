package com.rapido.platformservice.dto;

import java.time.LocalDateTime;

public class AiPredictionDashboardResponse {

    private int demandForecast;
    private double surgeForecast;
    private int driverShortage;
    private double revenuePrediction;

    private String predictionStatus;
    private String timestamp;

    public AiPredictionDashboardResponse() {
        this.timestamp = LocalDateTime.now().toString();
    }

    public int getDemandForecast() {
        return demandForecast;
    }

    public void setDemandForecast(int demandForecast) {
        this.demandForecast = demandForecast;
    }

    public double getSurgeForecast() {
        return surgeForecast;
    }

    public void setSurgeForecast(double surgeForecast) {
        this.surgeForecast = surgeForecast;
    }

    public int getDriverShortage() {
        return driverShortage;
    }

    public void setDriverShortage(int driverShortage) {
        this.driverShortage = driverShortage;
    }

    public double getRevenuePrediction() {
        return revenuePrediction;
    }

    public void setRevenuePrediction(double revenuePrediction) {
        this.revenuePrediction = revenuePrediction;
    }

    public String getPredictionStatus() {
        return predictionStatus;
    }

    public void setPredictionStatus(String predictionStatus) {
        this.predictionStatus = predictionStatus;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}