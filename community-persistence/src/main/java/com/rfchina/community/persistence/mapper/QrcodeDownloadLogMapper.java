package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.QrcodeDownloadLog;
import com.rfchina.community.persistence.model.QrcodeDownloadLogExample;
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

public interface QrcodeDownloadLogMapper extends Serializable {
    @SelectProvider(type=QrcodeDownloadLogSqlProvider.class, method="countByExample")
    long countByExample(QrcodeDownloadLogExample example);

    @DeleteProvider(type=QrcodeDownloadLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(QrcodeDownloadLogExample example);

    @Delete({
        "delete from qrcode_download_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into qrcode_download_log (community_id, user_agent, ",
        "client_ip, platform, ",
        "model, channel, ",
        "create_time, target_url)",
        "values (#{communityId,jdbcType=INTEGER}, #{userAgent,jdbcType=VARCHAR}, ",
        "#{clientIp,jdbcType=VARCHAR}, #{platform,jdbcType=VARCHAR}, ",
        "#{model,jdbcType=VARCHAR}, #{channel,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{targetUrl,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(QrcodeDownloadLog record);

    @InsertProvider(type=QrcodeDownloadLogSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(QrcodeDownloadLog record);

    @SelectProvider(type=QrcodeDownloadLogSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_agent", property="userAgent", jdbcType=JdbcType.VARCHAR),
        @Result(column="client_ip", property="clientIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="platform", property="platform", jdbcType=JdbcType.VARCHAR),
        @Result(column="model", property="model", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel", property="channel", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="target_url", property="targetUrl", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<QrcodeDownloadLog> selectByExampleWithBLOBs(QrcodeDownloadLogExample example);

    @SelectProvider(type=QrcodeDownloadLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_agent", property="userAgent", jdbcType=JdbcType.VARCHAR),
        @Result(column="client_ip", property="clientIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="platform", property="platform", jdbcType=JdbcType.VARCHAR),
        @Result(column="model", property="model", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel", property="channel", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<QrcodeDownloadLog> selectByExample(QrcodeDownloadLogExample example);

    @Select({
        "select",
        "id, community_id, user_agent, client_ip, platform, model, channel, create_time, ",
        "target_url",
        "from qrcode_download_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_agent", property="userAgent", jdbcType=JdbcType.VARCHAR),
        @Result(column="client_ip", property="clientIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="platform", property="platform", jdbcType=JdbcType.VARCHAR),
        @Result(column="model", property="model", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel", property="channel", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="target_url", property="targetUrl", jdbcType=JdbcType.LONGVARCHAR)
    })
    QrcodeDownloadLog selectByPrimaryKey(Long id);

    @UpdateProvider(type=QrcodeDownloadLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") QrcodeDownloadLog record, @Param("example") QrcodeDownloadLogExample example);

    @UpdateProvider(type=QrcodeDownloadLogSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") QrcodeDownloadLog record, @Param("example") QrcodeDownloadLogExample example);

    @UpdateProvider(type=QrcodeDownloadLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") QrcodeDownloadLog record, @Param("example") QrcodeDownloadLogExample example);

    @UpdateProvider(type=QrcodeDownloadLogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QrcodeDownloadLog record);

    @Update({
        "update qrcode_download_log",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "user_agent = #{userAgent,jdbcType=VARCHAR},",
          "client_ip = #{clientIp,jdbcType=VARCHAR},",
          "platform = #{platform,jdbcType=VARCHAR},",
          "model = #{model,jdbcType=VARCHAR},",
          "channel = #{channel,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "target_url = #{targetUrl,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(QrcodeDownloadLog record);

    @Update({
        "update qrcode_download_log",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "user_agent = #{userAgent,jdbcType=VARCHAR},",
          "client_ip = #{clientIp,jdbcType=VARCHAR},",
          "platform = #{platform,jdbcType=VARCHAR},",
          "model = #{model,jdbcType=VARCHAR},",
          "channel = #{channel,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(QrcodeDownloadLog record);
}