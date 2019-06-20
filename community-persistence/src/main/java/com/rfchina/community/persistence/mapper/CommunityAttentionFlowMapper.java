package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityAttentionFlow;
import com.rfchina.community.persistence.model.CommunityAttentionFlowExample;
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

public interface CommunityAttentionFlowMapper extends Serializable {
    @SelectProvider(type=CommunityAttentionFlowSqlProvider.class, method="countByExample")
    long countByExample(CommunityAttentionFlowExample example);

    @DeleteProvider(type=CommunityAttentionFlowSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityAttentionFlowExample example);

    @Delete({
        "delete from community_attention_flow",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into community_attention_flow (uid, community_id, ",
        "opt_type, create_time, ",
        "idx_seq, add_type)",
        "values (#{uid,jdbcType=BIGINT}, #{communityId,jdbcType=INTEGER}, ",
        "#{optType,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{idxSeq,jdbcType=BIGINT}, #{addType,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CommunityAttentionFlow record);

    @InsertProvider(type=CommunityAttentionFlowSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CommunityAttentionFlow record);

    @SelectProvider(type=CommunityAttentionFlowSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="opt_type", property="optType", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="idx_seq", property="idxSeq", jdbcType=JdbcType.BIGINT),
        @Result(column="add_type", property="addType", jdbcType=JdbcType.INTEGER)
    })
    List<CommunityAttentionFlow> selectByExample(CommunityAttentionFlowExample example);

    @Select({
        "select",
        "id, uid, community_id, opt_type, create_time, idx_seq, add_type",
        "from community_attention_flow",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="opt_type", property="optType", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="idx_seq", property="idxSeq", jdbcType=JdbcType.BIGINT),
        @Result(column="add_type", property="addType", jdbcType=JdbcType.INTEGER)
    })
    CommunityAttentionFlow selectByPrimaryKey(Long id);

    @UpdateProvider(type=CommunityAttentionFlowSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityAttentionFlow record, @Param("example") CommunityAttentionFlowExample example);

    @UpdateProvider(type=CommunityAttentionFlowSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityAttentionFlow record, @Param("example") CommunityAttentionFlowExample example);

    @UpdateProvider(type=CommunityAttentionFlowSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityAttentionFlow record);

    @Update({
        "update community_attention_flow",
        "set uid = #{uid,jdbcType=BIGINT},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "opt_type = #{optType,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "idx_seq = #{idxSeq,jdbcType=BIGINT},",
          "add_type = #{addType,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommunityAttentionFlow record);
}