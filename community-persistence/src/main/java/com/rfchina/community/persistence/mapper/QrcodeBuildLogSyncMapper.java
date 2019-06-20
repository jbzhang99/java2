package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.QrcodeBuildLogSync;
import com.rfchina.community.persistence.model.QrcodeBuildLogSyncExample;
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

public interface QrcodeBuildLogSyncMapper extends Serializable {
    @SelectProvider(type=QrcodeBuildLogSyncSqlProvider.class, method="countByExample")
    long countByExample(QrcodeBuildLogSyncExample example);

    @DeleteProvider(type=QrcodeBuildLogSyncSqlProvider.class, method="deleteByExample")
    int deleteByExample(QrcodeBuildLogSyncExample example);

    @Delete({
        "delete from qrcode_build_log_sync",
        "where my_id = #{myId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long myId);

    @Insert({
        "insert into qrcode_build_log_sync (my_create_time, my_community_id, ",
        "id, qrcode_decoding, ",
        "community_id, type, ",
        "can_pass_count, begin_time, ",
        "end_time, qrcode_id, ",
        "create_time, sys_group)",
        "values (#{myCreateTime,jdbcType=TIMESTAMP}, #{myCommunityId,jdbcType=INTEGER}, ",
        "#{id,jdbcType=BIGINT}, #{qrcodeDecoding,jdbcType=VARCHAR}, ",
        "#{communityId,jdbcType=INTEGER}, #{type,jdbcType=INTEGER}, ",
        "#{canPassCount,jdbcType=INTEGER}, #{beginTime,jdbcType=TIMESTAMP}, ",
        "#{endTime,jdbcType=TIMESTAMP}, #{qrcodeId,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{sysGroup,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="myId", before=false, resultType=Long.class)
    int insert(QrcodeBuildLogSync record);

    @InsertProvider(type=QrcodeBuildLogSyncSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="myId", before=false, resultType=Long.class)
    int insertSelective(QrcodeBuildLogSync record);

    @SelectProvider(type=QrcodeBuildLogSyncSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="my_id", property="myId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="my_create_time", property="myCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="my_community_id", property="myCommunityId", jdbcType=JdbcType.INTEGER),
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="qrcode_decoding", property="qrcodeDecoding", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="can_pass_count", property="canPassCount", jdbcType=JdbcType.INTEGER),
        @Result(column="begin_time", property="beginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="qrcode_id", property="qrcodeId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sys_group", property="sysGroup", jdbcType=JdbcType.INTEGER)
    })
    List<QrcodeBuildLogSync> selectByExample(QrcodeBuildLogSyncExample example);

    @Select({
        "select",
        "my_id, my_create_time, my_community_id, id, qrcode_decoding, community_id, type, ",
        "can_pass_count, begin_time, end_time, qrcode_id, create_time, sys_group",
        "from qrcode_build_log_sync",
        "where my_id = #{myId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="my_id", property="myId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="my_create_time", property="myCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="my_community_id", property="myCommunityId", jdbcType=JdbcType.INTEGER),
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="qrcode_decoding", property="qrcodeDecoding", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="can_pass_count", property="canPassCount", jdbcType=JdbcType.INTEGER),
        @Result(column="begin_time", property="beginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="qrcode_id", property="qrcodeId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sys_group", property="sysGroup", jdbcType=JdbcType.INTEGER)
    })
    QrcodeBuildLogSync selectByPrimaryKey(Long myId);

    @UpdateProvider(type=QrcodeBuildLogSyncSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") QrcodeBuildLogSync record, @Param("example") QrcodeBuildLogSyncExample example);

    @UpdateProvider(type=QrcodeBuildLogSyncSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") QrcodeBuildLogSync record, @Param("example") QrcodeBuildLogSyncExample example);

    @UpdateProvider(type=QrcodeBuildLogSyncSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QrcodeBuildLogSync record);

    @Update({
        "update qrcode_build_log_sync",
        "set my_create_time = #{myCreateTime,jdbcType=TIMESTAMP},",
          "my_community_id = #{myCommunityId,jdbcType=INTEGER},",
          "id = #{id,jdbcType=BIGINT},",
          "qrcode_decoding = #{qrcodeDecoding,jdbcType=VARCHAR},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "type = #{type,jdbcType=INTEGER},",
          "can_pass_count = #{canPassCount,jdbcType=INTEGER},",
          "begin_time = #{beginTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "qrcode_id = #{qrcodeId,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "sys_group = #{sysGroup,jdbcType=INTEGER}",
        "where my_id = #{myId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(QrcodeBuildLogSync record);
}