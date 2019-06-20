package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.StatWaterOrder;
import com.rfchina.community.persistence.model.StatWaterOrderExample;
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

public interface StatWaterOrderMapper extends Serializable {
    @SelectProvider(type=StatWaterOrderSqlProvider.class, method="countByExample")
    long countByExample(StatWaterOrderExample example);

    @DeleteProvider(type=StatWaterOrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(StatWaterOrderExample example);

    @Delete({
        "delete from stat_water_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into stat_water_order (area_id, community_id, ",
        "community_type, user_count, ",
        "room_count, order_count, ",
        "bucket_count, stat_time, ",
        "create_time)",
        "values (#{areaId,jdbcType=INTEGER}, #{communityId,jdbcType=INTEGER}, ",
        "#{communityType,jdbcType=INTEGER}, #{userCount,jdbcType=INTEGER}, ",
        "#{roomCount,jdbcType=INTEGER}, #{orderCount,jdbcType=INTEGER}, ",
        "#{bucketCount,jdbcType=INTEGER}, #{statTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(StatWaterOrder record);

    @InsertProvider(type=StatWaterOrderSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(StatWaterOrder record);

    @SelectProvider(type=StatWaterOrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
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
    List<StatWaterOrder> selectByExample(StatWaterOrderExample example);

    @Select({
        "select",
        "id, area_id, community_id, community_type, user_count, room_count, order_count, ",
        "bucket_count, stat_time, create_time",
        "from stat_water_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
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
    StatWaterOrder selectByPrimaryKey(Long id);

    @UpdateProvider(type=StatWaterOrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StatWaterOrder record, @Param("example") StatWaterOrderExample example);

    @UpdateProvider(type=StatWaterOrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StatWaterOrder record, @Param("example") StatWaterOrderExample example);

    @UpdateProvider(type=StatWaterOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StatWaterOrder record);

    @Update({
        "update stat_water_order",
        "set area_id = #{areaId,jdbcType=INTEGER},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "community_type = #{communityType,jdbcType=INTEGER},",
          "user_count = #{userCount,jdbcType=INTEGER},",
          "room_count = #{roomCount,jdbcType=INTEGER},",
          "order_count = #{orderCount,jdbcType=INTEGER},",
          "bucket_count = #{bucketCount,jdbcType=INTEGER},",
          "stat_time = #{statTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(StatWaterOrder record);
}