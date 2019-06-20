package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.UserSearchLog;
import com.rfchina.community.persistence.model.UserSearchLogExample;
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

public interface UserSearchLogMapper extends Serializable {
    @SelectProvider(type=UserSearchLogSqlProvider.class, method="countByExample")
    long countByExample(UserSearchLogExample example);

    @DeleteProvider(type=UserSearchLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserSearchLogExample example);

    @Delete({
        "delete from user_search_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into user_search_log (uid, title, ",
        "create_time, update_time)",
        "values (#{uid,jdbcType=BIGINT}, #{title,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserSearchLog record);

    @InsertProvider(type=UserSearchLogSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(UserSearchLog record);

    @SelectProvider(type=UserSearchLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserSearchLog> selectByExample(UserSearchLogExample example);

    @Select({
        "select",
        "id, uid, title, create_time, update_time",
        "from user_search_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    UserSearchLog selectByPrimaryKey(Long id);

    @UpdateProvider(type=UserSearchLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserSearchLog record, @Param("example") UserSearchLogExample example);

    @UpdateProvider(type=UserSearchLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserSearchLog record, @Param("example") UserSearchLogExample example);

    @UpdateProvider(type=UserSearchLogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserSearchLog record);

    @Update({
        "update user_search_log",
        "set uid = #{uid,jdbcType=BIGINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserSearchLog record);
}