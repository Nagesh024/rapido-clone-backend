package com.rapido.platformengineering.kpi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "engineering_kpi")
public class EngineeringKPI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;

    private Integer deploymentFrequency;

    private Double changeFailureRate;

    private Double leadTimeHours;

    private Double mttrHours;

    private Double availability;

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

    public Integer getDeploymentFrequency() {
        return deploymentFrequency;
    }

    public void setDeploymentFrequency(Integer deploymentFrequency) {
        this.deploymentFrequency = deploymentFrequency;
    }

    public Double getChangeFailureRate() {
        return changeFailureRate;
    }

    public void setChangeFailureRate(Double changeFailureRate) {
        this.changeFailureRate = changeFailureRate;
    }

    public Double getLeadTimeHours() {
        return leadTimeHours;
    }

    public void setLeadTimeHours(Double leadTimeHours) {
        this.leadTimeHours = leadTimeHours;
    }

    public Double getMttrHours() {
        return mttrHours;
    }

    public void setMttrHours(Double mttrHours) {
        this.mttrHours = mttrHours;
    }

    public Double getAvailability() {
        return availability;
    }

    public void setAvailability(Double availability) {
        this.availability = availability;
    }
}