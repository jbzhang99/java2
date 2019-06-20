package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.CommunityAroundPoiTypeMapper;
import com.rfchina.community.persistence.model.ext.ExtCommunityAroundPoiType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ExtCommunityAroundPoiTypeMapper
 * @Author wlrllr
 * @Date 2019/4/24 10:24
 * @Version 1.0
 **/
public interface ExtCommunityAroundPoiTypeMapper extends CommunityAroundPoiTypeMapper {

    @SelectProvider(type = ExtCommunityAroundPoiTypeSqlProvider.class, method = "page")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="parent_type", property="parentType", jdbcType=JdbcType.VARCHAR),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
            @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
            @Result(column="parent_name", property="parentName", jdbcType=JdbcType.VARCHAR),
            @Result(column="poiType", property="poiType", jdbcType=JdbcType.VARCHAR),
            @Result(column="parentSort", property="parentSort", jdbcType=JdbcType.INTEGER),
            @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
            @Result(column="poi_pic_url", property="poiPicUrl", jdbcType=JdbcType.VARCHAR)

    })
    PageList<ExtCommunityAroundPoiType> page(Map<String,Object> map, PageBounds pageBounds);

    @Select({"select parent_type parentType,parent_name parentName,CONCAT('[',GROUP_CONCAT(CONCAT('{\"id\":\"',type,'\",\"name\":\"',`name`,'\"}')),']') childTypes ",
            "from community_around_poi_type where `level` =2 GROUP BY parent_type"})
    List<Map> groupType();
}
