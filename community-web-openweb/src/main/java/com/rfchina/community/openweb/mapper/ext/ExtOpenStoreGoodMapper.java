package com.rfchina.community.openweb.mapper.ext;

import com.rfchina.community.openweb.entity.ExtOpenStoreGood;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.util.Map;

/**
 */
public interface ExtOpenStoreGoodMapper {

	 	@SelectProvider(type=ExtOpenStoreGoodSqlProvider.class, method="pageByCondition")
	    @Results({
	        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
	        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
	        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
	        @Result(column="pre_price", property="prePrice", jdbcType=JdbcType.DECIMAL),
	        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
	        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
	        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
				@Result(column="recommend", property="recommend", jdbcType=JdbcType.INTEGER),
			@Result(column="sorting", property="sorting", jdbcType=JdbcType.INTEGER),
	        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.LONGVARCHAR),
	        @Result(column="sale_amount", property="saleAmount", jdbcType=JdbcType.INTEGER),
	        @Result(column="premium_num", property="premiumNum", jdbcType=JdbcType.INTEGER)
	    })
	 	public PageList<ExtOpenStoreGood> pageByCondition(Map<String, Object> param, PageBounds pageBounds);
}
