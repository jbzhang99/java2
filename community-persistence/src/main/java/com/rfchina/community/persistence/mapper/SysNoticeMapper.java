package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysNotice;
import com.rfchina.community.persistence.model.SysNoticeExample;
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

public interface SysNoticeMapper extends Serializable {
    @SelectProvider(type=SysNoticeSqlProvider.class, method="countByExample")
    long countByExample(SysNoticeExample example);

    @DeleteProvider(type=SysNoticeSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysNoticeExample example);

    @Delete({
        "delete from sys_notice",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sys_notice (create_comm, create_id, ",
        "create_time, title, ",
        "platform_uid, comm_uid, ",
        "master_uid, seller_uid, ",
        "status, content)",
        "values (#{createComm,jdbcType=INTEGER}, #{createId,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{title,jdbcType=VARCHAR}, ",
        "#{platformUid,jdbcType=BIGINT}, #{commUid,jdbcType=BIGINT}, ",
        "#{masterUid,jdbcType=BIGINT}, #{sellerUid,jdbcType=BIGINT}, ",
        "#{status,jdbcType=INTEGER}, #{content,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(SysNotice record);

    @InsertProvider(type=SysNoticeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(SysNotice record);

    @SelectProvider(type=SysNoticeSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_comm", property="createComm", jdbcType=JdbcType.INTEGER),
        @Result(column="create_id", property="createId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="platform_uid", property="platformUid", jdbcType=JdbcType.BIGINT),
        @Result(column="comm_uid", property="commUid", jdbcType=JdbcType.BIGINT),
        @Result(column="master_uid", property="masterUid", jdbcType=JdbcType.BIGINT),
        @Result(column="seller_uid", property="sellerUid", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<SysNotice> selectByExampleWithBLOBs(SysNoticeExample example);

    @SelectProvider(type=SysNoticeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_comm", property="createComm", jdbcType=JdbcType.INTEGER),
        @Result(column="create_id", property="createId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="platform_uid", property="platformUid", jdbcType=JdbcType.BIGINT),
        @Result(column="comm_uid", property="commUid", jdbcType=JdbcType.BIGINT),
        @Result(column="master_uid", property="masterUid", jdbcType=JdbcType.BIGINT),
        @Result(column="seller_uid", property="sellerUid", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<SysNotice> selectByExample(SysNoticeExample example);

    @Select({
        "select",
        "id, create_comm, create_id, create_time, title, platform_uid, comm_uid, master_uid, ",
        "seller_uid, status, content",
        "from sys_notice",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_comm", property="createComm", jdbcType=JdbcType.INTEGER),
        @Result(column="create_id", property="createId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="platform_uid", property="platformUid", jdbcType=JdbcType.BIGINT),
        @Result(column="comm_uid", property="commUid", jdbcType=JdbcType.BIGINT),
        @Result(column="master_uid", property="masterUid", jdbcType=JdbcType.BIGINT),
        @Result(column="seller_uid", property="sellerUid", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    SysNotice selectByPrimaryKey(Long id);

    @UpdateProvider(type=SysNoticeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysNotice record, @Param("example") SysNoticeExample example);

    @UpdateProvider(type=SysNoticeSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") SysNotice record, @Param("example") SysNoticeExample example);

    @UpdateProvider(type=SysNoticeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysNotice record, @Param("example") SysNoticeExample example);

    @UpdateProvider(type=SysNoticeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysNotice record);

    @Update({
        "update sys_notice",
        "set create_comm = #{createComm,jdbcType=INTEGER},",
          "create_id = #{createId,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "title = #{title,jdbcType=VARCHAR},",
          "platform_uid = #{platformUid,jdbcType=BIGINT},",
          "comm_uid = #{commUid,jdbcType=BIGINT},",
          "master_uid = #{masterUid,jdbcType=BIGINT},",
          "seller_uid = #{sellerUid,jdbcType=BIGINT},",
          "status = #{status,jdbcType=INTEGER},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(SysNotice record);

    @Update({
        "update sys_notice",
        "set create_comm = #{createComm,jdbcType=INTEGER},",
          "create_id = #{createId,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "title = #{title,jdbcType=VARCHAR},",
          "platform_uid = #{platformUid,jdbcType=BIGINT},",
          "comm_uid = #{commUid,jdbcType=BIGINT},",
          "master_uid = #{masterUid,jdbcType=BIGINT},",
          "seller_uid = #{sellerUid,jdbcType=BIGINT},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysNotice record);
}