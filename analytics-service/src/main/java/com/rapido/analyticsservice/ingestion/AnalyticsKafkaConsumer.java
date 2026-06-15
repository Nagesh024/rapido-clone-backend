package com.rapido.analyticsservice.ingestion;

import com.rapido.analyticsservice.service.AuditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AnalyticsKafkaConsumer {

    private static final Logger log =
            LoggerFactory.getLogger(
                    AnalyticsKafkaConsumer.class);

    private final AuditService auditService;

    public AnalyticsKafkaConsumer(
            AuditService auditService) {

        this.auditService = auditService;
    }

    @KafkaListener(
            topics = "ride-completed",
            groupId = "analytics-group")
    public void consumeRideCompleted(
            String message) {

        log.info(
                "Ride Completed Event Received: {}",
                message);

        auditService.saveEvent(
                "RIDE_COMPLETED",
                message);
    }

    @KafkaListener(
            topics = "payment-success",
            groupId = "analytics-group")
    public void consumePaymentSuccess(
            String message) {

        log.info(
                "Payment Success Event Received: {}",
                message);

        auditService.saveEvent(
                "PAYMENT_SUCCESS",
                message);
    }

    @KafkaListener(
            topics = "driver-status-updated",
            groupId = "analytics-group")
    public void consumeDriverStatus(
            String message) {

        log.info(
                "Driver Status Event Received: {}",
                message);

        auditService.saveEvent(
                "DRIVER_STATUS_UPDATED",
                message);
    }

    @KafkaListener(
            topics = "notification-sent",
            groupId = "analytics-group")
    public void consumeNotification(
            String message) {

        log.info(
                "Notification Event Received: {}",
                message);

        auditService.saveEvent(
                "NOTIFICATION_SENT",
                message);
    }
}