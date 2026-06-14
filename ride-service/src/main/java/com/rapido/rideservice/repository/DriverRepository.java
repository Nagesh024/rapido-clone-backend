package com.rapido.rideservice.repository;

import com.rapido.rideservice.entity.Driver;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    List<Driver> findByActiveTrueAndAvailableTrue();

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT d FROM Driver d WHERE d.id = :id")
    Optional<Driver> lockDriverById(@Param("id") Long id);
}