package com.rfchina.community.open.bridge.mapper.ext;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtOpenSettlementApplySqlProvider {

	private static transient Logger logger = LoggerFactory.getLogger(ExtOpenSettlementApplySqlProvider.class);
	
	public String pageByCondition(Map<String, Object> param){
		StringBuffer sb = new StringBuffer("select (COALESCE(platform_poundage_amount,0)+COALESCE(platform_commission_amount,0)+COALESCE(platform_think_amount,0)) as total_amount,t.*,d.title as service_name,b.title as merchant_name,p.think_rate,p.platform_fee,a.name as service_category,p.community_rate," +
				" b.type as merchant_type from open_settlement_apply t join community_service d on t.service_id=d.id " +
				" join community_service_category a on a.id=d.category_id " +
				" join open_merchant_info b on b.id=d.merchant_id " +
				" join open_service_pay p on d.id=p.service_id "+
				" where t.status != 0 ");
		
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
		
		if(param.get("serviceId") != null){
			sb.append(" and d.id = #{serviceId}");
		}
		
		if(param.get("type") != null){
			sb.append(" and t.type = #{type}");
		}
		
		if(param.get("settlementId") != null){
			sb.append(" and t.settlement_id = #{settlementId}");
		}
		
		if(param.get("serviceName") != null){
			sb.append(" and d.title like #{serviceName}");
		}
		
		if(param.get("merchantName") != null){
			sb.append(" and b.title like #{merchantName}");
		}
		
		if(param.get("invoiceStatus") != null){
			sb.append(" and t.invoice_status = #{invoiceStatus}");
		}
		
		logger.info("SQL："+sb.toString());
		
		return sb.toString();
	}
}
