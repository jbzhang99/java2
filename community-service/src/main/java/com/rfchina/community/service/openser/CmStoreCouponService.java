package com.rfchina.community.service.openser;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenConstant.CardRecordResource;
import com.rfchina.community.base.OpenConstant.CardRecordStatus;
import com.rfchina.community.base.OpenConstant.ConfirmStatus;
import com.rfchina.community.base.OpenConstant.CouponStatus;
import com.rfchina.community.component.UserMsgComponent;
import com.rfchina.community.persistence.mapper.CmActivityCardCouponItemMapper;
import com.rfchina.community.persistence.mapper.CmActivityCardCouponRecordMapper;
import com.rfchina.community.persistence.mapper.CmStoreCouponExtendMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.OpenQuickOrderMapper;
import com.rfchina.community.persistence.mapper.OpenStoreOrderMapper;
import com.rfchina.community.persistence.mapper.open.CmStoreCouponGlobalMapper;
import com.rfchina.community.persistence.model.CmActivityCardCouponItem;
import com.rfchina.community.persistence.model.CmActivityCardCouponRecord;
import com.rfchina.community.persistence.model.CmActivityCardCouponRecordExample;
import com.rfchina.community.persistence.model.CmStoreCouponExtend;
import com.rfchina.community.persistence.model.CmStoreCouponExtendExample;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.OpenQuickOrder;
import com.rfchina.community.persistence.model.OpenQuickOrderExample;
import com.rfchina.community.persistence.model.OpenStoreOrder;
import com.rfchina.community.persistence.model.OpenStoreOrderExample;
import com.rfchina.community.persistence.model.ext.ExtStoreCoupon;
import com.rfchina.community.service.BaseService;

@Service
public class CmStoreCouponService extends BaseService {
	private static Logger logger = LoggerFactory.getLogger(CmStoreCouponService.class);

	@Autowired
	private CmActivityCardCouponItemMapper cmActivityCardCouponItemMapper;

	@Autowired
	private CmStoreCouponExtendMapper cmStoreCouponExtendMapper;

	@Autowired
	private CmActivityCardCouponRecordMapper cmActivityCardCouponRecordMapper;

	@Autowired
	private CmStoreCouponGlobalMapper cmStoreCouponGlobalMapper;
	@Autowired
	private OpenStoreOrderMapper openStoreOrderMapper;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private UserMsgComponent userMsgComponent;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private OpenQuickOrderMapper openQuickOrderMapper;

	public PageList<ExtStoreCoupon> pageList(Map<String, Object> example, int index, int limit) {
		example.put("coupon_type", 1);
		PageBounds pageBounds = new PageBounds(index, limit);
		PageList<ExtStoreCoupon> list = cmStoreCouponGlobalMapper.pageByExample(example, pageBounds);
		for (ExtStoreCoupon extStoreCoupon : list) {
			Long couponId = extStoreCoupon.getId();
			extStoreCoupon.setDrawCount(drawCount(couponId));
			extStoreCoupon.setUseCount(confirmCount(couponId));
		}
		return list;
	}

	

	// 更新状态 平台用
	public int updateStoreCoupon(Long id, CouponStatus status) {

		CmActivityCardCouponItem selectByPrimaryKey = cmActivityCardCouponItemMapper.selectByPrimaryKey(id);
		validator(selectByPrimaryKey == null, "数据不存在!");

		if (selectByPrimaryKey.getStatus() == CouponStatus.delete.getStatus()) {
			validator(status.compareTo(CouponStatus.enabled) == 0, "已经删除不能启用");
			validator(status.compareTo(CouponStatus.disabled) == 0, "已经删除不能转停用");
		}

		CmActivityCardCouponItem record = new CmActivityCardCouponItem();
		record.setId(id);
		record.setUpdateTime(new Date());
		record.setStatus(status.getStatus());
		if (status.compareTo(CouponStatus.delete) == 0) {
			CmActivityCardCouponRecordExample example = new CmActivityCardCouponRecordExample();
			example.createCriteria().andCouponIdEqualTo(id);
			long userCount = cmActivityCardCouponRecordMapper.countByExample(example);
			validator(userCount > 0, "不能删除,已经认领人数为:" + userCount);
			// 物理删除

			cmStoreCouponExtendMapper.deleteByPrimaryKey(id);
			return cmActivityCardCouponItemMapper.deleteByPrimaryKey(id);

		} else {

			return cmActivityCardCouponItemMapper.updateByPrimaryKeySelective(record);
		}
	}

	public void checkCoupon(Long id, Integer serId) {
		CmStoreCouponExtendExample example = new CmStoreCouponExtendExample();
		example.createCriteria().andCardItemIdEqualTo(id).andServiceIdEqualTo(serId);
		validator(cmStoreCouponExtendMapper.countByExample(example) == 0, "非法操作!");
	}

	// 更新状态 商家服务用
	public int updateStoreCoupon(Long id, Integer serId, CouponStatus status) {
		checkCoupon(id, serId);
		return updateStoreCoupon(id, status);
	}

	public Long drawCount(Long couponId) {
		CmActivityCardCouponRecordExample example = new CmActivityCardCouponRecordExample();
		example.createCriteria().andCouponIdEqualTo(couponId).andStatusEqualTo(1);
		return cmActivityCardCouponRecordMapper.countByExample(example);
	}

	private Long confirmCount(Long couponId) {
		CmActivityCardCouponRecordExample example = new CmActivityCardCouponRecordExample();
		example.createCriteria().andCouponIdEqualTo(couponId).andStatusEqualTo(1).andConfirmStatusEqualTo(1);
		return cmActivityCardCouponRecordMapper.countByExample(example);
	}

	/**
	 * @author:fukangwen @Description: 新增券信息  @return Object @throws
	 */
	public ExtStoreCoupon insertStoreCoupon(ExtStoreCoupon extStoreCoupon) {
		CmActivityCardCouponItem item = new CmActivityCardCouponItem();
		BeanUtils.copyProperties(extStoreCoupon, item);
		cmActivityCardCouponItemMapper.insertSelective(item);

		CmStoreCouponExtend extend = new CmStoreCouponExtend();
		extend.setCardItemId(item.getId());
		extend.setLimitMoney(extStoreCoupon.getLimitMoney());
		extend.setServiceId(extStoreCoupon.getServiceId());
		extend.setMerchantId(extStoreCoupon.getMerchantId());
		cmStoreCouponExtendMapper.insertSelective(extend);

		return this.getStoreCouponInfo(item.getId());
	}

	/**
	 * @author:fukangwen @Description: 获取券详情 @return ExtStoreCoupon @throws
	 */
	public ExtStoreCoupon getStoreCouponInfo(long id) {
		CmActivityCardCouponItem selectByPrimaryKey = cmActivityCardCouponItemMapper.selectByPrimaryKey(id);
		validator(selectByPrimaryKey == null, "数据不存在!");
		ExtStoreCoupon extStoreCoupon = new ExtStoreCoupon();
		BeanUtils.copyProperties(selectByPrimaryKey, extStoreCoupon);

		CmStoreCouponExtend cmStoreCouponExtend = cmStoreCouponExtendMapper.selectByPrimaryKey(id);
		validator(cmStoreCouponExtend == null, "数据不存在!");

		extStoreCoupon.setLimitMoney(cmStoreCouponExtend.getLimitMoney());
		extStoreCoupon.setServiceId(cmStoreCouponExtend.getServiceId());
		return extStoreCoupon;
	}

	/**
	 * @author:fukangwen @Description: 更新券信息 @return Object @throws
	 */
	public void updateStoreCouponInfo(long id, String couponName, int couponNum, String remark) {
		CmActivityCardCouponItem selectByPrimaryKey = cmActivityCardCouponItemMapper.selectByPrimaryKey(id);
		validator(selectByPrimaryKey == null, "数据不存在!");
		CmActivityCardCouponItem record = new CmActivityCardCouponItem();
		record.setId(id);
		record.setUpdateTime(new Date());
		record.setRemark(remark);
		record.setCouponName(couponName);
		validator(selectByPrimaryKey.getOpenStatus() == OpenConstant.CouponOpenStatus.open && couponNum < 0, "库存不能小于0");
		record.setCouponNum(couponNum);
		cmActivityCardCouponItemMapper.updateByPrimaryKeySelective(record);
		
	}

	/**
	 * @author:fukangwen @Description: 发券 TODO @return void @throws
	 */
	public void giveOutStoreCoupon(long id, int type, String outTradeNo) {
		CmActivityCardCouponItem selectByPrimaryKey = cmActivityCardCouponItemMapper.selectByPrimaryKey(id);
		validator(selectByPrimaryKey == null, "数据不存在!");
		validator(selectByPrimaryKey.getOpenStatus() != OpenConstant.CouponOpenStatus.privated, "非公开券才能发券");
		CmStoreCouponExtend cmStoreCouponExtend = cmStoreCouponExtendMapper.selectByPrimaryKey(id);
		validator(cmStoreCouponExtend == null, "数据不存在!");
		
		// 根据类型发券，0为商品订单号， 1为闪付订单号
		validator(type != 0 && type != 1, "发券类型有误");
		
		Long uid = 0L;
		if (type == 0) {
			// 查找订单
			OpenStoreOrderExample example = new OpenStoreOrderExample();
			example.createCriteria().andOutTradeNoEqualTo(outTradeNo).andPayStatusEqualTo(OpenConstant.OpenStorePayStatus.PAY.getCode()); 
			List<OpenStoreOrder> orderList = openStoreOrderMapper.selectByExample(example);
			validator(orderList.isEmpty(), "商品订单号不存在，请重新输入");
			OpenStoreOrder order = orderList.get(0);
			// 存在支付成功的单发券
			insertCmCardCouponRecord(selectByPrimaryKey, CardRecordResource.store_send.getCode(), order.getUserId());
			uid = order.getUserId();
		} else {
			//  闪付
			OpenQuickOrderExample example = new OpenQuickOrderExample();
			example.createCriteria().andOutTradeNoEqualTo(outTradeNo); 
			List<OpenQuickOrder> orderList = openQuickOrderMapper.selectByExample(example);
			OpenQuickOrder order = orderList.get(0);
			validator(orderList.isEmpty(), "订单号不存在，请重新输入");
			// 存在支付成功的单发券
			insertCmCardCouponRecord(selectByPrimaryKey, CardRecordResource.store_send.getCode(), order.getUid());
			uid = order.getUid();
		}
		
		//获取店铺名
		CommunityService store = communityServiceMapper.selectByPrimaryKey(cmStoreCouponExtend.getServiceId());
		validator(store == null, "店铺不存在");
		String content = "恭喜您获得【" + store.getTitle() +"】的优惠券【" + selectByPrimaryKey.getCouponName() + "】,赶快去购买使用吧~";
		userMsgComponent.addMsg(0, "优惠券获取通知", content, uid, 3);
	}

	public void insertCmCardCouponRecord(CmActivityCardCouponItem item, int source, long uid) {
		CmActivityCardCouponRecord record = new CmActivityCardCouponRecord();
		record.setCouponId(item.getId());
		record.setValidFromDate(item.getValidFromDate());
		record.setValidToDate(item.getValidToDate());
		record.setCreateTime(new Date());
		record.setUpdateTime(record.getCreateTime());
		record.setCouponType(item.getCouponType());
		record.setItemType(item.getItemType());
		record.setSource(source);
		record.setStatus(CardRecordStatus.valid);
		record.setUid(uid);
		record.setConfirmStatus(ConfirmStatus.no_confirm);
		//存serviceId
		CmStoreCouponExtend extend = cmStoreCouponExtendMapper.selectByPrimaryKey(item.getId());
		record.setCardCouponId((long)extend.getServiceId());
		cmActivityCardCouponRecordMapper.insertSelective(record);
	}

	
}
