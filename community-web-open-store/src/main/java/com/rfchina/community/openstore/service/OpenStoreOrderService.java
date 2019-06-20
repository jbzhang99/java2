package com.rfchina.community.openstore.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rfchina.api.request.pay.FuPayCreateRequest.GoodsDetail;
import com.rfchina.community.base.OpenGoodGroupConstant;
import com.rfchina.community.base.OrderPayConstant;
import com.rfchina.community.base.SysConstant;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.openstore.entity.SimOpenOrderTotal;
import com.rfchina.community.openstore.entity.ext.*;
import com.rfchina.community.openstore.mapper.ext.ExtOpenStoreOrderMapper;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.service.openser.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
/**
 * @author:fukangwen
 * @Description: 模板订单service
 */
@Service
public class OpenStoreOrderService extends BaseService{

	@Autowired
	private OpenStoreOrderMapper openStoreOrderMapper;
	@Autowired
	private OpenStoreShoppingCartService openStoreShoppingCartService;
	@Autowired
	private OpenStoreGoodOrderRelService openStoreGoodOrderRelService;
	@Autowired
	private OpenStoreOrderPayService openStoreOrderPayService;
	@Autowired
	private OpenStoreGoodService openStoreGoodService;
	@Autowired
	private OpenServiceBusinessService openServiceBusinessService;
	@Autowired
	private CommunityServiceService communityServiceService;
	@Autowired
	private ExtOpenStoreOrderMapper extOpenStoreOrderMapper;
	@Autowired
	private CommunityMapper communityMapper;
	@Autowired
	private OpenStoreServiceDiscountService openStoreServiceDiscountService;
	@Autowired
	private OpenStoreServiceTempleteService openStoreServiceTempleteService;
	@Autowired
	private OpenConfService openConfService;
	@Autowired
	private OpenOrderSerService openOrderSerService;
	@Autowired
	private CmOpenStoreCouponService cmOpenStoreCouponService;
	@Autowired
	private OpenFeeOrderMapper openFeeOrderMapper;
	@Autowired
	private OpenOrderTotalMapper openOrderTotalMapper;
	@Autowired
	private OpenStoreServiceTempleteMapper openStoreServiceTempleteMapper;
	@Autowired
	private OpenStoreVerifyCardService openStoreVerifyCardService;
	@Autowired
	private CmStoreCouponRecordService cmStoreCouponRecordService;
	@Autowired
	private OpenXFSJService openXFSJService;
	@Autowired
	private OpenStoreGoodOrderRelMapper openStoreGoodOrderRelMapper;
	@Autowired
	private OpenStoreGoodGroupInfoService openStoreGoodGroupInfoService;
	@Autowired
	private OpenStoreGroupDataService openStoreGroupDataService;

	public static final long EXPIRE_TIME = (long)15 * 60 * 1000;
	
	/**
	 * @author:fukangwen
	 * @Description: 获取商品详情的list
	 * @return List<GoodsDetail>
	 * @throws
	 */
	public List<GoodsDetail> getGoodDetailList(OpenStoreOrder openStoreOrder, String serviceTitle) {
		List<OpenStoreGoodOrderRel> list = openStoreGoodOrderRelService.getList(openStoreOrder.getId());
		List<GoodsDetail> goodDetails = new ArrayList<>();
		for(OpenStoreGoodOrderRel rel : list) {
			GoodsDetail detail = new GoodsDetail();
			detail.setGoodId(String.valueOf(rel.getGoodId()));
			detail.setBody(rel.getGoodName() + " * " + rel.getAmount());
			detail.setTotalAmount(rel.getCurrentSinglePrice().multiply(new BigDecimal(rel.getAmount())).multiply(new BigDecimal(100)).longValue());
			detail.setName(detail.getBody());
			detail.setPrice(detail.getTotalAmount());
			detail.setReceiptAmount(detail.getTotalAmount());
			detail.setRemark(serviceTitle);
			detail.setQuantity(new BigDecimal(rel.getAmount()));
			goodDetails.add(detail);
		}
		
		if(openStoreOrder.getExpressMoney().compareTo(BigDecimal.ZERO) == 1) {
			GoodsDetail detail = new GoodsDetail();
			detail.setBody("运费");
			detail.setTotalAmount(openStoreOrder.getExpressMoney().multiply(new BigDecimal(100)).longValue());
			buildGoodsDetail(serviceTitle, goodDetails, detail);
		}
		
		if(openStoreOrder.getDiscountPrice().compareTo(BigDecimal.ZERO) == 1) {
			GoodsDetail detail = new GoodsDetail();
			detail.setBody("满减");
			detail.setTotalAmount(-openStoreOrder.getDiscountPrice().multiply(new BigDecimal(100)).longValue());
			buildGoodsDetail(serviceTitle, goodDetails, detail);
		}
		
		if(openStoreOrder.getCouponPrice().compareTo(BigDecimal.ZERO) == 1) {
			GoodsDetail detail = new GoodsDetail();
			detail.setBody("店铺优惠券");
			detail.setTotalAmount(-openStoreOrder.getCouponPrice().multiply(new BigDecimal(100)).longValue());
			buildGoodsDetail(serviceTitle, goodDetails, detail);
		}
		
		return goodDetails;
		
	}

	private void buildGoodsDetail(String serviceTitle, List<GoodsDetail> goodDetails, GoodsDetail detail) {
		detail.setName(detail.getBody());
		detail.setPrice(detail.getTotalAmount());
		detail.setReceiptAmount(detail.getTotalAmount());
		detail.setRemark(serviceTitle);
		detail.setGoodId("0");
		detail.setQuantity(new BigDecimal(1));
		goodDetails.add(detail);
	}

	/**
	 * @author:fukangwen
	 * @Description: 生成订单号, 17101223123184  年月日+6位id+随机
	 * @return String
	 * @throws
	 */
	public String createOrderCode(int orderId) {
		StringBuilder orderCode = new StringBuilder(DateTimeUtils.format(new Date(), "yyMMdd"));
		String orderIdStr ="000000"+ orderId;
		orderIdStr = orderIdStr.substring(orderIdStr.length()-6);
		 
		orderCode.append(orderIdStr);
		orderCode.append(RandomStringUtils.randomNumeric(2));
		return orderCode.toString();
	}
	
	public OpenStoreOrder getOpenStoreOrder(int orderId) {
		return openStoreOrderMapper.selectByPrimaryKey(orderId);
	}

	/**
	 * @author:fukangwen
	 * @Description: 分页展示订单列表
	 * @return PageInfo
	 * @throws
	 */
	public PageInfo< ?> list(Long userId,int type, int index, int size) {
        logger.info("获取我的订单列表:参数userId:{},index:{},size:{}", userId, index, size);
        PageHelper.startPage(index, size);
        Map<String, Object> param = new HashMap<>();
        param.put("userId", userId);


        //0全部 1代付款,2待发货3待收货4已完成
        if (type == 1) {
            param.put("pay_status", 0);
        } else if (type == 2) {
            param.put("pay_status", 1);
            param.put("send_status", 0);
        } else if (type == 3) {
            param.put("pay_status", 1);
            param.put("send_status", 1);
        } else if (type == 4) {
            param.put("pay_status", 1);
            param.put("send_status", 2);
        } else if (type == 5) {
			param.put("pay_status", 1);
			param.put("comment_status", 0);
		}


        List<OpenStoreOrder> list = extOpenStoreOrderMapper.selectWithOutOpenId(param);
        PageInfo pageInfo = new PageInfo(list);
        if (!list.isEmpty()) {
            List<ExtOpenStoreOrderSimple> extList = new ArrayList<>();
            for (OpenStoreOrder order : list) {
                ExtOpenStoreOrderSimple extOrder = new ExtOpenStoreOrderSimple();
                BeanUtils.copyProperties(order, extOrder);
                extOrder.setGoodImgList(openStoreGoodOrderRelService.getImgList(order.getId()));
                CommunityService service = communityServiceService.getCommunityServiceByPrimaryKey(order.getServiceId());
                extOrder.setServiceName(service == null ? "" : service.getTitle());
                extList.add(extOrder);
            }
            pageInfo.setList(extList);
        }
        return pageInfo;
	}

	public JSONObject countByUserId(Long uid){
        // //0全部 1代付款,2待发货3待收货4已完成
		Map map = extOpenStoreOrderMapper.countByUserId(uid);
        JSONObject json = new JSONObject();
		if(map != null && !map.isEmpty()){
			json.putAll(map);
		}
       /* OpenStoreOrderExample exa = new OpenStoreOrderExample();
        exa.createCriteria().andUserIdEqualTo(uid).andPayStatusEqualTo(0);
        json.put("type1", openStoreOrderMapper.countByExample(exa));

        exa.clear();
        exa.createCriteria().andUserIdEqualTo(uid).andPayStatusEqualTo(1).andSendStatusEqualTo(0);
        json.put("type2", openStoreOrderMapper.countByExample(exa));
        exa.clear();
        exa.createCriteria().andUserIdEqualTo(uid).andPayStatusEqualTo(1).andSendStatusEqualTo(1);
        json.put("type3", openStoreOrderMapper.countByExample(exa));
        exa.clear();
        exa.createCriteria().andUserIdEqualTo(uid).andPayStatusEqualTo(1).andSendStatusEqualTo(2);
        json.put("type4", openStoreOrderMapper.countByExample(exa));*/
        logger.info("uid:{},json:{}", uid, json);
        return json;
    }

	/**
	 * @param uid 
	 * @author:fukangwen
	 * @Description: 获取订单详情
	 * @return ExtOpenStoreOrder
	 * @throws
	 */
	public ExtOpenStoreOrder getDetail(int orderId, Long uid) {
		//
		OpenStoreOrder openStoreOrder = openStoreOrderMapper.selectByPrimaryKey(orderId);
		validator(openStoreOrder == null, "订单不存在");
		validator(openStoreOrder.getUserId() != uid.longValue(), "非法访问!");

		ExtOpenStoreOrder extOpenStoreOrder = new ExtOpenStoreOrder();
		BeanUtils.copyProperties(openStoreOrder, extOpenStoreOrder);
		extOpenStoreOrder.setGoodList(openStoreGoodOrderRelService.getVOList(orderId));
		extOpenStoreOrder.setIsNeedVerify(openStoreVerifyCardService.isNeedVerify(orderId));
		OpenStoreServiceTemplete templete = openStoreServiceTempleteMapper
				.selectByPrimaryKey(openStoreOrder.getServiceId());
		extOpenStoreOrder.setStorePhone(templete == null ? "" : templete.getPhone());
		if (StringUtils.isNotBlank(openStoreOrder.getOutTradeNo())) {
			com.rfchina.community.persistence.model.OpenOrder openOrder = openOrderSerService
					.getOpenOrder(openStoreOrder.getOutTradeNo());
			if (openOrder != null) {
				extOpenStoreOrder
						.setOpenPoint(openConfService.getOpenPointByOrderId(openOrder.getId(), openOrder.getUid()));
				extOpenStoreOrder.setBillId(openOrder.getBillId());
				extOpenStoreOrder.setBillSplitStatus(openOrder.getBillSplitStatus());
			}
		}
		OpenFeeOrderExample example = new OpenFeeOrderExample();
		example.createCriteria().andStoreOrderIdEqualTo(orderId);
		List<OpenFeeOrderWithBLOBs> feeOrderList = openFeeOrderMapper.selectByExampleWithBLOBs(example);
		extOpenStoreOrder.setFeeOrderList(feeOrderList);

		//团购拼团状态
		if(openStoreOrder.getGroupDataId() != null){
			extOpenStoreOrder.setGroupDataStatus(openStoreGroupDataService.getGroupDataStatus(openStoreOrder.getGroupDataId()));
			extOpenStoreOrder.setGroupSuccessHour(openStoreGoodGroupInfoService.getGroupSuccessHour(openStoreOrder.getGroupInfoId()));
		}
		return extOpenStoreOrder;
	}

	/**
	 * @author:fukangwen
	 * @Description: 确认收货
	 * @return void
	 * @throws
	 */
	public void confirmReceive(int orderId, long uId) {
		OpenStoreOrder openStoreOrder = openStoreOrderMapper.selectByPrimaryKey(orderId);
		validator(openStoreOrder == null, "订单不存在");
		validator(openStoreOrder.getUserId().intValue() != uId, "非法操作");
		//已支付，且是发货状态
		if(openStoreOrder.getPayStatus() == OrderPayConstant.PayStatus.PAY.getCode()
				&& openStoreOrder.getSendStatus() == OrderPayConstant.SendStatus.SEND.getCode()) {
			openStoreOrder.setSendStatus(OrderPayConstant.SendStatus.COMPLETE.getCode());
			openStoreOrder.setConfirmTime(new Date());
			openStoreOrder.setCommentStatus(SysConstant.COMMON_STATUS_HIDE); //评论状态设置为待评论
			openStoreOrderMapper.updateByPrimaryKeySelective(openStoreOrder);
		}
			
	}

	/**
	 * @author:fukangwen
	 * @Description: 更新商品状态
	 * @return void
	 * @throws
	 */
	public void updatePayStatus(String outTradeNo, String payTime, String payChannel) {
		//
		OpenStoreOrderPay openStoreOrderPay = openStoreOrderPayService.getByOutTradeNo(outTradeNo);
		validator(openStoreOrderPay == null, "订单不存在"+ outTradeNo);
		OpenStoreOrder openStoreOrder = this.getOpenStoreOrder(openStoreOrderPay.getStoreOrderId());
		CommunityService communityService =communityServiceService.getCommunityServiceByPrimaryKey(openStoreOrder.getServiceId());
		long now = System.currentTimeMillis();
		Boolean flag = this.updatePayResult(outTradeNo, payTime, payChannel);
		logger.info("updatePayStatus use time={}", System.currentTimeMillis()-now);
		if(flag) {
			//发送邮件
			openServiceBusinessService.sendPaySuccessEmail(communityService.getMerchantId(), openStoreOrderPay.getPayTime(), communityService.getTitle());
		}
	}
	
	@Transactional
	public synchronized Boolean updatePayResult(String outTradeNo, String payTime, String payChannel) {
		//

		OpenStoreOrderPay openStoreOrderPay = openStoreOrderPayService.getByOutTradeNo(outTradeNo);
		validator(openStoreOrderPay == null, "订单不存在");
		
		//未支付
		if(OrderPayConstant.PayStatus.PAY.getCode() != openStoreOrderPay.getPayStatus()) {
			logger.info("订单状态已更新：payStatus={}", openStoreOrderPay.getPayStatus());
			if(StringUtils.isNoneBlank(payTime)) {
				openStoreOrderPay.setPayTime(new Date(Long.parseLong(payTime)));
				openStoreOrderPay.setPayStatus(OrderPayConstant.PayStatus.PAY.getCode());
				openStoreOrderPay.setPayChannel(payChannel);
				openStoreOrderPayService.update(openStoreOrderPay);
			}
			//更新OpenStoreOrder 的状态 
			OpenStoreOrder openStoreOrder = this.getOpenStoreOrder(openStoreOrderPay.getStoreOrderId());
			openStoreOrder.setSendStatus(OrderPayConstant.SendStatus.NOT_SEND.getCode());
			openStoreOrder.setPayChannel(payChannel);
			openStoreOrder.setOutTradeNo(outTradeNo);
			openStoreOrder.setPayStatus(openStoreOrderPay.getPayStatus());
			openStoreOrder.setPayTime(openStoreOrderPay.getPayTime());
			openStoreOrderMapper.updateByPrimaryKeySelective(openStoreOrder);
			
			//更新销量
			openStoreGoodService.updateSaleAmount(openStoreOrder.getId());

			//团购状态groupStatus， 团购信息groupInfoId， 团购数据groupDataId
			if(openStoreOrder.getGroupStatus() == OpenGoodGroupConstant.groupOrderStatus.group){
				openStoreGroupDataService.insertOrUpdate(openStoreOrder);
			}
			
			//核销信息
			openStoreGoodOrderRelService.update(openStoreOrder.getId(), openStoreOrder.getUserId(), OrderPayConstant.PayStatus.PAY.getCode()
					,openStoreOrder.getOriginalPrice(), openStoreOrder.getTotalAmount(), openStoreOrder.getServiceId());
			
			//更新券状态 
			cmStoreCouponRecordService.confirm(openStoreOrder.getOrderCode(), outTradeNo);
			
			return true;
		}
		
		logger.info("订单状态已更新：out_trade_no={}", outTradeNo);
		return false;
	}


	/**
	 * @author:fukangwen
	 * @Description: 下单前参数验证
	 * @return void
	 * @throws
	 */
	public void mutiCommonPayCheck(ParamMutiOpenStoreOrder paramOrder) {
		validator(paramOrder.getCommunityId() <= 0, "社区参数不能为空");
		validator(paramOrder.getMutiOrderCreateParam().isEmpty(), "订单参数有误");
		validator(paramOrder.getMobile().length() > 11, "手机号码太长");
		validator(communityMapper.selectByPrimaryKey((int)paramOrder.getCommunityId()) == null, "社区不存在");

		//如果是团购价，必须订单只有一种商品，1件数量
		if(paramOrder.getGroupStatus() == OpenGoodGroupConstant.groupOrderStatus.group){
			validator(paramOrder.getMutiOrderCreateParam().size() > 1, "团购价只支持单独购买");
			MutiOrderCreateParam param = paramOrder.getMutiOrderCreateParam().get(0);
			validator(param.getStoreGoodList().size() > 1, "团购价只支持购买单个商品");
			ParamOpenStoreGood good = param.getStoreGoodList().get(0);
			//validator(good.getAmount() > 1, "团购价只支持单次购买一件商品"); 支持单次购买多次
			good.setGroupDataId(paramOrder.getGroupDataId()); //设置团id
		}

		//计算所有商品价格总价
		BigDecimal allServerTotal = new BigDecimal(0);
		//  for 循环，计算总价格
		for(MutiOrderCreateParam param : paramOrder.getMutiOrderCreateParam()) {
			validateSingleStore(param, paramOrder.getUid(), paramOrder.getGroupStatus());
			allServerTotal = allServerTotal.add(param.getTotalAmount()).setScale(2, BigDecimal.ROUND_HALF_DOWN);
		}
		
		// 计算所有金额
		validator(allServerTotal.compareTo(paramOrder.getMutiTotal()) != 0, "价格发生变动,请返回重新下单");
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 验证单个商家的金额，并返回该商家的总金额
	 * groupStatus 为1，使用团购价，商品必为只有一种且只有一个，此时不使用店铺优惠券等各种优惠
	 * @return BigDecimal
	 * @throws
	 */
	private void validateSingleStore(MutiOrderCreateParam paramOrder, long uid, int groupStatus) {
		validator(paramOrder.getGoodList() == null || paramOrder.getGoodList().isEmpty(), "商品信息不能为空");
		CommunityService communityService = communityServiceService.getCommunityServiceByPrimaryKey(paramOrder.getServiceId());
		validator(communityService == null, "店铺不存在");
		validator(communityService.getStatus().intValue() == 2, "订单创建失败，该商家已被停用，如有疑问请联系平台或现场物业人员");//2为禁用
		
		//运费是否发生变化
		OpenStoreServiceTemplete openStoreServiceTemplete = openStoreServiceTempleteService.getTempleteInfo(paramOrder.getServiceId());
		validator(openStoreServiceTemplete == null, "该服务不存在");
		validator(openStoreServiceTemplete.getExpressMoney().compareTo(paramOrder.getExpressMoney()) != 0, "运费发生变化，请重新下单");
		
		//计算所有商品价格总价
		BigDecimal serverGoodTotal = BigDecimal.ZERO;

		for(ParamOpenStoreGood good : paramOrder.getStoreGoodList()) {
			validator(good.getAmount() <= 0 || good.getGoodId() <= 0, "商品信息有误");
			OpenStoreGood openStoreGood = openStoreGoodService.getById(good.getGoodId());
			validator(openStoreGood == null, "商品不存在");
			validator(openStoreGood.getStatus() != OpenStoreGoodService.Status.GROUNDING.getKey(), "购买失败，所选商品已删除或下架，请重新下单。");

			//获取团购信息
			OpenStoreGoodGroupInfo groupInfo = openStoreGoodGroupInfoService.getValidGoodGroupInfo(good.getGoodId());

			int groupStockStatus = OpenGoodGroupConstant.groupStockStatus.good_stock;
			if(groupInfo != null){
				if(OpenGoodGroupConstant.groupOrderStatus.group == groupStatus){
					//团购使用团购库存跟团购价
					good.setStock(groupInfo.getStock());
					good.setGoodPrice(groupInfo.getGroupPrice());
					good.setLimitTimes(groupInfo.getLimitTimes());
					groupStockStatus = OpenGoodGroupConstant.groupStockStatus.group_stock;
					good.setGroupInfoId(groupInfo.getId());
					validator(good.getStock() < good.getAmount(), "团购库存不足");
					paramOrder.setGroupInfoId(groupInfo.getId());
				}else{
					//单买使用团购单买价，商品库存
					good.setStock(openStoreGood.getStock());
					good.setGoodPrice(groupInfo.getPrice());
					good.setLimitTimes(openStoreGood.getLimitTimes());
					validator(good.getStock() < good.getAmount(), "库存不足");
				}

			}else{
				//validator(groupStatus == OpenGoodGroupConstant.groupOrderStatus.group, "团购活动已经失效");
				//判断库存够不够
				good.setStock(openStoreGood.getStock());
				good.setGoodPrice(openStoreGood.getPrice());
				good.setLimitTimes(openStoreGood.getLimitTimes());
				validator(good.getStock() < good.getAmount(), "库存不足");
			}
			good.setGroupStockStatus(groupStockStatus);
			good.setGoodsName(openStoreGood.getName());
			//判断单用户商品购买次数是否超了
			if(good.getLimitTimes() > 0) {
				validateUserGoodLimitTimes(good, uid, groupStatus, groupInfo == null ? null : groupInfo.getId());
			}

			//计算商品价格
			serverGoodTotal = serverGoodTotal.add(good.getGoodPrice().multiply(new BigDecimal(good.getAmount())).setScale(2, BigDecimal.ROUND_HALF_DOWN));
		}
		
		//该商家计算得商品价格
		paramOrder.setGoodTotal(serverGoodTotal);


		// 获取满减金额
		BigDecimal discountPrice = BigDecimal.ZERO;
		//非团购价才有满减
		if(groupStatus == OpenGoodGroupConstant.groupOrderStatus.no_group) {
			discountPrice = openStoreServiceDiscountService.getDiscountPrice(serverGoodTotal, paramOrder.getServiceId());
		}else{

		}

		//计算原总价
		paramOrder.setOriginalPrice(paramOrder.getExpressMoney().add(serverGoodTotal));
		//计算优惠券后的价格跟传过来的商品总价是否一致
		BigDecimal serverTotal = paramOrder.getOriginalPrice().subtract(discountPrice);
		BigDecimal couponSubPrice = BigDecimal.ZERO;

		//非团购价才能用优惠券
		if(paramOrder.getCouponRecordId() > 0 && groupStatus == OpenGoodGroupConstant.groupOrderStatus.no_group) {
			//获取优惠券记录并查看状态金额
			couponSubPrice = cmOpenStoreCouponService.getCouponDiscountMoney(paramOrder.getCouponRecordId(),
					serverTotal, uid, paramOrder.getServiceId());
			serverTotal = serverTotal.subtract(couponSubPrice);
		}
		paramOrder.setCouponSubPrice(couponSubPrice);

		logger.info("total={}, serverTotal={}", paramOrder.getTotalAmount(), serverTotal);
		validator(paramOrder.getTotalAmount().compareTo(serverTotal) != 0, "商品价格发生改变,请重新下单");
		
	}


	private void validateUserGoodLimitTimes(ParamOpenStoreGood good, long uid, int groupStatus, Long groupInfoId) {
		logger.info("判断用户的购买次数， groupInfoId={}, uid={}, limitTimes={}", groupInfoId, uid, good.getLimitTimes());
		if(groupStatus == OpenGoodGroupConstant.groupOrderStatus.group){
			long times = getGoodPayTimes(good.getGoodId(), uid, groupInfoId);
			long newTimes = good.getAmount() + times;
			logger.info("判断用户的购买次数, newTimes={}", newTimes);
			validator(newTimes > good.getLimitTimes(), "不好意思，该商品在活动期间单个用户最多只能购买" + good.getLimitTimes() + "件哦");
		}else{
			long times = getGoodPayTimes(good.getGoodId(), uid, null);
			long newTimes = good.getAmount() + times;
			logger.info("判断用户的购买次数, newTimes={}", newTimes);
			validator(newTimes > good.getLimitTimes(), "抱歉，您选购的商品【"+good.getGoodsName()+"】每个用户最多购买" + good.getLimitTimes() + "件。");
		}

	}

	public long getGoodPayTimes(int goodId, long uid, Long groupInfoId) {
		Map<String, Object> param = new HashMap<>();
		param.put("goodId", goodId);
		param.put("uid", uid);
		if(groupInfoId != null){
			param.put("groupInfoId", groupInfoId);
		}
		return extOpenStoreOrderMapper.countByUserIdAndGoodId(param);
	}


	/** 
	  * 将一个json字串转为list 
	  * @return
	  */
	  public List<MutiOrderCreateParam> converMutiOrderCreateParamFormString(String paramList){ 
	  if (paramList == null || paramList.equals("")) 
	   return new ArrayList(); 
	  
	  List<MutiOrderCreateParam> dataList = JSONArray.parseArray(paramList, MutiOrderCreateParam.class);
	  for(MutiOrderCreateParam param : dataList) {
		  param.setStoreGoodList(this.converParamOpenStoreGoodFormString(param.getGoodList()));
	  }
	  return dataList;
	 } 
	  
	
	/** 
	  * 将一个json字串转为list 
	  * @return
	  */
	  public List<ParamOpenStoreGood> converParamOpenStoreGoodFormString(String goodList){ 
	  if (goodList == null || goodList.equals("")) 
	   return new ArrayList(); 
	  
	  return JSONArray.parseArray(goodList, ParamOpenStoreGood.class);
	 }
	 
	 /** 
	  * 将一个json字串转为list 
	  * @return
	  */
	  public List<Integer> converIntegerFormString(String shoppingCartIdList){ 
	  if (shoppingCartIdList == null || shoppingCartIdList.equals("")) 
	   return new ArrayList(); 
	  
	  return JSONArray.parseArray(shoppingCartIdList, Integer.class);
	 }

	/**
	 * @author:fukangwen
	 * @Description: 创建联合支付订单
	 * @return void
	 * @throws
	 */
	@Transactional
	public List<Integer> createMutiOrder(ParamMutiOpenStoreOrder paramOrder, String title, String openId, Long uid, int resourceType) {
		//验证参数
		this.mutiCommonPayCheck(paramOrder);

		List<Integer> orderIdList = new ArrayList<>();
		// 循环新建订单
		for(MutiOrderCreateParam param : paramOrder.getMutiOrderCreateParam()) {
			int orderId = this.createSingleOrder(param, paramOrder.getCommunityId(),
					paramOrder.getUserName(), paramOrder.getMobile(), paramOrder.getAddrInfoId(), paramOrder.getAddrDetail(), paramOrder.getGroupDataId(),
					paramOrder.getGroupStatus(), title, openId, uid, resourceType);
			orderIdList.add(orderId);
		}
		
		//购物车设置为无效
		if(paramOrder.getShoppingCartIdList() != null && !paramOrder.getShoppingCartIdList().isEmpty()) {
			openStoreShoppingCartService.invalidShoppingCart(paramOrder.getShoppingCartIdList());
		}
		
		return orderIdList;
	} 
	
	/**
	 * @author:fukangwen
	 * @Description: 新增订单
	 * @return OpenStoreOrder
	 * @throws
	 */
	@Transactional
	public int createSingleOrder(MutiOrderCreateParam paramOrder, long communityId, String userName, String mobile, Long addrInfoId,
			String addrDetail, long groupDataId, int groupStatus, String title, String openId,
			Long uid, int resourceType) {
		//生成主订单
		OpenStoreOrder openStoreOrder = new OpenStoreOrder();
		BeanUtils.copyProperties(paramOrder, openStoreOrder);
		openStoreOrder.setCommunityId(communityId);
		openStoreOrder.setBody(title);
		openStoreOrder.setCreateTime(new Date());
		openStoreOrder.setInvalidTime(new Date(System.currentTimeMillis() + EXPIRE_TIME));
		openStoreOrder.setDetail(title);
		openStoreOrder.setOpenId(openId);
		openStoreOrder.setOrderCode("0");//默认值
		openStoreOrder.setPayStatus(OrderPayConstant.PayStatus.NO_PAYMENT.getCode());
		openStoreOrder.setSubject(title);
		openStoreOrder.setRefundStatus(0);
		openStoreOrder.setRefundComment("");
		openStoreOrder.setUserId(uid);
		openStoreOrder.setServiceId(paramOrder.getServiceId());
		openStoreOrder.setResourceType(resourceType);
		openStoreOrder.setUserName(userName);
		openStoreOrder.setMobile(mobile);
		openStoreOrder.setAddrDetail(addrDetail);
		openStoreOrder.setGoodsTotal(paramOrder.getGoodTotal());
		openStoreOrder.setAddrInfoId(addrInfoId == null ? 0 : addrInfoId.intValue());//此字段暂时没用
		openStoreOrder.setVerifyStatus("unverified");
		openStoreOrder.setCouponPrice(paramOrder.getCouponSubPrice());
		openStoreOrder.setCouponRecordId(paramOrder.getCouponRecordId());
		openStoreOrder.setGroupDataId(groupDataId);
		openStoreOrder.setGroupInfoId(paramOrder.getGroupInfoId());
		openStoreOrder.setGroupStatus(groupStatus);
		//更新订单信息
		openXFSJService.completeTypeInfo(openStoreOrder);

		//新增主订单
		openStoreOrderMapper.insertSelective(openStoreOrder);
		
		//设置orderCode
		openStoreOrder.setOrderCode(createOrderCode(openStoreOrder.getId()));
		openStoreOrderMapper.updateByPrimaryKeySelective(openStoreOrder);
		
		//减库存
		long now = System.currentTimeMillis();
		openStoreGoodService.reduceStock(groupDataId, paramOrder.getStoreGoodList(), openStoreOrder.getId());
		logger.info("加入购物车改变库存的总时间：耗时：{}", System.currentTimeMillis() - now);


		//锁券
		if(paramOrder.getCouponRecordId() > 0) {
			cmStoreCouponRecordService.lockCardCouponRecord(paramOrder.getCouponRecordId(), openStoreOrder.getOrderCode());
		}
		
		//新增商品-订单关联记录
		openStoreGoodOrderRelService.createGoodOrderRel(openStoreOrder.getId(),  paramOrder.getStoreGoodList());
		
		return openStoreOrder.getId();
	}

	/**
	 * @author:fukangwen
	 * @Description: 根据trade_no获取支付单详情
	 * @return Object
	 * @throws
	 */
	public SimOpenOrderTotal getDetailByCommunityOutTradeNo(String communityOutTradeNo) {
		OpenOrderTotalExample example = new OpenOrderTotalExample();
		example.createCriteria().andCommunityTradeNoEqualTo(communityOutTradeNo);
		List<OpenOrderTotal> list = openOrderTotalMapper.selectByExample(example);
		if(list.isEmpty())
			return null;
		
		OpenOrderTotal orderTotal = list.get(0);
		
		SimOpenOrderTotal simOrderTotal = new SimOpenOrderTotal();
		BeanUtils.copyProperties(orderTotal, simOrderTotal);
		return simOrderTotal;
	}

	public OpenStoreOrderPay getPayDetail(String outTradeNo) {
		return openStoreOrderPayService.getByOutTradeNo(outTradeNo);
	}

	/**
	 * @author:fukangwen
	 * @Description: 获取订单中商品的详情
	 * @return List<OpenStoreGoodOrderRel>
	 * @throws
	 */
	public List<OpenStoreGoodOrderRel> getRelList(int orderId) {
		OpenStoreGoodOrderRelExample example = new OpenStoreGoodOrderRelExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		return openStoreGoodOrderRelMapper.selectByExample(example);
	}
}
