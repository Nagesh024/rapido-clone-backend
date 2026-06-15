package com.rapido.backupservice.resilience;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResilienceController {

    private final RideHistoryService rideHistoryService;
    private final NotificationService notificationService;

    public ResilienceController(
            RideHistoryService rideHistoryService,
            NotificationService notificationService) {

        this.rideHistoryService = rideHistoryService;
        this.notificationService = notificationService;
    }

    @GetMapping("/resilience/ride-history")
    public String rideHistory() {

        return rideHistoryService.getRideHistory();
    }

    @GetMapping("/resilience/notification")
    public String notification() {

        return notificationService.sendNotification();
    }
}