package com.rfchina.community.open.bridge.mapper.ext;

import com.rfchina.community.base.OrderPayConstant;
import com.rfchina.community.persistence.mapper.OpenOrderSqlProvider;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ExtOpenOrderSqlProvider extends OpenOrderSqlProvider{

	public String pageByCondition(Map<String, Object> param){
		
		StringBuffer sb = new StringBuffer("SELECT t.*, c.name community_name, u.phone FROM open_order_total t LEFT JOIN community c ON t.community_id = c.id LEFT JOIN user_info u on u.id=t.uid where 1=1");
		
		if(param.get("startCreateTime") != null){
			sb.append(" and t.create_time >= #{startCreateTime}");
		}
		if(param.get("endCreateTime") != null){
			sb.append(" and t.create_time <= #{endCreateTime}");
		}
		
		if(param.get("billStatus") != null){
			sb.append(" and t.bill_status = #{billStatus}");
		}
		
		if(param.get("communityId") != null){
			sb.append(" and t.community_id = #{communityId}");
		}
	
		if(param.get("communityTradeNo") != null){
			sb.append(" and t.community_trade_no = #{communityTradeNo}");
		}
		if(param.get("billId") != null){
			sb.append(" and t.bill_id = #{billId}");
		}
		Object refundStatus = param.get("refundStatus");
		if(refundStatus != null){
			if(OrderPayConstant.RefundFlag.YES.getCode() == Integer.valueOf((String)refundStatus)){
				sb.append(" and t.refund_count >= 1");
			}else if(OrderPayConstant.RefundFlag.NO.getCode() == Integer.valueOf((String)refundStatus)){
				sb.append(" and t.refund_count = 0");
			}
		}
		return sb.toString();
	}
	
	 public String pageByAdminCondition(Map<String, Object> param) {

	        StringBuffer sb = new StringBuffer("select t.*,d.title as service_name,a.`name` as community_name,b.title as merchant_name,c.phone from open_order t join community_service d on t.app_id=d.app_id join community a on t.community_id=a.id join open_merchant_info b on b.id=d.merchant_id join user_info c on t.uid=c.id where 1=1 ");

	        if (param.get("startCreateTime") != null) {
	            sb.append(" and t.create_time >= #{startCreateTime}");
	        }
	        if (param.get("endCreateTime") != null) {
	            sb.append(" and t.create_time <= #{endCreateTime}");
	        }

	        if (param.get("merchantId") != null) {
	            sb.append(" and b.id = #{merchantId}");
	        }

	        if (param.get("serviceId") != null) {
	            sb.append(" and d.id = #{serviceId}");
	        }

	        if (param.get("billStatus") != null) {
	            sb.append(" and t.bill_status = #{billStatus}");
	        }

	        if (param.get("communityId") != null) {
	            sb.append(" and a.id = #{communityId}");
	        }

	        if (param.get("serviceName") != null) {
	            sb.append(" and d.title like #{serviceName}");
	        }

	        if (param.get("merchantName") != null) {
	            sb.append(" and b.title like #{merchantName}");
	        }

	        if (param.get("communityName") != null) {
	            sb.append(" and a.`name` like #{communityName}");
	        }
	        if (param.get("outTradeNo") != null) {
	            sb.append(" and t.`out_trade_no` = #{outTradeNo}");
	        }
	        return sb.toString();
	    }


	public String sumAmount(Map<String, Object> param) {

		StringBuffer sb = new StringBuffer("select IFNULL(sum(total_amount),0) total_amount from open_order where bill_status= 2 ");

		if (param.get("taskId") != null) {
			sb.append(" and task_id = #{taskId}");
		}
		if (param.get("taskRelId") != null) {
			sb.append(" and task_rel_id = #{taskRelId}");
		}

		if (param.get("empGuid") != null) {
			sb.append(" and emp_guid = #{empGuid}");
		}

		if (param.get("isContainRefund") != null && !MapUtils.getBoolean(param, "isContainRefund")) {
			sb.append(" and refund_status = 0");
		}

		return sb.toString();
	}


	public String taskOrderStat(Map<String, Object> param) {

		StringBuffer sb = new StringBuffer(" SELECT" +
				"  IFNULL(sum(total_amount), 0) total_amount," +
				"  IFNULL(sum(case when refund_status > 0 then total_amount else 0 end), 0) refund_amount," +
				"  IFNULL(sum(case when refund_status =0 then total_amount else 0 end), 0) no_refund_amount," +
				"  IFNULL(count(*), 0) order_amount" +
				"  FROM " +
				"  open_order" +
				"  WHERE" +
				"  bill_status = 2");

		if (param.get("taskId") != null) {
			sb.append(" and task_id = #{taskId}");
		}
		if (param.get("taskRelId") != null) {
			sb.append(" and task_rel_id = #{taskRelId}");
		}
		if (param.get("empGuid") != null) {
			sb.append(" and emp_guid = #{empGuid}");
		}

		return sb.toString();
	}


	public String taskOrderList(Map<String, Object> param) {

		StringBuffer sb = new StringBuffer("SELECT id, total_amount, out_trade_no, refund_status,bill_finished_time FROM open_order WHERE bill_status = 2 ");

		if (param.get("taskId") != null) {
			sb.append(" and task_id = #{taskId}");
		}

		if (param.get("taskRelId") != null) {
			sb.append(" and task_rel_id = #{taskRelId}");
		}

		if (param.get("empGuid") != null) {
			sb.append(" and emp_guid = #{empGuid}");
		}

		return sb.toString();
	}

	public String listOperatorOrder(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer("select _order.id, _order.emp_guid, _order.emp_phone, _order.emp_name, _order.out_trade_no,_order.total_amount,_order.refund_status,");
		sb.append("	_order.bill_finished_time, _order.task_id,_service.title serviceName ");
		sb.append("	from open_order _order LEFT JOIN community_service _service on _service.id=_order.service_id");
		sb.append(" where _order.bill_status=2 and _order.task_id > 0 ");
		if (param.get("empGuidName") != null) {
			sb.append(" and  _order.emp_name like #{empGuidName}");
		}
		if (param.get("empGuidPhone") != null) {
			sb.append(" and _order.emp_phone like #{empGuidPhone}");
		}
		if (param.get("outTradeNo") != null) {
			sb.append(" and _order.out_trade_no like #{outTradeNo}");
		}
		if (param.get("endDate") != null) {
			sb.append(" and _order.bill_finished_time< #{endDate}");
		}
		if (param.get("beginDate") != null) {
			sb.append(" and _order.bill_finished_time > #{beginDate}");
		}
		if (param.get("taskId") != null) {
			sb.append(" and _order.task_id= #{taskId}");
		}
		if (param.get("refundStatus") != null) {
			sb.append(" and _order.refund_status= #{refundStatus}");
		}
		if (param.get("serviceName") != null) {
			sb.append(" and _service.title like #{serviceName}");
		}
		sb.append(" order by _order.bill_finished_time desc");
		return sb.toString();
	}

	public String pageCondition(Map<String, Object> param){

		StringBuffer sb = new StringBuffer("select t.*,d.title as service_name,a.`name` as community_name,b.title as merchant_name," +
				"c.phone,a.city_name from open_order t join community_service d on t.app_id=d.app_id join community a on t.community_id=a.id " +
				"join open_merchant_info b on b.id=d.merchant_id join user_info c on t.uid=c.id " +
				"where 1=1 ");

		if(param.get("startCreateTime") != null){
			sb.append(" and t.create_time >= #{startCreateTime}");
		}

		if(param.get("endCreateTime") != null){
			sb.append(" and t.create_time <= #{endCreateTime}");
		}

		if(param.get("startBillFinishedDate") != null){
			sb.append(" and t.bill_finished_time >= #{startBillFinishedDate}");
		}

		if(param.get("endBillFinishedDate") != null){
			sb.append(" and t.bill_finished_time <= #{endBillFinishedDate}");
		}



		if(param.get("startBillSplitDate") != null){
			sb.append(" and t.bill_split_time >= #{startBillSplitDate}");
		}

		if(param.get("endBillSplitDate") != null){
			sb.append(" and t.bill_split_time <= #{endBillSplitDate}");
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
			sb.append(" and t.community_trade_no like #{platformBillId}");
		}

		if(param.get("serviceBillId") != null){
			sb.append(" and t.out_trade_no = #{serviceBillId}");
		}
		sb.append(" order by t.id desc");
		return sb.toString();
	}

}
