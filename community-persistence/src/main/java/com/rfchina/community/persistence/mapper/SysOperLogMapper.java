package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysOperLog;
import com.rfchina.community.persistence.model.SysOperLogExample;
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

public interface SysOperLogMapper extends Serializable {
    @SelectProvider(type=SysOperLogSqlProvider.class, method="countByExample")
    long countByExample(SysOperLogExample example);

    @DeleteProvider(type=SysOperLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysOperLogExample example);

    @Delete({
        "delete from sys_oper_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sys_oper_log (community_id, app_id, ",
        "oper_id, oper_name, ",
        "oper_event, oper_content, ",
        "oper_ip, target_id, ",
        "target_name, target_content, ",
        "oper_level, oper_type, ",
        "oper_time)",
        "values (#{communityId,jdbcType=INTEGER}, #{appId,jdbcType=INTEGER}, ",
        "#{operId,jdbcType=BIGINT}, #{operName,jdbcType=VARCHAR}, ",
        "#{operEvent,jdbcType=VARCHAR}, #{operContent,jdbcType=VARCHAR}, ",
        "#{operIp,jdbcType=VARCHAR}, #{targetId,jdbcType=BIGINT}, ",
        "#{targetName,jdbcType=VARCHAR}, #{targetContent,jdbcType=VARCHAR}, ",
        "#{operLevel,jdbcType=INTEGER}, #{operType,jdbcType=INTEGER}, ",
        "#{operTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(SysOperLog record);

    @InsertProvider(type=SysOperLogSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(SysOperLog record);

    @SelectProvider(type=SysOperLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.INTEGER),
        @Result(column="oper_id", property="operId", jdbcType=JdbcType.BIGINT),
        @Result(column="oper_name", property="operName", jdbcType=JdbcType.VARCHAR),
        @Result(column="oper_event", property="operEvent", jdbcType=JdbcType.VARCHAR),
        @Result(column="oper_content", property="operContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="oper_ip", property="operIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="target_id", property="targetId", jdbcType=JdbcType.BIGINT),
        @Result(column="target_name", property="targetName", jdbcType=JdbcType.VARCHAR),
        @Result(column="target_content", property="targetContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="oper_level", property="operLevel", jdbcType=JdbcType.INTEGER),
        @Result(column="oper_type", property="operType", jdbcType=JdbcType.INTEGER),
        @Result(column="oper_time", property="operTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SysOperLog> selectByExample(SysOperLogExample example);

    @Select({
        "select",
        "id, community_id, app_id, oper_id, oper_name, oper_event, oper_content, oper_ip, ",
        "target_id, target_name, target_content, oper_level, oper_type, oper_time",
        "from sys_oper_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.INTEGER),
        @Result(column="oper_id", property="operId", jdbcType=JdbcType.BIGINT),
        @Result(column="oper_name", property="operName", jdbcType=JdbcType.VARCHAR),
        @Result(column="oper_event", property="operEvent", jdbcType=JdbcType.VARCHAR),
        @Result(column="oper_content", property="operContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="oper_ip", property="operIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="target_id", property="targetId", jdbcType=JdbcType.BIGINT),
        @Result(column="target_name", property="targetName", jdbcType=JdbcType.VARCHAR),
        @Result(column="target_content", property="targetContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="oper_level", property="operLevel", jdbcType=JdbcType.INTEGER),
        @Result(column="oper_type", property="operType", jdbcType=JdbcType.INTEGER),
        @Result(column="oper_time", property="operTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SysOperLog selectByPrimaryKey(Long id);

    @UpdateProvider(type=SysOperLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysOperLog record, @Param("example") SysOperLogExample example);

    @UpdateProvider(type=SysOperLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysOperLog record, @Param("example") SysOperLogExample example);

    @UpdateProvider(type=SysOperLogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysOperLog record);

    @Update({
        "update sys_oper_log",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "app_id = #{appId,jdbcType=INTEGER},",
          "oper_id = #{operId,jdbcType=BIGINT},",
          "oper_name = #{operName,jdbcType=VARCHAR},",
          "oper_event = #{operEvent,jdbcType=VARCHAR},",
          "oper_content = #{operContent,jdbcType=VARCHAR},",
          "oper_ip = #{operIp,jdbcType=VARCHAR},",
          "target_id = #{targetId,jdbcType=BIGINT},",
          "target_name = #{targetName,jdbcType=VARCHAR},",
          "target_content = #{targetContent,jdbcType=VARCHAR},",
          "oper_level = #{operLevel,jdbcType=INTEGER},",
          "oper_type = #{operType,jdbcType=INTEGER},",
          "oper_time = #{operTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysOperLog record);
}