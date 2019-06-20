package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityAround;
import com.rfchina.community.persistence.model.CommunityAroundExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CommunityAroundMapper extends BaseMapper {
    @SelectProvider(type=CommunityAroundSqlProvider.class, method="countByExample")
    long countByExample(CommunityAroundExample example);

    @DeleteProvider(type=CommunityAroundSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityAroundExample example);

    @Delete({
        "delete from community_around",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into community_around (id, city, ",
        "city_name, status, ",
        "name, longitude, ",
        "latitude, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=BIGINT}, #{city,jdbcType=BIGINT}, ",
        "#{cityName,jdbcType=VARCHAR}, #{status,jdbcType=BIGINT}, ",
        "#{name,jdbcType=VARCHAR}, #{longitude,jdbcType=VARCHAR}, ",
        "#{latitude,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(CommunityAround record);

    @InsertProvider(type=CommunityAroundSqlProvider.class, method="insertSelective")
    int insertSelective(CommunityAround record);

    @SelectProvider(type=CommunityAroundSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="city", property="city", jdbcType=JdbcType.BIGINT),
        @Result(column="city_name", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
        @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CommunityAround> selectByExample(CommunityAroundExample example);

    @Select({
        "select",
        "id, city, city_name, status, name, longitude, latitude, create_time, update_time",
        "from community_around",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="city", property="city", jdbcType=JdbcType.BIGINT),
        @Result(column="city_name", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
        @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CommunityAround selectByPrimaryKey(Long id);

    @UpdateProvider(type=CommunityAroundSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityAround record, @Param("example") CommunityAroundExample example);

    @UpdateProvider(type=CommunityAroundSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityAround record, @Param("example") CommunityAroundExample example);

    @UpdateProvider(type=CommunityAroundSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityAround record);

    @Update({
        "update community_around",
        "set city = #{city,jdbcType=BIGINT},",
          "city_name = #{cityName,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=BIGINT},",
          "name = #{name,jdbcType=VARCHAR},",
          "longitude = #{longitude,jdbcType=VARCHAR},",
          "latitude = #{latitude,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommunityAround record);
}