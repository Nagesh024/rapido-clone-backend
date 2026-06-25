package com.rapido.platformengineering.risk.repository;

import com.rapido.platformengineering.risk.entity.RiskRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskRegisterRepository
        extends JpaRepository<RiskRegister, Long> {
}