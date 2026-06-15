package com.rapido.globalservice.analytics;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analytics")
public class InternationalAnalyticsController {

    private final InternationalAnalyticsService service;

    public InternationalAnalyticsController(
            InternationalAnalyticsService service
    ) {
        this.service = service;
    }

    @GetMapping("/country/{countryCode}")
    public List<InternationalAnalytics>
    getCountryAnalytics(
            @PathVariable String countryCode
    ) {

        return service.getCountryAnalytics(
                countryCode
        );
    }
}