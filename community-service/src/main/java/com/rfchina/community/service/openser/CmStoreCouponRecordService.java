package com.rfchina.community.service.openser;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.Page;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenConstant.CardRecordResource;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.component.UserMsgComponent;
import com.rfchina.community.persistence.mapper.CmActivityCardCouponItemMapper;
import com.rfchina.community.persistence.mapper.CmActivityCardCouponRecordMapper;
import com.rfchina.community.persistence.mapper.CmStoreCouponExtendMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.UserInfoMapper;
import com.rfchina.community.persistence.mapper.open.CmActivityCardCouponRecordGlobalMapper;
import com.rfchina.community.persistence.model.CmActivityCardCouponItem;
import com.rfchina.community.persistence.model.CmActivityCardCouponRecord;
import com.rfchina.community.persistence.model.CmActivityCardCouponRecordExample;
import com.rfchina.community.persistence.model.CmStoreCouponExtend;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.UserInfo;
import com.rfchina.community.persistence.model.UserInfoExample;
import com.rfchina.community.persistence.model.ext.EXTCmActivityCardCouponRecord;
import com.rfchina.community.persistence.model.ext.SimCmActivityCardCouponRecord;
import com.rfchina.community.service.BaseService;

//优惠券领取记录

@Service
public class CmStoreCouponRecordService extends BaseService {
	private static Logger logger = LoggerFactory.getLogger(CmStoreCouponRecordService.class);

	@Autowired
	private CmActivityCardCouponRecordGlobalMapper cmActivityCardCouponRecordGlobalMapper;

	@Autowired
	private CmActivityCardCouponRecordMapper cmActivityCardCouponRecordMapper;
	@Autowired
	private CmStoreCouponExtendMapper cmStoreCouponExtendMapper;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private UserMsgComponent userMsgComponent;

	@Autowired
	// cm_activity_card_coupon_item
	private CmActivityCardCouponItemMapper cmActivityCardCouponItemMapper;
	@Autowired
	private UserInfoMapper userInfoMapper;

	public PageList<EXTCmActivityCardCouponRecord> pageList(Map<String, Object> example, int index, int limit,
			boolean phoneHide) {

		PageBounds pageBounds = new PageBounds(index, limit);
		PageList<EXTCmActivityCardCouponRecord> list = cmActivityCardCouponRecordGlobalMapper.pageByExample(example,
				pageBounds);
		for (EXTCmActivityCardCouponRecord extStoreCoupon : list) {

			Long uid = extStoreCoupon.getUid();
			UserInfo userinfo = getUserInfo(uid);
			if (userinfo != null) {
				String phone = userinfo.getPhone();
				if (phoneHide) {
					phone = phone.substring(0, 3) + "****" + phone.substring(7);
				}
				extStoreCoupon.setPhone(phone);
			}
		}
		return list;
	}

	public UserInfo getUserInfo(Long uid) {
		return userInfoMapper.selectByPrimaryKey(uid);
	}

	public UserInfo getUserInfoByPhone(String phone) {
		UserInfoExample example = new UserInfoExample();
		example.createCriteria().andPhoneEqualTo(phone);
		List<UserInfo> list = userInfoMapper.selectByExample(example);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	public PageList<EXTCmActivityCardCouponRecord> pageList(Long id, int index, int limit, boolean phoneHide) {
		Map<String, Object> example = new HashMap<>();
		example.put("coupon_id", id);
		return pageList(example, index, limit, phoneHide);
	}

	public String batchCouponByPhone(CmActivityCardCouponItem coupon, String phone, String content,
		 int serviceId, String operatorName, String operatorPhone) {
		if (StringUtils.isBlank(phone)) {
			return "手机号码为空!";
		}
		try {
			UserInfo userinfo = getUserInfoByPhone(phone);
			validator(userinfo == null, "发券失败，该手机未注册");
			addCoupon(coupon, userinfo.getId(), content, serviceId, operatorName, operatorPhone);
		} catch (Exception e) {
			return e.getMessage();
		}

		return "发券成功";
	}

//	`coupon_id` bigint(20) NOT NULL COMMENT '优惠卡券ID',
//	  `coupon_sn` varchar(100) NOT NULL DEFAULT '' COMMENT '领取编号',
	private void addCoupon(CmActivityCardCouponItem coupon, Long uid, String content,  int serviceId
		,String operatorName, String operatorPhone) {
		CmActivityCardCouponRecord record = new CmActivityCardCouponRecord();
		record.setActivityId(0L);
		record.setCardCouponId((long)serviceId);
		record.setCreateTime(new Date());
		record.setStatus(1);// '状态0为停用 1为启用'
		record.setIdcardNo("");// '电子卡编号/业务主键id'
		record.setConfirmCode("");// '兑换代码/订单号'
		record.setConfirmStatus(0);// '核销状态 0未核销 1核销 2核销中',
		record.setConfirmTime(null);
		record.setSource(CardRecordResource.platform_send.getCode());
		record.setCouponType(coupon.getCouponType());
		record.setValidFromDate(coupon.getValidFromDate());
		record.setValidToDate(coupon.getValidToDate());
		record.setUid(uid);
		record.setItemType(coupon.getItemType());
		record.setCouponId(coupon.getId());
		record.setUpdateTime(new Date());
		record.setOperatorName(operatorName);
		record.setOperatorPhone(operatorPhone);
		cmActivityCardCouponRecordMapper.insertSelective(record);
		// 生成
		Long id = record.getId();
		CmActivityCardCouponRecord r = new CmActivityCardCouponRecord();
		r.setId(id);
		String couponSn = buildCouponSn(id);
		r.setCouponSn(couponSn);
		cmActivityCardCouponRecordMapper.updateByPrimaryKeySelective(r);
		
		userMsgComponent.addMsg(0, "优惠券获取通知", content, uid, 3);
	}

	public String buildCouponSn(Long id) {
		return OpenStoreVerifyCardService.generateCode(id, 12);
	}

	/**
	 * @author:fukangwen @Description: 根据券状态返回券列表 ,1 @return Object @throws
	 */
	public Page<SimCmActivityCardCouponRecord> userCouponRecordList(Long uid, int status, int index, int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", uid);
		map.put("status", status);
		map.put("now", DateTimeUtils.format(new Date(), DateTimeUtils.DATETIME_FORMAT));
		PageBounds pageBounds = new PageBounds(index, limit, true);
		pageBounds.setAsyncTotalCount(false);
		PageList<SimCmActivityCardCouponRecord> list = cmActivityCardCouponRecordGlobalMapper.pageByParam(map,
				pageBounds);
		return list.convert();
	}

	/**
	 * @author:fukangwen @Description: 根据券状态返回券列表,不用分页 @return Object @throws
	 */
	public List<SimCmActivityCardCouponRecord> userValidCouponRecordList(Long uid, int serviceId,
			BigDecimal totalAmount) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", uid);
		map.put("status", 2);// 未使用
		map.put("serviceId", serviceId);
		totalAmount = totalAmount.setScale(2, BigDecimal.ROUND_HALF_DOWN);
		map.put("now", DateTimeUtils.format(new Date(), DateTimeUtils.DATETIME_FORMAT));
		PageBounds pageBounds = new PageBounds(1, Integer.MAX_VALUE);
		PageList<SimCmActivityCardCouponRecord> list = cmActivityCardCouponRecordGlobalMapper.pageByParam(map,
				pageBounds);

		// 排序
		for (SimCmActivityCardCouponRecord record : list) {

			// 判断是否超过limit_money
			record.setCanUse(true);
			long now = System.currentTimeMillis();
			if (record.getLimitMoney().compareTo(totalAmount) > 0 || now < record.getValidFromDate().getTime()
					|| now > record.getValidToDate().getTime()) {
				record.setCanUse(false);
				record.setTempPrice(totalAmount);
				continue;
			}
			BigDecimal tempPrice = new BigDecimal(0);
			if (OpenConstant.ItemType.discount.getCode() == record.getItemType()) {
				tempPrice = totalAmount.multiply(record.getPayAmount()).divide(new BigDecimal(10)).setScale(2,
						BigDecimal.ROUND_HALF_DOWN);
				record.setTempPrice(tempPrice);
				record.setCouponDiscountPrice(totalAmount.subtract(tempPrice).setScale(2, BigDecimal.ROUND_HALF_DOWN));
			}
			if (OpenConstant.ItemType.change.getCode() == record.getItemType()) {
				record.setTempPrice(
						totalAmount.subtract(record.getPayAmount()).setScale(2, BigDecimal.ROUND_HALF_DOWN));
				record.setCouponDiscountPrice(record.getPayAmount());
			}
			
			//总价小于等于0，也是不可以用的
			if(record.getTempPrice().compareTo(new BigDecimal(0)) <= 0) {
				record.setTempPrice(totalAmount);
				record.setCanUse(false);
			}
		}
		Collections.sort(list, new Comparator<SimCmActivityCardCouponRecord>() {
			public int compare(SimCmActivityCardCouponRecord record1, SimCmActivityCardCouponRecord record2) {
				/**
				 * 升序排的话就是第一个参数.compareTo(第二个参数); 降序排的话就是第二个参数.compareTo(第一个参数);
				 */
				return record1.getTempPrice().compareTo(record2.getTempPrice());// 升序
			}
		});
		return list;
	}

	// 获取券详细信息
	public SimCmActivityCardCouponRecord getCardCouponRecord(long recordId) {
		CmActivityCardCouponRecord record = cmActivityCardCouponRecordMapper.selectByPrimaryKey(recordId);
		validator(record == null, "优惠券不存在");
		SimCmActivityCardCouponRecord sim = new SimCmActivityCardCouponRecord();
		BeanUtils.copyProperties(record, sim);

		CmActivityCardCouponItem item = cmActivityCardCouponItemMapper.selectByPrimaryKey(record.getCouponId());
		CmStoreCouponExtend extend = cmStoreCouponExtendMapper.selectByPrimaryKey(record.getCouponId());
		validator(item == null || extend == null, "优惠券不存在");

		sim.setCardCouponId(Long.valueOf(extend.getServiceId()));
		sim.setPayAmount(item.getPayAmount());
		sim.setLimitMoney(extend.getLimitMoney());
		return sim;
	}

	// 锁券
	public int lockCardCouponRecord(long id, String orderCode) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("orderCode", orderCode);
		int row = cmActivityCardCouponRecordGlobalMapper.lockCardCouponRecord(param);
		return row;
	}

	// 核销
	public void confirm(String orderCode, String out_trade_no) {
		CmActivityCardCouponRecordExample example = new CmActivityCardCouponRecordExample();
		example.createCriteria().andConfirmCodeEqualTo(orderCode);
		List<CmActivityCardCouponRecord> list = cmActivityCardCouponRecordMapper.selectByExample(example);
		if (list.isEmpty())
			return;

		CmActivityCardCouponRecord record = list.get(0);

		record.setConfirmStatus(OpenConstant.ConfirmStatus.confirm);
		record.setConfirmTime(new Date());
		record.setIdcardNo(out_trade_no);
		cmActivityCardCouponRecordMapper.updateByPrimaryKey(record);
	}

	public int confirm(Long id, String confirmCode, Date time,String outTradeNo) {
		CmActivityCardCouponRecord record = new CmActivityCardCouponRecord();
		record.setConfirmStatus(OpenConstant.ConfirmStatus.confirm);
		record.setConfirmCode(confirmCode);
		record.setConfirmTime(time);
		record.setIdcardNo(outTradeNo);
		//
		CmActivityCardCouponRecordExample example = new CmActivityCardCouponRecordExample();
		example.createCriteria().andIdEqualTo(id).andConfirmStatusNotEqualTo(OpenConstant.ConfirmStatus.confirm);
		return cmActivityCardCouponRecordMapper.updateByExampleSelective(record, example);
	}

	public int cancel(Long id) {
		CmActivityCardCouponRecord record = new CmActivityCardCouponRecord();
		record.setConfirmStatus(OpenConstant.ConfirmStatus.no_confirm);
		record.setConfirmCode("");
		//
		CmActivityCardCouponRecordExample example = new CmActivityCardCouponRecordExample();
		example.createCriteria().andIdEqualTo(id).andConfirmStatusNotEqualTo(OpenConstant.ConfirmStatus.confirm);
		return cmActivityCardCouponRecordMapper.updateByExampleSelective(record, example);
	}

	// 解锁
	public void unlockCardCouponRecord(String orderCode) {
		CmActivityCardCouponRecordExample example = new CmActivityCardCouponRecordExample();
		example.createCriteria().andConfirmCodeEqualTo(orderCode);
		List<CmActivityCardCouponRecord> list = cmActivityCardCouponRecordMapper.selectByExample(example);
		if (list.isEmpty())
			return;

		CmActivityCardCouponRecord record = list.get(0);

		record.setConfirmStatus(OpenConstant.ConfirmStatus.no_confirm);
		record.setConfirmCode(null);
		cmActivityCardCouponRecordMapper.updateByPrimaryKey(record);
	}
}
