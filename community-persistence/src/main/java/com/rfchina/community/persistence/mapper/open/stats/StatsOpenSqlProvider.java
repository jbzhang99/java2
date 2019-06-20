package com.rfchina.community.persistence.mapper.open.stats;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class StatsOpenSqlProvider {

	private static Logger logger = LoggerFactory.getLogger(StatsOpenSqlProvider.class);

	public String zizaiWufuStatsMerchant(Map<String, Object> param) {
		String sql = "select * from  open_stats_merchant where stat_date between  #{startTime,jdbcType=DATE} and #{endTime,jdbcType=DATE} ";

		return sql;
	}
	
	public String zizaiWufuStatsMerchantByStartTime(Map<String, Object> param) {
		String sql = "select  IFNULL(sum(merchant_count),0) merchant_count, IFNULL(sum(shelves_count),0) shelves_count  from  open_stats_merchant where stat_date <  #{startTime,jdbcType=DATE}";
		return sql;
	}

	public String zizaiWufuStatsOrder(Map<String, Object> param) {
		String sql = "select stat_date,sum(order_count) as order_count,sum(total_amount) as total_amount from  open_stats_order where stat_date between #{startTime,jdbcType=TIMESTAMP} and #{endTime,jdbcType=TIMESTAMP} ";
		String group = " group by stat_date";
		Integer communityId = MapUtils.getInteger(param, "communityId", 0);
		if (communityId > 0) {
			sql += " and community_id=#{communityId}";
		}
		Integer serviceId = MapUtils.getInteger(param, "serviceId", 0);
		if (serviceId > 0) {
			sql += " and service_id=#{serviceId}";
		}

		sql = sql + group;
		logger.info("zizaiWufuStatsOrder sql :{}", sql);
		return sql;
	}

	public String zizaiWufuStatsOrderByStartTime(Map<String, Object> param) {
		String sql = "select stat_date,IFNULL(sum(order_count),0) as order_count,IFNULL(sum(total_amount),0) as total_amount from  open_stats_order where stat_date < #{startTime,jdbcType=TIMESTAMP} ";
		Integer communityId = MapUtils.getInteger(param, "communityId", 0);
		if (communityId > 0) {
			sql += " and community_id=#{communityId}";
		}
		Integer serviceId = MapUtils.getInteger(param, "serviceId", 0);
		if (serviceId > 0) {
			sql += " and service_id=#{serviceId}";
		}

		logger.info("zizaiWufuStatsOrderByStartTime sql :{}", sql);
		return sql;
	}
	
	public String statOrderStream(Map<String, Object> param) {
		String sql = "select DATE(bill_finished_time) stat_date,IFNULL(sum(total_amount),0) total_amount,IFNULL(sum(refund_money),0) refund_money,IFNULL(sum(platform_charge),0) platform_charge, IFNULL(sum(service_charge),0) service_charge,IFNULL(sum(receipt_amount),0) receipt_amount "
				+ " from open_order _order LEFT JOIN community_service _service "
				+ "	on _order.service_id = _service.id where _order.bill_status=2 and _order.type in (1,4,5) "
				+"	and bill_finished_time > #{startTime,jdbcType=TIMESTAMP} and bill_finished_time < #{endTime,jdbcType=TIMESTAMP}";
		Integer categoryId = MapUtils.getInteger(param, "categoryId", 0);
		if (categoryId > 0) {
			sql += " and category_id=#{categoryId}";
		}
		sql += " and bill_finished_time is not null group by DATE(bill_finished_time)";
		logger.info("statOrderStream sql :{}", sql);
		return sql;
	}
	
	public String zizaiStreamOrderStat(Map<String, Object> param) {
		String sql = "select _c2.name second_category_name,x.* from (" +
				"	select _c1.name category_name, _order.service_id,_service.title,_service.category_id,_detail.category_second_type,_info.title merchant_name,_info.type,count(*) order_count, count(refund_money>0 or null) refund_count, " +
				"	IFNULL(sum(total_amount),0) total_amount,IFNULL(sum(refund_money),0) refund_money,IFNULL(sum(platform_charge),0) platform_charge, IFNULL(sum(service_charge),0) service_charge, " + 
				"	IFNULL(sum(receipt_amount),0) receipt_amount from open_order _order LEFT JOIN community_service _service on _order.service_id = _service.id  " + 
				"	LEFT JOIN open_service_detail _detail on _detail.service_id = _service.id " + 
				"	LEFT JOIN open_merchant_info _info on _service.merchant_id=_info.id " + 
				" 	LEFT JOIN community_service_category _c1 on _service.category_id=_c1.id " +
				"	where _order.bill_status=2 and _order.type in (1,4,5)"
				+"	and bill_finished_time > #{startTime,jdbcType=TIMESTAMP} and bill_finished_time < #{endTime,jdbcType=TIMESTAMP}";
		
		Integer categoryId = MapUtils.getInteger(param, "categoryId", 0);
		if (categoryId > 0) {
			sql += " and category_id=#{categoryId}";
		}
		sql += "	group by _order.service_id ) x LEFT JOIN community_service_category _c2 ON x.category_second_type = _c2.id";
		logger.info("statOrderStream sql :{}", sql);
		return sql;
	}
}