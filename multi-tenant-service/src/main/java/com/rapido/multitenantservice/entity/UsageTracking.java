package com.rapido.multitenantservice.entity;

import com.rapido.multitenantservice.entity.base.BaseTenantEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "usage_tracking")
public class UsageTracking extends BaseTenantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "api_calls")
    private Long apiCalls;

    @Column(name = "rides")
    private Long rides;

    @Column(name = "drivers")
    private Long drivers;

    @Column(name = "storage_usage_mb")
    private Long storageUsageMb;

    public Long getId() {
        return id;
    }

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