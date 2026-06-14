package com.rapido.driverservice.consumer;

import com.rapido.driverservice.event.PaymentFailedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PaymentFailureConsumer {

    private final Set<String> processedEvents = new HashSet<>();

    @KafkaListener(topics = "payment-failed", groupId = "driver-service")
    public void handlePaymentFailure(PaymentFailedEvent event) {

        String eventId = event.getRideId();

        // =========================
        // IDEMPOTENCY CHECK
        // =========================
        if (processedEvents.contains(eventId)) {
            System.out.println("⚠ Duplicate event ignored: " + eventId);
            return;
        }

        processedEvents.add(eventId);

        System.out.println("🔁 DRIVER COMPENSATION STARTED");
        System.out.println("🚫 Releasing Driver: " + event.getDriverId());
        System.out.println("✅ Driver is now AVAILABLE");
    }
}