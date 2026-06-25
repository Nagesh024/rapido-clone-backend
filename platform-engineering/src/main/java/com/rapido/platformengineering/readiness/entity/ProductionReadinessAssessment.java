package com.rapido.platformengineering.readiness.entity;

import com.rapido.platformengineering.readiness.enums.ReadinessStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "production_readiness_assessment")
public class ProductionReadinessAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;

    private Integer monitoringScore;

    private Integer securityScore;

    private Integer performanceScore;

    private Integer scalabilityScore;

    private Integer disasterRecoveryScore;

    private Integer complianceScore;

    private Integer totalScore;

    @Enumerated(EnumType.STRING)
    private ReadinessStatus status;

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

    public Integer getMonitoringScore() {
        return monitoringScore;
    }

    public void setMonitoringScore(Integer monitoringScore) {
        this.monitoringScore = monitoringScore;
    }

    public Integer getSecurityScore() {
        return securityScore;
    }

    public void setSecurityScore(Integer securityScore) {
        this.securityScore = securityScore;
    }

    public Integer getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(Integer performanceScore) {
        this.performanceScore = performanceScore;
    }

    public Integer getScalabilityScore() {
        return scalabilityScore;
    }

    public void setScalabilityScore(Integer scalabilityScore) {
        this.scalabilityScore = scalabilityScore;
    }

    public Integer getDisasterRecoveryScore() {
        return disasterRecoveryScore;
    }

    public void setDisasterRecoveryScore(Integer disasterRecoveryScore) {
        this.disasterRecoveryScore = disasterRecoveryScore;
    }

    public Integer getComplianceScore() {
        return complianceScore;
    }

    public void setComplianceScore(Integer complianceScore) {
        this.complianceScore = complianceScore;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public ReadinessStatus getStatus() {
        return status;
    }

    public void setStatus(ReadinessStatus status) {
        this.status = status;
    }
}