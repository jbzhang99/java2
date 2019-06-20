package com.rfchina.community.openstore.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.jfinal.weixin.sdk.cache.IAccessTokenCache;

public class SpringBootRedisAccessTokenCache implements IAccessTokenCache {
	private final String ACCESS_TOKEN_PREFIX = "wx:token:";

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Override
	public String get(String key) {
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
		return ops.get(ACCESS_TOKEN_PREFIX.concat(key));
	}

	@Override
	public void set(String key, String jsonValue) {
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
		ops.set(ACCESS_TOKEN_PREFIX.concat(key), jsonValue, DEFAULT_TIME_OUT, TimeUnit.SECONDS);
	}

	@Override
	public void remove(String key) {
		stringRedisTemplate.delete(ACCESS_TOKEN_PREFIX.concat(key));
	}

}
