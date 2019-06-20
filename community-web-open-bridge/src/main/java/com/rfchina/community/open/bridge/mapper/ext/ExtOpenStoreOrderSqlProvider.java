package com.rfchina.community.open.bridge.mapper.ext;

import com.rfchina.community.persistence.mapper.OpenStoreGoodSqlProvider;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 */
public class ExtOpenStoreOrderSqlProvider extends OpenStoreGoodSqlProvider {

	private static Logger logger = LoggerFactory.getLogger(ExtOpenStoreOrderSqlProvider.class);

	public String pageByCondition(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer(
				"select _order.*, _service.title service_title, _service.merchant_id, _info.title merchant_title ,_community.name community_title"
						+ " from open_store_order _order "
						+ " LEFT JOIN community_service _service on _order.service_id=_service.id "
						+ " LEFT JOIN open_merchant_info _info on _service.merchant_id=_info.id "
						+ " LEFT JOIN community _community on _community.id=_order.community_id ");
		// 关联商品表,
		if (MapUtils.getLong(param, "goodId", 0L) > 0) {
			sb.append(" LEFT JOIN open_store_good_order_rel _rel on _rel.order_id=_order.id ");
		}

//		open_store_good_order_rel

		sb.append(" where 1=1 ");
		// 关联商品表,
		if (MapUtils.getLong(param, "goodId", 0L) > 0) {
			sb.append(" and _rel.good_id = #{goodId}");
		}

		if (param.get("type") != null) {
			sb.append(" and _order.type = #{type}");
		}
		if (param.get("communityId") != null) {
			sb.append(" and _order.community_id = #{communityId}");
		}
		if (param.get("communityIdList") != null) {
			sb.append(" and _order.community_id in(" + param.get("communityIdList") + ") ");
		}
		if (param.get("serviceId") != null) {
			sb.append(" and _order.service_id = #{serviceId}");
		}
		if (param.get("merchantId") != null) {
			sb.append(" and _info.id = #{merchantId}");
		}
		if (param.get("sendStatus") != null) {
			sb.append(" and _order.send_status = #{sendStatus}");
		}
		if (param.get("payStatus") != null) {
			sb.append(" and _order.pay_status = #{payStatus}");
		}
		if (param.get("refundStatus") != null) {
			sb.append(" and _order.refund_status = #{refundStatus}");
		}
		if (param.get("verifyStatus") != null) {
			sb.append(" and _order.verify_status = #{verifyStatus}");
		}
		if (param.get("orderCode") != null) {
			sb.append(" and _order.order_code like #{orderCode}");
		}
		if (param.get("outTradeNo") != null) {
			sb.append(" and _order.out_trade_no like #{outTradeNo}");
		}
		if (param.get("startCreateDate") != null) {
			sb.append(" and _order.create_time >= #{startCreateDate}");
		}
		if (param.get("endCreateDate") != null) {
			sb.append(" and _order.create_time <= #{endCreateDate}");
		}
		if(param.get("commentStatus") != null){
			sb.append(" and _order.comment_status = #{commentStatus}");
		}
		if(param.get("groupStatus") != null){
			sb.append(" and _order.group_status = #{groupStatus}");
		}
		sb.append(" order by _order.id desc");
		logger.info("{}", sb);
		return sb.toString();
	}

	public String pageByExportCondition(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer(
				"select _order.addr_detail,_order.group_status, _order.user_name,_order.mobile,_order.express_area,_order.express_phone,_order.express_name,_order.remark,_user.phone user_phone,_order.order_code,_order.out_trade_no, _order.express_money,_order.original_price,_order.discount_price,"
						+ "	_order.total_amount,_order.coupon_price, _order.pay_status,_order.send_status,_order.refund_status,_order.create_time,_order.type,"
						+ " 	_service.title service_title, _service.merchant_id, _info.title merchant_title ,_community.name community_title, _open.bill_id, _open.receipt_amount,"
						+ "	_open.platform_charge,_open.think_charge, _open.service_charge,_open.refund_money,_xfsj.act_titile activityTitle, _open.bill_finished_time ,_open.community_trade_no"
						+ "	from open_store_order _order LEFT JOIN community_service _service on _order.service_id=_service.id"
						+ "	LEFT JOIN open_merchant_info _info on _service.merchant_id=_info.id"
						+ "	LEFT JOIN community _community on _community.id=_order.community_id"
						+ "	LEFT JOIN open_order _open on _open.out_trade_no=_order.out_trade_no"
						+ "	LEFT JOIN user_info _user on _order.user_id=_user.id"
						+ "	left JOIN open_xfsj_info _xfsj on _xfsj.id=_order.xfsj_id where 1=1");

		if (param.get("type") != null) {
			sb.append(" and _order.type = #{type}");
		}
		if (param.get("communityId") != null) {
			sb.append(" and _order.community_id = #{communityId}");
		}
		if (param.get("communityIdList") != null) {
			sb.append(" and _order.community_id in(" + param.get("communityIdList") + ") ");
		}
		if (param.get("serviceId") != null) {
			sb.append(" and _order.service_id = #{serviceId}");
		}
		if (param.get("merchantId") != null) {
			sb.append(" and _info.id = #{merchantId}");
		}
		if (param.get("sendStatus") != null) {
			sb.append(" and _order.send_status = #{sendStatus}");
		}
		if (param.get("payStatus") != null) {
			sb.append(" and _order.pay_status = #{payStatus}");
		}
		if (param.get("refundStatus") != null) {
			sb.append(" and _order.refund_status = #{refundStatus}");
		}
		if (param.get("verifyStatus") != null) {
			sb.append(" and _order.verify_status = #{verifyStatus}");
		}
		if (param.get("orderCode") != null) {
			sb.append(" and _order.order_code like #{orderCode}");
		}
		if (param.get("outTradeNo") != null) {
			sb.append(" and _order.out_trade_no like #{outTradeNo}");
		}
		if (param.get("startCreateDate") != null) {
			sb.append(" and _order.create_time >= #{startCreateDate}");
		}
		if (param.get("endCreateDate") != null) {
			sb.append(" and _order.create_time <= #{endCreateDate}");
		}
		if(param.get("commentStatus") != null){
			sb.append(" and _order.comment_status = #{commentStatus}");
		}
		if(param.get("groupStatus") != null){
			sb.append(" and _order.group_status = #{groupStatus}");
		}
		sb.append(" order by _order.id desc");

		return sb.toString();
	}

	public String getSuccessTotalMoney(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer(
				"select IFNULL(sum(_order.total_amount),0) total_amount" + " from open_store_order _order "
						+ " LEFT JOIN community_service _service on _order.service_id=_service.id "
						+ " LEFT JOIN open_merchant_info _info on _service.merchant_id=_info.id "
						+ " LEFT JOIN community _community on _community.id=_order.community_id where 1=1");

		if (param.get("type") != null) {
			sb.append(" and _order.type = #{type}");
		}
		if (param.get("communityId") != null) {
			sb.append(" and _order.community_id = #{communityId}");
		}
		if (param.get("communityIdList") != null) {
			sb.append(" and _order.community_id in(" + param.get("communityIdList") + ") ");
		}
		if (param.get("serviceId") != null) {
			sb.append(" and _order.service_id = #{serviceId}");
		}
		if (param.get("merchantId") != null) {
			sb.append(" and _info.id = #{merchantId}");
		}
		if (param.get("sendStatus") != null) {
			sb.append(" and _order.send_status = #{sendStatus}");
		}
		if (param.get("payStatus") != null) {
			sb.append(" and _order.pay_status = #{payStatus}");
		}
		if (param.get("verifyStatus") != null) {
			sb.append(" and _order.verify_status = #{verifyStatus}");
		}
		if (param.get("orderCode") != null) {
			sb.append(" and _order.order_code like #{orderCode}");
		}
		if (param.get("outTradeNo") != null) {
			sb.append(" and _order.out_trade_no like #{outTradeNo}");
		}
		if (param.get("startCreateDate") != null) {
			sb.append(" and _order.create_time >= #{startCreateDate}");
		}
		if (param.get("endCreateDate") != null) {
			sb.append(" and _order.create_time <= #{endCreateDate}");
		}

		return sb.toString();
	}
}
