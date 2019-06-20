package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityShare;
import com.rfchina.community.persistence.model.CommunityShareExample;
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

public interface CommunityShareMapper extends Serializable {
    @SelectProvider(type=CommunityShareSqlProvider.class, method="countByExample")
    long countByExample(CommunityShareExample example);

    @DeleteProvider(type=CommunityShareSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityShareExample example);

    @Delete({
        "delete from community_share",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into community_share (community_id, uid, ",
        "create_time, idx_seq)",
        "values (#{communityId,jdbcType=INTEGER}, #{uid,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{idxSeq,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CommunityShare record);

    @InsertProvider(type=CommunityShareSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CommunityShare record);

    @SelectProvider(type=CommunityShareSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="idx_seq", property="idxSeq", jdbcType=JdbcType.BIGINT)
    })
    List<CommunityShare> selectByExample(CommunityShareExample example);

    @Select({
        "select",
        "id, community_id, uid, create_time, idx_seq",
        "from community_share",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="idx_seq", property="idxSeq", jdbcType=JdbcType.BIGINT)
    })
    CommunityShare selectByPrimaryKey(Long id);

    @UpdateProvider(type=CommunityShareSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityShare record, @Param("example") CommunityShareExample example);

    @UpdateProvider(type=CommunityShareSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityShare record, @Param("example") CommunityShareExample example);

    @UpdateProvider(type=CommunityShareSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityShare record);

    @Update({
        "update community_share",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "uid = #{uid,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "idx_seq = #{idxSeq,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommunityShare record);
}