package com.rfchina.community.openweb.mapper.ext;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import com.rfchina.community.persistence.model.Community;
import com.rfchina.community.persistence.model.CommunityExample;

/**
 */
public interface ExtCommunityMapper {

    @SelectProvider(type=ExtCommunitySqlProvider.class, method="pageByExample")
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
        @Result(column="cid", property="cid", jdbcType=JdbcType.BIGINT)
    })
    PageList<Community> pageByExample(@Param("example") CommunityExample example, PageBounds pageBounds);
    
    
    @SelectProvider(type=ExtCommunitySqlProvider.class, method="pageByCondition")
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
        @Result(column="cid", property="cid", jdbcType=JdbcType.BIGINT)
    })
    PageList<Community> pageByCondition(Map<String, Object> param, PageBounds pageBounds);

    
    @Select("select  a.id,a.name from community c,area a where c.city_id=a.id and c.status =1 group by c.city_id")
    List<Map<String,Object>> searchCityByCommuntiy();

    @Select("select  a.id,a.name from community c,area a , open_fee_order b where c.city_id=a.id and b.community_id=c.id and c.status =1 and b.service_id=#{serviceId} group by c.city_id")
	List<Map<String, Object>> searchCityByFee(int serviceId);

    @Select("select  c.id,c.name from community c, open_fee_order b where  b.community_id=c.id and c.status =1 and b.service_id=#{serviceId} and c.city_id= #{areaId} group by c.id")
    List<Map<String, Object>> getCommunityListByfee(Map<String, Object> param);
}
