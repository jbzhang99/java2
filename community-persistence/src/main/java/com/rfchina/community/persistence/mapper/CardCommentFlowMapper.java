package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CardCommentFlow;
import com.rfchina.community.persistence.model.CardCommentFlowExample;
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

public interface CardCommentFlowMapper extends Serializable {
    @SelectProvider(type=CardCommentFlowSqlProvider.class, method="countByExample")
    long countByExample(CardCommentFlowExample example);

    @DeleteProvider(type=CardCommentFlowSqlProvider.class, method="deleteByExample")
    int deleteByExample(CardCommentFlowExample example);

    @Delete({
        "delete from card_comment_flow",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into card_comment_flow (src_id, card_id, ",
        "reply_id, reply_uid, ",
        "uid, comment, opt_type, ",
        "status, create_time, ",
        "cid)",
        "values (#{srcId,jdbcType=BIGINT}, #{cardId,jdbcType=BIGINT}, ",
        "#{replyId,jdbcType=BIGINT}, #{replyUid,jdbcType=BIGINT}, ",
        "#{uid,jdbcType=BIGINT}, #{comment,jdbcType=VARCHAR}, #{optType,jdbcType=TINYINT}, ",
        "#{status,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{cid,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CardCommentFlow record);

    @InsertProvider(type=CardCommentFlowSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CardCommentFlow record);

    @SelectProvider(type=CardCommentFlowSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="src_id", property="srcId", jdbcType=JdbcType.BIGINT),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.BIGINT),
        @Result(column="reply_id", property="replyId", jdbcType=JdbcType.BIGINT),
        @Result(column="reply_uid", property="replyUid", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="opt_type", property="optType", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="cid", property="cid", jdbcType=JdbcType.BIGINT)
    })
    List<CardCommentFlow> selectByExample(CardCommentFlowExample example);

    @Select({
        "select",
        "id, src_id, card_id, reply_id, reply_uid, uid, comment, opt_type, status, create_time, ",
        "cid",
        "from card_comment_flow",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="src_id", property="srcId", jdbcType=JdbcType.BIGINT),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.BIGINT),
        @Result(column="reply_id", property="replyId", jdbcType=JdbcType.BIGINT),
        @Result(column="reply_uid", property="replyUid", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="opt_type", property="optType", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="cid", property="cid", jdbcType=JdbcType.BIGINT)
    })
    CardCommentFlow selectByPrimaryKey(Long id);

    @UpdateProvider(type=CardCommentFlowSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CardCommentFlow record, @Param("example") CardCommentFlowExample example);

    @UpdateProvider(type=CardCommentFlowSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CardCommentFlow record, @Param("example") CardCommentFlowExample example);

    @UpdateProvider(type=CardCommentFlowSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CardCommentFlow record);

    @Update({
        "update card_comment_flow",
        "set src_id = #{srcId,jdbcType=BIGINT},",
          "card_id = #{cardId,jdbcType=BIGINT},",
          "reply_id = #{replyId,jdbcType=BIGINT},",
          "reply_uid = #{replyUid,jdbcType=BIGINT},",
          "uid = #{uid,jdbcType=BIGINT},",
          "comment = #{comment,jdbcType=VARCHAR},",
          "opt_type = #{optType,jdbcType=TINYINT},",
          "status = #{status,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "cid = #{cid,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CardCommentFlow record);
}