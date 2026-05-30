package com.rapido.communication_service.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
public class RedisMessagePublisher {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ChannelTopic chatTopic;

    public RedisMessagePublisher(
            RedisTemplate<String, Object> redisTemplate,
            ChannelTopic chatTopic
    ) {
        this.redisTemplate = redisTemplate;
        this.chatTopic = chatTopic;
    }

    public void publish(String message) {

        redisTemplate.convertAndSend(
                chatTopic.getTopic(),
                message
        );

        System.out.println("Redis published message: " + message);
    }
}