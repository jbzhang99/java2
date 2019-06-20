package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.UserMsg;
import com.rfchina.community.persistence.model.UserMsgExample;
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

public interface UserMsgMapper extends Serializable {
    @SelectProvider(type=UserMsgSqlProvider.class, method="countByExample")
    long countByExample(UserMsgExample example);

    @DeleteProvider(type=UserMsgSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserMsgExample example);

    @Delete({
        "delete from user_msg",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into user_msg (to_uid, from_uid, ",
        "is_read, object_id, ",
        "object_type, token, ",
        "community_id, create_time, ",
        "status, title, msg_type, ",
        "content)",
        "values (#{toUid,jdbcType=BIGINT}, #{fromUid,jdbcType=BIGINT}, ",
        "#{isRead,jdbcType=INTEGER}, #{objectId,jdbcType=BIGINT}, ",
        "#{objectType,jdbcType=INTEGER}, #{token,jdbcType=VARCHAR}, ",
        "#{communityId,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, #{msgType,jdbcType=INTEGER}, ",
        "#{content,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserMsg record);

    @InsertProvider(type=UserMsgSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(UserMsg record);

    @SelectProvider(type=UserMsgSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="to_uid", property="toUid", jdbcType=JdbcType.BIGINT),
        @Result(column="from_uid", property="fromUid", jdbcType=JdbcType.BIGINT),
        @Result(column="is_read", property="isRead", jdbcType=JdbcType.INTEGER),
        @Result(column="object_id", property="objectId", jdbcType=JdbcType.BIGINT),
        @Result(column="object_type", property="objectType", jdbcType=JdbcType.INTEGER),
        @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="msg_type", property="msgType", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<UserMsg> selectByExampleWithBLOBs(UserMsgExample example);

    @SelectProvider(type=UserMsgSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="to_uid", property="toUid", jdbcType=JdbcType.BIGINT),
        @Result(column="from_uid", property="fromUid", jdbcType=JdbcType.BIGINT),
        @Result(column="is_read", property="isRead", jdbcType=JdbcType.INTEGER),
        @Result(column="object_id", property="objectId", jdbcType=JdbcType.BIGINT),
        @Result(column="object_type", property="objectType", jdbcType=JdbcType.INTEGER),
        @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="msg_type", property="msgType", jdbcType=JdbcType.INTEGER)
    })
    List<UserMsg> selectByExample(UserMsgExample example);

    @Select({
        "select",
        "id, to_uid, from_uid, is_read, object_id, object_type, token, community_id, ",
        "create_time, status, title, msg_type, content",
        "from user_msg",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="to_uid", property="toUid", jdbcType=JdbcType.BIGINT),
        @Result(column="from_uid", property="fromUid", jdbcType=JdbcType.BIGINT),
        @Result(column="is_read", property="isRead", jdbcType=JdbcType.INTEGER),
        @Result(column="object_id", property="objectId", jdbcType=JdbcType.BIGINT),
        @Result(column="object_type", property="objectType", jdbcType=JdbcType.INTEGER),
        @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="msg_type", property="msgType", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    UserMsg selectByPrimaryKey(Long id);

    @UpdateProvider(type=UserMsgSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserMsg record, @Param("example") UserMsgExample example);

    @UpdateProvider(type=UserMsgSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") UserMsg record, @Param("example") UserMsgExample example);

    @UpdateProvider(type=UserMsgSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserMsg record, @Param("example") UserMsgExample example);

    @UpdateProvider(type=UserMsgSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserMsg record);

    @Update({
        "update user_msg",
        "set to_uid = #{toUid,jdbcType=BIGINT},",
          "from_uid = #{fromUid,jdbcType=BIGINT},",
          "is_read = #{isRead,jdbcType=INTEGER},",
          "object_id = #{objectId,jdbcType=BIGINT},",
          "object_type = #{objectType,jdbcType=INTEGER},",
          "token = #{token,jdbcType=VARCHAR},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "msg_type = #{msgType,jdbcType=INTEGER},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(UserMsg record);

    @Update({
        "update user_msg",
        "set to_uid = #{toUid,jdbcType=BIGINT},",
          "from_uid = #{fromUid,jdbcType=BIGINT},",
          "is_read = #{isRead,jdbcType=INTEGER},",
          "object_id = #{objectId,jdbcType=BIGINT},",
          "object_type = #{objectType,jdbcType=INTEGER},",
          "token = #{token,jdbcType=VARCHAR},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "msg_type = #{msgType,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserMsg record);
}