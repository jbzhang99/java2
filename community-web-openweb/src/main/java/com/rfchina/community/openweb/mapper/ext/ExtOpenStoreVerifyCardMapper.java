package com.rfchina.community.openweb.mapper.ext;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import com.rfchina.community.openweb.entity.ExtOpenOrder;
import com.rfchina.community.openweb.entity.ExtOpenStoreGood;
import com.rfchina.community.service.openser.entity.ExtVerifyCardVO;

/**
 */
public interface ExtOpenStoreVerifyCardMapper {

	 	@SelectProvider(type=ExtOpenStoreVerifyCardSqlProvider.class, method="pageByCondition")
	 	@Results({
 	        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
 	        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
 	        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
 	        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER),
 	        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
 	        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
 	        @Result(column="good_order_rel_id", property="goodOrderRelId", jdbcType=JdbcType.INTEGER),
 	        @Result(column="good_code", property="goodCode", jdbcType=JdbcType.VARCHAR),
 	        @Result(column="good_name", property="goodName", jdbcType=JdbcType.VARCHAR),
 	        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
 	        @Result(column="verify_start_time", property="verifyStartTime", jdbcType=JdbcType.TIMESTAMP),
 	        @Result(column="verify_end_time", property="verifyEndTime", jdbcType=JdbcType.TIMESTAMP),
 	        @Result(column="verify_status", property="verifyStatus", jdbcType=JdbcType.INTEGER),
 	        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
 	        @Result(column="verify_time", property="verifyTime", jdbcType=JdbcType.TIMESTAMP),
 	        @Result(column="single_scale_price", property="singleScalePrice", jdbcType=JdbcType.DECIMAL)
 	    })
	 	public PageList<ExtVerifyCardVO> pageByCondition(Map<String, Object> param, PageBounds pageBounds);

}
