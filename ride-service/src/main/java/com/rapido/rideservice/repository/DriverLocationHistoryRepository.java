package com.rapido.rideservice.repository;

import com.rapido.rideservice.entity.DriverLocationHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverLocationHistoryRepository
        extends JpaRepository<DriverLocationHistory, Long> {

    List<DriverLocationHistory> findByRideId(Long rideId);
}