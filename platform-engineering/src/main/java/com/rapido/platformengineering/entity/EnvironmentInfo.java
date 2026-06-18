package com.rapido.platformengineering.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "environment_info")
public class EnvironmentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String environmentName;

    private String owner;

    private String cpuUsage;

    private String memoryUsage;

    private String deploymentStatus;

    public EnvironmentInfo() {
    }

    public Long getId() {
        return id;
    }

    public String getEnvironmentName() {
        return environmentName;
    }

    public String getOwner() {
        return owner;
    }

    public String getCpuUsage() {
        return cpuUsage;
    }

    public String getMemoryUsage() {
        return memoryUsage;
    }

    public String getDeploymentStatus() {
        return deploymentStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setCpuUsage(String cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public void setMemoryUsage(String memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public void setDeploymentStatus(String deploymentStatus) {
        this.deploymentStatus = deploymentStatus;
    }
}