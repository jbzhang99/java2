package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.StatVenueOrder;
import com.rfchina.community.persistence.model.StatVenueOrderExample;
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

public interface StatVenueOrderMapper extends Serializable {
    @SelectProvider(type=StatVenueOrderSqlProvider.class, method="countByExample")
    long countByExample(StatVenueOrderExample example);

    @DeleteProvider(type=StatVenueOrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(StatVenueOrderExample example);

    @Delete({
        "delete from stat_venue_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into stat_venue_order (area_id, community_id, ",
        "community_type, user_count, ",
        "order_count, room_count, ",
        "stat_time, create_time)",
        "values (#{areaId,jdbcType=INTEGER}, #{communityId,jdbcType=INTEGER}, ",
        "#{communityType,jdbcType=INTEGER}, #{userCount,jdbcType=INTEGER}, ",
        "#{orderCount,jdbcType=INTEGER}, #{roomCount,jdbcType=INTEGER}, ",
        "#{statTime,jdbcType=TIMESTAMP}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(StatVenueOrder record);

    @InsertProvider(type=StatVenueOrderSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(StatVenueOrder record);

    @SelectProvider(type=StatVenueOrderSqlProvider.class, method="selectByExample")
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
    List<StatVenueOrder> selectByExample(StatVenueOrderExample example);

    @Select({
        "select",
        "id, area_id, community_id, community_type, user_count, order_count, room_count, ",
        "stat_time, create_time",
        "from stat_venue_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
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
    StatVenueOrder selectByPrimaryKey(Long id);

    @UpdateProvider(type=StatVenueOrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StatVenueOrder record, @Param("example") StatVenueOrderExample example);

    @UpdateProvider(type=StatVenueOrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StatVenueOrder record, @Param("example") StatVenueOrderExample example);

    @UpdateProvider(type=StatVenueOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StatVenueOrder record);

    @Update({
        "update stat_venue_order",
        "set area_id = #{areaId,jdbcType=INTEGER},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "community_type = #{communityType,jdbcType=INTEGER},",
          "user_count = #{userCount,jdbcType=INTEGER},",
          "order_count = #{orderCount,jdbcType=INTEGER},",
          "room_count = #{roomCount,jdbcType=INTEGER},",
          "stat_time = #{statTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(StatVenueOrder record);
}