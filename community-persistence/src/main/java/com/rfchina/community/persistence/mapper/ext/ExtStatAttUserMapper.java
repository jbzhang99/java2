package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.model.StatAttUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/**
 */
public interface ExtStatAttUserMapper {

    @SelectProvider(type=ExtStatAttUserSqlProvider.class, method="statAttUser")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
            @Result(column="community_type", property="communityType", jdbcType=JdbcType.INTEGER),
            @Result(column="acc_count", property="accCount", jdbcType=JdbcType.INTEGER),
            @Result(column="cur_count", property="curCount", jdbcType=JdbcType.INTEGER),
            @Result(column="stat_time", property="statTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<StatAttUser> statAttUser(@Param("statTime") Date statTime);
}
