package com.rapido.platformservice.dto;

import java.util.List;

public class FraudDashboardResponse {

    private List<String> highRiskUsers;
    private List<String> highRiskDrivers;
    private List<String> paymentFraud;
    private List<String> walletAbuse;
    private List<String> promoAbuse;

    private int totalFraudCases;

    private String investigationStatus;

    public List<String> getHighRiskUsers() {
        return highRiskUsers;
    }

    public void setHighRiskUsers(List<String> highRiskUsers) {
        this.highRiskUsers = highRiskUsers;
    }

    public List<String> getHighRiskDrivers() {
        return highRiskDrivers;
    }

    public void setHighRiskDrivers(List<String> highRiskDrivers) {
        this.highRiskDrivers = highRiskDrivers;
    }

    public List<String> getPaymentFraud() {
        return paymentFraud;
    }

    public void setPaymentFraud(List<String> paymentFraud) {
        this.paymentFraud = paymentFraud;
    }

    public List<String> getWalletAbuse() {
        return walletAbuse;
    }

    public void setWalletAbuse(List<String> walletAbuse) {
        this.walletAbuse = walletAbuse;
    }

    public List<String> getPromoAbuse() {
        return promoAbuse;
    }

    public void setPromoAbuse(List<String> promoAbuse) {
        this.promoAbuse = promoAbuse;
    }

    public int getTotalFraudCases() {
        return totalFraudCases;
    }

    public void setTotalFraudCases(int totalFraudCases) {
        this.totalFraudCases = totalFraudCases;
    }

    public String getInvestigationStatus() {
        return investigationStatus;
    }

    public void setInvestigationStatus(String investigationStatus) {
        this.investigationStatus = investigationStatus;
    }
}