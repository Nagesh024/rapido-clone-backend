package com.rapido.adminservice.analytics;

import com.rapido.adminservice.analytics.dto.RideAnalyticsResponse;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {

    public RideAnalyticsResponse getRideAnalytics() {

        return new RideAnalyticsResponse(
                350L,
                "6 PM - 7 PM",
                22L,
                "Madhapur"
        );
    }
}