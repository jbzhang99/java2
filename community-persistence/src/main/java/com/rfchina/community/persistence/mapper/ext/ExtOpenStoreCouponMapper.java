package com.rfchina.community.persistence.mapper.ext;

import java.io.Serializable;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import com.rfchina.community.persistence.model.OpenStoreCoupon;

public interface ExtOpenStoreCouponMapper extends Serializable {

	@SelectProvider(type = ExtOpenStoreCouponSqlProvider.class, method = "pageByCondition")
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "service_id", property = "serviceId", jdbcType = JdbcType.INTEGER),
			@Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
			@Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
			@Result(column = "pic", property = "pic", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sub_title", property = "subTitle", jdbcType = JdbcType.VARCHAR),
			@Result(column = "coupon_no", property = "couponNo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "begin_time", property = "beginTime", jdbcType = JdbcType.DATE),
			@Result(column = "end_time", property = "endTime", jdbcType = JdbcType.DATE),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "details", property = "details", jdbcType = JdbcType.LONGVARCHAR) })
	public PageList<OpenStoreCoupon> pageByCondition(Map<String, Object> param, PageBounds pageBounds);

}