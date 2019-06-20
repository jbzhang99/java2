package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityMsg;
import com.rfchina.community.persistence.model.CommunityMsgExample;
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

public interface CommunityMsgMapper extends Serializable {
    @SelectProvider(type=CommunityMsgSqlProvider.class, method="countByExample")
    long countByExample(CommunityMsgExample example);

    @DeleteProvider(type=CommunityMsgSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityMsgExample example);

    @Delete({
        "delete from community_msg",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into community_msg (community_id, title, ",
        "author, content, ",
        "attachment, status, ",
        "type, publish_time, ",
        "create_time, update_time)",
        "values (#{communityId,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{author,jdbcType=VARCHAR}, #{content,jdbcType=VARCHAR}, ",
        "#{attachment,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{type,jdbcType=INTEGER}, #{publishTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CommunityMsg record);

    @InsertProvider(type=CommunityMsgSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CommunityMsg record);

    @SelectProvider(type=CommunityMsgSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="author", property="author", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="attachment", property="attachment", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CommunityMsg> selectByExample(CommunityMsgExample example);

    @Select({
        "select",
        "id, community_id, title, author, content, attachment, status, type, publish_time, ",
        "create_time, update_time",
        "from community_msg",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="author", property="author", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="attachment", property="attachment", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CommunityMsg selectByPrimaryKey(Long id);

    @UpdateProvider(type=CommunityMsgSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityMsg record, @Param("example") CommunityMsgExample example);

    @UpdateProvider(type=CommunityMsgSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityMsg record, @Param("example") CommunityMsgExample example);

    @UpdateProvider(type=CommunityMsgSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityMsg record);

    @Update({
        "update community_msg",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "author = #{author,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "attachment = #{attachment,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "type = #{type,jdbcType=INTEGER},",
          "publish_time = #{publishTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommunityMsg record);
}