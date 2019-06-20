package com.rfchina.community.brothers.service;

import com.alibaba.fastjson.JSON;
import com.rfchina.api.response.model.pay.FuPayGetSettlementApplyDetailResponseModel;
import com.rfchina.api.response.model.pay.base.FuPaySettlementDetailModel;
import com.rfchina.community.base.Constant;
import com.rfchina.community.brothers.mapper.ExtOpenOrderBroMapper;
import com.rfchina.community.persistence.mapper.OpenOrderMapper;
import com.rfchina.community.persistence.mapper.OpenSettlementApplyMapper;
import com.rfchina.community.persistence.model.OpenOrderExample;
import com.rfchina.community.persistence.model.OpenSettlementApply;
import com.rfchina.community.service.IPaySettlement;
import com.rfchina.community.service.IPaySettlementDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

//第三方服务商提现
@Service
public class OpenSettlementApplyService implements IPaySettlement, IPaySettlementDetail {

	private static Logger logger = LoggerFactory.getLogger(OpenSettlementApplyService.class);

	@Autowired
	private OpenSettlementApplyMapper openSettlementApplyMapper;
	@Autowired
	private OpenOrderMapper openOrderMapper;
	@Autowired
	private ExtOpenOrderBroMapper extOpenOrderBroMapper;

	public String sett_type = "open_order";

	@Override
	public boolean settlemetDetail(String type, String applyId, FuPaySettlementDetailModel model) {
		logger.info("test" + type + applyId + model.toString());
		if (!sett_type.equals(type))
			return false;
		OpenSettlementApply data = openSettlementApplyMapper.selectByPrimaryKey(Integer.valueOf(applyId));
		if (data == null)
			return false;
		// community_trade_no outTradeNo
		OpenOrderExample example = new OpenOrderExample();
		example.createCriteria().andCommunityTradeNoEqualTo(model.getOutTradeNo())
				.andAccountIdEqualTo(model.getAccountId());
		long count = openOrderMapper.countByExample(example);

		//
		// {"accountId":"98113954","appId":347285,"balanceStatus":2,"billCreateTime":1494314211000,"billId":"001201705095472851516510000287",
		// "body":"测试商品第三方body","bussinessBalanceStatus":2,"cmpFeeAmount":0,"cmpOutTradeNo":"open_170368613797047605817298706",
		// "cmpReceiptAmount":10,"cmpTotalAmount":10,"createTime":1499235273000,"feeAmount":0,"id":11,"mchId":"10314642","outTradeNo":"open_170368613797047605817298706",
		// "payChannel":"AliPay","payChannelId":7,"refundStatus":0,"sid":"RFJ201707051414320000645","status":7,"subject":"测试商品第三方subject"
		// ,"totalAmount":10,"tradeType":"APP"}

		logger.info("settlemetDetail85416,count:{},applyId:{},json:{}", count, applyId, JSON.toJSONString(model));
		return count == 1;
	}

	@Override
	public boolean settlemetApply(String type, String applyId, FuPayGetSettlementApplyDetailResponseModel model) {
		if (!sett_type.equals(type))
			return false;
		OpenSettlementApply data = openSettlementApplyMapper.selectByPrimaryKey(Integer.valueOf(applyId));
		if (data == null)
			return false;
		OpenSettlementApply apply = new OpenSettlementApply();
		// '结算确认状态, 1:未确认, 2:已撤消, 3:撤消中 4:已确认, 5:确认中'
		// 结算成功
		apply.setId(data.getId());
		apply.setAuditComment(model.getRevokeComment());
		apply.setBankAccount(model.getBankAccount());
		apply.setBankName(model.getDepositBank());
		apply.setCompanyName(model.getDepositName());
		if (model.getConfirmStatus() == 4) {
			// apply.setAuditComment(responseModel.getConfirmComment());
			apply.setStatus(Constant.OpenAdmin.SettlementApplyStatus.PAY_CENTER_PASS);
			apply.setSettleSuccessTime(new Date());
			// 更新提现的订单状态
			openSettlementApplyMapper.updateByPrimaryKeySelective(apply);
			int withdraw_status = 4;
			extOpenOrderBroMapper.updateWithdrawStatus(data.getSettlementStartTime(), data.getSettlementEndTime(),
					withdraw_status, data.getServiceId(), model.getId());

		}else if (model.getConfirmStatus() == 2) {

			// 结算不通过
			// '结算确认状态, 1:未确认, 2:已撤消, 3:撤消中 4:已确认, 5:确认中'
			apply.setStatus(Constant.OpenAdmin.SettlementApplyStatus.PAY_CENTER_NOTPASS);

			openSettlementApplyMapper.updateByPrimaryKeySelective(apply);
		}else {
			openSettlementApplyMapper.updateByPrimaryKeySelective(apply);
		}

		return true;
	}

}
