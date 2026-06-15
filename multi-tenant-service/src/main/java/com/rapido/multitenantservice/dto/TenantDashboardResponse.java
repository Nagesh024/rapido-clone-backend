package com.rapido.multitenantservice.dto;

public class TenantDashboardResponse {

    private Long totalDrivers;
    private Long totalRides;
    private Long totalCustomers;
    private Double totalRevenue;

    public Long getTotalDrivers() {
        return totalDrivers;
    }

    public void setTotalDrivers(Long totalDrivers) {
        this.totalDrivers = totalDrivers;
    }

    public Long getTotalRides() {
        return totalRides;
    }

    public void setTotalRides(Long totalRides) {
        this.totalRides = totalRides;
    }

    public Long getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(Long totalCustomers) {
        this.totalCustomers = totalCustomers;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}