package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityAroundUpdatePlan;
import com.rfchina.community.persistence.model.CommunityAroundUpdatePlanExample;
import com.rfchina.community.persistence.model.CommunityAroundUpdatePlanKey;
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

public interface CommunityAroundUpdatePlanMapper extends BaseMapper {
    @SelectProvider(type=CommunityAroundUpdatePlanSqlProvider.class, method="countByExample")
    long countByExample(CommunityAroundUpdatePlanExample example);

    @DeleteProvider(type=CommunityAroundUpdatePlanSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityAroundUpdatePlanExample example);

    @Delete({
        "delete from community_around_update_plan",
        "where community_id = #{communityId,jdbcType=BIGINT}",
          "and type_id = #{typeId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(CommunityAroundUpdatePlanKey key);

    @Insert({
        "insert into community_around_update_plan (community_id, type_id, ",
        "status, type_code, ",
        "parent_type_code)",
        "values (#{communityId,jdbcType=BIGINT}, #{typeId,jdbcType=BIGINT}, ",
        "#{status,jdbcType=INTEGER}, #{typeCode,jdbcType=VARCHAR}, ",
        "#{parentTypeCode,jdbcType=VARCHAR})"
    })
    int insert(CommunityAroundUpdatePlan record);

    @InsertProvider(type=CommunityAroundUpdatePlanSqlProvider.class, method="insertSelective")
    int insertSelective(CommunityAroundUpdatePlan record);

    @SelectProvider(type=CommunityAroundUpdatePlanSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="type_code", property="typeCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_type_code", property="parentTypeCode", jdbcType=JdbcType.VARCHAR)
    })
    List<CommunityAroundUpdatePlan> selectByExample(CommunityAroundUpdatePlanExample example);

    @Select({
        "select",
        "community_id, type_id, status, type_code, parent_type_code",
        "from community_around_update_plan",
        "where community_id = #{communityId,jdbcType=BIGINT}",
          "and type_id = #{typeId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="type_code", property="typeCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_type_code", property="parentTypeCode", jdbcType=JdbcType.VARCHAR)
    })
    CommunityAroundUpdatePlan selectByPrimaryKey(CommunityAroundUpdatePlanKey key);

    @UpdateProvider(type=CommunityAroundUpdatePlanSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityAroundUpdatePlan record, @Param("example") CommunityAroundUpdatePlanExample example);

    @UpdateProvider(type=CommunityAroundUpdatePlanSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityAroundUpdatePlan record, @Param("example") CommunityAroundUpdatePlanExample example);

    @UpdateProvider(type=CommunityAroundUpdatePlanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityAroundUpdatePlan record);

    @Update({
        "update community_around_update_plan",
        "set status = #{status,jdbcType=INTEGER},",
          "type_code = #{typeCode,jdbcType=VARCHAR},",
          "parent_type_code = #{parentTypeCode,jdbcType=VARCHAR}",
        "where community_id = #{communityId,jdbcType=BIGINT}",
          "and type_id = #{typeId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommunityAroundUpdatePlan record);
}