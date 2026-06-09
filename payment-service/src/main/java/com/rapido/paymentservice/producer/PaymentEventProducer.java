package com.rapido.paymentservice.producer;

import com.rapido.paymentservice.event.PaymentFailedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentEventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public PaymentEventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // 🔴 THIS METHOD YOU WERE MISSING
    public void publishPaymentFailedEvent(String rideId, String driverId) {

        PaymentFailedEvent event =
                new PaymentFailedEvent(rideId, driverId, "PAYMENT_FAILED");

        kafkaTemplate.send("payment-failed", rideId, event);

        System.out.println("🚨 PAYMENT FAILED EVENT SENT");
    }
}