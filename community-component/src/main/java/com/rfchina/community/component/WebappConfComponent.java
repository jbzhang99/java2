package com.rfchina.community.component;

import com.rfchina.community.base.Constant;
import com.rfchina.community.persistence.mapper.WebappConfMapper;
import com.rfchina.community.persistence.model.WebappConf;
import com.rfchina.community.persistence.model.WebappConfExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class WebappConfComponent {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private WebappConfMapper webappConfMapper;

    private static final String COMMUNITY_ADMIN_AUTO_LOGIN_KEY = "community.admin.auto_login";

    private static final String PLATFORM_ADMIN_AUTO_LOGIN_KEY = "platform.admin.auto_login";

    private static final String WEB_CONF = "WEB_CONF:";

    public boolean communityAdminIsAutoLogin() {
        WebappConfExample example = new WebappConfExample();
        example.createCriteria().andAppIdEqualTo(Constant.App.Id.COMMUNITY_ADMIN.value())
                .andConfKeyEqualTo(COMMUNITY_ADMIN_AUTO_LOGIN_KEY);
        boolean flag = webappConfMapper.selectByExample(example)
                .stream()
                .findFirst()
                .map((value) -> "1".equals(value.getConfValue()))
                .orElse(Boolean.FALSE);
        return flag;
    }

    public boolean platformAdminIsAutoLogin() {
        WebappConfExample example = new WebappConfExample();
        example.createCriteria().andAppIdEqualTo(Constant.App.Id.PLATFORM_ADMIN.value())
                .andConfKeyEqualTo(PLATFORM_ADMIN_AUTO_LOGIN_KEY);
        boolean flag = webappConfMapper.selectByExample(example)
                .stream()
                .findFirst()
                .map((value) -> "1".equals(value.getConfValue()))
                .orElse(Boolean.FALSE);
        return flag;
    }

    public String getWebConf(int appId, String confKey) {
        return getWebConf(appId, confKey, 1L, TimeUnit.HOURS);
    }

    public String getWebConf(int appId, String confKey, long cacheTime, TimeUnit cacheUnit) {

        String cacheKey = WEB_CONF + appId + confKey;

        String confValue = stringRedisTemplate.opsForValue().get(cacheKey);
        if (null == confValue) {
            WebappConfExample example = new WebappConfExample();
            example.createCriteria().andAppIdEqualTo(appId)
                    .andConfKeyEqualTo(confKey);
            WebappConf conf = webappConfMapper.selectByExample(example)
                    .stream()
                    .findFirst().get();
            stringRedisTemplate.opsForValue().set(cacheKey, conf.getConfValue(), cacheTime, cacheUnit);
            return conf.getConfValue();
        } else {
            return confValue;
        }

    }
}
