package com.rapido.platformservice.controller;

import com.rapido.platformservice.dto.ExecutiveReportResponse;
import com.rapido.platformservice.service.ExecutiveReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExecutiveReportController {

    private final ExecutiveReportService service;

    public ExecutiveReportController(
            ExecutiveReportService service) {
        this.service = service;
    }

    @GetMapping("/executive/reports")
    public ExecutiveReportResponse reports() {
        return service.generateReports();
    }

}