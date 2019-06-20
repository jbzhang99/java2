package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CardInfo;
import com.rfchina.community.persistence.model.CardInfoExample;
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

public interface CardInfoMapper extends Serializable {
    @SelectProvider(type=CardInfoSqlProvider.class, method="countByExample")
    long countByExample(CardInfoExample example);

    @DeleteProvider(type=CardInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(CardInfoExample example);

    @Delete({
        "delete from card_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into card_info (category_id, template_id, ",
        "community_id, operation_id, ",
        "title, content, ",
        "status, audit_status, ",
        "audit_reason, square_audit_reason, ",
        "square_audit_status, square_audit_time, ",
        "square_publish_time, publish_time, ",
        "attachment, subject_id, ",
        "subject_name, subject_type, ",
        "subject_icon, pub_to_square, ",
        "source, creator_id, ",
        "cid, apply_time, ",
        "create_time, update_time, ",
        "delete_time)",
        "values (#{categoryId,jdbcType=INTEGER}, #{templateId,jdbcType=INTEGER}, ",
        "#{communityId,jdbcType=INTEGER}, #{operationId,jdbcType=VARCHAR}, ",
        "#{title,jdbcType=VARCHAR}, #{content,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=TINYINT}, #{auditStatus,jdbcType=TINYINT}, ",
        "#{auditReason,jdbcType=VARCHAR}, #{squareAuditReason,jdbcType=VARCHAR}, ",
        "#{squareAuditStatus,jdbcType=TINYINT}, #{squareAuditTime,jdbcType=TIMESTAMP}, ",
        "#{squarePublishTime,jdbcType=TIMESTAMP}, #{publishTime,jdbcType=TIMESTAMP}, ",
        "#{attachment,jdbcType=VARCHAR}, #{subjectId,jdbcType=BIGINT}, ",
        "#{subjectName,jdbcType=VARCHAR}, #{subjectType,jdbcType=INTEGER}, ",
        "#{subjectIcon,jdbcType=VARCHAR}, #{pubToSquare,jdbcType=TINYINT}, ",
        "#{source,jdbcType=VARCHAR}, #{creatorId,jdbcType=BIGINT}, ",
        "#{cid,jdbcType=BIGINT}, #{applyTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{deleteTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CardInfo record);

    @InsertProvider(type=CardInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CardInfo record);

    @SelectProvider(type=CardInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.INTEGER),
        @Result(column="template_id", property="templateId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="operation_id", property="operationId", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="audit_reason", property="auditReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="square_audit_reason", property="squareAuditReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="square_audit_status", property="squareAuditStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="square_audit_time", property="squareAuditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="square_publish_time", property="squarePublishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="attachment", property="attachment", jdbcType=JdbcType.VARCHAR),
        @Result(column="subject_id", property="subjectId", jdbcType=JdbcType.BIGINT),
        @Result(column="subject_name", property="subjectName", jdbcType=JdbcType.VARCHAR),
        @Result(column="subject_type", property="subjectType", jdbcType=JdbcType.INTEGER),
        @Result(column="subject_icon", property="subjectIcon", jdbcType=JdbcType.VARCHAR),
        @Result(column="pub_to_square", property="pubToSquare", jdbcType=JdbcType.TINYINT),
        @Result(column="source", property="source", jdbcType=JdbcType.VARCHAR),
        @Result(column="creator_id", property="creatorId", jdbcType=JdbcType.BIGINT),
        @Result(column="cid", property="cid", jdbcType=JdbcType.BIGINT),
        @Result(column="apply_time", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="delete_time", property="deleteTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CardInfo> selectByExample(CardInfoExample example);

    @Select({
        "select",
        "id, category_id, template_id, community_id, operation_id, title, content, status, ",
        "audit_status, audit_reason, square_audit_reason, square_audit_status, square_audit_time, ",
        "square_publish_time, publish_time, attachment, subject_id, subject_name, subject_type, ",
        "subject_icon, pub_to_square, source, creator_id, cid, apply_time, create_time, ",
        "update_time, delete_time",
        "from card_info",
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
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="audit_reason", property="auditReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="square_audit_reason", property="squareAuditReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="square_audit_status", property="squareAuditStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="square_audit_time", property="squareAuditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="square_publish_time", property="squarePublishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="attachment", property="attachment", jdbcType=JdbcType.VARCHAR),
        @Result(column="subject_id", property="subjectId", jdbcType=JdbcType.BIGINT),
        @Result(column="subject_name", property="subjectName", jdbcType=JdbcType.VARCHAR),
        @Result(column="subject_type", property="subjectType", jdbcType=JdbcType.INTEGER),
        @Result(column="subject_icon", property="subjectIcon", jdbcType=JdbcType.VARCHAR),
        @Result(column="pub_to_square", property="pubToSquare", jdbcType=JdbcType.TINYINT),
        @Result(column="source", property="source", jdbcType=JdbcType.VARCHAR),
        @Result(column="creator_id", property="creatorId", jdbcType=JdbcType.BIGINT),
        @Result(column="cid", property="cid", jdbcType=JdbcType.BIGINT),
        @Result(column="apply_time", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="delete_time", property="deleteTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CardInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=CardInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CardInfo record, @Param("example") CardInfoExample example);

    @UpdateProvider(type=CardInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CardInfo record, @Param("example") CardInfoExample example);

    @UpdateProvider(type=CardInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CardInfo record);

    @Update({
        "update card_info",
        "set category_id = #{categoryId,jdbcType=INTEGER},",
          "template_id = #{templateId,jdbcType=INTEGER},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "operation_id = #{operationId,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "audit_status = #{auditStatus,jdbcType=TINYINT},",
          "audit_reason = #{auditReason,jdbcType=VARCHAR},",
          "square_audit_reason = #{squareAuditReason,jdbcType=VARCHAR},",
          "square_audit_status = #{squareAuditStatus,jdbcType=TINYINT},",
          "square_audit_time = #{squareAuditTime,jdbcType=TIMESTAMP},",
          "square_publish_time = #{squarePublishTime,jdbcType=TIMESTAMP},",
          "publish_time = #{publishTime,jdbcType=TIMESTAMP},",
          "attachment = #{attachment,jdbcType=VARCHAR},",
          "subject_id = #{subjectId,jdbcType=BIGINT},",
          "subject_name = #{subjectName,jdbcType=VARCHAR},",
          "subject_type = #{subjectType,jdbcType=INTEGER},",
          "subject_icon = #{subjectIcon,jdbcType=VARCHAR},",
          "pub_to_square = #{pubToSquare,jdbcType=TINYINT},",
          "source = #{source,jdbcType=VARCHAR},",
          "creator_id = #{creatorId,jdbcType=BIGINT},",
          "cid = #{cid,jdbcType=BIGINT},",
          "apply_time = #{applyTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "delete_time = #{deleteTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CardInfo record);
}