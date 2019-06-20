package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.ParkingOrder;
import com.rfchina.community.persistence.model.ParkingOrderExample;
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

public interface ParkingOrderMapper extends Serializable {
    @SelectProvider(type=ParkingOrderSqlProvider.class, method="countByExample")
    long countByExample(ParkingOrderExample example);

    @DeleteProvider(type=ParkingOrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(ParkingOrderExample example);

    @Delete({
        "delete from parking_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into parking_order (community_id, serial_no, ",
        "mobile, uid, car_plate_no, ",
        "card_no, order_type, ",
        "order_status, pay_status, ",
        "pay_type, pay_time, ",
        "pay_amount, pay_price, ",
        "pay_src, wx_openid, ",
        "duration, free_duration, ",
        "address, enter_time, ",
        "cancel_time, monthly_pay_num, ",
        "monthly_pay_start_time, monthly_pay_end_time, ",
        "rfpay_bill_id, rfpay_trade_no, ",
        "rfpay_body, rfpay_type, ",
        "rfpay_create_time, rfpay_close_time, ",
        "rfpay_account, rfpay_fee_rate, ",
        "rfpay_clearing_fee, rfpay_actual_clearing_fee, ",
        "prv_uid, create_time, ",
        "update_time)",
        "values (#{communityId,jdbcType=INTEGER}, #{serialNo,jdbcType=VARCHAR}, ",
        "#{mobile,jdbcType=VARCHAR}, #{uid,jdbcType=BIGINT}, #{carPlateNo,jdbcType=VARCHAR}, ",
        "#{cardNo,jdbcType=VARCHAR}, #{orderType,jdbcType=INTEGER}, ",
        "#{orderStatus,jdbcType=INTEGER}, #{payStatus,jdbcType=INTEGER}, ",
        "#{payType,jdbcType=VARCHAR}, #{payTime,jdbcType=TIMESTAMP}, ",
        "#{payAmount,jdbcType=DECIMAL}, #{payPrice,jdbcType=VARCHAR}, ",
        "#{paySrc,jdbcType=INTEGER}, #{wxOpenid,jdbcType=VARCHAR}, ",
        "#{duration,jdbcType=VARCHAR}, #{freeDuration,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{enterTime,jdbcType=TIMESTAMP}, ",
        "#{cancelTime,jdbcType=TIMESTAMP}, #{monthlyPayNum,jdbcType=INTEGER}, ",
        "#{monthlyPayStartTime,jdbcType=VARCHAR}, #{monthlyPayEndTime,jdbcType=VARCHAR}, ",
        "#{rfpayBillId,jdbcType=VARCHAR}, #{rfpayTradeNo,jdbcType=VARCHAR}, ",
        "#{rfpayBody,jdbcType=VARCHAR}, #{rfpayType,jdbcType=VARCHAR}, ",
        "#{rfpayCreateTime,jdbcType=TIMESTAMP}, #{rfpayCloseTime,jdbcType=TIMESTAMP}, ",
        "#{rfpayAccount,jdbcType=VARCHAR}, #{rfpayFeeRate,jdbcType=DECIMAL}, ",
        "#{rfpayClearingFee,jdbcType=DECIMAL}, #{rfpayActualClearingFee,jdbcType=BIGINT}, ",
        "#{prvUid,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ParkingOrder record);

    @InsertProvider(type=ParkingOrderSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ParkingOrder record);

    @SelectProvider(type=ParkingOrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="serial_no", property="serialNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="car_plate_no", property="carPlateNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_no", property="cardNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_type", property="orderType", jdbcType=JdbcType.INTEGER),
        @Result(column="order_status", property="orderStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_type", property="payType", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pay_amount", property="payAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="pay_price", property="payPrice", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_src", property="paySrc", jdbcType=JdbcType.INTEGER),
        @Result(column="wx_openid", property="wxOpenid", jdbcType=JdbcType.VARCHAR),
        @Result(column="duration", property="duration", jdbcType=JdbcType.VARCHAR),
        @Result(column="free_duration", property="freeDuration", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="enter_time", property="enterTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="cancel_time", property="cancelTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="monthly_pay_num", property="monthlyPayNum", jdbcType=JdbcType.INTEGER),
        @Result(column="monthly_pay_start_time", property="monthlyPayStartTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="monthly_pay_end_time", property="monthlyPayEndTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="rfpay_bill_id", property="rfpayBillId", jdbcType=JdbcType.VARCHAR),
        @Result(column="rfpay_trade_no", property="rfpayTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="rfpay_body", property="rfpayBody", jdbcType=JdbcType.VARCHAR),
        @Result(column="rfpay_type", property="rfpayType", jdbcType=JdbcType.VARCHAR),
        @Result(column="rfpay_create_time", property="rfpayCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="rfpay_close_time", property="rfpayCloseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="rfpay_account", property="rfpayAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="rfpay_fee_rate", property="rfpayFeeRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="rfpay_clearing_fee", property="rfpayClearingFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="rfpay_actual_clearing_fee", property="rfpayActualClearingFee", jdbcType=JdbcType.BIGINT),
        @Result(column="prv_uid", property="prvUid", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ParkingOrder> selectByExample(ParkingOrderExample example);

    @Select({
        "select",
        "id, community_id, serial_no, mobile, uid, car_plate_no, card_no, order_type, ",
        "order_status, pay_status, pay_type, pay_time, pay_amount, pay_price, pay_src, ",
        "wx_openid, duration, free_duration, address, enter_time, cancel_time, monthly_pay_num, ",
        "monthly_pay_start_time, monthly_pay_end_time, rfpay_bill_id, rfpay_trade_no, ",
        "rfpay_body, rfpay_type, rfpay_create_time, rfpay_close_time, rfpay_account, ",
        "rfpay_fee_rate, rfpay_clearing_fee, rfpay_actual_clearing_fee, prv_uid, create_time, ",
        "update_time",
        "from parking_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="serial_no", property="serialNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="car_plate_no", property="carPlateNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_no", property="cardNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_type", property="orderType", jdbcType=JdbcType.INTEGER),
        @Result(column="order_status", property="orderStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_type", property="payType", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pay_amount", property="payAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="pay_price", property="payPrice", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_src", property="paySrc", jdbcType=JdbcType.INTEGER),
        @Result(column="wx_openid", property="wxOpenid", jdbcType=JdbcType.VARCHAR),
        @Result(column="duration", property="duration", jdbcType=JdbcType.VARCHAR),
        @Result(column="free_duration", property="freeDuration", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="enter_time", property="enterTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="cancel_time", property="cancelTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="monthly_pay_num", property="monthlyPayNum", jdbcType=JdbcType.INTEGER),
        @Result(column="monthly_pay_start_time", property="monthlyPayStartTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="monthly_pay_end_time", property="monthlyPayEndTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="rfpay_bill_id", property="rfpayBillId", jdbcType=JdbcType.VARCHAR),
        @Result(column="rfpay_trade_no", property="rfpayTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="rfpay_body", property="rfpayBody", jdbcType=JdbcType.VARCHAR),
        @Result(column="rfpay_type", property="rfpayType", jdbcType=JdbcType.VARCHAR),
        @Result(column="rfpay_create_time", property="rfpayCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="rfpay_close_time", property="rfpayCloseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="rfpay_account", property="rfpayAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="rfpay_fee_rate", property="rfpayFeeRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="rfpay_clearing_fee", property="rfpayClearingFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="rfpay_actual_clearing_fee", property="rfpayActualClearingFee", jdbcType=JdbcType.BIGINT),
        @Result(column="prv_uid", property="prvUid", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    ParkingOrder selectByPrimaryKey(Long id);

    @UpdateProvider(type=ParkingOrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ParkingOrder record, @Param("example") ParkingOrderExample example);

    @UpdateProvider(type=ParkingOrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ParkingOrder record, @Param("example") ParkingOrderExample example);

    @UpdateProvider(type=ParkingOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ParkingOrder record);

    @Update({
        "update parking_order",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "serial_no = #{serialNo,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "uid = #{uid,jdbcType=BIGINT},",
          "car_plate_no = #{carPlateNo,jdbcType=VARCHAR},",
          "card_no = #{cardNo,jdbcType=VARCHAR},",
          "order_type = #{orderType,jdbcType=INTEGER},",
          "order_status = #{orderStatus,jdbcType=INTEGER},",
          "pay_status = #{payStatus,jdbcType=INTEGER},",
          "pay_type = #{payType,jdbcType=VARCHAR},",
          "pay_time = #{payTime,jdbcType=TIMESTAMP},",
          "pay_amount = #{payAmount,jdbcType=DECIMAL},",
          "pay_price = #{payPrice,jdbcType=VARCHAR},",
          "pay_src = #{paySrc,jdbcType=INTEGER},",
          "wx_openid = #{wxOpenid,jdbcType=VARCHAR},",
          "duration = #{duration,jdbcType=VARCHAR},",
          "free_duration = #{freeDuration,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "enter_time = #{enterTime,jdbcType=TIMESTAMP},",
          "cancel_time = #{cancelTime,jdbcType=TIMESTAMP},",
          "monthly_pay_num = #{monthlyPayNum,jdbcType=INTEGER},",
          "monthly_pay_start_time = #{monthlyPayStartTime,jdbcType=VARCHAR},",
          "monthly_pay_end_time = #{monthlyPayEndTime,jdbcType=VARCHAR},",
          "rfpay_bill_id = #{rfpayBillId,jdbcType=VARCHAR},",
          "rfpay_trade_no = #{rfpayTradeNo,jdbcType=VARCHAR},",
          "rfpay_body = #{rfpayBody,jdbcType=VARCHAR},",
          "rfpay_type = #{rfpayType,jdbcType=VARCHAR},",
          "rfpay_create_time = #{rfpayCreateTime,jdbcType=TIMESTAMP},",
          "rfpay_close_time = #{rfpayCloseTime,jdbcType=TIMESTAMP},",
          "rfpay_account = #{rfpayAccount,jdbcType=VARCHAR},",
          "rfpay_fee_rate = #{rfpayFeeRate,jdbcType=DECIMAL},",
          "rfpay_clearing_fee = #{rfpayClearingFee,jdbcType=DECIMAL},",
          "rfpay_actual_clearing_fee = #{rfpayActualClearingFee,jdbcType=BIGINT},",
          "prv_uid = #{prvUid,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ParkingOrder record);
}