package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.ResourcePatrolType;
import com.rfchina.community.persistence.model.ResourcePatrolTypeExample;
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

public interface ResourcePatrolTypeMapper extends Serializable {
    @SelectProvider(type=ResourcePatrolTypeSqlProvider.class, method="countByExample")
    long countByExample(ResourcePatrolTypeExample example);

    @DeleteProvider(type=ResourcePatrolTypeSqlProvider.class, method="deleteByExample")
    int deleteByExample(ResourcePatrolTypeExample example);

    @Delete({
        "delete from resource_patrol_type",
        "where patrol_type = #{patrolType,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer patrolType);

    @Insert({
        "insert into resource_patrol_type (patrol_type, type_name, ",
        "status)",
        "values (#{patrolType,jdbcType=INTEGER}, #{typeName,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER})"
    })
    int insert(ResourcePatrolType record);

    @InsertProvider(type=ResourcePatrolTypeSqlProvider.class, method="insertSelective")
    int insertSelective(ResourcePatrolType record);

    @SelectProvider(type=ResourcePatrolTypeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="patrol_type", property="patrolType", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type_name", property="typeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<ResourcePatrolType> selectByExample(ResourcePatrolTypeExample example);

    @Select({
        "select",
        "patrol_type, type_name, status",
        "from resource_patrol_type",
        "where patrol_type = #{patrolType,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="patrol_type", property="patrolType", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type_name", property="typeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    ResourcePatrolType selectByPrimaryKey(Integer patrolType);

    @UpdateProvider(type=ResourcePatrolTypeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ResourcePatrolType record, @Param("example") ResourcePatrolTypeExample example);

    @UpdateProvider(type=ResourcePatrolTypeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ResourcePatrolType record, @Param("example") ResourcePatrolTypeExample example);

    @UpdateProvider(type=ResourcePatrolTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ResourcePatrolType record);

    @Update({
        "update resource_patrol_type",
        "set type_name = #{typeName,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER}",
        "where patrol_type = #{patrolType,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ResourcePatrolType record);
}