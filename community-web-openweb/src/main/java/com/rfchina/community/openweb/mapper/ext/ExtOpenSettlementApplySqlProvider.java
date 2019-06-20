package com.rfchina.community.openweb.mapper.ext;

import java.util.Map;

public class ExtOpenSettlementApplySqlProvider {

	
	public String pageByCondition(Map<String, Object> param){
		StringBuffer sb = new StringBuffer("select t.*,d.title as service_name from open_settlement_apply t join community_service d on t.service_id=d.id where 1=1 and t.status != 0 ");
		
		if(param.get("startCreateTime") != null){
			sb.append(" and t.create_time >= #{startCreateTime}");
		}
		
		if(param.get("endCreateTime") != null){
			sb.append(" and t.create_time <= #{endCreateTime}");
		}
		
		if(param.get("merchantId") != null){
			sb.append(" and t.merchant_id = #{merchantId}");
		}
		
		if(param.get("status") != null){
			sb.append(" and t.status = #{status}");
		}
		
		if(param.get("invoiceStatus") != null){
			sb.append(" and t.invoice_status = #{invoiceStatus}");
		}
		
		if(param.get("settlementId") != null){
			sb.append(" and t.settlement_id = #{settlementId}");
		}
		
		if(param.get("type") != null){
			sb.append(" and t.type = #{type}");
		}
		sb.append(" order by id desc");
		
		return sb.toString();
	}
}
