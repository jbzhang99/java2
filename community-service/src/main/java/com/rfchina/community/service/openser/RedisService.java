package com.rfchina.community.service.openser;

import com.rfchina.community.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedisService
 * @Description TODO
 * @Author wlrllr
 * @Date 2019/2/1 11:16
 * @Version 1.0
 **/
@Service
public class RedisService  extends BaseService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public String get(String key) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        return ops.get(key);
    }

    public void set(String key, String value) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set(key, value);
    }

    public void set(String key, String value,Long timeout) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set(key, value, timeout, TimeUnit.SECONDS);
    }

    public void remove(String key) {
        stringRedisTemplate.delete(key);
    }
}
