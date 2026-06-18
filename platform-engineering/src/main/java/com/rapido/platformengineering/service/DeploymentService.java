package com.rapido.platformengineering.service;

import com.rapido.platformengineering.dto.*;
import com.rapido.platformengineering.entity.DeploymentAudit;
import com.rapido.platformengineering.repository.DeploymentAuditRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DeploymentService {

    private final DeploymentAuditRepository repository;

    public DeploymentService(
            DeploymentAuditRepository repository) {

        this.repository = repository;
    }

    public String deploy(
            DeploymentRequest request) {

        DeploymentAudit audit =
                new DeploymentAudit();

        audit.setApplicationName(
                request.applicationName());

        audit.setEnvironment(
                request.environment());

        audit.setActionType("DEPLOY");

        audit.setStatus("SUCCESS");

        audit.setCreatedAt(
                LocalDateTime.now());

        repository.save(audit);

        return "Deployment Triggered Successfully";
    }

    public String rollback(
            RollbackRequest request) {

        DeploymentAudit audit =
                new DeploymentAudit();

        audit.setApplicationName(
                request.applicationName());

        audit.setEnvironment("N/A");

        audit.setActionType("ROLLBACK");

        audit.setStatus("SUCCESS");

        audit.setCreatedAt(
                LocalDateTime.now());

        repository.save(audit);

        return "Rollback Triggered Successfully";
    }

    public DeploymentStatusResponse status(
            String application) {

        return new DeploymentStatusResponse(
                application,
                "HEALTHY",
                "DEV"
        );
    }
}