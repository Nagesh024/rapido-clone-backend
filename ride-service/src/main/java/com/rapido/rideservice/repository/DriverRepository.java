package com.rapido.rideservice.repository;

import com.rapido.rideservice.entity.Driver;

import jakarta.persistence.LockModeType;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    @Query(value = """
        SELECT *
        FROM drivers
        WHERE active = true
          AND available = true
          AND ST_DWithin(
                location,
                ST_SetSRID(ST_MakePoint(:lng, :lat), 4326)::geography,
                :radius
          )
        ORDER BY ST_Distance(
                location,
                ST_SetSRID(ST_MakePoint(:lng, :lat), 4326)::geography
        ) ASC
        """, nativeQuery = true)
    List<Driver> findNearbyDrivers(
            @Param("lat") double lat,
            @Param("lng") double lng,
            @Param("radius") double radius
    );

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT d FROM Driver d WHERE d.id = :id")
    Optional<Driver> lockDriverById(@Param("id") Long id);
}