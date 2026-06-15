package com.rapido.backupservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rapido.backupservice.elasticsearch.RecoveryTestService;
import com.rapido.backupservice.elasticsearch.ReplicationService;

@RestController
public class ElasticController {

    private final ReplicationService replicationService;
    private final RecoveryTestService recoveryTestService;

    public ElasticController(
            ReplicationService replicationService,
            RecoveryTestService recoveryTestService) {

        this.replicationService = replicationService;
        this.recoveryTestService = recoveryTestService;
    }

    @GetMapping("/elastic/recovery-test")
    public String testRecovery() {

        replicationService.replicateIndexes();

        recoveryTestService.verifyRecovery();

        return "Recovery Test Successful";
    }
}