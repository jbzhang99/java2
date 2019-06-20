package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.WaterSupply;
import com.rfchina.community.persistence.model.WaterSupplyExample;
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

public interface WaterSupplyMapper extends Serializable {
    @SelectProvider(type=WaterSupplySqlProvider.class, method="countByExample")
    long countByExample(WaterSupplyExample example);

    @DeleteProvider(type=WaterSupplySqlProvider.class, method="deleteByExample")
    int deleteByExample(WaterSupplyExample example);

    @Delete({
        "delete from water_supply",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into water_supply (community_id, water_brand_id, ",
        "name, amount, capacity, ",
        "deposit, type, status, ",
        "start_date, end_date, ",
        "num, remark, intro, ",
        "create_time, update_time, ",
        "delete_status, delete_time)",
        "values (#{communityId,jdbcType=INTEGER}, #{waterBrandId,jdbcType=BIGINT}, ",
        "#{name,jdbcType=VARCHAR}, #{amount,jdbcType=DECIMAL}, #{capacity,jdbcType=VARCHAR}, ",
        "#{deposit,jdbcType=DECIMAL}, #{type,jdbcType=TINYINT}, #{status,jdbcType=TINYINT}, ",
        "#{startDate,jdbcType=TIMESTAMP}, #{endDate,jdbcType=TIMESTAMP}, ",
        "#{num,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, #{intro,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{deleteStatus,jdbcType=TINYINT}, #{deleteTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(WaterSupply record);

    @InsertProvider(type=WaterSupplySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(WaterSupply record);

    @SelectProvider(type=WaterSupplySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="water_brand_id", property="waterBrandId", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="capacity", property="capacity", jdbcType=JdbcType.VARCHAR),
        @Result(column="deposit", property="deposit", jdbcType=JdbcType.DECIMAL),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="start_date", property="startDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="delete_status", property="deleteStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="delete_time", property="deleteTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WaterSupply> selectByExample(WaterSupplyExample example);

    @Select({
        "select",
        "id, community_id, water_brand_id, name, amount, capacity, deposit, type, status, ",
        "start_date, end_date, num, remark, intro, create_time, update_time, delete_status, ",
        "delete_time",
        "from water_supply",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="water_brand_id", property="waterBrandId", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="capacity", property="capacity", jdbcType=JdbcType.VARCHAR),
        @Result(column="deposit", property="deposit", jdbcType=JdbcType.DECIMAL),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="start_date", property="startDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="delete_status", property="deleteStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="delete_time", property="deleteTime", jdbcType=JdbcType.TIMESTAMP)
    })
    WaterSupply selectByPrimaryKey(Long id);

    @UpdateProvider(type=WaterSupplySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WaterSupply record, @Param("example") WaterSupplyExample example);

    @UpdateProvider(type=WaterSupplySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WaterSupply record, @Param("example") WaterSupplyExample example);

    @UpdateProvider(type=WaterSupplySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WaterSupply record);

    @Update({
        "update water_supply",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "water_brand_id = #{waterBrandId,jdbcType=BIGINT},",
          "name = #{name,jdbcType=VARCHAR},",
          "amount = #{amount,jdbcType=DECIMAL},",
          "capacity = #{capacity,jdbcType=VARCHAR},",
          "deposit = #{deposit,jdbcType=DECIMAL},",
          "type = #{type,jdbcType=TINYINT},",
          "status = #{status,jdbcType=TINYINT},",
          "start_date = #{startDate,jdbcType=TIMESTAMP},",
          "end_date = #{endDate,jdbcType=TIMESTAMP},",
          "num = #{num,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "intro = #{intro,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "delete_status = #{deleteStatus,jdbcType=TINYINT},",
          "delete_time = #{deleteTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(WaterSupply record);
}