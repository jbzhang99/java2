package com.rfchina.community.openapi.mapper.ext;

import java.util.Map;

import com.rfchina.community.persistence.mapper.OpenOrderSqlProvider;

public class ExtOpenOrderSqlProvider extends OpenOrderSqlProvider{

	
	public String pageByCondition(Map<String, Object> param){
		
		StringBuffer sb = new StringBuffer("select t.*,d.title as service_name,a.`name` as community_name,b.title as merchant_name,c.phone from open_order t join community_service d on t.app_id=d.app_id join community a on t.community_id=a.id join open_merchant_info b on b.id=d.merchant_id join user_info c on t.uid=c.id where 1=1 ");
		
		if(param.get("startCreateTime") != null){
			sb.append(" and t.create_time >= #{startCreateTime}");
		}
		
		if(param.get("endCreateTime") != null){
			sb.append(" and t.create_time <= #{endCreateTime}");
		}
		
		if(param.get("merchantId") != null){
			sb.append(" and d.merchant_id = #{merchantId}");
		}
		
		if(param.get("serviceId") != null){
			sb.append(" and d.id = #{serviceId}");
		}
		
		if(param.get("billStatus") != null){
			sb.append(" and t.bill_status = #{billStatus}");
		}
		
		if(param.get("refundStatus") != null){
			sb.append(" and t.refund_status = #{refundStatus}");
		}
		
		if(param.get("withdrawStatus") != null){
			sb.append(" and t.withdraw_status = #{withdrawStatus}");
		}
		
		if(param.get("platformBillId") != null){
			sb.append(" and t.community_trade_no = #{platformBillId}");
		}
		
		if(param.get("serviceBillId") != null){
			sb.append(" and t.out_trade_no = #{serviceBillId}");
		}
		
		return sb.toString();
	}
	
	
	
	public String getOpenOrderCount(Map<String, Object> param){
		StringBuffer sb = new StringBuffer("select count(1) as order_count,sum(t.total_amount) as order_amount_count,sum(t.platform_charge) as platform_poundage_amount, sum(t.service_charge) as platform_commission_amount , sum(t.total_amount-t.platform_charge-service_charge) as settlement_amount_count from open_order t join community_service d on t.app_id=d.app_id where 1=1 and t.type=1 and t.bill_status=2 ");
		
		if(param.get("startCreateTime") != null){
			sb.append(" and t.create_time >= #{startCreateTime}");
		}
		
		if(param.get("endCreateTime") != null){
			sb.append(" and t.create_time <= #{endCreateTime}");
		}
		
		if(param.get("serviceId") != null){
			sb.append(" and d.id = #{serviceId}");
		}
		
		return sb.toString();
	}
	
	public String getPlatformChargeCount(Map<String, Object> param){
		StringBuffer sb = new StringBuffer("select d.id as service_id,d.merchant_id, count(1) as order_count,sum(t.total_amount) as order_amount_count,sum(t.platform_charge) as platform_poundage_amount, sum(t.service_charge) as platform_commission_amount , sum(t.total_amount-t.platform_charge-service_charge) as settlement_amount_count from open_order t join community_service d on t.app_id=d.app_id where 1=1 and t.type=3 ");
		if(param.get("startCreateTime") != null){
			sb.append(" and t.create_time >= #{startCreateTime}");
		}
		
		if(param.get("endCreateTime") != null){
			sb.append(" and t.create_time <= #{endCreateTime}");
		}
		
		sb.append(" group by d.id ");
		return sb.toString();
	}
	
	public String getServiceChargeCount(Map<String, Object> param){
		StringBuffer sb = new StringBuffer("select d.id as service_id , t.community_id,d.merchant_id, count(1) as order_count,sum(t.total_amount) as order_amount_count,sum(t.platform_charge) as platform_poundage_amount, sum(t.service_charge) as platform_commission_amount , sum(t.total_amount-t.platform_charge-service_charge) as settlement_amount_count from open_order t join community_service d on t.app_id=d.app_id where 1=1 and t.type =4 ");
		if(param.get("startCreateTime") != null){
			sb.append(" and t.create_time >= #{startCreateTime}");
		}
		
		if(param.get("endCreateTime") != null){
			sb.append(" and t.create_time <= #{endCreateTime}");
		}
		
		sb.append(" group by d.id,t.community_id ");
		return sb.toString();
	}
	
	
	public String getOpenOrderGroupByCommunity(Map<String, Object> param){
		StringBuffer sb = new StringBuffer("select * from open_order t where 1=1 ");
		
		if(param.get("startCreateTime") != null){
			sb.append(" and t.create_time >= #{startCreateTime}");
		}
		
		if(param.get("endCreateTime") != null){
			sb.append(" and t.create_time <= #{endCreateTime}");
		}
		
		if(param.get("type") != null){
			sb.append(" and t.type = #{type}");
		}
		
		if(param.get("serviceChargeStatus") != null){
			sb.append(" and t.service_charge_status = #{serviceChargeStatus}");
		}
		
		if(param.get("billStatus") != null){
			sb.append(" and t.bill_status = #{billStatus}");
		}
		
		sb.append(" group by t.community_id,t.service_id ");
		
		return sb.toString();
	}
}
