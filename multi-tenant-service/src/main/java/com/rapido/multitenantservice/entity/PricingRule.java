package com.rapido.multitenantservice.entity;

import com.rapido.multitenantservice.entity.base.BaseTenantEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "pricing_rules")
public class PricingRule extends BaseTenantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "base_fare")
    private Double baseFare;

    @Column(name = "surge_multiplier")
    private Double surgeMultiplier;

    @Column(name = "commission_percentage")
    private Double commissionPercentage;

    public Long getId() {
        return id;
    }

    public Double getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(Double baseFare) {
        this.baseFare = baseFare;
    }

    public Double getSurgeMultiplier() {
        return surgeMultiplier;
    }

    public void setSurgeMultiplier(Double surgeMultiplier) {
        this.surgeMultiplier = surgeMultiplier;
    }

    public Double getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(Double commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }
}