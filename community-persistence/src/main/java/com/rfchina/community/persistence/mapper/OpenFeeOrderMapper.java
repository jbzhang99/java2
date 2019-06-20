package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenFeeOrder;
import com.rfchina.community.persistence.model.OpenFeeOrderExample;
import com.rfchina.community.persistence.model.OpenFeeOrderWithBLOBs;
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

public interface OpenFeeOrderMapper extends Serializable {
    @SelectProvider(type=OpenFeeOrderSqlProvider.class, method="countByExample")
    long countByExample(OpenFeeOrderExample example);

    @DeleteProvider(type=OpenFeeOrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenFeeOrderExample example);

    @Delete({
        "delete from open_fee_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_fee_order (community_id, service_id, ",
        "verify_no, create_time, ",
        "type, order_no, store_order_id, ",
        "trade_amount, platform_charge, ",
        "platform_charge_rate, service_charge, ",
        "service_charge_rate, pay_amount, ",
        "pay_id, pay_status, pay_time, ",
        "order_explain, goods_detail, ",
        "sales_contract)",
        "values (#{communityId,jdbcType=INTEGER}, #{serviceId,jdbcType=INTEGER}, ",
        "#{verifyNo,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{type,jdbcType=CHAR}, #{orderNo,jdbcType=VARCHAR}, #{storeOrderId,jdbcType=INTEGER}, ",
        "#{tradeAmount,jdbcType=DECIMAL}, #{platformCharge,jdbcType=DECIMAL}, ",
        "#{platformChargeRate,jdbcType=DECIMAL}, #{serviceCharge,jdbcType=DECIMAL}, ",
        "#{serviceChargeRate,jdbcType=DECIMAL}, #{payAmount,jdbcType=DECIMAL}, ",
        "#{payId,jdbcType=BIGINT}, #{payStatus,jdbcType=CHAR}, #{payTime,jdbcType=TIMESTAMP}, ",
        "#{orderExplain,jdbcType=VARCHAR}, #{goodsDetail,jdbcType=LONGVARCHAR}, ",
        "#{salesContract,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenFeeOrderWithBLOBs record);

    @InsertProvider(type=OpenFeeOrderSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenFeeOrderWithBLOBs record);

    @SelectProvider(type=OpenFeeOrderSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="verify_no", property="verifyNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="type", property="type", jdbcType=JdbcType.CHAR),
        @Result(column="order_no", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="store_order_id", property="storeOrderId", jdbcType=JdbcType.INTEGER),
        @Result(column="trade_amount", property="tradeAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="platform_charge", property="platformCharge", jdbcType=JdbcType.DECIMAL),
        @Result(column="platform_charge_rate", property="platformChargeRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="service_charge", property="serviceCharge", jdbcType=JdbcType.DECIMAL),
        @Result(column="service_charge_rate", property="serviceChargeRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="pay_amount", property="payAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="pay_id", property="payId", jdbcType=JdbcType.BIGINT),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.CHAR),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="order_explain", property="orderExplain", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_detail", property="goodsDetail", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="sales_contract", property="salesContract", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<OpenFeeOrderWithBLOBs> selectByExampleWithBLOBs(OpenFeeOrderExample example);

    @SelectProvider(type=OpenFeeOrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="verify_no", property="verifyNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="type", property="type", jdbcType=JdbcType.CHAR),
        @Result(column="order_no", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="store_order_id", property="storeOrderId", jdbcType=JdbcType.INTEGER),
        @Result(column="trade_amount", property="tradeAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="platform_charge", property="platformCharge", jdbcType=JdbcType.DECIMAL),
        @Result(column="platform_charge_rate", property="platformChargeRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="service_charge", property="serviceCharge", jdbcType=JdbcType.DECIMAL),
        @Result(column="service_charge_rate", property="serviceChargeRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="pay_amount", property="payAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="pay_id", property="payId", jdbcType=JdbcType.BIGINT),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.CHAR),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="order_explain", property="orderExplain", jdbcType=JdbcType.VARCHAR)
    })
    List<OpenFeeOrder> selectByExample(OpenFeeOrderExample example);

    @Select({
        "select",
        "id, community_id, service_id, verify_no, create_time, type, order_no, store_order_id, ",
        "trade_amount, platform_charge, platform_charge_rate, service_charge, service_charge_rate, ",
        "pay_amount, pay_id, pay_status, pay_time, order_explain, goods_detail, sales_contract",
        "from open_fee_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="verify_no", property="verifyNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="type", property="type", jdbcType=JdbcType.CHAR),
        @Result(column="order_no", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="store_order_id", property="storeOrderId", jdbcType=JdbcType.INTEGER),
        @Result(column="trade_amount", property="tradeAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="platform_charge", property="platformCharge", jdbcType=JdbcType.DECIMAL),
        @Result(column="platform_charge_rate", property="platformChargeRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="service_charge", property="serviceCharge", jdbcType=JdbcType.DECIMAL),
        @Result(column="service_charge_rate", property="serviceChargeRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="pay_amount", property="payAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="pay_id", property="payId", jdbcType=JdbcType.BIGINT),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.CHAR),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="order_explain", property="orderExplain", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_detail", property="goodsDetail", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="sales_contract", property="salesContract", jdbcType=JdbcType.LONGVARCHAR)
    })
    OpenFeeOrderWithBLOBs selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenFeeOrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenFeeOrderWithBLOBs record, @Param("example") OpenFeeOrderExample example);

    @UpdateProvider(type=OpenFeeOrderSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") OpenFeeOrderWithBLOBs record, @Param("example") OpenFeeOrderExample example);

    @UpdateProvider(type=OpenFeeOrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenFeeOrder record, @Param("example") OpenFeeOrderExample example);

    @UpdateProvider(type=OpenFeeOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenFeeOrderWithBLOBs record);

    @Update({
        "update open_fee_order",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "service_id = #{serviceId,jdbcType=INTEGER},",
          "verify_no = #{verifyNo,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "type = #{type,jdbcType=CHAR},",
          "order_no = #{orderNo,jdbcType=VARCHAR},",
          "store_order_id = #{storeOrderId,jdbcType=INTEGER},",
          "trade_amount = #{tradeAmount,jdbcType=DECIMAL},",
          "platform_charge = #{platformCharge,jdbcType=DECIMAL},",
          "platform_charge_rate = #{platformChargeRate,jdbcType=DECIMAL},",
          "service_charge = #{serviceCharge,jdbcType=DECIMAL},",
          "service_charge_rate = #{serviceChargeRate,jdbcType=DECIMAL},",
          "pay_amount = #{payAmount,jdbcType=DECIMAL},",
          "pay_id = #{payId,jdbcType=BIGINT},",
          "pay_status = #{payStatus,jdbcType=CHAR},",
          "pay_time = #{payTime,jdbcType=TIMESTAMP},",
          "order_explain = #{orderExplain,jdbcType=VARCHAR},",
          "goods_detail = #{goodsDetail,jdbcType=LONGVARCHAR},",
          "sales_contract = #{salesContract,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(OpenFeeOrderWithBLOBs record);

    @Update({
        "update open_fee_order",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "service_id = #{serviceId,jdbcType=INTEGER},",
          "verify_no = #{verifyNo,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "type = #{type,jdbcType=CHAR},",
          "order_no = #{orderNo,jdbcType=VARCHAR},",
          "store_order_id = #{storeOrderId,jdbcType=INTEGER},",
          "trade_amount = #{tradeAmount,jdbcType=DECIMAL},",
          "platform_charge = #{platformCharge,jdbcType=DECIMAL},",
          "platform_charge_rate = #{platformChargeRate,jdbcType=DECIMAL},",
          "service_charge = #{serviceCharge,jdbcType=DECIMAL},",
          "service_charge_rate = #{serviceChargeRate,jdbcType=DECIMAL},",
          "pay_amount = #{payAmount,jdbcType=DECIMAL},",
          "pay_id = #{payId,jdbcType=BIGINT},",
          "pay_status = #{payStatus,jdbcType=CHAR},",
          "pay_time = #{payTime,jdbcType=TIMESTAMP},",
          "order_explain = #{orderExplain,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenFeeOrder record);
}