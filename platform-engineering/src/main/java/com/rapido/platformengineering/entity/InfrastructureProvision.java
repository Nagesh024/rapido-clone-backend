package com.rapido.platformengineering.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "infrastructure_provision")
public class InfrastructureProvision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String environment;

    private String serviceName;

    private String status;

    public InfrastructureProvision() {
    }

    public Long getId() {
        return id;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}