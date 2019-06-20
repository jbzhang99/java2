package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.Notification;
import com.rfchina.community.persistence.model.NotificationExample;
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

public interface NotificationMapper extends Serializable {
    @SelectProvider(type=NotificationSqlProvider.class, method="countByExample")
    long countByExample(NotificationExample example);

    @DeleteProvider(type=NotificationSqlProvider.class, method="deleteByExample")
    int deleteByExample(NotificationExample example);

    @Delete({
        "delete from notification",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into notification (app_id, title, ",
        "remark, status, ",
        "type, create_time, ",
        "create_comm, create_uid, ",
        "thumb, push_time, ",
        "audit_remark, content)",
        "values (#{appId,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{type,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{createComm,jdbcType=INTEGER}, #{createUid,jdbcType=BIGINT}, ",
        "#{thumb,jdbcType=VARCHAR}, #{pushTime,jdbcType=TIMESTAMP}, ",
        "#{auditRemark,jdbcType=VARCHAR}, #{content,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Notification record);

    @InsertProvider(type=NotificationSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(Notification record);

    @SelectProvider(type=NotificationSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_comm", property="createComm", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT),
        @Result(column="thumb", property="thumb", jdbcType=JdbcType.VARCHAR),
        @Result(column="push_time", property="pushTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_remark", property="auditRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Notification> selectByExampleWithBLOBs(NotificationExample example);

    @SelectProvider(type=NotificationSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_comm", property="createComm", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT),
        @Result(column="thumb", property="thumb", jdbcType=JdbcType.VARCHAR),
        @Result(column="push_time", property="pushTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_remark", property="auditRemark", jdbcType=JdbcType.VARCHAR)
    })
    List<Notification> selectByExample(NotificationExample example);

    @Select({
        "select",
        "id, app_id, title, remark, status, type, create_time, create_comm, create_uid, ",
        "thumb, push_time, audit_remark, content",
        "from notification",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_comm", property="createComm", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT),
        @Result(column="thumb", property="thumb", jdbcType=JdbcType.VARCHAR),
        @Result(column="push_time", property="pushTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_remark", property="auditRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    Notification selectByPrimaryKey(Long id);

    @UpdateProvider(type=NotificationSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Notification record, @Param("example") NotificationExample example);

    @UpdateProvider(type=NotificationSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Notification record, @Param("example") NotificationExample example);

    @UpdateProvider(type=NotificationSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Notification record, @Param("example") NotificationExample example);

    @UpdateProvider(type=NotificationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Notification record);

    @Update({
        "update notification",
        "set app_id = #{appId,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "type = #{type,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_comm = #{createComm,jdbcType=INTEGER},",
          "create_uid = #{createUid,jdbcType=BIGINT},",
          "thumb = #{thumb,jdbcType=VARCHAR},",
          "push_time = #{pushTime,jdbcType=TIMESTAMP},",
          "audit_remark = #{auditRemark,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(Notification record);

    @Update({
        "update notification",
        "set app_id = #{appId,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "type = #{type,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_comm = #{createComm,jdbcType=INTEGER},",
          "create_uid = #{createUid,jdbcType=BIGINT},",
          "thumb = #{thumb,jdbcType=VARCHAR},",
          "push_time = #{pushTime,jdbcType=TIMESTAMP},",
          "audit_remark = #{auditRemark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Notification record);
}