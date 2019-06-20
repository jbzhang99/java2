package com.rfchina.community.persistence.mapper.open;

import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

public class OpenFeeOrderSqlGlobalProvider {

	public String pageByExample(Map<String, Object> param) {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select o.*,m.title merchant_name,s.title service_name,c.name community_name from open_fee_order o  ");
		sql.append(" left  join community_service s on s.id=o.service_id ");
		sql.append(" left  join open_merchant_info m on m.id=s.merchant_id ");
		sql.append(" left  join community c on c.id=o.community_id ");
		sql.append(" where 1=1 ");

		String pay_status = MapUtils.getString(param, "pay_status", "");
		if (StringUtils.isNotBlank(pay_status)) {
			String[] strs = pay_status.split(",");
			String st = "";
			for (String string : strs) {
				st += ",'" + string + "'";
			}
			sql.append(" and o.pay_status in(").append(st.substring(1)).append(") ");

		}
		if (StringUtils.isNotBlank(MapUtils.getString(param, "begin_create_time", ""))) {
			sql.append(" and o.create_time >= #{begin_create_time} ");
		}
		if (StringUtils.isNotBlank(MapUtils.getString(param, "end_create_time", ""))) {
			sql.append(" and o.create_time <=#{end_create_time} ");
		}
		if (StringUtils.isNotBlank(MapUtils.getString(param, "type", ""))) {
			sql.append(" and o.type=#{type} ");
		}
		if (MapUtils.getInteger(param, "service_id", 0) > 0) {
			sql.append(" and o.service_id = #{service_id} ");
		}
		if (MapUtils.getLong(param, "id", 0L) > 0) {
			sql.append(" and o.id = #{id} ");
		}
		if (MapUtils.getInteger(param, "community_id", 0) > 0) {
			sql.append(" and o.community_id = #{community_id} ");
		}
		if (StringUtils.isNotBlank(MapUtils.getString(param, "verify_no", ""))) {
			sql.append(" and o.verify_no like #{verify_no} ");
		}
		if (StringUtils.isNotBlank(MapUtils.getString(param, "merchant_name", ""))) {
			sql.append(" and m.title like #{merchant_name} ");
		}
		if (StringUtils.isNotBlank(MapUtils.getString(param, "service_name", ""))) {
			sql.append(" and s.title like #{service_name} ");
		}
		if (StringUtils.isNotBlank(MapUtils.getString(param, "order_no", ""))) {
			sql.append(" and o.order_no like #{order_no} ");
		}
		sql.append(" order by o.id desc");
		return sql.toString();
	}

}