package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.WebappConf;
import com.rfchina.community.persistence.model.WebappConfExample;
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

public interface WebappConfMapper extends Serializable {
    @SelectProvider(type=WebappConfSqlProvider.class, method="countByExample")
    long countByExample(WebappConfExample example);

    @DeleteProvider(type=WebappConfSqlProvider.class, method="deleteByExample")
    int deleteByExample(WebappConfExample example);

    @Delete({
        "delete from webapp_conf",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into webapp_conf (app_id, conf_key, ",
        "conf_value, create_time)",
        "values (#{appId,jdbcType=INTEGER}, #{confKey,jdbcType=VARCHAR}, ",
        "#{confValue,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(WebappConf record);

    @InsertProvider(type=WebappConfSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(WebappConf record);

    @SelectProvider(type=WebappConfSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.INTEGER),
        @Result(column="conf_key", property="confKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="conf_value", property="confValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WebappConf> selectByExample(WebappConfExample example);

    @Select({
        "select",
        "id, app_id, conf_key, conf_value, create_time",
        "from webapp_conf",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.INTEGER),
        @Result(column="conf_key", property="confKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="conf_value", property="confValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    WebappConf selectByPrimaryKey(Integer id);

    @UpdateProvider(type=WebappConfSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WebappConf record, @Param("example") WebappConfExample example);

    @UpdateProvider(type=WebappConfSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WebappConf record, @Param("example") WebappConfExample example);

    @UpdateProvider(type=WebappConfSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WebappConf record);

    @Update({
        "update webapp_conf",
        "set app_id = #{appId,jdbcType=INTEGER},",
          "conf_key = #{confKey,jdbcType=VARCHAR},",
          "conf_value = #{confValue,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(WebappConf record);
}