package com.rapido.communication_service.redis;

import org.springframework.stereotype.Service;

@Service
public class RedisMessageSubscriber {

    public void onMessage(String message) {

        System.out.println("Redis received message: " + message);
    }
}