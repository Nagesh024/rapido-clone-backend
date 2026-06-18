package com.rapido.platformengineering.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dora_metrics")
public class DoraMetric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer deploymentsPerDay;

    private Double leadTimeHours;

    private Double mttrHours;

    private Double changeFailureRate;

    public DoraMetric() {
    }

    public Long getId() {
        return id;
    }

    public Integer getDeploymentsPerDay() {
        return deploymentsPerDay;
    }

    public Double getLeadTimeHours() {
        return leadTimeHours;
    }

    public Double getMttrHours() {
        return mttrHours;
    }

    public Double getChangeFailureRate() {
        return changeFailureRate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDeploymentsPerDay(Integer deploymentsPerDay) {
        this.deploymentsPerDay = deploymentsPerDay;
    }

    public void setLeadTimeHours(Double leadTimeHours) {
        this.leadTimeHours = leadTimeHours;
    }

    public void setMttrHours(Double mttrHours) {
        this.mttrHours = mttrHours;
    }

    public void setChangeFailureRate(Double changeFailureRate) {
        this.changeFailureRate = changeFailureRate;
    }
}