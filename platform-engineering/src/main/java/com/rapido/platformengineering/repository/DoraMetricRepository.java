package com.rapido.platformengineering.repository;

import com.rapido.platformengineering.entity.DoraMetric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoraMetricRepository
        extends JpaRepository<DoraMetric, Long> {
}