package com.rfchina.community.openstore.service;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenRefundConstant;
import com.rfchina.community.base.OrderPayConstant;
import com.rfchina.community.component.JavaMailComponent;
import com.rfchina.community.component.JavaMailComponent.EmailType;
import com.rfchina.community.openstore.task.NoticeExecutor;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.service.SmsGlobalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OpenRefundService extends BaseService{

    @Autowired
    private SmsGlobalService smsGlobalService;
    @Autowired
    private OpenStoreOrderRefundApplyMapper openStoreOrderRefundApplyMapper;
    @Autowired
	private OpenStoreOrderMapper openStoreOrderMapper;
	@Autowired
	private OpenOrderMapper openOrderMapper;
	@Autowired
	private JavaMailComponent javaMailComponent;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;
	
	@Transactional
	public void refundApply(int storeOrderId, String reasonCertificate, String refundRemark, String refundComment) {
		OpenStoreOrder storeOrder = openStoreOrderMapper.selectByPrimaryKey(storeOrderId);
		validator(storeOrder == null, "订单不存在");
		validator(storeOrder.getRefundStatus() == OpenConstant.OpenStoreRefundStatus.ing.getCode()
				|| storeOrder.getRefundStatus() == OpenConstant.OpenStoreRefundStatus.Success.getCode()
				|| storeOrder.getRefundStatus() == OpenConstant.OpenStoreRefundStatus.user_apply.getCode()
				, "退款申请已提交了");
		
		//非原路退回方式
		validator(OpenConstant.PayChannel.UnionPay.equals(storeOrder.getPayChannel()), "此订单不支持原路退款,请联系商家退款");
		
		OpenOrderExample example = new OpenOrderExample();
		example.createCriteria().andOutTradeNoEqualTo(storeOrder.getOutTradeNo());
		List<OpenOrder> list = openOrderMapper.selectByExample(example);
		validator(list.isEmpty(), "订单不存在");
		OpenOrder order = list.get(0);
		
		//判断是否已经拆单了
		validator(order.getBillSplitStatus() == OpenConstant.open_order.BillSplitStatus.split, "订单已经拆单不能退款");
		
		long openRefundId = this.insert(order.getBillId(), storeOrder.getId(), reasonCertificate);
		
		storeOrder.setSameWay(OpenRefundConstant.SameWayStatus.original);
		storeOrder.setRefundComment(refundComment);
		storeOrder.setRefundApproval("");
		storeOrder.setRefundRemark(refundRemark);
		storeOrder.setRefundStatus(OpenConstant.OpenStoreRefundStatus.user_apply.getCode());
		storeOrder.setRefundTime(new Date());
		storeOrder.setOpenRefundId(openRefundId);
		openStoreOrderMapper.updateByPrimaryKeySelective(storeOrder);
		
		//open_order 更新状态-商家审核中
		order.setRefundStatus(OrderPayConstant.RefundStatus.MERCHANT_AUDITING.getCode());
		openOrderMapper.updateByPrimaryKeySelective(order);
		
//		服务商名称】，
//		您好，您的服务【服务名称】收到了一条订单退款申请，订单号为XXXXXXXXXXX，请尽快审批，以防影响后续资金结算流程。
		CommunityService service = communityServiceMapper.selectByPrimaryKey(storeOrder.getServiceId());
		OpenMerchantInfo merchant = openMerchantInfoMapper.selectByPrimaryKey(service.getMerchantId());
		//发送短信、邮件给商家
		NoticeExecutor.getExecutor().execute(() -> {
			addMessage(merchant.getTitle(), service.getTitle(), storeOrder.getOutTradeNo(), merchant.getEmail());
			addSms(merchant.getContactPhone(),service.getTitle(), storeOrder.getOutTradeNo());
		});
    }
	
	private void addMessage(String merchantTitle, String serviceName, String outTradeNo, String email) {
		logger.info("refundApply : addMessage : email={},merchantTitle={}, serviceName={}, outTradeNo={}", email,merchantTitle, serviceName, outTradeNo);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("merchantTitle", merchantTitle);
		model.put("serviceName", serviceName);
		model.put("outTradeNo", outTradeNo);
		javaMailComponent.sendEmail(EmailType.user_refund_notice, email, model);
		
	}
	
	private void addSms(String phone, String serviceName, String outTradeNo) {
		logger.info("refundApply : addSms : phone={}, serviceName={}, outTradeNo={}", phone, serviceName, outTradeNo);
		// sms您好，您的服务【服务名称】收到了一条订单退款申请，订单号为XXXXXXXXXXX，请尽快审批，以防影响后续资金结算流程。
		smsGlobalService.sendSms(phone, SmsGlobalService.SmsType.user_refund_notice, serviceName, outTradeNo);
		
	}

    private long insert(String billId, int storeOrderId, String reasonCertificate) {
    	OpenStoreOrderRefundApply apply = new OpenStoreOrderRefundApply();
    	apply.setBillId(billId);
    	apply.setReasonCertificate(reasonCertificate);
    	apply.setRefundSource(OpenRefundConstant.Source.user);
    	apply.setStoreOrderId(storeOrderId);
    	apply.setCreateTime(new Date());
    	openStoreOrderRefundApplyMapper.insertSelective(apply);
    	return apply.getId();
    }

    
  
    
}
