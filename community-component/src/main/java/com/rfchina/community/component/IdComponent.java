package com.rfchina.community.component;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 */
@Component
public class IdComponent {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	public Long id() {
		return id("id");
	}

	// stringRedisTemplate.expire(key, 1, TimeUnit.DAY);
	public Long id(String key) {
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
		return ops.increment(key, 1);
	}

	public String idByLength(int length) {
		if (length > 20) {
			throw new RuntimeException("必须小于20");
		}
		if (length < 1) {
			throw new RuntimeException("必须大于0");
		}
		String str = "00000000000000000000" + id();
		return str.substring(str.length() - length);
	}
}
