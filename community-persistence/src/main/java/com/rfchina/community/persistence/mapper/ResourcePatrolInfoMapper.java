package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.ResourcePatrolInfo;
import com.rfchina.community.persistence.model.ResourcePatrolInfoExample;
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
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ResourcePatrolInfoMapper extends Serializable {
    @SelectProvider(type=ResourcePatrolInfoSqlProvider.class, method="countByExample")
    long countByExample(ResourcePatrolInfoExample example);

    @DeleteProvider(type=ResourcePatrolInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(ResourcePatrolInfoExample example);

    @Delete({
        "delete from resource_patrol_info",
        "where patrol_id = #{patrolId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long patrolId);

    @Insert({
        "insert into resource_patrol_info (xfsj_id, community_id, ",
        "admin_uid, emp_guid, ",
        "create_time, update_time, ",
        "status, patrol_status)",
        "values (#{xfsjId,jdbcType=BIGINT}, #{communityId,jdbcType=INTEGER}, ",
        "#{adminUid,jdbcType=BIGINT}, #{empGuid,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=INTEGER}, #{patrolStatus,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="patrolId", before=false, resultType=Long.class)
    int insert(ResourcePatrolInfo record);

    @InsertProvider(type=ResourcePatrolInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="patrolId", before=false, resultType=Long.class)
    int insertSelective(ResourcePatrolInfo record);

    @SelectProvider(type=ResourcePatrolInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="patrol_id", property="patrolId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="xfsj_id", property="xfsjId", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="admin_uid", property="adminUid", jdbcType=JdbcType.BIGINT),
        @Result(column="emp_guid", property="empGuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="patrol_status", property="patrolStatus", jdbcType=JdbcType.INTEGER)
    })
    List<ResourcePatrolInfo> selectByExample(ResourcePatrolInfoExample example);

    @Select({
        "select",
        "patrol_id, xfsj_id, community_id, admin_uid, emp_guid, create_time, update_time, ",
        "status, patrol_status",
        "from resource_patrol_info",
        "where patrol_id = #{patrolId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="patrol_id", property="patrolId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="xfsj_id", property="xfsjId", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="admin_uid", property="adminUid", jdbcType=JdbcType.BIGINT),
        @Result(column="emp_guid", property="empGuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="patrol_status", property="patrolStatus", jdbcType=JdbcType.INTEGER)
    })
    ResourcePatrolInfo selectByPrimaryKey(Long patrolId);

    @UpdateProvider(type=ResourcePatrolInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ResourcePatrolInfo record, @Param("example") ResourcePatrolInfoExample example);

    @UpdateProvider(type=ResourcePatrolInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ResourcePatrolInfo record, @Param("example") ResourcePatrolInfoExample example);

    @UpdateProvider(type=ResourcePatrolInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ResourcePatrolInfo record);

    @Update({
        "update resource_patrol_info",
        "set xfsj_id = #{xfsjId,jdbcType=BIGINT},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "admin_uid = #{adminUid,jdbcType=BIGINT},",
          "emp_guid = #{empGuid,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "patrol_status = #{patrolStatus,jdbcType=INTEGER}",
        "where patrol_id = #{patrolId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ResourcePatrolInfo record);
}