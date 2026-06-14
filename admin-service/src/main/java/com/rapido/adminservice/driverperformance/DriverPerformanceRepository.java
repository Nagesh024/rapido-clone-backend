package com.rapido.adminservice.driverperformance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverPerformanceRepository
        extends JpaRepository<DriverPerformance, Long> {

}