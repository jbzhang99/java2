package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VenuePrice;
import com.rfchina.community.persistence.model.VenuePriceExample;
import com.rfchina.community.persistence.model.VenuePriceKey;
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

public interface VenuePriceMapper extends Serializable {
    @SelectProvider(type=VenuePriceSqlProvider.class, method="countByExample")
    long countByExample(VenuePriceExample example);

    @DeleteProvider(type=VenuePriceSqlProvider.class, method="deleteByExample")
    int deleteByExample(VenuePriceExample example);

    @Delete({
        "delete from venue_price",
        "where venue_id = #{venueId,jdbcType=BIGINT}",
          "and week = #{week,jdbcType=INTEGER}",
          "and time_slice = #{timeSlice,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(VenuePriceKey key);

    @Insert({
        "insert into venue_price (venue_id, week, ",
        "time_slice, price)",
        "values (#{venueId,jdbcType=BIGINT}, #{week,jdbcType=INTEGER}, ",
        "#{timeSlice,jdbcType=VARCHAR}, #{price,jdbcType=DECIMAL})"
    })
    int insert(VenuePrice record);

    @InsertProvider(type=VenuePriceSqlProvider.class, method="insertSelective")
    int insertSelective(VenuePrice record);

    @SelectProvider(type=VenuePriceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="venue_id", property="venueId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="week", property="week", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="time_slice", property="timeSlice", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL)
    })
    List<VenuePrice> selectByExample(VenuePriceExample example);

    @Select({
        "select",
        "venue_id, week, time_slice, price",
        "from venue_price",
        "where venue_id = #{venueId,jdbcType=BIGINT}",
          "and week = #{week,jdbcType=INTEGER}",
          "and time_slice = #{timeSlice,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="venue_id", property="venueId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="week", property="week", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="time_slice", property="timeSlice", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL)
    })
    VenuePrice selectByPrimaryKey(VenuePriceKey key);

    @UpdateProvider(type=VenuePriceSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VenuePrice record, @Param("example") VenuePriceExample example);

    @UpdateProvider(type=VenuePriceSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VenuePrice record, @Param("example") VenuePriceExample example);

    @UpdateProvider(type=VenuePriceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VenuePrice record);

    @Update({
        "update venue_price",
        "set price = #{price,jdbcType=DECIMAL}",
        "where venue_id = #{venueId,jdbcType=BIGINT}",
          "and week = #{week,jdbcType=INTEGER}",
          "and time_slice = #{timeSlice,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(VenuePrice record);
}