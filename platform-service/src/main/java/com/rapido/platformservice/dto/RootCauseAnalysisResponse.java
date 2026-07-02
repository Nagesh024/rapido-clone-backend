package com.rapido.platformservice.dto;

import java.time.LocalDateTime;
import java.util.List;

public class RootCauseAnalysisResponse {

    private boolean infrastructureIssue;
    private boolean applicationIssue;
    private boolean databaseIssue;
    private boolean networkIssue;

    private String rootCause;

    private String severity;

    private List<String> evidence;

    private String timestamp;

    public RootCauseAnalysisResponse() {
        this.timestamp = LocalDateTime.now().toString();
    }

    public boolean isInfrastructureIssue() {
        return infrastructureIssue;
    }

    public void setInfrastructureIssue(boolean infrastructureIssue) {
        this.infrastructureIssue = infrastructureIssue;
    }

    public boolean isApplicationIssue() {
        return applicationIssue;
    }

    public void setApplicationIssue(boolean applicationIssue) {
        this.applicationIssue = applicationIssue;
    }

    public boolean isDatabaseIssue() {
        return databaseIssue;
    }

    public void setDatabaseIssue(boolean databaseIssue) {
        this.databaseIssue = databaseIssue;
    }

    public boolean isNetworkIssue() {
        return networkIssue;
    }

    public void setNetworkIssue(boolean networkIssue) {
        this.networkIssue = networkIssue;
    }

    public String getRootCause() {
        return rootCause;
    }

    public void setRootCause(String rootCause) {
        this.rootCause = rootCause;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public List<String> getEvidence() {
        return evidence;
    }

    public void setEvidence(List<String> evidence) {
        this.evidence = evidence;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}