package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysMsgInfo;
import com.rfchina.community.persistence.model.SysMsgInfoExample;
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

public interface SysMsgInfoMapper extends Serializable {
    @SelectProvider(type=SysMsgInfoSqlProvider.class, method="countByExample")
    long countByExample(SysMsgInfoExample example);

    @DeleteProvider(type=SysMsgInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysMsgInfoExample example);

    @Delete({
        "delete from sys_msg_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sys_msg_info (content, object_key, ",
        "object_type, create_time, ",
        "create_community_id, msg_source_type)",
        "values (#{content,jdbcType=VARCHAR}, #{objectKey,jdbcType=VARCHAR}, ",
        "#{objectType,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{createCommunityId,jdbcType=INTEGER}, #{msgSourceType,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(SysMsgInfo record);

    @InsertProvider(type=SysMsgInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(SysMsgInfo record);

    @SelectProvider(type=SysMsgInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="object_key", property="objectKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="object_type", property="objectType", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_community_id", property="createCommunityId", jdbcType=JdbcType.INTEGER),
        @Result(column="msg_source_type", property="msgSourceType", jdbcType=JdbcType.VARCHAR)
    })
    List<SysMsgInfo> selectByExample(SysMsgInfoExample example);

    @Select({
        "select",
        "id, content, object_key, object_type, create_time, create_community_id, msg_source_type",
        "from sys_msg_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="object_key", property="objectKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="object_type", property="objectType", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_community_id", property="createCommunityId", jdbcType=JdbcType.INTEGER),
        @Result(column="msg_source_type", property="msgSourceType", jdbcType=JdbcType.VARCHAR)
    })
    SysMsgInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=SysMsgInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysMsgInfo record, @Param("example") SysMsgInfoExample example);

    @UpdateProvider(type=SysMsgInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysMsgInfo record, @Param("example") SysMsgInfoExample example);

    @UpdateProvider(type=SysMsgInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysMsgInfo record);

    @Update({
        "update sys_msg_info",
        "set content = #{content,jdbcType=VARCHAR},",
          "object_key = #{objectKey,jdbcType=VARCHAR},",
          "object_type = #{objectType,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_community_id = #{createCommunityId,jdbcType=INTEGER},",
          "msg_source_type = #{msgSourceType,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysMsgInfo record);
}