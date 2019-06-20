package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityAttention;
import com.rfchina.community.persistence.model.CommunityAttentionExample;
import com.rfchina.community.persistence.model.CommunityAttentionKey;
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

public interface CommunityAttentionMapper extends Serializable {
    @SelectProvider(type=CommunityAttentionSqlProvider.class, method="countByExample")
    long countByExample(CommunityAttentionExample example);

    @DeleteProvider(type=CommunityAttentionSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityAttentionExample example);

    @Delete({
        "delete from community_attention",
        "where uid = #{uid,jdbcType=BIGINT}",
          "and community_id = #{communityId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(CommunityAttentionKey key);

    @Insert({
        "insert into community_attention (uid, community_id, ",
        "create_time, idx_seq, ",
        "add_type)",
        "values (#{uid,jdbcType=BIGINT}, #{communityId,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{idxSeq,jdbcType=BIGINT}, ",
        "#{addType,jdbcType=INTEGER})"
    })
    int insert(CommunityAttention record);

    @InsertProvider(type=CommunityAttentionSqlProvider.class, method="insertSelective")
    int insertSelective(CommunityAttention record);

    @SelectProvider(type=CommunityAttentionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="idx_seq", property="idxSeq", jdbcType=JdbcType.BIGINT),
        @Result(column="add_type", property="addType", jdbcType=JdbcType.INTEGER)
    })
    List<CommunityAttention> selectByExample(CommunityAttentionExample example);

    @Select({
        "select",
        "uid, community_id, create_time, idx_seq, add_type",
        "from community_attention",
        "where uid = #{uid,jdbcType=BIGINT}",
          "and community_id = #{communityId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="idx_seq", property="idxSeq", jdbcType=JdbcType.BIGINT),
        @Result(column="add_type", property="addType", jdbcType=JdbcType.INTEGER)
    })
    CommunityAttention selectByPrimaryKey(CommunityAttentionKey key);

    @UpdateProvider(type=CommunityAttentionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityAttention record, @Param("example") CommunityAttentionExample example);

    @UpdateProvider(type=CommunityAttentionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityAttention record, @Param("example") CommunityAttentionExample example);

    @UpdateProvider(type=CommunityAttentionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityAttention record);

    @Update({
        "update community_attention",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "idx_seq = #{idxSeq,jdbcType=BIGINT},",
          "add_type = #{addType,jdbcType=INTEGER}",
        "where uid = #{uid,jdbcType=BIGINT}",
          "and community_id = #{communityId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommunityAttention record);
}