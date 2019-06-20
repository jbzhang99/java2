package com.rfchina.community.openweb.mapper.ext;

import java.util.Map;

import com.rfchina.community.persistence.mapper.OpenStoreVerifyCardSqlProvider;

/**
 */
public class ExtOpenStoreVerifyCardSqlProvider extends OpenStoreVerifyCardSqlProvider {
	public String pageByCondition(Map<String, Object> param){
		StringBuffer sb = new StringBuffer("select _card.*,_order.out_trade_no from open_store_verify_card _card left JOIN open_store_order _order on _card.order_id=_order.id"
				+" where 1=1 ");
		if(param.get("serviceId") != null){
			sb.append(" and _card.service_id = #{serviceId}");
		}
		if(param.get("startCreateDate") != null){
			sb.append(" and _card.create_time >= #{startCreateDate}");
		}
		
		if(param.get("endCreateDate") != null){
			sb.append(" and _card.create_time <= #{endCreateDate}");
		}
		
		if(param.get("startVerifyDate") != null){
			sb.append(" and _card.verify_time >= #{startVerifyDate}");
		}
		
		if(param.get("endVerifyDate") != null){
			sb.append(" and _card.verify_time <= #{endVerifyDate}");
		}
		
		if(param.get("goodCode") != null){
			sb.append(" and _card.good_code = #{goodCode}");
		}
		if(param.get("code") != null){
			sb.append(" and _card.code like #{code}");
		}
		if(param.get("outTradeNo") != null){
			sb.append(" and _order.out_trade_no = #{outTradeNo}");
		}
		
		sb.append(" order by _card.id desc ");
		System.out.println(sb);
		return sb.toString();
	}
	
}
