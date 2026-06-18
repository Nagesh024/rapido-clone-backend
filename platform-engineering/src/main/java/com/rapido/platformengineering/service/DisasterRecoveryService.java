package com.rapido.platformengineering.service;

import com.rapido.platformengineering.dto.DisasterRecoveryResponse;
import org.springframework.stereotype.Service;

@Service
public class DisasterRecoveryService {

    public DisasterRecoveryResponse getStatus() {

        return new DisasterRecoveryResponse(
                "COMPLETED",
                "COMPLETED",
                "COMPLETED",
                "AVAILABLE"
        );
    }
}