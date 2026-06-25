package com.rapido.platformengineering.risk.repository;

import com.rapido.platformengineering.risk.entity.ArchitectureRisk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArchitectureRiskRepository
        extends JpaRepository<ArchitectureRisk, Long> {
}