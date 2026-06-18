package com.rapido.platformengineering.controller;

import com.rapido.platformengineering.dto.DoraMetricResponse;
import com.rapido.platformengineering.service.DoraMetricService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metrics")
public class DoraMetricController {

    private final DoraMetricService service;

    public DoraMetricController(
            DoraMetricService service) {

        this.service = service;
    }

    @GetMapping("/dora")
    public DoraMetricResponse metrics() {

        return service.getMetrics();
    }
}