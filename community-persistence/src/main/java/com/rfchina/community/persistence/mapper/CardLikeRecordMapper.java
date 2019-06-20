package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CardLikeRecord;
import com.rfchina.community.persistence.model.CardLikeRecordExample;
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

public interface CardLikeRecordMapper extends Serializable {
    @SelectProvider(type=CardLikeRecordSqlProvider.class, method="countByExample")
    long countByExample(CardLikeRecordExample example);

    @DeleteProvider(type=CardLikeRecordSqlProvider.class, method="deleteByExample")
    int deleteByExample(CardLikeRecordExample example);

    @Delete({
        "delete from card_like_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into card_like_record (card_id, uid, ",
        "create_time, idx_seq)",
        "values (#{cardId,jdbcType=BIGINT}, #{uid,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{idxSeq,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CardLikeRecord record);

    @InsertProvider(type=CardLikeRecordSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CardLikeRecord record);

    @SelectProvider(type=CardLikeRecordSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="idx_seq", property="idxSeq", jdbcType=JdbcType.BIGINT)
    })
    List<CardLikeRecord> selectByExample(CardLikeRecordExample example);

    @Select({
        "select",
        "id, card_id, uid, create_time, idx_seq",
        "from card_like_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="idx_seq", property="idxSeq", jdbcType=JdbcType.BIGINT)
    })
    CardLikeRecord selectByPrimaryKey(Long id);

    @UpdateProvider(type=CardLikeRecordSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CardLikeRecord record, @Param("example") CardLikeRecordExample example);

    @UpdateProvider(type=CardLikeRecordSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CardLikeRecord record, @Param("example") CardLikeRecordExample example);

    @UpdateProvider(type=CardLikeRecordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CardLikeRecord record);

    @Update({
        "update card_like_record",
        "set card_id = #{cardId,jdbcType=BIGINT},",
          "uid = #{uid,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "idx_seq = #{idxSeq,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CardLikeRecord record);
}