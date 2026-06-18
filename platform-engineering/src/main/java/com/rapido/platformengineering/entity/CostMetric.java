package com.rapido.platformengineering.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cost_metrics")
public class CostMetric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double environmentCost;
    private Double serviceCost;
    private Double clusterCost;
    private Double databaseCost;
    private Double teamCost;

    public CostMetric() {}

    public Long getId() {
        return id;
    }

    public Double getEnvironmentCost() {
        return environmentCost;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public Double getClusterCost() {
        return clusterCost;
    }

    public Double getDatabaseCost() {
        return databaseCost;
    }

    public Double getTeamCost() {
        return teamCost;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEnvironmentCost(Double environmentCost) {
        this.environmentCost = environmentCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public void setClusterCost(Double clusterCost) {
        this.clusterCost = clusterCost;
    }

    public void setDatabaseCost(Double databaseCost) {
        this.databaseCost = databaseCost;
    }

    public void setTeamCost(Double teamCost) {
        this.teamCost = teamCost;
    }
}