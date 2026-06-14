package com.rapido.driverservice.controller;

import com.rapido.driverservice.entity.Driver;
import com.rapido.driverservice.service.DriverSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search/drivers")
public class DriverSearchController {

    private final DriverSearchService driverSearchService;

    @Autowired
    public DriverSearchController(DriverSearchService driverSearchService) {
        this.driverSearchService = driverSearchService;
    }

    @GetMapping("/nearby")
    public List<Driver> getNearbyDrivers(
            @RequestParam Double latitude,
            @RequestParam Double longitude,
            @RequestParam Double radius,
            @RequestParam String vehicleType
    ) {
        return driverSearchService.findNearbyDrivers(
                latitude,
                longitude,
                radius,
                vehicleType
        );
    }
}