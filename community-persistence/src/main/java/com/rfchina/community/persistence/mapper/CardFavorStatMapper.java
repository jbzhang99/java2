package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CardFavorStat;
import com.rfchina.community.persistence.model.CardFavorStatExample;
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

public interface CardFavorStatMapper extends Serializable {
    @SelectProvider(type=CardFavorStatSqlProvider.class, method="countByExample")
    long countByExample(CardFavorStatExample example);

    @DeleteProvider(type=CardFavorStatSqlProvider.class, method="deleteByExample")
    int deleteByExample(CardFavorStatExample example);

    @Delete({
        "delete from card_favor_stat",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into card_favor_stat (card_id, uid, ",
        "status, create_time)",
        "values (#{cardId,jdbcType=BIGINT}, #{uid,jdbcType=BIGINT}, ",
        "#{status,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CardFavorStat record);

    @InsertProvider(type=CardFavorStatSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CardFavorStat record);

    @SelectProvider(type=CardFavorStatSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CardFavorStat> selectByExample(CardFavorStatExample example);

    @Select({
        "select",
        "id, card_id, uid, status, create_time",
        "from card_favor_stat",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CardFavorStat selectByPrimaryKey(Long id);

    @UpdateProvider(type=CardFavorStatSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CardFavorStat record, @Param("example") CardFavorStatExample example);

    @UpdateProvider(type=CardFavorStatSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CardFavorStat record, @Param("example") CardFavorStatExample example);

    @UpdateProvider(type=CardFavorStatSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CardFavorStat record);

    @Update({
        "update card_favor_stat",
        "set card_id = #{cardId,jdbcType=BIGINT},",
          "uid = #{uid,jdbcType=BIGINT},",
          "status = #{status,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CardFavorStat record);
}