package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VenueInfo;
import com.rfchina.community.persistence.model.VenueInfoExample;
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

public interface VenueInfoMapper extends Serializable {
    @SelectProvider(type=VenueInfoSqlProvider.class, method="countByExample")
    long countByExample(VenueInfoExample example);

    @DeleteProvider(type=VenueInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(VenueInfoExample example);

    @Delete({
        "delete from venue_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into venue_info (community_id, service_type, ",
        "title, charge_type, ",
        "reorder, status, ",
        "business_begin, business_end, ",
        "week_part, address, ",
        "intro, def_price, ",
        "ppv)",
        "values (#{communityId,jdbcType=INTEGER}, #{serviceType,jdbcType=INTEGER}, ",
        "#{title,jdbcType=VARCHAR}, #{chargeType,jdbcType=INTEGER}, ",
        "#{reorder,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{businessBegin,jdbcType=VARCHAR}, #{businessEnd,jdbcType=VARCHAR}, ",
        "#{weekPart,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{intro,jdbcType=VARCHAR}, #{defPrice,jdbcType=DECIMAL}, ",
        "#{ppv,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(VenueInfo record);

    @InsertProvider(type=VenueInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(VenueInfo record);

    @SelectProvider(type=VenueInfoSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="service_type", property="serviceType", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="charge_type", property="chargeType", jdbcType=JdbcType.INTEGER),
        @Result(column="reorder", property="reorder", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="business_begin", property="businessBegin", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_end", property="businessEnd", jdbcType=JdbcType.VARCHAR),
        @Result(column="week_part", property="weekPart", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="def_price", property="defPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="ppv", property="ppv", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<VenueInfo> selectByExampleWithBLOBs(VenueInfoExample example);

    @SelectProvider(type=VenueInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="service_type", property="serviceType", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="charge_type", property="chargeType", jdbcType=JdbcType.INTEGER),
        @Result(column="reorder", property="reorder", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="business_begin", property="businessBegin", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_end", property="businessEnd", jdbcType=JdbcType.VARCHAR),
        @Result(column="week_part", property="weekPart", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="def_price", property="defPrice", jdbcType=JdbcType.DECIMAL)
    })
    List<VenueInfo> selectByExample(VenueInfoExample example);

    @Select({
        "select",
        "id, community_id, service_type, title, charge_type, reorder, status, business_begin, ",
        "business_end, week_part, address, intro, def_price, ppv",
        "from venue_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="service_type", property="serviceType", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="charge_type", property="chargeType", jdbcType=JdbcType.INTEGER),
        @Result(column="reorder", property="reorder", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="business_begin", property="businessBegin", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_end", property="businessEnd", jdbcType=JdbcType.VARCHAR),
        @Result(column="week_part", property="weekPart", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="def_price", property="defPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="ppv", property="ppv", jdbcType=JdbcType.LONGVARCHAR)
    })
    VenueInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=VenueInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VenueInfo record, @Param("example") VenueInfoExample example);

    @UpdateProvider(type=VenueInfoSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") VenueInfo record, @Param("example") VenueInfoExample example);

    @UpdateProvider(type=VenueInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VenueInfo record, @Param("example") VenueInfoExample example);

    @UpdateProvider(type=VenueInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VenueInfo record);

    @Update({
        "update venue_info",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "service_type = #{serviceType,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "charge_type = #{chargeType,jdbcType=INTEGER},",
          "reorder = #{reorder,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "business_begin = #{businessBegin,jdbcType=VARCHAR},",
          "business_end = #{businessEnd,jdbcType=VARCHAR},",
          "week_part = #{weekPart,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "intro = #{intro,jdbcType=VARCHAR},",
          "def_price = #{defPrice,jdbcType=DECIMAL},",
          "ppv = #{ppv,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(VenueInfo record);

    @Update({
        "update venue_info",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "service_type = #{serviceType,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "charge_type = #{chargeType,jdbcType=INTEGER},",
          "reorder = #{reorder,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "business_begin = #{businessBegin,jdbcType=VARCHAR},",
          "business_end = #{businessEnd,jdbcType=VARCHAR},",
          "week_part = #{weekPart,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "intro = #{intro,jdbcType=VARCHAR},",
          "def_price = #{defPrice,jdbcType=DECIMAL}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(VenueInfo record);
}