package com.rapido.platformengineering.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "service_catalog")
public class ServiceCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;

    private String owner;

    private String repositoryUrl;

    private String environment;

    private String sla;

    public ServiceCatalog() {
    }

    public Long getId() {
        return id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getOwner() {
        return owner;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getSla() {
        return sla;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public void setSla(String sla) {
        this.sla = sla;
    }
}