package com.rapido.backupservice.monitoring;

import org.springframework.stereotype.Service;

@Service
public class MonitoringNotificationService {

    public String notifyRecovery() {

        System.out.println("Recovery Notification Sent");

        return "Recovery Notification Delivered";
    }
}