package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CardComment;
import com.rfchina.community.persistence.model.CardCommentExample;
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

public interface CardCommentMapper extends Serializable {
    @SelectProvider(type=CardCommentSqlProvider.class, method="countByExample")
    long countByExample(CardCommentExample example);

    @DeleteProvider(type=CardCommentSqlProvider.class, method="deleteByExample")
    int deleteByExample(CardCommentExample example);

    @Delete({
        "delete from card_comment",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into card_comment (card_id, reply_id, ",
        "reply_uid, uid, comment, ",
        "status, create_time, ",
        "cid)",
        "values (#{cardId,jdbcType=BIGINT}, #{replyId,jdbcType=BIGINT}, ",
        "#{replyUid,jdbcType=BIGINT}, #{uid,jdbcType=BIGINT}, #{comment,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{cid,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CardComment record);

    @InsertProvider(type=CardCommentSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CardComment record);

    @SelectProvider(type=CardCommentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.BIGINT),
        @Result(column="reply_id", property="replyId", jdbcType=JdbcType.BIGINT),
        @Result(column="reply_uid", property="replyUid", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="cid", property="cid", jdbcType=JdbcType.BIGINT)
    })
    List<CardComment> selectByExample(CardCommentExample example);

    @Select({
        "select",
        "id, card_id, reply_id, reply_uid, uid, comment, status, create_time, cid",
        "from card_comment",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.BIGINT),
        @Result(column="reply_id", property="replyId", jdbcType=JdbcType.BIGINT),
        @Result(column="reply_uid", property="replyUid", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="cid", property="cid", jdbcType=JdbcType.BIGINT)
    })
    CardComment selectByPrimaryKey(Long id);

    @UpdateProvider(type=CardCommentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CardComment record, @Param("example") CardCommentExample example);

    @UpdateProvider(type=CardCommentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CardComment record, @Param("example") CardCommentExample example);

    @UpdateProvider(type=CardCommentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CardComment record);

    @Update({
        "update card_comment",
        "set card_id = #{cardId,jdbcType=BIGINT},",
          "reply_id = #{replyId,jdbcType=BIGINT},",
          "reply_uid = #{replyUid,jdbcType=BIGINT},",
          "uid = #{uid,jdbcType=BIGINT},",
          "comment = #{comment,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "cid = #{cid,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CardComment record);
}