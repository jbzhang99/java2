package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.CommunityAroundPoiDataMapper;
import com.rfchina.community.persistence.model.CommunityAroundPoiData;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ExtCommunityAroundPoiDataMapper extends CommunityAroundPoiDataMapper {

    @Select({
            "select",
            "id, community_id, type_id, status, data",
            "from community_around_poi_data",
            "where status = -1 limit #{start},#{end}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.BIGINT),
            @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
            @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
            @Result(column="data", property="data", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<CommunityAroundPoiData> page(@Param("start") Integer start, @Param("end") Integer end);


    @InsertProvider(type = ExtCommunityAroundPoiDataSqlProvider.class,method = "batchInsert")
    int batchInsert(List<CommunityAroundPoiData> list);
}