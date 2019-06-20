package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysMsgObjectType;
import com.rfchina.community.persistence.model.SysMsgObjectTypeExample;
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

public interface SysMsgObjectTypeMapper extends Serializable {
    @SelectProvider(type=SysMsgObjectTypeSqlProvider.class, method="countByExample")
    long countByExample(SysMsgObjectTypeExample example);

    @DeleteProvider(type=SysMsgObjectTypeSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysMsgObjectTypeExample example);

    @Delete({
        "delete from sys_msg_object_type",
        "where ot_object_type = #{otObjectType,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String otObjectType);

    @Insert({
        "insert into sys_msg_object_type (ot_object_type, ot_title, ",
        "ot_target_pf, ot_open_type, ",
        "ot_content, ot_resource, ",
        "ot_source_pf)",
        "values (#{otObjectType,jdbcType=VARCHAR}, #{otTitle,jdbcType=VARCHAR}, ",
        "#{otTargetPf,jdbcType=VARCHAR}, #{otOpenType,jdbcType=VARCHAR}, ",
        "#{otContent,jdbcType=VARCHAR}, #{otResource,jdbcType=INTEGER}, ",
        "#{otSourcePf,jdbcType=VARCHAR})"
    })
    int insert(SysMsgObjectType record);

    @InsertProvider(type=SysMsgObjectTypeSqlProvider.class, method="insertSelective")
    int insertSelective(SysMsgObjectType record);

    @SelectProvider(type=SysMsgObjectTypeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ot_object_type", property="otObjectType", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="ot_title", property="otTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="ot_target_pf", property="otTargetPf", jdbcType=JdbcType.VARCHAR),
        @Result(column="ot_open_type", property="otOpenType", jdbcType=JdbcType.VARCHAR),
        @Result(column="ot_content", property="otContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="ot_resource", property="otResource", jdbcType=JdbcType.INTEGER),
        @Result(column="ot_source_pf", property="otSourcePf", jdbcType=JdbcType.VARCHAR)
    })
    List<SysMsgObjectType> selectByExample(SysMsgObjectTypeExample example);

    @Select({
        "select",
        "ot_object_type, ot_title, ot_target_pf, ot_open_type, ot_content, ot_resource, ",
        "ot_source_pf",
        "from sys_msg_object_type",
        "where ot_object_type = #{otObjectType,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ot_object_type", property="otObjectType", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="ot_title", property="otTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="ot_target_pf", property="otTargetPf", jdbcType=JdbcType.VARCHAR),
        @Result(column="ot_open_type", property="otOpenType", jdbcType=JdbcType.VARCHAR),
        @Result(column="ot_content", property="otContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="ot_resource", property="otResource", jdbcType=JdbcType.INTEGER),
        @Result(column="ot_source_pf", property="otSourcePf", jdbcType=JdbcType.VARCHAR)
    })
    SysMsgObjectType selectByPrimaryKey(String otObjectType);

    @UpdateProvider(type=SysMsgObjectTypeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysMsgObjectType record, @Param("example") SysMsgObjectTypeExample example);

    @UpdateProvider(type=SysMsgObjectTypeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysMsgObjectType record, @Param("example") SysMsgObjectTypeExample example);

    @UpdateProvider(type=SysMsgObjectTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysMsgObjectType record);

    @Update({
        "update sys_msg_object_type",
        "set ot_title = #{otTitle,jdbcType=VARCHAR},",
          "ot_target_pf = #{otTargetPf,jdbcType=VARCHAR},",
          "ot_open_type = #{otOpenType,jdbcType=VARCHAR},",
          "ot_content = #{otContent,jdbcType=VARCHAR},",
          "ot_resource = #{otResource,jdbcType=INTEGER},",
          "ot_source_pf = #{otSourcePf,jdbcType=VARCHAR}",
        "where ot_object_type = #{otObjectType,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysMsgObjectType record);
}