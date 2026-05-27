package com.rapido.rideservice.repository;

import com.rapido.rideservice.entity.Ride;
import com.rapido.rideservice.entity.RideStatus;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Long> {

    List<Ride> findByUserId(Long userId);

    List<Ride> findByDriverId(Long driverId);

    List<Ride> findByStatus(RideStatus status);

    List<Ride> findByStatusAndRequestedAtBefore(
            RideStatus status,
            LocalDateTime timeoutTime
    );
}