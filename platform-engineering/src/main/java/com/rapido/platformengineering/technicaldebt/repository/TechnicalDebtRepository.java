package com.rapido.platformengineering.technicaldebt.repository;

import com.rapido.platformengineering.technicaldebt.entity.TechnicalDebt;
import com.rapido.platformengineering.technicaldebt.enums.DebtCategory;
import com.rapido.platformengineering.technicaldebt.enums.DebtSeverity;
import com.rapido.platformengineering.technicaldebt.enums.DebtStatus;
import com.rapido.platformengineering.technicaldebt.enums.DebtSeverity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicalDebtRepository
        extends JpaRepository<TechnicalDebt, Long> {

    long countByStatus(DebtStatus status);


    long countByCategory(DebtCategory category);

	long countBySeverity(
	        DebtSeverity severity);
}