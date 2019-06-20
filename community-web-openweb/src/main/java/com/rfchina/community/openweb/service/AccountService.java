package com.rfchina.community.openweb.service;

import com.rfchina.community.openweb.entity.AdminUserInfo;
import com.rfchina.community.openweb.shiro.RfUsernamePasswordToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends BaseService{
	@Value("${shiro.realmName}")
	private String realmName;


	public boolean login(String userName, String encryptedPassword, String realIp) {
		RfUsernamePasswordToken token = new RfUsernamePasswordToken(userName, encryptedPassword);
		token.setRealIp(realIp);
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);
		return subject.isAuthenticated();
	}

	public AdminUserInfo rfWalletLogin(String userName, String password, String realIp) {
		RfUsernamePasswordToken token = new RfUsernamePasswordToken(userName, password);
		token.setRealIp(realIp);
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);
		AdminUserInfo adminInfo = (AdminUserInfo) subject.getPrincipal();
		return adminInfo;
	}

	//
	public boolean loginWhenRegister(String tempToken, String realIp){
		RfUsernamePasswordToken token = new RfUsernamePasswordToken("tempToken", tempToken);
		token.setRealIp(realIp);
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);
		return subject.isAuthenticated();

	}
}
