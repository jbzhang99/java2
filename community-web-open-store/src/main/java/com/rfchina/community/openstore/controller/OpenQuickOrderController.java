package com.rfchina.community.openstore.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.openapi.ExtAppMoneyBase;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.component.IdComponent;
import com.rfchina.community.openstore.service.*;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.OpenQuickOrder;
import com.rfchina.community.service.openser.CmStoreCouponRecordService;
import com.rfchina.community.service.openser.OpenQuickOrderSerService;
import com.rfchina.platform.common.http.HttpUtil;
import com.rfchina.platform.common.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENSTORE)
public class OpenQuickOrderController extends BaseController {

	@Value("${zizai.server.url}")
	private String serverUrl;
	@Value("${zizai.open.api.url}")
	private String openApiServer;

	@Autowired
	private CommunityServiceService communityServiceService;
	@Autowired
	private IdComponent idComponent;

	@Autowired
	private OpenQuickOrderSerService openQuickOrderSerService;
	@Autowired
	private OpenStoreServiceDiscountService openStoreServiceDiscountService;
	@Autowired
	private CmOpenStoreCouponService cmOpenStoreCouponService;
	@Autowired
	private OpenQuickOrderService openQuickOrderService;
	@Autowired
	private CmStoreCouponRecordService cmStoreCouponRecordService;
	@Autowired
	private WeixinService weixinService ;

	@RequestMapping(value = { "/quick_order_create" })
	@ResponseBody
	public Result<?> mutiOrderCreate(
			@RequestParam(value = "communityId", required = true, defaultValue = "0") Integer communityId,
			@RequestParam(value = "totalMoney", required = true, defaultValue = "0") BigDecimal totalMoney,
//			@RequestParam(value = "subtractMoney", required = true, defaultValue = "0") BigDecimal subtractMoney,
			@RequestParam(value = "realMoney", required = true, defaultValue = "0") BigDecimal realMoney,
			@RequestParam(value = "couponId", required = false, defaultValue = "0") Long couponId,
			@RequestParam(value = "serviceId", required = true, defaultValue = "0") Integer serviceId,
			@RequestParam(value = "clientType", required = false, defaultValue = "APP") String clientType,
			@RequestParam(value = "access_token", required = false) String accessToken, HttpServletRequest request) {
		validator(serviceId <= 0, "服务ID必须大于0");
		Long uid = validateAndGetUid(clientType, accessToken);
		validator(realMoney.compareTo(BigDecimal.valueOf(0L)) <= 0, "实付金额必须大于0");
		OpenQuickOrder order = new OpenQuickOrder();
		// 1初始化,2支付成功,3放弃支付
		order.setBillStatus(1);
		order.setCommunityId(communityId);
		order.setCouponId(couponId);
		order.setTotalMoney(totalMoney);
		order.setRealMoney(realMoney);
		order.setUid(uid);
		order.setServiceId(serviceId);
		order.setCreateTime(new Date());
		validator(totalMoney.compareTo(BigDecimal.valueOf(0L)) <= 0, "消费金额必须大于0");
		validator(realMoney.compareTo(BigDecimal.valueOf(0L)) <= 0, "实付金额必须大于0");

		// 满减金额
		BigDecimal subtractMoney = openStoreServiceDiscountService.getDiscountPrice(totalMoney, serviceId);
		order.setSubtractMoney(subtractMoney);

		BigDecimal resultMmoney = totalMoney.subtract(subtractMoney); // 订单金额-满减优惠
		BigDecimal couponMoney = new BigDecimal("0"); // 优惠券金额
		if (couponId != null && couponId > 0) {
			couponMoney = cmOpenStoreCouponService.getCouponDiscountMoney(couponId, resultMmoney, uid, serviceId);
		}
		validator(realMoney.compareTo(BigDecimal.valueOf(0L)) <= 0, "优惠金额必须大于0");
		order.setCouponMoney(couponMoney);

		// 实付金额：等于输入订单金额 – 满减优惠 – 优惠券优惠
		resultMmoney = resultMmoney.subtract(couponMoney);

		logger.info("totalMoney:{},discountPrice:{},CouponMoney:{}, resultMmoney:{}, 前端传来的支付价格realMoney:{}", totalMoney,
				subtractMoney, couponMoney, resultMmoney, realMoney);

		validator(resultMmoney.compareTo(realMoney) != 0, "实付金额核验错误!");

		openQuickOrderSerService.saveOpenQuickOrder(order);

		return Result.successData(order);
	}

	// tradeType 交易类型, JSAPI: 支付宝移动网站支付或微信公众号支付, NATIVE: 支付宝扫码支付或微信原生扫码支付, APP:
	// 支付宝或微信APP支付, MICROPAY: 支付宝条码支付或微信刷卡支付, SAPP: 微信小程序支付, H5: 手机网页支付
	@RequestMapping("/quick_order_pay_create")
	public Result<?> mutiPayCreate(@RequestParam(value = "id", required = true) Long orderId, // json格式
			@RequestParam(value = "payChannel", required = false, defaultValue = "") String payChannel,
			@RequestParam(value = "tradeType", required = true) String tradeType, // pos机用 MICROPAY
			@RequestParam(value = "redirectUrl", required = false) String redirectUrl,
			@RequestParam(value = "clientType", required = false, defaultValue = "APP") String clientType,
			@RequestParam(value = "wap_name", required = false, defaultValue = "H5闪付网页支付") String wapName,
			@RequestParam(value = "wap_url", required = false, defaultValue = "http://store.zizai.thinkinpower.com") String wapUrl,
			@RequestParam(value = "wap_redirect_url", required = false, defaultValue = "") String wapRedirectUrl,	//h5支付必填
			@RequestParam(value = "access_token", required = false) String accessToken, HttpServletRequest request,
			@RequestParam(value="weiXinOpenId", required = false, defaultValue = "") String weiXinOpenId,
			@RequestParam(value = "appType", required = false) Integer appType) {

		// 用户id
		Long uid = validateAndGetUid(clientType, accessToken);

		Map<String, String> params = new HashMap<>();
		List<ExtAppMoneyBase> baseList = new ArrayList<>();
		Integer communityId = 0;
		// 前缀
		String projectType = "闪付支付";
		OpenQuickOrder openStoreOrder = openQuickOrderSerService.getOpenQuickOrder(orderId);
		validator(openStoreOrder == null, "订单不存在");
		validator(openStoreOrder.getUid() == null || openStoreOrder.getUid().longValue() != uid.longValue(),
				"不是自己的订单,不能支付");
		validator(openStoreOrder.getBillStatus() == 2, "该订单已经支付");
		// 通用变量
		communityId = openStoreOrder.getCommunityId();

		String outTradeNo = OpenQuickOrderSerService.PAY_TRADE_NO_PREFIX
				+ DateTimeUtils.format(new Date(), "yyMMddHHmmssSSS") + idComponent.idByLength(4);
		CommunityService communityService = communityServiceService
				.getCommunityServiceByPrimaryKey(openStoreOrder.getServiceId());
		validator(communityService.getAppId() == null || communityService.getAppId() <= 0,
				"服务异常" + openStoreOrder.getServiceId());
		ExtAppMoneyBase base = new ExtAppMoneyBase();
		base.setAppId(communityService.getAppId());
		base.setBody(communityService.getTitle() + "闪付");
		base.setDetail(communityService.getTitle() + "闪付");
		base.setSubject(communityService.getTitle() + "闪付");
		base.setGoodsDetails(null);
		base.setOutTradeNo(outTradeNo);
		// 正式支付
		base.setTotalAmount(openStoreOrder.getRealMoney());
		base.setAppId(communityService.getAppId());
		base.setRfOpenId(null);
		base.setUid(openStoreOrder.getUid());
		baseList.add(base);
		// 调用社区后台接口进行下单
		if(appType != null){
			WeixinService.AppInfo appInfo = weixinService.getAppInfoByType(appType);
			if(appInfo != null){
				params.put("channelAppName",appInfo.getChannelAppName());
			}
		}
		params.put("weixin_open_id",weiXinOpenId);
		params.put("batch_order", JSONArray.toJSONString(baseList));
		params.put("token", accessToken);
		params.put("community_id", "" + communityId);
		params.put("pay_channel", payChannel);
		params.put("client_ip", com.rfchina.community.base.util.HttpUtil.getIp2(request));
		params.put("project_type", projectType);
		params.put("trade_type", tradeType);
		params.put("bussiness_type", "1");
		params.put("type", "5");
		params.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
		params.put("expire_time", DateUtil.formatDate(
				new Date(System.currentTimeMillis() + OpenStoreOrderService.EXPIRE_TIME), "yyyy-MM-dd HH:mm:ss"));
		// 支付成功后的跳转地址, 前端传过来
		params.put("redirect_url", redirectUrl);
		//网页支付需要
		params.put("wap_name", wapName);
		params.put("wap_url", wapUrl);
		params.put("wap_redirect_url", wapRedirectUrl);
		String url = openApiServer + "/community/api/open/admin/pay_create_v3";
		String responsData = HttpUtil.post(url, "UTF-8", params, 30, null, null);
		logger.info("url:{},params:{},responsData:{}", url, params, responsData);
		JSONObject json = JSON.parseObject(responsData);
		if (200 != json.getIntValue("code")) {
			Result.error("创建订单失败，原因为：" + serverUrl + "----" + JSONObject.toJSONString(responsData));
		}
		String communityTradeNo = json.getJSONObject("data").getString("community_trade_no");
		String out_trade_no = json.getJSONObject("data").getString("out_trade_no");
		// 新增多条条记录
		openQuickOrderSerService.createQuickOrderPay(out_trade_no, orderId, payChannel, tradeType, communityTradeNo);
		JSONObject result = json.getJSONObject("data");
		JSONObject payInfo = result.getJSONObject("pay_info");
		if(payInfo != null){
			result.put("paySign", payInfo.getString("sign"));
			result.put("package", payInfo.getString("packageStr"));
			result.put("nonceStr", payInfo.getString("noncestr"));
			result.put("timeStamp", payInfo.getString("timestamp"));
			String signType = payInfo.getString("signType");
			if(StringUtils.isBlank(signType)){
				signType = "MD5";
			}
			result.put("signType", signType);
		}
		return Result.successData(result);
	}

	@RequestMapping(value = { "/open_quick_order_pager" })
	public Result<?> goodPageQuery(@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size,
			@RequestParam Map<String, Object> example,
			@RequestParam(value = "client_type", required = false, defaultValue = "APP") String clientType,
			@RequestParam(value = "access_token", required = false) String accessToken
	) {
		example.remove("size");
		example.remove("index");
		example.remove("client_type");
		example.remove("access_token");
		// 用户id
		Long uid = validateAndGetUid(clientType, accessToken);
		validator(uid == null || uid <= 0, "请登录!");
		example.put("uid", uid);

		return Result.successData(openQuickOrderService.listQuickOrder(example, index, size, false));
	}

	@RequestMapping(value = { "/get_open_quick_order" })
	public Result<?> getOpenQuickOrder(Long id,
									   @RequestParam(value = "client_type", required = false, defaultValue = "APP") String clientType,
									   @RequestParam(value = "access_token", required = false) String accessToken) {
		// 用户id
		Long uid = validateAndGetUid(clientType, accessToken);
		return Result.successData(openQuickOrderService.getQuickOrder(id, 0, uid));
	}

	@RequestMapping(value = { "/cancel_open_quick_order" })
	public Result<?> cancelOpenQuickOrder(Long id,
										  @RequestParam(value = "client_type", required = false, defaultValue = "APP") String clientType,
										  @RequestParam(value = "access_token", required = false) String accessToken) {
		// 用户id
		Long uid = validateAndGetUid(clientType, accessToken);
		return Result.successData(openQuickOrderSerService.cancel(id, uid));
	}

	// 获取优惠券列表
	@RequestMapping(value = { "/get_valid_coupon_record" })
	public Result<?> getValidCouponRecord(@RequestParam(value = "total") String total,
			@RequestParam(value = "serviceId", required = true) int serviceId,
			@RequestParam(value = "access_token", required = false) String accessToken) {
		// 用户id
		Long uid = validateAndGetUid(null, accessToken);
		BigDecimal totalAmount = new BigDecimal(total).setScale(2, BigDecimal.ROUND_HALF_DOWN);
		return Result.successData(cmStoreCouponRecordService.userValidCouponRecordList(uid, serviceId, totalAmount));
	}
}
