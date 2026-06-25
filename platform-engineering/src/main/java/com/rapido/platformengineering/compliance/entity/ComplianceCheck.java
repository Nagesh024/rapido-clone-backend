package com.rapido.platformengineering.compliance.entity;

import com.rapido.platformengineering.compliance.enums.ComplianceStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "compliance_check")
public class ComplianceCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;

    private Boolean microserviceStandard;

    private Boolean apiStandard;

    private Boolean securityStandard;

    private Boolean deploymentStandard;

    @Enumerated(EnumType.STRING)
    private ComplianceStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Boolean getMicroserviceStandard() {
        return microserviceStandard;
    }

    public void setMicroserviceStandard(Boolean microserviceStandard) {
        this.microserviceStandard = microserviceStandard;
    }

    public Boolean getApiStandard() {
        return apiStandard;
    }

    public void setApiStandard(Boolean apiStandard) {
        this.apiStandard = apiStandard;
    }

    public Boolean getSecurityStandard() {
        return securityStandard;
    }

    public void setSecurityStandard(Boolean securityStandard) {
        this.securityStandard = securityStandard;
    }

    public Boolean getDeploymentStandard() {
        return deploymentStandard;
    }

    public void setDeploymentStandard(Boolean deploymentStandard) {
        this.deploymentStandard = deploymentStandard;
    }

    public ComplianceStatus getStatus() {
        return status;
    }

    public void setStatus(ComplianceStatus status) {
        this.status = status;
    }
}