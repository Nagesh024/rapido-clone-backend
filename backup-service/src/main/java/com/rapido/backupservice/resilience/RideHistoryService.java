package com.rapido.backupservice.resilience;

import org.springframework.stereotype.Service;

@Service
public class RideHistoryService {

    private final CacheService cacheService;

    public RideHistoryService(
            CacheService cacheService) {

        this.cacheService = cacheService;
    }

    public String getRideHistory() {

        try {

            throw new RuntimeException(
                    "Ride Service Down");

        } catch (Exception ex) {

            System.out.println(
                    "Fallback Activated");

            return cacheService.getRideHistoryFromCache();
        }
    }
}