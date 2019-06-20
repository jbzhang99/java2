package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.model.StatVenueOrder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/**
 */
public interface ExtStatVenueOrderMapper {

        @SelectProvider(type=ExtStatVenueOrderSqlProvider.class, method="statVenueOrder")
        @Results({
                @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
                @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
                @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
                @Result(column="community_type", property="communityType", jdbcType=JdbcType.INTEGER),
                @Result(column="user_count", property="userCount", jdbcType=JdbcType.INTEGER),
                @Result(column="order_count", property="orderCount", jdbcType=JdbcType.INTEGER),
                @Result(column="room_count", property="roomCount", jdbcType=JdbcType.INTEGER),
                @Result(column="stat_time", property="statTime", jdbcType=JdbcType.TIMESTAMP),
                @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
        })
        List<StatVenueOrder> statVenueOrder(@Param("startTime") Date startTime,
                                            @Param("endTime") Date endTime);
}
