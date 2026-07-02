package com.rapido.platformservice.dto;

import java.time.LocalDateTime;

public class ExecutiveKpiResponse {

    private long dailyActiveUsers;
    private long monthlyActiveUsers;

    private double revenueGrowth;
    private double rideGrowth;

    private double driverRetention;
    private double customerRetention;

    private String businessStatus;

    private String timestamp;

    public ExecutiveKpiResponse() {
        this.timestamp = LocalDateTime.now().toString();
    }

    public long getDailyActiveUsers() {
        return dailyActiveUsers;
    }

    public void setDailyActiveUsers(long dailyActiveUsers) {
        this.dailyActiveUsers = dailyActiveUsers;
    }

    public long getMonthlyActiveUsers() {
        return monthlyActiveUsers;
    }

    public void setMonthlyActiveUsers(long monthlyActiveUsers) {
        this.monthlyActiveUsers = monthlyActiveUsers;
    }

    public double getRevenueGrowth() {
        return revenueGrowth;
    }

    public void setRevenueGrowth(double revenueGrowth) {
        this.revenueGrowth = revenueGrowth;
    }

    public double getRideGrowth() {
        return rideGrowth;
    }

    public void setRideGrowth(double rideGrowth) {
        this.rideGrowth = rideGrowth;
    }

    public double getDriverRetention() {
        return driverRetention;
    }

    public void setDriverRetention(double driverRetention) {
        this.driverRetention = driverRetention;
    }

    public double getCustomerRetention() {
        return customerRetention;
    }

    public void setCustomerRetention(double customerRetention) {
        this.customerRetention = customerRetention;
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}