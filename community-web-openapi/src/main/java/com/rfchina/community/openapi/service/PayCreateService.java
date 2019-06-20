package com.rfchina.community.openapi.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import com.rfchina.community.base.OpenOperatorTaskConstant;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.model.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.api.request.pay.FuPayCreateRequest.GoodsDetail;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.pay.FuPayCreateResponseModel;
import com.rfchina.api.response.model.pay.FuPayGetAccountResponseModel;
import com.rfchina.api.response.model.pay.FuPayGetMchDetailResponseModel;
import com.rfchina.api.response.model.pay.FuPayPreOrderResponseModel;
import com.rfchina.api.response.model.pay.FuPayQrCodeGenResponseModel;
import com.rfchina.api.response.model.user.GetUserInfoWithOpenIdResponseModel;
import com.rfchina.api.response.model.user.VerifyUserTokenResponseModel;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.EmojiUtil;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.openapi.ExtAppMoney;
import com.rfchina.community.base.openapi.ExtAppMoneyBase;
import com.rfchina.community.base.openapi.ExtAppMoneyTotal;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.openapi.entity.AccountData;
import com.rfchina.community.openapi.entity.ExtServiceMerchantInfo;
import com.rfchina.community.openapi.mapper.ext.ExtOpenServiceMapper;
import com.rfchina.community.service.openser.OpenOrderSerService;

@Service
public class PayCreateService extends BaseService {

	private static Logger logger = LoggerFactory.getLogger(PayCreateService.class);

	@Autowired
	private PlatformService platformService;
	@Autowired
	private CommunityMapper communityMapper;
	@Autowired
	private CommunityPayService communityPayService;

	@Autowired
	private FuPayService fuPayService;
	@Autowired
	private CommunityServiceRelaMapper communityServiceRelaMapper;

	@Autowired
	private OpenOrderTotalResponseMapper openOrderTotalResponseMapper;

	@Autowired
	private OpenOrderSerService openOrderService;

	@Autowired
	private OpenOrderTotalMapper openOrderTotalMapper;

	@Autowired
	private CommunityServiceTempMapper communityServiceTempMapper;
	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;
	@Autowired
	private OpenPointRecordService openPointRecordService;
	@Autowired
	private ExtOpenServiceMapper extOpenServiceMapper;
	@Autowired
	private OpenStoreOrderMapper openStoreOrderMapper;
	@Autowired
	private OpenOperatorTaskMapper openOperatorTaskMapper;
	@Autowired
	private OpenOperatorTaskRelMapper openOperatorTaskRelMapper;
	@Value("${debug.communityId}")
	private int debugCommunityId;

	@Value("${debug.masterInfoId}")
	private long debugMasterInfoId;

	@Value("${rfpay.appId}")
	private Long rfpayAppId;
	@Value("${rfpay.appSecret}")
	private String rfpayAppSecret;
	@Value("${open.common.account_id}")
	private String commonAccountId;
	@Value("${think.account.id}")
	private String thinkAccountId;

	private Community getCommunity(int communityId) {
		Community community = communityMapper.selectByPrimaryKey(communityId);
		validator(community == null, "社区不存在:" + communityId);
		validator(community.getStatus() == 2, "该社区已经禁用:" + communityId);
		return community;
	}

	// 不能和公共账号相同
	private void checkAccountId(String payAccount, String merchantId) {
		validator(StringUtils.isBlank(payAccount), "结算账号为空");
		validator(StringUtils.equalsIgnoreCase(commonAccountId, payAccount), "结算账号配置错误!" + payAccount);

		// 社区拆分账号
		FuPayGetAccountResponseModel responseModel = platformService.getAccount(payAccount);
		validator(responseModel == null, "获取社区收款账号出错!" + payAccount);
		validator(!merchantId.equalsIgnoreCase(responseModel.getMchId()),
				"社区收款账号跟商家账号不匹配" + payAccount + "," + merchantId);
		validator(responseModel.getStatus() != 1, "社区收款账号状态不正常" + payAccount);

		validator(StringUtils.isBlank(merchantId), "没有配置商家账号" + payAccount);
		FuPayGetMchDetailResponseModel mchDetailResponseModel = platformService.getMchDetail(merchantId);
		validator(mchDetailResponseModel == null, "获取社区商家详情出错!" + merchantId);
		validator(mchDetailResponseModel.getStatus() != 2, "社区商家账号状态不正常" + merchantId);
	}

	public AccountData checkCommunityPay(int communityId) {
		getCommunity(communityId);
		// 判断社区的结算账号跟商家是否正常
		CommunityPay communityPay = communityPayService.getCommunityPay(communityId);
		validator(communityPay == null, "该社区没有配置结算账号!" + communityId);
		String payAccount = communityPay.getOpenPayAccount();
		String merchantId = communityPay.getOpenMerchantId();

		checkAccountId(payAccount, merchantId);
		return new AccountData(payAccount, merchantId);

	}

	public Long getUidByToken(String token, ExtAppMoneyBase extAppMoneyBase) {
		Long uid = 0L;
		if (StringUtils.isNotBlank(token)) {
			/// access_token to uid
			VerifyUserTokenResponseModel model = platformService.getVerifyUserToken(token);
			validator(model == null, "转换uid出错");

			uid = model.getUserId();
		} else if (extAppMoneyBase.getUid() != null && extAppMoneyBase.getUid() > 0
				&& extAppMoneyBase.getOpenStoreId() != null && extAppMoneyBase.getOpenStoreId() > 0) {
			/// open id to uid
			OpenStoreOrder storeOrder = openStoreOrderMapper.selectByPrimaryKey(extAppMoneyBase.getOpenStoreId());
			validator(storeOrder == null || storeOrder.getUserId().longValue() != extAppMoneyBase.getUid().longValue(),
					"用户未授权");
			uid = extAppMoneyBase.getUid();
		} else {
			logger.info(extAppMoneyBase.toString());
			ResponseData<GetUserInfoWithOpenIdResponseModel> data1 = fuPayService.getUserInfoWithOpenIdRequest(
					rfpayAppId, rfpayAppSecret, extAppMoneyBase.getAppId(), extAppMoneyBase.getRfOpenId());
			if (data1 != null && data1.getCode() == 1001) {
				uid = data1.getData().getUid();
			} else {
				error("错误:" + data1.getCode() + "_" + data1.getMsg());
			}
		}
		return uid;
	}

	// 社区是否增加服务.
	public void checkCommunityAndService(int communityId, int serviceId) {
		CommunityServiceRelaExample ex = new CommunityServiceRelaExample();
		ex.createCriteria().andServiceIdEqualTo(serviceId).andCommunityIdEqualTo(communityId);
		List<CommunityServiceRela> lst = communityServiceRelaMapper.selectByExample(ex);
		validator(lst.isEmpty(), "该社区没有启用这个服务,社区ID:" + communityId + ",服务ID:" + serviceId);

	}

	public String createCommunityTradeNo() {
		// 生成社区订单号
		String dateformat = DateTimeUtils.format(new Date(), "yyMMddHHmmssSSS");
		// 5+15+5
		String communityTradeNo = Constant.OpenOrder.PAY_TRADE_NO_PREFIX_NEW + dateformat
				+ RandomStringUtils.randomNumeric(5) + no();
		return communityTradeNo;
	}

	private String no() {
		atomicInteger.getAndIncrement();
		String no = "00" + atomicInteger.intValue();
		return no.substring(no.length() - 3, no.length());
	}

	public static AtomicInteger atomicInteger = new AtomicInteger(new Random().nextInt(1000));

	public void createOpenOrderTotalResponse(Long id, Object model) {
		OpenOrderTotalResponse record = new OpenOrderTotalResponse();
		record.setId(id);
		record.setPayCreateResponse(JSON.toJSONString(model));
		openOrderTotalResponseMapper.insertSelective(record);
	}

	public JSONObject buildData(String payType, int communityId, String payChannel, String clientIp, String projectType,
			String tradeType, String weiXinOpenId, String expireTime, int bussinessType, Long uid,
			List<ExtAppMoney> moneys, String redirectUrl, AccountData communityAccountId, int type,
			String wapName, String wapUrl, String wapRedirectUrl, String posTitle,String channelAppName) {
		// 生成社区订单号
		String communityTradeNo = createCommunityTradeNo();

		validator(moneys.isEmpty(), "没有提交数据");
		//4合并支付,5闪付,
		validator(type != OpenConstant.open_order.Type.total_normal
				&& type != OpenConstant.open_order.Type.quick, "type必须等于4或5");

		String subject_temp = "";
		String body_temp = "";
		String detail_temp = "";
		List<GoodsDetail> goodsDetails_temp = new ArrayList<>();
		logger.info("1communityTradeNo:{},moneys:{}", communityTradeNo, JSON.toJSONString(moneys));
		mapService(moneys);
		logger.info("2communityTradeNo:{},moneys:{}", communityTradeNo, JSON.toJSONString(moneys));
		ExtAppMoneyTotal total = new ExtAppMoneyTotal();
		total.setMoneys(moneys);
		total.build();
		String outTradeNo_temp = "";
		String rfOpenId_temp = "";
		for (ExtAppMoney m : total.getMoneys()) {
			outTradeNo_temp += "," + m.getOutTradeNo();
			rfOpenId_temp += "," + m.getRfOpenId();
			subject_temp = m.getSubject();
			body_temp = m.getBody();
			detail_temp = m.getDetail();
			goodsDetails_temp.addAll(m.getGoodsDetails());
			validator(StringUtils.isBlank(m.getAccountId()), "该appid对应的结算账号不存在" + m.getAppId());
			if (debugCommunityId != communityId) {
				// 社区是否增加服务.
				checkCommunityAndService(communityId, m.getServiceId());
			}

			validator(m.getTotalAmount() == null || m.getTotalAmount().compareTo(BigDecimal.valueOf(0)) <= 0,
					"total_amount不能为空或是小于等于0");
			validator(StringUtils.isBlank(m.getOutTradeNo()), "第三方订单号不能为空!");
			// 检查是否有重复订单
			validator(openOrderService.uniqueOutTradeNo(m.getOutTradeNo(), m.getAppId()) > 0,
					"失败,第三方订单重复!" + m.getOutTradeNo());

		}
		if (outTradeNo_temp.startsWith(",")) {
			outTradeNo_temp = outTradeNo_temp.substring(1);
		}
		if (rfOpenId_temp.startsWith(",")) {
			rfOpenId_temp = rfOpenId_temp.substring(1);
		}
		Integer storeCount = moneys.size();
		if (storeCount > 1) {
			subject_temp = "自在生活合并支付" + storeCount + "个商家订单";
			detail_temp = "自在生活合并支付" + storeCount + "个商家订单";
			body_temp = "自在生活合并支付" + storeCount + "个商家订单";
		}
		if(StringUtils.isNotBlank(posTitle)) {
			body_temp = posTitle;
		}
		logger.info("{}", total.toString());

		BigDecimal platformChargeTotal = total.getPlatformChargeTotal();
		BigDecimal totalAmountTotal = total.getTotalAmountTotal();

		LocalDateTime localDateTime = null;
		if (StringUtils.isNotBlank(expireTime)) {
			localDateTime = LocalDateTime.parse(expireTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		}
		int index = clientIp.indexOf(",");
		if (index != -1) {
			clientIp = clientIp.substring(0, index);
		}

		body_temp = EmojiUtil.replaceAll(body_temp);
		detail_temp = EmojiUtil.replaceAll(detail_temp);
		subject_temp = EmojiUtil.replaceAll(subject_temp);
		// 调用支付中心接口进行下单
		JSONObject jsonObject = new JSONObject();

		ResponseData<?> responseData = null;
		if (OpenConstant.PayType.PRE.equals(payType)) {
			responseData = fuPayService.prePayCreate(rfpayAppId, rfpayAppSecret, commonAccountId, communityTradeNo,
					totalAmountTotal.multiply(new BigDecimal("100")).longValue(),
					platformChargeTotal.multiply(new BigDecimal("100")).longValue(), subject_temp, body_temp, clientIp,
					bussinessType + "", localDateTime, bussinessType + "", goodsDetails_temp, redirectUrl, null, null,
					uid + "", null);
		} else if (OpenConstant.PayType.APP.equals(payType)) {
			responseData = fuPayService.fuPayCreate(rfpayAppId, rfpayAppSecret, commonAccountId, payChannel,
					communityTradeNo, totalAmountTotal.multiply(new BigDecimal("100")).longValue(),
					platformChargeTotal.multiply(new BigDecimal("100")).longValue(), subject_temp, body_temp,
					detail_temp, clientIp, bussinessType, localDateTime, projectType, tradeType, weiXinOpenId,wapName, wapUrl, wapRedirectUrl,
					goodsDetails_temp.toArray(new GoodsDetail[0]));
			jsonObject.put("pay_info", responseData.getData());
		}else if (OpenConstant.PayType.SAPP.equals(payType)) {
			responseData = fuPayService.fuPayCreateForSAPP(rfpayAppId, rfpayAppSecret, commonAccountId, payChannel,
					communityTradeNo, totalAmountTotal.multiply(new BigDecimal("100")).longValue(),
					platformChargeTotal.multiply(new BigDecimal("100")).longValue(), subject_temp, body_temp,
					detail_temp, clientIp, bussinessType, localDateTime, projectType, weiXinOpenId,channelAppName,wapName, wapUrl, wapRedirectUrl,
					goodsDetails_temp.toArray(new GoodsDetail[0]));
			jsonObject.put("pay_info", responseData.getData());
		} else { // pos机支付
			responseData = fuPayService.posPayCreate(rfpayAppId, rfpayAppSecret, commonAccountId, communityTradeNo,
					totalAmountTotal.multiply(new BigDecimal("100")).longValue(),
					platformChargeTotal.multiply(new BigDecimal("100")).longValue(), subject_temp, body_temp, clientIp,
					projectType, localDateTime, bussinessType, null, tradeType,
					goodsDetails_temp.toArray(new GoodsDetail[0]));

		}
		String billId = null;
		if (responseData != null && responseData.getCode() == 1001) {
			// 保存订单信息到数据库
			Date createTime = new Date();
			if (OpenConstant.PayType.PRE.equals(payType)) {
				FuPayQrCodeGenResponseModel model = (FuPayQrCodeGenResponseModel) responseData.getData();
				billId = model.getBillId();
				jsonObject.put("billId", billId);
				jsonObject.put("redirect_url", model.getRedirectUrl());
			} else if (OpenConstant.PayType.APP.equals(payType) || OpenConstant.PayType.SAPP.equals(payType)) {
				FuPayCreateResponseModel model = (FuPayCreateResponseModel) responseData.getData();
				createTime = model.getCreateTime();
				billId = model.getBillId();
				jsonObject.put("redirect_url", model.getPayContent());
			} else {// pos机支付
				FuPayPreOrderResponseModel model = (FuPayPreOrderResponseModel) responseData.getData();
				billId = model.getBillId();
				jsonObject.put("billId", billId);
			}

			Long totalId = savePayOrder(communityId, communityAccountId, payChannel, clientIp, projectType, tradeType,
					weiXinOpenId, expireTime, bussinessType, uid, communityTradeNo, total, storeCount,
					platformChargeTotal, totalAmountTotal, subject_temp, createTime, billId, type);
			// Long id = openOrder.getId();
			createOpenOrderTotalResponse(totalId, responseData.getData());
			// 插入积分记录，通过定时任务去判断需不要送给用户

		} else {
			logger.error("创建订单出错，原因为：" + JSON.toJSONString(responseData));
			error("创建订单出错，原因为：" + JSON.toJSONString(responseData));
		}
		jsonObject.put("out_trade_no", outTradeNo_temp);
		jsonObject.put("rf_open_id", rfOpenId_temp);
		jsonObject.put("community_trade_no", communityTradeNo);

		return jsonObject;

	}

	private Long savePayOrder(int communityId, AccountData communityAccountId, String payChannel, String clientIp,
			String projectType, String tradeType, String weiXinOpenId, String expireTime, int bussinessType, Long uid,
			String communityTradeNo, ExtAppMoneyTotal total, Integer storeCount, BigDecimal platformChargeTotal,
			BigDecimal totalAmountTotal, String subject_temp, Date createTime, String billId, int type) {

		OpenOrderTotal record = new OpenOrderTotal();
		record.setAccountId(commonAccountId);
		record.setCommunityId(Long.valueOf(communityId));
		record.setUid(uid);
		record.setCommunityAccountId(communityAccountId.getAccountId());
		record.setBillStatus(1);
		record.setBillId(billId);
		record.setBillSplitStatus(2);
		record.setPfBalanceStatus(0);
		record.setPfBussinessBalanceStatus(0);
		record.setPfRefundStatus(0);
		record.setRefundCount(0);
		record.setPayChannel(payChannel);
		record.setCommunityTradeNo(communityTradeNo);
		record.setStoreCount(storeCount);
		record.setTotalAmount(totalAmountTotal);
		record.setType(type);
		record.setTotalPlatformCharge(platformChargeTotal);
		record.setTotalReceiptAmount(total.getReceiptAmountTotal());
		record.setTotalToReceiptAmount(total.getToReceiptAmountTotal());
		record.setTotalRefundMoney(total.getRefundUserTotal());
		record.setTotalServiceCharge(total.getServiceChargeTotal());

		//思力
		record.setTotalThinkAmount(total.getThinkAmountTotal());
		record.setTotalThinkToAmount(total.getToThinkAmountTotal());
		record.setThinkAccountId(thinkAccountId);

		//20190104旧代码重复赋值并且赋值商家应收变成服务费实收，导致数据也有问题，
		record.setTotalToServiceCharge(total.getToServiceChargeTotal());
		record.setCreateTime(createTime);
		record.setUpdateTime(createTime);
		record.setExpireTime(StringUtils.isNotBlank(expireTime) ? DateTimeUtils.parseDateTime(expireTime) : null);
		record.setStoreCount(storeCount);
		record.setSubject(subject_temp);
		openOrderTotalMapper.insertSelective(record);
		Long totalId = record.getId();
		for (ExtAppMoney money : total.getMoneys()) {
			Long id1 = createChildOrder(totalId, communityId, communityAccountId, payChannel, clientIp, projectType,
					tradeType, weiXinOpenId, expireTime, bussinessType, uid, communityTradeNo, money, createTime,
					billId, type);
			openPointRecordService.insert(uid, id1, money.getTotalAmount());
		}
		return totalId;
	}

	private Long createChildOrder(Long totalId, int communityId, AccountData communityAccountId, String payChannel,
			String clientIp, String projectType, String tradeType, String weiXinOpenId, String expireTime,
			int bussinessType, Long uid, String communityTradeNo, ExtAppMoney money, Date billCreateTime, String billId,
			int type) {

		OpenOrder openOrder = new OpenOrder();
		openOrder.setAccountId(money.getAccountId());
		openOrder.setThinkAccountId(money.getThinkAccountId());
		openOrder.setTotalId(totalId);
		openOrder.setAppId(money.getAppId());
		openOrder.setBillCreateTime(billCreateTime);
		openOrder.setBillId(billId);
		openOrder.setBillStatus(1);
		openOrder.setServiceId(money.getServiceId());
		openOrder.setServiceChargeStatus(1);
		openOrder.setBalanceStatus(1);
		openOrder.setServiceAccount(communityAccountId.getAccountId());
		openOrder.setServiceAccountMchid(communityAccountId.getAccountMchid());
		openOrder.setBody(money.getBody());
		openOrder.setDetail(money.getDetail());
		openOrder.setSubject(money.getSubject());
		openOrder.setBussinessType(bussinessType);
		openOrder.setClientIp(clientIp);
		openOrder.setCommunityId(Long.valueOf(communityId));
		openOrder.setCreateTime(new Date());
		openOrder.setExpireTime(StringUtils.isNotBlank(expireTime) ? DateTimeUtils.parseDateTime(expireTime) : null);
		openOrder.setGoodsDetail(JSON.toJSONString(money.getGoodsDetails()));
		openOrder.setOutTradeNo(money.getOutTradeNo());
		openOrder.setPayChannel(payChannel);
		openOrder.setProjectType(projectType);
		// openOrder.setServiceStatus(1);
		openOrder.setTotalAmount(money.getTotalAmount());
		openOrder.setTradeType(tradeType);
		openOrder.setOpenId(money.getRfOpenId());
		// 通过rf_open_id获取用户ID
		openOrder.setUid(uid);
		openOrder.setWithdrawStatus(6);
		// 计算手续费、佣金数据
		openOrder.setPlatformChargeRate(money.getPlatformFee());
		openOrder.setPlatformCharge(money.getPlatformCharge());
		openOrder.setServiceChargeRate(money.getCommunityRate());
		openOrder.setServiceCharge(money.getServiceCharge());
		//思力
		openOrder.setThinkChargeRate(money.getThinkRate());
		openOrder.setThinkCharge(money.getThinkCharge());

		openOrder.setRefundMoney(BigDecimal.valueOf(0));
		openOrder.setType(type); // 订单,2保证金,3场地服务费,4,合并支付,5闪付

		// '是否拆单，1：是，2：否',
		openOrder.setBillSplitStatus(2);
		openOrder.setReceiptAmount(money.getReceiptAmount());
		openOrder.setCommunityTradeNo(communityTradeNo);
		openOrder.setWeixinOpenId(weiXinOpenId);
		openOrderService.insertOpenOrder(openOrder);

		//合并支付跟闪付才需要
		if(type == 4 || type == 5){
			updateTaskInfoIfExist(openOrder, money.getServiceId(), communityId);
		}
		return openOrder.getId();
	}

	//根据店铺和社区，判断是否有任务在执行，把任务id跟员工id写入 TODO 有坑，同一个社区可能多个活动
	private void updateTaskInfoIfExist(OpenOrder openOrder, int serviceId, int communityId){
		Date now = new Date();
		OpenOperatorTaskExample example = new OpenOperatorTaskExample();
		example.createCriteria().andServiceIdEqualTo(serviceId)
				.andCommunityIdEqualTo(communityId)
				.andReceiveStatusEqualTo(OpenOperatorTaskConstant.ReceiveStatus.receive)
				.andReleaseStatusEqualTo(OpenOperatorTaskConstant.ReleaseStatus.running.getCode())
				.andStartTimeLessThanOrEqualTo(now)
				.andEndTimeGreaterThanOrEqualTo(now);
		example.setOrderByClause("create_time desc");
		List<OpenOperatorTask> list =  openOperatorTaskMapper.selectByExample(example);
		if(list.isEmpty())
			return;

		OpenOperatorTask task = list.get(0);

		//运营者记录
		OpenOperatorTaskRelExample relExample = new OpenOperatorTaskRelExample();
		relExample.createCriteria().andTaskIdEqualTo(task.getId()).andValidStatusEqualTo(1);
		relExample.setOrderByClause("id desc");
		List<OpenOperatorTaskRel> relList = openOperatorTaskRelMapper.selectByExample(relExample);

		if(relList.isEmpty())
			return ;

		OpenOperatorTaskRel rel = relList.get(0);
		openOrder.setTaskId(task.getId());
		openOrder.setEmpGuid(rel.getEmpGuid());
		openOrder.setEmpPhone(rel.getEmpPhone());
		openOrder.setEmpName(rel.getEmpName());
		openOrder.setTaskRelId(rel.getId());
		openOrderService.updateOpenOrderByPrimaryKey(openOrder);

	}


	private void mapService(List<ExtAppMoney> list) {
		String appids = "";
		for (ExtAppMoney extAppMoney : list) {
			Long appId = extAppMoney.getAppId();
			validator(appids.indexOf(appId.toString()) != -1, "错误,发现一个商家有多个订单,appId:" + appId);
			appids += "," + appId;
		}
		List<ExtServiceMerchantInfo> lis1t = extOpenServiceMapper.selectOpenService(appids.substring(1));
		validator(lis1t.isEmpty(), "无相关服务" + appids);

		for (ExtServiceMerchantInfo info : lis1t) {
			for (ExtAppMoney m : list) {
				if (m.getAppId() == info.getAppId().longValue()) {
					m.setCommunityRate(info.getCommunityRate());
					m.setPlatformFee(info.getPlatformFee());
					m.setThinkRate(info.getThinkRate());
					m.setAccountId(info.getAccountId());
					m.setServiceId(info.getServiceId());
					m.setThinkAccountId(commonAccountId);
					break;
				}
			}
		}
		logger.info("appids:{},list:{}", appids, JSON.toJSONString(lis1t));
	}

}
