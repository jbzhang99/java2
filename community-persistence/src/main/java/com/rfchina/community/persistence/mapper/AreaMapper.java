package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.Area;
import com.rfchina.community.persistence.model.AreaExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface AreaMapper extends BaseMapper {
    @SelectProvider(type=AreaSqlProvider.class, method="countByExample")
    long countByExample(AreaExample example);

    @DeleteProvider(type=AreaSqlProvider.class, method="deleteByExample")
    int deleteByExample(AreaExample example);

    @Delete({
        "delete from area",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into area (id, name, ",
        "parent_id, short_name, ",
        "level_type, city_code, ",
        "zipcode, merger_name, ",
        "lng, lat, pinyin)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{parentId,jdbcType=INTEGER}, #{shortName,jdbcType=VARCHAR}, ",
        "#{levelType,jdbcType=TINYINT}, #{cityCode,jdbcType=VARCHAR}, ",
        "#{zipcode,jdbcType=VARCHAR}, #{mergerName,jdbcType=VARCHAR}, ",
        "#{lng,jdbcType=DOUBLE}, #{lat,jdbcType=DOUBLE}, #{pinyin,jdbcType=VARCHAR})"
    })
    int insert(Area record);

    @InsertProvider(type=AreaSqlProvider.class, method="insertSelective")
    int insertSelective(Area record);

    @SelectProvider(type=AreaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="short_name", property="shortName", jdbcType=JdbcType.VARCHAR),
        @Result(column="level_type", property="levelType", jdbcType=JdbcType.TINYINT),
        @Result(column="city_code", property="cityCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="zipcode", property="zipcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="merger_name", property="mergerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="lng", property="lng", jdbcType=JdbcType.DOUBLE),
        @Result(column="lat", property="lat", jdbcType=JdbcType.DOUBLE),
        @Result(column="pinyin", property="pinyin", jdbcType=JdbcType.VARCHAR)
    })
    List<Area> selectByExample(AreaExample example);

    @Select({
        "select",
        "id, name, parent_id, short_name, level_type, city_code, zipcode, merger_name, ",
        "lng, lat, pinyin",
        "from area",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="short_name", property="shortName", jdbcType=JdbcType.VARCHAR),
        @Result(column="level_type", property="levelType", jdbcType=JdbcType.TINYINT),
        @Result(column="city_code", property="cityCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="zipcode", property="zipcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="merger_name", property="mergerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="lng", property="lng", jdbcType=JdbcType.DOUBLE),
        @Result(column="lat", property="lat", jdbcType=JdbcType.DOUBLE),
        @Result(column="pinyin", property="pinyin", jdbcType=JdbcType.VARCHAR)
    })
    Area selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AreaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Area record, @Param("example") AreaExample example);

    @UpdateProvider(type=AreaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Area record, @Param("example") AreaExample example);

    @UpdateProvider(type=AreaSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Area record);

    @Update({
        "update area",
        "set name = #{name,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=INTEGER},",
          "short_name = #{shortName,jdbcType=VARCHAR},",
          "level_type = #{levelType,jdbcType=TINYINT},",
          "city_code = #{cityCode,jdbcType=VARCHAR},",
          "zipcode = #{zipcode,jdbcType=VARCHAR},",
          "merger_name = #{mergerName,jdbcType=VARCHAR},",
          "lng = #{lng,jdbcType=DOUBLE},",
          "lat = #{lat,jdbcType=DOUBLE},",
          "pinyin = #{pinyin,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Area record);
}