package com.rapido.backupservice.monitoring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitoringController {

    private final MonitoringService monitoringService;
    private final AlertService alertService;
    private final MonitoringNotificationService notificationService;

    public MonitoringController(
            MonitoringService monitoringService,
            AlertService alertService,
            MonitoringNotificationService notificationService) {

        this.monitoringService = monitoringService;
        this.alertService = alertService;
        this.notificationService = notificationService;
    }

    @GetMapping("/monitoring/health")
    public String health() {

        return monitoringService.healthStatus();
    }

    @GetMapping("/monitoring/alert")
    public String alert() {

        return alertService.triggerAlert();
    }

    @GetMapping("/monitoring/notify")
    public String notifyRecovery() {

        return notificationService.notifyRecovery();
    }
}