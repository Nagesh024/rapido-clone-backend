package com.rapido.multitenantservice.entity;

import com.rapido.multitenantservice.entity.base.BaseTenantEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "subscription_plans")
public class SubscriptionPlan extends BaseTenantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String planName;

    private Integer rideLimit;

    private Integer driverLimit;

    private Boolean analyticsAccess;

    private Boolean mlFeatures;

    public Long getId() {
        return id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Integer getRideLimit() {
        return rideLimit;
    }

    public void setRideLimit(Integer rideLimit) {
        this.rideLimit = rideLimit;
    }

    public Integer getDriverLimit() {
        return driverLimit;
    }

    public void setDriverLimit(Integer driverLimit) {
        this.driverLimit = driverLimit;
    }

    public Boolean getAnalyticsAccess() {
        return analyticsAccess;
    }

    public void setAnalyticsAccess(Boolean analyticsAccess) {
        this.analyticsAccess = analyticsAccess;
    }

    public Boolean getMlFeatures() {
        return mlFeatures;
    }

    public void setMlFeatures(Boolean mlFeatures) {
        this.mlFeatures = mlFeatures;
    }
}