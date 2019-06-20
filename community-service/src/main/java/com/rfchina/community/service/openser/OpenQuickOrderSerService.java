package com.rfchina.community.service.openser;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.persistence.mapper.OpenQuickOrderMapper;
import com.rfchina.community.persistence.mapper.OpenQuickOrderPayMapper;
import com.rfchina.community.persistence.mapper.open.OpenQuickOrderGlobalMapper;
import com.rfchina.community.persistence.model.OpenOrder;
import com.rfchina.community.persistence.model.OpenQuickOrder;
import com.rfchina.community.persistence.model.OpenQuickOrderExample;
import com.rfchina.community.persistence.model.OpenQuickOrderExample.Criteria;
import com.rfchina.community.persistence.model.OpenQuickOrderPay;
import com.rfchina.community.persistence.model.UserInfo;
import com.rfchina.community.persistence.model.ext.ExtOpenQuickOrder;
import com.rfchina.community.service.BaseService;
import com.rfchina.community.service.UserInfoSerService;

@Service
public class OpenQuickOrderSerService extends BaseService {
	
	private static Logger logger = LoggerFactory.getLogger(OpenQuickOrderSerService.class);
	
	@Autowired
	private OpenQuickOrderMapper openQuickOrderMapper;
	@Autowired
	private OpenQuickOrderPayMapper openQuickOrderPayMapper;
	@Autowired
	private OpenQuickOrderGlobalMapper openQuickOrderGlobalMapper;
	@Autowired
	private UserInfoSerService userInfoSerService;

	@Autowired
	private CmStoreCouponRecordService cmStoreCouponRecordService;

	public static String PAY_TRADE_NO_PREFIX = "QUICK_";

	public int saveOpenQuickOrder(OpenQuickOrder order) {
		try {
			return openQuickOrderMapper.insertSelective(order);
		} finally {
			Long couponId = order.getCouponId();
			if (couponId != null && couponId > 0) {
				cmStoreCouponRecordService.lockCardCouponRecord(couponId, quickId(order.getId()));
			}
		}
	}

	public String quickId(Long id) {
		return PAY_TRADE_NO_PREFIX + id;
	}

	public int saveOpenQuickOrderPay(OpenQuickOrderPay order) {
		return openQuickOrderPayMapper.insertSelective(order);
	}

	public int updateOpenQuickOrder(OpenQuickOrder order) {
		return openQuickOrderMapper.updateByPrimaryKeySelective(order);
	}

	public int updateOpenQuickOrder(OpenQuickOrder order, Long id) {
		OpenQuickOrderExample example = new OpenQuickOrderExample();
		example.createCriteria().andIdEqualTo(id).andBillStatusNotEqualTo(2);
		return openQuickOrderMapper.updateByExampleSelective(order, example);
	}

	public int updateOpenQuickOrderPay(OpenQuickOrderPay order) {
		return openQuickOrderPayMapper.updateByPrimaryKeySelective(order);
	}

	public OpenQuickOrder getOpenQuickOrder(Long orderId) {
		return openQuickOrderMapper.selectByPrimaryKey(orderId);
	}

	public OpenQuickOrderPay getOpenQuickOrderPay(String id) {
		return openQuickOrderPayMapper.selectByPrimaryKey(id);
	}

	public void createQuickOrderPay(String outTradeNo, Long quickId, String payChannel, String tradeType,
			String communityTradeNo) {

		OpenQuickOrderPay record = new OpenQuickOrderPay();
		record.setBillId(null);
		record.setCommunityTradeNo(communityTradeNo);
		record.setCreateTime(new Date());
		record.setOutTradeNo(outTradeNo);
		record.setPayChannel(payChannel);
		record.setQuickId(quickId);
		record.setTradeType(tradeType);
		record.setStatus(1);
		saveOpenQuickOrderPay(record);
	}

	// 闪付直接
	public String exeQuick(List<OpenOrder> list, Map<String, String> map) {
		String notify_scene = MapUtils.getString(map, "notify_scene", "");
		Long pay_time = MapUtils.getLong(map, "pay_time");
		for (OpenOrder openOrder : list) {
			String outTradeNo = openOrder.getOutTradeNo();
			OpenQuickOrderPay pay = getOpenQuickOrderPay(outTradeNo);
			if (pay == null)
				return "null" + outTradeNo;
			OpenQuickOrder quickOrder = getOpenQuickOrder(pay.getQuickId());

			if ("TRADE_PAID_SUCCESS".equalsIgnoreCase(notify_scene)) {


				Date payTime = new Date(pay_time);
				OpenQuickOrderPay data = new OpenQuickOrderPay();
				data.setOutTradeNo(outTradeNo);
				data.setStatus(2);
				data.setBillId(openOrder.getBillId());
				data.setSuccessTime(payTime);
				updateOpenQuickOrderPay(data);
				OpenQuickOrder order = new OpenQuickOrder();
				order.setOutTradeNo(outTradeNo);
				order.setBillStatus(2);
				order.setBillId(openOrder.getBillId());
				order.setPayTime(payTime);
				order.setCommunityTradeNo(openOrder.getCommunityTradeNo());
				order.setBillId(openOrder.getBillId());
				order.setId(pay.getQuickId());
				updateOpenQuickOrder(order);

				Long couponId = quickOrder.getCouponId();
				if (couponId != null && couponId > 0) {
					cmStoreCouponRecordService.confirm(couponId, quickId(pay.getQuickId()), payTime, outTradeNo);
				}
				return "success";
			} else if ("TRADE_TIMEOUT_CLOSE".equalsIgnoreCase(notify_scene)
					|| "TRADE_PAID_FAILURE".equalsIgnoreCase(notify_scene)) {
				logger.info("TRADE_TIMEOUT_CLOSE-TRADE_PAID_FAILURE:{}",outTradeNo);
				OpenQuickOrderPay data = new OpenQuickOrderPay();
				data.setOutTradeNo(outTradeNo);
				data.setStatus(3);
				data.setBillId(openOrder.getBillId());
				updateOpenQuickOrderPay(data);

				OpenQuickOrder order = openQuickOrderMapper.selectByPrimaryKey(pay.getQuickId());
				if(order != null && order.getBillStatus() != 2) {
					order.setBillStatus(3);
					order.setId(pay.getQuickId());
					updateOpenQuickOrder(order);
				}
				
				Long couponId = quickOrder.getCouponId();
				if (couponId != null && couponId > 0) {
					cmStoreCouponRecordService.cancel(couponId);
				}
				return "success";
			}
		}
		return "error";

	}

	public PageList<ExtOpenQuickOrder> listQuickOrder(Map<String, Object> example, int page, int limit,
			boolean phoneHide) {
		PageBounds pageBounds = new PageBounds(page, limit);

		String phone = MapUtils.getString(example, "phone");
		if (StringUtils.isNotBlank(phone)) {
			example.put("uid", userInfoSerService.userInfoByPhone(phone));
		}

		PageList<ExtOpenQuickOrder> pager = openQuickOrderGlobalMapper.pageByExample(example, pageBounds);
		for (ExtOpenQuickOrder order : pager) {
			Long uid = order.getUid();
			UserInfo userinfo = userInfoSerService.getUserInfo(uid);

			if (userinfo != null) {
				String phone1 = userinfo.getPhone();
				if (phoneHide) {
					phone1 = phone1.substring(0, 3) + "****" + phone1.substring(7);
				}
				order.setPhone(phone1);
			}

		}
		return pager;
	}

	public ExtOpenQuickOrder getQuickOrder(Long id, int serviceId, Long uid) {
		PageBounds pageBounds = new PageBounds(1, 1);
		Map<String, Object> example = new HashMap<>();
		example.put("id", id);
		example.put("service_id", serviceId);
		example.put("uid", uid);
		PageList<ExtOpenQuickOrder> pager = openQuickOrderGlobalMapper.pageByExample(example, pageBounds);
		for (ExtOpenQuickOrder order : pager) {
			uid = order.getUid();
			UserInfo userinfo = userInfoSerService.getUserInfo(uid);
			if (userinfo != null) {
				order.setPhone(userinfo.getPhone());
			}

		}
		if (pager.isEmpty())
			return new ExtOpenQuickOrder();
		return pager.get(0);
	}

	public int cancel(Long id, Long uid) {
		return cancel(id, uid, true,4);
	}

	public int cancel(Long id, Long uid, boolean flag,int billStatus) {

		OpenQuickOrder order = openQuickOrderMapper.selectByPrimaryKey(id);
		validator(order == null, "订单不存在!");

		OpenQuickOrder record = new OpenQuickOrder();
		record.setBillStatus(billStatus);// 用户关闭

		OpenQuickOrderExample example = new OpenQuickOrderExample();
		Criteria cre = example.createCriteria().andIdEqualTo(id);
		if (flag) {
			validator(flag && order.getUid() != uid.longValue(), "非法访问!");
			cre.andUidEqualTo(uid);
		}

		int i = openQuickOrderMapper.updateByExampleSelective(record, example);

		if (order != null) {
			Long cid = order.getCouponId();
			if (cid != null && cid > 0) {
				cmStoreCouponRecordService.cancel(cid);
			}
		}

		return i;
	}


	public void canceltesk() {
		OpenQuickOrderExample example = new OpenQuickOrderExample();
		example.createCriteria().andBillStatusEqualTo(1)
				.andCreateTimeLessThan(new Date(System.currentTimeMillis() - 1000L * 60 * 40));
		List<OpenQuickOrder> list = openQuickOrderMapper.selectByExample(example);
		for (OpenQuickOrder openQuickOrder : list) {
			logger.info("openQuickOrder-start:{}", JSON.toJSONString(openQuickOrder));
			int i = cancel(openQuickOrder.getId(), 0L, false,3);
			logger.info("openQuickOrder-end,i:{}", i);
		}
	}

}
