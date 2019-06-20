package com.rfchina.community.open.bridge.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rfchina.api.response.model.app.CreateAppResponseModel;
import com.rfchina.api.response.model.pay.FuPayAddMchAccountResponseModel;
import com.rfchina.api.response.model.pay.FuPayAddMchResponseModel;
import com.rfchina.api.response.model.pay.FuPayGetMchAccountListResponseModel;
import com.rfchina.api.response.model.pay.base.FuPayAccountModel;
import com.rfchina.api.response.model.pay.base.FuPayMchAccountModel;
import com.rfchina.community.base.Constant;
import com.rfchina.community.component.JavaMailComponent;
import com.rfchina.community.component.JavaMailComponent.EmailType;
import com.rfchina.community.component.OpenAuditInfoComponent.ObjectType;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceTempMapper;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.CommunityServiceTemp;
import com.rfchina.community.persistence.model.CommunityServiceTempExample;
import com.rfchina.community.persistence.model.OpenMerchantInfo;

/**
 */
@Service
public class OpenXFSJMerchantInfoService extends BaseService implements IOpenAuditType {

	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;

//	@Autowired
//	private OpenMerchantInfoTempMapper openMerchantInfoTempMapper;

	// @Autowired
	// private platformGlobalComponent platformGlobalComponent;

	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;

	@Autowired
	private JavaMailComponent javaMailComponent;

	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private CommunityServiceTempMapper communityServiceTempMapper;

	private static transient Logger logger = LoggerFactory.getLogger(OpenXFSJMerchantInfoService.class);

	@Override
	public IOpenAuditTypeReturn audit(ObjectType type) {
		// 小富市集审批
		if (type.compareTo(ObjectType.xfsj_provider_apply) == 0) {
			return new IOpenAuditTypeReturn() {

				@Override
				public void passAudit(Long uid, String objectId, Map<String, String> parameter) throws Exception {
					logger.info("xfsj_provider_apply passAudit  uid:{},   objectId:{},   parameter:{}", uid, objectId,
							parameter);
					OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(uid);

					// 增加服务的id
					auditService(info.getId());

					Map<String, Object> model = new HashMap<>();
					model.put("title", info.getTitle());
					javaMailComponent.sendEmail(EmailType.merchant_info_pass, info.getEmail(), model);

				}

				@Override
				public void unpassAudit(Long uid, String objectId, String reason) throws Exception {
					logger.info("xfsj_provider_apply unpassAudit  uid:{},   objectId:{},   reason:{}", uid, objectId,
							reason);

					OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(uid);
					info.setUpdateTime(new Date());
					info.setStatusContent(reason);
					info.setId(uid);
					openMerchantInfoMapper.updateByPrimaryKeySelective(info);

					//修改服务的状态
					CommunityServiceTempExample example = new CommunityServiceTempExample();
					example.createCriteria().andMerchantIdEqualTo(uid);
					List<CommunityServiceTemp> list = communityServiceTempMapper.selectByExample(example);
					validator(list.isEmpty(), "审核服务不存在");

					CommunityServiceTemp sert = list.get(0);
					sert.setUpdateTime(new Date());
					sert.setAuditTime(new Date());
					sert.setAuditComment(reason);
					sert.setStatus(Constant.OpenAdmin.CommunityServiceGroundStatus.UNGROUNDING);
					sert.setAuditStatus(Constant.OpenAdmin.CommunityServiceAuditStatus.AUDIT_NOTPASS);
					sert.setGroundAuditStatus(Constant.OpenAdmin.CommunityServiceGroundAuditStatus.AUDIT_NOTPASS);

					CommunityService ser = new CommunityService();
					ser.setId(sert.getId());
					ser.setUpdateTime(new Date());
					ser.setAuditTime(new Date());
					ser.setAuditComment(reason);
					ser.setStatus(Constant.OpenAdmin.CommunityServiceGroundStatus.UNGROUNDING);
					ser.setAuditStatus(Constant.OpenAdmin.CommunityServiceAuditStatus.AUDIT_NOTPASS);
					ser.setGroundAuditStatus(Constant.OpenAdmin.CommunityServiceGroundAuditStatus.AUDIT_NOTPASS);

					communityServiceTempMapper.updateByPrimaryKeySelective(sert);
					communityServiceMapper.updateByPrimaryKeySelective(ser);

					Map<String, Object> model = new HashMap<>();
					model.put("title", info.getTitle());
					model.put("reason", reason);
					javaMailComponent.sendEmail(EmailType.merchant_info_unpass, info.getEmail(), model);
				}
			};
		}
		return null;
	}

	private void auditService(Long merchantId) {
		CommunityServiceTempExample example = new CommunityServiceTempExample();
		example.createCriteria().andMerchantIdEqualTo(merchantId);
		List<CommunityServiceTemp> list = communityServiceTempMapper.selectByExample(example);
		for (CommunityServiceTemp temp : list) {
			auditCommunityServiceTemp(temp, merchantId);
		}

	}

	@Value("${open.storeapi.url}")
	private String openStoreapiUrl;

	private void auditCommunityServiceTemp(CommunityServiceTemp temp, Long merchantId) {
		OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(merchantId);

		Integer serviceId = temp.getId();
		String title = temp.getTitle();

		CommunityServiceTemp sert = new CommunityServiceTemp();
		sert.setId(serviceId);
		sert.setUpdateTime(new Date());
		sert.setAuditTime(new Date());
		sert.setAuditComment("");
		sert.setStatus(Constant.OpenAdmin.CommunityServiceGroundStatus.GROUNDING);
		sert.setAuditStatus(Constant.OpenAdmin.CommunityServiceAuditStatus.AUDIT_PASS_PAID);
		sert.setGroundAuditStatus(Constant.OpenAdmin.CommunityServiceGroundAuditStatus.AUDIT_PASS);
		CommunityService ser = new CommunityService();
		ser.setId(serviceId);
		ser.setUpdateTime(new Date());
		ser.setAuditTime(new Date());
		ser.setAuditComment("");
		ser.setStatus(Constant.OpenAdmin.CommunityServiceGroundStatus.GROUNDING);
		ser.setAuditStatus(Constant.OpenAdmin.CommunityServiceAuditStatus.AUDIT_PASS_PAID);
		ser.setGroundAuditStatus(Constant.OpenAdmin.CommunityServiceGroundAuditStatus.AUDIT_PASS);

		if (temp.getAppId() == null || temp.getAppId() <= 0) {
			// 访问地址
			//  http://store.zizai.test.thinkinpower.net/index.html#/home?isNew=1&serviceId=413&communityId=4
			String link = openStoreapiUrl + "index.html#/home?isNew=1&serviceId=" + serviceId;
			String mchid = info.getMchId();
			CreateAppResponseModel medel = createAppResponseModel(title, temp.getDescription(), link);
			validator(medel == null, "创建平台应用失败");
			sert.setAppId(medel.getAppId());
			sert.setAppSecret(medel.getAppSecret());
			sert.setLink(link);
			ser.setAppId(medel.getAppId());
			ser.setAppSecret(medel.getAppSecret());
			ser.setLink(link);

		}

		// 创建结算
		// 修改到审批通过创建
		Long mid = temp.getMerchantId();
		validator(mid == null || mid <= 0, "请先创建商家ID");
		logger.info("serviceId:{},mid:{}", serviceId, mid);
		String notifyUrl = openStoreapiUrl + "api/openstore/notify_url/" + serviceId;
		validator(StringUtils.isBlank(info.getMchId()), "没有该商家结算账号");
		String mchid = info.getMchId();
		sert.setAccountReceivableProject("模板服务");
		sert.setNotifyUrl(notifyUrl);
		ser.setAccountReceivableProject("模板服务");
		ser.setNotifyUrl(notifyUrl);

		//判断appId是否为空
		if(StringUtils.isBlank(ser.getAccountId())) {
			FuPayAccountModel accountResponseModel = platformGlobalComponent.createAccount(mchid, "自在服务_" + title + "_" + serviceId);
			validator(accountResponseModel == null, "创建服务结算账号出错" + mid);
			String acc = accountResponseModel.getAccountId();
			sert.setAccountId(acc);
			ser.setAccountId(acc);
		}
		communityServiceTempMapper.updateByPrimaryKeySelective(sert);
		communityServiceMapper.updateByPrimaryKeySelective(ser);

	}

	public CreateAppResponseModel createAppResponseModel(String title, String description, String link) {
		CreateAppResponseModel createAppResponseModel = platformGlobalComponent.createApp("自在-开放-" + title, 3, "1002",
				"0101", description, 120 * 60, 4, 1, null, null, "", "", 1, 1);
		return createAppResponseModel;
	}

//	public String getBuildTitle(OpenMerchantInfoTemp info) {
//		return String.format("自_%s_%s", info.getTitle(), info.getId());
//	}

	public String getBuildTitle(OpenMerchantInfo info) {
		return String.format("自_%s_%s", info.getTitle(), info.getId());
	}
}
