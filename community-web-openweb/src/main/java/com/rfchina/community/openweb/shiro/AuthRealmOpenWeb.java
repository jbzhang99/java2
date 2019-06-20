//package com.rfchina.community.openweb.shiro;
//
//import com.rfchina.community.base.Constant;
//import com.rfchina.community.openweb.entity.AdminUserInfo;
//import com.rfchina.community.persistence.mapper.PassportMapper;
//import com.rfchina.community.persistence.model.Passport;
//import com.rfchina.community.persistence.model.PassportExample;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// */
//@Component
//public class AuthRealmOpenWeb extends AuthorizingRealm {
//
//	private final Logger logger = LoggerFactory.getLogger(getClass());
//
//	@Value("${app.id}")
//	private Integer appId;
//
//	@Value("${shiro.realmName}")
//	private String realmName;
//
//	@Autowired
//	private PassportMapper passportMapper;
//
//	@Override
//	public String getName() {
//		return realmName;
//	}
//
//	@Override
//	public boolean supports(AuthenticationToken authenticationToken) {
//		return true;
//	}
//
//	@Override
//	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//		RfUsernamePasswordToken rfUsernamePasswordToken = (RfUsernamePasswordToken) authenticationToken;
//		String username = (String) rfUsernamePasswordToken.getPrincipal();
//
//		PassportExample example = new PassportExample();
//		example.createCriteria().andUsernameEqualTo(username).andAppIdEqualTo(appId);
//		List<Passport> list = passportMapper.selectByExample(example);
//
//		if (null == list || list.isEmpty() || list.size() != 1) {
//			throw new UnknownAccountException();
//		}
//		Passport passport = list.get(0);
//
//		AdminUserInfo adminInfo = new AdminUserInfo();
//		// adminInfo.setRealIp(rfUsernamePasswordToken.getRealIp());
//		//
//		if (Constant.Passport.Status.DISABLE.intValue() == passport.getStatus()) { // 禁用，直接抛出异常
//			throw new DisabledAccountException();
//		}
//		adminInfo.setUid(passport.getId());
//		adminInfo.setEmail(passport.getUsername());
//
//		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(adminInfo, passport.getPassword(), getName());
//		return authenticationInfo;
//	}
//
//	@Override
//	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//		authorizationInfo.addRole("open");
//
//		return authorizationInfo;
//	}
//
//}
