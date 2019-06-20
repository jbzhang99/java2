package com.rfchina.community.openstore.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.api.response.ResponseData;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenGoodGroupConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.openapi.ExtAppMoneyBase;
import com.rfchina.community.base.util.RegexUtils;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.openstore.entity.SimOpenStoreGood;
import com.rfchina.community.openstore.entity.ext.ExtMutiBeforePayInfo;
import com.rfchina.community.openstore.entity.ext.ExtOpenStoreServiceTemplete;
import com.rfchina.community.openstore.entity.ext.ParamMutiOpenStoreOrder;
import com.rfchina.community.openstore.entity.ext.ParamOpenStoreGood;
import com.rfchina.community.openstore.service.*;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.OpenStoreGoodGroupInfo;
import com.rfchina.community.persistence.model.OpenStoreOrder;
import com.rfchina.community.service.openser.CmStoreCouponRecordService;
import com.rfchina.platform.common.http.HttpUtil;
import com.rfchina.platform.common.utils.DateUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENSTORE)
public class OpenStoreOrderController extends BaseController{

	@Value("${zizai.server.url}")
	private String serverUrl;
	@Value("${zizai.open.api.url}")
	private String openApiServer;
	public static final String  STORE_PAY_TRADE_NO_PREFIX = "STORE_";
	public static final String  XFSJ_PAY_TRADE_NO_PREFIX = "XFSJ_";
	public static final String  GROUP_PAY_TRADE_NO_PREFIX = "Group_";
	@Autowired
	private CommunityServiceService communityServiceService;
	@Autowired
	private OpenStoreOrderService openStoreOrderService;
	@Autowired
	private OpenStoreOrderPayService openStoreOrderPayService;
	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;
	@Autowired
	private OpenStoreGoodService openStoreGoodService;
	@Autowired
	private OpenStoreServiceTempleteService openStoreServiceTempleteService;
	@Autowired
	private OpenStoreServiceDiscountService openStoreServiceDiscountService;
	@Autowired
	public CmStoreCouponRecordService cmStoreCouponRecordService;
	@Autowired
	public OpenStoreGoodGroupInfoService openStoreGoodGroupInfoService;

	@Value("${open.storeapi.url}")
	private String openStoreapiUrl;
	@Value("${good.automatic.praise.length}")
	private long automaticPraiseLength ;
	@Autowired
	private WeixinService weixinService ;

	/**
	 * @author:fukangwen
	 * @Description:创建主订单
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = {"/muti_order_create"})
	@ResponseBody
	public Result<?> mutiOrderCreate(
			@RequestParam(value="communityId") long communityId,
			@RequestParam(value="addrInfoId", required = false) Long addrInfoId,
			@RequestParam(value="groupDataId", required = false, defaultValue = "0") int groupDataId,	//加入拼团需要拼团id
			@RequestParam(value="groupStatus", required = false, defaultValue = "0") int groupStatus, //团状态 1团购价状态，0则正常单，但是商品如果在团购期间，使用单买价
			@RequestParam(value="addrDetail", required = false) String addrDetail,
			@RequestParam(value="userName", required = false) String userName,
			@RequestParam(value="mobile", required = false) String mobile,
			@RequestParam(value="mutiTotal") String mutiTotal,
			@RequestParam(value="shoppingCartIdList", required = false) String shoppingCartIdList,
			@RequestParam(value="mutiOrderCreateParamListJson") String mutiOrderCreateParamListJson,
			@RequestParam(value = "clientType", required = false, defaultValue="APP") String clientType,
			@RequestParam(value = "resourceType", required = false, defaultValue= "1") int resourceType,
			@RequestParam(value = "access_token", required = false) String accessToken) {
		
		Long uid = validateAndGetUid(clientType, accessToken);
		
		ParamMutiOpenStoreOrder paramOrder = new ParamMutiOpenStoreOrder();
		paramOrder.setCommunityId(communityId);
		paramOrder.setMutiOrderCreateParam(openStoreOrderService.converMutiOrderCreateParamFormString(mutiOrderCreateParamListJson));
		paramOrder.setShoppingCartIdList(openStoreOrderService.converIntegerFormString(shoppingCartIdList));
		paramOrder.setUserName(userName);
		paramOrder.setMobile(mobile);
		paramOrder.setAddrDetail(addrDetail);
		paramOrder.setAddrInfoId(addrInfoId);
		paramOrder.setClientType(clientType);
		paramOrder.setMutiTotal(new BigDecimal(mutiTotal).setScale(2, BigDecimal.ROUND_HALF_DOWN));
		paramOrder.setUid(uid);
		paramOrder.setGroupDataId(groupDataId);
		paramOrder.setGroupStatus(groupStatus);
		logger.info("method ： mutiOrderCreate; paramOrder={}", paramOrder.toString()); 
		
		String openId = null;
		if(OpenConstant.ClientType.APP.equals(clientType)) {
			openId = getOpenId();
			validator(StringUtils.isBlank(paramOrder.getUserName()), "联系人姓名不能为空");
			validator(StringUtils.isBlank(paramOrder.getMobile()), "联系人手机不能为空");
			validator(!RegexUtils.isMobile(paramOrder.getMobile()), "手机格式不正确");
		}

		String title = "自在社区-自在服务商品购买";
		
		// 保存订单记录 
		List<Integer> orderIdList = openStoreOrderService.createMutiOrder(paramOrder, title, openId, uid
				, resourceType);
		
		return Result.successData(orderIdList);
	}
	
	
	/**
	 * @author:fukangwen
	 * @Description: 支付
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/muti_pay_create")
	public Result<?> mutiPayCreate(
			@RequestParam(value="orderIdsJson") String orderIdsJson, //json格式
			@RequestParam(value="appId", required = false) String appId, //微信appId
			@RequestParam(value="payChannel", required = false, defaultValue="") String payChannel,
			@RequestParam(value="tradeType") String tradeType,//pos机用 MICROPAY, H5网页支付SAPP
			@RequestParam(value="redirectUrl", required = false) String redirectUrl,
			@RequestParam(value="weiXinOpenId", required = false, defaultValue = "") String weiXinOpenId,
			@RequestParam(value = "clientType", required = false, defaultValue="APP") String clientType,
			@RequestParam(value = "access_token", required = false) String accessToken,
			@RequestParam(value = "wap_name", required = false, defaultValue = "H5商城网页支付") String wapName,
			@RequestParam(value = "wap_url", required = false, defaultValue = "http://store.zizai.thinkinpower.com") String wapUrl,
			@RequestParam(value = "wap_redirect_url", required = false, defaultValue = "") String wapRedirectUrl,	//h5支付必填
			@RequestParam(value = "appType", required = false) Integer appType,
			HttpServletRequest request) {
		
		logger.info("method ： mutiPayCreate; orderIdsJson={}, payChannel={}, tradeType={},clientType={},access_token={}",
				orderIdsJson, payChannel, tradeType,clientType, accessToken);
		Map<String, String> params = new HashMap<>();
		//用户id
		Long uid = validateAndGetUid(clientType, accessToken);
		if(appType != null){
			WeixinService.AppInfo appInfo = weixinService.getAppInfoByType(appType);
			if(appInfo != null){
				params.put("channelAppName",appInfo.getChannelAppName());
				appId = appInfo.getAppId();
			}
		}
		List<Integer> orderIdList = openStoreOrderService.converIntegerFormString(orderIdsJson);
		validator(orderIdList.isEmpty(), "参数错误");
		List<ExtAppMoneyBase> baseList = new ArrayList<>();
		Long communityId = 0L;
		
		//前缀
		String payTradeNoPrefix = STORE_PAY_TRADE_NO_PREFIX;
		String projectType = "第三方模板支付";
		//网页支付
		if(StringUtils.isNotBlank(redirectUrl) || StringUtils.isNotBlank(wapRedirectUrl)) {
			payTradeNoPrefix = XFSJ_PAY_TRADE_NO_PREFIX;
			projectType = "第三方小富市集支付";
		}
		Map<String, Integer> rel = new HashMap<>();
		StringBuilder posTitle = new StringBuilder("来自");
		int size = 4;
		for(Integer orderId : orderIdList) {
			long count = openStoreOrderPayService.successPayByid(orderId, 1);
			validator(count>0,"该订单已经支付") ;
			OpenStoreOrder openStoreOrder = openStoreOrderService.getOpenStoreOrder(orderId);
			validator(openStoreOrder == null, "订单不存在");
			validator(openStoreOrder.getUserId() == null || openStoreOrder.getUserId().longValue() != uid.longValue()
					, "不是自己的订单,不能支付");

			if(openStoreOrder.getGroupStatus() == OpenGoodGroupConstant.groupOrderStatus.group){
				payTradeNoPrefix = GROUP_PAY_TRADE_NO_PREFIX;
			}
			
			// 通用变量
			communityId = openStoreOrder.getCommunityId();
			
			String outTradeNo = String.format("%s%d%s", payTradeNoPrefix, System.nanoTime(),
					RandomStringUtils.randomNumeric(10));
			
			//关联关系
			rel.put(outTradeNo, orderId);
			
			CommunityService communityService = communityServiceService.getCommunityServiceByPrimaryKey(openStoreOrder.getServiceId());
			if(size > 0) {
				posTitle.append(communityService.getTitle() + ";");
			}
			size--;
			ExtAppMoneyBase base = new ExtAppMoneyBase();
			base.setAppId(communityService.getAppId());
			base.setBody(openStoreOrder.getBody());
			base.setDetail(openStoreOrder.getDetail());
			base.setSubject(openStoreOrder.getSubject());
			base.setGoodsDetails(openStoreOrderService.getGoodDetailList(openStoreOrder,communityService.getTitle()));
			base.setOutTradeNo(outTradeNo);
			base.setTotalAmount(openStoreOrder.getTotalAmount());
			base.setAppId(communityService.getAppId());
			base.setRfOpenId(openStoreOrder.getOpenId());
			base.setUid(openStoreOrder.getUserId());
			base.setOpenStoreId(openStoreOrder.getId());
			baseList.add(base);

		}
		//如果是小程序支付，通过type获取channel_app_name
		if(appType != null){
			WeixinService.AppInfo appInfo = weixinService.getAppInfoByType(appType);
			if(appInfo != null){
				params.put("channelAppName",appInfo.getChannelAppName());
			}
		}
		// 调用社区后台接口进行下单
		params.put("weixin_open_id",weiXinOpenId);
		params.put("batch_order", JSONArray.toJSONString(baseList));
		params.put("token", accessToken);
		params.put("community_id", "" + communityId);
		params.put("pay_channel", payChannel);
		params.put("client_ip", com.rfchina.community.base.util.HttpUtil.getIp2(request));
		params.put("project_type", projectType);
		params.put("trade_type", tradeType);
		params.put("bussiness_type", "1");
		params.put("wxAppId", appId);
		params.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
		params.put("expire_time", DateUtil.formatDate(new Date(System.currentTimeMillis() + OpenStoreOrderService.EXPIRE_TIME), "yyyy-MM-dd HH:mm:ss"));
		
		//支付成功后的跳转地址, 前端传过来
		params.put("redirect_url", redirectUrl);
		
		//网页支付需要
		params.put("wap_name", wapName);
		params.put("wap_url", wapUrl);
		params.put("wap_redirect_url", wapRedirectUrl);
		params.put("posTitle", posTitle.append("等店铺的商品").toString());
		String url = openApiServer + "/community/api/open/admin/pay_create_v3";
		String responsData = HttpUtil.post(url, "UTF-8", params, 30, null, null);
		logger.info("123url:{},params:{},responsData:{}", url, params, responsData);
		JSONObject json = JSON.parseObject(responsData);
		if (200 != json.getIntValue("code")) {
			Result.error("创建订单失败，原因为：" + serverUrl + "----" + JSONObject.toJSONString(responsData));
		}
		String communityTradeNo = json.getJSONObject("data").getString("community_trade_no");
		String out_trade_no = json.getJSONObject("data").getString("out_trade_no");
		
		String[] outTradeNos = out_trade_no.split(",");
		List<String> outTradeNoList = Arrays.asList(outTradeNos);
		
		//新增多条条记录 
		openStoreOrderPayService.mutiCreate(outTradeNoList, rel, payChannel, tradeType, communityTradeNo);

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
	 
	
	/**
	 * 我的订单列表
	 * @author:fukangwen
	 * @Description: 订单list
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/order_list")
	public Result<?> list(
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size,
			@RequestParam(value = "type", required = false, defaultValue = "0") int type,
			@RequestParam(value = "clientType", required = false, defaultValue="APP") String clientType,
			@RequestParam(value = "access_token", required = false) String accessToken){
		Long uid = validateAndGetUid(clientType, accessToken);
		return Result.successData(openStoreOrderService.list(uid,type, index, size));
	}

	//我的订单统计数量
	@RequestMapping("/order_list_count")
	public Result<?> countByUserId(
			@RequestParam(value = "clientType", required = false, defaultValue="APP") String clientType,
			@RequestParam(value = "access_token", required = false) String accessToken){
		Long uid = validateAndGetUid(clientType, accessToken);
		return Result.successData(openStoreOrderService.countByUserId(uid));
	}


	/**
	 * @author:fukangwen
	 * @Description: 单个订单详情
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/order_get_detail")
	public Result<?> getDetail(
			@RequestParam(value="order_id") int orderId,
			@RequestParam(value = "clientType", required = false, defaultValue="APP") String clientType,
			@RequestParam(value = "access_token", required = false) String accessToken){
		
		logger.info("method ： getDetail; orderId={}", orderId);
		
		Long uid = validateAndGetUid(clientType, accessToken);
		
		return Result.successData(openStoreOrderService.getDetail(orderId, uid));
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 多个订单详情
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/order_get_detail_by_tradeno")
	public Result<?> getDetailByCommunityOutTradeNo(
			@RequestParam(value="communityOutTradeNo") String communityOutTradeNo,
			@RequestParam(value = "clientType", required = false, defaultValue="APP") String clientType,
			@RequestParam(value = "access_token", required = false) String accessToken){
		logger.info("method ： getDetailByCommunityOutTradeNo; communityOutTradeNo={}", communityOutTradeNo);
		return Result.successData(openStoreOrderService.getDetailByCommunityOutTradeNo(communityOutTradeNo));
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 订单确认收货
	 * @return Result<?>
	 * 
	 * @throws
	 */
	@RequestMapping("/order_confirm_receive")
	public Result<?> confirmReceive(
			@RequestParam(value="order_id") int orderId,
			@RequestParam(value = "clientType", required = false, defaultValue="APP") String clientType,
			@RequestParam(value = "access_token", required = false) String accessToken){
		logger.info("method ： confirmReceive; orderId={}", orderId);
		Long uid = validateAndGetUid(clientType, accessToken);
		
		openStoreOrderService.confirmReceive(orderId, uid);
		return Result.success();
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 根据bill_id去支付中心查单
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = { "/order_get_center_bill_detail" }, method = { RequestMethod.POST })
	@ResponseBody
	public Result<?> getBillDetail(@RequestParam(value = "id") String billId,
			@RequestParam(value = "clientType", required = false, defaultValue="APP") String clientType,
			@RequestParam(value = "access_token", required = false) String accessToken)
			throws ServletException, IOException {
		validateAndGetUid(clientType, accessToken);
		ResponseData<?> json = platformGlobalComponent.getBillDetail(billId);
		return Result.successData(json);
	}
	
	
	/**
	 * @author:fukangwen
	 * @Description: 支付单状态
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/order_get_pay_detail")
	public Result<?> getDetail(
			@RequestParam(value="out_trade_no") String outTradeNo,
			@RequestParam(value = "clientType", required = false, defaultValue="APP") String clientType,
			@RequestParam(value = "access_token", required = false) String accessToken){
		
		logger.info("method ： getDetail; orderId={}", outTradeNo);
		
		validateAndGetUid(clientType, accessToken);
		
		return Result.successData(openStoreOrderService.getPayDetail(outTradeNo));
	}
	
	
	/**
	 * @author:fukangwen
	 * @Description: 加载购物车商品,下单前计算出每个服务的商品价格總價，優惠總價
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = {"/muti_data_before_pay"})
	public Result<?> listMutiDataBeforePay(
			@RequestParam(value = "goodListStr") String goodListStr,
			@RequestParam(value="groupStatus", required = false, defaultValue = "0") int groupStatus, //团状态 1团购价状态，0则正常单，但是商品如果在团购期间，使用单买价
			@RequestParam(value = "access_token", required = false) String accessToken
			) {
		logger.info("method ： muti_data_before_pay; goodListStr={}", goodListStr); 
		Long uid = validateAndGetUid(null, accessToken);
		validator(StringUtils.isBlank(goodListStr) , "参数有误");
		
		List<ParamOpenStoreGood> paramGoodList = openStoreOrderService.converParamOpenStoreGoodFormString(goodListStr);
		List<SimOpenStoreGood> list = openStoreGoodService.listGoodBeforePay(paramGoodList);
		
		List<ExtMutiBeforePayInfo> returnList = new ArrayList<>();
		if(!list.isEmpty()) {
			Map<Integer, List<SimOpenStoreGood>> goodListMap = list.stream()
	                .distinct()
	                .collect(Collectors.groupingBy(SimOpenStoreGood::getServiceId));
			goodListMap.forEach((serviceId, goodList)->{
				ExtMutiBeforePayInfo info = new ExtMutiBeforePayInfo();
				ExtOpenStoreServiceTemplete templete  = openStoreServiceTempleteService.getTempleteInfo(serviceId);
				info.setExpressMoney(templete.getExpressMoney());
				info.setTemplete(templete);
				info.setServiceId(serviceId);
				info.setSimGoodList(goodList);
				info.setGoodsPrice(this.getGoodTotalPrice(goodList, groupStatus));

				//拼团不能用优惠满减，不能使用商家券
				BigDecimal discountPrice = BigDecimal.ZERO;
				if(OpenGoodGroupConstant.groupOrderStatus.no_group == groupStatus) {
					discountPrice = openStoreServiceDiscountService.getDiscountPrice(info.getGoodsPrice(), serviceId);
				}
				info.setDiscountPrice(discountPrice);

				info.setTotalAmount(info.getGoodsPrice().subtract(info.getDiscountPrice()).add(info.getExpressMoney())); //商品总价-满减金额+运费

				if(OpenGoodGroupConstant.groupOrderStatus.no_group == groupStatus) {
					info.setCardCouponRecordList(cmStoreCouponRecordService.userValidCouponRecordList(uid, serviceId, info.getTotalAmount()));
				}
				returnList.add(info);
			});
		}
		return  Result.successData(returnList);
	}


	/**
	 * @author:wlrllr
	 * @Description: 获取订单商品信息
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/getOrderGoodsInfo")
	public Result<?> getOrderGoodsInfo(@RequestParam(value = "orderId") int orderId,
									   @RequestParam(value = "clientType", required = false, defaultValue = "APP") String clientType,
									   @RequestParam(value = "access_token", required = false) String accessToken) {
		logger.info("method ： getDetail; orderId={}", orderId);
		validateAndGetUid(clientType, accessToken);
		return Result.successData(openStoreOrderService.getRelList(orderId));
	}

	//计算商品总价
	private BigDecimal getGoodTotalPrice(List<SimOpenStoreGood> goodList, int groupStatus) {
		BigDecimal serverGoodTotal = new BigDecimal(0); 
		for(SimOpenStoreGood sim : goodList) {
			OpenStoreGoodGroupInfo groupInfo = openStoreGoodGroupInfoService.getValidGoodGroupInfo(sim.getId());
			if(groupInfo != null){
				if(groupStatus == OpenGoodGroupConstant.groupOrderStatus.no_group){
					sim.setPrice(groupInfo.getPrice());
				}else{
					sim.setPrice(groupInfo.getGroupPrice());
				}
			}

			serverGoodTotal = serverGoodTotal.add(
					sim.getPrice().multiply(new BigDecimal(sim.getAmount())).setScale(2, BigDecimal.ROUND_HALF_DOWN)
					);
		}
		return serverGoodTotal;
	}
	
	
}
