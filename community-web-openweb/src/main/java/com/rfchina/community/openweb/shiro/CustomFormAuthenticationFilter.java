package com.rfchina.community.openweb.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        // 获取当前登录
        logger.info("onAccessDenied--------------");
        Subject subject = getSubject(request, response);
        if (subject.getPrincipal() == null) {
            // 使用response响应流返回数据到前台（因前端需要接受json数据，注意前后端跨域问题）
            return false;
        } else {
            return true;
        }
    }
}