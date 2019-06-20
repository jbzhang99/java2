package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VisitCommunity;
import com.rfchina.community.persistence.model.VisitCommunityExample;
import java.io.Serializable;
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

public interface VisitCommunityMapper extends Serializable {
    @SelectProvider(type=VisitCommunitySqlProvider.class, method="countByExample")
    long countByExample(VisitCommunityExample example);

    @DeleteProvider(type=VisitCommunitySqlProvider.class, method="deleteByExample")
    int deleteByExample(VisitCommunityExample example);

    @Delete({
        "delete from visit_community",
        "where community_id = #{communityId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer communityId);

    @Insert({
        "insert into visit_community (community_id, follow_max, ",
        "follow_must, open_time, ",
        "closing_time, is_entrance_guard, ",
        "entrance_guard_type)",
        "values (#{communityId,jdbcType=INTEGER}, #{followMax,jdbcType=INTEGER}, ",
        "#{followMust,jdbcType=TINYINT}, #{openTime,jdbcType=VARCHAR}, ",
        "#{closingTime,jdbcType=VARCHAR}, #{isEntranceGuard,jdbcType=INTEGER}, ",
        "#{entranceGuardType,jdbcType=INTEGER})"
    })
    int insert(VisitCommunity record);

    @InsertProvider(type=VisitCommunitySqlProvider.class, method="insertSelective")
    int insertSelective(VisitCommunity record);

    @SelectProvider(type=VisitCommunitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="follow_max", property="followMax", jdbcType=JdbcType.INTEGER),
        @Result(column="follow_must", property="followMust", jdbcType=JdbcType.TINYINT),
        @Result(column="open_time", property="openTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="closing_time", property="closingTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_entrance_guard", property="isEntranceGuard", jdbcType=JdbcType.INTEGER),
        @Result(column="entrance_guard_type", property="entranceGuardType", jdbcType=JdbcType.INTEGER)
    })
    List<VisitCommunity> selectByExample(VisitCommunityExample example);

    @Select({
        "select",
        "community_id, follow_max, follow_must, open_time, closing_time, is_entrance_guard, ",
        "entrance_guard_type",
        "from visit_community",
        "where community_id = #{communityId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="follow_max", property="followMax", jdbcType=JdbcType.INTEGER),
        @Result(column="follow_must", property="followMust", jdbcType=JdbcType.TINYINT),
        @Result(column="open_time", property="openTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="closing_time", property="closingTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_entrance_guard", property="isEntranceGuard", jdbcType=JdbcType.INTEGER),
        @Result(column="entrance_guard_type", property="entranceGuardType", jdbcType=JdbcType.INTEGER)
    })
    VisitCommunity selectByPrimaryKey(Integer communityId);

    @UpdateProvider(type=VisitCommunitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VisitCommunity record, @Param("example") VisitCommunityExample example);

    @UpdateProvider(type=VisitCommunitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VisitCommunity record, @Param("example") VisitCommunityExample example);

    @UpdateProvider(type=VisitCommunitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VisitCommunity record);

    @Update({
        "update visit_community",
        "set follow_max = #{followMax,jdbcType=INTEGER},",
          "follow_must = #{followMust,jdbcType=TINYINT},",
          "open_time = #{openTime,jdbcType=VARCHAR},",
          "closing_time = #{closingTime,jdbcType=VARCHAR},",
          "is_entrance_guard = #{isEntranceGuard,jdbcType=INTEGER},",
          "entrance_guard_type = #{entranceGuardType,jdbcType=INTEGER}",
        "where community_id = #{communityId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(VisitCommunity record);
}