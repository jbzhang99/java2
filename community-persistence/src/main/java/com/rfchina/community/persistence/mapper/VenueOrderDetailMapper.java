package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VenueOrderDetail;
import com.rfchina.community.persistence.model.VenueOrderDetailExample;
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

public interface VenueOrderDetailMapper extends Serializable {
    @SelectProvider(type=VenueOrderDetailSqlProvider.class, method="countByExample")
    long countByExample(VenueOrderDetailExample example);

    @DeleteProvider(type=VenueOrderDetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(VenueOrderDetailExample example);

    @Delete({
        "delete from venue_order_detail",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into venue_order_detail (order_id, venue_id, ",
        "week, time_slice, ",
        "play_date, price)",
        "values (#{orderId,jdbcType=BIGINT}, #{venueId,jdbcType=BIGINT}, ",
        "#{week,jdbcType=INTEGER}, #{timeSlice,jdbcType=VARCHAR}, ",
        "#{playDate,jdbcType=DATE}, #{price,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(VenueOrderDetail record);

    @InsertProvider(type=VenueOrderDetailSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(VenueOrderDetail record);

    @SelectProvider(type=VenueOrderDetailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT),
        @Result(column="venue_id", property="venueId", jdbcType=JdbcType.BIGINT),
        @Result(column="week", property="week", jdbcType=JdbcType.INTEGER),
        @Result(column="time_slice", property="timeSlice", jdbcType=JdbcType.VARCHAR),
        @Result(column="play_date", property="playDate", jdbcType=JdbcType.DATE),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL)
    })
    List<VenueOrderDetail> selectByExample(VenueOrderDetailExample example);

    @Select({
        "select",
        "id, order_id, venue_id, week, time_slice, play_date, price",
        "from venue_order_detail",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT),
        @Result(column="venue_id", property="venueId", jdbcType=JdbcType.BIGINT),
        @Result(column="week", property="week", jdbcType=JdbcType.INTEGER),
        @Result(column="time_slice", property="timeSlice", jdbcType=JdbcType.VARCHAR),
        @Result(column="play_date", property="playDate", jdbcType=JdbcType.DATE),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL)
    })
    VenueOrderDetail selectByPrimaryKey(Long id);

    @UpdateProvider(type=VenueOrderDetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VenueOrderDetail record, @Param("example") VenueOrderDetailExample example);

    @UpdateProvider(type=VenueOrderDetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VenueOrderDetail record, @Param("example") VenueOrderDetailExample example);

    @UpdateProvider(type=VenueOrderDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VenueOrderDetail record);

    @Update({
        "update venue_order_detail",
        "set order_id = #{orderId,jdbcType=BIGINT},",
          "venue_id = #{venueId,jdbcType=BIGINT},",
          "week = #{week,jdbcType=INTEGER},",
          "time_slice = #{timeSlice,jdbcType=VARCHAR},",
          "play_date = #{playDate,jdbcType=DATE},",
          "price = #{price,jdbcType=DECIMAL}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(VenueOrderDetail record);
}