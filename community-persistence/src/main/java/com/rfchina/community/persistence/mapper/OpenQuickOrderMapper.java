package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenQuickOrder;
import com.rfchina.community.persistence.model.OpenQuickOrderExample;
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

public interface OpenQuickOrderMapper extends Serializable {
    @SelectProvider(type=OpenQuickOrderSqlProvider.class, method="countByExample")
    long countByExample(OpenQuickOrderExample example);

    @DeleteProvider(type=OpenQuickOrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenQuickOrderExample example);

    @Delete({
        "delete from open_quick_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_quick_order (uid, community_id, ",
        "service_id, total_money, ",
        "subtract_money, coupon_money, ",
        "real_money, coupon_id, ",
        "bill_status, out_trade_no, ",
        "community_trade_no, bill_id, ",
        "create_time, pay_time)",
        "values (#{uid,jdbcType=BIGINT}, #{communityId,jdbcType=INTEGER}, ",
        "#{serviceId,jdbcType=INTEGER}, #{totalMoney,jdbcType=DECIMAL}, ",
        "#{subtractMoney,jdbcType=DECIMAL}, #{couponMoney,jdbcType=DECIMAL}, ",
        "#{realMoney,jdbcType=DECIMAL}, #{couponId,jdbcType=BIGINT}, ",
        "#{billStatus,jdbcType=INTEGER}, #{outTradeNo,jdbcType=VARCHAR}, ",
        "#{communityTradeNo,jdbcType=VARCHAR}, #{billId,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{payTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenQuickOrder record);

    @InsertProvider(type=OpenQuickOrderSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenQuickOrder record);

    @SelectProvider(type=OpenQuickOrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="total_money", property="totalMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="subtract_money", property="subtractMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="coupon_money", property="couponMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="real_money", property="realMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="coupon_id", property="couponId", jdbcType=JdbcType.BIGINT),
        @Result(column="bill_status", property="billStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_trade_no", property="communityTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenQuickOrder> selectByExample(OpenQuickOrderExample example);

    @Select({
        "select",
        "id, uid, community_id, service_id, total_money, subtract_money, coupon_money, ",
        "real_money, coupon_id, bill_status, out_trade_no, community_trade_no, bill_id, ",
        "create_time, pay_time",
        "from open_quick_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="total_money", property="totalMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="subtract_money", property="subtractMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="coupon_money", property="couponMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="real_money", property="realMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="coupon_id", property="couponId", jdbcType=JdbcType.BIGINT),
        @Result(column="bill_status", property="billStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_trade_no", property="communityTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenQuickOrder selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenQuickOrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenQuickOrder record, @Param("example") OpenQuickOrderExample example);

    @UpdateProvider(type=OpenQuickOrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenQuickOrder record, @Param("example") OpenQuickOrderExample example);

    @UpdateProvider(type=OpenQuickOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenQuickOrder record);

    @Update({
        "update open_quick_order",
        "set uid = #{uid,jdbcType=BIGINT},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "service_id = #{serviceId,jdbcType=INTEGER},",
          "total_money = #{totalMoney,jdbcType=DECIMAL},",
          "subtract_money = #{subtractMoney,jdbcType=DECIMAL},",
          "coupon_money = #{couponMoney,jdbcType=DECIMAL},",
          "real_money = #{realMoney,jdbcType=DECIMAL},",
          "coupon_id = #{couponId,jdbcType=BIGINT},",
          "bill_status = #{billStatus,jdbcType=INTEGER},",
          "out_trade_no = #{outTradeNo,jdbcType=VARCHAR},",
          "community_trade_no = #{communityTradeNo,jdbcType=VARCHAR},",
          "bill_id = #{billId,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "pay_time = #{payTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenQuickOrder record);
}