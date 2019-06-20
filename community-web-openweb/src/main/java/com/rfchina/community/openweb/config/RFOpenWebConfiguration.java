package com.rfchina.community.openweb.config;


import com.rfchina.community.openweb.shiro.CustomFormAuthenticationFilter;
import com.rfchina.community.openweb.shiro.OpenWebRedisSessionDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.servlet.Filter;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/**
 */
@Configuration
public class RFOpenWebConfiguration {

    public static final long GLOBAL_SESSION_TIMEOUT = TimeUnit.DAYS.toMillis(30);

    @Value("#{ @environment[\'shiro.sessionManager.sessionIdCookieEnabled\'] ?: true }")
    protected boolean sessionIdCookieEnabled;

    @Value("#{ @environment[\'shiro.sessionManager.sessionIdUrlRewritingEnabled\'] ?: true }")
    protected boolean sessionIdUrlRewritingEnabled;

    @Value("#{ @environment[\'shiro.useRedisSessionDAO\'] ?: false }")
    protected boolean useRedisSessionDAO;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public AsyncTaskExecutor asyncTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("Anno-Executor");
        executor.setMaxPoolSize(10);
        return executor;
    }

    @Bean
    protected SessionManager sessionManager(RedisTemplate<Object, Object> redisTemplate) {
        DefaultWebSessionManager webSessionManager = new DefaultWebSessionManager();
        if(useRedisSessionDAO) {
            webSessionManager.setSessionDAO(new OpenWebRedisSessionDAO(redisTemplate));
            logger.info("Configure shiro to use redis-session-dao");
        } else {
            logger.info("SHiro do not use redis-session-dao");
        }
        webSessionManager.setSessionIdCookieEnabled(this.sessionIdCookieEnabled);
        webSessionManager.setSessionIdUrlRewritingEnabled(this.sessionIdUrlRewritingEnabled);
        webSessionManager.setGlobalSessionTimeout(GLOBAL_SESSION_TIMEOUT);      //Session会话6小时后超时
        return webSessionManager;
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor mvp = new MethodValidationPostProcessor();
        return mvp;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        return defaultWebSecurityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        System.out.println("ShiroConfiguration.shiroFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();//获取filters
        filters.put("authc", new CustomFormAuthenticationFilter());//将自定义 的FormAuthenticationFilter注入shiroFilter中
        // 必须设置SecuritManager
       shiroFilterFactoryBean.setSecurityManager(securityManager);

        return shiroFilterFactoryBean;

    }
}
