package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.StatCommunityAttention;
import com.rfchina.community.persistence.model.StatCommunityAttentionExample;
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

public interface StatCommunityAttentionMapper extends Serializable {
    @SelectProvider(type=StatCommunityAttentionSqlProvider.class, method="countByExample")
    long countByExample(StatCommunityAttentionExample example);

    @DeleteProvider(type=StatCommunityAttentionSqlProvider.class, method="deleteByExample")
    int deleteByExample(StatCommunityAttentionExample example);

    @Delete({
        "delete from stat_community_attention",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into stat_community_attention (area_id, community_id, ",
        "community_type, current_app_user_count, ",
        "current_server_user_count, incr_app_user_count, ",
        "incr_server_user_count, del_app_user_count, ",
        "del_server_user_count, create_time, ",
        "stat_time)",
        "values (#{areaId,jdbcType=INTEGER}, #{communityId,jdbcType=INTEGER}, ",
        "#{communityType,jdbcType=INTEGER}, #{currentAppUserCount,jdbcType=BIGINT}, ",
        "#{currentServerUserCount,jdbcType=BIGINT}, #{incrAppUserCount,jdbcType=BIGINT}, ",
        "#{incrServerUserCount,jdbcType=BIGINT}, #{delAppUserCount,jdbcType=BIGINT}, ",
        "#{delServerUserCount,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{statTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(StatCommunityAttention record);

    @InsertProvider(type=StatCommunityAttentionSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(StatCommunityAttention record);

    @SelectProvider(type=StatCommunityAttentionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_type", property="communityType", jdbcType=JdbcType.INTEGER),
        @Result(column="current_app_user_count", property="currentAppUserCount", jdbcType=JdbcType.BIGINT),
        @Result(column="current_server_user_count", property="currentServerUserCount", jdbcType=JdbcType.BIGINT),
        @Result(column="incr_app_user_count", property="incrAppUserCount", jdbcType=JdbcType.BIGINT),
        @Result(column="incr_server_user_count", property="incrServerUserCount", jdbcType=JdbcType.BIGINT),
        @Result(column="del_app_user_count", property="delAppUserCount", jdbcType=JdbcType.BIGINT),
        @Result(column="del_server_user_count", property="delServerUserCount", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="stat_time", property="statTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<StatCommunityAttention> selectByExample(StatCommunityAttentionExample example);

    @Select({
        "select",
        "id, area_id, community_id, community_type, current_app_user_count, current_server_user_count, ",
        "incr_app_user_count, incr_server_user_count, del_app_user_count, del_server_user_count, ",
        "create_time, stat_time",
        "from stat_community_attention",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_type", property="communityType", jdbcType=JdbcType.INTEGER),
        @Result(column="current_app_user_count", property="currentAppUserCount", jdbcType=JdbcType.BIGINT),
        @Result(column="current_server_user_count", property="currentServerUserCount", jdbcType=JdbcType.BIGINT),
        @Result(column="incr_app_user_count", property="incrAppUserCount", jdbcType=JdbcType.BIGINT),
        @Result(column="incr_server_user_count", property="incrServerUserCount", jdbcType=JdbcType.BIGINT),
        @Result(column="del_app_user_count", property="delAppUserCount", jdbcType=JdbcType.BIGINT),
        @Result(column="del_server_user_count", property="delServerUserCount", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="stat_time", property="statTime", jdbcType=JdbcType.TIMESTAMP)
    })
    StatCommunityAttention selectByPrimaryKey(Long id);

    @UpdateProvider(type=StatCommunityAttentionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StatCommunityAttention record, @Param("example") StatCommunityAttentionExample example);

    @UpdateProvider(type=StatCommunityAttentionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StatCommunityAttention record, @Param("example") StatCommunityAttentionExample example);

    @UpdateProvider(type=StatCommunityAttentionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StatCommunityAttention record);

    @Update({
        "update stat_community_attention",
        "set area_id = #{areaId,jdbcType=INTEGER},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "community_type = #{communityType,jdbcType=INTEGER},",
          "current_app_user_count = #{currentAppUserCount,jdbcType=BIGINT},",
          "current_server_user_count = #{currentServerUserCount,jdbcType=BIGINT},",
          "incr_app_user_count = #{incrAppUserCount,jdbcType=BIGINT},",
          "incr_server_user_count = #{incrServerUserCount,jdbcType=BIGINT},",
          "del_app_user_count = #{delAppUserCount,jdbcType=BIGINT},",
          "del_server_user_count = #{delServerUserCount,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "stat_time = #{statTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(StatCommunityAttention record);
}