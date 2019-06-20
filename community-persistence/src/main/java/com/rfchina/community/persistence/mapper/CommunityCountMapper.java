package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityCount;
import com.rfchina.community.persistence.model.CommunityCountExample;
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

public interface CommunityCountMapper extends Serializable {
    @SelectProvider(type=CommunityCountSqlProvider.class, method="countByExample")
    long countByExample(CommunityCountExample example);

    @DeleteProvider(type=CommunityCountSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityCountExample example);

    @Delete({
        "delete from community_count",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into community_count (id, attention_count)",
        "values (#{id,jdbcType=INTEGER}, #{attentionCount,jdbcType=INTEGER})"
    })
    int insert(CommunityCount record);

    @InsertProvider(type=CommunityCountSqlProvider.class, method="insertSelective")
    int insertSelective(CommunityCount record);

    @SelectProvider(type=CommunityCountSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="attention_count", property="attentionCount", jdbcType=JdbcType.INTEGER)
    })
    List<CommunityCount> selectByExample(CommunityCountExample example);

    @Select({
        "select",
        "id, attention_count",
        "from community_count",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="attention_count", property="attentionCount", jdbcType=JdbcType.INTEGER)
    })
    CommunityCount selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CommunityCountSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityCount record, @Param("example") CommunityCountExample example);

    @UpdateProvider(type=CommunityCountSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityCount record, @Param("example") CommunityCountExample example);

    @UpdateProvider(type=CommunityCountSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityCount record);

    @Update({
        "update community_count",
        "set attention_count = #{attentionCount,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommunityCount record);
}