package com.rapido.multitenantservice.entity;

import com.rapido.multitenantservice.entity.base.BaseTenantEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "tenant_configuration")
public class TenantConfiguration extends BaseTenantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pricing_rule")
    private String pricingRule;

    @Column(name = "commission_rule")
    private String commissionRule;

    @Column(name = "ride_category")
    private String rideCategory;

    @Column(name = "notification_template")
    private String notificationTemplate;

    public Long getId() {
        return id;
    }

    public String getPricingRule() {
        return pricingRule;
    }

    public void setPricingRule(String pricingRule) {
        this.pricingRule = pricingRule;
    }

    public String getCommissionRule() {
        return commissionRule;
    }

    public void setCommissionRule(String commissionRule) {
        this.commissionRule = commissionRule;
    }

    public String getRideCategory() {
        return rideCategory;
    }

    public void setRideCategory(String rideCategory) {
        this.rideCategory = rideCategory;
    }

    public String getNotificationTemplate() {
        return notificationTemplate;
    }

    public void setNotificationTemplate(String notificationTemplate) {
        this.notificationTemplate = notificationTemplate;
    }
}