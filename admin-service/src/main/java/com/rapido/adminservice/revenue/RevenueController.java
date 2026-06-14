package com.rapido.adminservice.revenue;

import com.rapido.adminservice.revenue.dto.RevenueAnalyticsResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/analytics")
public class RevenueController {

    private final RevenueService revenueService;

    public RevenueController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    @GetMapping("/revenue")
    public RevenueAnalyticsResponse getRevenueAnalytics() {
        return revenueService.getRevenueAnalytics();
    }
}