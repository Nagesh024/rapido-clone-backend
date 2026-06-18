package com.rapido.platformengineering.controller;

import com.rapido.platformengineering.dto.PlatformResponse;
import com.rapido.platformengineering.service.PlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/platform")
@RequiredArgsConstructor
public class PlatformController {

    private final PlatformService service = new PlatformService();

    @GetMapping("/health")
    public PlatformResponse health() {
        return service.health();
    }
}