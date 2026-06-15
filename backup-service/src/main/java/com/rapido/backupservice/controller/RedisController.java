package com.rapido.backupservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rapido.backupservice.redis.RedisFailoverService;
import com.rapido.backupservice.redis.RedisHealthService;

@RestController
public class RedisController {

    private final RedisHealthService healthService;
    private final RedisFailoverService failoverService;

    public RedisController(
            RedisHealthService healthService,
            RedisFailoverService failoverService) {

        this.healthService = healthService;
        this.failoverService = failoverService;
    }

    @GetMapping("/redis/health")
    public String health() {

        return String.valueOf(
                healthService.isHealthy());
    }

    @GetMapping("/redis/failover")
    public String failover() {

        failoverService.triggerFailover();

        return "Redis Failover Triggered";
    }
}