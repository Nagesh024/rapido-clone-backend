package com.rapido.search.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RateLimiterService {

    private final Map<String, Integer> requestCounts =
            new ConcurrentHashMap<>();

    public boolean allowRequest(String clientIp) {

        requestCounts.putIfAbsent(clientIp, 0);

        int count =
                requestCounts.get(clientIp);

        if (count >= 5) {
            return false;
        }

        requestCounts.put(
                clientIp,
                count + 1
        );

        return true;
    }
}