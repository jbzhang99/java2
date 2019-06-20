package com.rfchina.community.openweb.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenConstant.CouponStatus;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.base.util.MyUtils;
import com.rfchina.community.base.util.RegexUtils;
import com.rfchina.community.base.util.ValidatorUtil;
import com.rfchina.community.component.UserMsgComponent;
import com.rfchina.community.openweb.service.CommunityServiceService;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.ext.ExtStoreCoupon;
import com.rfchina.community.service.openser.CmStoreCouponService;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENWEB)
public class CmStoreCouponController extends BaseController {

	@Autowired
	private CmStoreCouponService cmStoreCouponService;
	@Autowired
	private CommunityServiceService communityServiceService;
	@Autowired
	private UserMsgComponent userMsgComponent;
	
	

	@RequestMapping(value = { "/store_coupon_page_list" })
	public Result<?> pageList(@RequestParam(value = "service_id", required = true) int service_id,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size,
			@RequestParam() Map<String, Object> example) {
		authorityCheck(service_id);
		example.put("service_id", service_id+"");
		
		MyUtils.likeMap(example, "merchant_name","service_name","coupon_name");
		
		
//		Map<String, Object> example = null;
		return Result.successData(cmStoreCouponService.pageList(example, index, size).convert());
	}

	@RequestMapping(value = { "/store_coupon_update_status" })
	public Result<?> updateStoreCoupon(@RequestParam(value = "service_id", required = true) int service_id,
			@RequestParam(value = "id", required = true) Long id,
			@RequestParam(value = "status", required = true) Integer status) {
		authorityCheck(service_id);
		return Result.successData(cmStoreCouponService.updateStoreCoupon(id, service_id, CouponStatus.trun(status)));
	}

	
	/**
	 * 新增
	 * @throws ParseException 
	 */
	@RequestMapping("/store_coupon_insert")
	public Result<?> insertStoreCoupon(
			@RequestParam(value = "serviceId", required = true) int serviceId,
			@RequestParam(value = "couponName", required = true) String couponName,
			@RequestParam(value = "openStatus", required = true) int openStatus,
			@RequestParam(value = "couponNum", required = false, defaultValue="0") int couponNum,
			@RequestParam(value = "itemType", required = true) int itemType,
			@RequestParam(value = "payAmount", required = true) String payAmount,
			@RequestParam(value = "limitMoney", required = true) String limitMoney,
			@RequestParam(value = "userLimit", required = false, defaultValue="1") int userLimit,
			@RequestParam(value = "validFromDate", required = true) String validFromDate,
			@RequestParam(value = "validToDate", required = true) String validToDate,
			@RequestParam(value = "remark", required = false, defaultValue="") String remark
			) throws ParseException {
	
		ExtStoreCoupon extStoreCoupon = insertCheck(serviceId, couponName, openStatus, couponNum, itemType, payAmount, 
				limitMoney, userLimit, validFromDate, validToDate, remark);
		
		return Result.successData(cmStoreCouponService.insertStoreCoupon(extStoreCoupon));
	}
	
	/**
	 * @throws ParseException 
	 * @author:fukangwen
	 * @Description: 新增或修改參數驗證
	 * @return void
	 * @throws
	 */
	private ExtStoreCoupon insertCheck(int serviceId, String couponName, int openStatus, int couponNum, int itemType,
			String payAmount, String limitMoney, int userLimit, String validFromDate, String validToDate,
			String remark) throws ParseException {
		authorityCheck(serviceId);
		//要不要判断服务是否可以创建
		CommunityService communityService = communityServiceService.getCommunityServiceByPrimaryKey(serviceId);
		validator(communityService == null, "服务不存在");
		validator(communityService.getStatus() != 1, "服务上架才能创建");
		ExtStoreCoupon extStoreCoupon = new ExtStoreCoupon();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date validFromTime = null;
		Date validToTime= null;
		ValidatorUtil.verify(validFromDate, "有效开始时间");
		validFromTime = sdf.parse(validFromDate);
		ValidatorUtil.verify(validToDate, "有效结束时间");
		validToTime = sdf.parse(validToDate);
		
		extStoreCoupon.setMerchantId(communityService.getMerchantId());
		extStoreCoupon.setValidFromDate(validFromTime);
		extStoreCoupon.setValidToDate(validToTime);
		
		ValidatorUtil.verify(couponName, "优惠券名称", true, 1, 20);
		extStoreCoupon.setCouponName(couponName);
		extStoreCoupon.setServiceId(serviceId);
		
		extStoreCoupon.setCreateTime(new Date());
		extStoreCoupon.setUpdateTime(extStoreCoupon.getCreateTime());
		extStoreCoupon.setCouponType(1);// 商家券为1，平台券为0
		
		validator(!OpenConstant.ItemType.isExist(itemType), "不存在该优惠形式");
		extStoreCoupon.setItemType(itemType);
		
		extStoreCoupon.setOpenStatus(openStatus);
		
		validator(openStatus == OpenConstant.CouponOpenStatus.open && couponNum < 0, "优惠券库存需要为正整数");
		extStoreCoupon.setCouponNum(couponNum);
		
	
		
		validator(!RegexUtils.isPositiveNum(payAmount), "优惠字段必须为正的数字");
		if(OpenConstant.ItemType.discount.getCode() == itemType) {
			BigDecimal disCountAmount = new BigDecimal(payAmount).setScale(1, BigDecimal.ROUND_DOWN);
			validator(disCountAmount.compareTo(new BigDecimal(0)) <= 0 || 
					disCountAmount.compareTo(new BigDecimal(10)) >= 0, "折扣券范围应在0~10之间,小数位最多一位");
			extStoreCoupon.setPayAmount(disCountAmount);
		}else {
			BigDecimal changeAmount = new BigDecimal(payAmount);
			validator(changeAmount.compareTo(new BigDecimal(0)) <= 0,"抵用券必须为正的数字");
			extStoreCoupon.setPayAmount(changeAmount);
		}
		
		validator(!RegexUtils.isPositiveNum(limitMoney), "使用门槛必须为正的数字");
		extStoreCoupon.setLimitMoney(new BigDecimal(limitMoney));
		validator(OpenConstant.ItemType.change.getCode() == itemType
				&& extStoreCoupon.getLimitMoney().compareTo(extStoreCoupon.getPayAmount()) <= 0, "抵扣券门槛必须大于可抵用价格");
		
		ValidatorUtil.verify(remark, "使用说明", false, 0, 200);
		extStoreCoupon.setRemark(remark);
		//公开券禁用，非公开启用
		extStoreCoupon.setStatus(openStatus == OpenConstant.CouponOpenStatus.open ? 
				OpenConstant.CouponStatus.disabled.getStatus() : OpenConstant.CouponStatus.enabled.getStatus()); //给默认值
		extStoreCoupon.setUserLimit(userLimit);
		extStoreCoupon.setUseRule("满" + limitMoney + "元可用");
		
		return extStoreCoupon;

	}

	
	/**
	 * 获取详情
	 */
	@RequestMapping("/get_store_coupon_info")
	public Result<?> getStoreCouponInfo(
			@RequestParam(value = "serviceId", required = true) int serviceId,
			@RequestParam(value = "id", required = true) long id) {
		authorityCheck(serviceId);
		return Result.successData(cmStoreCouponService.getStoreCouponInfo(id));
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/store_coupon_update_info")
	public Result<?> updateStoreCouponInfo(
			@RequestParam(value = "serviceId", required = true) int serviceId,
			@RequestParam(value = "id", required = true) long id,
			@RequestParam(value = "couponName", required = true) String couponName,
			@RequestParam(value = "couponNum", required = false, defaultValue="0") int couponNum,
			@RequestParam(value = "remark", required = false, defaultValue="") String remark
			) {
		authorityCheck(serviceId);
		validator(couponNum < 0, "优惠券库存不能为负数");
		ValidatorUtil.verify(couponName, "优惠券名称", true, 1, 20);
		ValidatorUtil.verify(remark, "优惠券名称", false, 0, 200);
		cmStoreCouponService.updateStoreCouponInfo(id, couponName,
				couponNum,remark);
		return Result.success();
	}
	
	
	/**
	 * 发券
	 */
	@RequestMapping("/give_out_store_coupon")
	public Result<?> giveOutStoreCoupon(
			@RequestParam(value = "serviceId", required = true) int serviceId,
			@RequestParam(value = "id", required = true) long id,
			@RequestParam(value = "type", required = false, defaultValue="0") int type, 	//类型，0为商品订单号， 1为闪付订单号
			@RequestParam(value = "outTradeNo", required = true) String outTradeNo
			) {
		authorityCheck(serviceId);
		cmStoreCouponService.giveOutStoreCoupon(id, type, outTradeNo);
		
		return Result.success();
	}
	
}
