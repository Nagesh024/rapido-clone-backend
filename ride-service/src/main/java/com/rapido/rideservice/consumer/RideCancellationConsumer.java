package com.rapido.rideservice.consumer;

import com.rapido.rideservice.event.PaymentFailedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RideCancellationConsumer {

    private final Set<String> processed = new HashSet<>();

    @KafkaListener(topics = "payment-failed", groupId = "ride-service")
    public void cancelRide(PaymentFailedEvent event) {

        String rideId = event.getRideId();

        if (processed.contains(rideId)) {
            System.out.println("⚠ Duplicate ignored: " + rideId);
            return;
        }

        processed.add(rideId);

        System.out.println("❌ Cancelling Ride: " + rideId);
        System.out.println("✅ Ride marked CANCELLED");
    }
}