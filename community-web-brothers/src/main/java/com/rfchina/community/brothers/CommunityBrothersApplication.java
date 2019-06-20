package com.rfchina.community.brothers;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication(scanBasePackages = { "com.rfchina.community.component","com.rfchina.community.service","com.rfchina.community.brothers", })
@MapperScan(value = { CommunityBrothersApplication.MAPPER_PACKAGE1, CommunityBrothersApplication.MAPPER_PACKAGE })
@EnableScheduling
@EnableAsync
@EnableCaching
@EnableTransactionManagement
public class CommunityBrothersApplication extends WebMvcConfigurerAdapter {

	public static final String MAPPER_PACKAGE = "com.rfchina.community.persistence.mapper";
	public static final String MAPPER_PACKAGE1 = "com.rfchina.community.brothers.mapper";

	private static transient Logger logger = LoggerFactory.getLogger(CommunityBrothersApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CommunityBrothersApplication.class);
		app.addListeners(new ApplicationPidFileWriter());
		app.run(args);
	}
//	@Value("${platform.host}")
//	private String host;
//
//	@Value("${platform.appId}")
//	private Long appId;
//	@Value("${platform.appSecret}")
//	private String appSecret;
	
//	@Bean
//	public PlatformGlobalComponent platformGlobalComponent(){
//		PlatformGlobalComponent p=new PlatformGlobalComponent();
//		p.setAppId(appId);
//		p.setAppSecret(appSecret);
//		p.setHost(host);
//		logger.info("platformGlobalComponent host:{},appId:{},appSecret:{}",host,appId,appSecret);
//		return p;
//	}
}
