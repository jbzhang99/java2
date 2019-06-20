package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysResource;
import com.rfchina.community.persistence.model.SysResourceExample;
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

public interface SysResourceMapper extends Serializable {
    @SelectProvider(type=SysResourceSqlProvider.class, method="countByExample")
    long countByExample(SysResourceExample example);

    @DeleteProvider(type=SysResourceSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysResourceExample example);

    @Delete({
        "delete from sys_resource",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_resource (parent_id, app_id, ",
        "name, resource, ",
        "remark, status, ",
        "type, level, sorting, ",
        "create_time)",
        "values (#{parentId,jdbcType=INTEGER}, #{appId,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{resource,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT}, ",
        "#{type,jdbcType=TINYINT}, #{level,jdbcType=TINYINT}, #{sorting,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(SysResource record);

    @InsertProvider(type=SysResourceSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(SysResource record);

    @SelectProvider(type=SysResourceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="resource", property="resource", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="level", property="level", jdbcType=JdbcType.TINYINT),
        @Result(column="sorting", property="sorting", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SysResource> selectByExample(SysResourceExample example);

    @Select({
        "select",
        "id, parent_id, app_id, name, resource, remark, status, type, level, sorting, ",
        "create_time",
        "from sys_resource",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="resource", property="resource", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="level", property="level", jdbcType=JdbcType.TINYINT),
        @Result(column="sorting", property="sorting", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SysResource selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SysResourceSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysResource record, @Param("example") SysResourceExample example);

    @UpdateProvider(type=SysResourceSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysResource record, @Param("example") SysResourceExample example);

    @UpdateProvider(type=SysResourceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysResource record);

    @Update({
        "update sys_resource",
        "set parent_id = #{parentId,jdbcType=INTEGER},",
          "app_id = #{appId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "resource = #{resource,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "type = #{type,jdbcType=TINYINT},",
          "level = #{level,jdbcType=TINYINT},",
          "sorting = #{sorting,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysResource record);
}