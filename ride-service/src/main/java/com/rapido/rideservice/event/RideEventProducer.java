package com.rapido.rideservice.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RideEventProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private static final String TOPIC = "ride-requested";

    public void publishRideRequested(RideRequestedEvent event) {

        kafkaTemplate.send(TOPIC, event);

        System.out.println("✅ EVENT PUBLISHED: " + event.getRideId());
    }
}