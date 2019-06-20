package com.rfchina.community.open.bridge.mapper.ext;

import com.rfchina.community.open.bridge.entity.ExtOpenStoreGoodGroupInfo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.util.Map;

/**
 */
public interface ExtOpenStoreGoodGroupInfoMapper {

	 	@SelectProvider(type=ExtOpenStoreGoodGroupInfoSqlProvider.class, method="pageByCondition")
		@Results({
				@Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
				@Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
				@Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
				@Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
				@Result(column="group_price", property="groupPrice", jdbcType=JdbcType.DECIMAL),
				@Result(column="people_num", property="peopleNum", jdbcType=JdbcType.INTEGER),
				@Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
				@Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
				@Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
				@Result(column="limit_times", property="limitTimes", jdbcType=JdbcType.INTEGER),
				@Result(column="virtural_success_hour", property="virturalSuccessHour", jdbcType=JdbcType.INTEGER),
				@Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
				@Result(column="good_name", property="goodName", jdbcType=JdbcType.VARCHAR),
				@Result(column="service_name", property="serviceName", jdbcType=JdbcType.VARCHAR),
				@Result(column="merchant_name", property="merchantName", jdbcType=JdbcType.VARCHAR),
				@Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
		})
	 	public PageList<ExtOpenStoreGoodGroupInfo> pageByCondition(Map<String, Object> param, PageBounds pageBounds);
}
