package com.rfchina.community.open.bridge.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.api.response.model.pay.FuPayAddMchAccountResponseModel;
import com.rfchina.api.response.model.pay.FuPayAddMchResponseModel;
import com.rfchina.api.response.model.pay.FuPayGetMchAccountListResponseModel;
import com.rfchina.api.response.model.pay.base.FuPayMchAccountModel;
import com.rfchina.community.base.Constant;
import com.rfchina.community.component.JavaMailComponent;
import com.rfchina.community.component.JavaMailComponent.EmailType;
import com.rfchina.community.component.OpenAuditInfoComponent.ObjectType;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.component.SysMsgInfoComponent;
import com.rfchina.community.open.bridge.entity.KeyValueDomain;
import com.rfchina.community.persistence.mapper.CommunityMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.CommunityServiceExample;
import com.rfchina.community.persistence.model.OpenMerchantInfo;
import com.rfchina.community.persistence.model.OpenMerchantInfoExample;

/**
 */
@Service
public class OpenMerchantInfoService extends BaseService implements IOpenAuditType {

	@Autowired
	private CommunityMapper communityMapper;

	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;
 
	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;
 
	@Autowired
	private SysMsgInfoComponent sysMsgInfoComponent;

	@Autowired
	private JavaMailComponent javaMailComponent;
	
	@Autowired
	private CommunityServiceMapper communityServiceMapper;

	private static transient Logger logger = LoggerFactory.getLogger(OpenMerchantInfoService.class);

	@Override
	public IOpenAuditTypeReturn audit(ObjectType type) {
		if (type.compareTo(ObjectType.service_provider_approval) == 0) {
			return new IOpenAuditTypeReturn() {

				@Override
				public void passAudit(Long uid, String objectId, Map<String, String> parameter) throws Exception {
					/*
					Double fee = MapUtils.getDouble(parameter, "fee");
					validator(fee == null || fee >= 100 || fee < 0, "平台手续费只能在0-100之间" + fee);
					OpenMerchantInfoTemp t = openMerchantInfoTempMapper.selectByPrimaryKey(uid);
					
					OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(uid);
					// System.out.println(ObjectType.service_provider_approval +
					// "-------passAudit-----Long uid, String objectId-" + uid +
					// "
					// " + objectId
					// + "json:" + JSON.toJSONString(parameter));
					
					//查询服务佣金最高的比例
					CommunityServiceExample example = new CommunityServiceExample();
					example.setOrderByClause("commission_rate desc");
					example.createCriteria().andMerchantIdEqualTo(uid);
					List<CommunityService> servicelist = communityServiceMapper.selectByExample(example);
					if(servicelist != null && servicelist.size() > 0){
						if(servicelist.get(0).getCommissionRate().doubleValue()+fee >= 100){
							error("平台手续费比例加服务佣金比例不能大于等于100%");
						}
					}
					

					OpenMerchantInfoTemp r11 = new OpenMerchantInfoTemp();
					r11.setUpdateTime(new Date());
					r11.setPlatformFee(fee);
					r11.setStatus(Constant.merchantInfo.status.pass);
					r11.setStatusContent("");
					r11.setId(uid);
					openMerchantInfoTempMapper.updateByPrimaryKeySelective(r11);
					OpenMerchantInfo r = new OpenMerchantInfo();
					r.setUpdateTime(new Date());
					r.setPlatformFee(fee);
					r.setStatus(Constant.merchantInfo.status.normal);
					///
					r.setBankAccount(t.getBankAccount());
					r.setBankAccountName(t.getBankAccountName());
					r.setBankTitle(t.getBankTitle());
					r.setTitle(t.getTitle());
					r.setStatusContent("");
					///
					r.setIntroduction(t.getIntroduction());
					///
					if (t.getType() == 1) {// 公司
						r.setBusinessLicense(t.getBusinessLicense());
						r.setBusinessScope(t.getBusinessScope());
						r.setIsOtherLicense(t.getIsOtherLicense());
						r.setOtherLicense(t.getOtherLicense());
						r.setRegistrationNumber(t.getRegistrationNumber());
						r.setTitleSimple(t.getTitleSimple());
					} else if (t.getType() == 2) {// 个人
						r.setIdNumber(t.getIdNumber());
						r.setIdObverse(t.getIdObverse());
						r.setIdPositive(t.getIdPositive());
					}
					r.setId(uid);
					openMerchantInfoMapper.updateByPrimaryKeySelective(r);
					// 申请支付中心的账号
					// 没有商户,就去创建
					String mchId = info.getMchId();
					if (StringUtils.isBlank(mchId)) {
						String contact = t.getContactPerson();
						if (t.getType() == 2) {
							contact = t.getTitle();
						}
						FuPayAddMchResponseModel merch = platformGlobalComponent.addMchRequest(contact, getBuildTitle(t),
								t.getContactPhone());
						validator(merch == null, "创建支付中心的商家出错!");
						// 商家审批
						mchId = merch.getId();
						platformGlobalComponent.editMchRequest(mchId, contact, getBuildTitle(t), t.getContactPhone(), 2);
						OpenMerchantInfo r333 = new OpenMerchantInfo();
						r333.setId(uid);
						r333.setMchId(mchId);
						r333.setUpdateTime(new Date());
						openMerchantInfoMapper.updateByPrimaryKeySelective(r333);
						OpenMerchantInfoTemp r444 = new OpenMerchantInfoTemp();
						r444.setId(uid);
						r444.setMchId(mchId);
						r444.setUpdateTime(new Date());
						openMerchantInfoTempMapper.updateByPrimaryKeySelective(r444);
					}
					if (StringUtils.isBlank(mchId)) {
						error("无商家数据");
					}
					
					//审核的银行账号不为空，创建商家账号1启用，2禁用
					if ((info.getAccountId() == null || info.getAccountId() <= 0) && StringUtils.isNoneBlank(t.getBankAccount())) {
						FuPayGetMchAccountListResponseModel list = platformGlobalComponent.uGetMchAccountListRequest(mchId,
								"1");
						if (list.getTotal() > 0) {
							for (FuPayMchAccountModel acc : list.getList()) {
								platformGlobalComponent.editMchAccountRequest(mchId, acc.getId(), 2);
							}

						}
						FuPayAddMchAccountResponseModel account = platformGlobalComponent.addMchAccountRequest(mchId,
								t.getBankAccountName(), t.getBankTitle(), t.getBankAccount());
						validator(account == null, "创建支付中心的商家账号出错!");
//						platformGlobalComponent.editMchAccountRequest(mchId, account.getId(), 1);
						OpenMerchantInfo r333 = new OpenMerchantInfo();
						r333.setId(uid);
						r333.setAccountId(account.getId());
						r333.setUpdateTime(new Date());
						openMerchantInfoMapper.updateByPrimaryKeySelective(r333);
						OpenMerchantInfoTemp r444 = new OpenMerchantInfoTemp();
						r444.setId(uid);
						r444.setAccountId(account.getId());
						r444.setUpdateTime(new Date());
						openMerchantInfoTempMapper.updateByPrimaryKeySelective(r444);
					}
					// 更新商户

					// String mchId = info.getMchId();
					String contact = t.getContactPerson();
					if (t.getType() == 2) {
						contact = t.getTitle();
					}
					String contact1 = info.getContactPerson();
					if (t.getType() == 2) {
						contact1 = info.getTitle();
					}
					if (!StringUtils.equals(contact, contact1)
							|| !StringUtils.equals(getBuildTitle(t), getBuildTitle(info))
							|| !StringUtils.equals(t.getContactPhone(), info.getContactPhone())) {
						boolean flag = platformGlobalComponent.editMchRequest(mchId, contact, getBuildTitle(t),
								t.getContactPhone(), 2);
						validator(!flag, "更新支付中心的商家信息出错!");
					}
					// ------更新账号
					if (null != info.getAccountId() && info.getAccountId() > 0) {
						if (!StringUtils.equals(t.getBankAccountName(), info.getBankAccountName())
								|| !StringUtils.equals(t.getBankTitle(), info.getBankTitle())
								|| !StringUtils.equals(t.getBankAccount(), info.getBankAccount())) {

							FuPayGetMchAccountListResponseModel list = platformGlobalComponent.uGetMchAccountListRequest(mchId,
									"1");
							if (list.getTotal() > 0) {
								for (FuPayMchAccountModel acc : list.getList()) {
									platformGlobalComponent.editMchAccountRequest(mchId, acc.getId(), 2);
								}

							}

							// boolean flag =
							// platformGlobalComponent.editMchAccountRequest(info.getMchId(),
							// info.getAccountId(), 3);
							// validator(!flag, "禁用支付中心的商家过去的结算账号信息出错!");
							FuPayAddMchAccountResponseModel account = platformGlobalComponent.addMchAccountRequest(mchId,
									t.getBankAccountName(), t.getBankTitle(), t.getBankAccount());
							validator(account == null, "创建新的支付中心的商家账号出错!");
							OpenMerchantInfo r333 = new OpenMerchantInfo();
							r333.setId(uid);
							r333.setAccountId(account.getId());
							r333.setUpdateTime(new Date());
							openMerchantInfoMapper.updateByPrimaryKeySelective(r333);
							OpenMerchantInfoTemp r444 = new OpenMerchantInfoTemp();
							r444.setId(uid);
							r444.setAccountId(account.getId());
							r444.setUpdateTime(new Date());
							openMerchantInfoTempMapper.updateByPrimaryKeySelective(r444);
						}
					}

					// sms
					sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.open_service_provider_pass, uid + "", 0,
							uid);
					Map<String, Object> model = new HashMap<>();
					model.put("title", t.getTitle());
					javaMailComponent.sendEmail(EmailType.merchant_info_pass, info.getEmail(), model);
					
//					String content=String.format("欢迎你成功加入自在社区自在服务平台，快去完善自己的资料发布服务应用吧。", args);
//					platformGlobalComponent.sendSms(info.getContactPhone(), content);
					*/
				}

				@Override
				public void unpassAudit(Long uid, String objectId, String reason) throws Exception {
					/*OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(uid);
					OpenMerchantInfoTemp record = new OpenMerchantInfoTemp();
					record.setUpdateTime(new Date());
					record.setStatus(Constant.merchantInfo.status.unpass);
					record.setStatusContent(reason);
					record.setId(uid);
					openMerchantInfoTempMapper.updateByPrimaryKeySelective(record);
					// System.out.println(
					// ObjectType.service_provider_approval +
					// "------unpassAudit-----Long uid, String objectId--" + uid
					// + " " + objectId);
					// sms
					sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.open_service_provider_unpass, uid + "", 0,
							uid);
					Map<String, Object> model = new HashMap<>();
					model.put("title", info.getTitle());
					model.put("reason", reason);
					javaMailComponent.sendEmail(EmailType.merchant_info_unpass, info.getEmail(), model);*/
				}
			};
		}
		return null;
	}

//	public String getBuildTitle(OpenMerchantInfoTemp info) {
//		return String.format("自_%s_%s", info.getTitle(), info.getId());
//	}

	public String getBuildTitle(OpenMerchantInfo info) {
		return String.format("自_%s_%s", info.getTitle(), info.getId());
	}
	
	public List<KeyValueDomain> searchMerchantInfoList(String keyword){
		String likeKeyWord = "%" + keyword + "%";
		OpenMerchantInfoExample example = new OpenMerchantInfoExample();
		example.createCriteria().andTitleLike(likeKeyWord).andStatusEqualTo(1);
		List<OpenMerchantInfo> list = openMerchantInfoMapper.selectByExample(example);
		List<KeyValueDomain> returnList =  new ArrayList<>();
		for(OpenMerchantInfo info : list) {
			KeyValueDomain domain = new KeyValueDomain();
			domain.setKey(info.getId());
			domain.setValue(info.getTitle());
			returnList.add(domain);
		}
		return returnList;
	}
}
