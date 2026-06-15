package com.rapido.backupservice.resilience;

import org.springframework.stereotype.Service;

@Service
public class CacheService {

    public String getRideHistoryFromCache() {

        return "Ride History Returned From Cache";
    }
}