package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VenueOrder;
import com.rfchina.community.persistence.model.VenueOrderExample;
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

public interface VenueOrderMapper extends Serializable {
    @SelectProvider(type=VenueOrderSqlProvider.class, method="countByExample")
    long countByExample(VenueOrderExample example);

    @DeleteProvider(type=VenueOrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(VenueOrderExample example);

    @Delete({
        "delete from venue_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into venue_order (uid, order_number, ",
        "community_id, order_name, ",
        "order_phone, venue_id, ",
        "total_price, real_price, ",
        "create_time, play_date, ",
        "status, pay_type, ",
        "pay_status, pay_time, ",
        "refund_time, charge_type, ",
        "children, children_price, ",
        "adult, adult_price, ",
        "admin_uid, bill_id, ",
        "bill_close_time, bill_create_time, ",
        "notify_id, verify_code, ",
        "use_time, reservation_channels, ",
        "cancel_time, rfpay_account, ",
        "rfpay_fee_rate, rfpay_clearing_fee, ",
        "rfpay_actual_clearing_fee)",
        "values (#{uid,jdbcType=BIGINT}, #{orderNumber,jdbcType=VARCHAR}, ",
        "#{communityId,jdbcType=INTEGER}, #{orderName,jdbcType=VARCHAR}, ",
        "#{orderPhone,jdbcType=VARCHAR}, #{venueId,jdbcType=BIGINT}, ",
        "#{totalPrice,jdbcType=DECIMAL}, #{realPrice,jdbcType=DECIMAL}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{playDate,jdbcType=DATE}, ",
        "#{status,jdbcType=INTEGER}, #{payType,jdbcType=VARCHAR}, ",
        "#{payStatus,jdbcType=INTEGER}, #{payTime,jdbcType=TIMESTAMP}, ",
        "#{refundTime,jdbcType=TIMESTAMP}, #{chargeType,jdbcType=INTEGER}, ",
        "#{children,jdbcType=INTEGER}, #{childrenPrice,jdbcType=DECIMAL}, ",
        "#{adult,jdbcType=INTEGER}, #{adultPrice,jdbcType=DECIMAL}, ",
        "#{adminUid,jdbcType=BIGINT}, #{billId,jdbcType=VARCHAR}, ",
        "#{billCloseTime,jdbcType=TIMESTAMP}, #{billCreateTime,jdbcType=TIMESTAMP}, ",
        "#{notifyId,jdbcType=VARCHAR}, #{verifyCode,jdbcType=VARCHAR}, ",
        "#{useTime,jdbcType=TIMESTAMP}, #{reservationChannels,jdbcType=INTEGER}, ",
        "#{cancelTime,jdbcType=TIMESTAMP}, #{rfpayAccount,jdbcType=VARCHAR}, ",
        "#{rfpayFeeRate,jdbcType=DECIMAL}, #{rfpayClearingFee,jdbcType=DECIMAL}, ",
        "#{rfpayActualClearingFee,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(VenueOrder record);

    @InsertProvider(type=VenueOrderSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(VenueOrder record);

    @SelectProvider(type=VenueOrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="order_number", property="orderNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="order_name", property="orderName", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_phone", property="orderPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="venue_id", property="venueId", jdbcType=JdbcType.BIGINT),
        @Result(column="total_price", property="totalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="real_price", property="realPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="play_date", property="playDate", jdbcType=JdbcType.DATE),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_type", property="payType", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="refund_time", property="refundTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="charge_type", property="chargeType", jdbcType=JdbcType.INTEGER),
        @Result(column="children", property="children", jdbcType=JdbcType.INTEGER),
        @Result(column="children_price", property="childrenPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="adult", property="adult", jdbcType=JdbcType.INTEGER),
        @Result(column="adult_price", property="adultPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="admin_uid", property="adminUid", jdbcType=JdbcType.BIGINT),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_close_time", property="billCloseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="bill_create_time", property="billCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="notify_id", property="notifyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="verify_code", property="verifyCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="use_time", property="useTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="reservation_channels", property="reservationChannels", jdbcType=JdbcType.INTEGER),
        @Result(column="cancel_time", property="cancelTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="rfpay_account", property="rfpayAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="rfpay_fee_rate", property="rfpayFeeRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="rfpay_clearing_fee", property="rfpayClearingFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="rfpay_actual_clearing_fee", property="rfpayActualClearingFee", jdbcType=JdbcType.BIGINT)
    })
    List<VenueOrder> selectByExample(VenueOrderExample example);

    @Select({
        "select",
        "id, uid, order_number, community_id, order_name, order_phone, venue_id, total_price, ",
        "real_price, create_time, play_date, status, pay_type, pay_status, pay_time, ",
        "refund_time, charge_type, children, children_price, adult, adult_price, admin_uid, ",
        "bill_id, bill_close_time, bill_create_time, notify_id, verify_code, use_time, ",
        "reservation_channels, cancel_time, rfpay_account, rfpay_fee_rate, rfpay_clearing_fee, ",
        "rfpay_actual_clearing_fee",
        "from venue_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="order_number", property="orderNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="order_name", property="orderName", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_phone", property="orderPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="venue_id", property="venueId", jdbcType=JdbcType.BIGINT),
        @Result(column="total_price", property="totalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="real_price", property="realPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="play_date", property="playDate", jdbcType=JdbcType.DATE),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_type", property="payType", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="refund_time", property="refundTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="charge_type", property="chargeType", jdbcType=JdbcType.INTEGER),
        @Result(column="children", property="children", jdbcType=JdbcType.INTEGER),
        @Result(column="children_price", property="childrenPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="adult", property="adult", jdbcType=JdbcType.INTEGER),
        @Result(column="adult_price", property="adultPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="admin_uid", property="adminUid", jdbcType=JdbcType.BIGINT),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_close_time", property="billCloseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="bill_create_time", property="billCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="notify_id", property="notifyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="verify_code", property="verifyCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="use_time", property="useTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="reservation_channels", property="reservationChannels", jdbcType=JdbcType.INTEGER),
        @Result(column="cancel_time", property="cancelTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="rfpay_account", property="rfpayAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="rfpay_fee_rate", property="rfpayFeeRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="rfpay_clearing_fee", property="rfpayClearingFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="rfpay_actual_clearing_fee", property="rfpayActualClearingFee", jdbcType=JdbcType.BIGINT)
    })
    VenueOrder selectByPrimaryKey(Long id);

    @UpdateProvider(type=VenueOrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VenueOrder record, @Param("example") VenueOrderExample example);

    @UpdateProvider(type=VenueOrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VenueOrder record, @Param("example") VenueOrderExample example);

    @UpdateProvider(type=VenueOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VenueOrder record);

    @Update({
        "update venue_order",
        "set uid = #{uid,jdbcType=BIGINT},",
          "order_number = #{orderNumber,jdbcType=VARCHAR},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "order_name = #{orderName,jdbcType=VARCHAR},",
          "order_phone = #{orderPhone,jdbcType=VARCHAR},",
          "venue_id = #{venueId,jdbcType=BIGINT},",
          "total_price = #{totalPrice,jdbcType=DECIMAL},",
          "real_price = #{realPrice,jdbcType=DECIMAL},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "play_date = #{playDate,jdbcType=DATE},",
          "status = #{status,jdbcType=INTEGER},",
          "pay_type = #{payType,jdbcType=VARCHAR},",
          "pay_status = #{payStatus,jdbcType=INTEGER},",
          "pay_time = #{payTime,jdbcType=TIMESTAMP},",
          "refund_time = #{refundTime,jdbcType=TIMESTAMP},",
          "charge_type = #{chargeType,jdbcType=INTEGER},",
          "children = #{children,jdbcType=INTEGER},",
          "children_price = #{childrenPrice,jdbcType=DECIMAL},",
          "adult = #{adult,jdbcType=INTEGER},",
          "adult_price = #{adultPrice,jdbcType=DECIMAL},",
          "admin_uid = #{adminUid,jdbcType=BIGINT},",
          "bill_id = #{billId,jdbcType=VARCHAR},",
          "bill_close_time = #{billCloseTime,jdbcType=TIMESTAMP},",
          "bill_create_time = #{billCreateTime,jdbcType=TIMESTAMP},",
          "notify_id = #{notifyId,jdbcType=VARCHAR},",
          "verify_code = #{verifyCode,jdbcType=VARCHAR},",
          "use_time = #{useTime,jdbcType=TIMESTAMP},",
          "reservation_channels = #{reservationChannels,jdbcType=INTEGER},",
          "cancel_time = #{cancelTime,jdbcType=TIMESTAMP},",
          "rfpay_account = #{rfpayAccount,jdbcType=VARCHAR},",
          "rfpay_fee_rate = #{rfpayFeeRate,jdbcType=DECIMAL},",
          "rfpay_clearing_fee = #{rfpayClearingFee,jdbcType=DECIMAL},",
          "rfpay_actual_clearing_fee = #{rfpayActualClearingFee,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(VenueOrder record);
}