package com.rapido.adminservice.analytics;

import com.rapido.adminservice.analytics.dto.RideAnalyticsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/analytics")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping("/rides")
    public RideAnalyticsResponse getRideAnalytics() {
        return analyticsService.getRideAnalytics();
    }
}