package com.rapido.platformengineering.repository;

import com.rapido.platformengineering.entity.PlatformServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformServiceRepository
        extends JpaRepository<PlatformServiceEntity, Long> {
}