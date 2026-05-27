package com.rapido.rideservice.controller;

import com.rapido.rideservice.dto.RideRequestDTO;
import com.rapido.rideservice.dto.RideResponseDTO;
import com.rapido.rideservice.entity.Driver;
import com.rapido.rideservice.matching.RideMatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rides")
public class RideMatchingController {

    @Autowired
    private RideMatchingService rideMatchingService;

    @GetMapping("/nearby-drivers")
    public List<Driver> nearbyDrivers(@RequestParam double lat,
                                      @RequestParam double lng) {
        return rideMatchingService.nearbyDrivers(lat, lng);
    }

    @GetMapping("/surge-preview")
    public String surgePreview(@RequestParam double lat,
                               @RequestParam double lng) {
        double surge = rideMatchingService.surgePreview(lat, lng);
        return "Current surge multiplier: " + surge;
    }

    @PostMapping("/request")
    public RideResponseDTO requestRide(@RequestBody RideRequestDTO request) {
        return rideMatchingService.requestRide(request);
    }
}