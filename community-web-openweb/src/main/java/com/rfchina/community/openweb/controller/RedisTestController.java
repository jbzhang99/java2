package com.rfchina.community.openweb.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openweb.service.CommunityServiceService;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.model.CommunityService;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENWEB)
public class RedisTestController extends BaseController {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@RequestMapping("/redis_test")
	public Result<?> redis_test() {
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
		Long id = ops.increment("id", 1);
		if (id == 1) {
			stringRedisTemplate.expire("id", 1, TimeUnit.MINUTES);
		}
		Long x = stringRedisTemplate.opsForValue().increment("a", 1);
		return Result.successData(id);
	}
	

}
