package com.rapido.platformengineering.databasegovernance.repository;

import com.rapido.platformengineering.databasegovernance.entity.DatabaseStandard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseStandardRepository
        extends JpaRepository<DatabaseStandard, Long> {
}