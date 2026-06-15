package com.rapido.multitenantservice.entity;

import com.rapido.multitenantservice.entity.base.BaseTenantEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "feature_flags")
public class FeatureFlag extends BaseTenantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chat_enabled")
    private Boolean chatEnabled;

    @Column(name = "ml_forecast_enabled")
    private Boolean mlForecastEnabled;

    @Column(name = "wallet_enabled")
    private Boolean walletEnabled;

    @Column(name = "fraud_detection_enabled")
    private Boolean fraudDetectionEnabled;

    public Long getId() {
        return id;
    }

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