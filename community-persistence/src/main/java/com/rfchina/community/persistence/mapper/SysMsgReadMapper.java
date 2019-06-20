package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysMsgRead;
import com.rfchina.community.persistence.model.SysMsgReadExample;
import com.rfchina.community.persistence.model.SysMsgReadKey;
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

public interface SysMsgReadMapper extends Serializable {
    @SelectProvider(type=SysMsgReadSqlProvider.class, method="countByExample")
    long countByExample(SysMsgReadExample example);

    @DeleteProvider(type=SysMsgReadSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysMsgReadExample example);

    @Delete({
        "delete from sys_msg_read",
        "where admin_uid = #{adminUid,jdbcType=BIGINT}",
          "and msg_id = #{msgId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(SysMsgReadKey key);

    @Insert({
        "insert into sys_msg_read (admin_uid, msg_id, ",
        "is_read, create_time, ",
        "read_time)",
        "values (#{adminUid,jdbcType=BIGINT}, #{msgId,jdbcType=BIGINT}, ",
        "#{isRead,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{readTime,jdbcType=TIMESTAMP})"
    })
    int insert(SysMsgRead record);

    @InsertProvider(type=SysMsgReadSqlProvider.class, method="insertSelective")
    int insertSelective(SysMsgRead record);

    @SelectProvider(type=SysMsgReadSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="admin_uid", property="adminUid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="msg_id", property="msgId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="is_read", property="isRead", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="read_time", property="readTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SysMsgRead> selectByExample(SysMsgReadExample example);

    @Select({
        "select",
        "admin_uid, msg_id, is_read, create_time, read_time",
        "from sys_msg_read",
        "where admin_uid = #{adminUid,jdbcType=BIGINT}",
          "and msg_id = #{msgId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="admin_uid", property="adminUid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="msg_id", property="msgId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="is_read", property="isRead", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="read_time", property="readTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SysMsgRead selectByPrimaryKey(SysMsgReadKey key);

    @UpdateProvider(type=SysMsgReadSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysMsgRead record, @Param("example") SysMsgReadExample example);

    @UpdateProvider(type=SysMsgReadSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysMsgRead record, @Param("example") SysMsgReadExample example);

    @UpdateProvider(type=SysMsgReadSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysMsgRead record);

    @Update({
        "update sys_msg_read",
        "set is_read = #{isRead,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "read_time = #{readTime,jdbcType=TIMESTAMP}",
        "where admin_uid = #{adminUid,jdbcType=BIGINT}",
          "and msg_id = #{msgId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysMsgRead record);
}