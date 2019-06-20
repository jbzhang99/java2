package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.CommunityAroundPoiRelMapper;
import com.rfchina.community.persistence.model.CommunityAroundPoiRel;
import com.rfchina.community.persistence.model.ext.ExtCommunityAroundPoiRel;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.util.List;

public interface ExtCommunityAroundPoiRelMapper extends CommunityAroundPoiRelMapper {

    @InsertProvider(type = ExtCommunityAroundPoiRelSqlProvider.class, method = "batchInsert")
    int batchInsert(List<CommunityAroundPoiRel> list);


    @Select({
            "select _rel.*,_around.longitude,_around.latitude,_poi.longitude poi_longitude ,_poi.latitude poi_latitude",
            "from community_around_poi_rel _rel ,",
            "community_around _around,community_around_poi _poi",
            "where _around.id=_rel.community_id and _poi.id=_rel.poi_id and  _rel.status=-1"
    })
    @Results({
            @Result(column = "community_id", property = "communityId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "poi_id", property = "poiId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "distance", property = "distance", jdbcType = JdbcType.DOUBLE),
            @Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
            @Result(column = "longitude", property = "longitude", jdbcType = JdbcType.VARCHAR),
            @Result(column = "latitude", property = "latitude", jdbcType = JdbcType.VARCHAR),
            @Result(column = "poi_longitude", property = "poiLongitude", jdbcType = JdbcType.VARCHAR),
            @Result(column = "poi_latitude", property = "poiLatitude", jdbcType = JdbcType.VARCHAR)
    })
    PageList<ExtCommunityAroundPoiRel> pageOldRel(PageBounds pageBounds);
}