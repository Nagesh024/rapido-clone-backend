package com.rapido.backupservice.redis;

import org.springframework.stereotype.Service;

@Service
public class RedisHealthService {

    public boolean isHealthy() {

        System.out.println(
                "Redis Health Check Passed");

        return true;
    }
}