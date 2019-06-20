package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VenueHoliday;
import com.rfchina.community.persistence.model.VenueHolidayExample;
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

public interface VenueHolidayMapper extends Serializable {
    @SelectProvider(type=VenueHolidaySqlProvider.class, method="countByExample")
    long countByExample(VenueHolidayExample example);

    @DeleteProvider(type=VenueHolidaySqlProvider.class, method="deleteByExample")
    int deleteByExample(VenueHolidayExample example);

    @Delete({
        "delete from venue_holiday",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into venue_holiday (community_id, holiday, ",
        "title)",
        "values (#{communityId,jdbcType=INTEGER}, #{holiday,jdbcType=DATE}, ",
        "#{title,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(VenueHoliday record);

    @InsertProvider(type=VenueHolidaySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(VenueHoliday record);

    @SelectProvider(type=VenueHolidaySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="holiday", property="holiday", jdbcType=JdbcType.DATE),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR)
    })
    List<VenueHoliday> selectByExample(VenueHolidayExample example);

    @Select({
        "select",
        "id, community_id, holiday, title",
        "from venue_holiday",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="holiday", property="holiday", jdbcType=JdbcType.DATE),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR)
    })
    VenueHoliday selectByPrimaryKey(Long id);

    @UpdateProvider(type=VenueHolidaySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VenueHoliday record, @Param("example") VenueHolidayExample example);

    @UpdateProvider(type=VenueHolidaySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VenueHoliday record, @Param("example") VenueHolidayExample example);

    @UpdateProvider(type=VenueHolidaySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VenueHoliday record);

    @Update({
        "update venue_holiday",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "holiday = #{holiday,jdbcType=DATE},",
          "title = #{title,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(VenueHoliday record);
}