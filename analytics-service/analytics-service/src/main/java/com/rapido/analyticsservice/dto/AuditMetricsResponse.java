package com.rapido.analyticsservice.dto;

public class AuditMetricsResponse {

    private Long totalEvents;
    private Long rideEvents;
    private Long paymentEvents;
    private Long driverEvents;
    private Long notificationEvents;

    public Long getTotalEvents() {
        return totalEvents;
    }

    public void setTotalEvents(Long totalEvents) {
        this.totalEvents = totalEvents;
    }

    public Long getRideEvents() {
        return rideEvents;
    }

    public void setRideEvents(Long rideEvents) {
        this.rideEvents = rideEvents;
    }

    public Long getPaymentEvents() {
        return paymentEvents;
    }

    public void setPaymentEvents(Long paymentEvents) {
        this.paymentEvents = paymentEvents;
    }

    public Long getDriverEvents() {
        return driverEvents;
    }

    public void setDriverEvents(Long driverEvents) {
        this.driverEvents = driverEvents;
    }

    public Long getNotificationEvents() {
        return notificationEvents;
    }

    public void setNotificationEvents(Long notificationEvents) {
        this.notificationEvents = notificationEvents;
    }
}