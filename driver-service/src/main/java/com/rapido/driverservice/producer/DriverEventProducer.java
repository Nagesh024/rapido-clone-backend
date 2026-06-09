package com.rapido.driverservice.producer;

import com.rapido.driverservice.event.RideAssignedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DriverEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public DriverEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendRideAssigned(RideAssignedEvent event) {

        kafkaTemplate.send(
                "ride-assigned",
                event.getRideId(),
                event.toString()   // TEMP FIX (important)
        );

        System.out.println("EVENT SENT: " + event.getRideId());
    }
}
