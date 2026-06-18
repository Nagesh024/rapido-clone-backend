package com.rapido.platformengineering.controller;

import com.rapido.platformengineering.dto.LoadTestResponse;
import com.rapido.platformengineering.service.LoadTestService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loadtest")
public class LoadTestController {

    private final LoadTestService service;

    public LoadTestController(
            LoadTestService service) {

        this.service = service;
    }

    @GetMapping
    public LoadTestResponse status() {

        return service.getStatus();
    }
}