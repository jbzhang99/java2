package com.rfchina.community.openstore.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.rfchina.community.base.OrderPayConstant;
import com.rfchina.community.base.SysConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.OpenStoreOrderMapper;
import com.rfchina.community.persistence.mapper.OpenStoreOrderPayMapper;
import com.rfchina.community.persistence.model.OpenStoreOrder;
import com.rfchina.community.persistence.model.OpenStoreOrderPay;
import com.rfchina.community.persistence.model.OpenStoreOrderPayExample;
import com.rfchina.community.service.openser.CmStoreCouponRecordService;

/**
 * @author:fukangwen
 * @Description: 模板支付service
 */
@Service
public class OpenStoreOrderPayService extends BaseService {

	@Autowired
	private OpenStoreOrderPayMapper openStoreOrderPayMapper;
	@Autowired
	private OpenStoreOrderMapper openStoreOrderMapper;
	@Autowired
	private CmStoreCouponRecordService cmStoreCouponRecordService;

	/**
	 * @author:fukangwen @Description: 创建 @return void @throws
	 */
	public void create(OpenStoreOrderPay record) {
		openStoreOrderPayMapper.insert(record);

	}
	
	/**
	 * @author:fukangwen 
	 */
	public void mutiCreate(List<String> outTradeNoList, Map<String, Integer> rel, String payChannel, String tradeType, String communityTradeNo) {
		for(String outTradeNo : outTradeNoList) {
			Integer orderId = rel.get(outTradeNo);
			OpenStoreOrder openStoreOrder = openStoreOrderMapper.selectByPrimaryKey(orderId);
			OpenStoreOrderPay pay = new OpenStoreOrderPay();
			pay.setCommunityTradeNo(communityTradeNo);
			pay.setCreateTime(new Date());
			pay.setOpenId(openStoreOrder.getOpenId());
			pay.setOutTradeNo(outTradeNo);
			pay.setPayChannel(payChannel);
			pay.setPayStatus(OrderPayConstant.PayStatus.NO_PAYMENT.getCode());
			pay.setServiceId(openStoreOrder.getServiceId());
			pay.setStoreOrderId(openStoreOrder.getId());
			pay.setTradeType(tradeType);
			pay.setTotalAmount(openStoreOrder.getTotalAmount());
			this.create(pay);
		}
		
	}
	

	/**
	 * @author:fukangwen @Description: 根据out_trade_no查询支付记录 @return
	 *                   OpenStoreOrderPay @throws
	 */
	public OpenStoreOrderPay getByOutTradeNo(String out_trade_no) {
		OpenStoreOrderPayExample example = new OpenStoreOrderPayExample();
		example.createCriteria().andOutTradeNoEqualTo(out_trade_no);
		List<OpenStoreOrderPay> list = openStoreOrderPayMapper.selectByExample(example);
		if (list.isEmpty())
			return null;

		return list.get(0);
	}

	// 支付状态查询
	public long successPayByid(int id, Integer status) {
		OpenStoreOrderPayExample example = new OpenStoreOrderPayExample();
		// store_order_id
		example.createCriteria().andStoreOrderIdEqualTo(id).andPayStatusEqualTo(status);
		return openStoreOrderPayMapper.countByExample(example);
	}

	public OpenStoreOrderPay getById(int id) {
		return openStoreOrderPayMapper.selectByPrimaryKey(id);

	}

	/**
	 * @author:fukangwen @Description: 更新 @return void @throws
	 */
	public void update(OpenStoreOrderPay openStoreOrderPay) {
		openStoreOrderPayMapper.updateByPrimaryKeySelective(openStoreOrderPay);

	}

	/**
	 * @author:fukangwen @Description: 超时更新状态 @return void @throws
	 */
	public void payFailure(String out_trade_no) {
		OpenStoreOrderPay pay = this.getByOutTradeNo(out_trade_no);
		if (pay != null) {
			pay.setPayStatus(OrderPayConstant.PayStatus.FAILURE.getCode());
			pay.setPayTime(new Date());
			openStoreOrderPayMapper.updateByPrimaryKeySelective(pay);
		}
	}
	
	/**
	 * @author:fukangwen @Description: 超时更新状态 @return void @throws
	 */
	public void timeOutClose(String out_trade_no) {
		OpenStoreOrderPay pay = this.getByOutTradeNo(out_trade_no);
		if (pay != null) {
			pay.setPayStatus(OrderPayConstant.PayStatus.INVALID.getCode());
			pay.setPayTime(new Date());
			openStoreOrderPayMapper.updateByPrimaryKeySelective(pay);
		}
	}

	public void refund(String out_trade_no, int refundStatus) {
		OpenStoreOrderPay pay = this.getByOutTradeNo(out_trade_no);
		if (pay != null) {
			Integer id = pay.getId();
			Integer orderid = pay.getStoreOrderId();
			pay = new OpenStoreOrderPay();
			pay.setId(id);
			pay.setRefundStatus(refundStatus);
			pay.setRefundTime(new Date());
			pay.setRefundApproval("");
			pay.setRefundEmail(0);
			openStoreOrderPayMapper.updateByPrimaryKeySelective(pay);

			OpenStoreOrder order = openStoreOrderMapper.selectByPrimaryKey(orderid);

			String refundApproval = "";
			if (refundStatus == 3) {
				refundApproval = "退款失败,请联系平台.";
			}
			if (refundStatus == 2) {
				//发货修改 2   '订单发送状态, 0未发货，1已发货，2已完成',
				order.setSendStatus(2);
				order.setCommentStatus(SysConstant.COMMON_STATUS_HIDE); //评论状态设置为待评论
				order.setConfirmTime(new Date()); //完成时间
				//返还优惠券
				cmStoreCouponRecordService.unlockCardCouponRecord(order.getOrderCode());
			}
			order.setRefundApproval(refundApproval);
			order.setRefundStatus(refundStatus);
			openStoreOrderMapper.updateByPrimaryKeySelective(order);
		}

	}

}
