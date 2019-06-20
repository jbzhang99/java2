package com.rfchina.community.persistence.mapper.open;

import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenQuickOrderGlobalSqlProvider {
	private static Logger logger = LoggerFactory.getLogger(OpenQuickOrderGlobalSqlProvider.class);

	public String pageByExample(Map<String, Object> param) {
		StringBuffer sql = new StringBuffer();

		sql.append(" select o.*,s.title service_name,i.title merchant_name, ");
		sql.append(" c.name community_name,p.pay_channel,p.trade_type ,p.success_time ");
		sql.append(" from open_quick_order o  ");
		sql.append(" LEFT JOIN community_service s on o.service_id=s.id ");
		sql.append(" LEFT JOIN open_merchant_info i on s.merchant_id=i.id ");
		sql.append(" left JOIN community c on o.community_id=c.id ");
		sql.append(" left join open_quick_order_pay p on p.out_trade_no=o.out_trade_no ");
		sql.append(" where 1=1 ");

		if (StringUtils.isNotBlank(MapUtils.getString(param, "begin_create_time", ""))) {
			sql.append(" and o.create_time >= #{begin_create_time} ");
		}
		if (StringUtils.isNotBlank(MapUtils.getString(param, "end_create_time", ""))) {
			sql.append(" and o.create_time <=#{end_create_time} ");
		}

		if (MapUtils.getInteger(param, "community_id", 0) > 0) {
			sql.append(" and o.community_id = #{community_id} ");
		}

		if (StringUtils.isNotBlank(MapUtils.getString(param, "merchant_name", ""))) {
			sql.append(" and i.title like #{merchant_name} ");
		}
		if (StringUtils.isNotBlank(MapUtils.getString(param, "service_name", ""))) {
			sql.append(" and s.title like #{service_name} ");
		}

		if (MapUtils.getLong(param, "uid", 0L) > 0) {
			sql.append(" and o.uid = #{uid} ");
		}

		if (MapUtils.getLong(param, "id", 0L) > 0) {
			sql.append(" and o.id = #{id} ");
		}
		if (MapUtils.getIntValue(param, "bill_status", -1) > -1) {
			sql.append(" and o.bill_status = #{bill_status} ");
		}

		if (StringUtils.isNotBlank(MapUtils.getString(param, "out_trade_no", ""))) {
			sql.append(" and o.out_trade_no like #{out_trade_no} ");
		}

		if (MapUtils.getInteger(param, "service_id", 0) > 0) {
			sql.append(" and o.service_id = #{service_id} ");
		}

		sql.append(" order by o.id desc");
		logger.info("{}",sql);
		return sql.toString();
	}
}