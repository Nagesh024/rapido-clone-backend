package com.rapido.platformservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class OperationsController {

    @GetMapping("/operations/overview")
    public ResponseEntity<Map<String, Object>> getOperationsOverview() {

        Map<String, Object> response = new LinkedHashMap<>();

        response.put("platform", "Rapido Enterprise Operations Center");
        response.put("timestamp", LocalDateTime.now());

        response.put("executiveDashboard", "UP");
        response.put("networkOperationsCenter", "UP");
        response.put("securityOperationsCenter", "UP");
        response.put("financeDashboard", "UP");
        response.put("engineeringDashboard", "UP");

        response.put("overallStatus", "HEALTHY");

        return ResponseEntity.ok(response);
    }
}