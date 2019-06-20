package com.rfchina.community.openstore;

import com.jfinal.weixin.sdk.cache.IAccessTokenCache;
import com.rfchina.community.base.Constant;
import com.rfchina.community.component.zipkin.ZipkinComponent;
import com.rfchina.community.openstore.interceptor.OpenLogRequestInterceptor;
import com.rfchina.community.openstore.service.SpringBootRedisAccessTokenCache;
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

@SpringBootApplication(scanBasePackages = { "com.rfchina.community.component", "com.rfchina.community.service",
		"com.rfchina.community.openstore" })
@MapperScan(value = { CommunityOpenStoreApplication.MAPPER_PACKAGE, CommunityOpenStoreApplication.MAPPER_PACKAGE1 })
// @EnableScheduling
@EnableAsync
// @EnableCaching
@EnableTransactionManagement
//@EnableFuScheduleTask
//(appId="99831765", scheduleTaskBaseUri="http://test.p.rfmember.net")
public class CommunityOpenStoreApplication extends WebMvcConfigurerAdapter {

	public static final String MAPPER_PACKAGE = "com.rfchina.community.persistence.mapper";
	public static final String MAPPER_PACKAGE1 = "com.rfchina.community.openstore.mapper";

	private static transient Logger logger = LoggerFactory.getLogger(CommunityOpenStoreApplication.class);

	@Value("${auth.enabled:false}")
	private boolean authEnabled;
    @Autowired
    private ZipkinComponent zipkinComponent;
    
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CommunityOpenStoreApplication.class);
		app.addListeners(new ApplicationPidFileWriter());
		app.run(args);
	}

	public void addInterceptors(InterceptorRegistry registry) {
		zipkinComponent.configInterceptors(registry);
		
		registry.addInterceptor(new OpenLogRequestInterceptor()).addPathPatterns("/api/**")
				.excludePathPatterns(Constant.ROOT_PATH_OPENWEB + "/acc/register");
		if (authEnabled) {

			logger.info("[auth.enabled] is true, DO  validate auth");
		} else {
			logger.info("[auth.enabled] is false, DO NOT validate auth");
		}
	}

	@Bean
	public IAccessTokenCache getAccessTokenCache() {
		return new SpringBootRedisAccessTokenCache();
	}

}
