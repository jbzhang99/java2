package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenConf;
import com.rfchina.community.persistence.model.OpenConfExample;
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

public interface OpenConfMapper extends Serializable {
    @SelectProvider(type=OpenConfSqlProvider.class, method="countByExample")
    long countByExample(OpenConfExample example);

    @DeleteProvider(type=OpenConfSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenConfExample example);

    @Delete({
        "delete from open_conf",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into open_conf (id, type, ",
        "code, remark, create_time)",
        "values (#{id,jdbcType=INTEGER}, #{type,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(OpenConf record);

    @InsertProvider(type=OpenConfSqlProvider.class, method="insertSelective")
    int insertSelective(OpenConf record);

    @SelectProvider(type=OpenConfSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenConf> selectByExample(OpenConfExample example);

    @Select({
        "select",
        "id, type, code, remark, create_time",
        "from open_conf",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenConf selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OpenConfSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenConf record, @Param("example") OpenConfExample example);

    @UpdateProvider(type=OpenConfSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenConf record, @Param("example") OpenConfExample example);

    @UpdateProvider(type=OpenConfSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenConf record);

    @Update({
        "update open_conf",
        "set type = #{type,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenConf record);
}