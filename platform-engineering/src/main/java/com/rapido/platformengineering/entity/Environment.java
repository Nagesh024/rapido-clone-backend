package com.rapido.platformengineering.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "environments")
public class Environment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String environmentName;

    private String owner;

    private String status;

    private String clusterName;

    private String namespace;

    public Environment() {
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

    public String getStatus() {
        return status;
    }

    public String getClusterName() {
        return clusterName;
    }

    public String getNamespace() {
        return namespace;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
}