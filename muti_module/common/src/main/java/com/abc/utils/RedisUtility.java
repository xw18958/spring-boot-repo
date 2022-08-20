package com.abc.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class RedisUtility {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
                }
            return true;
            } catch (Exception e) {
            e.printStackTrace();
            return false;
            }
        }

    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
        }

    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
            } catch (Exception e) {
            e.printStackTrace();
            return false;
            }
        }

}
