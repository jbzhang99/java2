package com.rfchina.community.openweb.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.pay.FuPayCreateResponseModel;
import com.rfchina.api.response.model.pay.FuPayQrCodeGenResponseModel;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.base.util.HttpUtil;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.openweb.service.FuPayService;
import com.rfchina.community.openweb.service.OpenWebOrderService;
import com.rfchina.community.persistence.mapper.CommunityPayMapper;
import com.rfchina.community.persistence.mapper.OpenOrderDetailMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJBusinessInfoMapper;
import com.rfchina.community.persistence.mapper.OpenXFSJInfoMapper;
import com.rfchina.community.persistence.mapper.OpenXfsjSignUpInfoMapper;
import com.rfchina.community.persistence.model.CommunityPay;
import com.rfchina.community.persistence.model.CommunityServiceTemp;
import com.rfchina.community.persistence.model.OpenOrder;
import com.rfchina.community.persistence.model.OpenOrderDetail;
import com.rfchina.community.persistence.model.OpenXFSJBusinessInfo;
import com.rfchina.community.persistence.model.OpenXFSJInfo;
import com.rfchina.community.persistence.model.OpenXfsjSignUpInfo;

/**
 * @author:fukangwen
 * @Description: 活动缴费
 */
@RestController
@RequestMapping(value = { Constant.ROOT_PATH_OPENWEB + "/payment" })
public class XFSJCommunityPayController extends BaseController {

	@Value("${rfpay.appId}")
	private long rfpayAppId;
	@Value("${rfpay.appSecret}")
	private String rfpayAppSecret;
	@Value("${open.h5.url}")
	private String openH5Url;
	@Autowired
	private OpenOrderDetailMapper openOrderDetailMapper;
	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;
	@Autowired
	private OpenWebOrderService openOrderService;
	@Autowired
	private FuPayService fuPayService;
	@Autowired
	private OpenXfsjSignUpInfoMapper openXfsjSignUpInfoMapper;
	@Autowired
	private OpenXFSJBusinessInfoMapper openXFSJBusinessInfoMapper;
	@Autowired
	private OpenXFSJInfoMapper openXFSJInfoMapper;
	@Autowired
	private CommunityPayMapper communityPayMapper;


	@RequestMapping("/pay_activity")
	@Transactional(rollbackFor = Exception.class)
	public Result<?> payActivity(
			@RequestParam("serviceId") int serviceId, 
			@RequestParam("id") Long id, //报名表id
			@RequestParam(value = "pay_channel", required = true) String payChannel,
			HttpServletRequest request) {
		
		logger.info("service_id:{},id:{},pay_channel:{}",serviceId, id, payChannel);
		authorityCheck(serviceId);
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId(), "非法访问!");
		
		//获取活动报名信息
		OpenXfsjSignUpInfo signUpInfo = openXfsjSignUpInfoMapper.selectByPrimaryKey(id);
		validator(signUpInfo == null, "数据不存在!");
		validator(signUpInfo.getUid().longValue() != getAdminId().longValue(), "非法访问!");
		validator(signUpInfo.getStatus() != OpenConstant.SignUpCheckStatus.PASS, "非报名状态不能支付");
		
		//获取活动信息
		OpenXFSJBusinessInfo openXFSJBusinessInfo = openXFSJBusinessInfoMapper.selectByPrimaryKey(signUpInfo.getXfsjId());
		validator(openXFSJBusinessInfo == null, "活动信息不存在!");
//		validator(openXFSJBusinessInfo.getSignUpEndTime() == null ||
//				openXFSJBusinessInfo.getSignUpEndTime().getTime() < new Date().getTime(), "已经超过报名时间,不能支付");
		
		OpenXFSJInfo openXFSJInfo = openXFSJInfoMapper.selectByPrimaryKey(signUpInfo.getXfsjId());
		validator(openXFSJInfo == null, "活动信息不存在!");
		
		//获取社区信息
		CommunityPay communityPay = communityPayMapper.selectByPrimaryKey(openXFSJInfo.getCommunityId());
		validator(communityPay == null || StringUtils.isBlank(communityPay.getPayAccount()), "社区账户信息不存在");
		String account = communityPay.getPayAccount();
		
		//调用支付中心的支付接口进行支付
		String communityOutTradeNo = String.format("%s%d%s", Constant.OpenOrder.PAY_ACTIVITY_PREFIX,
				System.nanoTime(), RandomStringUtils.randomNumeric(10));
		
		logger.info("out_trade_no:{}", communityOutTradeNo);
		
		BigDecimal serviceFee = signUpInfo.getServiceFee();
		BigDecimal platformChargeRate = signUpInfo.getPlatformChargeRate();
		BigDecimal platformCharge = signUpInfo.getPlatformCharge();
		BigDecimal receiptAmount = signUpInfo.getReceiptAmount();

		DateTimeFormatter sf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime expireTime = LocalDateTime
				.parse(DateTimeUtils.formatDateTime(new Date(System.currentTimeMillis() + 1000L * 60 * 6)), sf);
		String title = openXFSJInfo.getActTitile() + "-综合服务费";
		String ip=HttpUtil.getIp2(request);
		ResponseData<FuPayCreateResponseModel> responseData = platformGlobalComponent.fuPayCreate(account,
				payChannel, communityOutTradeNo, serviceFee.multiply(new BigDecimal("100")).longValue(),
				platformCharge.multiply(new BigDecimal("100")).longValue(), title, title, title, ip, 2, expireTime, "活动缴费", "NATIVE",
				null, null);
		
		if (responseData.getCode() == 1001) {
			// 保存订单信息
			OpenOrder openOrder = new OpenOrder();
			openOrder.setCommunityId(openXFSJInfo.getCommunityId().longValue());
			openOrder.setAccountId(account);
			openOrder.setAppId(rfpayAppId);
			Date billCreate = responseData.getData().getCreateTime();
			openOrder.setBillCreateTime(billCreate);
			String billId = responseData.getData().getBillId();
			openOrder.setBillId(billId);
			openOrder.setBillStatus(1);
			openOrder.setBody(title);
			openOrder.setBussinessType(3);//1：正常交易单，2：保证金单,3活动缴费订单
			openOrder.setClientIp(ip);
			openOrder.setCreateTime(responseData.getData().getCreateTime());
			openOrder.setDetail(title);
			openOrder.setServiceChargeRate(new BigDecimal(0));
			openOrder.setExpireTime(null);
			openOrder.setGoodsDetail(null);
			openOrder.setPayChannel(payChannel);
			openOrder.setProjectType("活动缴费");
			// openOrder.setServiceStatus(1);
			openOrder.setSubject(title);
			openOrder.setTotalAmount(serviceFee);
			openOrder.setPlatformChargeRate(platformChargeRate);
			openOrder.setPlatformCharge(platformCharge);
			
			openOrder.setTradeType("NATIVE");
			openOrder.setCommunityTradeNo(communityOutTradeNo);

			openOrder.setOutTradeNo(communityOutTradeNo);
			openOrder.setReceiptAmount(receiptAmount);
			openOrder.setType(OpenConstant.open_order.Type.activity); //1：正常交易单，2：保证金单,3活动缴费订单
			openOrder.setCautionId(id); //报名信息单id
			openOrder.setServiceId(serviceId);
			openOrderService.insertOpenOrder(openOrder);
			
			OpenOrderDetail record = new OpenOrderDetail();
			record.setId(openOrder.getId());
			record.setPayCreateResponse(JSON.toJSONString(responseData.getData()));
			openOrderDetailMapper.insertSelective(record);
			
			return Result.successData(responseData.getData());
		} else {
			error("支付失败" + JSON.toJSONString(responseData));
		}
		return Result.success();
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 直接调起微信支付
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/h5/pay_activity")
	@Transactional(rollbackFor = Exception.class)
	public Result<?> h5PayActivity(
			@RequestParam("service_id") int serviceId,
			@RequestParam("id") Long id,
			@RequestParam(value = "pay_channel", required = true, defaultValue = "") String payChannel,
			HttpServletRequest request) {
		logger.info("h5PayActivity:serviceId={},id={},pay_channel={}", serviceId, id, payChannel);
		authorityCheck(serviceId);
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId(), "非法访问!");
		
		//获取活动报名信息
		OpenXfsjSignUpInfo signUpInfo = openXfsjSignUpInfoMapper.selectByPrimaryKey(id);
		validator(signUpInfo == null, "数据不存在!");
		validator(signUpInfo.getUid().longValue() != getAdminId().longValue(), "非法访问!");
		validator(signUpInfo.getStatus() != OpenConstant.SignUpCheckStatus.PASS, "非报名状态不能支付");
		
		//获取活动信息
		OpenXFSJBusinessInfo openXFSJBusinessInfo = openXFSJBusinessInfoMapper.selectByPrimaryKey(signUpInfo.getXfsjId());
		validator(openXFSJBusinessInfo == null, "活动信息不存在!");
//		validator(openXFSJBusinessInfo.getSignUpEndTime() == null ||
//				openXFSJBusinessInfo.getSignUpEndTime().getTime() < new Date().getTime(), "已经超过报名时间,不能支付");
		
		OpenXFSJInfo openXFSJInfo = openXFSJInfoMapper.selectByPrimaryKey(signUpInfo.getXfsjId());
		validator(openXFSJInfo == null, "活动信息不存在!");
		
		//获取社区结算信息
		CommunityPay communityPay = communityPayMapper.selectByPrimaryKey(openXFSJInfo.getCommunityId());
		validator(communityPay == null || StringUtils.isBlank(communityPay.getPayAccount()), "社区账户信息不存在");
		String account = communityPay.getPayAccount();
		//调用支付中心的支付接口进行支付
		String communityOutTradeNo = String.format("%s%d%s", Constant.OpenOrder.PAY_ACTIVITY_PREFIX,
				System.nanoTime(), RandomStringUtils.randomNumeric(10));
		
		logger.info("out_trade_no:{}", communityOutTradeNo);
		
		BigDecimal serviceFee = signUpInfo.getServiceFee();
		BigDecimal platformChargeRate = signUpInfo.getPlatformChargeRate();
		BigDecimal platformCharge = signUpInfo.getPlatformCharge();
		BigDecimal receiptAmount = signUpInfo.getReceiptAmount();

		DateTimeFormatter sf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime expireTime = LocalDateTime
				.parse(DateTimeUtils.formatDateTime(new Date(System.currentTimeMillis() + 1000L * 60 * 15)), sf);
		String title = openXFSJInfo.getActTitile() + "-综合服务费";

		// 保存订单信息
		OpenOrder openOrder = new OpenOrder();
		openOrder.setCommunityId(openXFSJInfo.getCommunityId().longValue());
		openOrder.setAccountId(account);
		openOrder.setAppId(rfpayAppId);
		openOrder.setBillCreateTime(new Date());
		openOrder.setBillStatus(1);
		openOrder.setBody(title);
		openOrder.setBussinessType(3);//1：正常交易单，2：保证金单,3活动缴费订单
		openOrder.setClientIp(HttpUtil.getIp2(request));
		openOrder.setCreateTime(new Date());
		openOrder.setDetail(title);
		openOrder.setExpireTime(null);
		openOrder.setGoodsDetail(null);
		openOrder.setPayChannel(payChannel);
		openOrder.setProjectType("活动缴费");
		// openOrder.setServiceStatus(1);
		openOrder.setSubject(title);
		openOrder.setTotalAmount(serviceFee);
		
		openOrder.setPlatformChargeRate(platformChargeRate);
		openOrder.setPlatformCharge(platformCharge);
		openOrder.setServiceChargeRate(new BigDecimal(0));
		
		openOrder.setTradeType("NATIVE");
		openOrder.setCommunityTradeNo(communityOutTradeNo);

		openOrder.setOutTradeNo(communityOutTradeNo);
		openOrder.setReceiptAmount(receiptAmount);
		openOrder.setType(OpenConstant.open_order.Type.activity);//1：正常交易单，2：保证金单,3活动缴费订单
		openOrder.setCautionId(id);//报名信息单id
		openOrder.setServiceId(serviceId);
		openOrderService.insertOpenOrder(openOrder);
		
		//调用返回billId
		String redirectUrl = openH5Url+ "/#/activityPaySuccess";
		
		FuPayQrCodeGenResponseModel model = this.createPrePay(openOrder, redirectUrl);
		openOrder.setBillId(model.getBillId());
		openOrderService.updateOpenOrderByPrimaryKey(openOrder);
		
		OpenOrderDetail record = new OpenOrderDetail();
		Long openOrderId = openOrder.getId();
		record.setId(openOrderId);
		record.setPayCreateResponse(JSON.toJSONString(model));
		openOrderDetailMapper.insertSelective(record);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("out_trade_no", communityOutTradeNo);
		jsonObject.put("billId", model.getBillId());
		jsonObject.put("redirect_url", model.getRedirectUrl());
		return Result.successData(jsonObject);
	}
	
	
	/**
	 * 渠道未知时, 扫码付预建单 FuPayQrCodeGenRequest
	 * 
	 *            订单
	 *            支付订单
	 */
	public FuPayQrCodeGenResponseModel createPrePay(OpenOrder openOrder, String redirectUrl) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MINUTE, 15);
		LocalDateTime expireTime = LocalDateTime.ofInstant(calendar.getTime().toInstant(), ZoneId.systemDefault());

		logger.info("redirectUrl={}", redirectUrl);
		ResponseData<FuPayQrCodeGenResponseModel> result = fuPayService.prePayCreate(rfpayAppId, rfpayAppSecret,
				openOrder.getAccountId(), openOrder.getCommunityTradeNo(), 
				openOrder.getTotalAmount().multiply(new BigDecimal("100")).longValue(),
				openOrder.getPlatformCharge().multiply(new BigDecimal("100")).longValue(),
				openOrder.getSubject(), openOrder.getBody(), openOrder.getClientIp(), null,
				expireTime, null, null, redirectUrl, null, null, null, null);
		if (result.getCode() == 1001) {
			return result.getData();
		} else if (9027 == result.getCode()) {
			return result.getData();
		} else {
			logger.error("创建支付订单出错, FuPayCreateResponseModel: " + JSON.toJSON(result));
			error("创建订单出错，FuPayCreateResponseModel原因为：" + JSON.toJSONString(result));
			return null;
		}
		
	}
}
