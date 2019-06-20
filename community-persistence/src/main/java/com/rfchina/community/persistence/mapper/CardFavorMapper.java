package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CardFavor;
import com.rfchina.community.persistence.model.CardFavorExample;
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

public interface CardFavorMapper extends Serializable {
    @SelectProvider(type=CardFavorSqlProvider.class, method="countByExample")
    long countByExample(CardFavorExample example);

    @DeleteProvider(type=CardFavorSqlProvider.class, method="deleteByExample")
    int deleteByExample(CardFavorExample example);

    @Delete({
        "delete from card_favor",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into card_favor (card_id, uid, ",
        "create_time, idx_seq)",
        "values (#{cardId,jdbcType=BIGINT}, #{uid,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{idxSeq,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CardFavor record);

    @InsertProvider(type=CardFavorSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CardFavor record);

    @SelectProvider(type=CardFavorSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="idx_seq", property="idxSeq", jdbcType=JdbcType.BIGINT)
    })
    List<CardFavor> selectByExample(CardFavorExample example);

    @Select({
        "select",
        "id, card_id, uid, create_time, idx_seq",
        "from card_favor",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="idx_seq", property="idxSeq", jdbcType=JdbcType.BIGINT)
    })
    CardFavor selectByPrimaryKey(Long id);

    @UpdateProvider(type=CardFavorSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CardFavor record, @Param("example") CardFavorExample example);

    @UpdateProvider(type=CardFavorSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CardFavor record, @Param("example") CardFavorExample example);

    @UpdateProvider(type=CardFavorSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CardFavor record);

    @Update({
        "update card_favor",
        "set card_id = #{cardId,jdbcType=BIGINT},",
          "uid = #{uid,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "idx_seq = #{idxSeq,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CardFavor record);
}