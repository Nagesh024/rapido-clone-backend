package com.rapido.backupservice.redis;

import org.springframework.stereotype.Service;

@Service
public class RedisFailoverService {

    public void triggerFailover() {

        System.out.println(
                "Redis Replica Promoted To Master");

    }
}