package com.rfchina.community.openstore.controller;

import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.user.VerifyUserTokenResponseModel;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.exception.WorkRunTimeException;
import com.rfchina.community.base.util.HttpUtil;
import com.rfchina.community.component.PlatformGlobalComponent;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 */
public abstract class BaseController extends HttpClientPlugin {

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpServletResponse response;
	@Autowired
	PlatformGlobalComponent platformGlobalComponent;

	@Value("${auth.enabled:false}")
	private boolean authEnabled;
	@Value("${platform.host}")
	private String host;

	public boolean isAuthEnabled() {
		return authEnabled;
	}

	protected String getIp2() {
		return HttpUtil.getIp2(request);
	}

	protected void error(String msg) {
		throw new WorkRunTimeException(msg);
	}

	protected void validator(boolean fag, String msg) {
		if (fag) {
			error(msg);
		}
	}
	
	public int getServiceId(){
		Object object = request.getSession().getAttribute("serviceId");
		logger.info("getServiceId:serviceId={},sessionId={}", object, request.getSession().getId());
		validator(object == null, "验证失效，请重新进入");
		return (Integer)object;
	}
	public Long getUidId(){
		Object object = request.getSession().getAttribute("uid");
		logger.info("getUidId:uid={}", object);
		validator(object == null, "验证失效，请重新进入");
		return (Long)object;
	}
	public String getOpenId(){
		Object object = request.getSession().getAttribute("openId");
		logger.info("getOpenId:openId={}", object);
		validator(object == null, "验证失效，请重新进入");
		return (String)object;
	}
	
	public String getToken(){
		Object object = request.getSession().getAttribute("token");
		if(object == null)
			return null;
		return (String)object;
	}
	
	/**
	 * 令牌验证<br>
	 * 
	 * 请求地址: /auth/verify_token<br>
	 * 接口说明: 访问受保护资源时，调用此接口验证令牌是否合法、有效。<br>
	 * 请求类型: POST<br>
	 */
	public Long getUidByToken(String token) {
		validator(StringUtils.isBlank(token), "验证失效，请重新进入");
		ResponseData<VerifyUserTokenResponseModel> res = platformGlobalComponent.verifyUserToken(token);
		validator(res.getCode() != 1001, res.getMsg());
		Long id = res.getData().getUserId();
		return id;
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 获取用户id
	 * @return Long
	 * @throws
	 */
	public Long validateAndGetUid(String clientType, String accessToken) {
		if(StringUtils.isBlank(accessToken) && OpenConstant.ClientType.APP.equals(clientType))
			return getUidId();
		
		return getUidByToken(accessToken);
	}
}
