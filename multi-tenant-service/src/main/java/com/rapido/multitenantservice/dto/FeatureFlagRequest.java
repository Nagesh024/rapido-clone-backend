package com.rapido.multitenantservice.dto;

public class FeatureFlagRequest {

    private Boolean chatEnabled;
    private Boolean mlForecastEnabled;
    private Boolean walletEnabled;
    private Boolean fraudDetectionEnabled;

    public Boolean getChatEnabled() {
        return chatEnabled;
    }

    public void setChatEnabled(Boolean chatEnabled) {
        this.chatEnabled = chatEnabled;
    }

    public Boolean getMlForecastEnabled() {
        return mlForecastEnabled;
    }

    public void setMlForecastEnabled(Boolean mlForecastEnabled) {
        this.mlForecastEnabled = mlForecastEnabled;
    }

    public Boolean getWalletEnabled() {
        return walletEnabled;
    }

    public void setWalletEnabled(Boolean walletEnabled) {
        this.walletEnabled = walletEnabled;
    }

    public Boolean getFraudDetectionEnabled() {
        return fraudDetectionEnabled;
    }

    public void setFraudDetectionEnabled(Boolean fraudDetectionEnabled) {
        this.fraudDetectionEnabled = fraudDetectionEnabled;
    }
}