package com.rapido.globalservice.logging;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MLLoggingController {

    private final MLLoggingService
            loggingService;

    public MLLoggingController(
            MLLoggingService loggingService
    ) {
        this.loggingService = loggingService;
    }

    @GetMapping("/ml/logs")
    public String logs() {

        loggingService.generateLogs();

        return "ML Logs Generated";
    }
}