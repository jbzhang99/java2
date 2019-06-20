package com.rfchina.community.openstore.mapper.ext;

import com.rfchina.community.persistence.model.Community;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

/**
 */
public interface ExtCommunityMapper {


    @Select({"select _community.* from community _community join open_xfsj_info _info on _community.id=_info.community_id where _info.status=1  and _info.type='community'"})
	@Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="qrcode_url", property="qrcodeUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
        @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
        @Result(column="admin_id", property="adminId", jdbcType=JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="logo_url", property="logoUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="background_url", property="backgroundUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="topic_audit", property="topicAudit", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="cid", property="cid", jdbcType=JdbcType.BIGINT),
        @Result(column="weixin", property="weixin", jdbcType=JdbcType.VARCHAR),
        @Result(column="property_company", property="propertyCompany", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_person", property="businessPerson", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_phone", property="businessPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_email", property="businessEmail", jdbcType=JdbcType.VARCHAR)
    })
	PageList<Community> getXFSJCommunity( PageBounds pageBounds);
}
