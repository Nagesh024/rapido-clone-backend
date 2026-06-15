package com.rapido.multitenantservice.dto;

public class TenantConfigurationRequest {

    private String pricingRule;
    private String commissionRule;
    private String rideCategory;
    private String notificationTemplate;

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