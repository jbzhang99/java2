package com.rfchina.community.openstore.mapper.ext;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.rfchina.community.persistence.mapper.open.OpenQuickOrderGlobalSqlProvider;
import com.rfchina.community.persistence.model.ext.ExtOpenQuickOrder;

public interface ExtOpenQuickOrderMapper extends Serializable {

	@SelectProvider(type = OpenQuickOrderGlobalSqlProvider.class, method = "pageByExample")
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "uid", property = "uid", jdbcType = JdbcType.BIGINT),
			@Result(column = "community_id", property = "communityId", jdbcType = JdbcType.INTEGER),
			@Result(column = "service_id", property = "serviceId", jdbcType = JdbcType.INTEGER),
			@Result(column = "total_money", property = "totalMoney", jdbcType = JdbcType.DECIMAL),
			@Result(column = "subtract_money", property = "subtractMoney", jdbcType = JdbcType.DECIMAL),
			@Result(column = "coupon_money", property = "couponMoney", jdbcType = JdbcType.DECIMAL),
			@Result(column = "real_money", property = "realMoney", jdbcType = JdbcType.DECIMAL),
			@Result(column = "coupon_id", property = "couponId", jdbcType = JdbcType.BIGINT),
			@Result(column = "bill_status", property = "billStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "out_trade_no", property = "outTradeNo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "community_trade_no", property = "communityTradeNo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "bill_id", property = "billId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "pay_time", property = "payTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "service_name", property = "serviceName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "merchant_name", property = "merchantName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "community_name", property = "communityName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "pay_channel", property = "payChannel", jdbcType = JdbcType.VARCHAR),
			@Result(column = "trade_type", property = "tradeType", jdbcType = JdbcType.VARCHAR) })

	List<ExtOpenQuickOrder> pageByExample(Map<String, Object> example );

}