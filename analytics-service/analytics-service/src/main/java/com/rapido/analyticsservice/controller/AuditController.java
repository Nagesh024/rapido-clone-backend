package com.rapido.analyticsservice.controller;

import com.rapido.analyticsservice.dto.AuditMetricsResponse;
import com.rapido.analyticsservice.dto.DistributionResponse;
import com.rapido.analyticsservice.dto.HealthSummaryResponse;
import com.rapido.analyticsservice.dto.TrendResponse;
import com.rapido.analyticsservice.entity.AuditEvent;
import com.rapido.analyticsservice.repository.AuditEventRepository;
import com.rapido.analyticsservice.service.AuditExportService;
import com.rapido.analyticsservice.service.AuditMetricsService;
import com.rapido.analyticsservice.service.DistributionService;
import com.rapido.analyticsservice.service.HealthSummaryService;
import com.rapido.analyticsservice.service.TrendService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuditController {

    private final AuditEventRepository auditEventRepository;

    private final AuditMetricsService auditMetricsService;

    private final TrendService trendService;

    private final DistributionService distributionService;

    private final AuditExportService auditExportService;

    private final HealthSummaryService healthSummaryService;

    public AuditController(
            AuditEventRepository auditEventRepository,
            AuditMetricsService auditMetricsService,
            TrendService trendService,
            DistributionService distributionService,
            AuditExportService auditExportService,
            HealthSummaryService healthSummaryService) {

        this.auditEventRepository =
                auditEventRepository;

        this.auditMetricsService =
                auditMetricsService;

        this.trendService =
                trendService;

        this.distributionService =
                distributionService;

        this.auditExportService =
                auditExportService;

        this.healthSummaryService =
                healthSummaryService;
    }

    @GetMapping("/analytics/audit")
    public List<AuditEvent> getAuditEvents() {

        return auditEventRepository.findAll();
    }

    @GetMapping("/analytics/audit/search")
    public List<AuditEvent> searchAuditEvents(
            @RequestParam String eventType) {

        return auditEventRepository
                .findByEventType(eventType);
    }

    @GetMapping("/analytics/audit/page")
    public Page<AuditEvent> getAuditEventsPage(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "createdAt")
            String sort) {

        return auditEventRepository.findAll(
                PageRequest.of(
                        page,
                        size,
                        Sort.by(sort).descending()));
    }

    @GetMapping("/analytics/audit/metrics")
    public AuditMetricsResponse getMetrics() {

        return auditMetricsService.getMetrics();
    }

    @GetMapping("/analytics/audit/trends")
    public TrendResponse getTrends() {

        return trendService.getTrends();
    }

    @GetMapping("/analytics/audit/distribution")
    public DistributionResponse getDistribution() {

        return distributionService.getDistribution();
    }

    @GetMapping("/analytics/audit/export")
    public String exportAuditEvents() {

        return auditExportService.exportAuditEvents();
    }

    @GetMapping("/analytics/health-summary")
    public HealthSummaryResponse getHealthSummary() {

        return healthSummaryService.getSummary();
    }
}