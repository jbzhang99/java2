package com.rfchina.community.openstore.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.persistence.mapper.CmActivityCardCouponItemMapper;
import com.rfchina.community.persistence.mapper.CmActivityCardCouponRecordMapper;
import com.rfchina.community.persistence.mapper.CmStoreCouponExtendMapper;
import com.rfchina.community.persistence.mapper.open.CmStoreCouponGlobalMapper;
import com.rfchina.community.persistence.model.CmActivityCardCouponItem;
import com.rfchina.community.persistence.model.CmActivityCardCouponRecordExample;
import com.rfchina.community.persistence.model.CmStoreCouponExtend;
import com.rfchina.community.persistence.model.ext.ExtStoreCoupon;
import com.rfchina.community.persistence.model.ext.SimCmActivityCardCouponRecord;
import com.rfchina.community.service.BaseService;
import com.rfchina.community.service.openser.CmStoreCouponRecordService;
import com.rfchina.community.service.openser.CmStoreCouponService;

@Service
public class CmOpenStoreCouponService extends BaseService {

	@Autowired
	private CmActivityCardCouponItemMapper cmActivityCardCouponItemMapper;

	@Autowired
	private CmStoreCouponExtendMapper cmStoreCouponExtendMapper;

	@Autowired
	private CmActivityCardCouponRecordMapper cmActivityCardCouponRecordMapper;

	@Autowired
	private CmStoreCouponGlobalMapper cmStoreCouponGlobalMapper;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private CmStoreCouponService cmStoreCouponService;
	@Autowired
	private CmStoreCouponRecordService cmStoreCouponRecordService;
	
	/**
	 * 用户领券
	 */
	public void receiveStoreCoupon(long uid, long couponId, int serviceId) {
		//验证券是不是该服务的
		CmStoreCouponExtend itemExtend = cmStoreCouponExtendMapper.selectByPrimaryKey(couponId);
		validator(itemExtend == null, "该券不存在");
		validator(itemExtend.getServiceId().intValue() != serviceId, "非法领券");
		
		CmActivityCardCouponItem item = cmActivityCardCouponItemMapper.selectByPrimaryKey(couponId);
		validator(item == null, "该券不存在");
		validator(item.getStatus() != OpenConstant.CouponStatus.enabled.getStatus(), "该券还未启用");
		validator(item.getOpenStatus() == OpenConstant.CouponOpenStatus.privated, "该券为非公开券,不能领券");
		validator(item.getCouponNum() <= 0, "该券已经领取完");
		//判断用户可领取次数是否超过
		long receiveCount = this.getUserReceiveStoreCouponCount(uid, couponId);
		validator(item.getUserLimit() > 0 && item.getUserLimit() <= receiveCount, "领取次数已达上限");
		
		//减库存
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", item.getId());
		param.put("decNum", 1);
		int row = cmStoreCouponGlobalMapper.reduceCouponNum(param);
		validator(row <= 0, "该券已经领取完");
		//加入数据库
		cmStoreCouponService.insertCmCardCouponRecord(item, OpenConstant.CouponSource.user_receive, uid);
		
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 判断用户主动领取券的数量
	 * @return Integer
	 * @throws
	 */
	private long getUserReceiveStoreCouponCount(long uid, long couponId) {
		CmActivityCardCouponRecordExample example = new CmActivityCardCouponRecordExample();
		example.createCriteria().andCouponIdEqualTo(couponId).andStatusEqualTo(1)
			.andUidEqualTo(uid).andSourceEqualTo(OpenConstant.CouponSource.user_receive);
		return cmActivityCardCouponRecordMapper.countByExample(example);
	}

	/**
	 * 店铺券列表(不分页)
	 */
	public List<ExtStoreCoupon> getValidStoreCouponList(int serviceId){
		Map<String, Object> example = new HashMap<String, Object>();
		example.put("coupon_type", 1);
		example.put("service_id", serviceId);
		example.put("open_status", OpenConstant.CouponOpenStatus.open);
		example.put("status", OpenConstant.CouponStatus.enabled.getStatus());
		PageBounds pageBounds = new PageBounds(1, Integer.MAX_VALUE);
		PageList<ExtStoreCoupon> list = cmStoreCouponGlobalMapper.pageByExample(example, pageBounds);
		for (ExtStoreCoupon extStoreCoupon : list) {
			Boolean isFull = extStoreCoupon.getCouponNum() <= 0 ? true : false;
			extStoreCoupon.setIsFull(isFull);
		}
		return list;
	}

	/**
	 * @author:fukangwen
	 * @Description: 获取使用券减免的金额
	 * @return BigDecimal
	 * @throws
	 */
	public BigDecimal getCouponDiscountMoney(long couponRecordId, BigDecimal totalAmount, long uid, int serviceId) {
		BigDecimal couponDiscountMoney = new BigDecimal(0);
		SimCmActivityCardCouponRecord sim = cmStoreCouponRecordService.getCardCouponRecord(couponRecordId);
		validator(sim.getCardCouponId() != serviceId || sim.getUid().longValue() != uid, "优惠券异常");
		
		//判断有效期
		long now = System.currentTimeMillis();
		validator(sim.getValidFromDate().getTime() > now, "此优惠券还未到活动时间");
		validator(sim.getValidToDate().getTime() < now, "此优惠券已过期");
		validator(sim.getConfirmStatus() == OpenConstant.ConfirmStatus.confirm, "该券已经被使用");
		validator(sim.getConfirmStatus() == OpenConstant.ConfirmStatus.confirming, "该券已经被锁定,请及时支付未完成的订单");
		
		validator(sim.getLimitMoney().compareTo(totalAmount) > 0, "此优惠券不满足使用条件");
		
		if(OpenConstant.ItemType.change.getCode() == sim.getItemType()) {
			couponDiscountMoney = sim.getPayAmount();
		}
		if(OpenConstant.ItemType.discount.getCode() == sim.getItemType()) {
			BigDecimal temp = totalAmount.multiply(sim.getPayAmount()).divide(new BigDecimal(10)).setScale(2, BigDecimal.ROUND_HALF_DOWN);
			couponDiscountMoney = totalAmount.subtract(temp);
		}
		return couponDiscountMoney;
	}
	
	
	
}
