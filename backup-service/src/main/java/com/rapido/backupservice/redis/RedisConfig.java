package com.rapido.backupservice.redis;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {

    public RedisConfig() {

        System.out.println(
                "Redis HA Configuration Loaded");

    }
}