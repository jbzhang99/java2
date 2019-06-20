package com.rfchina.community.open.bridge;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.rfchina.community.component.zipkin.ZipkinComponent;

@SpringBootApplication(scanBasePackages = { "com.rfchina.community.open.bridge","com.rfchina.community.component","com.rfchina.community.service" })
@MapperScan(value = { "com.rfchina.community.persistence.mapper", "com.rfchina.community.open.bridge.mapper" })
@EnableScheduling
@EnableAsync
@EnableCaching
@EnableTransactionManagement
public class RfCommunityOpenBridgeApiApplication extends WebMvcConfigurerAdapter {

	private static transient Logger logger = LoggerFactory.getLogger(RfCommunityOpenBridgeApiApplication.class);

	@Value("${auth.enabled:false}")
	private boolean authEnabled;
    @Autowired
    private ZipkinComponent zipkinComponent;
    
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(RfCommunityOpenBridgeApiApplication.class);
		app.addListeners(new ApplicationPidFileWriter());
		app.run(args);
	}

	public void addInterceptors(InterceptorRegistry registry) {
		zipkinComponent.configInterceptors(registry);
		
		if (authEnabled) {
			// registry.addWebRequestInterceptor(new LoginWebRequestInterceptor())
			// .addPathPatterns("/community/api/**")
			// .excludePathPatterns(Constant.ROOT_PATH_OPEN + "/pay_create");
		} else {
			logger.warn("[auth.enabled] is false, DO NOT validate auth");
		}
	}
}
