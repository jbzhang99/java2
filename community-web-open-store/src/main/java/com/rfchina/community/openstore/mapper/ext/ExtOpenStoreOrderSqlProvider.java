package com.rfchina.community.openstore.mapper.ext;

import com.rfchina.community.persistence.mapper.OpenStoreOrderPaySqlProvider;

import java.util.Map;

/**
 */
public class ExtOpenStoreOrderSqlProvider extends OpenStoreOrderPaySqlProvider {
	public String selectWithOutOpenId(Map<String, Object> param){
		StringBuilder sb = new StringBuilder(
				"select * from open_store_order where 1=1 ");
		if(param.get("serviceId") != null){
			sb.append(param.get("and service_id = #{serviceId}"));
		}
		sb.append(" and user_id=");
		sb.append(param.get("userId"));

		//支付状态 0 待支付,1已经支付,2关闭
		if(param.get("pay_status") != null){
			sb.append(" and pay_status = #{pay_status} ");
		}
//		退款状态
		if(param.get("refund_status") != null){
			sb.append(" and refund_status = #{refund_status} ");
		}
		////发货状态， 0未发货，1已发货，2确认收货
		if(param.get("send_status") != null){
			sb.append(" and send_status = #{send_status} ");
		}
		if(param.get("comment_status") != null){
			sb.append(" and comment_status = #{comment_status} ");
		}
		sb.append(" order by id desc");
		return sb.toString();
	}


	public String countByUserIdAndGoodId(Map<String, Object> param){
		StringBuilder sb = new StringBuilder("select IFNULL(sum(_rel.amount),0) amount from open_store_good_order_rel _rel LEFT JOIN open_store_order _order on _rel.order_id=_order.id ");
		Object groupInfoId = param.get("groupInfoId");
		if(groupInfoId != null){
			sb.append(" LEFT JOIN open_store_group_data _data on _data.id=_order.group_data_id LEFT JOIN open_store_good_group_info _info on _info.id=_data.good_group_id");
		}
		sb.append(" where _order.pay_status in (0,1)  and _order.user_id=#{uid} and _rel.good_id=#{goodId}");

		if(groupInfoId != null){
			sb.append(" and _info.id=#{groupInfoId}");
		}
		return sb.toString();
	}

}
