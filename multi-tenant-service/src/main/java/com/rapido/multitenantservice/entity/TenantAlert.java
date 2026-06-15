package com.rapido.multitenantservice.entity;

import com.rapido.multitenantservice.entity.base.BaseTenantEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "tenant_alerts")
public class TenantAlert extends BaseTenantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String alertType;

    private String alertMessage;

    private String severity;

    private String status;

    public Long getId() {
        return id;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}