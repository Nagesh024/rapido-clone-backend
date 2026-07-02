package com.rapido.platformservice.dto;

import java.time.LocalDateTime;

public class FinancialDashboardResponse {

    private double totalRevenue;
    private double walletBalance;
    private double totalRefunds;
    private double settlements;
    private double gatewaySuccessRate;

    private String financialStatus;
    private String timestamp;

    public FinancialDashboardResponse() {
        this.timestamp = LocalDateTime.now().toString();
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public double getTotalRefunds() {
        return totalRefunds;
    }

    public void setTotalRefunds(double totalRefunds) {
        this.totalRefunds = totalRefunds;
    }

    public double getSettlements() {
        return settlements;
    }

    public void setSettlements(double settlements) {
        this.settlements = settlements;
    }

    public double getGatewaySuccessRate() {
        return gatewaySuccessRate;
    }

    public void setGatewaySuccessRate(double gatewaySuccessRate) {
        this.gatewaySuccessRate = gatewaySuccessRate;
    }

    public String getFinancialStatus() {
        return financialStatus;
    }

    public void setFinancialStatus(String financialStatus) {
        this.financialStatus = financialStatus;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}