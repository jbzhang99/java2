package com.rfchina.community.component;

import com.rfchina.community.base.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class DistTaskComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(DistTaskComponent.class);

    private static final String KEY_PREFIX = "rfcommunity_dist_task_";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void dist(String key, DistTask task) {
        String cacheKey = KEY_PREFIX + key;
        LOGGER.info("Begin to run task for key[{}]", key);
        try {
            if(!stringRedisTemplate.hasKey(cacheKey)) {
                task.run();
                stringRedisTemplate.opsForValue().set(cacheKey, Constant.YesOrNo.YES.toString(), 2, TimeUnit.MINUTES);
                LOGGER.info("Cache key[{}] is not exists in Redis, task will be runned");
            } else {
                LOGGER.info("Cache key[{}] is exists in Redis, task will not run");
            }
        } catch (Exception e) {
            LOGGER.error("Run task error for key[" + key +"]", e);
        } finally {
            stringRedisTemplate.delete(key);
            LOGGER.info("Finish task for key[{}]", key);
        }
    }
}
