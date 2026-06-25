package com.rapido.platformengineering.dependencyscanner.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dependency_scan_results")
public class DependencyScanResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dependencyName;

    private String vulnerabilityId;

    private String severity;

    private Double cvssScore;

    private Boolean buildBlocked;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDependencyName() {
        return dependencyName;
    }

    public void setDependencyName(String dependencyName) {
        this.dependencyName = dependencyName;
    }

    public String getVulnerabilityId() {
        return vulnerabilityId;
    }

    public void setVulnerabilityId(String vulnerabilityId) {
        this.vulnerabilityId = vulnerabilityId;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Double getCvssScore() {
        return cvssScore;
    }

    public void setCvssScore(Double cvssScore) {
        this.cvssScore = cvssScore;
    }

    public Boolean getBuildBlocked() {
        return buildBlocked;
    }

    public void setBuildBlocked(Boolean buildBlocked) {
        this.buildBlocked = buildBlocked;
    }
}