package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommonCfg;
import com.rfchina.community.persistence.model.CommonCfgExample;
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

public interface CommonCfgMapper extends Serializable {
    @SelectProvider(type=CommonCfgSqlProvider.class, method="countByExample")
    long countByExample(CommonCfgExample example);

    @DeleteProvider(type=CommonCfgSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommonCfgExample example);

    @Delete({
        "delete from common_cfg",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into common_cfg (cfg_key, cfg_value, ",
        "type, status, create_time, ",
        "update_time)",
        "values (#{cfgKey,jdbcType=VARCHAR}, #{cfgValue,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=TINYINT}, #{status,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CommonCfg record);

    @InsertProvider(type=CommonCfgSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CommonCfg record);

    @SelectProvider(type=CommonCfgSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="cfg_key", property="cfgKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="cfg_value", property="cfgValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CommonCfg> selectByExample(CommonCfgExample example);

    @Select({
        "select",
        "id, cfg_key, cfg_value, type, status, create_time, update_time",
        "from common_cfg",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="cfg_key", property="cfgKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="cfg_value", property="cfgValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CommonCfg selectByPrimaryKey(Long id);

    @UpdateProvider(type=CommonCfgSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommonCfg record, @Param("example") CommonCfgExample example);

    @UpdateProvider(type=CommonCfgSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommonCfg record, @Param("example") CommonCfgExample example);

    @UpdateProvider(type=CommonCfgSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommonCfg record);

    @Update({
        "update common_cfg",
        "set cfg_key = #{cfgKey,jdbcType=VARCHAR},",
          "cfg_value = #{cfgValue,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=TINYINT},",
          "status = #{status,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommonCfg record);
}