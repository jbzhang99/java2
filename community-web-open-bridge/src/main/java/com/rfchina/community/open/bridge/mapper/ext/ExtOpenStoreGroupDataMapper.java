package com.rfchina.community.open.bridge.mapper.ext;

import com.rfchina.community.open.bridge.entity.ExtOpenStoreGroupData;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.util.Map;

/**
 */
public interface ExtOpenStoreGroupDataMapper {

	 	@SelectProvider(type=ExtOpenStoreGroupDataSqlProvider.class, method="pageByCondition")
		@Results({
				@Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
				@Result(column="good_group_id", property="goodGroupId", jdbcType=JdbcType.BIGINT),
				@Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
				@Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
				@Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
				@Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
				@Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
				@Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
				@Result(column="good_name", property="goodName", jdbcType=JdbcType.VARCHAR),
				@Result(column="service_name", property="serviceName", jdbcType=JdbcType.VARCHAR),
				@Result(column="success_time", property="successTime", jdbcType=JdbcType.TIMESTAMP)
		})
	 	public PageList<ExtOpenStoreGroupData> pageByCondition(Map<String, Object> param, PageBounds pageBounds);
}
