package com.rapido.backupservice.chaos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChaosController {

    private final ChaosService chaosService;

    public ChaosController(
            ChaosService chaosService) {

        this.chaosService = chaosService;
    }

    @GetMapping("/chaos/node")
    public String nodeFailure() {

        return chaosService.simulateNodeFailure();
    }

    @GetMapping("/chaos/database")
    public String databaseFailure() {

        return chaosService.simulateDatabaseFailure();
    }

    @GetMapping("/chaos/kafka")
    public String kafkaFailure() {

        return chaosService.simulateKafkaFailure();
    }

    @GetMapping("/chaos/network")
    public String networkLatency() {

        return chaosService.simulateNetworkLatency();
    }
}