package com.rfchina.community.service;

import com.rfchina.api.response.model.pay.FuPayGetSettlementApplyDetailResponseModel;
import com.rfchina.api.response.model.pay.base.FuPaySettlementDetailModel;

/**
 * 结算
 * @author liyicun
 *
 */
public interface IPaySettlementDetail {

	public boolean settlemetDetail(String type,String applyId,FuPaySettlementDetailModel model);

	

}
