package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.ResourcePatrolResult;
import com.rfchina.community.persistence.model.ResourcePatrolResultExample;
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

public interface ResourcePatrolResultMapper extends Serializable {
    @SelectProvider(type=ResourcePatrolResultSqlProvider.class, method="countByExample")
    long countByExample(ResourcePatrolResultExample example);

    @DeleteProvider(type=ResourcePatrolResultSqlProvider.class, method="deleteByExample")
    int deleteByExample(ResourcePatrolResultExample example);

    @Delete({
        "delete from resource_patrol_result",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into resource_patrol_result (id, patrol_id, ",
        "patrol_type, patrol_result, ",
        "patrol_img, patrol_detail)",
        "values (#{id,jdbcType=BIGINT}, #{patrolId,jdbcType=BIGINT}, ",
        "#{patrolType,jdbcType=INTEGER}, #{patrolResult,jdbcType=VARCHAR}, ",
        "#{patrolImg,jdbcType=VARCHAR}, #{patrolDetail,jdbcType=VARCHAR})"
    })
    int insert(ResourcePatrolResult record);

    @InsertProvider(type=ResourcePatrolResultSqlProvider.class, method="insertSelective")
    int insertSelective(ResourcePatrolResult record);

    @SelectProvider(type=ResourcePatrolResultSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="patrol_id", property="patrolId", jdbcType=JdbcType.BIGINT),
        @Result(column="patrol_type", property="patrolType", jdbcType=JdbcType.INTEGER),
        @Result(column="patrol_result", property="patrolResult", jdbcType=JdbcType.VARCHAR),
        @Result(column="patrol_img", property="patrolImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="patrol_detail", property="patrolDetail", jdbcType=JdbcType.VARCHAR)
    })
    List<ResourcePatrolResult> selectByExample(ResourcePatrolResultExample example);

    @Select({
        "select",
        "id, patrol_id, patrol_type, patrol_result, patrol_img, patrol_detail",
        "from resource_patrol_result",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="patrol_id", property="patrolId", jdbcType=JdbcType.BIGINT),
        @Result(column="patrol_type", property="patrolType", jdbcType=JdbcType.INTEGER),
        @Result(column="patrol_result", property="patrolResult", jdbcType=JdbcType.VARCHAR),
        @Result(column="patrol_img", property="patrolImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="patrol_detail", property="patrolDetail", jdbcType=JdbcType.VARCHAR)
    })
    ResourcePatrolResult selectByPrimaryKey(Long id);

    @UpdateProvider(type=ResourcePatrolResultSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ResourcePatrolResult record, @Param("example") ResourcePatrolResultExample example);

    @UpdateProvider(type=ResourcePatrolResultSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ResourcePatrolResult record, @Param("example") ResourcePatrolResultExample example);

    @UpdateProvider(type=ResourcePatrolResultSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ResourcePatrolResult record);

    @Update({
        "update resource_patrol_result",
        "set patrol_id = #{patrolId,jdbcType=BIGINT},",
          "patrol_type = #{patrolType,jdbcType=INTEGER},",
          "patrol_result = #{patrolResult,jdbcType=VARCHAR},",
          "patrol_img = #{patrolImg,jdbcType=VARCHAR},",
          "patrol_detail = #{patrolDetail,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ResourcePatrolResult record);
}