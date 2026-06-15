package com.rapido.adminservice.reporting;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/reports")
public class ReportingController {

    private final ReportingService reportingService;

    public ReportingController(
            ReportingService reportingService) {

        this.reportingService = reportingService;
    }

    @GetMapping("/revenue")
    public ReportResponse revenueReport(
            @RequestParam(defaultValue = "CSV")
            String format) {

        return reportingService
                .generateRevenueReport(format);
    }

    @GetMapping("/rides")
    public ReportResponse rideReport(
            @RequestParam(defaultValue = "CSV")
            String format) {

        return reportingService
                .generateRideReport(format);
    }

    @GetMapping("/fraud")
    public ReportResponse fraudReport(
            @RequestParam(defaultValue = "PDF")
            String format) {

        return reportingService
                .generateFraudReport(format);
    }
}