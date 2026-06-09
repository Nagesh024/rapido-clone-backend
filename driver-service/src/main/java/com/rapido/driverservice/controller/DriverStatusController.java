package com.rapido.driverservice.controller;

import org.springframework.web.bind.annotation.*;

import com.rapido.driverservice.dto.DriverStatusRequest;
import com.rapido.driverservice.event.DriverStatusEvent;
import com.rapido.driverservice.producer.DriverStatusProducer;

@RestController
@RequestMapping("/driver/status")
public class DriverStatusController {

    private final DriverStatusProducer producer;

    public DriverStatusController(
            DriverStatusProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/update")
    public String updateStatus(
            @RequestBody DriverStatusRequest request) {

        producer.publishDriverStatus(request);

        return "Driver status updated successfully";
    }
}