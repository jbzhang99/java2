package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.WaterDeposit;
import com.rfchina.community.persistence.model.WaterDepositExample;
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

public interface WaterDepositMapper extends Serializable {
    @SelectProvider(type=WaterDepositSqlProvider.class, method="countByExample")
    long countByExample(WaterDepositExample example);

    @DeleteProvider(type=WaterDepositSqlProvider.class, method="deleteByExample")
    int deleteByExample(WaterDepositExample example);

    @Delete({
        "delete from water_deposit",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into water_deposit (supply_id, community_id, ",
        "room_id, room_owner, ",
        "contact, phone, ",
        "tel, amount, type, ",
        "status, pay_time, ",
        "refund_time, remark, ",
        "create_time, update_time)",
        "values (#{supplyId,jdbcType=BIGINT}, #{communityId,jdbcType=INTEGER}, ",
        "#{roomId,jdbcType=INTEGER}, #{roomOwner,jdbcType=VARCHAR}, ",
        "#{contact,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, ",
        "#{tel,jdbcType=VARCHAR}, #{amount,jdbcType=DECIMAL}, #{type,jdbcType=TINYINT}, ",
        "#{status,jdbcType=TINYINT}, #{payTime,jdbcType=TIMESTAMP}, ",
        "#{refundTime,jdbcType=TIMESTAMP}, #{remark,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(WaterDeposit record);

    @InsertProvider(type=WaterDepositSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(WaterDeposit record);

    @SelectProvider(type=WaterDepositSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="supply_id", property="supplyId", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="room_id", property="roomId", jdbcType=JdbcType.INTEGER),
        @Result(column="room_owner", property="roomOwner", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="refund_time", property="refundTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WaterDeposit> selectByExample(WaterDepositExample example);

    @Select({
        "select",
        "id, supply_id, community_id, room_id, room_owner, contact, phone, tel, amount, ",
        "type, status, pay_time, refund_time, remark, create_time, update_time",
        "from water_deposit",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="supply_id", property="supplyId", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="room_id", property="roomId", jdbcType=JdbcType.INTEGER),
        @Result(column="room_owner", property="roomOwner", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="refund_time", property="refundTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    WaterDeposit selectByPrimaryKey(Long id);

    @UpdateProvider(type=WaterDepositSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WaterDeposit record, @Param("example") WaterDepositExample example);

    @UpdateProvider(type=WaterDepositSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WaterDeposit record, @Param("example") WaterDepositExample example);

    @UpdateProvider(type=WaterDepositSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WaterDeposit record);

    @Update({
        "update water_deposit",
        "set supply_id = #{supplyId,jdbcType=BIGINT},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "room_id = #{roomId,jdbcType=INTEGER},",
          "room_owner = #{roomOwner,jdbcType=VARCHAR},",
          "contact = #{contact,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "amount = #{amount,jdbcType=DECIMAL},",
          "type = #{type,jdbcType=TINYINT},",
          "status = #{status,jdbcType=TINYINT},",
          "pay_time = #{payTime,jdbcType=TIMESTAMP},",
          "refund_time = #{refundTime,jdbcType=TIMESTAMP},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(WaterDeposit record);
}