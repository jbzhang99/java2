package com.rfchina.community.openweb;

import com.jfinal.weixin.sdk.cache.IAccessTokenCache;
import com.rfchina.community.base.Constant;
import com.rfchina.community.openweb.interceptor.OpenLoginInterceptor;
import com.rfchina.community.openweb.service.SpringBootRedisAccessTokenCache;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.jfinal.weixin.sdk.cache.IAccessTokenCache;
import com.rfchina.community.base.Constant;
import com.rfchina.community.component.zipkin.ZipkinComponent;
import com.rfchina.community.openweb.interceptor.OpenLoginInterceptor;
import com.rfchina.community.openweb.service.SpringBootRedisAccessTokenCache;


@SpringBootApplication(scanBasePackages = { "com.rfchina.community.component", "com.rfchina.community.service",
		"com.rfchina.community.openweb" })
@MapperScan(value = { CommunityOpenWebApplication.MAPPER_PACKAGE, CommunityOpenWebApplication.MAPPER_PACKAGE1 })
// @EnableScheduling
@EnableAsync
// @EnableCaching
@EnableTransactionManagement
public class CommunityOpenWebApplication extends WebMvcConfigurerAdapter {

	public static final String MAPPER_PACKAGE = "com.rfchina.community.persistence.mapper";
	public static final String MAPPER_PACKAGE1 = "com.rfchina.community.openweb.mapper";

	private static transient Logger logger = LoggerFactory.getLogger(CommunityOpenWebApplication.class);

	@Value("${auth.enabled:false}")
	private boolean authEnabled;
    @Autowired
    private ZipkinComponent zipkinComponent;
//	@Value("${spring.redis.host}")
//	private String host;
//
//	@Value("${spring.redis.port}")
//	private int port;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CommunityOpenWebApplication.class);
		app.addListeners(new ApplicationPidFileWriter());
		app.run(args);
	}

	public void addInterceptors(InterceptorRegistry registry) {
		zipkinComponent.configInterceptors(registry);
		if (authEnabled) {
			registry.addInterceptor(new OpenLoginInterceptor()).addPathPatterns("/api/**")
//					.excludePathPatterns(Constant.ROOT_PATH_OPENWEB + "/acc/register")
//					.excludePathPatterns(Constant.ROOT_PATH_OPENWEB + "/acc/login")
					.excludePathPatterns(Constant.ROOT_PATH_OPENWEB + "/acc/**")
					.excludePathPatterns(Constant.ROOT_PATH_OPENWEB + "/service_category_list")
					.excludePathPatterns(Constant.ROOT_PATH_OPENWEB + "/service_area_list")
//					.excludePathPatterns(Constant.ROOT_PATH_OPENWEB + "/acc/register_step_one")
//					.excludePathPatterns(Constant.ROOT_PATH_OPENWEB + "/acc/reg_from_email")
//					.excludePathPatterns(Constant.ROOT_PATH_OPENWEB + "/acc/forget_passwd_step_one")
			;
			logger.info("[auth.enabled] is true, DO  validate auth");
		} else {
			logger.info("[auth.enabled] is false, DO NOT validate auth");
		}
	}

	////////

//	/**
//	 * 配置shiro redisManager 使用的是shiro-redis开源插件
//	 *
//	 * @return
//	 */
//	public RedisManager redisManager() {
//		RedisManager redisManager = new RedisManager();
//		redisManager.setHost(host);
//		redisManager.setPort(port);
//		// 8小时过期
//		redisManager.setExpire(60 * 60 * 8);// 配置缓存过期时间
//		// redisManager.setExpire(60 * 3);// 配置缓存过期时间
//		redisManager.setTimeout(Protocol.DEFAULT_TIMEOUT);
//		// redisManager.setPassword(password);
//		return redisManager;
//	}
//
//	/**
//	 * cacheManager 缓存 redis实现 使用的是shiro-redis开源插件
//	 *
//	 * @return
//	 */
//	// public RedisCacheManager cacheManager() {
//	// RedisCacheManager redisCacheManager = new RedisCacheManager( );
//	// redisCacheManager.setRedisManager(redisManager());
//	// return redisCacheManager;
//	// }
//
//	/**
//	 * RedisSessionDAO shiro sessionDao层的实现 通过redis 使用的是shiro-redis开源插件
//	 */
//	@Bean
//	public RedisSessionDAO redisSessionDAO() {
//
//		RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
//		redisSessionDAO.setRedisManager(redisManager());
//		redisSessionDAO.setKeyPrefix("openweb");
//		return redisSessionDAO;
//	}
//
//	/**
//	 * shiro session的管理
//	 */
//	@Bean
//	public DefaultWebSessionManager sessionManager() {
//		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//		sessionManager.setSessionDAO(redisSessionDAO());
//		logger.info("------------=-=-=0iu99");
//		return sessionManager;
//	}

	@Bean
	public IAccessTokenCache getAccessTokenCache() {
		return new SpringBootRedisAccessTokenCache();
	}



}
