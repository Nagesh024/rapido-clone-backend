package com.rapido.multitenantservice.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TenantEventConsumer {

    @KafkaListener(
            topics = "tenant-events",
            groupId = "tenant-group")
    public void consume(
            TenantEvent event) {

        System.out.println(
                "Tenant ID : "
                        + event.getTenantId());

        System.out.println(
                "Event Type : "
                        + event.getEventType());

        System.out.println(
                "Payload : "
                        + event.getPayload());
    }
}