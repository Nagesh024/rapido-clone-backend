package com.rapido.driverservice.producer;

import com.rapido.driverservice.dto.DriverStatusRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DriverStatusProducer {

    private final KafkaTemplate<String,Object> kafkaTemplate;

    public DriverStatusProducer(
            KafkaTemplate<String,Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishDriverStatus(
            DriverStatusRequest request) {

        kafkaTemplate.send(
                "driver-status-events",
                request.getDriverId(),
                request
        );

        System.out.println(
                "EVENT SENT -> " +
                request.getDriverId()
        );
    }
}