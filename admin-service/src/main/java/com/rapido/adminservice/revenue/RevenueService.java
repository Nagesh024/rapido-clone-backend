package com.rapido.adminservice.revenue;

import com.rapido.adminservice.revenue.dto.RevenueAnalyticsResponse;
import org.springframework.stereotype.Service;

@Service
public class RevenueService {

    public RevenueAnalyticsResponse getRevenueAnalytics() {
        return new RevenueAnalyticsResponse(
                50000.0,
                350000.0,
                1500000.0,
                900000.0,
                600000.0
        );
    }
}