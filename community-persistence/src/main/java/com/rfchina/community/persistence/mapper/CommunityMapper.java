package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.Community;
import com.rfchina.community.persistence.model.CommunityExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

public interface CommunityMapper extends BaseMapper<Community,CommunityExample,Integer> {
    @SelectProvider(type=CommunitySqlProvider.class, method="countByExample")
    long countByExample(CommunityExample example);

    @DeleteProvider(type=CommunitySqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityExample example);

    @Delete({
        "delete from community",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into community (name, phone, ",
        "tel, city_id, city_name, ",
        "area_id, address, ",
        "intro, status, project_guid, ",
        "category, sort, ",
        "sync_flag, qrcode_url, ",
        "longitude, latitude, ",
        "admin_id, type, building_area, ",
        "practical_area, type_desc, ",
        "logo_url, background_url, ",
        "topic_audit, create_time, ",
        "cid, weixin, property_company, ",
        "business_person, business_phone, ",
        "business_email, pinyin, ",
        "update_time)",
        "values (#{name,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, ",
        "#{tel,jdbcType=VARCHAR}, #{cityId,jdbcType=INTEGER}, #{cityName,jdbcType=VARCHAR}, ",
        "#{areaId,jdbcType=INTEGER}, #{address,jdbcType=VARCHAR}, ",
        "#{intro,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, #{projectGuid,jdbcType=VARCHAR}, ",
        "#{category,jdbcType=INTEGER}, #{sort,jdbcType=INTEGER}, ",
        "#{syncFlag,jdbcType=TINYINT}, #{qrcodeUrl,jdbcType=VARCHAR}, ",
        "#{longitude,jdbcType=VARCHAR}, #{latitude,jdbcType=VARCHAR}, ",
        "#{adminId,jdbcType=BIGINT}, #{type,jdbcType=INTEGER}, #{buildingArea,jdbcType=VARCHAR}, ",
        "#{practicalArea,jdbcType=VARCHAR}, #{typeDesc,jdbcType=VARCHAR}, ",
        "#{logoUrl,jdbcType=VARCHAR}, #{backgroundUrl,jdbcType=VARCHAR}, ",
        "#{topicAudit,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{cid,jdbcType=BIGINT}, #{weixin,jdbcType=VARCHAR}, #{propertyCompany,jdbcType=VARCHAR}, ",
        "#{businessPerson,jdbcType=VARCHAR}, #{businessPhone,jdbcType=VARCHAR}, ",
        "#{businessEmail,jdbcType=VARCHAR}, #{pinyin,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Community record);

    @InsertProvider(type=CommunitySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Community record);

    @SelectProvider(type=CommunitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="city_id", property="cityId", jdbcType=JdbcType.INTEGER),
        @Result(column="city_name", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="project_guid", property="projectGuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="category", property="category", jdbcType=JdbcType.INTEGER),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="sync_flag", property="syncFlag", jdbcType=JdbcType.TINYINT),
        @Result(column="qrcode_url", property="qrcodeUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
        @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
        @Result(column="admin_id", property="adminId", jdbcType=JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="building_area", property="buildingArea", jdbcType=JdbcType.VARCHAR),
        @Result(column="practical_area", property="practicalArea", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_desc", property="typeDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="logo_url", property="logoUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="background_url", property="backgroundUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="topic_audit", property="topicAudit", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="cid", property="cid", jdbcType=JdbcType.BIGINT),
        @Result(column="weixin", property="weixin", jdbcType=JdbcType.VARCHAR),
        @Result(column="property_company", property="propertyCompany", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_person", property="businessPerson", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_phone", property="businessPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_email", property="businessEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="pinyin", property="pinyin", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Community> selectByExample(CommunityExample example);

    @Select({
        "select",
        "id, name, phone, tel, city_id, city_name, area_id, address, intro, status, project_guid, ",
        "category, sort, sync_flag, qrcode_url, longitude, latitude, admin_id, type, ",
        "building_area, practical_area, type_desc, logo_url, background_url, topic_audit, ",
        "create_time, cid, weixin, property_company, business_person, business_phone, ",
        "business_email, pinyin, update_time",
        "from community",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="city_id", property="cityId", jdbcType=JdbcType.INTEGER),
        @Result(column="city_name", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="project_guid", property="projectGuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="category", property="category", jdbcType=JdbcType.INTEGER),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="sync_flag", property="syncFlag", jdbcType=JdbcType.TINYINT),
        @Result(column="qrcode_url", property="qrcodeUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
        @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
        @Result(column="admin_id", property="adminId", jdbcType=JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="building_area", property="buildingArea", jdbcType=JdbcType.VARCHAR),
        @Result(column="practical_area", property="practicalArea", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_desc", property="typeDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="logo_url", property="logoUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="background_url", property="backgroundUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="topic_audit", property="topicAudit", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="cid", property="cid", jdbcType=JdbcType.BIGINT),
        @Result(column="weixin", property="weixin", jdbcType=JdbcType.VARCHAR),
        @Result(column="property_company", property="propertyCompany", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_person", property="businessPerson", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_phone", property="businessPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_email", property="businessEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="pinyin", property="pinyin", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Community selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CommunitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Community record, @Param("example") CommunityExample example);

    @UpdateProvider(type=CommunitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Community record, @Param("example") CommunityExample example);

    @UpdateProvider(type=CommunitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Community record);

    @Update({
        "update community",
        "set name = #{name,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "city_id = #{cityId,jdbcType=INTEGER},",
          "city_name = #{cityName,jdbcType=VARCHAR},",
          "area_id = #{areaId,jdbcType=INTEGER},",
          "address = #{address,jdbcType=VARCHAR},",
          "intro = #{intro,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "project_guid = #{projectGuid,jdbcType=VARCHAR},",
          "category = #{category,jdbcType=INTEGER},",
          "sort = #{sort,jdbcType=INTEGER},",
          "sync_flag = #{syncFlag,jdbcType=TINYINT},",
          "qrcode_url = #{qrcodeUrl,jdbcType=VARCHAR},",
          "longitude = #{longitude,jdbcType=VARCHAR},",
          "latitude = #{latitude,jdbcType=VARCHAR},",
          "admin_id = #{adminId,jdbcType=BIGINT},",
          "type = #{type,jdbcType=INTEGER},",
          "building_area = #{buildingArea,jdbcType=VARCHAR},",
          "practical_area = #{practicalArea,jdbcType=VARCHAR},",
          "type_desc = #{typeDesc,jdbcType=VARCHAR},",
          "logo_url = #{logoUrl,jdbcType=VARCHAR},",
          "background_url = #{backgroundUrl,jdbcType=VARCHAR},",
          "topic_audit = #{topicAudit,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "cid = #{cid,jdbcType=BIGINT},",
          "weixin = #{weixin,jdbcType=VARCHAR},",
          "property_company = #{propertyCompany,jdbcType=VARCHAR},",
          "business_person = #{businessPerson,jdbcType=VARCHAR},",
          "business_phone = #{businessPhone,jdbcType=VARCHAR},",
          "business_email = #{businessEmail,jdbcType=VARCHAR},",
          "pinyin = #{pinyin,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Community record);
}