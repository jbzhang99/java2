package com.rfchina.community.openweb.service;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OrderPayConstant;
import com.rfchina.community.persistence.mapper.OpenOrderMapper;
import com.rfchina.community.persistence.mapper.OpenStoreOrderMapper;
import com.rfchina.community.persistence.model.OpenOrder;
import com.rfchina.community.persistence.model.OpenOrderExample;
import com.rfchina.community.persistence.model.OpenStoreOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenRefundService extends BaseService{

    private static Logger logger = LoggerFactory.getLogger(OpenRefundService.class);

    @Autowired
	private OpenStoreOrderMapper openStoreOrderMapper;
	@Autowired
	private OpenOrderMapper openOrderMapper;

	
	/**
	 * 审核通过
	 * @param storeOrderId
	 */
	/*public void auditPass(int storeOrderId) {
		OpenStoreOrder storeOrder = openStoreOrderMapper.selectByPrimaryKey(storeOrderId);
		validator(storeOrder == null, "订单不存在");
		validator(storeOrder.getRefundStatus() == OpenConstant.OpenStoreRefundStatus.ing.getCode()
				|| storeOrder.getRefundStatus() == OpenConstant.OpenStoreRefundStatus.Success.getCode()
				|| storeOrder.getRefundStatus() == OpenConstant.OpenStoreRefundStatus.user_apply.getCode()
				, "退款申请已提交了");
		
		storeOrder.setSameWay(OpenRefundConstant.SameWayStatus.original);
		storeOrder.setRefundStatus(OpenConstant.OpenStoreRefundStatus.ing.getCode());
		storeOrder.setRefundTime(new Date());
		openStoreOrderMapper.updateByPrimaryKeySelective(storeOrder);
		
		//更新openOrder
		OpenOrderExample example = new OpenOrderExample();
		example.createCriteria().andOutTradeNoEqualTo(storeOrder.getOutTradeNo());
		List<OpenOrder> list = openOrderMapper.selectByExample(example);
		validator(list.isEmpty(), "订单不存在");
		OpenOrder order = list.get(0);
		
		order.setRefundStatus(OpenConstant.open_order.RefundStatus.NO_REFUND);
		openOrderMapper.updateByPrimaryKeySelective(order);
		
    }*/
	
	/**
	 * 审核拒绝
	 * @param storeOrderId
	 */
	public void auditReject(int storeOrderId, String refundApproval) {
		OpenStoreOrder storeOrder = openStoreOrderMapper.selectByPrimaryKey(storeOrderId);
		validator(storeOrder == null, "订单不存在");
		storeOrder.setRefundStatus(OpenConstant.OpenStoreRefundStatus.error.getCode());
		storeOrder.setRefundApproval(refundApproval);
		openStoreOrderMapper.updateByPrimaryKeySelective(storeOrder);
		
		//更新openOrder
		OpenOrderExample example = new OpenOrderExample();
		example.createCriteria().andOutTradeNoEqualTo(storeOrder.getOutTradeNo());
		List<OpenOrder> list = openOrderMapper.selectByExample(example);
		validator(list.isEmpty(), "订单不存在");
		OpenOrder order = list.get(0);
		
		//退款失败
		order.setRefundStatus(OrderPayConstant.RefundStatus.FAILURE.getCode());
		openOrderMapper.updateByPrimaryKeySelective(order);
    }

}
