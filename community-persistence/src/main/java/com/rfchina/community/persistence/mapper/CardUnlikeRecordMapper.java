package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CardUnlikeRecord;
import com.rfchina.community.persistence.model.CardUnlikeRecordExample;
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

public interface CardUnlikeRecordMapper extends Serializable {
    @SelectProvider(type=CardUnlikeRecordSqlProvider.class, method="countByExample")
    long countByExample(CardUnlikeRecordExample example);

    @DeleteProvider(type=CardUnlikeRecordSqlProvider.class, method="deleteByExample")
    int deleteByExample(CardUnlikeRecordExample example);

    @Delete({
        "delete from card_unlike_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into card_unlike_record (card_id, uid, ",
        "create_time, idx_seq)",
        "values (#{cardId,jdbcType=BIGINT}, #{uid,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{idxSeq,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CardUnlikeRecord record);

    @InsertProvider(type=CardUnlikeRecordSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CardUnlikeRecord record);

    @SelectProvider(type=CardUnlikeRecordSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="idx_seq", property="idxSeq", jdbcType=JdbcType.BIGINT)
    })
    List<CardUnlikeRecord> selectByExample(CardUnlikeRecordExample example);

    @Select({
        "select",
        "id, card_id, uid, create_time, idx_seq",
        "from card_unlike_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="idx_seq", property="idxSeq", jdbcType=JdbcType.BIGINT)
    })
    CardUnlikeRecord selectByPrimaryKey(Long id);

    @UpdateProvider(type=CardUnlikeRecordSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CardUnlikeRecord record, @Param("example") CardUnlikeRecordExample example);

    @UpdateProvider(type=CardUnlikeRecordSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CardUnlikeRecord record, @Param("example") CardUnlikeRecordExample example);

    @UpdateProvider(type=CardUnlikeRecordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CardUnlikeRecord record);

    @Update({
        "update card_unlike_record",
        "set card_id = #{cardId,jdbcType=BIGINT},",
          "uid = #{uid,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "idx_seq = #{idxSeq,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CardUnlikeRecord record);
}