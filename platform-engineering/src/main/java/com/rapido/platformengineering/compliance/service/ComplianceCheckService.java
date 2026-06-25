package com.rapido.platformengineering.compliance.service;

import com.rapido.platformengineering.compliance.entity.ComplianceCheck;
import com.rapido.platformengineering.compliance.repository.ComplianceCheckRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplianceCheckService {

    private final ComplianceCheckRepository repository;
    private final ComplianceEngineService engine;

    public ComplianceCheckService(
            ComplianceCheckRepository repository,
            ComplianceEngineService engine) {

        this.repository = repository;
        this.engine = engine;
    }

    public ComplianceCheck save(
            ComplianceCheck check) {

        check.setStatus(
                engine.evaluate(
                        check.getMicroserviceStandard(),
                        check.getApiStandard(),
                        check.getSecurityStandard(),
                        check.getDeploymentStandard()));

        return repository.save(check);
    }

    public List<ComplianceCheck> findAll() {
        return repository.findAll();
    }
}