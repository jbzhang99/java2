package com.rfchina.community.openweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.rfchina.community.base.exception.WorkRunTimeException;
import com.rfchina.community.base.util.HttpUtil;
import com.rfchina.community.openweb.entity.AdminUserInfo;
import com.rfchina.community.openweb.service.CommunityServiceService;
import com.rfchina.community.openweb.shiro.AdminInfoUtils;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.CommunityServiceTemp;

/**
 */
public abstract class BaseController {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpServletResponse response;
	@Autowired
	CommunityServiceService communityServiceService;

	@Value("${auth.enabled:false}")
	private boolean authEnabled;

	public boolean isAuthEnabled() {
		return authEnabled;
	}

	protected AdminUserInfo getAdminInfo() {
		if (authEnabled) {
			return AdminInfoUtils.getAdminUserInfo();
		}
		AdminUserInfo adminInfo = new AdminUserInfo();
		adminInfo.setEmail("liyicun@163.com");
		adminInfo.setUid(4L);
		return adminInfo;
	}

	protected Long getAdminId() {
		return getAdminInfo().getUid();
	}

	protected String getIp2() {
		return HttpUtil.getIp2(request);
	}

	protected void error(String msg) {
		throw new WorkRunTimeException(msg);
	}

	protected void error(Exception e) throws Exception {
		throw e;
	}

	protected void validator(boolean fag, String msg) {
		if (fag) {
			error(msg);
		}
	}

	public CommunityService authorityCheck(int serviceId) {
		Long adminid = getAdminId();
		CommunityService communityServiceTemp = communityServiceService.getCommunityServiceByPrimaryKey(serviceId);
		if (communityServiceTemp == null) {
			error("此服务信息不存在"+serviceId);
		}
		if (authEnabled) {
			validator(communityServiceTemp.getMerchantId().longValue() != adminid.longValue(),
					"非法访问!" + communityServiceTemp.getMerchantId().longValue() + "_" + adminid.longValue());
		}
		return communityServiceTemp;
	}

}
