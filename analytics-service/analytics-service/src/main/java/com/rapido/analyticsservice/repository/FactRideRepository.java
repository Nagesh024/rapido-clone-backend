package com.rapido.analyticsservice.repository;

import com.rapido.analyticsservice.entity.FactRide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface FactRideRepository
        extends JpaRepository<FactRide, Long> {

    boolean existsByRideId(Long rideId);

    Long countByStatus(String status);

    @Query("""
           SELECT COALESCE(SUM(f.fare),0)
           FROM FactRide f
           """)
    BigDecimal getTotalRevenue();

    @Query("""
           SELECT AVG(f.durationMinutes)
           FROM FactRide f
           """)
    Double getAverageRideDuration();

    @Query("""
           SELECT COALESCE(SUM(f.fare),0)
           FROM FactRide f
           """)
    BigDecimal getWeeklyRevenue();

    @Query("""
           SELECT COUNT(f)
           FROM FactRide f
           """)
    Long getWeeklyRideCount();

    @Query("""
           SELECT COALESCE(SUM(f.fare),0)
           FROM FactRide f
           """)
    BigDecimal getMonthlyRevenue();

    @Query("""
           SELECT COUNT(f)
           FROM FactRide f
           """)
    Long getMonthlyRideCount();

    @Query("""
           SELECT COUNT(f)
           FROM FactRide f
           """)
    Long getCustomerCount();

    @Query("""
           SELECT COUNT(f)
           FROM FactRide f
           WHERE f.status = 'COMPLETED'
           """)
    Long getActiveRideCount();
}