package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.AreaMapper;
import com.rfchina.community.persistence.model.Area;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ExtAreaMapper extends AreaMapper {

    @Select({"select a.id,a.name,a.short_name,a.city_code,a.lat,a.lng,a.pinyin from area a INNER JOIN community community ",
            "ON community.city_id = a.id where community.`status`=1 and community.category=1 GROUP BY a.id ORDER BY pinyin"})
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
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
    List<Area> getCityHasCommunity();
}