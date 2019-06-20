package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.App;
import com.rfchina.community.persistence.model.AppExample;
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

public interface AppMapper extends Serializable {
    @SelectProvider(type=AppSqlProvider.class, method="countByExample")
    long countByExample(AppExample example);

    @DeleteProvider(type=AppSqlProvider.class, method="deleteByExample")
    int deleteByExample(AppExample example);

    @Delete({
        "delete from rf_app",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rf_app (id, name, ",
        "status, type, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{type,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(App record);

    @InsertProvider(type=AppSqlProvider.class, method="insertSelective")
    int insertSelective(App record);

    @SelectProvider(type=AppSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<App> selectByExample(AppExample example);

    @Select({
        "select",
        "id, name, status, type, create_time, update_time",
        "from rf_app",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    App selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AppSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") App record, @Param("example") AppExample example);

    @UpdateProvider(type=AppSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") App record, @Param("example") AppExample example);

    @UpdateProvider(type=AppSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(App record);

    @Update({
        "update rf_app",
        "set name = #{name,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "type = #{type,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(App record);
}