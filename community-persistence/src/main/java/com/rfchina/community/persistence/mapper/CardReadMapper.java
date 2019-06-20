package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CardRead;
import com.rfchina.community.persistence.model.CardReadExample;
import com.rfchina.community.persistence.model.CardReadKey;
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

public interface CardReadMapper extends Serializable {
    @SelectProvider(type=CardReadSqlProvider.class, method="countByExample")
    long countByExample(CardReadExample example);

    @DeleteProvider(type=CardReadSqlProvider.class, method="deleteByExample")
    int deleteByExample(CardReadExample example);

    @Delete({
        "delete from card_read",
        "where uid = #{uid,jdbcType=BIGINT}",
          "and community_id = #{communityId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(CardReadKey key);

    @Insert({
        "insert into card_read (uid, community_id, ",
        "cid, create_time, ",
        "update_time)",
        "values (#{uid,jdbcType=BIGINT}, #{communityId,jdbcType=INTEGER}, ",
        "#{cid,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(CardRead record);

    @InsertProvider(type=CardReadSqlProvider.class, method="insertSelective")
    int insertSelective(CardRead record);

    @SelectProvider(type=CardReadSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="cid", property="cid", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CardRead> selectByExample(CardReadExample example);

    @Select({
        "select",
        "uid, community_id, cid, create_time, update_time",
        "from card_read",
        "where uid = #{uid,jdbcType=BIGINT}",
          "and community_id = #{communityId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="cid", property="cid", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CardRead selectByPrimaryKey(CardReadKey key);

    @UpdateProvider(type=CardReadSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CardRead record, @Param("example") CardReadExample example);

    @UpdateProvider(type=CardReadSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CardRead record, @Param("example") CardReadExample example);

    @UpdateProvider(type=CardReadSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CardRead record);

    @Update({
        "update card_read",
        "set cid = #{cid,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where uid = #{uid,jdbcType=BIGINT}",
          "and community_id = #{communityId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CardRead record);
}