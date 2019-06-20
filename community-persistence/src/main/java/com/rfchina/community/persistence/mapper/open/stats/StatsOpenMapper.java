package com.rfchina.community.persistence.mapper.open.stats;

import com.rfchina.community.persistence.model.OpenStatsMerchant;
import com.rfchina.community.persistence.model.OpenStatsOrder;
import com.rfchina.community.persistence.model.ext.ExtStatOrderStream;
import com.rfchina.community.persistence.model.ext.ExtStatOrderStreamDetail;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface StatsOpenMapper extends Serializable {

	@SelectProvider(type = StatsOpenSqlProvider.class, method = "zizaiWufuStatsMerchant")
	@Results({ @Result(column = "stat_date", property = "statDate", jdbcType = JdbcType.DATE, id = true),
			@Result(column = "stat_wreek", property = "statWreek", jdbcType = JdbcType.INTEGER),
			@Result(column = "stat_month", property = "statMonth", jdbcType = JdbcType.INTEGER),
			@Result(column = "merchant_count", property = "merchantCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "shelves_count", property = "shelvesCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	List<OpenStatsMerchant> zizaiWufuStatsMerchant(@Param("startTime") LocalDate startTime,
			@Param("endTime") LocalDate endTime);

	@SelectProvider(type = StatsOpenSqlProvider.class, method = "zizaiWufuStatsOrder")
	@Results({ @Result(column = "stat_date", property = "statDate", jdbcType = JdbcType.DATE, id = true),
			@Result(column = "order_count", property = "orderCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "total_amount", property = "totalAmount", jdbcType = JdbcType.DECIMAL) })
	List<OpenStatsOrder> zizaiWufuStatsOrder(@Param("startTime") LocalDate startTime,
			@Param("endTime") LocalDate endTime, @Param("communityId") Integer communityId,
			@Param("serviceId") Integer serviceId);
	
	@SelectProvider(type = StatsOpenSqlProvider.class, method = "zizaiWufuStatsOrderByStartTime")
	@Results({ @Result(column = "stat_date", property = "statDate", jdbcType = JdbcType.DATE, id = true),
		@Result(column = "order_count", property = "orderCount", jdbcType = JdbcType.INTEGER),
		@Result(column = "total_amount", property = "totalAmount", jdbcType = JdbcType.DECIMAL) })
	List<OpenStatsOrder> zizaiWufuStatsOrderByStartTime(@Param("startTime") LocalDate startTime
			, @Param("communityId") Integer communityId,@Param("serviceId") Integer serviceId);

	@SelectProvider(type = StatsOpenSqlProvider.class, method = "zizaiWufuStatsMerchantByStartTime")
	@Results({ @Result(column = "stat_date", property = "statDate", jdbcType = JdbcType.DATE, id = true),
		@Result(column = "stat_wreek", property = "statWreek", jdbcType = JdbcType.INTEGER),
		@Result(column = "stat_month", property = "statMonth", jdbcType = JdbcType.INTEGER),
		@Result(column = "merchant_count", property = "merchantCount", jdbcType = JdbcType.INTEGER),
		@Result(column = "shelves_count", property = "shelvesCount", jdbcType = JdbcType.INTEGER),
		@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	List<OpenStatsMerchant> zizaiWufuStatsMerchantByStartTime(@Param("startTime") LocalDate startTime);

	@SelectProvider(type = StatsOpenSqlProvider.class, method = "statOrderStream")
	@Results({ 
		@Result(column = "total_amount", property = "totalAmount", jdbcType = JdbcType.DECIMAL),
		@Result(column = "refund_money", property = "refundMoney", jdbcType = JdbcType.DECIMAL),
		@Result(column = "platform_charge", property = "platformCharge", jdbcType = JdbcType.DECIMAL),
		@Result(column = "service_charge", property = "serviceCharge", jdbcType = JdbcType.DECIMAL),
		@Result(column = "receipt_amount", property = "receiptAmount", jdbcType = JdbcType.DECIMAL),
		@Result(column = "stat_date", property = "statDate", jdbcType = JdbcType.VARCHAR)
		})
	List<ExtStatOrderStream> statOrderStream(@Param("startTime") Date startTime,
			@Param("endTime")  Date endTime, @Param("categoryId") Integer categoryId);

	@SelectProvider(type = StatsOpenSqlProvider.class, method = "zizaiStreamOrderStat")
	@Results({ 
		@Result(column = "category_name", property = "categoryName", jdbcType = JdbcType.VARCHAR),
		@Result(column = "second_category_name", property = "secondCategoryName", jdbcType = JdbcType.VARCHAR),
		@Result(column = "service_id", property = "serviceId", jdbcType = JdbcType.INTEGER),
		@Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
		@Result(column = "category_id", property = "categoryId", jdbcType = JdbcType.INTEGER),
		@Result(column = "category_second_type", property = "categorySecondType", jdbcType = JdbcType.INTEGER),
		@Result(column = "merchant_name", property = "merchantName", jdbcType = JdbcType.VARCHAR),
		@Result(column = "type", property = "type", jdbcType = JdbcType.INTEGER),
		@Result(column = "order_count", property = "orderCount", jdbcType = JdbcType.INTEGER),
		@Result(column = "refund_count", property = "refundCount", jdbcType = JdbcType.INTEGER),
		@Result(column = "total_amount", property = "totalAmount", jdbcType = JdbcType.DECIMAL),
		@Result(column = "refund_money", property = "refundMoney", jdbcType = JdbcType.DECIMAL),
		@Result(column = "platform_charge", property = "platformCharge", jdbcType = JdbcType.DECIMAL),
		@Result(column = "service_charge", property = "serviceCharge", jdbcType = JdbcType.DECIMAL),
		@Result(column = "receipt_amount", property = "receiptAmount", jdbcType = JdbcType.DECIMAL)
		})
	PageList<ExtStatOrderStreamDetail> zizaiStreamOrderStat(@Param("startTime") Date startTime,
			@Param("endTime")  Date endTime, @Param("categoryId") Integer categoryId, PageBounds pageBounds);
}