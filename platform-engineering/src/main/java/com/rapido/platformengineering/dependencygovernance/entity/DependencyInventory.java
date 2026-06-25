package com.rapido.platformengineering.dependencygovernance.entity;

import com.rapido.platformengineering.dependencygovernance.enums.DependencyStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "dependency_inventory")
public class DependencyInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dependencyName;

    private String version;

    private String licenseType;

    private Integer vulnerabilityCount;

    @Enumerated(EnumType.STRING)
    private DependencyStatus status;

    private Boolean approved;

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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public Integer getVulnerabilityCount() {
        return vulnerabilityCount;
    }

    public void setVulnerabilityCount(Integer vulnerabilityCount) {
        this.vulnerabilityCount = vulnerabilityCount;
    }

    public DependencyStatus getStatus() {
        return status;
    }

    public void setStatus(DependencyStatus status) {
        this.status = status;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
}