package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityAroundPoi;
import com.rfchina.community.persistence.model.CommunityAroundPoiExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CommunityAroundPoiMapper extends BaseMapper {
    @SelectProvider(type=CommunityAroundPoiSqlProvider.class, method="countByExample")
    long countByExample(CommunityAroundPoiExample example);

    @DeleteProvider(type=CommunityAroundPoiSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityAroundPoiExample example);

    @Delete({
        "delete from community_around_poi",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into community_around_poi (api_id, status, ",
        "api_type, type, pic_url, ",
        "name, address, longitude, ",
        "latitude, tel, post_code, ",
        "web_site, email, ",
        "province_code, province_name, ",
        "city_code, city_name, ",
        "ad_code, ad_name, ",
        "create_time, update_time, ",
        "sync_status)",
        "values (#{apiId,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{apiType,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, #{picUrl,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, #{longitude,jdbcType=VARCHAR}, ",
        "#{latitude,jdbcType=VARCHAR}, #{tel,jdbcType=VARCHAR}, #{postCode,jdbcType=VARCHAR}, ",
        "#{webSite,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{provinceCode,jdbcType=VARCHAR}, #{provinceName,jdbcType=VARCHAR}, ",
        "#{cityCode,jdbcType=VARCHAR}, #{cityName,jdbcType=VARCHAR}, ",
        "#{adCode,jdbcType=VARCHAR}, #{adName,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{syncStatus,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CommunityAroundPoi record);

    @InsertProvider(type=CommunityAroundPoiSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CommunityAroundPoi record);

    @SelectProvider(type=CommunityAroundPoiSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="api_id", property="apiId", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="api_type", property="apiType", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
        @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="post_code", property="postCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="web_site", property="webSite", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="province_code", property="provinceCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="province_name", property="provinceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="city_code", property="cityCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="city_name", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ad_code", property="adCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="ad_name", property="adName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sync_status", property="syncStatus", jdbcType=JdbcType.INTEGER)
    })
    List<CommunityAroundPoi> selectByExample(CommunityAroundPoiExample example);

    @Select({
        "select",
        "id, api_id, status, api_type, type, pic_url, name, address, longitude, latitude, ",
        "tel, post_code, web_site, email, province_code, province_name, city_code, city_name, ",
        "ad_code, ad_name, create_time, update_time, sync_status",
        "from community_around_poi",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="api_id", property="apiId", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="api_type", property="apiType", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
        @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="post_code", property="postCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="web_site", property="webSite", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="province_code", property="provinceCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="province_name", property="provinceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="city_code", property="cityCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="city_name", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ad_code", property="adCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="ad_name", property="adName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sync_status", property="syncStatus", jdbcType=JdbcType.INTEGER)
    })
    CommunityAroundPoi selectByPrimaryKey(Long id);

    @UpdateProvider(type=CommunityAroundPoiSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityAroundPoi record, @Param("example") CommunityAroundPoiExample example);

    @UpdateProvider(type=CommunityAroundPoiSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityAroundPoi record, @Param("example") CommunityAroundPoiExample example);

    @UpdateProvider(type=CommunityAroundPoiSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityAroundPoi record);

    @Update({
        "update community_around_poi",
        "set api_id = #{apiId,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "api_type = #{apiType,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "pic_url = #{picUrl,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "longitude = #{longitude,jdbcType=VARCHAR},",
          "latitude = #{latitude,jdbcType=VARCHAR},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "post_code = #{postCode,jdbcType=VARCHAR},",
          "web_site = #{webSite,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "province_code = #{provinceCode,jdbcType=VARCHAR},",
          "province_name = #{provinceName,jdbcType=VARCHAR},",
          "city_code = #{cityCode,jdbcType=VARCHAR},",
          "city_name = #{cityName,jdbcType=VARCHAR},",
          "ad_code = #{adCode,jdbcType=VARCHAR},",
          "ad_name = #{adName,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "sync_status = #{syncStatus,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommunityAroundPoi record);
}