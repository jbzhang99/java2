package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.RfpayCallback;
import com.rfchina.community.persistence.model.RfpayCallbackExample;
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

public interface RfpayCallbackMapper extends Serializable {
    @SelectProvider(type=RfpayCallbackSqlProvider.class, method="countByExample")
    long countByExample(RfpayCallbackExample example);

    @DeleteProvider(type=RfpayCallbackSqlProvider.class, method="deleteByExample")
    int deleteByExample(RfpayCallbackExample example);

    @Delete({
        "delete from rfpay_callback",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into rfpay_callback (notify_id, notify_time, ",
        "bill_id, account_id, ",
        "app_id, pay_channel, ",
        "out_trade_no, client_ip, ",
        "total_amount, receipt_amount, ",
        "refund_fee, subject, ",
        "body, detail, trade_status, ",
        "timestamp, sign, ",
        "create_time)",
        "values (#{notifyId,jdbcType=VARCHAR}, #{notifyTime,jdbcType=VARCHAR}, ",
        "#{billId,jdbcType=VARCHAR}, #{accountId,jdbcType=VARCHAR}, ",
        "#{appId,jdbcType=VARCHAR}, #{payChannel,jdbcType=VARCHAR}, ",
        "#{outTradeNo,jdbcType=VARCHAR}, #{clientIp,jdbcType=VARCHAR}, ",
        "#{totalAmount,jdbcType=VARCHAR}, #{receiptAmount,jdbcType=VARCHAR}, ",
        "#{refundFee,jdbcType=VARCHAR}, #{subject,jdbcType=VARCHAR}, ",
        "#{body,jdbcType=VARCHAR}, #{detail,jdbcType=VARCHAR}, #{tradeStatus,jdbcType=VARCHAR}, ",
        "#{timestamp,jdbcType=VARCHAR}, #{sign,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(RfpayCallback record);

    @InsertProvider(type=RfpayCallbackSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(RfpayCallback record);

    @SelectProvider(type=RfpayCallbackSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="notify_id", property="notifyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="notify_time", property="notifyTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="client_ip", property="clientIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.VARCHAR),
        @Result(column="receipt_amount", property="receiptAmount", jdbcType=JdbcType.VARCHAR),
        @Result(column="refund_fee", property="refundFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
        @Result(column="body", property="body", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_status", property="tradeStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="timestamp", property="timestamp", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign", property="sign", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RfpayCallback> selectByExample(RfpayCallbackExample example);

    @Select({
        "select",
        "id, notify_id, notify_time, bill_id, account_id, app_id, pay_channel, out_trade_no, ",
        "client_ip, total_amount, receipt_amount, refund_fee, subject, body, detail, ",
        "trade_status, timestamp, sign, create_time",
        "from rfpay_callback",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="notify_id", property="notifyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="notify_time", property="notifyTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="client_ip", property="clientIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.VARCHAR),
        @Result(column="receipt_amount", property="receiptAmount", jdbcType=JdbcType.VARCHAR),
        @Result(column="refund_fee", property="refundFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
        @Result(column="body", property="body", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_status", property="tradeStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="timestamp", property="timestamp", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign", property="sign", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    RfpayCallback selectByPrimaryKey(Long id);

    @UpdateProvider(type=RfpayCallbackSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RfpayCallback record, @Param("example") RfpayCallbackExample example);

    @UpdateProvider(type=RfpayCallbackSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RfpayCallback record, @Param("example") RfpayCallbackExample example);

    @UpdateProvider(type=RfpayCallbackSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RfpayCallback record);

    @Update({
        "update rfpay_callback",
        "set notify_id = #{notifyId,jdbcType=VARCHAR},",
          "notify_time = #{notifyTime,jdbcType=VARCHAR},",
          "bill_id = #{billId,jdbcType=VARCHAR},",
          "account_id = #{accountId,jdbcType=VARCHAR},",
          "app_id = #{appId,jdbcType=VARCHAR},",
          "pay_channel = #{payChannel,jdbcType=VARCHAR},",
          "out_trade_no = #{outTradeNo,jdbcType=VARCHAR},",
          "client_ip = #{clientIp,jdbcType=VARCHAR},",
          "total_amount = #{totalAmount,jdbcType=VARCHAR},",
          "receipt_amount = #{receiptAmount,jdbcType=VARCHAR},",
          "refund_fee = #{refundFee,jdbcType=VARCHAR},",
          "subject = #{subject,jdbcType=VARCHAR},",
          "body = #{body,jdbcType=VARCHAR},",
          "detail = #{detail,jdbcType=VARCHAR},",
          "trade_status = #{tradeStatus,jdbcType=VARCHAR},",
          "timestamp = #{timestamp,jdbcType=VARCHAR},",
          "sign = #{sign,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(RfpayCallback record);
}