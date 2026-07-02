package com.rapido.platformservice.dto;

import java.time.LocalDateTime;
import java.util.List;

public class IncidentTimelineResponse {

    private String incidentId;

    private List<String> timeline;

    private String currentStatus;

    private String assignedEngineer;

    private String timestamp;

    public IncidentTimelineResponse() {
        this.timestamp = LocalDateTime.now().toString();
    }

    public String getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }

    public List<String> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<String> timeline) {
        this.timeline = timeline;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getAssignedEngineer() {
        return assignedEngineer;
    }

    public void setAssignedEngineer(String assignedEngineer) {
        this.assignedEngineer = assignedEngineer;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}