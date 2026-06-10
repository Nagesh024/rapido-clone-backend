package com.rapido.analyticsservice.service;

import com.rapido.analyticsservice.dto.CustomerAnalyticsResponse;
import com.rapido.analyticsservice.repository.FactRideRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerAnalyticsService {

    private final FactRideRepository factRideRepository;

    public CustomerAnalyticsService(
            FactRideRepository factRideRepository) {

        this.factRideRepository =
                factRideRepository;
    }

    public CustomerAnalyticsResponse
    getCustomerAnalytics() {

        CustomerAnalyticsResponse response =
                new CustomerAnalyticsResponse();

        long totalCustomers =
                factRideRepository
                        .getCustomerCount();

        long returningCustomers =
                totalCustomers > 1
                        ? totalCustomers - 1
                        : 0;

        double retention =
                totalCustomers == 0
                        ? 0
                        : (returningCustomers * 100.0)
                          / totalCustomers;

        double churn =
                100.0 - retention;

        response.setTotalCustomers(
                totalCustomers);

        response.setReturningCustomers(
                returningCustomers);

        response.setRetentionRate(
                retention);

        response.setChurnRate(
                churn);

        return response;
    }
}