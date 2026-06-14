package com.rapido.analyticsservice.controller;

import com.rapido.analyticsservice.dto.CustomerAnalyticsResponse;
import com.rapido.analyticsservice.service.CustomerAnalyticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerAnalyticsController {

    private final CustomerAnalyticsService
            customerAnalyticsService;

    public CustomerAnalyticsController(
            CustomerAnalyticsService
                    customerAnalyticsService) {

        this.customerAnalyticsService =
                customerAnalyticsService;
    }

    @GetMapping(
            "/analytics/customers")
    public CustomerAnalyticsResponse
    getCustomerAnalytics() {

        return customerAnalyticsService
                .getCustomerAnalytics();
    }
}