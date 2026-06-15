package com.rapido.multitenantservice.dto;

public class UsageTrackingRequest {

    private Long apiCalls;
    private Long rides;
    private Long drivers;
    private Long storageUsageMb;

    public Long getApiCalls() {
        return apiCalls;
    }

    public void setApiCalls(Long apiCalls) {
        this.apiCalls = apiCalls;
    }

    public Long getRides() {
        return rides;
    }

    public void setRides(Long rides) {
        this.rides = rides;
    }

    public Long getDrivers() {
        return drivers;
    }

    public void setDrivers(Long drivers) {
        this.drivers = drivers;
    }

    public Long getStorageUsageMb() {
        return storageUsageMb;
    }

    public void setStorageUsageMb(Long storageUsageMb) {
        this.storageUsageMb = storageUsageMb;
    }
}