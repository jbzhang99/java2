package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysUploadImage;
import com.rfchina.community.persistence.model.SysUploadImageExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.util.List;

public interface SysUploadImageMapper extends Serializable {
    @SelectProvider(type=SysUploadImageSqlProvider.class, method="countByExample")
    long countByExample(SysUploadImageExample example);

    @DeleteProvider(type=SysUploadImageSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysUploadImageExample example);

    @Delete({
        "delete from sys_upload_image",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sys_upload_image (uid, link, ",
        "create_time, create_ip, ",
        "type, sys_type)",
        "values (#{uid,jdbcType=BIGINT}, #{link,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{createIp,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=VARCHAR}, #{sysType,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(SysUploadImage record);

    @InsertProvider(type=SysUploadImageSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(SysUploadImage record);

    @SelectProvider(type=SysUploadImageSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="link", property="link", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_ip", property="createIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="sys_type", property="sysType", jdbcType=JdbcType.VARCHAR)
    })
    List<SysUploadImage> selectByExample(SysUploadImageExample example);

    @Select({
        "select",
        "id, uid, link, create_time, create_ip, type, sys_type",
        "from sys_upload_image",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="link", property="link", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_ip", property="createIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="sys_type", property="sysType", jdbcType=JdbcType.VARCHAR)
    })
    SysUploadImage selectByPrimaryKey(Long id);

    @UpdateProvider(type=SysUploadImageSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysUploadImage record, @Param("example") SysUploadImageExample example);

    @UpdateProvider(type=SysUploadImageSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysUploadImage record, @Param("example") SysUploadImageExample example);

    @UpdateProvider(type=SysUploadImageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysUploadImage record);

    @Update({
        "update sys_upload_image",
        "set uid = #{uid,jdbcType=BIGINT},",
          "link = #{link,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_ip = #{createIp,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "sys_type = #{sysType,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysUploadImage record);
}