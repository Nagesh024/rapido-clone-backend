package com.rapido.backupservice.failover;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FailoverController {

    private final FailoverService failoverService;

    public FailoverController(
            FailoverService failoverService) {

        this.failoverService = failoverService;
    }

    @GetMapping("/failover")
    public String failover() {

        return failoverService.executeFailover();
    }
}