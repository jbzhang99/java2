package com.rfchina.community.component.zipkin;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.rfchina.platform.zipkin.ZipkinContext;
import com.rfchina.platform.zipkin.handler.ServletTracingFilter;

import brave.spring.webmvc.SpanCustomizingAsyncHandlerInterceptor;



@Configuration
@ConditionalOnProperty(name = "zipkin.service.enable", havingValue = "true")
@Import({SpanCustomizingAsyncHandlerInterceptor.class, ServletTracingFilter.class})
public class ZipkinComponent {

    private static final Logger log = LoggerFactory.getLogger(ZipkinComponent.class);

    @Autowired
    private ZipkinProperties zipKinConfig;

    @Autowired
    private SpanCustomizingAsyncHandlerInterceptor tracingInterceptor;

    @PostConstruct
    public void init() {
        // Zipkin的总开关
        ZipkinContext.setEnable(zipKinConfig.getServiceEnable());
        // Zipkin收集器地址
        ZipkinContext.setZipkinUrl(zipKinConfig.getCollectorUrl());
        // 本地服务名称
        ZipkinContext.setServiceName(zipKinConfig.getServiceName());
        // 初始化上下文
        ZipkinContext.init();
    }

    public void configInterceptors(InterceptorRegistry registry) {
        if (ZipkinContext.isEnable()) {
            registry.addInterceptor(tracingInterceptor);
            log.info("Zipkin-Support : SpringMvc注入跟踪拦截器!");
        }
    }
}

