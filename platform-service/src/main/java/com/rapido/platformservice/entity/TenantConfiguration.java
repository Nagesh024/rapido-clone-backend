package com.rapido.platformservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tenant_configurations")
public class TenantConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenantName;

    private String paymentGateway;

    private String smsProvider;

    public TenantConfiguration() {
    }

    public TenantConfiguration(Long id, String tenantName, String paymentGateway, String smsProvider) {
        this.id = id;
        this.tenantName = tenantName;
        this.paymentGateway = paymentGateway;
        this.smsProvider = smsProvider;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getPaymentGateway() {
        return paymentGateway;
    }

    public void setPaymentGateway(String paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String getSmsProvider() {
        return smsProvider;
    }

    public void setSmsProvider(String smsProvider) {
        this.smsProvider = smsProvider;
    }
}