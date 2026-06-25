package com.rapido.platformengineering.compliance.repository;

import com.rapido.platformengineering.compliance.entity.ComplianceCheck;
import com.rapido.platformengineering.compliance.enums.ComplianceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplianceCheckRepository
        extends JpaRepository<ComplianceCheck, Long> {

    long countByStatus(
            ComplianceStatus status);
}