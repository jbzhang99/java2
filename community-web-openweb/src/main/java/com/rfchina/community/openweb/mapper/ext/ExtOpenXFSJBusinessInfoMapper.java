package com.rfchina.community.openweb.mapper.ext;

import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import com.rfchina.community.openweb.entity.ExtOpenXFSJBusinessInfo;
import com.rfchina.community.persistence.mapper.CommunityResourceMapper;

public interface ExtOpenXFSJBusinessInfoMapper extends CommunityResourceMapper{
	
	@SelectProvider(type=ExtOpenXFSJBusinessInfoSqlProvider.class, method="listBusinessInfo")
	@Results({
	        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
	        @Result(column="xfsj_id", property="xfsjId", jdbcType=JdbcType.BIGINT, id=true),
	        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
	        @Result(column="service_fee", property="serviceFee", jdbcType=JdbcType.DECIMAL),
	        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
	        @Result(column="contact_phone", property="contactPhone", jdbcType=JdbcType.VARCHAR),
	        @Result(column="sign_up_end_time", property="signUpEndTime", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="sign_up_status", property="signUpStatus", jdbcType=JdbcType.INTEGER),
	        @Result(column="locale_img", property="localeImg", jdbcType=JdbcType.LONGVARCHAR),
	        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
	        @Result(column="act_titile", property="actTitile", jdbcType=JdbcType.VARCHAR),
	        @Result(column="act_address", property="actAddress", jdbcType=JdbcType.VARCHAR),
	        @Result(column="act_time", property="actTime", jdbcType=JdbcType.VARCHAR),
	        @Result(column="act_img", property="actImg", jdbcType=JdbcType.VARCHAR),
	        @Result(column="act_url", property="actUrl", jdbcType=JdbcType.VARCHAR),
	        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
	        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT),
	        @Result(column="begin_time", property="beginTime", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="area_name", property="areaName", jdbcType=JdbcType.VARCHAR),
	        @Result(column="community_name", property="communityName", jdbcType=JdbcType.VARCHAR)
	        
	})
	PageList<ExtOpenXFSJBusinessInfo> listBusinessInfo(Map<String, Object> map, PageBounds pageBounds);
	
	
	@SelectProvider(type=ExtOpenXFSJBusinessInfoSqlProvider.class, method="listMyBusinessInfo")
	@Results({
	        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
	        @Result(column="xfsj_id", property="xfsjId", jdbcType=JdbcType.BIGINT, id=true),
	        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
	        @Result(column="service_fee", property="serviceFee", jdbcType=JdbcType.DECIMAL),
	        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
	        @Result(column="contact_phone", property="contactPhone", jdbcType=JdbcType.VARCHAR),
	        @Result(column="sign_up_end_time", property="signUpEndTime", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="sign_up_status", property="signUpStatus", jdbcType=JdbcType.INTEGER),
	        @Result(column="locale_img", property="localeImg", jdbcType=JdbcType.LONGVARCHAR),
	        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
	        @Result(column="act_titile", property="actTitile", jdbcType=JdbcType.VARCHAR),
	        @Result(column="act_address", property="actAddress", jdbcType=JdbcType.VARCHAR),
	        @Result(column="act_time", property="actTime", jdbcType=JdbcType.VARCHAR),
	        @Result(column="act_img", property="actImg", jdbcType=JdbcType.VARCHAR),
	        @Result(column="act_url", property="actUrl", jdbcType=JdbcType.VARCHAR),
	        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
	        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT),
	        @Result(column="begin_time", property="beginTime", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="area_name", property="areaName", jdbcType=JdbcType.VARCHAR),
	        @Result(column="community_name", property="communityName", jdbcType=JdbcType.VARCHAR)
	        
	})
	PageList<ExtOpenXFSJBusinessInfo> listMyBusinessInfo(Map<String, Object> map, PageBounds pageBounds);
	
}
