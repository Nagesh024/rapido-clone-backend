package com.rapido.platformservice.dto;

import java.util.List;

public class SiemDashboardResponse {

    private int totalEvents;
    private int correlatedIncidents;
    private int criticalAlerts;
    private int highAlerts;
    private int mediumAlerts;
    private int lowAlerts;

    private List<String> eventSources;
    private List<String> threatTimeline;

    private String status;

    public int getTotalEvents() {
        return totalEvents;
    }

    public void setTotalEvents(int totalEvents) {
        this.totalEvents = totalEvents;
    }

    public int getCorrelatedIncidents() {
        return correlatedIncidents;
    }

    public void setCorrelatedIncidents(int correlatedIncidents) {
        this.correlatedIncidents = correlatedIncidents;
    }

    public int getCriticalAlerts() {
        return criticalAlerts;
    }

    public void setCriticalAlerts(int criticalAlerts) {
        this.criticalAlerts = criticalAlerts;
    }

    public int getHighAlerts() {
        return highAlerts;
    }

    public void setHighAlerts(int highAlerts) {
        this.highAlerts = highAlerts;
    }

    public int getMediumAlerts() {
        return mediumAlerts;
    }

    public void setMediumAlerts(int mediumAlerts) {
        this.mediumAlerts = mediumAlerts;
    }

    public int getLowAlerts() {
        return lowAlerts;
    }

    public void setLowAlerts(int lowAlerts) {
        this.lowAlerts = lowAlerts;
    }

    public List<String> getEventSources() {
        return eventSources;
    }

    public void setEventSources(List<String> eventSources) {
        this.eventSources = eventSources;
    }

    public List<String> getThreatTimeline() {
        return threatTimeline;
    }

    public void setThreatTimeline(List<String> threatTimeline) {
        this.threatTimeline = threatTimeline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}