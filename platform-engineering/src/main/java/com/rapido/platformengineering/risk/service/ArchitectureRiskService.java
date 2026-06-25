package com.rapido.platformengineering.risk.service;

import com.rapido.platformengineering.risk.entity.ArchitectureRisk;
import com.rapido.platformengineering.risk.repository.ArchitectureRiskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchitectureRiskService {

    private final ArchitectureRiskRepository repository;
    private final RiskAssessmentService assessmentService;

    public ArchitectureRiskService(
            ArchitectureRiskRepository repository,
            RiskAssessmentService assessmentService) {

        this.repository = repository;
        this.assessmentService = assessmentService;
    }

    public ArchitectureRisk save(
            ArchitectureRisk risk) {

        int score =
                assessmentService.calculateRiskScore(
                        risk.getImpact(),
                        risk.getLikelihood());

        risk.setRiskScore(score);

        risk.setSeverity(
                assessmentService.classify(score));

        return repository.save(risk);
    }

    public List<ArchitectureRisk> findAll() {
        return repository.findAll();
    }
}