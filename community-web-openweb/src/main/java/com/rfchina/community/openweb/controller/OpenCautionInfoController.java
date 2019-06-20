package com.rfchina.community.openweb.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.rfchina.community.base.OpenConstant;
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
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.base.util.HttpUtil;
import com.rfchina.community.base.util.ValidatorUtil;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.component.SysMsgInfoComponent;
import com.rfchina.community.component.SysMsgInfoComponent.ObjectType;
import com.rfchina.community.openweb.service.FuPayService;
import com.rfchina.community.openweb.service.OpenWebOrderService;
import com.rfchina.community.persistence.mapper.OpenCautionInfoMapper;
import com.rfchina.community.persistence.mapper.OpenOrderDetailMapper;
import com.rfchina.community.persistence.model.CommunityServiceTemp;
import com.rfchina.community.persistence.model.OpenCautionInfo;
import com.rfchina.community.persistence.model.OpenCautionInfoExample;
import com.rfchina.community.persistence.model.OpenOrder;
import com.rfchina.community.persistence.model.OpenOrderDetail;
import com.rfchina.community.service.openser.OpenCautionInfoSerService;

//保证金
@RestController
@RequestMapping(value = { Constant.ROOT_PATH_OPENWEB + "/caution" })
public class OpenCautionInfoController extends BaseController {

	@Value("${rfpay.appId}")
	private long rfpayAppId;

	@Value("${rfpay.appSecret}")
	private String rfpayAppSecret;

	@Value("${rfpay.accountId}")
	private String rfpayAccountId;
	@Value("${open.h5.url}")
	private String openH5Url;

	@Autowired
	private SysMsgInfoComponent sysMsgInfoComponent;
	@Autowired
	private OpenCautionInfoSerService openCautionInfoSerService;
	@Autowired
	private OpenOrderDetailMapper openOrderDetailMapper;
	@Autowired
	private OpenCautionInfoMapper openCautionInfoMapper;
	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;
	@Autowired
	private OpenWebOrderService openOrderService;
	@Autowired
	private FuPayService fuPayService;

	@RequestMapping(value = { "/list_open_caution" })
	public Result<?> list_open_caution(@RequestParam(value = "serviceId", required = true) Integer serviceId) {
		authorityCheck(serviceId);
		JSONObject json = openCautionInfoSerService.cautionHandle(serviceId, false);
		return Result.successData(json);
	}

	@RequestMapping("/payment_caution_money2")
	@Transactional(rollbackFor = Exception.class)
	public Result<?> paymentCautionMoney2(@RequestParam("service_id") int serviceId, @RequestParam("id") Long id,
			// @RequestParam(value = "caution_money", required = false, defaultValue = "0")
			// String cautionMoney,
			@RequestParam("money_type") String money_type,
			@RequestParam(value = "money_pic", required = false, defaultValue = "") String cautionMoneyPic,

			@RequestParam(value = "pay_channel", required = false, defaultValue = "") String payChannel,
			HttpServletRequest request) {
		authorityCheck(serviceId);
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId(), "非法访问!");
		// if (StringUtils.isBlank(Constant.OpenAdmin.CautionMoneyType.translate(type)))
		// {
		// error("保证金类别不正确，只能为线上或线下");
		// }

		validator(!"qrcode".equals(money_type) && !"pic".equals(money_type), "保证金类别不正确，只能为线上或线下");

		OpenCautionInfo caution = openCautionInfoMapper.selectByPrimaryKey(id);
		validator(caution == null, "数据不存在!");
		validator(caution.getServiceId() != serviceId, "非法访问!");
		// '1,待缴纳,2,已线上缴纳,3线下缴纳待核验,4已线下缴纳,5隐藏,6已退'
		validator(caution.getStatus() != 1 && caution.getStatus() != 3, "该笔保证金非待缴状态!");

		// 判断保证金类别
		if ("qrcode".equals(money_type)) {
			validator(StringUtils.isBlank(payChannel), "线上支付时，支付渠道不能为空");

			//
			long feeAmount = 0;
			// 如果是线上支付的，则调用支付中心的支付接口进行支付
			String communityOutTradeNo = String.format("%s%d%s", Constant.OpenOrder.PAY_CAUTION_PREFIX,
					System.nanoTime(), RandomStringUtils.randomNumeric(10));
			BigDecimal cautionMoney = caution.getMoney();

			DateTimeFormatter sf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime expireTime = LocalDateTime
					.parse(DateTimeUtils.formatDateTime(new Date(System.currentTimeMillis() + 1000L * 60 * 6)), sf);
			String ip=HttpUtil.getIp2(request);
			ResponseData<FuPayCreateResponseModel> responseData = platformGlobalComponent.fuPayCreate(rfpayAccountId,
					payChannel, communityOutTradeNo, cautionMoney.multiply(new BigDecimal("100")).longValue(),
					feeAmount, communityServiceTemp.getTitle() + "服务的保证金", communityServiceTemp.getTitle() + "服务的保证金",
					communityServiceTemp.getTitle() + "服务的保证金",ip, 2, expireTime, "保证金", "NATIVE",
					null, null);

			if (responseData.getCode() == 1001) {
				// 保存订单信息

				OpenOrder openOrder = new OpenOrder();
				openOrder.setAccountId(rfpayAccountId);
				openOrder.setAppId(rfpayAppId);
				Date billCreate = responseData.getData().getCreateTime();
				openOrder.setBillCreateTime(billCreate);
				String billId = responseData.getData().getBillId();
				openOrder.setBillId(billId);
				openOrder.setBillStatus(1);
				openOrder.setBody(communityServiceTemp.getTitle() + "服务的保证金");
				openOrder.setBussinessType(2);
				openOrder.setClientIp(ip);
				openOrder.setCreateTime(responseData.getData().getCreateTime());
				openOrder.setDetail(communityServiceTemp.getTitle() + "服务的保证金");
				openOrder.setExpireTime(null);
				openOrder.setGoodsDetail(null);
				openOrder.setPayChannel(payChannel);
				openOrder.setProjectType("保证金");
				// openOrder.setServiceStatus(1);
				openOrder.setSubject(communityServiceTemp.getTitle() + "服务的保证金");
				openOrder.setTotalAmount(cautionMoney);
				openOrder.setTradeType("NATIVE");
				openOrder.setCommunityTradeNo(communityOutTradeNo);

				openOrder.setOutTradeNo(communityOutTradeNo);
				openOrder.setReceiptAmount(cautionMoney);
				openOrder.setType(OpenConstant.open_order.Type.caution);
				openOrder.setCautionId(id);
				openOrder.setServiceId(serviceId);
				openOrderService.insertOpenOrder(openOrder);
				
				OpenOrderDetail record = new OpenOrderDetail();
				record.setId(openOrder.getId());
				record.setPayCreateResponse(JSON.toJSONString(responseData.getData()));
				openOrderDetailMapper.insertSelective(record);
				// 修改服务信息
				// communityServiceTemp.setCautionBillId(responseData.getData().getBillId());
				// communityServiceService.updateCommunityServiceTemp(communityServiceTemp);

				//
				// 不用在这里修改,因为还不知道真的交款,在确定交款后在修改,后面通过id在直接修改.
				// OpenCautionInfo record = new OpenCautionInfo();
				// record.setBillCreateTime(billCreate);
				// record.setBillId(billId);
				// record.setBillStatus(1);
				// record.setMoneyType(money_type);
				// OpenCautionInfoExample example = new OpenCautionInfoExample();
				// example.createCriteria().andIdEqualTo(id).andServiceIdEqualTo(serviceId);
				// openCautionInfoMapper.updateByExampleSelective(record, example);
				return Result.successData(responseData.getData());
			} else {
				error("支付失败" + JSON.toJSONString(responseData));
			}

		}
		if ("pic".equals(money_type)) {
			if (StringUtils.isBlank(cautionMoneyPic)) {
				error("线下支付时，保证金转账图片不能为空");
			}
			ValidatorUtil.matchesImage(cautionMoneyPic, "图片", true);
			// communityServiceTemp.setCautionMoneyPic(cautionMoneyPic);
			// 修改服务信息
			// communityServiceService.updateCommunityServiceTemp(communityServiceTemp);
			//
			// CommunityService communityServiceInfo = new CommunityService();
			// communityServiceInfo.setId(serviceId);
			// communityServiceInfo.setCautionMoneyPic(cautionMoneyPic);
			// communityServiceInfo.setCautionMoneyType(type);
			// communityServiceService.updateCommunityService(communityServiceInfo);
			//
			// '1,待缴纳,2,已线上缴纳,3线下缴纳待核验,4已线下缴纳,5隐藏,6已退'
			OpenCautionInfo record = new OpenCautionInfo();
			record.setMoneyPic(cautionMoneyPic);
			record.setStatus(3);
			record.setMoneyType(money_type);

			OpenCautionInfoExample example = new OpenCautionInfoExample();
			example.createCriteria().andIdEqualTo(id).andServiceIdEqualTo(serviceId);
			openCautionInfoMapper.updateByExampleSelective(record, example);

			List<String> parameter = new ArrayList<>();
			parameter.add(communityServiceTemp.getTitle());
			sysMsgInfoComponent.addPlatform(ObjectType.open_caution_money_pic, serviceId + "", parameter);
		}

		return Result.success();
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 直接调起微信支付
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/xfsj/payment_caution_money")
	@Transactional(rollbackFor = Exception.class)
	public Result<?> xfsjPaymentCautionMoney(
			@RequestParam("service_id") int serviceId,
			@RequestParam("id") Long id,
			@RequestParam(value = "pay_channel", required = true, defaultValue = "") String payChannel,
			HttpServletRequest request) {
		authorityCheck(serviceId);
		CommunityServiceTemp communityServiceTemp = communityServiceService
				.getCommunityServiceTempByPrimaryKey(serviceId);
		validator(communityServiceTemp == null, "此服务信息不存在");
		validator(communityServiceTemp.getMerchantId().longValue() != getAdminId(), "非法访问!");

		OpenCautionInfo caution = openCautionInfoMapper.selectByPrimaryKey(id);
		validator(caution == null, "数据不存在!");
		
		validator(caution.getServiceId() != serviceId, "非法访问!");
		// '1,待缴纳,2,已线上缴纳,3线下缴纳待核验,4已线下缴纳,5隐藏,6已退'
		validator(caution.getStatus() != 1 && caution.getStatus() != 3, "该笔保证金非待缴状态!");

		// 判断保证金类别
		validator(StringUtils.isBlank(payChannel), "线上支付时，支付渠道不能为空");

		//
		String communityOutTradeNo = String.format("%s%d%s", Constant.OpenOrder.PAY_CAUTION_PREFIX,
				System.nanoTime(), RandomStringUtils.randomNumeric(10));
		BigDecimal cautionMoney = caution.getMoney();

		// 保存订单信息
		OpenOrder openOrder = new OpenOrder();
		openOrder.setAccountId(rfpayAccountId);
		openOrder.setAppId(rfpayAppId);
		openOrder.setBillCreateTime(new Date());
		openOrder.setBillStatus(1);
		openOrder.setBody(communityServiceTemp.getTitle() + "服务的保证金");
		openOrder.setBussinessType(2);
		openOrder.setClientIp(HttpUtil.getIp2(request));
		openOrder.setCreateTime(new Date());
		openOrder.setDetail(communityServiceTemp.getTitle() + "服务的保证金");
		openOrder.setExpireTime(null);
		openOrder.setGoodsDetail(null);
		openOrder.setPayChannel(payChannel);
		openOrder.setProjectType("保证金");
		// openOrder.setServiceStatus(1);
		openOrder.setSubject(communityServiceTemp.getTitle() + "服务的保证金");
		openOrder.setTotalAmount(cautionMoney);
		openOrder.setTradeType("NATIVE");
		openOrder.setCommunityTradeNo(communityOutTradeNo);

		openOrder.setOutTradeNo(communityOutTradeNo);
		openOrder.setReceiptAmount(cautionMoney);
		openOrder.setType(OpenConstant.open_order.Type.caution);
		openOrder.setCautionId(id);
		openOrder.setServiceId(serviceId);
		openOrderService.insertOpenOrder(openOrder);
		
		//调用返回billId
		String redirectUrl = openH5Url+ "/index.html#/cautionPaySuccess/" + openOrder.getId();
		
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
	 * @param order
	 *            订单
	 * @param payOrder
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
				0L,
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
