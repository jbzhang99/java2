package com.rfchina.community.open.bridge.mapper.ext;

import com.rfchina.community.persistence.model.ext.ExtOpenOperatorTask;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.io.Serializable;
import java.util.Map;

public interface ExtOpenOperatorTaskBridgeMapper extends Serializable {

	@SelectProvider(type=ExtOpenOperatorTaskBridgeSqlProvider.class, method="pageQuery")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "city_id", property = "cityId", jdbcType = JdbcType.INTEGER),
			@Result(column = "community_id", property = "communityId", jdbcType = JdbcType.INTEGER),
			@Result(column = "xfsj_id", property = "xfsjId", jdbcType = JdbcType.BIGINT),
			@Result(column = "service_id", property = "serviceId", jdbcType = JdbcType.INTEGER),
			@Result(column = "merchant_id", property = "merchantId", jdbcType = JdbcType.BIGINT),
			@Result(column = "start_time", property = "startTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "end_time", property = "endTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "release_status", property = "releaseStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "release_time", property = "releaseTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "receive_status", property = "receiveStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "emp_guid", property = "empGuid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "emp_phone", property = "empPhone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "emp_name", property = "empName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "become_time", property = "becomeTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "address", property = "address", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "city_name", property = "cityName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "community_name", property = "communityName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "type", property = "type", jdbcType = JdbcType.VARCHAR),
			@Result(column = "act_titile", property = "actTitile", jdbcType = JdbcType.VARCHAR),
			@Result(column = "merchant_name", property = "merchantName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "service_name", property = "serviceName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "category_id", property = "categoryId", jdbcType = JdbcType.INTEGER),
			@Result(column = "category_name", property = "categoryName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "activity_status", property = "activityStatus", jdbcType = JdbcType.INTEGER)

	})
	public PageList<ExtOpenOperatorTask> pageQuery(Map<String, Object> param, PageBounds pageBounds);
	
}