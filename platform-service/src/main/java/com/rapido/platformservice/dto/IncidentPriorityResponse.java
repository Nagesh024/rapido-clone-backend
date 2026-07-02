package com.rapido.platformservice.dto;

import java.time.LocalDateTime;

public class IncidentPriorityResponse {

    private int businessImpact;
    private int affectedUsers;
    private int revenueImpact;
    private int securityRisk;

    private int priorityScore;

    private String priorityLevel;

    private String timestamp;

    public IncidentPriorityResponse() {
        this.timestamp = LocalDateTime.now().toString();
    }

    public int getBusinessImpact() {
        return businessImpact;
    }

    public void setBusinessImpact(int businessImpact) {
        this.businessImpact = businessImpact;
    }

    public int getAffectedUsers() {
        return affectedUsers;
    }

    public void setAffectedUsers(int affectedUsers) {
        this.affectedUsers = affectedUsers;
    }

    public int getRevenueImpact() {
        return revenueImpact;
    }

    public void setRevenueImpact(int revenueImpact) {
        this.revenueImpact = revenueImpact;
    }

    public int getSecurityRisk() {
        return securityRisk;
    }

    public void setSecurityRisk(int securityRisk) {
        this.securityRisk = securityRisk;
    }

    public int getPriorityScore() {
        return priorityScore;
    }

    public void setPriorityScore(int priorityScore) {
        this.priorityScore = priorityScore;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}