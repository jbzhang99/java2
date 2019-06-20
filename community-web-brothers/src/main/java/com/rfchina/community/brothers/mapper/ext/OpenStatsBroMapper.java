package com.rfchina.community.brothers.mapper.ext;

import org.apache.ibatis.annotations.Update;

import java.util.Date;

/**
 */
public interface OpenStatsBroMapper {

	@Update({ "delete from open_stats_order where stat_date = #{statDate,jdbcType=DATE}" })
	public int deleteOpenStatsOrder(Date statDate);

	@Update({
			"INSERT INTO  `open_stats_order` (`stat_date`, `community_id`, `service_id`,  `order_count`, `total_amount`, `create_time`) "
					+ " select date(bill_finished_time),community_id,service_id,COUNT(*) as order_count,sum(total_amount) AS total_amount,now() from open_order "
					+ " where type in (1,4,5,6) and bill_status=2 and date(bill_finished_time) = #{statDate,jdbcType=DATE}"
					+ " group by community_id,service_id ,date(bill_finished_time)" })
	public int updataOpenStatsOrder(Date statDate);

	@Update({ "delete from open_stats_merchant where stat_date = #{statDate,jdbcType=DATE}" })
	public int deleteOpenStatsMerchant(Date statDate);

	@Update({ "INSERT INTO  `open_stats_merchant` (`stat_date`,create_time) "
			+ "	select date(create_time) as stat_date ,now()  from open_merchant_info  where date(create_time) = #{statDate,jdbcType=DATE} group by date(create_time) UNION "
			+ "	SELECT date(update_time) as stat_date ,now() FROM `open_audit_info` WHERE `audit_type` ='submit_service_audit' and date(update_time) = #{statDate,jdbcType=DATE} and audit_status=2 group BY date(update_time)" })
	public int updateOpenStatsMerchant(Date statDate);

	@Update({
			"update open_stats_merchant a set a.merchant_count=(select count(*) as merchant_count  from open_merchant_info where date(create_time)=a.stat_date group by date(create_time)) where stat_date = #{statDate,jdbcType=DATE}" })
	public int updateOpenStatsMerchant11(Date statDate);

	@Update({ "update open_stats_merchant set merchant_count=0 where merchant_count is null " })
	public int updateOpenStatsMerchant12(Date statDate);

	@Update({
			"update open_stats_merchant a set a.shelves_count=(SELECT  count(*) as shelves_count FROM `open_audit_info` WHERE `audit_type` ='submit_service_audit' and audit_status=2 and date(update_time)=a.stat_date  group BY date(update_time)) where  stat_date = #{statDate,jdbcType=DATE}" })
	public int updateOpenStatsMerchant21(Date statDate);

	@Update({ "update open_stats_merchant set shelves_count=0 where shelves_count is null" })
	public int updateOpenStatsMerchant22(Date statDate);

}
