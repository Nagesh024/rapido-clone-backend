package com.rapido.backupservice.resilience;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public String sendNotification() {

        try {

            throw new RuntimeException(
                    "Notification Service Down");

        } catch (Exception ex) {

            System.out.println(
                    "Notification Queued");

            return "Notification Queued During Failure";
        }
    }
}