package com.rapido.platformengineering.controller;

import com.rapido.platformengineering.dto.CostMetricResponse;
import com.rapido.platformengineering.service.CostMetricService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/costs")
public class CostMetricController {

    private final CostMetricService service;

    public CostMetricController(
            CostMetricService service) {

        this.service = service;
    }

    @GetMapping
    public CostMetricResponse getCosts() {

        return service.getCosts();
    }
}