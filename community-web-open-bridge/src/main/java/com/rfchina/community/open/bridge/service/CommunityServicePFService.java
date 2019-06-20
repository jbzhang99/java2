package com.rfchina.community.open.bridge.service;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rfchina.community.persistence.model.*;
import com.rfchina.community.service.openser.OpenServicePayService;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.Order;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.rfchina.api.response.model.pay.FuPayGetAccountListResponseModel;
import com.rfchina.api.response.model.pay.base.FuPayAccountModel;
import com.rfchina.community.base.Constant;
import com.rfchina.community.component.JavaMailComponent;
import com.rfchina.community.component.JavaMailComponent.EmailType;
import com.rfchina.community.component.OpenAuditInfoComponent;
import com.rfchina.community.component.OpenAuditInfoComponent.ObjectType;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.component.SysMsgInfoComponent;
import com.rfchina.community.open.bridge.entity.ExtCommunityService;
import com.rfchina.community.open.bridge.mapper.ext.ExtCommunityServiceMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceCategoryMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceRelaMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceRelaTempMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceTempMapper;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.mapper.OpenServiceDetailMapper;
import com.rfchina.community.service.openser.OpenCautionInfoSerService;

@Service
public class CommunityServicePFService extends BaseService implements IOpenAuditType {

	@Autowired
	private CommunityServiceTempMapper communityServiceTempMapper;

	@Autowired
	private CommunityServiceMapper communityServiceMapper;

	@Autowired
	private CommunityServiceRelaMapper communityServiceRelaMapper;

	@Autowired
	private OpenCautionInfoSerService openCautionInfoSerService;
	@Autowired
	private OpenServicePayService openServicePayService;
	@Autowired
	private CommunityServiceRelaTempMapper communityServiceRelaTempMapper;

	@Autowired
	private CommunityServiceCategoryMapper communityServiceCategoryMapper;

	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;

//	@Autowired
//	private OpenMerchantInfoTempMapper openMerchantInfoTempMapper;

	@Autowired
	private ExtCommunityServiceMapper extCommunityServiceMapper;
	@Autowired
	private OpenServiceDetailMapper openServiceDetailMapper;
	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;

	// @Autowired
	// private ExtServiceAreaMapper extServiceAreaMapper;

	@Autowired
	private OpenAuditInfoComponent openAuditInfoComponent;

	// @Autowired
	// private PlatformService platformService;

	// @Autowired
	// private OpenOrderService openOrderService;

	@Autowired
	private OpenServiceInterfaceService openServiceInterfaceService;

	@Autowired
	private SysMsgInfoComponent sysMsgInfoComponent;

	@Autowired
	private JavaMailComponent javaMailComponent;
	@Autowired
	private OpenServiceExtendService openServiceExtendService;

	private static transient Logger logger = LoggerFactory.getLogger(CommunityServicePFService.class);

	public long getCommunityServiceTempCount(int categoryId) {
		CommunityServiceTempExample example = new CommunityServiceTempExample();
		example.createCriteria().andCategoryIdEqualTo(categoryId);
		return communityServiceTempMapper.countByExample(example);
	}

	public PageList<ExtCommunityService> getCommunityServiceList(int id, String title, int merchantId,
			String merchantName, int categoryId, Date startCreateTime, Date endCreateTime, int index, int size,
			int cautionMoneyStatus, int groundAuditStatus, String verifyRole, int type, Integer quickPay) {
		Map<String, Object> param = new HashMap<>();
		if (id > 0) {
			param.put("id", id);
		}
		if (StringUtils.isNotBlank(title)) {
			param.put("title", "%" + title + "%");
		}
		if (merchantId > 0) {
			param.put("merchantId", merchantId);
		}
		if (categoryId > 0) {
			param.put("categoryId", categoryId);
		}
		if (type > 0) {
			param.put("type", type);
		}
		if (cautionMoneyStatus > 0) {
			param.put("cautionMoneyStatus", cautionMoneyStatus);
		}
		if (groundAuditStatus > 0) {
			param.put("groundAuditStatus", groundAuditStatus);
		}
		if (startCreateTime != null) {
			param.put("startCreateTime", startCreateTime);
		}
		if (endCreateTime != null) {
			param.put("endCreateTime", endCreateTime);
		}
		if (StringUtils.isNotBlank(merchantName)) {
			param.put("merchantName", "%" + merchantName + "%");
		}
		if (StringUtils.isNotBlank(verifyRole)) {
			param.put("verifyRole", verifyRole);
		}
		if (quickPay != null) {
			param.put("quickPay", quickPay);
		}
		PageBounds pageBounds = new PageBounds(index, size, Order.formString("id.desc"));
		PageList<ExtCommunityService> pager = extCommunityServiceMapper.getCommunityService(param, pageBounds);
	
		return pager;
	}

	public void updateCommunityServiceTemp(CommunityServiceTemp communityServiceTemp) {
		communityServiceTempMapper.updateByPrimaryKeySelective(communityServiceTemp);
	}

	public void updateCommunityService(CommunityService communityService) {
		communityServiceMapper.updateByPrimaryKeySelective(communityService);
	}

	public CommunityServiceTemp getCommunityServiceTempByPrimaryKey(int serviceId) {
		return communityServiceTempMapper.selectByPrimaryKey(serviceId);
	}

	public CommunityService getCommunityServiceByPrimaryKey(int serviceId) {
		return communityServiceMapper.selectByPrimaryKey(serviceId);
	}

	// public ExtCommunityService getCommunityServiceInfo(int serviceId) {
	// List<ExtCommunityService> list = getCommunityServiceList(serviceId, null, 0,
	// null, 0, null, null, 1, 10);
	// if (list != null && list.size() > 0) {
	// return list.get(0);
	// }
	// return null;
	// }

	// public List<ExtServiceArea> getServiceArea(int serviceId) {
	// return extServiceAreaMapper.getServiceArea(serviceId);
	// }
	//
	// public List<ExtServiceArea> getServiceAreaTemp(int serviceId) {
	// return extServiceAreaMapper.getServiceAreaTemp(serviceId);
	// }

	public List<CommunityServiceRela> getCommunityServiceRela(int serviceId) {
		CommunityServiceRelaExample example = new CommunityServiceRelaExample();
		example.createCriteria().andServiceIdEqualTo(serviceId);
		return communityServiceRelaMapper.selectByExample(example);
	}

	public List<CommunityServiceRelaTemp> getCommunityServiceTempRela(int serviceId) {
		CommunityServiceRelaTempExample example = new CommunityServiceRelaTempExample();
		example.createCriteria().andServiceIdEqualTo(serviceId);
		return communityServiceRelaTempMapper.selectByExample(example);
	}

	public CommunityServiceCategory getCommunityServiceCategory(int catid) {
		return communityServiceCategoryMapper.selectByPrimaryKey(catid);
	}

	/**
	 * @author:fukangwen @Description: 根据商家获取店铺信息 @return CommunityService @throws
	 */
	public CommunityService getCommunityServiceByMerchantInfoId(Long merchantInfoId) {
		CommunityServiceExample example = new CommunityServiceExample();
		example.createCriteria().andMerchantIdEqualTo(merchantInfoId);
		List<CommunityService> communityServiceList = communityServiceMapper.selectByExample(example);
		if (communityServiceList.isEmpty())
			error("店铺信息有误");
		return communityServiceList.get(0);
	}

	public OpenMerchantInfo getOpenMerchantInfo(Long mid) {
		return openMerchantInfoMapper.selectByPrimaryKey(mid);
	}

//	public OpenMerchantInfoTemp getOpenMerchantInfoTemp(Long mid) {
//		return openMerchantInfoTempMapper.selectByPrimaryKey(mid);
//	}

	@Override
	public IOpenAuditTypeReturn audit(ObjectType type) {
		// 服务删除审核
		if (type.compareTo(ObjectType.service_delete_apply) == 0) {
			// 进行删除操作
			return new IOpenAuditTypeReturn() {

				@Override
				public void unpassAudit(Long uid, String objectId, String reason) throws Exception {
					//
					CommunityServiceTemp communityServiceTemp = getCommunityServiceTempByPrimaryKey(
							Integer.parseInt(objectId));
					communityServiceTemp.setAuditStatus(Constant.OpenAdmin.CommunityServiceAuditStatus.DELETE_NOTPASS);
					communityServiceTemp.setAuditComment(reason);
					updateCommunityServiceTemp(communityServiceTemp);
					// sms
					List<String> parameter1 = new ArrayList<>();
					// parameter.add(merchant.getTitle());
					parameter1.add(communityServiceTemp.getTitle());
					sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.open_service_delete_apply_unpass, objectId,
							0, uid, parameter1);
					// email send
					OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(uid);
					sendEmail(info.getEmail(),info.getTitle(),communityServiceTemp.getTitle(),reason,EmailType.open_service_delete_apply_unpass);

				}

				@Override
				public void passAudit(Long uid, String objectId, Map<String, String> parameter) throws Exception {
					// 审批通过，进行删除
					CommunityService communityService = getCommunityServiceByPrimaryKey(Integer.parseInt(objectId));
					communityService.setStatus(Constant.OpenAdmin.CommunityServiceGroundStatus.DELETE);
					communityService.setAuditStatus(Constant.OpenAdmin.CommunityServiceAuditStatus.DELETE_PASS);
					updateCommunityService(communityService);
					CommunityServiceTemp communityServiceTemp = getCommunityServiceTempByPrimaryKey(
							Integer.parseInt(objectId));
					communityServiceTemp.setStatus(Constant.OpenAdmin.CommunityServiceGroundStatus.DELETE);
					communityServiceTemp.setAuditStatus(Constant.OpenAdmin.CommunityServiceAuditStatus.DELETE_PASS);
					updateCommunityServiceTemp(communityServiceTemp);

					if (communityService.getReceivableCautionMoney() == null
							|| communityService.getReceivableCautionMoney().compareTo(new BigDecimal("0")) == 0) {
						logger.debug("保证金为0，不需要退保证金申请");
					} else {
						openAuditInfoComponent.add(ObjectType.service_refund_caution, communityService.getMerchantId(),
								"" + communityService.getId(), communityService.getId());
						// 退款保证金不走线上,走线下
						logger.debug("发起退保证金申请");

					}
					// sms
					List<String> parameter1 = new ArrayList<>();
					// parameter.add(merchant.getTitle());
					parameter1.add(communityServiceTemp.getTitle());
					sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.open_service_delete_apply_pass, objectId, 0,
							uid, parameter1);
					// email send
					OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(uid);
					sendEmail(info.getEmail(),info.getTitle(),communityServiceTemp.getTitle(),EmailType.open_service_delete_apply_pass);
				}
			};
		}
		// 退保证金审核
		if (type.compareTo(ObjectType.service_refund_caution) == 0) {
			return new IOpenAuditTypeReturn() {

				@Override
				public void unpassAudit(Long uid, String objectId, String reason) throws Exception {
					//
					CommunityServiceTemp communityServiceTemp = getCommunityServiceTempByPrimaryKey(
							Integer.parseInt(objectId));
					// sms
					List<String> parameter1 = new ArrayList<>();
					// parameter.add(merchant.getTitle());
					parameter1.add(communityServiceTemp.getTitle());
					sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.open_service_refund_caution_unpass, objectId,
							0, uid, parameter1);
				}

				@Override
				public void passAudit(Long uid, String objectId, Map<String, String> parameter) throws Exception {
					// 进行退保证金操作
					CommunityService communityService = getCommunityServiceByPrimaryKey(Integer.parseInt(objectId));

					// 许可确认，保证金的退款都走线下流程
					// communityService.setCautionMoneyStatus(Constant.OpenAdmin.CautionMoneyStatus.REFUND);
					// updateCommunityService(communityService);
					// if (Constant.OpenAdmin.CautionMoneyType.ONLINE ==
					// communityService.getCautionMoneyType()) {
					// // 线上缴纳，向支付中心发起退款操作
					// logger.debug("向支付中心发起原路退保证金申请");
					// OpenOrder openOrder =
					// openOrderService.getOpenOrder(communityService.getCautionBillId());
					// if (openOrder != null) {
					// RefundItem refundItem = new RefundItem();
					// refundItem.setBillId(openOrder.getBillId());
					// refundItem.setOutTradeNo(openOrder.getCommunityTradeNo());
					// refundItem.setSubject(openOrder.getSubject());
					// refundItem.setBody(openOrder.getBody());
					// refundItem.setRefundAmount(openOrder.getTotalAmount().multiply(new
					// BigDecimal("100")).longValue());
					// refundItem.setSameWay(1);
					// List<RefundItem> refundItemList = new ArrayList<>();
					// refundItemList.add(refundItem);
					// platformService.refundApply(communityService.getTitle() +
					// "，自在服务退还保证金", openOrder.getAccountId(), null,
					// refundItemList,
					// "服务删除，退还保证金");
					// } else {
					// logger.debug("根据订单号：" +
					// communityService.getCautionBillId() + "查询不到订单记录");
					// }
					// }
					// if (Constant.OpenAdmin.CautionMoneyType.OFFLINE ==
					// communityService.getCautionMoneyType()) {
					// logger.debug("线下缴纳保证金，进行线下退款");
					// }
					// sms
					List<String> parameter1 = new ArrayList<>();
					// parameter.add(merchant.getTitle());
					parameter1.add(communityService.getTitle());
					sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.open_service_refund_caution_pass, objectId,
							0, uid, parameter1);
				}
			};
		}
		// 支付申请审核
		if (type.compareTo(ObjectType.service_apply_pay) == 0) {
			return new IOpenAuditTypeReturn() {

				@Override
				public void unpassAudit(Long uid, String objectId, String reason) throws Exception {
					String ifId = null;
					for (String string : objectId.split(":")) {
						if (string.startsWith("i")) {
							ifId = string.substring(1);
						}
					}
					//
					OpenServiceInterface openServiceInterface = openServiceInterfaceService
							.getServiceInterface(Integer.parseInt(ifId));
					if (openServiceInterface == null) {
						error("支付申请信息不存在");
					}
					openServiceInterface.setAuditComment(reason);
					openServiceInterface.setAuditStatus(Constant.OpenAdmin.ServiceInterfaceAuditStatus.AUDIT_NOTPASS);
					openServiceInterfaceService.updateServiceInterface(openServiceInterface);
					CommunityServiceTemp communityServiceTemp = getCommunityServiceTempByPrimaryKey(
							openServiceInterface.getServiceId());
					// sms
					List<String> parameter1 = new ArrayList<>();
					// parameter.add(merchant.getTitle());
					parameter1.add(communityServiceTemp.getTitle());
					sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.open_service_apply_pay_unpass, objectId, 0,
							uid, parameter1);

					// email send
					OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(uid);
					sendEmail(info.getEmail(),info.getTitle(),communityServiceTemp.getTitle(),reason,EmailType.open_service_apply_pay_unpass);

				}

				@Override
				public void passAudit(Long uid, String objectId, Map<String, String> parameter) throws Exception {
					String ifId = null;
					for (String string : objectId.split(":")) {
						if (string.startsWith("i")) {
							ifId = string.substring(1);
						}
					}

					// 支付接口申请通过后，向支付中心创建收款账号
					OpenServiceInterface openServiceInterface = openServiceInterfaceService
							.getServiceInterface(Integer.parseInt(ifId));
					if (openServiceInterface == null) {
						error("支付申请信息不存在");
					}
					openServiceInterface.setAuditStatus(Constant.OpenAdmin.ServiceInterfaceAuditStatus.AUDIT_PASS);
					openServiceInterface.setAuditComment("通过");
					openServiceInterface.setStatus(Constant.OpenAdmin.ServiceInterfaceStatus.ENABLE);

					CommunityServiceTemp communityServiceTemp = getCommunityServiceTempByPrimaryKey(
							openServiceInterface.getServiceId());
//					OpenMerchantInfoTemp openMerchantInfoTemp = openMerchantInfoTempMapper
//							.selectByPrimaryKey(communityServiceTemp.getMerchantId());
					OpenMerchantInfo openMerchantInfo= openMerchantInfoMapper
							.selectByPrimaryKey(communityServiceTemp.getMerchantId());

//					FuPayGetAccountListResponseModel list = platformGlobalComponent.fuPayMGetAccountListRequest(null,
//							openMerchantInfo.getMchId(), "自在服务_" + communityServiceTemp.getTitle(), true, 50, 0);
//					logger.info(JSON.toJSONString(list));

//					FuPayAccountModel accountResponseModel = platformGlobalComponent
//							.createAccount(openMerchantInfo.getMchId(), "自在服务_" + communityServiceTemp.getTitle() + "_" + openServiceInterface.getServiceId());

					// GetServiceApplyProgressResponseModel data =
					// platformService.getServiceApplyProgressRequest(
					// communityServiceTemp.getAppId(),
					// openServiceInterface.getInterfaceId());
					// if (data == null) {
					// // //审核状态, 1:未开通, 2: 申请审核中, 3: 已开通, 4: 不通过
					// if (data.getStatus() == 2) {
					// // 向平台开通接口
					// platformService.auditService(communityServiceTemp.getAppId(),
					// openServiceInterface.getInterfaceId(), 3, "通过");
					// }
					// }
					// 等外面的接口调通了在跑自己的
					openServiceInterfaceService.updateServiceInterface(openServiceInterface);
					CommunityService communityService = getCommunityServiceByPrimaryKey(
							openServiceInterface.getServiceId());
//					if (accountResponseModel != null) {
//						communityServiceTemp.setAccountId(accountResponseModel.getAccountId());
//						communityService.setAccountId(accountResponseModel.getAccountId());
						updateCommunityService(communityService);
						updateCommunityServiceTemp(communityServiceTemp);
//					}
					// sms
					List<String> parameter1 = new ArrayList<>();
					// parameter.add(merchant.getTitle());
					parameter1.add(communityServiceTemp.getTitle());
					sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.open_service_apply_pay_pass, objectId, 0,
							uid, parameter1);

					// email send
					OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(uid);
					sendEmail(info.getEmail(),info.getTitle(),communityServiceTemp.getTitle(),EmailType.open_service_apply_pay_pass);

				}
			};
		}
		if (type.compareTo(ObjectType.submit_service_audit) == 0) {
			// 服务上架审核
			return new IOpenAuditTypeReturn() {

				@Override
				public void unpassAudit(Long uid, String objectId, String reason) throws Exception {
					// 服务上架不通过
					CommunityServiceTemp communityServiceTemp = getCommunityServiceTempByPrimaryKey(
							Integer.parseInt(objectId));
					communityServiceTemp.setAuditComment(reason);
					communityServiceTemp
							.setGroundAuditStatus(Constant.OpenAdmin.CommunityServiceGroundAuditStatus.AUDIT_NOTPASS);
					updateCommunityServiceTemp(communityServiceTemp);

					CommunityService communityService = getCommunityServiceByPrimaryKey(Integer.parseInt(objectId));
					communityService.setAuditComment(reason);
					updateCommunityService(communityService);
					// sms
					List<String> parameter1 = new ArrayList<>();
					// parameter.add(merchant.getTitle());
					parameter1.add(communityServiceTemp.getTitle());
					sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.open_submit_service_audit_unpass, objectId,
							0, uid, parameter1);
					// email send
					OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(uid);
					sendEmail(info.getEmail(),info.getTitle(),communityServiceTemp.getTitle(),reason,EmailType.open_submit_service_audit_unpass);

				}

				@Override
				public void passAudit(Long uid, String objectId, Map<String, String> parameter) throws Exception {
					Double recommendLevel = MapUtils.getDouble(parameter, "recommendLevel");
					validator(recommendLevel == null || recommendLevel < 0 || recommendLevel > 5,
							"推荐指数值只能在0到5之间" + recommendLevel);
					// 服务上架审核通过，上架服务
					CommunityServiceTemp communityServiceTemp = getCommunityServiceTempByPrimaryKey(
							Integer.parseInt(objectId));
					communityServiceTemp
							.setGroundAuditStatus(Constant.OpenAdmin.CommunityServiceGroundAuditStatus.AUDIT_PASS);
					communityServiceTemp.setAuditTime(new Date());
					// 设置推荐指数
					communityServiceTemp.setRecommendLevel(recommendLevel);

					//判断appId是否为空
					String title = communityServiceTemp.getTitle();
					if(StringUtils.isBlank(communityServiceTemp.getAccountId())) {
						OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(communityServiceTemp.getMerchantId());
						validator(info == null, "商家不存在");
						FuPayAccountModel accountResponseModel = platformGlobalComponent.createAccount(info.getMchId(), "自在服务_" + title + "_" + communityServiceTemp.getId());
						validator(accountResponseModel == null, "创建服务结算账号出错" + info.getId());
						String acc = accountResponseModel.getAccountId();
						communityServiceTemp.setAccountId(acc);
						CommunityService communityService = new CommunityService();
						communityService.setId(communityServiceTemp.getId());
						communityService.setAccountId(acc);
						updateCommunityService(communityService);
					}

					if (Constant.OpenAdmin.GroundMode.AUTO == communityServiceTemp.getGroundMode()) {
						communityServiceTemp.setStatus(Constant.OpenAdmin.CommunityServiceGroundStatus.GROUNDING);
						communityServiceTemp.setGroundTime(new Date());
					}
					updateCommunityServiceTemp(communityServiceTemp);
					if (Constant.OpenAdmin.GroundMode.AUTO == communityServiceTemp.getGroundMode()) {
						CommunityService communityService = new CommunityService();
						BeanUtils.copyProperties(communityServiceTemp, communityService);
						updateCommunityService(communityService);
					}
					// 修改服务范围信息
					cmmSrvcRele(Integer.parseInt(objectId), true, communityServiceTemp.getTitle());

					// List<CommunityServiceRela> oldList =
					// getCommunityServiceRela(Integer.parseInt(objectId));
					// deleteCommunityServiceRela(Integer.parseInt(objectId));
					// List<CommunityServiceRelaTemp> list =
					// getCommunityServiceTempRela(Integer.parseInt(objectId));
					// if (list != null && list.size() > 0) {
					// for (int i = 0; i < list.size(); i++) {
					// CommunityServiceRela communityServiceRela = new CommunityServiceRela();
					// BeanUtils.copyProperties(communityServiceRela, list.get(i));
					// if (oldList != null && oldList.size() > 0) {
					// for (int j = 0; j < oldList.size(); j++) {
					// if (oldList.get(j).getCommunityId() == list.get(i).getCommunityId()) {
					// BeanUtils.copyProperties(communityServiceRela, oldList.get(j));
					// break;
					// }
					// }
					// }
					// addCommunityServiceRela(communityServiceRela);
					// }
					// }
					// sms
					List<String> parameter1 = new ArrayList<>();
					// parameter.add(merchant.getTitle());
					parameter1.add(communityServiceTemp.getTitle());
					sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.open_submit_service_audit_pass, objectId, 0,
							uid, parameter1);
					// email send
					OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(uid);
					sendEmail(info.getEmail(),info.getTitle(),communityServiceTemp.getTitle(),EmailType.open_submit_service_audit_pass);
				}
			};
		}
		// 服务下架审核
		if (type.compareTo(ObjectType.under_community_service) == 0) {
			return new IOpenAuditTypeReturn() {

				@Override
				public void unpassAudit(Long uid, String objectId, String reason) throws Exception {
					// 审核不通过
					CommunityServiceTemp communityServiceTemp = getCommunityServiceTempByPrimaryKey(
							Integer.parseInt(objectId));
					communityServiceTemp.setStatus(Constant.OpenAdmin.CommunityServiceGroundStatus.GROUNDING);
					communityServiceTemp.setAuditComment(reason);
					updateCommunityServiceTemp(communityServiceTemp);

					CommunityService communityService = getCommunityServiceByPrimaryKey(Integer.parseInt(objectId));
					communityService.setStatus(Constant.OpenAdmin.CommunityServiceGroundStatus.GROUNDING);
					communityService.setAuditComment(reason);
					updateCommunityService(communityService);

					// sms
					List<String> parameter1 = new ArrayList<>();
					// parameter.add(merchant.getTitle());
					parameter1.add(communityServiceTemp.getTitle());
					sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.open_under_community_service_unpass,
							objectId, 0, uid, parameter1);

					// email send
					OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(uid);
					sendEmail(info.getEmail(),info.getTitle(),communityServiceTemp.getTitle(),reason,EmailType.open_under_community_service_unpass);
				}

				@Override
				public void passAudit(Long uid, String objectId, Map<String, String> parameter) throws Exception {

					// 审核通过
					CommunityService communityService = getCommunityServiceByPrimaryKey(Integer.parseInt(objectId));
					validator(communityService == null, "服务ID不存在!" + objectId);
					communityService.setStatus(Constant.OpenAdmin.CommunityServiceGroundStatus.UNDER);
					communityService
							.setGroundAuditStatus(Constant.OpenAdmin.CommunityServiceGroundAuditStatus.NOTAUDIT);
					updateCommunityService(communityService);

					CommunityServiceTemp communityServiceTemp = getCommunityServiceTempByPrimaryKey(
							Integer.parseInt(objectId));
					communityServiceTemp.setStatus(Constant.OpenAdmin.CommunityServiceGroundStatus.UNDER);
					communityServiceTemp
							.setGroundAuditStatus(Constant.OpenAdmin.CommunityServiceGroundAuditStatus.NOTAUDIT);
					updateCommunityServiceTemp(communityServiceTemp);

					// 关联下架
					CommunityServiceRelaExample exa = new CommunityServiceRelaExample();
					exa.createCriteria().andServiceIdEqualTo(Integer.parseInt(objectId));
					List<CommunityServiceRela> list = communityServiceRelaMapper.selectByExample(exa);
					CommunityServiceRela record = new CommunityServiceRela();
					record.setStatus(Constant.OpenAdmin.CommunityServiceRelaStatus.DISABLE);
					record.setAuditStatus(Constant.OpenAdmin.CommunityServiceRelaAuditStatus.NOTAUDIT);
					record.setAuditComment("");
					record.setUpdateTime(new Date());
					CommunityServiceRelaExample example = new CommunityServiceRelaExample();
					example.createCriteria().andServiceIdEqualTo(Integer.parseInt(objectId));
					communityServiceRelaMapper.updateByExampleSelective(record, example);

					CommunityServiceRelaTemp record1 = new CommunityServiceRelaTemp();
					record1.setStatus(Constant.OpenAdmin.CommunityServiceRelaStatus.DISABLE);
					record1.setAuditStatus(Constant.OpenAdmin.CommunityServiceRelaAuditStatus.NOTAUDIT);
					record1.setUpdateTime(new Date());
					record1.setAuditComment("");
					CommunityServiceRelaTempExample example1 = new CommunityServiceRelaTempExample();
					example1.createCriteria().andServiceIdEqualTo(Integer.parseInt(objectId));
					communityServiceRelaTempMapper.updateByExampleSelective(record1, example1);
					//

					// sms
					List<String> parameter1 = new ArrayList<>();
					// parameter.add(merchant.getTitle());
					parameter1.add(communityService.getTitle());
					sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.open_under_community_service_pass, objectId,
							0, uid, parameter1);
					// email send
					OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(uid);
					sendEmail(info.getEmail(),info.getTitle(),communityServiceTemp.getTitle(),EmailType.open_under_community_service_pass);

					for (CommunityServiceRela string : list) {
						// sms
						List<String> parameter2 = new ArrayList<>();
						// parameter.add(merchant.getTitle());
						parameter2.add(communityService.getTitle());
						sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.open_pf_to_community_under, objectId,
								string.getCommunityId(), uid, parameter2);

					}
					openAuditInfoComponent.canel(OpenAuditInfoComponent.ObjectType.under_community_service, uid,
							objectId);

				}
			};
		}
		// 服务基本信息审核
		if (type.compareTo(ObjectType.service_approval) == 0) {
			return new IOpenAuditTypeReturn() {

				@Override
				public void unpassAudit(Long uid, String objectId, String reason) throws Exception {
					// 服务基本信息审核不通过
					CommunityServiceTemp communityServiceTemp = getCommunityServiceTempByPrimaryKey(
							Integer.parseInt(objectId));
					communityServiceTemp.setAuditStatus(Constant.OpenAdmin.CommunityServiceAuditStatus.AUDIT_NOTPASS);
					communityServiceTemp.setAuditComment(reason);
					updateCommunityServiceTemp(communityServiceTemp);
					// sms
					List<String> parameter = new ArrayList<>();
					// parameter.add(merchant.getTitle());
					parameter.add(communityServiceTemp.getTitle());
					sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.open_service_approval_unpass, objectId, 0,
							uid, parameter);
					// email send
					OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(uid);
					sendEmail(info.getEmail(),info.getTitle(),communityServiceTemp.getTitle(),reason,EmailType.open_service_approval_unpass);
				}

				@Override
				public void passAudit(Long uid, String objectId, Map<String, String> parameter) throws Exception {
					Double commissionRate =  MapUtils.getDouble(parameter, "commissionRate");
					validator(commissionRate == null || commissionRate.doubleValue() < 0 || commissionRate.doubleValue() >= 100,
							"社区服务费比例只能在0-100之间");
					Double platformFee = MapUtils.getDouble(parameter, "platformFee");
					validator(platformFee == null || platformFee.doubleValue() < 0 || platformFee.doubleValue() >= 100,
							"平台手续费比例只能在0-100之间");
					Double thinkRate = MapUtils.getDouble(parameter, "thinkRate");
					validator(thinkRate == null || thinkRate.doubleValue() < 0 || thinkRate.doubleValue() >= 100,
							"支付手续费比例只能在0-100之间");
					double totalFee = commissionRate + platformFee+thinkRate;
					validator(totalFee < 0 || totalFee >= 100,"平台手续费比例+社区服务费比例+支付手续费比例不能少于0%或大于等于100%");
					int serviceId = Integer.parseInt(objectId);
					// 审核通过，设置保证金金额，佣金比例
					CommunityServiceTemp communityServiceTemp = getCommunityServiceTempByPrimaryKey(serviceId);
					if (communityServiceTemp == null) {
						error("服务不存在" + serviceId + "_" + objectId);
					}

					OpenServicePay pay = openServicePayService.getOpenServicePay(serviceId);
					if(pay==null){
						error("服务费率表不存在 " + serviceId + "_" + objectId);
					}

					logger.info("7243community,serviceId:{}ServiceTemp{}", serviceId,
							JSON.toJSONString(communityServiceTemp));
					OpenMerchantInfo openMerchantInfo = openMerchantInfoMapper
							.selectByPrimaryKey(communityServiceTemp.getMerchantId());

					if (openMerchantInfo == null) {
						error("服务对应的服务商信息不存在");
					}
					communityServiceTemp.setAuditStatus(Constant.OpenAdmin.CommunityServiceAuditStatus.AUDIT_PASS_PAID);
					communityServiceTemp.setAuditTime(new Date());
					logger.info("7243community,serviceId:{}ServiceTemp{}", serviceId,
							JSON.toJSONString(communityServiceTemp));
					updateCommunityServiceTemp(communityServiceTemp);


					pay.setPlatformFee(BigDecimal.valueOf(platformFee)) ;
					pay.setCommunityRate(BigDecimal.valueOf(commissionRate));
					pay.setThinkRate(BigDecimal.valueOf(thinkRate));
					openServicePayService.insertOrUpdate(pay);

					logger.info("7244community,serviceId:{}ServiceTemp{}", serviceId,
							JSON.toJSONString(communityServiceTemp));
					CommunityService communityService = new CommunityService();

					// BeanUtils.copyProperties(communityService, communityServiceTemp);
					BeanUtils.copyProperties(communityServiceTemp, communityService);
					logger.info("724community,serviceId:{}ServiceTemp{}", serviceId,
							JSON.toJSONString(communityServiceTemp));
					logger.info("724community,serviceId:{}Service{}", serviceId, JSON.toJSONString(communityService));
					updateCommunityService(communityService);

					// 服务正式表
					CommunityService service = communityServiceMapper.selectByPrimaryKey(serviceId);
					// Boolean 服务是否上架，如果已上架需要自动上架服务
					cmmSrvcRele(serviceId, service.getStatus() == 1 ? true : false, "");

					// '1,待缴纳,2,已线上缴纳,3线下缴纳待核验,4已线下缴纳,5隐藏,6已退'
					openCautionInfoSerService.cautionHandle(serviceId, true);

					// 更新关键词到正式表
					openServiceExtendService.passKeyword(communityService.getId());

					// sms
					List<String> parameter1 = new ArrayList<>();
					// parameter.add(merchant.getTitle());
					parameter1.add(communityServiceTemp.getTitle());
					sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.open_service_approval_pass, objectId, 0, uid,
							parameter1);
					// email send
					OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(uid);
					sendEmail(info.getEmail(),info.getTitle(),communityServiceTemp.getTitle(),EmailType.open_service_approval_pass);
				}

			};
		}
		// 普通接口申请
		if (type.compareTo(ObjectType.service_interface_apply) == 0) {
			return new IOpenAuditTypeReturn() {

				@Override
				public void unpassAudit(Long uid, String objectId, String reason) throws Exception {

					String ifId = null;
					for (String string : objectId.split(":")) {
						if (string.startsWith("i")) {
							ifId = string.substring(1);
						}
					}
					//
					OpenServiceInterface openServiceInterface = openServiceInterfaceService
							.getServiceInterface(Integer.parseInt(ifId));
					if (openServiceInterface == null) {
						error("支付申请信息不存在");
					}
					openServiceInterface.setAuditComment(reason);
					openServiceInterface.setAuditStatus(Constant.OpenAdmin.ServiceInterfaceAuditStatus.AUDIT_NOTPASS);
					openServiceInterfaceService.updateServiceInterface(openServiceInterface);
					CommunityServiceTemp communityServiceTemp = getCommunityServiceTempByPrimaryKey(
							openServiceInterface.getServiceId());
					// sms
					List<String> parameter1 = new ArrayList<>();
					// parameter.add(merchant.getTitle());
					parameter1.add(communityServiceTemp.getTitle());
					sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.open_service_interface_apply_unpass,
							objectId, 0, uid, parameter1);
				}

				@Override
				public void passAudit(Long uid, String objectId, Map<String, String> parameter) throws Exception {

					String ifId = null;
					for (String string : objectId.split(":")) {
						if (string.startsWith("i")) {
							ifId = string.substring(1);
						}
					}
					OpenServiceInterface openServiceInterface = openServiceInterfaceService
							.getServiceInterface(Integer.parseInt(ifId));
					if (openServiceInterface == null) {
						error("支付申请信息不存在");
					}
					CommunityServiceTemp communityServiceTemp = getCommunityServiceTempByPrimaryKey(
							openServiceInterface.getServiceId());
					// 向平台开通接口
					platformGlobalComponent.auditService(communityServiceTemp.getAppId(),
							openServiceInterface.getInterfaceId(), 3, "通过");
					//
					openServiceInterface.setAuditComment("通过");
					openServiceInterface.setAuditStatus(Constant.OpenAdmin.ServiceInterfaceAuditStatus.AUDIT_PASS);
					openServiceInterface.setStatus(Constant.OpenAdmin.ServiceInterfaceStatus.ENABLE);
					openServiceInterfaceService.updateServiceInterface(openServiceInterface);

					// sms
					List<String> parameter1 = new ArrayList<>();
					// parameter.add(merchant.getTitle());
					parameter1.add(communityServiceTemp.getTitle());
					sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.open_service_interface_apply_pass, objectId,
							0, uid, parameter1);
				}
			};
		}

		return null;
	}

	private void cmmSrvcRele(Integer objectId, boolean auto, String title)
			throws IllegalAccessException, InvocationTargetException {
		// 把服务覆盖范围临时表的数据转移到正式表中
		List<CommunityServiceRela> oldList = getCommunityServiceRela(objectId);
		// deleteCommunityServiceRela(Integer.parseInt(objectId));
		List<CommunityServiceRelaTemp> newlist = getCommunityServiceTempRela(objectId);

		List<Integer> oldListcommid = new ArrayList<>();
		List<Integer> newListcommid = new ArrayList<>();
		List<Integer> delListcommid = new ArrayList<>();
		List<Integer> addListcommid = new ArrayList<>();

		for (CommunityServiceRela id : oldList) {
			oldListcommid.add(id.getCommunityId());
			delListcommid.add(id.getCommunityId());
		}
		for (CommunityServiceRelaTemp id : newlist) {
			newListcommid.add(id.getCommunityId());
			addListcommid.add(id.getCommunityId());
		}

		delListcommid.removeAll(newListcommid);
		addListcommid.removeAll(oldListcommid);

		for (Integer commid : addListcommid) {
			for (CommunityServiceRelaTemp data : newlist) {
				if (commid.intValue() == data.getCommunityId()) {

					CommunityServiceRela communityServiceRela = new CommunityServiceRela();
					BeanUtils.copyProperties(data, communityServiceRela);

					addCommunityServiceRela(communityServiceRela);
				}
			}
		}
		for (Integer commid : delListcommid) {
			deleteCommunityServiceRela(objectId, commid);
		}

		if (auto) {

			CommunityServiceRelaExample example = new CommunityServiceRelaExample();
			example.createCriteria().andServiceIdEqualTo(objectId);
			List<CommunityServiceRela> list = communityServiceRelaMapper.selectByExample(example);
			for (CommunityServiceRela communityServiceRela : list) {
				communityServiceRela.setStatus(1);
				communityServiceRela.setGroundTime(new Date());
				communityServiceRela.setSelectStatus(1);
				communityServiceRela.setAuditComment("平台审批通过自动上架");
				communityServiceRela.setAuditStatus(Constant.OpenAdmin.CommunityServiceRelaAuditStatus.AUDIT_PASS);
				communityServiceRelaMapper.updateByPrimaryKeySelective(communityServiceRela);
				// sms
				List<String> parameter2 = new ArrayList<>();
				// parameter.add(merchant.getTitle());
				parameter2.add(title);
				sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.open_pf_to_community_auto, objectId.toString(),
						communityServiceRela.getCommunityId(), null, parameter2);
			}

		}

		// if (newlist != null && newlist.size() > 0) {
		// for (int i = 0; i < newlist.size(); i++) {
		//
		// BeanUtils.copyProperties(communityServiceRela, newlist.get(i));
		// if (oldList != null && oldList.size() > 0) {
		// for (int j = 0; j < oldList.size(); j++) {
		// if (oldList.get(j).getCommunityId() == newlist.get(i).getCommunityId()) {
		// BeanUtils.copyProperties(communityServiceRela, oldList.get(j));
		// break;
		// }
		// }
		// // 朱哥 应该有bug
		// }
		// addCommunityServiceRela(communityServiceRela);
		// }
		// }
	}

	// public void deleteCommunityServiceRela(int serviceId) {
	// CommunityServiceRelaExample example = new CommunityServiceRelaExample();
	// example.createCriteria().andServiceIdEqualTo(serviceId);
	// communityServiceRelaMapper.deleteByExample(example);
	// }

	public void addCommunityServiceRela(CommunityServiceRela communityServiceRela) {
		communityServiceRelaMapper.insertSelective(communityServiceRela);
	}

	public void deleteCommunityServiceRela(Integer serviceId, Integer communityId) {
		CommunityServiceRelaKey key = new CommunityServiceRelaKey();
		key.setCommunityId(communityId);
		key.setServiceId(serviceId);
		communityServiceRelaMapper.deleteByPrimaryKey(key);
	}

	private void sendEmail(String email,String title, String serviceTitle, EmailType emailType) {
		sendEmail(email,title,serviceTitle,"",emailType);
	}

	private void sendEmail(String email,String title, String serviceTitle,String reason, EmailType emailType) {
		if(StringUtils.isNotBlank(email)){
			Map<String, Object> model = new HashMap<>();
			model.put("title", title);
			model.put("serviceTitle", serviceTitle);
			model.put("reason", reason);
			javaMailComponent.sendEmail(emailType, email, model);
		}else{
			logger.warn("邮件地址为空不能发送邮件...");
		}

	}
}
