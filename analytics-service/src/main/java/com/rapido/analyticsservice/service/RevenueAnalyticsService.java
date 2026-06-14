package com.rapido.analyticsservice.service;

import com.rapido.analyticsservice.dto.RevenueAnalyticsResponse;
import com.rapido.analyticsservice.repository.FactRideRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class RevenueAnalyticsService {

    private final FactRideRepository
            factRideRepository;

    public RevenueAnalyticsService(
            FactRideRepository factRideRepository) {

        this.factRideRepository =
                factRideRepository;
    }

    public RevenueAnalyticsResponse
    getRevenueAnalytics() {

        RevenueAnalyticsResponse response =
                new RevenueAnalyticsResponse();

        BigDecimal revenue =
                factRideRepository
                        .getTotalRevenue();

        long totalRides =
                factRideRepository.count();

        BigDecimal revenuePerDriver =
                totalRides == 0
                        ? BigDecimal.ZERO
                        : revenue.divide(
                                BigDecimal.valueOf(
                                        totalRides),
                                2,
                                RoundingMode.HALF_UP);

        BigDecimal commission =
                revenue.multiply(
                        BigDecimal.valueOf(0.20));

        response.setRevenuePerDay(
                revenue);

        response.setRevenuePerDriver(
                revenuePerDriver);

        response.setPlatformCommission(
                commission);

        return response;
    }
}