package com.rapido.multitenantservice.controller;

import com.rapido.multitenantservice.context.TenantContext;
import com.rapido.multitenantservice.kafka.TenantEvent;
import com.rapido.multitenantservice.kafka.TenantEventProducer;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/tenant/events")
public class TenantEventController {

    private final TenantEventProducer producer;

    public TenantEventController(
            TenantEventProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public Map<String, String> publish() {

        TenantEvent event =
                new TenantEvent();

        event.setTenantId(
                TenantContext.getTenantId());

        event.setEventType(
                "RIDE_CREATED");

        event.setPayload(
                "Ride booked successfully");

        producer.publish(event);

        return Map.of(
                "status",
                "EVENT_PUBLISHED");
    }
}