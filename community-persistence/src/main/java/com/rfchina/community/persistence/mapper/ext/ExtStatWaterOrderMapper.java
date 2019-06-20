package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.model.StatWaterOrder;
import com.rfchina.community.persistence.model.StatWaterTicketOrder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/**
 */
public interface ExtStatWaterOrderMapper {

    @SelectProvider(type=ExtStatWaterOrderSqlProvider.class, method="statWaterOrder")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
            @Result(column="community_type", property="communityType", jdbcType=JdbcType.INTEGER),
            @Result(column="user_count", property="userCount", jdbcType=JdbcType.INTEGER),
            @Result(column="room_count", property="roomCount", jdbcType=JdbcType.INTEGER),
            @Result(column="order_count", property="orderCount", jdbcType=JdbcType.INTEGER),
            @Result(column="bucket_count", property="bucketCount", jdbcType=JdbcType.INTEGER),
            @Result(column="stat_time", property="statTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<StatWaterOrder> statWaterOrder(@Param("startTime") Date startTime,
                                        @Param("endTime") Date endTime);

    @SelectProvider(type=ExtStatWaterOrderSqlProvider.class, method="statWaterTicketOrder")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
            @Result(column="community_type", property="communityType", jdbcType=JdbcType.INTEGER),
            @Result(column="user_count", property="userCount", jdbcType=JdbcType.INTEGER),
            @Result(column="room_count", property="roomCount", jdbcType=JdbcType.INTEGER),
            @Result(column="order_count", property="orderCount", jdbcType=JdbcType.INTEGER),
            @Result(column="ticket_count", property="ticketCount", jdbcType=JdbcType.INTEGER),
            @Result(column="fee_count", property="feeCount", jdbcType=JdbcType.VARCHAR),
            @Result(column="stat_time", property="statTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<StatWaterTicketOrder> statWaterTicketOrder(@Param("startTime") Date startTime,
                                                    @Param("endTime") Date endTime);
}
