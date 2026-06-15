package com.rapido.analyticsservice.repository;

import com.rapido.analyticsservice.entity.DimDriver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DimDriverRepository
        extends JpaRepository<DimDriver, Long> {
}