package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityResourceActivityRela;
import com.rfchina.community.persistence.model.CommunityResourceActivityRelaExample;
import com.rfchina.community.persistence.model.CommunityResourceActivityRelaKey;
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

public interface CommunityResourceActivityRelaMapper extends Serializable {
    @SelectProvider(type=CommunityResourceActivityRelaSqlProvider.class, method="countByExample")
    long countByExample(CommunityResourceActivityRelaExample example);

    @DeleteProvider(type=CommunityResourceActivityRelaSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityResourceActivityRelaExample example);

    @Delete({
        "delete from community_resource_activity_rela",
        "where community_id = #{communityId,jdbcType=INTEGER}",
          "and community_resource_id = #{communityResourceId,jdbcType=INTEGER}",
          "and activity_id = #{activityId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(CommunityResourceActivityRelaKey key);

    @Insert({
        "insert into community_resource_activity_rela (community_id, community_resource_id, ",
        "activity_id, city_id, ",
        "create_time, creater_id)",
        "values (#{communityId,jdbcType=INTEGER}, #{communityResourceId,jdbcType=INTEGER}, ",
        "#{activityId,jdbcType=BIGINT}, #{cityId,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{createrId,jdbcType=INTEGER})"
    })
    int insert(CommunityResourceActivityRela record);

    @InsertProvider(type=CommunityResourceActivityRelaSqlProvider.class, method="insertSelective")
    int insertSelective(CommunityResourceActivityRela record);

    @SelectProvider(type=CommunityResourceActivityRelaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="community_resource_id", property="communityResourceId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="activity_id", property="activityId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="city_id", property="cityId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creater_id", property="createrId", jdbcType=JdbcType.INTEGER)
    })
    List<CommunityResourceActivityRela> selectByExample(CommunityResourceActivityRelaExample example);

    @Select({
        "select",
        "community_id, community_resource_id, activity_id, city_id, create_time, creater_id",
        "from community_resource_activity_rela",
        "where community_id = #{communityId,jdbcType=INTEGER}",
          "and community_resource_id = #{communityResourceId,jdbcType=INTEGER}",
          "and activity_id = #{activityId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="community_resource_id", property="communityResourceId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="activity_id", property="activityId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="city_id", property="cityId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creater_id", property="createrId", jdbcType=JdbcType.INTEGER)
    })
    CommunityResourceActivityRela selectByPrimaryKey(CommunityResourceActivityRelaKey key);

    @UpdateProvider(type=CommunityResourceActivityRelaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityResourceActivityRela record, @Param("example") CommunityResourceActivityRelaExample example);

    @UpdateProvider(type=CommunityResourceActivityRelaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityResourceActivityRela record, @Param("example") CommunityResourceActivityRelaExample example);

    @UpdateProvider(type=CommunityResourceActivityRelaSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityResourceActivityRela record);

    @Update({
        "update community_resource_activity_rela",
        "set city_id = #{cityId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "creater_id = #{createrId,jdbcType=INTEGER}",
        "where community_id = #{communityId,jdbcType=INTEGER}",
          "and community_resource_id = #{communityResourceId,jdbcType=INTEGER}",
          "and activity_id = #{activityId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommunityResourceActivityRela record);
}