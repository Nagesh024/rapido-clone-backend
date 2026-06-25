package com.rapido.platformengineering.dependencyscanner.repository;

import com.rapido.platformengineering.dependencyscanner.entity.DependencyScanResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependencyScanResultRepository
        extends JpaRepository<DependencyScanResult, Long> {
}