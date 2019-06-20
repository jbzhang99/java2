package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.CommunityAroundMapper;
import com.rfchina.community.persistence.model.CommunityAround;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ExtCommunityAroundPoiTagMapper
 * @Author wlrllr
 * @Date 2019/4/24 10:24
 * @Version 1.0
 **/
public interface ExtCommunityAroundMapper extends CommunityAroundMapper {

    @Select({
            "select",
            "id, city_name, status, name, longitude, latitude, create_time, update_time",
            " from community_around where status=1"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "city_name", property = "cityName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.BIGINT),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "longitude", property = "longitude", jdbcType = JdbcType.VARCHAR),
            @Result(column = "latitude", property = "latitude", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    List<CommunityAround> getAllCommunity();

    @SelectProvider(type = ExtCommunityAroundSqlProvider.class, method = "page")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "city_name", property = "cityName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.BIGINT),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "longitude", property = "longitude", jdbcType = JdbcType.VARCHAR),
            @Result(column = "latitude", property = "latitude", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    PageList<CommunityAround> page(Map<String, Object> param, PageBounds pageBounds);

    @Select({
            "select _c.id,_c.city_id,_c.city_name,_c.name,_c.longitude,_c.latitude",
            " from community _c where _c.category = 1 and _c.id not in (select _c.id from community_around _ca) ",
            "    UNION",
            "select _c.id,_c.city_id,_c.city_name,_c.name,_c.longitude,_c.latitude",
            " from community _c INNER JOIN community_around _ca ON _c.id = _ca.id WHERE _c.longitude<>_ca.longitude or _c.latitude<>_ca.latitude"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "city_name", property = "cityName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "city_id", property = "city", jdbcType = JdbcType.BIGINT),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "longitude", property = "longitude", jdbcType = JdbcType.VARCHAR),
            @Result(column = "latitude", property = "latitude", jdbcType = JdbcType.VARCHAR)
    })
    List<CommunityAround> getUnSyncCommunity();

    @Insert({
            "insert into community_around(id,city,city_name,status,name,longitude,latitude,create_time) ",
            " select _c.id,_c.city_id,_c.city_name,-1,_c.name,_c.longitude,_c.latitude,NOW() ",
            "from community _c where _c.id not in (select _ca.id from community_around _ca) and _c.category=1"
    })
    int addNewCommunityAround();

    @Update({
            "update community_around _ca,community _c  SET _ca.longitude = _c.longitude,_ca.latitude = _c.latitude ,",
            " _ca.status=-1,_ca.update_time=NOW() ",
            " where _c.id = _ca.id AND (_c.longitude<>_ca.longitude or _c.latitude<>_ca.latitude)"
    })
    int updateCommunityAroundLocation();

    @Update({
            "update community_around _ca,community_around_poi_rel _rel  SET _rel.status=-1 where _ca.id = _rel.community_id AND _ca.status=-1"
    })
    int markCommunityAroundPoiRel();
}
