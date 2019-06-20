package com.rfchina.community.openweb.mapper.ext;

import com.rfchina.community.persistence.mapper.OpenStoreGoodSqlProvider;

import java.util.Map;

/**
 */
public class ExtOpenStoreOrderSqlProvider extends OpenStoreGoodSqlProvider {
	public String pageByCondition(Map<String, Object> param){
		StringBuffer sb = new StringBuffer("select _order.*,_data.status group_success_status from open_store_order _order left join open_store_group_data _data on _data.id=_order.group_data_id where _order.pay_status=1 ");
		if(param.get("serviceId") != null){
			sb.append(" and _order.service_id = #{serviceId}");
		}
		if(param.get("sendStatus") != null){
			sb.append(" and _order.send_status = #{sendStatus}");
		}
		
		if(param.get("verifyStatus") != null){
			sb.append(" and _order.verify_status = #{verifyStatus}");
		}
		
		if(param.get("mobile") != null){
			sb.append(" and _order.mobile like #{mobile}");
		}
		if(param.get("userName") != null){
			sb.append(" and _order.user_name like #{userName}");
		}
		if(param.get("orderCode") != null){
			sb.append(" and _order.order_code like #{orderCode}");
		}
		if(param.get("outTradeNo") != null){
			sb.append(" and _order.out_trade_no like #{outTradeNo}");
		}
		Object obj = param.get("refundStatus");
		if(obj != null){
			Integer refundStatus = (Integer)obj;
			if(refundStatus.intValue() == 1){
				sb.append(" and _order.refund_status in (1,5,6,7)");//退款处理中，前台只传1对应1,5,6,7四个状态
			}else{
				sb.append(" and _order.refund_status = #{refundStatus}");
			}
		}
		if(param.get("isRefundOrder") != null && obj == null){
			sb.append(" and _order.refund_status <> 0");
		}
		if(param.get("commentStatus") != null){
			sb.append(" and _order.comment_status = #{commentStatus}");
		}

		if(param.get("startCreateDate") != null){
			sb.append(" and _order.create_time >= #{startCreateDate}");
		}
		
		if(param.get("endCreateDate") != null){
			sb.append(" and _order.create_time <= #{endCreateDate}");
		}
		if(param.get("groupStatus") != null){
			sb.append(" and _order.group_status = #{groupStatus}");
		}
		
		sb.append(" order by _order.id desc");
		
		return sb.toString();
	}
}
