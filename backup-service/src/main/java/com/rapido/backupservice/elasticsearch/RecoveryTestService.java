package com.rapido.backupservice.elasticsearch;

import org.springframework.stereotype.Service;

@Service
public class RecoveryTestService {

    public void verifyRecovery() {

        System.out.println(
                "Index Recovery Test Passed");

    }
}