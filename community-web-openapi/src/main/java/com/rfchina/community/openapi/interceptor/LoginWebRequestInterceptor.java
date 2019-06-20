package com.rfchina.community.openapi.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.exception.LoginRunTimeException;
//import com.rfchina.community.openapi.service.PlatformUserService;

public class LoginWebRequestInterceptor implements WebRequestInterceptor {

	private static Logger logger = LoggerFactory.getLogger(LoginWebRequestInterceptor.class);

	@Override
	public void preHandle(WebRequest request) throws Exception {
		//不用去验证 网关会验证
//		String access_token = request.getParameter("access_token");
//		if (StringUtils.isNotBlank(access_token)) {
//			try {
//				PlatformUserService service = WebApplicationContextUtils
//						.getWebApplicationContext(((ServletRequestAttributes) request).getRequest().getServletContext())
//						.getBean(PlatformUserService.class);
//				JSONObject user = service.authVerifyToken(access_token);
//				logger.info(" 851 userinfo : {}",user);
//				request.setAttribute("logininfo",user.getLong("user_id"),
//						ServletRequestAttributes.SCOPE_REQUEST);
//			} catch (Exception e) {
//				throw new LoginRunTimeException("来刷新的token吧,"+e.getMessage());
//			}
//		}
	}

	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {

	}

	@Override
	public void afterCompletion(WebRequest request, Exception ex) throws Exception {

	}
}
