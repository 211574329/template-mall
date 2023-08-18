package com.echo.mall.order.service.impl;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisService {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    public Long incr(String key) {
//        ValueOperations<String, String> ops = redisTemplate.opsForValue();
//        return ops.increment(key, 1L);
        return new RedisAtomicLong(key, redisTemplate.getConnectionFactory()).incrementAndGet();
    }

    public Long get(String key) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String value = ops.get(key);
        if (value == null) {
            return null;
        }
        return Long.parseLong(value);
    }
}
