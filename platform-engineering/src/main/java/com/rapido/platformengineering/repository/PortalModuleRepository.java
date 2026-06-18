package com.rapido.platformengineering.repository;

import com.rapido.platformengineering.entity.PortalModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortalModuleRepository
        extends JpaRepository<PortalModule, Long> {
}