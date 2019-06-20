package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.CommunityAroundPoiTagRelMapper;
import com.rfchina.community.persistence.mapper.CommunityAroundPoiTagRelSqlProvider;
import com.rfchina.community.persistence.model.CommunityAroundPoiTagRelExample;
import com.rfchina.community.persistence.model.CommunityAroundPoiTagRelKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * @ClassName ExtCommunityAroundPoiTagMapper
 * @Author wlrllr
 * @Date 2019/4/24 10:24
 * @Version 1.0
 **/
public interface ExtCommunityAroundPoiTagRelMapper extends CommunityAroundPoiTagRelMapper {
    @Delete({
            "delete from community_around_poi_tag_rel",
            "where  poi_id = #{poiId,jdbcType=BIGINT}"
    })
    int deleteByPoiId(@Param("poiId") Long poiId);

    @Select({
            "select count(*) from community_around_poi_tag_rel ",
            " where tag_id = #{tagId,jdbcType=BIGINT}",
            " and poi_id = #{poiId,jdbcType=BIGINT}"
    })
    long countByPrimaryKey(CommunityAroundPoiTagRelKey tagRelKey);
}
