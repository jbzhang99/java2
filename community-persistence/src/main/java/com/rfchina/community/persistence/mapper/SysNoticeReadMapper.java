package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysNoticeRead;
import com.rfchina.community.persistence.model.SysNoticeReadExample;
import com.rfchina.community.persistence.model.SysNoticeReadKey;
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

public interface SysNoticeReadMapper extends Serializable {
    @SelectProvider(type=SysNoticeReadSqlProvider.class, method="countByExample")
    long countByExample(SysNoticeReadExample example);

    @DeleteProvider(type=SysNoticeReadSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysNoticeReadExample example);

    @Delete({
        "delete from sys_notice_read",
        "where admin_uid = #{adminUid,jdbcType=BIGINT}",
          "and notice_id = #{noticeId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(SysNoticeReadKey key);

    @Insert({
        "insert into sys_notice_read (admin_uid, notice_id, ",
        "read_time)",
        "values (#{adminUid,jdbcType=BIGINT}, #{noticeId,jdbcType=BIGINT}, ",
        "#{readTime,jdbcType=TIMESTAMP})"
    })
    int insert(SysNoticeRead record);

    @InsertProvider(type=SysNoticeReadSqlProvider.class, method="insertSelective")
    int insertSelective(SysNoticeRead record);

    @SelectProvider(type=SysNoticeReadSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="admin_uid", property="adminUid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="notice_id", property="noticeId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="read_time", property="readTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SysNoticeRead> selectByExample(SysNoticeReadExample example);

    @Select({
        "select",
        "admin_uid, notice_id, read_time",
        "from sys_notice_read",
        "where admin_uid = #{adminUid,jdbcType=BIGINT}",
          "and notice_id = #{noticeId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="admin_uid", property="adminUid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="notice_id", property="noticeId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="read_time", property="readTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SysNoticeRead selectByPrimaryKey(SysNoticeReadKey key);

    @UpdateProvider(type=SysNoticeReadSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysNoticeRead record, @Param("example") SysNoticeReadExample example);

    @UpdateProvider(type=SysNoticeReadSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysNoticeRead record, @Param("example") SysNoticeReadExample example);

    @UpdateProvider(type=SysNoticeReadSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysNoticeRead record);

    @Update({
        "update sys_notice_read",
        "set read_time = #{readTime,jdbcType=TIMESTAMP}",
        "where admin_uid = #{adminUid,jdbcType=BIGINT}",
          "and notice_id = #{noticeId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysNoticeRead record);
}