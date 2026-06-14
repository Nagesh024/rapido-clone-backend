package com.rapido.paymentservice.repository;

import com.rapido.paymentservice.entity.DriverEarnings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriverEarningsRepository extends JpaRepository<DriverEarnings, Long> {
    Optional<DriverEarnings> findByDriverId(Long driverId);
}