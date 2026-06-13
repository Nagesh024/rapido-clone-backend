package com.rapido.globalservice.analytics;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InternationalAnalyticsRepository
        extends JpaRepository<InternationalAnalytics, Long> {

    List<InternationalAnalytics>
    findByCountryCode(String countryCode);
}