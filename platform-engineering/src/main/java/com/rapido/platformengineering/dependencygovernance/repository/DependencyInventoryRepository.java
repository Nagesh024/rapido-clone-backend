package com.rapido.platformengineering.dependencygovernance.repository;

import com.rapido.platformengineering.dependencygovernance.entity.DependencyInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependencyInventoryRepository
        extends JpaRepository<DependencyInventory, Long> {
}