package com.rfchina.community.component.zipkin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZipkinProperties {

    @Value("${zipkin.service.enable:false}")
    private Boolean serviceEnable;

    @Value("${zipkin.collector.url:}")
    private String collectorUrl;

    @Value("${zipkin.service.name:}")
    private String serviceName;

    public Boolean getServiceEnable() {
        return serviceEnable;
    }

    public void setServiceEnable(Boolean serviceEnable) {
        this.serviceEnable = serviceEnable;
    }

    public String getCollectorUrl() {
        return collectorUrl;
    }

    public void setCollectorUrl(String collectorUrl) {
        this.collectorUrl = collectorUrl;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
