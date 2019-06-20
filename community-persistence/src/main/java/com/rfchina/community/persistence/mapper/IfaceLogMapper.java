package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.IfaceLog;
import com.rfchina.community.persistence.model.IfaceLogExample;
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

public interface IfaceLogMapper extends Serializable {
    @SelectProvider(type=IfaceLogSqlProvider.class, method="countByExample")
    long countByExample(IfaceLogExample example);

    @DeleteProvider(type=IfaceLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(IfaceLogExample example);

    @Delete({
        "delete from iface_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into iface_log (target_url, req_body, ",
        "rsp_body, create_time)",
        "values (#{targetUrl,jdbcType=VARCHAR}, #{reqBody,jdbcType=VARCHAR}, ",
        "#{rspBody,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(IfaceLog record);

    @InsertProvider(type=IfaceLogSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(IfaceLog record);

    @SelectProvider(type=IfaceLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="target_url", property="targetUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="req_body", property="reqBody", jdbcType=JdbcType.VARCHAR),
        @Result(column="rsp_body", property="rspBody", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<IfaceLog> selectByExample(IfaceLogExample example);

    @Select({
        "select",
        "id, target_url, req_body, rsp_body, create_time",
        "from iface_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="target_url", property="targetUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="req_body", property="reqBody", jdbcType=JdbcType.VARCHAR),
        @Result(column="rsp_body", property="rspBody", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    IfaceLog selectByPrimaryKey(Long id);

    @UpdateProvider(type=IfaceLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") IfaceLog record, @Param("example") IfaceLogExample example);

    @UpdateProvider(type=IfaceLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") IfaceLog record, @Param("example") IfaceLogExample example);

    @UpdateProvider(type=IfaceLogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(IfaceLog record);

    @Update({
        "update iface_log",
        "set target_url = #{targetUrl,jdbcType=VARCHAR},",
          "req_body = #{reqBody,jdbcType=VARCHAR},",
          "rsp_body = #{rspBody,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(IfaceLog record);
}