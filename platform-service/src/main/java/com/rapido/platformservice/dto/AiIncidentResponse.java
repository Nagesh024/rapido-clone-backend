package com.rapido.platformservice.dto;

import java.util.List;

public class AiIncidentResponse {

    private boolean abnormalTraffic;
    private boolean unexpectedLoginPattern;
    private boolean paymentFraud;
    private boolean rideFraud;
    private boolean resourceSpike;

    private int aiRiskScore;

    private String severity;

    private List<String> alerts;

    public boolean isAbnormalTraffic() {
        return abnormalTraffic;
    }

    public void setAbnormalTraffic(boolean abnormalTraffic) {
        this.abnormalTraffic = abnormalTraffic;
    }

    public boolean isUnexpectedLoginPattern() {
        return unexpectedLoginPattern;
    }

    public void setUnexpectedLoginPattern(boolean unexpectedLoginPattern) {
        this.unexpectedLoginPattern = unexpectedLoginPattern;
    }

    public boolean isPaymentFraud() {
        return paymentFraud;
    }

    public void setPaymentFraud(boolean paymentFraud) {
        this.paymentFraud = paymentFraud;
    }

    public boolean isRideFraud() {
        return rideFraud;
    }

    public void setRideFraud(boolean rideFraud) {
        this.rideFraud = rideFraud;
    }

    public boolean isResourceSpike() {
        return resourceSpike;
    }

    public void setResourceSpike(boolean resourceSpike) {
        this.resourceSpike = resourceSpike;
    }

    public int getAiRiskScore() {
        return aiRiskScore;
    }

    public void setAiRiskScore(int aiRiskScore) {
        this.aiRiskScore = aiRiskScore;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public List<String> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<String> alerts) {
        this.alerts = alerts;
    }
}