package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.StatRepairOrder;
import com.rfchina.community.persistence.model.StatRepairOrderExample;
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

public interface StatRepairOrderMapper extends Serializable {
    @SelectProvider(type=StatRepairOrderSqlProvider.class, method="countByExample")
    long countByExample(StatRepairOrderExample example);

    @DeleteProvider(type=StatRepairOrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(StatRepairOrderExample example);

    @Delete({
        "delete from stat_repair_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into stat_repair_order (area_id, community_id, ",
        "community_type, repair_user_count, ",
        "repair_room_count, repair_order_count, ",
        "issue_user_count, issue_room_count, ",
        "issue_order_count, stat_time, ",
        "create_time)",
        "values (#{areaId,jdbcType=INTEGER}, #{communityId,jdbcType=INTEGER}, ",
        "#{communityType,jdbcType=INTEGER}, #{repairUserCount,jdbcType=INTEGER}, ",
        "#{repairRoomCount,jdbcType=INTEGER}, #{repairOrderCount,jdbcType=INTEGER}, ",
        "#{issueUserCount,jdbcType=INTEGER}, #{issueRoomCount,jdbcType=INTEGER}, ",
        "#{issueOrderCount,jdbcType=INTEGER}, #{statTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(StatRepairOrder record);

    @InsertProvider(type=StatRepairOrderSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(StatRepairOrder record);

    @SelectProvider(type=StatRepairOrderSqlProvider.class, method="selectByExample")
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
    List<StatRepairOrder> selectByExample(StatRepairOrderExample example);

    @Select({
        "select",
        "id, area_id, community_id, community_type, repair_user_count, repair_room_count, ",
        "repair_order_count, issue_user_count, issue_room_count, issue_order_count, stat_time, ",
        "create_time",
        "from stat_repair_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
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
    StatRepairOrder selectByPrimaryKey(Long id);

    @UpdateProvider(type=StatRepairOrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StatRepairOrder record, @Param("example") StatRepairOrderExample example);

    @UpdateProvider(type=StatRepairOrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StatRepairOrder record, @Param("example") StatRepairOrderExample example);

    @UpdateProvider(type=StatRepairOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StatRepairOrder record);

    @Update({
        "update stat_repair_order",
        "set area_id = #{areaId,jdbcType=INTEGER},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "community_type = #{communityType,jdbcType=INTEGER},",
          "repair_user_count = #{repairUserCount,jdbcType=INTEGER},",
          "repair_room_count = #{repairRoomCount,jdbcType=INTEGER},",
          "repair_order_count = #{repairOrderCount,jdbcType=INTEGER},",
          "issue_user_count = #{issueUserCount,jdbcType=INTEGER},",
          "issue_room_count = #{issueRoomCount,jdbcType=INTEGER},",
          "issue_order_count = #{issueOrderCount,jdbcType=INTEGER},",
          "stat_time = #{statTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(StatRepairOrder record);
}