package com.rapido.analyticsservice.service;

import com.rapido.analyticsservice.dto.HealthSummaryResponse;
import com.rapido.analyticsservice.repository.AuditEventRepository;
import com.rapido.analyticsservice.repository.FactRideRepository;
import org.springframework.stereotype.Service;

@Service
public class HealthSummaryService {

    private final FactRideRepository factRideRepository;

    private final AuditEventRepository auditEventRepository;

    public HealthSummaryService(
            FactRideRepository factRideRepository,
            AuditEventRepository auditEventRepository) {

        this.factRideRepository =
                factRideRepository;

        this.auditEventRepository =
                auditEventRepository;
    }

    public HealthSummaryResponse getSummary() {

        HealthSummaryResponse response =
                new HealthSummaryResponse();

        response.setAnalyticsStatus("UP");

        response.setTotalRides(
                factRideRepository.count());

        response.setTotalRevenue(
                factRideRepository
                        .getTotalRevenue());

        response.setTotalAuditEvents(
                auditEventRepository.count());

        response.setReportsEnabled(true);

        response.setAuditEnabled(true);

        return response;
    }
}