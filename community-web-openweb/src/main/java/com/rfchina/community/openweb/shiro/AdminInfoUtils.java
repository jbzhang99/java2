package com.rfchina.community.openweb.shiro;

import com.rfchina.community.openweb.entity.AdminUserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 */
public class AdminInfoUtils {

    public static final AdminUserInfo getAdminUserInfo() {
        Subject subject = SecurityUtils.getSubject();
        AdminUserInfo adminInfo = (AdminUserInfo) subject.getPrincipal();
        return adminInfo;
    }

    public static boolean isAjax(ServletRequest request){
        return "XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest)request).getHeader("X-Requested-With"));
    }

}
