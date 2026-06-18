package com.rapido.platformengineering.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "platform_services")
public class PlatformServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "service_name")
    private String serviceName;

    private String owner;

    @Column(name = "repository_url")
    private String repositoryUrl;

    private String environment;

    private String sla;

    public PlatformServiceEntity() {
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