package com.rfchina.community.persistence.mapper.open;

import java.io.Serializable;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import com.rfchina.community.persistence.model.ext.ExtStoreCoupon;

public interface CmStoreCouponGlobalMapper extends Serializable {

	@SelectProvider(type = CmStoreCouponGlobalSqlProvider.class, method = "pageByExample")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "coupon_name", property = "couponName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "coupon_type", property = "couponType", jdbcType = JdbcType.INTEGER),
			@Result(column = "coupon_num", property = "couponNum", jdbcType = JdbcType.INTEGER),
			@Result(column = "valid_from_date", property = "validFromDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "valid_to_date", property = "validToDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "allow_from_date", property = "allowFromDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "allow_to_date", property = "allowToDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "item_type", property = "itemType", jdbcType = JdbcType.INTEGER),
			@Result(column = "use_rule", property = "useRule", jdbcType = JdbcType.VARCHAR),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "coupon_amount", property = "couponAmount", jdbcType = JdbcType.DECIMAL),
			@Result(column = "pay_amount", property = "payAmount", jdbcType = JdbcType.DECIMAL),
			@Result(column = "open_status", property = "openStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "deliver_num", property = "deliverNum", jdbcType = JdbcType.INTEGER),
			@Result(column = "user_limit", property = "userLimit", jdbcType = JdbcType.INTEGER),
			@Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "card_item_id", property = "cardItemId", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "service_id", property = "serviceId", jdbcType = JdbcType.INTEGER),
			@Result(column = "merchant_id", property = "merchantId", jdbcType = JdbcType.BIGINT),
			@Result(column = "limit_money", property = "limitMoney", jdbcType = JdbcType.DECIMAL),
			@Result(column = "merchant_name", property = "merchantName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "service_name", property = "serviceName", jdbcType = JdbcType.VARCHAR) })
	PageList<ExtStoreCoupon> pageByExample(Map<String, Object> example, PageBounds pageBounds);
	
	@UpdateProvider(type = CmStoreCouponGlobalSqlProvider.class, method = "reduceCouponNum")
	int reduceCouponNum(Map<String, Object> param);

}