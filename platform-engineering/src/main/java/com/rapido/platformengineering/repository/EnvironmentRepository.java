package com.rapido.platformengineering.repository;

import com.rapido.platformengineering.entity.EnvironmentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvironmentRepository
        extends JpaRepository<EnvironmentInfo, Long> {
}