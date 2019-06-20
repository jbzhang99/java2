package com.rfchina.community.service.openser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.api.request.pay.FuPayCreateRequest;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.pay.FuPayCreateResponseModel;
import com.rfchina.api.response.model.pay.FuPayQrCodeGenResponseModel;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.component.IdComponent;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.mapper.open.OpenFeeOrderGlobalMapper;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.persistence.model.ext.ExtOpenFeeOrder;
import com.rfchina.community.service.BaseService;
import com.rfchina.community.service.openser.entity.FeeGoodsDetails;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
public class OpenFeeOrderService extends BaseService {

	private static Logger logger = LoggerFactory.getLogger(OpenFeeOrderService.class);
	@Autowired
	private OpenStoreOrderMapper openStoreOrderMapper;
	@Autowired
	private OpenOrderMapper openOrderMapper;
	@Autowired
	private OpenFeeOrderMapper openfeeOrderMapper;

	@Autowired
	private CommunityMapper communityMapper;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;

	@Autowired
	private OpenFeeOrderPayMapper openfeeOrderPayMapper;
	@Autowired
	private OpenFeeOrderRelaMapper openfeeOrderRelaMapper;

	@Autowired
	private OpenFeeOrderGlobalMapper openFeeOrderGlobalMapper;

	@Autowired
	private CommunityPayMapper communityPayMapper;

	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;

	@Autowired
	private OpenOrderDetailMapper openOrderDetailMapper;
	@Autowired
	private IdComponent idComponent;
	// public enum PayStatus {
	// NO_PAYMENT(0, "未支付"), PAY(1, "已支付");
	//
	// }

	public enum PayType {
		online, img
	}

	public enum PayStatus {
		auditing, init, success, reject, scan, outtime
	}

	public enum Ordertype {
		platform, order
	}

	public enum OrderPayStatus {
		init, success, auditing, reject, no_need_audit
	}

	private List<OpenFeeOrder> checkIds(List<Long> ids, Integer service_id) {
		OpenFeeOrderExample example = new OpenFeeOrderExample();
		example.createCriteria().andIdIn(ids);
		List<OpenFeeOrder> list = openfeeOrderMapper.selectByExample(example);
		Integer comId = 0;
		for (OpenFeeOrder openFeeOrder : list) {
			validator(openFeeOrder.getServiceId().intValue() != service_id.intValue(),
					"有订单不属于该商家" + openFeeOrder.getId());
			OrderPayStatus ps = OrderPayStatus.valueOf(openFeeOrder.getPayStatus());
			validator(OrderPayStatus.no_need_audit.compareTo(ps) == 0, "无需支付 " + openFeeOrder.getId());
			validator(OrderPayStatus.success.compareTo(ps) == 0, "已缴纳 " + openFeeOrder.getId());
			validator(OrderPayStatus.auditing.compareTo(ps) == 0, "缴纳待确认,请等待结果" + openFeeOrder.getId());
			validator(comId != 0 && comId != openFeeOrder.getCommunityId(), "只能缴费同一个社区的订单" + openFeeOrder.getId());
			comId = openFeeOrder.getCommunityId();
			validator(openFeeOrder.getPayAmount().compareTo(BigDecimal.valueOf(0L)) < 1,
					"支付金额必须大于0,订单ID:" + openFeeOrder.getId());
		}
		return list;
	}

	public OpenOrder getOpenOrder(Integer serviceId, String OutTradeNo) {
		OpenOrderExample example = new OpenOrderExample();
		example.createCriteria().andServiceIdEqualTo(serviceId).andOutTradeNoEqualTo(OutTradeNo);
		List<OpenOrder> list = openOrderMapper.selectByExample(example);
		validator(list.isEmpty(), "支付单不存在," + serviceId + "_" + OutTradeNo);
		validator(list.size() != 1, "支付单数量错误," + serviceId + "_" + OutTradeNo);
		return list.get(0);
	}

	public void countStoreOrderId(Integer id) {
		OpenFeeOrderExample example = new OpenFeeOrderExample();
		example.createCriteria().andStoreOrderIdEqualTo(id);
		validator(openfeeOrderMapper.countByExample(example) > 0, "已经有核销记录!" + id);
	}

	private List<FeeGoodsDetails> parseFeeGoodsDetails(String goods_detail) {
		List<FeeGoodsDetails> list = null;
		try {
			list = JSON.parseArray(goods_detail, FeeGoodsDetails.class);
		} catch (com.alibaba.fastjson.JSONException e) {
			logger.error(goods_detail, e);
			validator(true, "商品明细数据转换出错,请重新输入");
		}
		for (FeeGoodsDetails feeGoodsDetails : list) {
			feeGoodsDetails.setPrice(feeGoodsDetails.getPrice().setScale(2,BigDecimal.ROUND_HALF_UP));
		}
		return list;
	}

	public BigDecimal sumPrice(List<FeeGoodsDetails> list) {
		BigDecimal sum = new BigDecimal(0);
		// List<FeeGoodsDetails> list = parseFeeGoodsDetails(goods_detail);

		for (FeeGoodsDetails feeGoodsDetails : list) {
			validator(feeGoodsDetails.getUnit() <= 0, feeGoodsDetails.getTitle() + "的数量必须大于0");
			sum = sum.add(feeGoodsDetails.getPrice().multiply(BigDecimal.valueOf(feeGoodsDetails.getUnit())));
		}
		sum = sum.setScale(2,BigDecimal.ROUND_HALF_UP);
		validator(sum.compareTo(BigDecimal.valueOf(0)) <= 0, "总的交易金额必须大于0");
		return sum;
	}

	// openweb 只用 增加
	public OpenFeeOrderWithBLOBs storeOrderVerifyPre(int serviceId, Integer storeOrderId, String goodsDetail,
			boolean pre) {
		List<FeeGoodsDetails> lst = parseFeeGoodsDetails(goodsDetail);

		BigDecimal sumPrice = sumPrice(lst);
		OpenStoreOrder storeOrder = openStoreOrderMapper.selectByPrimaryKey(storeOrderId);
		validator(storeOrder == null, "订单不存在");
		validator(storeOrder.getServiceId().intValue() != serviceId, "非法访问!");
		String OutTradeNo = storeOrder.getOutTradeNo();
		validator(StringUtils.isBlank(OutTradeNo), "支付单的订单号不存在!");
		countStoreOrderId(storeOrderId);
		OpenOrder openOrder = getOpenOrder(serviceId, OutTradeNo);
		BigDecimal platformChargeRate = openOrder.getPlatformChargeRate() == null ? BigDecimal.valueOf(0)
				: openOrder.getPlatformChargeRate();
		BigDecimal serviceChargeRate = openOrder.getServiceChargeRate() == null ? BigDecimal.valueOf(0)
				: openOrder.getServiceChargeRate();
		BigDecimal platformCharge = (sumPrice.multiply(platformChargeRate)).divide(BigDecimal.valueOf(100)).setScale(2,BigDecimal.ROUND_HALF_UP);
		BigDecimal serviceCharge = (sumPrice.multiply(serviceChargeRate)).divide(BigDecimal.valueOf(100)).setScale(2,BigDecimal.ROUND_HALF_UP);
		BigDecimal payAmount = platformCharge.add(serviceCharge).setScale(2,BigDecimal.ROUND_HALF_UP);
		Integer communityId = storeOrder.getCommunityId().intValue();
		validator(payAmount.compareTo(BigDecimal.valueOf(0)) < 0, "平台服务费为负数,请联系平台解决!" + storeOrderId);
		if (payAmount.compareTo(BigDecimal.valueOf(0)) > 0) {
			// 平台 1 社区0的情况
			validator(serviceCharge.compareTo(BigDecimal.valueOf(0)) <= 0, "核销失败，平台服务费异常，请联系平台解决!" + storeOrderId);
		}
		String payStatus = "init";
		if (payAmount.compareTo(BigDecimal.valueOf(0)) == 0) {
			payStatus = "no_need_audit";
		}
		OpenFeeOrderWithBLOBs feeOrder = new OpenFeeOrderWithBLOBs();
		feeOrder.setOrderNo(OutTradeNo);
		feeOrder.setTradeAmount(sumPrice);
		feeOrder.setPayAmount(payAmount);
		feeOrder.setPlatformCharge(platformCharge);
		feeOrder.setServiceCharge(serviceCharge);
		feeOrder.setCommunityId(communityId);
		feeOrder.setServiceId(serviceId);
		feeOrder.setPlatformChargeRate(platformChargeRate);
		feeOrder.setServiceChargeRate(serviceChargeRate);
		feeOrder.setGoodsDetail(JSON.toJSONString(lst));
		feeOrder.setCreateTime(new Date());
		feeOrder.setOrderExplain("");
		feeOrder.setPayStatus(payStatus);
		feeOrder.setStoreOrderId(storeOrderId);
		feeOrder.setType("order");
		if (!pre) {

			// 没有定需求 所以不乘坐
			// String verifyNo=DateTimeUtils.format(new Date(),
			// "yyMMddHHmmss")+idComponent.idByLength(5);
			// feeOrder.setVerifyNo(verifyNo);
			openfeeOrderMapper.insertSelective(feeOrder);
			OpenStoreOrder record = new OpenStoreOrder();
			record.setId(storeOrderId);
			record.setVerifyStatus("verified");
			openStoreOrderMapper.updateByPrimaryKeySelective(record);
		}
		return feeOrder;
	}

	public PageList<ExtOpenFeeOrder> openFeeOrderList(Map<String, Object> example, PageBounds pageBounds) {
		return openFeeOrderGlobalMapper.pageByExample(example, pageBounds);
	}

	public int updateOpenFeeBySalesContract(Long id, String salesContract, int serviceId) {

		OpenFeeOrderWithBLOBs data = openfeeOrderMapper.selectByPrimaryKey(id);
		validator(data == null, "数据为空" + id);
		validator(data.getServiceId().intValue() != serviceId, "非法访问" + id);
		if (StringUtils.isNotBlank(salesContract)) {
			String[] links = salesContract.split(",");
			validator(links.length > 9, "只能9张");
			for (String link : links) {
				validator(!link.startsWith("http"), "合同链接不合法" + link);
			}
		}

		OpenFeeOrderWithBLOBs record = new OpenFeeOrderWithBLOBs();
		record.setId(id);
		record.setSalesContract(salesContract);
		return openfeeOrderMapper.updateByPrimaryKeySelective(record);
	}

	public Long payImgLink(String ids, Integer service_id, String imgLink) {
		List<Long> listId = trunId(ids);
		List<OpenFeeOrder> list = checkIds(listId, service_id);
		validator(!imgLink.startsWith("http"), "链接不合法" + imgLink);
		BigDecimal payAmount = new BigDecimal(0);
		BigDecimal platformCharge = new BigDecimal(0);
		BigDecimal serviceCharge = new BigDecimal(0);
		Integer communityId = 0;
		for (OpenFeeOrder openFeeOrder : list) {
			payAmount = payAmount.add(openFeeOrder.getPayAmount());
			platformCharge = platformCharge.add(openFeeOrder.getPlatformCharge());
			serviceCharge = serviceCharge.add(openFeeOrder.getServiceCharge());
			communityId = openFeeOrder.getCommunityId();
		}
		String communityOutTradeNo = communityOutTradeNo();

		OpenFeeOrderPay record = new OpenFeeOrderPay();
		record.setCreateTime(new Date());
		record.setImgLink(imgLink);
		record.setPayType(PayType.img.name());
		record.setServiceId(service_id);
		record.setCommunityId(communityId);
		record.setPayStatus(PayStatus.auditing.name());
		record.setPayAmount(payAmount);
		record.setRejectReason("");
		record.setOutTradeNo(communityOutTradeNo);
		record.setPlatformCharge(platformCharge);
		record.setServiceCharge(serviceCharge);
		openfeeOrderPayMapper.insertSelective(record);
		Long payId = record.getId();
		for (Long id : listId) {
			OpenFeeOrderRelaKey key = new OpenFeeOrderRelaKey();
			key.setFeeId(id);
			key.setPayId(payId);
			openfeeOrderRelaMapper.insertSelective(key);
			OpenFeeOrderWithBLOBs order = new OpenFeeOrderWithBLOBs();
			order.setId(id);
			order.setPayStatus(OrderPayStatus.auditing.name());
			order.setPayId(payId);
			openfeeOrderMapper.updateByPrimaryKeySelective(order);
		}

		return payId;
	}

	private List<Long> trunId(String ids) {
		List<Long> lid = new ArrayList<>();
		for (String id : ids.split(",")) {
			lid.add(Long.valueOf(id));
		}
		return lid;
	}

	private String communityOutTradeNo() {
		return Constant.OpenOrder.PAY_FEE_PREFIX + DateTimeUtils.format(new Date(), "yyMMddHHmm")
				+ idComponent.idByLength(5);
	}

	public Object payByOnline(String ids, Integer service_id, String payChannel, String ip, String redirectUrl) {
		List<Long> listId = trunId(ids);
		List<OpenFeeOrder> list = checkIds(listId, service_id);

		BigDecimal payAmount = new BigDecimal(0);
		BigDecimal platformCharge = new BigDecimal(0);
		BigDecimal serviceCharge = new BigDecimal(0);
		Integer communityId = 0;
		for (OpenFeeOrder openFeeOrder : list) {
			payAmount = payAmount.add(openFeeOrder.getPayAmount());
			platformCharge = platformCharge.add(openFeeOrder.getPlatformCharge());
			serviceCharge = serviceCharge.add(openFeeOrder.getServiceCharge());
			communityId = openFeeOrder.getCommunityId();
		}
		// 获取社区信息
		CommunityPay communityPay = communityPayMapper.selectByPrimaryKey(communityId);
		validator(communityPay == null || StringUtils.isBlank(communityPay.getPayAccount()), "社区账户信息不存在");
		String account = communityPay.getPayAccount();

		// 调用支付中心的支付接口进行支付
		String communityOutTradeNo = communityOutTradeNo();
		BigDecimal receiptAmount = payAmount.subtract(platformCharge);

		Date expire = new Date(System.currentTimeMillis() + 1000L * 60 * 15);
		String title = "服务费订单";
		String projectType = "活动缴费";
		String tradeType = "NATIVE";
		// 保存订单信息
		OpenOrder openOrder = new OpenOrder();
		openOrder.setCommunityId(communityId.longValue());
		openOrder.setAccountId(account);
		// openOrder.setAppId(rfpayAppId);
		openOrder.setBillStatus(1);
		openOrder.setBussinessType(5);// 1：正常交易单，2：保证金单,3活动缴费订单
		openOrder.setClientIp(ip);
		openOrder.setSubject(title);
		openOrder.setBody(title);
		openOrder.setDetail(title);
		openOrder.setExpireTime(expire);
		openOrder.setGoodsDetail(null);
		openOrder.setPayChannel(payChannel);
		openOrder.setBillCreateTime(new Date());
		openOrder.setCreateTime(new Date());
		openOrder.setProjectType(projectType);
		openOrder.setServiceChargeRate(new BigDecimal(0));
		openOrder.setServiceCharge(serviceCharge);
		openOrder.setTotalAmount(payAmount);
		openOrder.setPlatformChargeRate(new BigDecimal(0));
		openOrder.setPlatformCharge(platformCharge);
		openOrder.setTradeType(tradeType);
		openOrder.setCommunityTradeNo(communityOutTradeNo);
		openOrder.setOutTradeNo(communityOutTradeNo);
		openOrder.setReceiptAmount(receiptAmount);
		openOrder.setType(OpenConstant.open_order.Type.verify); // 1：正常交易单，2：保证金单,3活动缴费订单
		openOrder.setServiceId(service_id);

		ResponseData<?> data = null;
		String sysRedirectUrl = null;
		String billId = null;
		if (StringUtils.isBlank(redirectUrl)) {
			data = createPay(openOrder);
			FuPayCreateResponseModel model = (FuPayCreateResponseModel) data.getData();
			Date billCreate = model.getCreateTime();
			billId = model.getBillId();
			openOrder.setBillId(billId);
			openOrder.setBillCreateTime(billCreate);
			openOrder.setCreateTime(billCreate);
		} else {
			data = createPrePay(openOrder, redirectUrl);
			FuPayQrCodeGenResponseModel model = (FuPayQrCodeGenResponseModel) data.getData();
			billId = model.getBillId();
			sysRedirectUrl = model.getRedirectUrl();
			openOrder.setBillCreateTime(new Date());
			openOrder.setBillId(billId);

		}

		openOrderMapper.insertSelective(openOrder);
		OpenOrderDetail detail = new OpenOrderDetail();
		Long openId = openOrder.getId();
		detail.setId(openId);
		detail.setPayCreateResponse(JSON.toJSONString(data.getData()));
		openOrderDetailMapper.insertSelective(detail);

		OpenFeeOrderPay record = new OpenFeeOrderPay();
		record.setCreateTime(new Date());
		record.setPayType(PayType.online.name());
		record.setServiceId(service_id);
		record.setPayStatus(PayStatus.init.name());
		record.setPayAmount(payAmount);
		record.setOpenId(openId);
		record.setBillId(billId);
		record.setPayChannel(payChannel);
		record.setCommunityId(communityId);
		record.setOutTradeNo(communityOutTradeNo);
		record.setPlatformCharge(platformCharge);
		record.setServiceCharge(serviceCharge);
		record.setRejectReason("");
		openfeeOrderPayMapper.insertSelective(record);
		Long payId = record.getId();
		for (Long id : listId) {
			OpenFeeOrderRelaKey key = new OpenFeeOrderRelaKey();
			key.setFeeId(id);
			key.setPayId(payId);
			openfeeOrderRelaMapper.insertSelective(key);
			// 这里不需要管理订单,可以多少支付,已经和产品沟通过可以的
		}

		if (StringUtils.isBlank(redirectUrl)) {
			return Result.successData(data.getData());
		} else {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("out_trade_no", communityOutTradeNo);
			jsonObject.put("billId", billId);
			jsonObject.put("redirect_url", sysRedirectUrl);
			return Result.successData(jsonObject);
		}

	}

	private ResponseData<?> createPay(OpenOrder openOrder) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(openOrder.getExpireTime());
		LocalDateTime expireTime = LocalDateTime.ofInstant(calendar.getTime().toInstant(), ZoneId.systemDefault());

		ResponseData<FuPayCreateResponseModel> responseData = platformGlobalComponent.fuPayCreate(
				openOrder.getAccountId(), openOrder.getPayChannel(), openOrder.getCommunityTradeNo(),
				openOrder.getTotalAmount().multiply(new BigDecimal("100")).longValue(),
				openOrder.getPlatformCharge().multiply(new BigDecimal("100")).longValue(), openOrder.getSubject(),
				openOrder.getBody(), openOrder.getDetail(), openOrder.getClientIp(), 2, expireTime,
				openOrder.getProjectType(), openOrder.getTradeType(), null, new FuPayCreateRequest.GoodsDetail[] {});
		if (responseData.getCode() != 1001) {
			error("支付失败_" + JSON.toJSONString(responseData));
		}
		return responseData;
	}

	private ResponseData<?> createPrePay(OpenOrder openOrder, String redirectUrl) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(openOrder.getExpireTime());
		LocalDateTime expireTime = LocalDateTime.ofInstant(calendar.getTime().toInstant(), ZoneId.systemDefault());

		logger.info("redirectUrl={}", redirectUrl);
		ResponseData<FuPayQrCodeGenResponseModel> result = platformGlobalComponent.prePayCreate(
				openOrder.getAccountId(), openOrder.getCommunityTradeNo(),
				openOrder.getTotalAmount().multiply(new BigDecimal("100")).longValue(),
				openOrder.getPlatformCharge().multiply(new BigDecimal("100")).longValue(), openOrder.getSubject(),
				openOrder.getBody(), openOrder.getClientIp(), null, expireTime, null, null, redirectUrl, null, null,
				null, null);
		if (result.getCode() == 1001) {
			return result;
		} else if (9027 == result.getCode()) {
			return result;
		} else {
			logger.error("创建支付订单出错, FuPayCreateResponseModel: " + JSON.toJSON(result));
			error("创建订单出错， " + JSON.toJSONString(result));
		}
		return result;

	}

	// 审批
	public int updatePayStatus(Long pay_id, String status, String rejectReason, Long auditUid, String auditPhone,
			String auditName) {
		OpenFeeOrderPay pay = openfeeOrderPayMapper.selectByPrimaryKey(pay_id);
		validator(pay == null, "支付单不存在" + pay_id);

		OpenFeeOrderPay record = new OpenFeeOrderPay();
		record.setId(pay_id);
		record.setPayStatus(PayStatus.valueOf(status).name());
		record.setAuditName(auditName);
		record.setAuditPhone(auditPhone);
		record.setAuditUid(auditUid);
		record.setAuditTime(new Date());

		if (PayStatus.valueOf(status).compareTo(PayStatus.success) == 0) {
			record.setPayTime(new Date());
		}
		if (PayStatus.valueOf(status).compareTo(PayStatus.reject) == 0) {
			validator(StringUtils.isBlank(rejectReason), "驳回必须填写原因");
			record.setRejectReason(rejectReason);
		}

		OpenFeeOrderRelaExample exle = new OpenFeeOrderRelaExample();
		exle.createCriteria().andPayIdEqualTo(pay_id);
		List<OpenFeeOrderRelaKey> list = openfeeOrderRelaMapper.selectByExample(exle);
		for (OpenFeeOrderRelaKey key : list) {
			OpenFeeOrderWithBLOBs rd = new OpenFeeOrderWithBLOBs();
			rd.setId(key.getFeeId());
			rd.setPayStatus(status);
			openfeeOrderMapper.updateByPrimaryKeySelective(rd);
		}

		return openfeeOrderPayMapper.updateByPrimaryKeySelective(record);

	}

	public Object feeStoreOrderAddPf(int serviceId, BigDecimal tradeAmount, BigDecimal platformCharge,
			BigDecimal serviceCharge, int communityId, String orderExplain) {
		validator(tradeAmount.compareTo(platformCharge.add(serviceCharge)) < 0, "必须 线下交易金额>=平台手续费+社区服务费");
		validator(serviceCharge.compareTo(BigDecimal.valueOf(0)) < 0, "必须 社区服务费 大于0 ");
		validator(platformCharge.compareTo(BigDecimal.valueOf(0)) < 0, "必须 平台手续费 大于等于0 ");
		validator(tradeAmount.compareTo(BigDecimal.valueOf(0)) < 0, "必须 线下交易金额 大于0 ");
		validator(StringUtils.isBlank(orderExplain), "收费说明 必须输入");
		BigDecimal payAmount = platformCharge.add(serviceCharge);
		String payStatus = "init";
		if (payAmount.compareTo(BigDecimal.valueOf(0)) == 0) {
			payStatus = "no_need_audit";
		}
		OpenFeeOrderWithBLOBs feeOrder = new OpenFeeOrderWithBLOBs();
		feeOrder.setOrderNo("");
		feeOrder.setTradeAmount(tradeAmount);
		feeOrder.setPayAmount(payAmount);
		feeOrder.setPlatformCharge(platformCharge);
		feeOrder.setServiceCharge(serviceCharge);
		feeOrder.setCommunityId(communityId);
		feeOrder.setServiceId(serviceId);
		feeOrder.setPlatformChargeRate(BigDecimal.valueOf(0));
		feeOrder.setServiceChargeRate(BigDecimal.valueOf(0));
		feeOrder.setGoodsDetail("");
		feeOrder.setCreateTime(new Date());
		feeOrder.setOrderExplain(orderExplain);
		feeOrder.setPayStatus(payStatus);
		feeOrder.setStoreOrderId(0);
		feeOrder.setType(Ordertype.platform.name());

		// 没有定需求 所以不乘坐
		// String verifyNo=DateTimeUtils.format(new Date(),
		// "yyMMddHHmmss")+idComponent.idByLength(5);
		// feeOrder.setVerifyNo(verifyNo);
		openfeeOrderMapper.insertSelective(feeOrder);

		return feeOrder;

	}

	public JSONObject getOpenFeeOrderInfo(Long id, Integer service_id) {
		OpenFeeOrderWithBLOBs order = openfeeOrderMapper.selectByPrimaryKey(id);

		validator(order == null, "数据不存在!" + id);
		if (service_id > 0) {
			validator(order.getServiceId().intValue() != service_id.intValue(), "非法访问" + id);
		}

		OpenFeeOrderPay pay = null;
		if (order.getPayId() != null) {
			pay = openfeeOrderPayMapper.selectByPrimaryKey(order.getPayId());
		} else {
			pay = new OpenFeeOrderPay();

		}

		Community community = communityMapper.selectByPrimaryKey(order.getCommunityId());
		if (community == null) {
			community = new Community();
		}

		CommunityService cs = communityServiceMapper.selectByPrimaryKey(order.getServiceId());
		if (cs == null) {
			cs = new CommunityService();
			cs.setMerchantId(0L);
		}

		OpenMerchantInfo merch = openMerchantInfoMapper.selectByPrimaryKey(cs.getMerchantId());
		if (merch == null) {
			merch = new OpenMerchantInfo();
		}
		JSONObject json = new JSONObject();
		json.put("info", order);
		json.put("pay", pay);
		json.put("communityName", community.getName());
		json.put("communityCityName", community.getCityName());
		json.put("serviceTitle", cs.getTitle());
		json.put("merchantTitle", merch.getTitle());

		return json;
	}

}
