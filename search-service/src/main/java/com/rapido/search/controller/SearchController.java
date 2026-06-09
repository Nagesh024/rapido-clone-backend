package com.rapido.search.controller;

import com.rapido.search.model.DriverDocument;
import com.rapido.search.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rapido.search.dto.DriverSearchRequest;
import java.util.List;
@RestController
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    // 🔥 INDEX DRIVER INTO ELASTICSEARCH
    @PostMapping("/index/driver")
    public ResponseEntity<DriverDocument> indexDriver(@RequestBody DriverDocument driver) {
        DriverDocument saved = searchService.indexDriver(driver);
        return ResponseEntity.ok(saved);
    }

    // 🔍 GET DRIVER BY ID
    @GetMapping("/driver/{id}")
    public ResponseEntity<DriverDocument> getDriver(@PathVariable String id) {
        return searchService.getDriver(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/drivers/nearby")
    public List<DriverDocument> findNearby(@RequestBody DriverSearchRequest request) {
        return searchService.findNearbyDrivers(
                request.getLatitude(),
                request.getLongitude(),
                request.getRadiusInKm()
        );
    }
}