package com.rapido.analyticsservice.repository;

import com.rapido.analyticsservice.entity.DimLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DimLocationRepository
        extends JpaRepository<DimLocation, Long> {
}