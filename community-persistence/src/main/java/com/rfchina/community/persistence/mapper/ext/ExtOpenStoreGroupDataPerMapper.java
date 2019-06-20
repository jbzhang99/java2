package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.model.OpenStoreGroupData;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

/**
 */
public interface ExtOpenStoreGroupDataPerMapper {

	@UpdateProvider(type = ExtOpenStoreGroupDataPerSqlProvider.class, method = "lockGroupDataUsableNum")
	public int lockGroupDataUsableNum(Map<String, Object> param);


	@Select({
			"select * from open_store_group_data where status=0 and stop_time <= now() and usable_num > 0  limit #{limitNum, jdbcType=INTEGER} "
	})
	@Results({
			@Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
			@Result(column="good_group_id", property="goodGroupId", jdbcType=JdbcType.BIGINT),
			@Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
			@Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
			@Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
			@Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
			@Result(column="start_type", property="startType", jdbcType=JdbcType.VARCHAR),
			@Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
			@Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
			@Result(column="people_num", property="peopleNum", jdbcType=JdbcType.INTEGER),
			@Result(column="success_num", property="successNum", jdbcType=JdbcType.INTEGER),
			@Result(column="usable_num", property="usableNum", jdbcType=JdbcType.INTEGER),
			@Result(column="lock_num", property="lockNum", jdbcType=JdbcType.INTEGER),
			@Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
			@Result(column="stop_time", property="stopTime", jdbcType=JdbcType.TIMESTAMP),
			@Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
			@Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
			@Result(column="success_time", property="successTime", jdbcType=JdbcType.TIMESTAMP)
	})
	List<OpenStoreGroupData> selectUnSuccessList(@Param("limitNum") int limitNum);
}
