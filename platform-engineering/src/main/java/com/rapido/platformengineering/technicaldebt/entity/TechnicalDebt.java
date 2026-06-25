package com.rapido.platformengineering.technicaldebt.entity;

import com.rapido.platformengineering.technicaldebt.enums.DebtCategory;
import com.rapido.platformengineering.technicaldebt.enums.DebtSeverity;
import com.rapido.platformengineering.technicaldebt.enums.DebtStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "technical_debt")
public class TechnicalDebt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Enumerated(EnumType.STRING)
    private DebtSeverity severity;

    @Column(length = 5000)
    private String description;

    @Enumerated(EnumType.STRING)
    private DebtCategory category;

    private Integer riskScore;

    private Integer businessImpact;

    private Integer technicalImpact;

    private Integer probability;

    @Enumerated(EnumType.STRING)
    private DebtStatus status;

    private String owner;

    private LocalDate identifiedDate;

    private LocalDate targetResolutionDate;

    public TechnicalDebt() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DebtCategory getCategory() {
        return category;
    }

    public void setCategory(DebtCategory category) {
        this.category = category;
    }
    public DebtSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(DebtSeverity severity) {
        this.severity = severity;
    }

    public Integer getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(Integer riskScore) {
        this.riskScore = riskScore;
    }

    public Integer getBusinessImpact() {
        return businessImpact;
    }

    public void setBusinessImpact(Integer businessImpact) {
        this.businessImpact = businessImpact;
    }

    public Integer getTechnicalImpact() {
        return technicalImpact;
    }

    public void setTechnicalImpact(Integer technicalImpact) {
        this.technicalImpact = technicalImpact;
    }

    public Integer getProbability() {
        return probability;
    }

    public void setProbability(Integer probability) {
        this.probability = probability;
    }

    public DebtStatus getStatus() {
        return status;
    }

    public void setStatus(DebtStatus status) {
        this.status = status;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public LocalDate getIdentifiedDate() {
        return identifiedDate;
    }

    public void setIdentifiedDate(LocalDate identifiedDate) {
        this.identifiedDate = identifiedDate;
    }

    public LocalDate getTargetResolutionDate() {
        return targetResolutionDate;
    }

    public void setTargetResolutionDate(LocalDate targetResolutionDate) {
        this.targetResolutionDate = targetResolutionDate;
    }
}