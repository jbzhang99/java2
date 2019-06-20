package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VenueLock;
import com.rfchina.community.persistence.model.VenueLockExample;
import com.rfchina.community.persistence.model.VenueLockKey;
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
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface VenueLockMapper extends Serializable {
    @SelectProvider(type=VenueLockSqlProvider.class, method="countByExample")
    long countByExample(VenueLockExample example);

    @DeleteProvider(type=VenueLockSqlProvider.class, method="deleteByExample")
    int deleteByExample(VenueLockExample example);

    @Delete({
        "delete from venue_lock",
        "where venue_id = #{venueId,jdbcType=BIGINT}",
          "and time_slice = #{timeSlice,jdbcType=VARCHAR}",
          "and play_date = #{playDate,jdbcType=DATE}"
    })
    int deleteByPrimaryKey(VenueLockKey key);

    @Insert({
        "insert into venue_lock (venue_id, time_slice, ",
        "play_date, week, order_id, ",
        "create_time, uuid)",
        "values (#{venueId,jdbcType=BIGINT}, #{timeSlice,jdbcType=VARCHAR}, ",
        "#{playDate,jdbcType=DATE}, #{week,jdbcType=INTEGER}, #{orderId,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{uuid,jdbcType=VARCHAR})"
    })
    int insert(VenueLock record);

    @InsertProvider(type=VenueLockSqlProvider.class, method="insertSelective")
    int insertSelective(VenueLock record);

    @SelectProvider(type=VenueLockSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="venue_id", property="venueId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="time_slice", property="timeSlice", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="play_date", property="playDate", jdbcType=JdbcType.DATE, id=true),
        @Result(column="week", property="week", jdbcType=JdbcType.INTEGER),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.VARCHAR)
    })
    List<VenueLock> selectByExample(VenueLockExample example);

    @Select({
        "select",
        "venue_id, time_slice, play_date, week, order_id, create_time, uuid",
        "from venue_lock",
        "where venue_id = #{venueId,jdbcType=BIGINT}",
          "and time_slice = #{timeSlice,jdbcType=VARCHAR}",
          "and play_date = #{playDate,jdbcType=DATE}"
    })
    @Results({
        @Result(column="venue_id", property="venueId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="time_slice", property="timeSlice", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="play_date", property="playDate", jdbcType=JdbcType.DATE, id=true),
        @Result(column="week", property="week", jdbcType=JdbcType.INTEGER),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.VARCHAR)
    })
    VenueLock selectByPrimaryKey(VenueLockKey key);

    @UpdateProvider(type=VenueLockSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VenueLock record, @Param("example") VenueLockExample example);

    @UpdateProvider(type=VenueLockSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VenueLock record, @Param("example") VenueLockExample example);

    @UpdateProvider(type=VenueLockSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VenueLock record);

    @Update({
        "update venue_lock",
        "set week = #{week,jdbcType=INTEGER},",
          "order_id = #{orderId,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "uuid = #{uuid,jdbcType=VARCHAR}",
        "where venue_id = #{venueId,jdbcType=BIGINT}",
          "and time_slice = #{timeSlice,jdbcType=VARCHAR}",
          "and play_date = #{playDate,jdbcType=DATE}"
    })
    int updateByPrimaryKey(VenueLock record);
}