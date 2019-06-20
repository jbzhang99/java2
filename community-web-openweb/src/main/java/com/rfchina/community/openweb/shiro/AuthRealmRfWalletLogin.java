package com.rfchina.community.openweb.shiro;

import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.mch.SyncLoginResponseModel;
import com.rfchina.api.response.model.mch.UserInfoModel;
import com.rfchina.community.base.OpenXFSJConstant;
import com.rfchina.community.base.StatusCode;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.openweb.entity.AdminUserInfo;
import com.rfchina.community.openweb.handler.TempTokenInvalidException;
import com.rfchina.community.openweb.service.MerchantInfoService;
import com.rfchina.community.persistence.model.OpenMerchantInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 */
@Component
public class AuthRealmRfWalletLogin extends AuthorizingRealm {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${app.id}")
	private Integer appId;

	@Value("${shiro.realmName}")
	private String realmName;
	@Autowired
	private MerchantInfoService merchantInfoService;
	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;
	@Override
	public String getName() {
		return realmName;
	}

	@Override
	public boolean supports(AuthenticationToken authenticationToken) {
		return true;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		RfUsernamePasswordToken rfUsernamePasswordToken = (RfUsernamePasswordToken) authenticationToken;
		String username = (String) rfUsernamePasswordToken.getPrincipal();
		String password = String.valueOf(rfUsernamePasswordToken.getPassword());

		ResponseData<SyncLoginResponseModel> resp = null;

		if("tempToken".equals(username)){
			resp = platformGlobalComponent.verifyTempToken(password, null);
			if(resp.getCode() != 1001){
				throw new TempTokenInvalidException(StatusCode.INVALID_TEMP_TOKEN.value(),StatusCode.INVALID_TEMP_TOKEN.name());
			}
		}else{
			resp = platformGlobalComponent.rfWalletLogin(username, password, null);
		}

		if(resp.getCode() == 41003){
			throw new UnknownAccountException();
		}
		if(resp.getCode() == 41006){
			throw new TempTokenInvalidException(StatusCode.INVALID_PASSWORD.value(),StatusCode.INVALID_PASSWORD.name());
		}
		SyncLoginResponseModel model = resp.getData();
		if(model == null){
			throw new TempTokenInvalidException(StatusCode.INVALID_STATUS.value(),StatusCode.INVALID_STATUS.name());
		}


		AdminUserInfo adminInfo = new AdminUserInfo();
		UserInfoModel user = model.getUser();
		if(user.getMchId() == null){
			throw new TempTokenInvalidException(StatusCode.INVALID_STATUS.value(),StatusCode.INVALID_STATUS.name());
		}
		Long merchantId = null;
		OpenMerchantInfo merchantInfo = merchantInfoService.getMerchantByMchId(user.getMchId());
		String platformType = user.getRemark();
		if(merchantInfo == null || merchantInfo.getId() == null) {
			//同步商家信息
			merchantId = merchantInfoService.createMerchantIfNoExist(user.getMchId(), platformType, user.getUsername());
		}else{
			merchantId = merchantInfo.getId();
			refreshXFSJStatus(merchantInfo.getXfsjStatus(),merchantId,platformType, username);
		}
		adminInfo.setUserId(user.getUserId());
		adminInfo.setUid(merchantId);
		adminInfo.setUserName(user.getUsername());
		adminInfo.setUserToken(model.getUserToken());
		adminInfo.setRegProgress(user.getRegProgress());
		adminInfo.setMchId(user.getMchId());
		adminInfo.setRemark(user.getRemark());
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(adminInfo, password, getName());
		return authenticationInfo;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addRole("open");

		return authorizationInfo;
	}

	private void refreshXFSJStatus(Integer xfsjStatus,Long id,String platformType, String userName){
		OpenMerchantInfo merchantInfo = new OpenMerchantInfo();
		merchantInfo.setUserName(userName);
		boolean flag = false;
		if(xfsjStatus != null && StringUtils.isNotBlank(platformType)){
			merchantInfo.setId(id);
			if(OpenXFSJConstant.XFSJPlatformType.xfsj.equals(platformType) && xfsjStatus.intValue() != 1){
				merchantInfo.setXfsjStatus(1);
				flag = true;
			}
			if(OpenXFSJConstant.XFSJPlatformType.no_xfsj.equals(platformType) && xfsjStatus.intValue() != 0){
				merchantInfo.setXfsjStatus(0);
				flag = true;
			}
		}
		if(flag){
			merchantInfoService.updateMerchantInfo(merchantInfo);
		}
	}
}
