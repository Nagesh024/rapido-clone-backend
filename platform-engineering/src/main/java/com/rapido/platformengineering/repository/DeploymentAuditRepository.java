package com.rapido.platformengineering.repository;

import com.rapido.platformengineering.entity.DeploymentAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeploymentAuditRepository
        extends JpaRepository<DeploymentAudit, Long> {
}