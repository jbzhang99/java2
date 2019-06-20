package com.rfchina.community.open.bridge.service;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.api.response.model.pay.PayRefundAuditLogModel;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenConstant.OpenStoreRefundStatus;
import com.rfchina.community.base.OpenRefundConstant;
import com.rfchina.community.base.OrderPayConstant;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.OpenStoreOrderMapper;
import com.rfchina.community.persistence.mapper.OpenStoreOrderRefundApplyMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.OpenOrder;
import com.rfchina.community.persistence.model.OpenStoreOrder;
import com.rfchina.community.persistence.model.OpenStoreOrderRefundApply;
import com.rfchina.community.persistence.model.ext.OpenStoreOrderRefundApplyVO;
import com.rfchina.community.service.openser.OpenOrderSerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author:fukangwen
 * @Description: 服务关键词设置
 */
@Service
public class OpenRefundService extends BaseService{

	@Autowired
	private OpenOrderSerService openOrderSerService;
	@Autowired
	private OpenStoreOrderMapper openStoreOrderMapper;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private OpenStoreOrderRefundApplyMapper openStoreOrderRefundApplyMapper;
	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;
	
	@Value("${app.environment}")
	private String environment;
	/**
	 * 
	 * @param storeOrderId
	 * @param sameWay
	 * @param refundComment
	 * @param reasonCertificate
	 * @param confirmLetter
	 * @param idCardFront
	 * @param idCardFear
	 * @param name
	 * @param depositBank
	 * @param accountNo
	 * @param accountPic
	 */
	public void refund(int storeOrderId, int sameWay, String refundComment, String reasonCertificate,
			String confirmLetter, String idCardFront, String idCardFear, String name, String depositBank,
			String accountNo, String accountPic) {
		OpenStoreOrder openStoreOrder = openStoreOrderMapper.selectByPrimaryKey(storeOrderId);
		validator(openStoreOrder == null, "订单不存在");   
		validator(openStoreOrder.getPayStatus() != OpenConstant.OpenStorePayStatus.PAY.getCode(), "订单未支付,不能退款");
		validator(openStoreOrder.getRefundStatus() == OpenStoreRefundStatus.ing.getCode(), "退款中不用重复发起");
		validator(openStoreOrder.getRefundStatus() == OpenStoreRefundStatus.Success.getCode(),
				"退款成功,不能发起");
		CommunityService ser = communityServiceMapper.selectByPrimaryKey(openStoreOrder.getServiceId());
		
		Long appId = ser.getAppId();
		int day = OpenConstant.refund_store_day;// 14;

		if ("test".equals(environment)) {
			// 测试环境1天后不能退款
			day = OpenConstant.TEST_BATCH_RUN;// 1;
		}
		logger.info("pay_refund:appId:{} outTradeNo:{},refund_reason:{},environment:{},day:{}", appId, openStoreOrder.getOutTradeNo(),
				refundComment, environment, day);
		int flag = openOrderSerService.payRefund(appId, openStoreOrder.getOutTradeNo(), day, refundComment, sameWay);

		if (flag > 0) {
			OpenOrder order = openOrderSerService.getOpenOrder(openStoreOrder.getOutTradeNo());
			long openRefundId = this.insert(order.getBillId(), storeOrderId, reasonCertificate,
					confirmLetter, idCardFront, idCardFear, name, depositBank,accountNo, accountPic);
			
			//openStoreOrder.setRefundStatus(OpenStoreRefundStatus.ing.getCode());
            openStoreOrder.setRefundStatus(OrderPayConstant.RefundStatus.PC_UPPING.getCode());
			openStoreOrder.setRefundTime(new Date());
			openStoreOrder.setRefundComment(refundComment);
			openStoreOrder.setRefundApproval("");
			openStoreOrder.setRefundRemark("");
			openStoreOrder.setSameWay(sameWay);
			openStoreOrder.setOpenRefundId(openRefundId);
			openStoreOrderMapper.updateByPrimaryKeySelective(openStoreOrder);
		}
	}

	/**
	 * @Author wlrllr
	 * @Description //TODO
	 * @Date 2019/1/4
	 * @Param [storeOrderId]
	 * @return com.alibaba.fastjson.JSONObject
	 **/
	public JSONObject getRefundDetailAndAuditList(int storeOrderId) {
		OpenStoreOrderRefundApplyVO vo = openOrderSerService.getRefundDetail(storeOrderId);
		JSONObject result = new JSONObject();
		result.put("detail",vo);
		String refundId = vo.getRefundBillId();
		if(StringUtils.isNotBlank(refundId)){
			List<PayRefundAuditLogModel> list = platformGlobalComponent.getRefundAuditList(refundId);
			if(list != null && list.size()>0){
				//查询结果是按时间升序排列，所以只需要倒序即可
				Collections.reverse(list);
			}
			result.put("auditList",list);
		}
		return result;
	}


	 private long insert(String billId, int storeOrderId, String reasonCertificate,
			 String confirmLetter, String idCardFront, String idCardFear, String name, String depositBank,
				String accountNo, String accountPic) {
	    	OpenStoreOrderRefundApply apply = new OpenStoreOrderRefundApply();
	    	apply.setBillId(billId);
	    	apply.setReasonCertificate(reasonCertificate);
	    	apply.setRefundSource(OpenRefundConstant.Source.platform);
	    	apply.setStoreOrderId(storeOrderId);
	    	apply.setConfirmLetter(confirmLetter);
	    	apply.setIdCardFront(idCardFront);
	    	apply.setIdCardRear(idCardFear);
	    	apply.setName(name);
	    	apply.setDepositBank(depositBank);
	    	apply.setAccountNo(accountNo);
	    	apply.setAccountPic(accountPic);
	    	apply.setCreateTime(new Date());
	    	openStoreOrderRefundApplyMapper.insertSelective(apply);
	    	return apply.getId();
	    }

}
