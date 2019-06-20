package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.UserMsgRead;
import com.rfchina.community.persistence.model.UserMsgReadExample;
import com.rfchina.community.persistence.model.UserMsgReadKey;
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

public interface UserMsgReadMapper {
    @SelectProvider(type=UserMsgReadSqlProvider.class, method="countByExample")
    long countByExample(UserMsgReadExample example);

    @DeleteProvider(type=UserMsgReadSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserMsgReadExample example);

    @Delete({
        "delete from user_msg_read",
        "where uid = #{uid,jdbcType=BIGINT}",
          "and msg_id = #{msgId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(UserMsgReadKey key);

    @Insert({
        "insert into user_msg_read (uid, msg_id, ",
        "create_time)",
        "values (#{uid,jdbcType=BIGINT}, #{msgId,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(UserMsgRead record);

    @InsertProvider(type=UserMsgReadSqlProvider.class, method="insertSelective")
    int insertSelective(UserMsgRead record);

    @SelectProvider(type=UserMsgReadSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="msg_id", property="msgId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserMsgRead> selectByExample(UserMsgReadExample example);

    @Select({
        "select",
        "uid, msg_id, create_time",
        "from user_msg_read",
        "where uid = #{uid,jdbcType=BIGINT}",
          "and msg_id = #{msgId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="msg_id", property="msgId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    UserMsgRead selectByPrimaryKey(UserMsgReadKey key);

    @UpdateProvider(type=UserMsgReadSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserMsgRead record, @Param("example") UserMsgReadExample example);

    @UpdateProvider(type=UserMsgReadSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserMsgRead record, @Param("example") UserMsgReadExample example);

    @UpdateProvider(type=UserMsgReadSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserMsgRead record);

    @Update({
        "update user_msg_read",
        "set create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where uid = #{uid,jdbcType=BIGINT}",
          "and msg_id = #{msgId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserMsgRead record);
}