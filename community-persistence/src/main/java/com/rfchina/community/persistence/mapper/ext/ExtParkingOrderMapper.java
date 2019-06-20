package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.model.ParkingOrder;
import com.rfchina.community.persistence.model.ParkingOrderExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

/**
 */
public interface ExtParkingOrderMapper {

    @SelectProvider(type=ExtParkingOrderSqlProvider.class, method="pageByExample")
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
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    PageList<ParkingOrder> pageByExample(@Param("example") ParkingOrderExample example, PageBounds pageBounds);
}
