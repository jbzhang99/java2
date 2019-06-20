package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CardLikeFlow;
import com.rfchina.community.persistence.model.CardLikeFlowExample;
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

public interface CardLikeFlowMapper extends Serializable {
    @SelectProvider(type=CardLikeFlowSqlProvider.class, method="countByExample")
    long countByExample(CardLikeFlowExample example);

    @DeleteProvider(type=CardLikeFlowSqlProvider.class, method="deleteByExample")
    int deleteByExample(CardLikeFlowExample example);

    @Delete({
        "delete from card_like_flow",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into card_like_flow (src_id, card_id, ",
        "uid, opt_type, create_time, ",
        "idx_seq)",
        "values (#{srcId,jdbcType=BIGINT}, #{cardId,jdbcType=BIGINT}, ",
        "#{uid,jdbcType=BIGINT}, #{optType,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{idxSeq,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CardLikeFlow record);

    @InsertProvider(type=CardLikeFlowSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CardLikeFlow record);

    @SelectProvider(type=CardLikeFlowSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="src_id", property="srcId", jdbcType=JdbcType.BIGINT),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="opt_type", property="optType", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="idx_seq", property="idxSeq", jdbcType=JdbcType.BIGINT)
    })
    List<CardLikeFlow> selectByExample(CardLikeFlowExample example);

    @Select({
        "select",
        "id, src_id, card_id, uid, opt_type, create_time, idx_seq",
        "from card_like_flow",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="src_id", property="srcId", jdbcType=JdbcType.BIGINT),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="opt_type", property="optType", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="idx_seq", property="idxSeq", jdbcType=JdbcType.BIGINT)
    })
    CardLikeFlow selectByPrimaryKey(Long id);

    @UpdateProvider(type=CardLikeFlowSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CardLikeFlow record, @Param("example") CardLikeFlowExample example);

    @UpdateProvider(type=CardLikeFlowSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CardLikeFlow record, @Param("example") CardLikeFlowExample example);

    @UpdateProvider(type=CardLikeFlowSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CardLikeFlow record);

    @Update({
        "update card_like_flow",
        "set src_id = #{srcId,jdbcType=BIGINT},",
          "card_id = #{cardId,jdbcType=BIGINT},",
          "uid = #{uid,jdbcType=BIGINT},",
          "opt_type = #{optType,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "idx_seq = #{idxSeq,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CardLikeFlow record);
}