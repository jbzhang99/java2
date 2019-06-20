package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityAroundPoiRel;
import com.rfchina.community.persistence.model.CommunityAroundPoiRelExample;
import com.rfchina.community.persistence.model.CommunityAroundPoiRelKey;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CommunityAroundPoiRelMapper extends BaseMapper {
    @SelectProvider(type=CommunityAroundPoiRelSqlProvider.class, method="countByExample")
    long countByExample(CommunityAroundPoiRelExample example);

    @DeleteProvider(type=CommunityAroundPoiRelSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityAroundPoiRelExample example);

    @Delete({
        "delete from community_around_poi_rel",
        "where community_id = #{communityId,jdbcType=BIGINT}",
          "and poi_id = #{poiId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(CommunityAroundPoiRelKey key);

    @Insert({
        "insert into community_around_poi_rel (community_id, poi_id, ",
        "distance, status)",
        "values (#{communityId,jdbcType=BIGINT}, #{poiId,jdbcType=BIGINT}, ",
        "#{distance,jdbcType=DOUBLE}, #{status,jdbcType=INTEGER})"
    })
    int insert(CommunityAroundPoiRel record);

    @InsertProvider(type=CommunityAroundPoiRelSqlProvider.class, method="insertSelective")
    int insertSelective(CommunityAroundPoiRel record);

    @SelectProvider(type=CommunityAroundPoiRelSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="poi_id", property="poiId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="distance", property="distance", jdbcType=JdbcType.DOUBLE),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<CommunityAroundPoiRel> selectByExample(CommunityAroundPoiRelExample example);

    @Select({
        "select",
        "community_id, poi_id, distance, status",
        "from community_around_poi_rel",
        "where community_id = #{communityId,jdbcType=BIGINT}",
          "and poi_id = #{poiId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="poi_id", property="poiId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="distance", property="distance", jdbcType=JdbcType.DOUBLE),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    CommunityAroundPoiRel selectByPrimaryKey(CommunityAroundPoiRelKey key);

    @UpdateProvider(type=CommunityAroundPoiRelSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityAroundPoiRel record, @Param("example") CommunityAroundPoiRelExample example);

    @UpdateProvider(type=CommunityAroundPoiRelSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityAroundPoiRel record, @Param("example") CommunityAroundPoiRelExample example);

    @UpdateProvider(type=CommunityAroundPoiRelSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityAroundPoiRel record);

    @Update({
        "update community_around_poi_rel",
        "set distance = #{distance,jdbcType=DOUBLE},",
          "status = #{status,jdbcType=INTEGER}",
        "where community_id = #{communityId,jdbcType=BIGINT}",
          "and poi_id = #{poiId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommunityAroundPoiRel record);
}