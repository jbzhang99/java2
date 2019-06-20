package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.HomeCardInfo;
import com.rfchina.community.persistence.model.HomeCardInfoExample;
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

public interface HomeCardInfoMapper extends Serializable {
    @SelectProvider(type=HomeCardInfoSqlProvider.class, method="countByExample")
    long countByExample(HomeCardInfoExample example);

    @DeleteProvider(type=HomeCardInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(HomeCardInfoExample example);

    @Delete({
        "delete from home_card_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into home_card_info (id, category_id, ",
        "template_id, community_id, ",
        "operation_id, title, ",
        "content, attachment, ",
        "status, subject_id, ",
        "subject_name, subject_type, ",
        "subject_icon, creator_id, ",
        "cid, create_time, ",
        "delete_time)",
        "values (#{id,jdbcType=BIGINT}, #{categoryId,jdbcType=INTEGER}, ",
        "#{templateId,jdbcType=INTEGER}, #{communityId,jdbcType=INTEGER}, ",
        "#{operationId,jdbcType=VARCHAR}, #{title,jdbcType=VARCHAR}, ",
        "#{content,jdbcType=VARCHAR}, #{attachment,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=TINYINT}, #{subjectId,jdbcType=BIGINT}, ",
        "#{subjectName,jdbcType=VARCHAR}, #{subjectType,jdbcType=TINYINT}, ",
        "#{subjectIcon,jdbcType=VARCHAR}, #{creatorId,jdbcType=BIGINT}, ",
        "#{cid,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{deleteTime,jdbcType=TIMESTAMP})"
    })
    int insert(HomeCardInfo record);

    @InsertProvider(type=HomeCardInfoSqlProvider.class, method="insertSelective")
    int insertSelective(HomeCardInfo record);

    @SelectProvider(type=HomeCardInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.INTEGER),
        @Result(column="template_id", property="templateId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="operation_id", property="operationId", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="attachment", property="attachment", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="subject_id", property="subjectId", jdbcType=JdbcType.BIGINT),
        @Result(column="subject_name", property="subjectName", jdbcType=JdbcType.VARCHAR),
        @Result(column="subject_type", property="subjectType", jdbcType=JdbcType.TINYINT),
        @Result(column="subject_icon", property="subjectIcon", jdbcType=JdbcType.VARCHAR),
        @Result(column="creator_id", property="creatorId", jdbcType=JdbcType.BIGINT),
        @Result(column="cid", property="cid", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="delete_time", property="deleteTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<HomeCardInfo> selectByExample(HomeCardInfoExample example);

    @Select({
        "select",
        "id, category_id, template_id, community_id, operation_id, title, content, attachment, ",
        "status, subject_id, subject_name, subject_type, subject_icon, creator_id, cid, ",
        "create_time, delete_time",
        "from home_card_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.INTEGER),
        @Result(column="template_id", property="templateId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="operation_id", property="operationId", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="attachment", property="attachment", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="subject_id", property="subjectId", jdbcType=JdbcType.BIGINT),
        @Result(column="subject_name", property="subjectName", jdbcType=JdbcType.VARCHAR),
        @Result(column="subject_type", property="subjectType", jdbcType=JdbcType.TINYINT),
        @Result(column="subject_icon", property="subjectIcon", jdbcType=JdbcType.VARCHAR),
        @Result(column="creator_id", property="creatorId", jdbcType=JdbcType.BIGINT),
        @Result(column="cid", property="cid", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="delete_time", property="deleteTime", jdbcType=JdbcType.TIMESTAMP)
    })
    HomeCardInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=HomeCardInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") HomeCardInfo record, @Param("example") HomeCardInfoExample example);

    @UpdateProvider(type=HomeCardInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") HomeCardInfo record, @Param("example") HomeCardInfoExample example);

    @UpdateProvider(type=HomeCardInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HomeCardInfo record);

    @Update({
        "update home_card_info",
        "set category_id = #{categoryId,jdbcType=INTEGER},",
          "template_id = #{templateId,jdbcType=INTEGER},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "operation_id = #{operationId,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "attachment = #{attachment,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "subject_id = #{subjectId,jdbcType=BIGINT},",
          "subject_name = #{subjectName,jdbcType=VARCHAR},",
          "subject_type = #{subjectType,jdbcType=TINYINT},",
          "subject_icon = #{subjectIcon,jdbcType=VARCHAR},",
          "creator_id = #{creatorId,jdbcType=BIGINT},",
          "cid = #{cid,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "delete_time = #{deleteTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(HomeCardInfo record);
}