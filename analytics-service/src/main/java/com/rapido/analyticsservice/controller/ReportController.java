package com.rapido.analyticsservice.controller;

import com.rapido.analyticsservice.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    private final ReportService reportService;

    public ReportController(
            ReportService reportService) {

        this.reportService = reportService;
    }

    @GetMapping("/analytics/report/csv")
    public String generateCsv() {

        return reportService
                .generateCsvReport();
    }

    @GetMapping("/analytics/report/excel")
    public String generateExcel() {

        return reportService
                .generateExcelReport();
    }

    @GetMapping("/analytics/report/pdf")
    public String generatePdf() {

        return reportService
                .generatePdfReport();
    }
}