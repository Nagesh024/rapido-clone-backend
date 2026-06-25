package com.rapido.platformengineering.kpi.repository;

import com.rapido.platformengineering.kpi.entity.EngineeringKPI;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineeringKPIRepository
        extends JpaRepository<EngineeringKPI, Long> {
}