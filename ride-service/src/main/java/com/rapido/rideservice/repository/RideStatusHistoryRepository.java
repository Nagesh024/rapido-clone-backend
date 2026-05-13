package com.rapido.rideservice.repository;

import com.rapido.rideservice.entity.RideStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RideStatusHistoryRepository extends JpaRepository<RideStatusHistory, Long> {

    List<RideStatusHistory> findByRideId(Long rideId);
}