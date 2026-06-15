package com.rapido.multitenantservice.dto;

public class TenantHealthRequest {

    private String databaseStatus;
    private String apiStatus;
    private String notificationStatus;
    private String billingStatus;

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public String getApiStatus() {
        return apiStatus;
    }

    public void setApiStatus(String apiStatus) {
        this.apiStatus = apiStatus;
    }

    public String getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(String notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    public String getBillingStatus() {
        return billingStatus;
    }

    public void setBillingStatus(String billingStatus) {
        this.billingStatus = billingStatus;
    }
}