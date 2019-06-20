package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.CommunityMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

public interface ExtBaseCommunityMapper extends CommunityMapper {

    @Select({"select id,name,longitude,latitude from community where `status`=1 and category=1 and city_id = #{cityId}"})
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR)
    })
    List<Map> getCommunityByCityId(Integer cityId);

    @Select({
            "<script>",
            "select GROUP_CONCAT(c.name) name,a.id areaId,a.`name` cityName from community c,area a",
            " where c.city_id = a.id and c.id in ",
            "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>",
            "#{item}",
            "</foreach>",
            " GROUP BY a.id",
            "</script>"
    })
    List<Map<String,String>> getCommunityAreaByCommunityIds(@Param(value="ids") List<Integer> record);
}