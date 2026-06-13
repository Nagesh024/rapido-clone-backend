package com.rapido.globalservice.cache;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CountryCacheService {

    private final RedisTemplate<String, Object>
            redisTemplate;

    public CountryCacheService(
            RedisTemplate<String, Object> redisTemplate
    ) {
        this.redisTemplate = redisTemplate;
    }

    public void saveTax(
            String countryCode,
            Object value
    ) {

        redisTemplate.opsForValue().set(
                "country:" + countryCode + ":tax",
                value
        );
    }

    public void savePricing(
            String countryCode,
            Object value
    ) {

        redisTemplate.opsForValue().set(
                "country:" + countryCode + ":pricing",
                value
        );
    }

    public void saveCurrency(
            String countryCode,
            Object value
    ) {

        redisTemplate.opsForValue().set(
                "country:" + countryCode + ":currency",
                value
        );
    }

    public Object get(
            String key
    ) {

        return redisTemplate
                .opsForValue()
                .get(key);
    }
}