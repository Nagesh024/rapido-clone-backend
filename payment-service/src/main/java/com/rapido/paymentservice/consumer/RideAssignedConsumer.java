package com.rapido.paymentservice.consumer;

import com.rapido.paymentservice.event.RideAssignedEvent;
import com.rapido.paymentservice.service.PaymentService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RideAssignedConsumer {

    private final PaymentService paymentService;

    public RideAssignedConsumer(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @KafkaListener(topics = "ride-assigned", groupId = "payment-service")
    public void handleRideAssigned(RideAssignedEvent event) {

        System.out.println("📥 PAYMENT SERVICE RECEIVED EVENT");
        System.out.println("Ride ID: " + event.getRideId());

        paymentService.processRidePayment(
                Long.parseLong(event.getUserId()),
                Long.parseLong(event.getRideId())
        );
    }
}