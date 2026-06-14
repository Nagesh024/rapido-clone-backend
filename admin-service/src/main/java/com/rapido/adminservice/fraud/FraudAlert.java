package com.rapido.adminservice.fraud;

import jakarta.persistence.*;

@Entity
public class FraudAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String fraudType;

    private String description;

    private String severity;

    private Boolean resolved = false;

    public FraudAlert() {
    }

    public FraudAlert(Long userId, String fraudType, String description, String severity, Boolean resolved) {
        this.userId = userId;
        this.fraudType = fraudType;
        this.description = description;
        this.severity = severity;
        this.resolved = resolved;
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public String getFraudType() { return fraudType; }
    public String getDescription() { return description; }
    public String getSeverity() { return severity; }
    public Boolean getResolved() { return resolved; }

    public void setId(Long id) { this.id = id; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setFraudType(String fraudType) { this.fraudType = fraudType; }
    public void setDescription(String description) { this.description = description; }
    public void setSeverity(String severity) { this.severity = severity; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }
}