package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysFieldMap;
import com.rfchina.community.persistence.model.SysFieldMapExample;
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

public interface SysFieldMapMapper extends Serializable {
    @SelectProvider(type=SysFieldMapSqlProvider.class, method="countByExample")
    long countByExample(SysFieldMapExample example);

    @DeleteProvider(type=SysFieldMapSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysFieldMapExample example);

    @Delete({
        "delete from sys_field_map",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sys_field_map (class_name, field, ",
        "name, use_default, ",
        "create_time)",
        "values (#{className,jdbcType=VARCHAR}, #{field,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{useDefault,jdbcType=TINYINT}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(SysFieldMap record);

    @InsertProvider(type=SysFieldMapSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(SysFieldMap record);

    @SelectProvider(type=SysFieldMapSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="class_name", property="className", jdbcType=JdbcType.VARCHAR),
        @Result(column="field", property="field", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="use_default", property="useDefault", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SysFieldMap> selectByExample(SysFieldMapExample example);

    @Select({
        "select",
        "id, class_name, field, name, use_default, create_time",
        "from sys_field_map",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="class_name", property="className", jdbcType=JdbcType.VARCHAR),
        @Result(column="field", property="field", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="use_default", property="useDefault", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SysFieldMap selectByPrimaryKey(Long id);

    @UpdateProvider(type=SysFieldMapSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysFieldMap record, @Param("example") SysFieldMapExample example);

    @UpdateProvider(type=SysFieldMapSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysFieldMap record, @Param("example") SysFieldMapExample example);

    @UpdateProvider(type=SysFieldMapSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysFieldMap record);

    @Update({
        "update sys_field_map",
        "set class_name = #{className,jdbcType=VARCHAR},",
          "field = #{field,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "use_default = #{useDefault,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysFieldMap record);
}