package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.CommunityAroundUpdatePlanMapper;
import com.rfchina.community.persistence.model.CommunityAroundUpdatePlan;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.util.Map;

public interface ExtCommunityAroundUpdatePlanMapper extends CommunityAroundUpdatePlanMapper {


    @SelectProvider(type=ExtCommunityAroundUpdatePlanSqlProvider.class, method="pageByExample")
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="type_code", property="typeCode", jdbcType=JdbcType.VARCHAR)
    })
    PageList<CommunityAroundUpdatePlan> pageByExample(Map map, PageBounds pageBounds);

    @Delete({
            "DELETE FROM community_around_update_plan where community_id in (select _ca.id from community_around _ca where _ca.status=-1)"
    })
    int delOldPlan();

    @Insert({
            "insert into community_around_update_plan(community_id,type_id,status,type_code,parent_type_code) " ,
            "select _ca.id,_capt.id type_id,-1,_capt.type,_capt.parent_type ",
             "from community_around _ca,community_around_poi_type _capt where _ca.status=-1 and _capt.level=3"
    })
    int addUpdatePlan();
}