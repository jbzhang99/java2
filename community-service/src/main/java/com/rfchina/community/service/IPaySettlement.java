package com.rfchina.community.service;

import com.rfchina.api.response.model.pay.FuPayGetSettlementApplyDetailResponseModel;
import com.rfchina.api.response.model.pay.base.FuPaySettlementDetailModel;

/**
 * 结算
 * @author liyicun
 *
 */
public interface IPaySettlement {

//	public boolean settlemetDetail(String applyId,FuPaySettlementDetailModel model);

	public boolean settlemetApply(String type,String applyId, FuPayGetSettlementApplyDetailResponseModel model);

}
