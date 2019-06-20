package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.CommunityAroundPoiTagMapper;
import com.rfchina.community.persistence.model.CommunityAroundPoiTag;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * @ClassName ExtCommunityAroundPoiTagMapper
 * @Description TODO
 * @Author wlrllr
 * @Date 2019/4/24 10:24
 * @Version 1.0
 **/
public interface ExtCommunityAroundPoiTagMapper extends CommunityAroundPoiTagMapper {

    @Select({
            "select",
            "_t.name, _t.sort",
            "from community_around_poi_tag _t inner join community_around_poi_tag_rel _tr on _tr.tag_id = _t.id ",
            "where status=1 and _tr.poi_id = #{poiId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER)
    })
    List<CommunityAroundPoiTag> getTagByPoiId(Long poiId);
}
