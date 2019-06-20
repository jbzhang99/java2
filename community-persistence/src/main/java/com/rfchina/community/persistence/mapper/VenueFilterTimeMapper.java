package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VenueFilterTime;
import com.rfchina.community.persistence.model.VenueFilterTimeExample;
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

public interface VenueFilterTimeMapper extends Serializable {
    @SelectProvider(type=VenueFilterTimeSqlProvider.class, method="countByExample")
    long countByExample(VenueFilterTimeExample example);

    @DeleteProvider(type=VenueFilterTimeSqlProvider.class, method="deleteByExample")
    int deleteByExample(VenueFilterTimeExample example);

    @Delete({
        "delete from venue_filter_time",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into venue_filter_time (venue_id, filter_type, ",
        "start_date, end_date, filter_date, ",
        "time_slice)",
        "values (#{venueId,jdbcType=BIGINT}, #{filterType,jdbcType=INTEGER}, ",
        "#{startDate,jdbcType=DATE}, #{endDate,jdbcType=DATE}, #{filterDate,jdbcType=DATE}, ",
        "#{timeSlice,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(VenueFilterTime record);

    @InsertProvider(type=VenueFilterTimeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(VenueFilterTime record);

    @SelectProvider(type=VenueFilterTimeSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="venue_id", property="venueId", jdbcType=JdbcType.BIGINT),
        @Result(column="filter_type", property="filterType", jdbcType=JdbcType.INTEGER),
        @Result(column="start_date", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.DATE),
        @Result(column="filter_date", property="filterDate", jdbcType=JdbcType.DATE),
        @Result(column="time_slice", property="timeSlice", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<VenueFilterTime> selectByExampleWithBLOBs(VenueFilterTimeExample example);

    @SelectProvider(type=VenueFilterTimeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="venue_id", property="venueId", jdbcType=JdbcType.BIGINT),
        @Result(column="filter_type", property="filterType", jdbcType=JdbcType.INTEGER),
        @Result(column="start_date", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.DATE),
        @Result(column="filter_date", property="filterDate", jdbcType=JdbcType.DATE)
    })
    List<VenueFilterTime> selectByExample(VenueFilterTimeExample example);

    @Select({
        "select",
        "id, venue_id, filter_type, start_date, end_date, filter_date, time_slice",
        "from venue_filter_time",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="venue_id", property="venueId", jdbcType=JdbcType.BIGINT),
        @Result(column="filter_type", property="filterType", jdbcType=JdbcType.INTEGER),
        @Result(column="start_date", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.DATE),
        @Result(column="filter_date", property="filterDate", jdbcType=JdbcType.DATE),
        @Result(column="time_slice", property="timeSlice", jdbcType=JdbcType.LONGVARCHAR)
    })
    VenueFilterTime selectByPrimaryKey(Long id);

    @UpdateProvider(type=VenueFilterTimeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VenueFilterTime record, @Param("example") VenueFilterTimeExample example);

    @UpdateProvider(type=VenueFilterTimeSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") VenueFilterTime record, @Param("example") VenueFilterTimeExample example);

    @UpdateProvider(type=VenueFilterTimeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VenueFilterTime record, @Param("example") VenueFilterTimeExample example);

    @UpdateProvider(type=VenueFilterTimeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VenueFilterTime record);

    @Update({
        "update venue_filter_time",
        "set venue_id = #{venueId,jdbcType=BIGINT},",
          "filter_type = #{filterType,jdbcType=INTEGER},",
          "start_date = #{startDate,jdbcType=DATE},",
          "end_date = #{endDate,jdbcType=DATE},",
          "filter_date = #{filterDate,jdbcType=DATE},",
          "time_slice = #{timeSlice,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(VenueFilterTime record);

    @Update({
        "update venue_filter_time",
        "set venue_id = #{venueId,jdbcType=BIGINT},",
          "filter_type = #{filterType,jdbcType=INTEGER},",
          "start_date = #{startDate,jdbcType=DATE},",
          "end_date = #{endDate,jdbcType=DATE},",
          "filter_date = #{filterDate,jdbcType=DATE}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(VenueFilterTime record);
}