package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.model.StatRegUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/**
 */
public interface ExtStatRegUserMapper {

    @SelectProvider(type=ExtStatRegUserSqlProvider.class, method="statRegUser")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="stat_date", property="statDate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="acc_count", property="accCount", jdbcType=JdbcType.INTEGER),
            @Result(column="app_count", property="appCount", jdbcType=JdbcType.INTEGER),
            @Result(column="other_count", property="otherCount", jdbcType=JdbcType.INTEGER),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<StatRegUser> statRegUser(@Param("statTime") Date startTime);
}
