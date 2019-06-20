package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.model.StatCommunityAttention;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/**
 */
public interface ExtStatCommunityAttentionMapper {

    @SelectProvider(type=ExtStatCommunityAttentionSqlProvider.class, method="statCommunityAttention")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
            @Result(column="community_type", property="communityType", jdbcType=JdbcType.TINYINT),
            @Result(column="current_app_user_count", property="currentAppUserCount", jdbcType=JdbcType.BIGINT),
            @Result(column="current_server_user_count", property="currentServerUserCount", jdbcType=JdbcType.BIGINT),
            @Result(column="incr_app_user_count", property="incrAppUserCount", jdbcType=JdbcType.BIGINT),
            @Result(column="incr_server_user_count", property="incrServerUserCount", jdbcType=JdbcType.BIGINT),
            @Result(column="del_app_user_count", property="delAppUserCount", jdbcType=JdbcType.BIGINT),
            @Result(column="del_server_user_count", property="delServerUserCount", jdbcType=JdbcType.BIGINT),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    public List<StatCommunityAttention> statCommunityAttention(@Param("startTime") Date startTime,
                                                               @Param("endTime") Date endTime);

}
