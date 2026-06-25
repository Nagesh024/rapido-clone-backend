package com.rapido.platformengineering.securitygovernance.repository;

import com.rapido.platformengineering.securitygovernance.entity.SecurityControl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityControlRepository
        extends JpaRepository<SecurityControl, Long> {
}