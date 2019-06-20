package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.UserCommentReply;
import com.rfchina.community.persistence.model.UserCommentReplyExample;
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

public interface UserCommentReplyMapper extends BaseMapper<UserCommentReply,UserCommentReplyExample,Long>{
    @SelectProvider(type=UserCommentReplySqlProvider.class, method="countByExample")
    long countByExample(UserCommentReplyExample example);

    @DeleteProvider(type=UserCommentReplySqlProvider.class, method="deleteByExample")
    int deleteByExample(UserCommentReplyExample example);

    @Delete({
        "delete from user_comment_reply",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into user_comment_reply (comment_id, reply_target, ",
        "status, create_time, ",
        "commentator, reply_comment)",
        "values (#{commentId,jdbcType=BIGINT}, #{replyTarget,jdbcType=BIGINT}, ",
        "#{status,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{commentator,jdbcType=BIGINT}, #{replyComment,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserCommentReply record);

    @InsertProvider(type=UserCommentReplySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(UserCommentReply record);

    @SelectProvider(type=UserCommentReplySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="comment_id", property="commentId", jdbcType=JdbcType.BIGINT),
        @Result(column="reply_target", property="replyTarget", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="commentator", property="commentator", jdbcType=JdbcType.BIGINT),
        @Result(column="reply_comment", property="replyComment", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<UserCommentReply> selectByExampleWithBLOBs(UserCommentReplyExample example);

    @SelectProvider(type=UserCommentReplySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="comment_id", property="commentId", jdbcType=JdbcType.BIGINT),
        @Result(column="reply_target", property="replyTarget", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="commentator", property="commentator", jdbcType=JdbcType.BIGINT)
    })
    List<UserCommentReply> selectByExample(UserCommentReplyExample example);

    @Select({
        "select",
        "id, comment_id, reply_target, status, create_time, commentator, reply_comment",
        "from user_comment_reply",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="comment_id", property="commentId", jdbcType=JdbcType.BIGINT),
        @Result(column="reply_target", property="replyTarget", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="commentator", property="commentator", jdbcType=JdbcType.BIGINT),
        @Result(column="reply_comment", property="replyComment", jdbcType=JdbcType.LONGVARCHAR)
    })
    UserCommentReply selectByPrimaryKey(Long id);

    @UpdateProvider(type=UserCommentReplySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserCommentReply record, @Param("example") UserCommentReplyExample example);

    @UpdateProvider(type=UserCommentReplySqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") UserCommentReply record, @Param("example") UserCommentReplyExample example);

    @UpdateProvider(type=UserCommentReplySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserCommentReply record, @Param("example") UserCommentReplyExample example);

    @UpdateProvider(type=UserCommentReplySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserCommentReply record);

    @Update({
        "update user_comment_reply",
        "set comment_id = #{commentId,jdbcType=BIGINT},",
          "reply_target = #{replyTarget,jdbcType=BIGINT},",
          "status = #{status,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "commentator = #{commentator,jdbcType=BIGINT},",
          "reply_comment = #{replyComment,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(UserCommentReply record);

    @Update({
        "update user_comment_reply",
        "set comment_id = #{commentId,jdbcType=BIGINT},",
          "reply_target = #{replyTarget,jdbcType=BIGINT},",
          "status = #{status,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "commentator = #{commentator,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserCommentReply record);
}