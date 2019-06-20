package com.rfchina.community.persistence.mapper.open;

import java.io.Serializable;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import com.rfchina.community.persistence.model.ext.ExtOpenFeeOrder;

public interface OpenFeeOrderGlobalMapper extends Serializable {

	@SelectProvider(type = OpenFeeOrderSqlGlobalProvider.class, method = "pageByExample")
	@Results({

			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "community_id", property = "communityId", jdbcType = JdbcType.INTEGER),
			@Result(column = "service_id", property = "serviceId", jdbcType = JdbcType.INTEGER),
			@Result(column = "verify_no", property = "verifyNo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "type", property = "type", jdbcType = JdbcType.CHAR),
			@Result(column = "order_no", property = "orderNo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "store_order_id", property = "storeOrderId", jdbcType = JdbcType.INTEGER),
			@Result(column = "trade_amount", property = "tradeAmount", jdbcType = JdbcType.DECIMAL),
			@Result(column = "platform_charge", property = "platformCharge", jdbcType = JdbcType.DECIMAL),
			@Result(column = "platform_charge_rate", property = "platformChargeRate", jdbcType = JdbcType.DECIMAL),
			@Result(column = "service_charge", property = "serviceCharge", jdbcType = JdbcType.DECIMAL),
			@Result(column = "service_charge_rate", property = "serviceChargeRate", jdbcType = JdbcType.DECIMAL),
			@Result(column = "pay_amount", property = "payAmount", jdbcType = JdbcType.DECIMAL),
			@Result(column = "pay_id", property = "payId", jdbcType = JdbcType.BIGINT),
			@Result(column = "pay_status", property = "payStatus", jdbcType = JdbcType.CHAR),
			@Result(column = "pay_time", property = "payTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "order_explain", property = "orderExplain", jdbcType = JdbcType.VARCHAR),
			@Result(column = "goods_detail", property = "goodsDetail", jdbcType = JdbcType.LONGVARCHAR),
			@Result(column = "sales_contract", property = "salesContract", jdbcType = JdbcType.LONGVARCHAR),
			@Result(column = "service_name", property = "serviceName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "merchant_name", property = "merchantName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "community_name", property = "communityName", jdbcType = JdbcType.VARCHAR)

	})
	PageList<ExtOpenFeeOrder> pageByExample(Map<String, Object> example, PageBounds pageBounds);

}