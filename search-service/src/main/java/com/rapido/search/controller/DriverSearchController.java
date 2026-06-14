package com.rapido.search.controller;

import com.rapido.search.model.DriverDocument;
import com.rapido.search.service.DriverGeoSearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search/drivers")
public class DriverSearchController {

    private final DriverGeoSearchService service;

    public DriverSearchController(
            DriverGeoSearchService service) {
        this.service = service;
    }

    @GetMapping("/nearby")
    public List<DriverDocument> nearbyDrivers() {

        return service.findNearbyDrivers(
                "AVAILABLE"
        );
    }
}