package com.rapido.rideservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RideController {

    @GetMapping({"/ride/health", "/rides/health", "/health"})
    public String health() {
        return "Ride Service Running Successfully";
    }
}