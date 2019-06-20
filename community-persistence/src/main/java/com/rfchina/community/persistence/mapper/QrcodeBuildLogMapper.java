package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.QrcodeBuildLog;
import com.rfchina.community.persistence.model.QrcodeBuildLogExample;
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

public interface QrcodeBuildLogMapper extends Serializable {
    @SelectProvider(type=QrcodeBuildLogSqlProvider.class, method="countByExample")
    long countByExample(QrcodeBuildLogExample example);

    @DeleteProvider(type=QrcodeBuildLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(QrcodeBuildLogExample example);

    @Delete({
        "delete from qrcode_build_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into qrcode_build_log (qrcode, uid, ",
        "community_id, other_community, ",
        "create_time, type, ",
        "begin_time, end_time, ",
        "can_count, status, ",
        "admin_id, other_id, ",
        "sys_type)",
        "values (#{qrcode,jdbcType=VARCHAR}, #{uid,jdbcType=BIGINT}, ",
        "#{communityId,jdbcType=INTEGER}, #{otherCommunity,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{type,jdbcType=INTEGER}, ",
        "#{beginTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, ",
        "#{canCount,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{adminId,jdbcType=BIGINT}, #{otherId,jdbcType=BIGINT}, ",
        "#{sysType,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(QrcodeBuildLog record);

    @InsertProvider(type=QrcodeBuildLogSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(QrcodeBuildLog record);

    @SelectProvider(type=QrcodeBuildLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="qrcode", property="qrcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="other_community", property="otherCommunity", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="begin_time", property="beginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="can_count", property="canCount", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="admin_id", property="adminId", jdbcType=JdbcType.BIGINT),
        @Result(column="other_id", property="otherId", jdbcType=JdbcType.BIGINT),
        @Result(column="sys_type", property="sysType", jdbcType=JdbcType.VARCHAR)
    })
    List<QrcodeBuildLog> selectByExample(QrcodeBuildLogExample example);

    @Select({
        "select",
        "id, qrcode, uid, community_id, other_community, create_time, type, begin_time, ",
        "end_time, can_count, status, admin_id, other_id, sys_type",
        "from qrcode_build_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="qrcode", property="qrcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="other_community", property="otherCommunity", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="begin_time", property="beginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="can_count", property="canCount", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="admin_id", property="adminId", jdbcType=JdbcType.BIGINT),
        @Result(column="other_id", property="otherId", jdbcType=JdbcType.BIGINT),
        @Result(column="sys_type", property="sysType", jdbcType=JdbcType.VARCHAR)
    })
    QrcodeBuildLog selectByPrimaryKey(Long id);

    @UpdateProvider(type=QrcodeBuildLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") QrcodeBuildLog record, @Param("example") QrcodeBuildLogExample example);

    @UpdateProvider(type=QrcodeBuildLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") QrcodeBuildLog record, @Param("example") QrcodeBuildLogExample example);

    @UpdateProvider(type=QrcodeBuildLogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QrcodeBuildLog record);

    @Update({
        "update qrcode_build_log",
        "set qrcode = #{qrcode,jdbcType=VARCHAR},",
          "uid = #{uid,jdbcType=BIGINT},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "other_community = #{otherCommunity,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "type = #{type,jdbcType=INTEGER},",
          "begin_time = #{beginTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "can_count = #{canCount,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "admin_id = #{adminId,jdbcType=BIGINT},",
          "other_id = #{otherId,jdbcType=BIGINT},",
          "sys_type = #{sysType,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(QrcodeBuildLog record);
}