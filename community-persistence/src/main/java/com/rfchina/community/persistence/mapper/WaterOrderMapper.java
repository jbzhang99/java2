package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.WaterOrder;
import com.rfchina.community.persistence.model.WaterOrderExample;
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

public interface WaterOrderMapper extends Serializable {
    @SelectProvider(type=WaterOrderSqlProvider.class, method="countByExample")
    long countByExample(WaterOrderExample example);

    @DeleteProvider(type=WaterOrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(WaterOrderExample example);

    @Delete({
        "delete from water_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into water_order (community_id, serial_no, ",
        "water_brand_id, uid, ",
        "room_id, room_owner, ",
        "master_child_id, contact, ",
        "phone, tel, num, ",
        "order_type, order_status, ",
        "order_src, order_time, ",
        "pay_type, pay_status, ",
        "pay_time, pay_body, ",
        "bill_id, bill_close_time, ",
        "bill_create_time, notify_id, ",
        "wechat_trade_no, alipay_trade_no, ",
        "total_fee, take_water, ",
        "take_water_time, receipt_ticket, ",
        "receipt_ticket_time, issue_ticket, ",
        "issue_ticket_time, staff_name, ",
        "staff_phone, order_water, ",
        "order_water_num, remark, ",
        "rfpay_account, rfpay_fee_rate, ",
        "rfpay_clearing_fee, rfpay_actual_clearing_fee, ",
        "create_time, update_time, ",
        "delete_status)",
        "values (#{communityId,jdbcType=INTEGER}, #{serialNo,jdbcType=VARCHAR}, ",
        "#{waterBrandId,jdbcType=BIGINT}, #{uid,jdbcType=BIGINT}, ",
        "#{roomId,jdbcType=BIGINT}, #{roomOwner,jdbcType=VARCHAR}, ",
        "#{masterChildId,jdbcType=BIGINT}, #{contact,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{tel,jdbcType=VARCHAR}, #{num,jdbcType=INTEGER}, ",
        "#{orderType,jdbcType=INTEGER}, #{orderStatus,jdbcType=INTEGER}, ",
        "#{orderSrc,jdbcType=INTEGER}, #{orderTime,jdbcType=TIMESTAMP}, ",
        "#{payType,jdbcType=INTEGER}, #{payStatus,jdbcType=INTEGER}, ",
        "#{payTime,jdbcType=TIMESTAMP}, #{payBody,jdbcType=VARCHAR}, ",
        "#{billId,jdbcType=VARCHAR}, #{billCloseTime,jdbcType=TIMESTAMP}, ",
        "#{billCreateTime,jdbcType=TIMESTAMP}, #{notifyId,jdbcType=VARCHAR}, ",
        "#{wechatTradeNo,jdbcType=VARCHAR}, #{alipayTradeNo,jdbcType=VARCHAR}, ",
        "#{totalFee,jdbcType=DECIMAL}, #{takeWater,jdbcType=INTEGER}, ",
        "#{takeWaterTime,jdbcType=TIMESTAMP}, #{receiptTicket,jdbcType=INTEGER}, ",
        "#{receiptTicketTime,jdbcType=TIMESTAMP}, #{issueTicket,jdbcType=INTEGER}, ",
        "#{issueTicketTime,jdbcType=TIMESTAMP}, #{staffName,jdbcType=VARCHAR}, ",
        "#{staffPhone,jdbcType=VARCHAR}, #{orderWater,jdbcType=INTEGER}, ",
        "#{orderWaterNum,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, ",
        "#{rfpayAccount,jdbcType=VARCHAR}, #{rfpayFeeRate,jdbcType=DECIMAL}, ",
        "#{rfpayClearingFee,jdbcType=DECIMAL}, #{rfpayActualClearingFee,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{deleteStatus,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(WaterOrder record);

    @InsertProvider(type=WaterOrderSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(WaterOrder record);

    @SelectProvider(type=WaterOrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="serial_no", property="serialNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="water_brand_id", property="waterBrandId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="room_id", property="roomId", jdbcType=JdbcType.BIGINT),
        @Result(column="room_owner", property="roomOwner", jdbcType=JdbcType.VARCHAR),
        @Result(column="master_child_id", property="masterChildId", jdbcType=JdbcType.BIGINT),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
        @Result(column="order_type", property="orderType", jdbcType=JdbcType.INTEGER),
        @Result(column="order_status", property="orderStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="order_src", property="orderSrc", jdbcType=JdbcType.INTEGER),
        @Result(column="order_time", property="orderTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pay_type", property="payType", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pay_body", property="payBody", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_close_time", property="billCloseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="bill_create_time", property="billCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="notify_id", property="notifyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="wechat_trade_no", property="wechatTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="alipay_trade_no", property="alipayTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_fee", property="totalFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="take_water", property="takeWater", jdbcType=JdbcType.INTEGER),
        @Result(column="take_water_time", property="takeWaterTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="receipt_ticket", property="receiptTicket", jdbcType=JdbcType.INTEGER),
        @Result(column="receipt_ticket_time", property="receiptTicketTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="issue_ticket", property="issueTicket", jdbcType=JdbcType.INTEGER),
        @Result(column="issue_ticket_time", property="issueTicketTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="staff_name", property="staffName", jdbcType=JdbcType.VARCHAR),
        @Result(column="staff_phone", property="staffPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_water", property="orderWater", jdbcType=JdbcType.INTEGER),
        @Result(column="order_water_num", property="orderWaterNum", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="rfpay_account", property="rfpayAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="rfpay_fee_rate", property="rfpayFeeRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="rfpay_clearing_fee", property="rfpayClearingFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="rfpay_actual_clearing_fee", property="rfpayActualClearingFee", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="delete_status", property="deleteStatus", jdbcType=JdbcType.INTEGER)
    })
    List<WaterOrder> selectByExample(WaterOrderExample example);

    @Select({
        "select",
        "id, community_id, serial_no, water_brand_id, uid, room_id, room_owner, master_child_id, ",
        "contact, phone, tel, num, order_type, order_status, order_src, order_time, pay_type, ",
        "pay_status, pay_time, pay_body, bill_id, bill_close_time, bill_create_time, ",
        "notify_id, wechat_trade_no, alipay_trade_no, total_fee, take_water, take_water_time, ",
        "receipt_ticket, receipt_ticket_time, issue_ticket, issue_ticket_time, staff_name, ",
        "staff_phone, order_water, order_water_num, remark, rfpay_account, rfpay_fee_rate, ",
        "rfpay_clearing_fee, rfpay_actual_clearing_fee, create_time, update_time, delete_status",
        "from water_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="serial_no", property="serialNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="water_brand_id", property="waterBrandId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="room_id", property="roomId", jdbcType=JdbcType.BIGINT),
        @Result(column="room_owner", property="roomOwner", jdbcType=JdbcType.VARCHAR),
        @Result(column="master_child_id", property="masterChildId", jdbcType=JdbcType.BIGINT),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
        @Result(column="order_type", property="orderType", jdbcType=JdbcType.INTEGER),
        @Result(column="order_status", property="orderStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="order_src", property="orderSrc", jdbcType=JdbcType.INTEGER),
        @Result(column="order_time", property="orderTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pay_type", property="payType", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pay_body", property="payBody", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_close_time", property="billCloseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="bill_create_time", property="billCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="notify_id", property="notifyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="wechat_trade_no", property="wechatTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="alipay_trade_no", property="alipayTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_fee", property="totalFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="take_water", property="takeWater", jdbcType=JdbcType.INTEGER),
        @Result(column="take_water_time", property="takeWaterTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="receipt_ticket", property="receiptTicket", jdbcType=JdbcType.INTEGER),
        @Result(column="receipt_ticket_time", property="receiptTicketTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="issue_ticket", property="issueTicket", jdbcType=JdbcType.INTEGER),
        @Result(column="issue_ticket_time", property="issueTicketTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="staff_name", property="staffName", jdbcType=JdbcType.VARCHAR),
        @Result(column="staff_phone", property="staffPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_water", property="orderWater", jdbcType=JdbcType.INTEGER),
        @Result(column="order_water_num", property="orderWaterNum", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="rfpay_account", property="rfpayAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="rfpay_fee_rate", property="rfpayFeeRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="rfpay_clearing_fee", property="rfpayClearingFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="rfpay_actual_clearing_fee", property="rfpayActualClearingFee", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="delete_status", property="deleteStatus", jdbcType=JdbcType.INTEGER)
    })
    WaterOrder selectByPrimaryKey(Long id);

    @UpdateProvider(type=WaterOrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WaterOrder record, @Param("example") WaterOrderExample example);

    @UpdateProvider(type=WaterOrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WaterOrder record, @Param("example") WaterOrderExample example);

    @UpdateProvider(type=WaterOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WaterOrder record);

    @Update({
        "update water_order",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "serial_no = #{serialNo,jdbcType=VARCHAR},",
          "water_brand_id = #{waterBrandId,jdbcType=BIGINT},",
          "uid = #{uid,jdbcType=BIGINT},",
          "room_id = #{roomId,jdbcType=BIGINT},",
          "room_owner = #{roomOwner,jdbcType=VARCHAR},",
          "master_child_id = #{masterChildId,jdbcType=BIGINT},",
          "contact = #{contact,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "num = #{num,jdbcType=INTEGER},",
          "order_type = #{orderType,jdbcType=INTEGER},",
          "order_status = #{orderStatus,jdbcType=INTEGER},",
          "order_src = #{orderSrc,jdbcType=INTEGER},",
          "order_time = #{orderTime,jdbcType=TIMESTAMP},",
          "pay_type = #{payType,jdbcType=INTEGER},",
          "pay_status = #{payStatus,jdbcType=INTEGER},",
          "pay_time = #{payTime,jdbcType=TIMESTAMP},",
          "pay_body = #{payBody,jdbcType=VARCHAR},",
          "bill_id = #{billId,jdbcType=VARCHAR},",
          "bill_close_time = #{billCloseTime,jdbcType=TIMESTAMP},",
          "bill_create_time = #{billCreateTime,jdbcType=TIMESTAMP},",
          "notify_id = #{notifyId,jdbcType=VARCHAR},",
          "wechat_trade_no = #{wechatTradeNo,jdbcType=VARCHAR},",
          "alipay_trade_no = #{alipayTradeNo,jdbcType=VARCHAR},",
          "total_fee = #{totalFee,jdbcType=DECIMAL},",
          "take_water = #{takeWater,jdbcType=INTEGER},",
          "take_water_time = #{takeWaterTime,jdbcType=TIMESTAMP},",
          "receipt_ticket = #{receiptTicket,jdbcType=INTEGER},",
          "receipt_ticket_time = #{receiptTicketTime,jdbcType=TIMESTAMP},",
          "issue_ticket = #{issueTicket,jdbcType=INTEGER},",
          "issue_ticket_time = #{issueTicketTime,jdbcType=TIMESTAMP},",
          "staff_name = #{staffName,jdbcType=VARCHAR},",
          "staff_phone = #{staffPhone,jdbcType=VARCHAR},",
          "order_water = #{orderWater,jdbcType=INTEGER},",
          "order_water_num = #{orderWaterNum,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "rfpay_account = #{rfpayAccount,jdbcType=VARCHAR},",
          "rfpay_fee_rate = #{rfpayFeeRate,jdbcType=DECIMAL},",
          "rfpay_clearing_fee = #{rfpayClearingFee,jdbcType=DECIMAL},",
          "rfpay_actual_clearing_fee = #{rfpayActualClearingFee,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "delete_status = #{deleteStatus,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(WaterOrder record);
}