package com.rapido.platformengineering.standards.repository;

import com.rapido.platformengineering.standards.entity.EngineeringStandard;
import com.rapido.platformengineering.standards.enums.StandardCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EngineeringStandardRepository
        extends JpaRepository<EngineeringStandard, Long> {

    List<EngineeringStandard> findByCategory(
            StandardCategory category);
}