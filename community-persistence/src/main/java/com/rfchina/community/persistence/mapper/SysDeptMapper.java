package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysDept;
import com.rfchina.community.persistence.model.SysDeptExample;
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

public interface SysDeptMapper extends Serializable {
    @SelectProvider(type=SysDeptSqlProvider.class, method="countByExample")
    long countByExample(SysDeptExample example);

    @DeleteProvider(type=SysDeptSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysDeptExample example);

    @Delete({
        "delete from sys_dept",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_dept (parent_id, community_id, ",
        "area_id, name, status, ",
        "parent_id_path, parent_name_path, ",
        "create_time)",
        "values (#{parentId,jdbcType=INTEGER}, #{communityId,jdbcType=INTEGER}, ",
        "#{areaId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT}, ",
        "#{parentIdPath,jdbcType=VARCHAR}, #{parentNamePath,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(SysDept record);

    @InsertProvider(type=SysDeptSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(SysDept record);

    @SelectProvider(type=SysDeptSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="parent_id_path", property="parentIdPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_name_path", property="parentNamePath", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SysDept> selectByExample(SysDeptExample example);

    @Select({
        "select",
        "id, parent_id, community_id, area_id, name, status, parent_id_path, parent_name_path, ",
        "create_time",
        "from sys_dept",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="parent_id_path", property="parentIdPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_name_path", property="parentNamePath", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SysDept selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SysDeptSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysDept record, @Param("example") SysDeptExample example);

    @UpdateProvider(type=SysDeptSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysDept record, @Param("example") SysDeptExample example);

    @UpdateProvider(type=SysDeptSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysDept record);

    @Update({
        "update sys_dept",
        "set parent_id = #{parentId,jdbcType=INTEGER},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "area_id = #{areaId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "parent_id_path = #{parentIdPath,jdbcType=VARCHAR},",
          "parent_name_path = #{parentNamePath,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysDept record);
}