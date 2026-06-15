package com.rapido.multitenantservice.entity;

import com.rapido.multitenantservice.entity.base.BaseTenantEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "tenant_billing")
public class TenantBilling extends BaseTenantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plan;

    @Column(name = "monthly_charge")
    private Double monthlyCharge;

    @Column(name = "usage_charge")
    private Double usageCharge;

    @Column(name = "feature_charge")
    private Double featureCharge;

    @Column(name = "total_charge")
    private Double totalCharge;

    public Long getId() {
        return id;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public Double getMonthlyCharge() {
        return monthlyCharge;
    }

    public void setMonthlyCharge(Double monthlyCharge) {
        this.monthlyCharge = monthlyCharge;
    }

    public Double getUsageCharge() {
        return usageCharge;
    }

    public void setUsageCharge(Double usageCharge) {
        this.usageCharge = usageCharge;
    }

    public Double getFeatureCharge() {
        return featureCharge;
    }

    public void setFeatureCharge(Double featureCharge) {
        this.featureCharge = featureCharge;
    }

    public Double getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(Double totalCharge) {
        this.totalCharge = totalCharge;
    }
}