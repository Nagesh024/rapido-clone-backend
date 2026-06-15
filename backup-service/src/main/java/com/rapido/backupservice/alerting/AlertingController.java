package com.rapido.backupservice.alerting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlertingController {

    private final AlertingService alertingService;

    public AlertingController(
            AlertingService alertingService) {

        this.alertingService = alertingService;
    }

    @GetMapping("/alerts/region")
    public String regionAlert() {

        return alertingService.regionAlert();
    }

    @GetMapping("/alerts/replication")
    public String replicationAlert() {

        return alertingService.replicationLagAlert();
    }

    @GetMapping("/alerts/backup")
    public String backupAlert() {

        return alertingService.backupFailureAlert();
    }

    @GetMapping("/alerts/error-rate")
    public String errorRateAlert() {

        return alertingService.errorRateAlert();
    }

    @GetMapping("/alerts/recovery")
    public String recoveryAlert() {

        return alertingService.recoveryFailureAlert();
    }
}