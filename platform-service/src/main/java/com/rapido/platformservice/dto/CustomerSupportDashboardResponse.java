package com.rapido.platformservice.dto;

import java.time.LocalDateTime;

public class CustomerSupportDashboardResponse {

    private int openTickets;
    private double averageResolutionTime;
    private int escalations;
    private int rideComplaints;
    private int refundRequests;

    private String supportStatus;
    private String timestamp;

    public CustomerSupportDashboardResponse() {
        this.timestamp = LocalDateTime.now().toString();
    }

    public int getOpenTickets() {
        return openTickets;
    }

    public void setOpenTickets(int openTickets) {
        this.openTickets = openTickets;
    }

    public double getAverageResolutionTime() {
        return averageResolutionTime;
    }

    public void setAverageResolutionTime(double averageResolutionTime) {
        this.averageResolutionTime = averageResolutionTime;
    }

    public int getEscalations() {
        return escalations;
    }

    public void setEscalations(int escalations) {
        this.escalations = escalations;
    }

    public int getRideComplaints() {
        return rideComplaints;
    }

    public void setRideComplaints(int rideComplaints) {
        this.rideComplaints = rideComplaints;
    }

    public int getRefundRequests() {
        return refundRequests;
    }

    public void setRefundRequests(int refundRequests) {
        this.refundRequests = refundRequests;
    }

    public String getSupportStatus() {
        return supportStatus;
    }

    public void setSupportStatus(String supportStatus) {
        this.supportStatus = supportStatus;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}