package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CardLikeStat;
import com.rfchina.community.persistence.model.CardLikeStatExample;
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

public interface CardLikeStatMapper extends Serializable {
    @SelectProvider(type=CardLikeStatSqlProvider.class, method="countByExample")
    long countByExample(CardLikeStatExample example);

    @DeleteProvider(type=CardLikeStatSqlProvider.class, method="deleteByExample")
    int deleteByExample(CardLikeStatExample example);

    @Delete({
        "delete from card_like_stat",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into card_like_stat (card_id, uid, ",
        "status, create_time)",
        "values (#{cardId,jdbcType=BIGINT}, #{uid,jdbcType=BIGINT}, ",
        "#{status,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CardLikeStat record);

    @InsertProvider(type=CardLikeStatSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CardLikeStat record);

    @SelectProvider(type=CardLikeStatSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CardLikeStat> selectByExample(CardLikeStatExample example);

    @Select({
        "select",
        "id, card_id, uid, status, create_time",
        "from card_like_stat",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CardLikeStat selectByPrimaryKey(Long id);

    @UpdateProvider(type=CardLikeStatSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CardLikeStat record, @Param("example") CardLikeStatExample example);

    @UpdateProvider(type=CardLikeStatSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CardLikeStat record, @Param("example") CardLikeStatExample example);

    @UpdateProvider(type=CardLikeStatSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CardLikeStat record);

    @Update({
        "update card_like_stat",
        "set card_id = #{cardId,jdbcType=BIGINT},",
          "uid = #{uid,jdbcType=BIGINT},",
          "status = #{status,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CardLikeStat record);
}