package com.rapido.multitenantservice.kafka;

import org.springframework.stereotype.Service;

@Service
public class TenantEventProducer {

    public void publish(TenantEvent event) {

        System.out.println(
                "Kafka Event Published : "
                        + event.getTenantId());

        System.out.println(
                "Event Type : "
                        + event.getEventType());

        System.out.println(
                "Payload : "
                        + event.getPayload());
    }
}