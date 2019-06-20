 package com.rfchina.community.openapi;

import static com.rfchina.community.openapi.RfCommunityOpenApiApplication.MAPPER_PACKAGE;
import static com.rfchina.community.openapi.RfCommunityOpenApiApplication.MAPPER_PACKAGE1;

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

import com.rfchina.community.base.Constant;
import com.rfchina.community.component.zipkin.ZipkinComponent;
import com.rfchina.community.openapi.interceptor.LoginWebRequestInterceptor;

@SpringBootApplication(scanBasePackages = {"com.rfchina.community"})
@MapperScan(value = {MAPPER_PACKAGE1, MAPPER_PACKAGE})
@EnableScheduling
@EnableAsync
@EnableCaching
@EnableTransactionManagement
public class RfCommunityOpenApiApplication extends WebMvcConfigurerAdapter {

	public static final String MAPPER_PACKAGE = "com.rfchina.community.persistence.mapper";
	public static final String MAPPER_PACKAGE1 = "com.rfchina.community.openapi.mapper";
	
	private static transient Logger logger = LoggerFactory.getLogger(RfCommunityOpenApiApplication.class);

	
	@Value("${auth.enabled:false}")
	private boolean authEnabled;
    @Autowired
    private ZipkinComponent zipkinComponent;
    
	public static void main(String[] args) {
//		SpringApplication.run(RfCommunityOpenApiApplication.class, args);
		
		SpringApplication app = new SpringApplication(RfCommunityOpenApiApplication.class);
		app.addListeners(new ApplicationPidFileWriter());
		app.run(args);
	}
	
	public void addInterceptors(InterceptorRegistry registry) {
		zipkinComponent.configInterceptors(registry);
		if (authEnabled) {
			registry.addWebRequestInterceptor(new LoginWebRequestInterceptor())
			.addPathPatterns("/community/api/**")
			.excludePathPatterns(Constant.ROOT_PATH_OPEN + "/pay_create");
		} else {
			logger.warn("[auth.enabled] is false, DO NOT validate auth");
		}
	}
}
