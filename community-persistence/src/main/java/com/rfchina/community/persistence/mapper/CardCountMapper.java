package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CardCount;
import com.rfchina.community.persistence.model.CardCountExample;
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

public interface CardCountMapper extends Serializable {
    @SelectProvider(type=CardCountSqlProvider.class, method="countByExample")
    long countByExample(CardCountExample example);

    @DeleteProvider(type=CardCountSqlProvider.class, method="deleteByExample")
    int deleteByExample(CardCountExample example);

    @Delete({
        "delete from card_count",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into card_count (id, like_count, ",
        "unlike_count, share_count, ",
        "comment_count)",
        "values (#{id,jdbcType=BIGINT}, #{likeCount,jdbcType=BIGINT}, ",
        "#{unlikeCount,jdbcType=BIGINT}, #{shareCount,jdbcType=BIGINT}, ",
        "#{commentCount,jdbcType=BIGINT})"
    })
    int insert(CardCount record);

    @InsertProvider(type=CardCountSqlProvider.class, method="insertSelective")
    int insertSelective(CardCount record);

    @SelectProvider(type=CardCountSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="like_count", property="likeCount", jdbcType=JdbcType.BIGINT),
        @Result(column="unlike_count", property="unlikeCount", jdbcType=JdbcType.BIGINT),
        @Result(column="share_count", property="shareCount", jdbcType=JdbcType.BIGINT),
        @Result(column="comment_count", property="commentCount", jdbcType=JdbcType.BIGINT)
    })
    List<CardCount> selectByExample(CardCountExample example);

    @Select({
        "select",
        "id, like_count, unlike_count, share_count, comment_count",
        "from card_count",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="like_count", property="likeCount", jdbcType=JdbcType.BIGINT),
        @Result(column="unlike_count", property="unlikeCount", jdbcType=JdbcType.BIGINT),
        @Result(column="share_count", property="shareCount", jdbcType=JdbcType.BIGINT),
        @Result(column="comment_count", property="commentCount", jdbcType=JdbcType.BIGINT)
    })
    CardCount selectByPrimaryKey(Long id);

    @UpdateProvider(type=CardCountSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CardCount record, @Param("example") CardCountExample example);

    @UpdateProvider(type=CardCountSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CardCount record, @Param("example") CardCountExample example);

    @UpdateProvider(type=CardCountSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CardCount record);

    @Update({
        "update card_count",
        "set like_count = #{likeCount,jdbcType=BIGINT},",
          "unlike_count = #{unlikeCount,jdbcType=BIGINT},",
          "share_count = #{shareCount,jdbcType=BIGINT},",
          "comment_count = #{commentCount,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CardCount record);
}