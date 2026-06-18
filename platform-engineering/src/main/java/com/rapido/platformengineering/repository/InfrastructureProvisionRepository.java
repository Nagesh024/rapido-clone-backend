package com.rapido.platformengineering.repository;

import com.rapido.platformengineering.entity.InfrastructureProvision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfrastructureProvisionRepository
        extends JpaRepository<InfrastructureProvision, Long> {
}