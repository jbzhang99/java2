package com.rfchina.community.brothers.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.rfchina.api.response.model.pay.FuPayGetSettlementApplyDetailResponseModel;
import com.rfchina.api.response.model.pay.base.FuPaySettlementDetailModel;
import com.rfchina.community.persistence.mapper.OpenOrderMapper;
import com.rfchina.community.persistence.mapper.OpenSettCommunityMapper;
import com.rfchina.community.persistence.model.OpenOrder;
import com.rfchina.community.persistence.model.OpenOrderExample;
import com.rfchina.community.persistence.model.OpenSettCommunity;
import com.rfchina.community.service.IPaySettlement;
import com.rfchina.community.service.IPaySettlementDetail;

//第三方的社区佣金提现
@Service
public class OpenSettlCommunityService implements IPaySettlement, IPaySettlementDetail {

	private static Logger logger = LoggerFactory.getLogger(OpenSettlCommunityService.class);

	@Autowired
	private OpenOrderMapper openOrderMapper;
	@Autowired
	private OpenSettCommunityMapper openSettCommunityMapper;
	@Autowired
	private PaySettlementDetailService paySettlementDetailService;

	public String sett_type = "open_community";

	@Override
	public boolean settlemetDetail(String type, String applyId, FuPaySettlementDetailModel model) {
		if (!sett_type.equals(type))
			return false;
		OpenSettCommunity data = openSettCommunityMapper.selectByPrimaryKey(Integer.valueOf(applyId));
		if (data == null)
			return false;
		// community_trade_no outTradeNo
		OpenOrderExample example = new OpenOrderExample();
		example.createCriteria().andCommunityTradeNoEqualTo(model.getOutTradeNo())
				.andServiceChargeBillIdEqualTo(model.getBillId());
		OpenOrder record = new OpenOrder();
		record.setTixianCommunity(model.getSid());
		// 结算
		record.setServiceChargeStatus(3);
		long count = openOrderMapper.updateByExampleSelective(record, example);

		//
		// {"accountId":"98113954","appId":347285,"balanceStatus":2,"billCreateTime":1494314211000,"billId":"001201705095472851516510000287",
		// "body":"测试商品第三方body","bussinessBalanceStatus":2,"cmpFeeAmount":0,"cmpOutTradeNo":"open_170368613797047605817298706",
		// "cmpReceiptAmount":10,"cmpTotalAmount":10,"createTime":1499235273000,"feeAmount":0,"id":11,"mchId":"10314642","outTradeNo":"open_170368613797047605817298706",
		// "payChannel":"AliPay","payChannelId":7,"refundStatus":0,"sid":"RFJ201707051414320000645","status":7,"subject":"测试商品第三方subject"
		// ,"totalAmount":10,"tradeType":"APP"}

		logger.info("settlemetDetail987541,count:{},applyId:{} ", count, applyId);
		return count == 1;
	}

	@Override
	public boolean settlemetApply(String type, String applyId, FuPayGetSettlementApplyDetailResponseModel model) {
		if (!sett_type.equals(type))
			return false;

		OpenSettCommunity data = openSettCommunityMapper.selectByPrimaryKey(Integer.valueOf(applyId));
		if (data == null)
			return false;
		OpenSettCommunity apply = new OpenSettCommunity();
		// '结算确认状态, 1:未确认, 2:已撤消, 3:撤消中 4:已确认, 5:确认中'
		// 结算成功
		apply.setId(data.getId());
		apply.setAuditComment(model.getRevokeComment());
		apply.setPfStatus(model.getConfirmStatus());
		if (model.getConfirmStatus() == 4) {
			// apply.setAuditComment(responseModel.getConfirmComment());
			apply.setStatus(10);
			// 更新提现的订单状态
			openSettCommunityMapper.updateByPrimaryKeySelective(apply);

			//

			String sid = model.getId();
			String myId = applyId;
			int myStatus = 4;
			paySettlementDetailService.updatePaySettlementDetail(type, sid, myId, myStatus);

		}
		// '结算确认状态, 1:未确认, 2:已撤消, 3:撤消中 4:已确认, 5:确认中'
		// 结算不通过
		if (model.getConfirmStatus() == 2) {
			apply.setStatus(11);
			openSettCommunityMapper.updateByPrimaryKeySelective(apply);
		}

		return true;
	}

}
