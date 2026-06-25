package com.rapido.platformengineering.certification.entity;

import com.rapido.platformengineering.certification.enums.CertificationStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "production_certification")
public class ProductionCertification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;

    private Boolean securityValidated;

    private Boolean performanceValidated;

    private Boolean monitoringValidated;

    private Boolean recoveryValidated;

    private Boolean complianceValidated;

    private Boolean documentationValidated;

    @Enumerated(EnumType.STRING)
    private CertificationStatus certificationStatus;

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

    public Boolean getSecurityValidated() {
        return securityValidated;
    }

    public void setSecurityValidated(Boolean securityValidated) {
        this.securityValidated = securityValidated;
    }

    public Boolean getPerformanceValidated() {
        return performanceValidated;
    }

    public void setPerformanceValidated(Boolean performanceValidated) {
        this.performanceValidated = performanceValidated;
    }

    public Boolean getMonitoringValidated() {
        return monitoringValidated;
    }

    public void setMonitoringValidated(Boolean monitoringValidated) {
        this.monitoringValidated = monitoringValidated;
    }

    public Boolean getRecoveryValidated() {
        return recoveryValidated;
    }

    public void setRecoveryValidated(Boolean recoveryValidated) {
        this.recoveryValidated = recoveryValidated;
    }

    public Boolean getComplianceValidated() {
        return complianceValidated;
    }

    public void setComplianceValidated(Boolean complianceValidated) {
        this.complianceValidated = complianceValidated;
    }

    public Boolean getDocumentationValidated() {
        return documentationValidated;
    }

    public void setDocumentationValidated(Boolean documentationValidated) {
        this.documentationValidated = documentationValidated;
    }

    public CertificationStatus getCertificationStatus() {
        return certificationStatus;
    }

    public void setCertificationStatus(
            CertificationStatus certificationStatus) {

        this.certificationStatus = certificationStatus;
    }
}