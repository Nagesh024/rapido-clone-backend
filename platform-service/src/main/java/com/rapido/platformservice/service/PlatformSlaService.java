package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.PlatformSlaResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PlatformSlaService {

    public PlatformSlaResponse getPlatformSla() {

        PlatformSlaResponse response = new PlatformSlaResponse();

        response.setAvailability(99.97);
        response.setLatency(84.3);
        response.setErrorBudget(96.5);
        response.setSloCompliance(99.82);

        if (response.getSloCompliance() >= 99.0) {
            response.setSlaStatus("COMPLIANT");
        } else {
            response.setSlaStatus("NON_COMPLIANT");
        }

        response.setTimestamp(LocalDateTime.now().toString());

        return response;
    }
}