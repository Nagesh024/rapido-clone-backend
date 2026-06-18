package com.rapido.platformengineering.service;

import org.springframework.stereotype.Service;
import com.rapido.platformengineering.dto.PlatformResponse;

@Service
public class PlatformService {

    public PlatformResponse health() {

        return new PlatformResponse(
                "platform-engineering",
                "UP",
                "1.0.0"
        );
    }
}