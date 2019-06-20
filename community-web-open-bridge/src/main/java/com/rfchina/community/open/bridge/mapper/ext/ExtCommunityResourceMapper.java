package com.rfchina.community.open.bridge.mapper.ext;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import com.rfchina.community.open.bridge.entity.ExtCommunityResourceActivity;
import com.rfchina.community.persistence.mapper.CommunityResourceMapper;
import com.rfchina.community.persistence.model.CommunityResource;
import com.rfchina.community.persistence.model.CommunityResourceExample;

public interface ExtCommunityResourceMapper extends CommunityResourceMapper{
	
	@SelectProvider(type=ExtCommunityResourceSqlProvider.class, method="pageByExample")
	@Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="city_id", property="cityId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="resource_type_id", property="resourceTypeId", jdbcType=JdbcType.INTEGER),
        @Result(column="addr_detail", property="addrDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="resource_desc", property="resourceDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="resource_total", property="resourceTotal", jdbcType=JdbcType.INTEGER),
        @Result(column="resource_used", property="resourceUsed", jdbcType=JdbcType.INTEGER),
        @Result(column="resource_fee", property="resourceFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="imgs", property="imgs", jdbcType=JdbcType.VARCHAR),
        @Result(column="resource_status", property="resourceStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creater_id", property="createrId", jdbcType=JdbcType.INTEGER),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modifier_id", property="modifierId", jdbcType=JdbcType.INTEGER)
    })
	PageList<CommunityResource> pageByExample(@Param("example") CommunityResourceExample example, PageBounds pageBounds);
	
	@SelectProvider(type=ExtCommunityResourceSqlProvider.class, method="getByActivityId")
	@Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),     
        @Result(column="city_id", property="cityId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="resource_type_title", property="resourceTypeTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="addr_detail", property="addrDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="resource_desc", property="resourceDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="resource_fee", property="resourceFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="imgs", property="imgs", jdbcType=JdbcType.VARCHAR),
    })
	PageList<ExtCommunityResourceActivity> getCommunityResourceByActivityId(Long ActivityId);
	
	@Update({
		"update community_resource",
        "set resource_status = 0,",
          "modify_time = NOW(),",
          "modifier_id = #{modifierId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
	int deleteBycommunityResourceId(CommunityResource record);
	
}
