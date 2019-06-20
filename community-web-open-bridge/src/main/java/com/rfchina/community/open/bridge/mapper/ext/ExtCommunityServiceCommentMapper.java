package com.rfchina.community.open.bridge.mapper.ext;

import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import com.rfchina.community.open.bridge.entity.ExtCommunityServiceComment;

public interface ExtCommunityServiceCommentMapper {

	
	@SelectProvider(type=ExtCommunityServiceCommentSqlProvider.class , method="pageCommunityServiceCommnet")
	@Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_name", property="communityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_phone", property="userPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="area_name", property="areaName", jdbcType=JdbcType.VARCHAR)
    })
	public PageList<ExtCommunityServiceComment> pageCommunityServiceCommnet(Map<String, Object> param , PageBounds pageBounds);
	
}
