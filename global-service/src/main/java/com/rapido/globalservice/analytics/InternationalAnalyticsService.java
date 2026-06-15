package com.rapido.globalservice.analytics;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternationalAnalyticsService {

    private final InternationalAnalyticsRepository repository;

    public InternationalAnalyticsService(
            InternationalAnalyticsRepository repository
    ) {
        this.repository = repository;
    }

    public List<InternationalAnalytics> getCountryAnalytics(
            String countryCode
    ) {

        return repository.findByCountryCode(
                countryCode
        );
    }
}