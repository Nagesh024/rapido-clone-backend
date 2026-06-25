package com.rapido.platformengineering.readiness.service;

import com.rapido.platformengineering.readiness.entity.ProductionReadinessAssessment;
import com.rapido.platformengineering.readiness.repository.ProductionReadinessRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionReadinessService {

    private final ProductionReadinessRepository repository;
    private final ReadinessAssessmentEngine engine;

    public ProductionReadinessService(
            ProductionReadinessRepository repository,
            ReadinessAssessmentEngine engine) {

        this.repository = repository;
        this.engine = engine;
    }

    public ProductionReadinessAssessment save(
            ProductionReadinessAssessment assessment) {

        int score =
                engine.calculateScore(
                        assessment.getMonitoringScore(),
                        assessment.getSecurityScore(),
                        assessment.getPerformanceScore(),
                        assessment.getScalabilityScore(),
                        assessment.getDisasterRecoveryScore(),
                        assessment.getComplianceScore());

        assessment.setTotalScore(score);

        assessment.setStatus(
                engine.evaluate(score));

        return repository.save(assessment);
    }

    public List<ProductionReadinessAssessment> findAll() {
        return repository.findAll();
    }
}