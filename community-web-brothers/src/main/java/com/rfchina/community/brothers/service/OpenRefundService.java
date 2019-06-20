package com.rfchina.community.brothers.service;

import java.util.Date;
import java.util.List;

import com.rfchina.community.base.OrderPayConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenRefundConstant;
import com.rfchina.community.base.OpenConstant.OpenStoreRefundStatus;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.OpenStoreOrderMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.OpenStoreOrder;
import com.rfchina.community.persistence.model.OpenStoreOrderExample;
import com.rfchina.community.service.openser.OpenOrderSerService;

@Service
public class OpenRefundService{
	
	@Value("${app.environment}")
	private String environment;
	@Autowired
	private OpenOrderSerService openOrderSerService;
	@Autowired
	private OpenStoreOrderMapper openStoreOrderMapper;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	private static Logger logger = LoggerFactory.getLogger(OpenRefundService.class);
	/**
	 * 
	 * @Description: 订单退款审核自动通过 @throws
	 */
	public int auditRefundAuditPass(){
		long time = 3 * 24 * 3600000;// 3天;

		if ("test".equals(environment)) {
			// 测试环境1小时
			time = 3600000L;	//test 1小时
		}
		//做筛选
		Date threeDayBefore = new Date((new Date().getTime()) - time);
		
		OpenStoreOrderExample example = new OpenStoreOrderExample();
		example.createCriteria().andPayStatusEqualTo(OpenConstant.OpenStorePayStatus.PAY.getCode())
			.andPayChannelNotEqualTo(OpenConstant.PayChannel.UnionPay)
			.andRefundStatusEqualTo(OpenConstant.OpenStoreRefundStatus.user_apply.getCode())
			.andRefundTimeLessThan(threeDayBefore);
		List<OpenStoreOrder> list = openStoreOrderMapper.selectByExample(example);
		int count = 0;
		if(list.isEmpty())
			return count;
		for(OpenStoreOrder openStoreOrder : list) {
			count += refund(openStoreOrder);
		}
		return count;
	}
	
	private int refund(OpenStoreOrder openStoreOrder) {
		CommunityService ser = communityServiceMapper.selectByPrimaryKey(openStoreOrder.getServiceId());
		Long appId = ser.getAppId();
		int day = OpenConstant.refund_store_day;// 14;

		if ("test".equals(environment)) {
			// 测试环境1天后不能退款
			day = OpenConstant.TEST_BATCH_RUN;// 1;
		}
		logger.info("pay_refund:appId:{} outTradeNo:{},environment:{},day:{}", appId, openStoreOrder.getOutTradeNo(),
				 environment, day);
		int flag = openOrderSerService.payRefund(appId, openStoreOrder.getOutTradeNo(), day, openStoreOrder.getRefundComment(),
				OpenRefundConstant.SameWayStatus.original);

		if (flag > 0) {
			//openStoreOrder.setRefundStatus(OpenStoreRefundStatus.ing.getCode());
			openStoreOrder.setRefundStatus(OrderPayConstant.RefundStatus.PC_UPPING.getCode());
			openStoreOrder.setRefundTime(new Date());
			openStoreOrder.setRefundApproval("");
			openStoreOrder.setSameWay(OpenRefundConstant.SameWayStatus.original);
			openStoreOrderMapper.updateByPrimaryKeySelective(openStoreOrder);
			return 1;
		}
		return 0;
	}
	
}
