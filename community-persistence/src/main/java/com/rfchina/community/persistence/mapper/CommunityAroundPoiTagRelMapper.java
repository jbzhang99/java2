package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityAroundPoiTagRelExample;
import com.rfchina.community.persistence.model.CommunityAroundPoiTagRelKey;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CommunityAroundPoiTagRelMapper extends BaseMapper {
    @SelectProvider(type=CommunityAroundPoiTagRelSqlProvider.class, method="countByExample")
    long countByExample(CommunityAroundPoiTagRelExample example);

    @DeleteProvider(type=CommunityAroundPoiTagRelSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityAroundPoiTagRelExample example);

    @Delete({
        "delete from community_around_poi_tag_rel",
        "where tag_id = #{tagId,jdbcType=BIGINT}",
          "and poi_id = #{poiId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(CommunityAroundPoiTagRelKey key);

    @Insert({
        "insert into community_around_poi_tag_rel (tag_id, poi_id)",
        "values (#{tagId,jdbcType=BIGINT}, #{poiId,jdbcType=BIGINT})"
    })
    int insert(CommunityAroundPoiTagRelKey record);

    @InsertProvider(type=CommunityAroundPoiTagRelSqlProvider.class, method="insertSelective")
    int insertSelective(CommunityAroundPoiTagRelKey record);

    @SelectProvider(type=CommunityAroundPoiTagRelSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="tag_id", property="tagId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="poi_id", property="poiId", jdbcType=JdbcType.BIGINT, id=true)
    })
    List<CommunityAroundPoiTagRelKey> selectByExample(CommunityAroundPoiTagRelExample example);

    @UpdateProvider(type=CommunityAroundPoiTagRelSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityAroundPoiTagRelKey record, @Param("example") CommunityAroundPoiTagRelExample example);

    @UpdateProvider(type=CommunityAroundPoiTagRelSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityAroundPoiTagRelKey record, @Param("example") CommunityAroundPoiTagRelExample example);
}