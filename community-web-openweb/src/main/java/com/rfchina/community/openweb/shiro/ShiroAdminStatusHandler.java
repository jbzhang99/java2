package com.rfchina.community.openweb.shiro;

import com.rfchina.community.openweb.entity.AdminUserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 */
@Component
public class ShiroAdminStatusHandler {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	// @Autowired
	// private PlatformAdminMapper platformAdminMapper;
//	@Autowired
//	private PassportMapper passportMapper;

	public void checkAdminStatus() throws Exception {
		
		Subject subject = SecurityUtils.getSubject();
		boolean auth = subject.isAuthenticated();
//		logger.info("auth:{}", auth);
		if (auth) {
			AdminUserInfo adminInfo = AdminInfoUtils.getAdminUserInfo();
			if (null == adminInfo)
				throw new DisabledAccountException();
		}else{
			throw new DisabledAccountException();
		}

	}
}
