package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.UserComment;
import com.rfchina.community.persistence.model.UserCommentExample;
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

public interface UserCommentMapper extends BaseMapper {
    @SelectProvider(type=UserCommentSqlProvider.class, method="countByExample")
    long countByExample(UserCommentExample example);

    @DeleteProvider(type=UserCommentSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserCommentExample example);

    @Delete({
        "delete from user_comment",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into user_comment (comment_target_type, comment_target, ",
        "out_trade_no, pic_url, ",
        "logistics_grade, service_grade, ",
        "goods_grade, commentator, ",
        "create_time, comment, ",
        "status, reply_status, ",
        "user_name)",
        "values (#{commentTargetType,jdbcType=VARCHAR}, #{commentTarget,jdbcType=BIGINT}, ",
        "#{outTradeNo,jdbcType=VARCHAR}, #{picUrl,jdbcType=VARCHAR}, ",
        "#{logisticsGrade,jdbcType=INTEGER}, #{serviceGrade,jdbcType=INTEGER}, ",
        "#{goodsGrade,jdbcType=INTEGER}, #{commentator,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{comment,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR}, #{replyStatus,jdbcType=VARCHAR}, ",
        "#{userName,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserComment record);

    @InsertProvider(type=UserCommentSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(UserComment record);

    @SelectProvider(type=UserCommentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="comment_target_type", property="commentTargetType", jdbcType=JdbcType.VARCHAR),
        @Result(column="comment_target", property="commentTarget", jdbcType=JdbcType.BIGINT),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="logistics_grade", property="logisticsGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="service_grade", property="serviceGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="goods_grade", property="goodsGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="commentator", property="commentator", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="reply_status", property="replyStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR)
    })
    List<UserComment> selectByExample(UserCommentExample example);

    @Select({
        "select",
        "id, comment_target_type, comment_target, out_trade_no, pic_url, logistics_grade, ",
        "service_grade, goods_grade, commentator, create_time, comment, status, reply_status, ",
        "user_name",
        "from user_comment",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="comment_target_type", property="commentTargetType", jdbcType=JdbcType.VARCHAR),
        @Result(column="comment_target", property="commentTarget", jdbcType=JdbcType.BIGINT),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="logistics_grade", property="logisticsGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="service_grade", property="serviceGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="goods_grade", property="goodsGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="commentator", property="commentator", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="reply_status", property="replyStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR)
    })
    UserComment selectByPrimaryKey(Long id);

    @UpdateProvider(type=UserCommentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserComment record, @Param("example") UserCommentExample example);

    @UpdateProvider(type=UserCommentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserComment record, @Param("example") UserCommentExample example);

    @UpdateProvider(type=UserCommentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserComment record);

    @Update({
        "update user_comment",
        "set comment_target_type = #{commentTargetType,jdbcType=VARCHAR},",
          "comment_target = #{commentTarget,jdbcType=BIGINT},",
          "out_trade_no = #{outTradeNo,jdbcType=VARCHAR},",
          "pic_url = #{picUrl,jdbcType=VARCHAR},",
          "logistics_grade = #{logisticsGrade,jdbcType=INTEGER},",
          "service_grade = #{serviceGrade,jdbcType=INTEGER},",
          "goods_grade = #{goodsGrade,jdbcType=INTEGER},",
          "commentator = #{commentator,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "comment = #{comment,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "reply_status = #{replyStatus,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserComment record);
}