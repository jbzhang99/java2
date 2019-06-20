package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.model.StatRepairOrder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/**
 */
public interface ExtStatRepairOrderMapper {

    @SelectProvider(type=ExtStatRepairOrderSqlProvider.class, method="statRepairOrder")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
            @Result(column="community_type", property="communityType", jdbcType=JdbcType.INTEGER),
            @Result(column="repair_user_count", property="repairUserCount", jdbcType=JdbcType.INTEGER),
            @Result(column="repair_room_count", property="repairRoomCount", jdbcType=JdbcType.INTEGER),
            @Result(column="repair_order_count", property="repairOrderCount", jdbcType=JdbcType.INTEGER),
            @Result(column="issue_user_count", property="issueUserCount", jdbcType=JdbcType.INTEGER),
            @Result(column="issue_room_count", property="issueRoomCount", jdbcType=JdbcType.INTEGER),
            @Result(column="issue_order_count", property="issueOrderCount", jdbcType=JdbcType.INTEGER),
            @Result(column="stat_time", property="statTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<StatRepairOrder> statRepairOrder(@Param("startTime") Date startTime,
                                          @Param("endTime") Date endTime);
}
