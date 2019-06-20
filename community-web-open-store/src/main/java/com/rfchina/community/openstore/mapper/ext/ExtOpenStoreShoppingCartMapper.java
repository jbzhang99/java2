package com.rfchina.community.openstore.mapper.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.rfchina.community.persistence.model.OpenStoreShoppingCart;

/**
 */
public interface ExtOpenStoreShoppingCartMapper {

	@SelectProvider(type = ExtOpenStoreShoppingCartSqlProvider.class, method = "getOpenStoreCartList")
	 @Results({
	        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
	        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
	        @Result(column="open_id", property="openId", jdbcType=JdbcType.VARCHAR),
	        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
	        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
	        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="valid_status", property="validStatus", jdbcType=JdbcType.INTEGER)
	    })
	public List<OpenStoreShoppingCart> getOpenStoreCartList(@Param("userId") Long userId);

	@SelectProvider(type = ExtOpenStoreShoppingCartSqlProvider.class, method = "getCartNum")
	public long getCartNum(@Param("userId") Long userId);

}
