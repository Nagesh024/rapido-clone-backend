package com.rapido.driverservice.consumer;

import com.rapido.driverservice.event.RideAssignedEvent;
import com.rapido.driverservice.event.RideRequestedEvent;
import com.rapido.driverservice.producer.DriverEventProducer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RideRequestConsumer {

    private final DriverEventProducer producer;

    public RideRequestConsumer(DriverEventProducer producer) {
        this.producer = producer;
    }

    @KafkaListener(topics = "ride-requested", groupId = "driver-service")
    public void handleRide(RideRequestedEvent event) {

        System.out.println("🔥 RIDE RECEIVED: " + event.getRideId());

        // Step 1: find driver
        String driverId = findNearestDriver(event);

        System.out.println("🚗 Assigned Driver: " + driverId);

        // Step 2: create event
        RideAssignedEvent assignedEvent =
                new RideAssignedEvent(event.getRideId(), driverId, "ASSIGNED");

        // Step 3: publish event
        producer.sendRideAssigned(assignedEvent);
    }

    private String findNearestDriver(RideRequestedEvent event) {
        return "DRIVER-" + (int)(Math.random() * 100);
    }
}