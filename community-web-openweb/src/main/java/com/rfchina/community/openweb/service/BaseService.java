package com.rfchina.community.openweb.service;

import com.rfchina.community.base.exception.WorkRunTimeException;
import com.rfchina.community.openweb.entity.AdminUserInfo;
import com.rfchina.community.openweb.shiro.AdminInfoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class BaseService {
	
	@Value("${auth.enabled:false}")
	private boolean authEnabled;
	protected final Logger logger = LoggerFactory.getLogger(getClass());
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

	public static void error(String msg) {
		throw new WorkRunTimeException(msg);
	}

	protected void error(Exception e) {
		throw new RuntimeException(e);
	}

	protected void validator(boolean fag, String msg) {
		if (fag) {
			error(msg);
		}
	}
	
}
