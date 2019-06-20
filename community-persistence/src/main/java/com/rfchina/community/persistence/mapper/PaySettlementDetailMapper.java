package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.PaySettlementDetail;
import com.rfchina.community.persistence.model.PaySettlementDetailExample;
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

public interface PaySettlementDetailMapper extends Serializable {
    @SelectProvider(type=PaySettlementDetailSqlProvider.class, method="countByExample")
    long countByExample(PaySettlementDetailExample example);

    @DeleteProvider(type=PaySettlementDetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(PaySettlementDetailExample example);

    @Delete({
        "delete from pay_settlement_detail",
        "where my_id = #{myId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long myId);

    @Insert({
        "insert into pay_settlement_detail (my_create_time, my_compare, ",
        "id, sid, bill_id, ",
        "account_id, mch_id, ",
        "app_id, subject, out_trade_no, ",
        "cmp_out_trade_no, total_amount, ",
        "receipt_amount, fee_amount, ",
        "cmp_total_amount, cmp_receipt_amount, ",
        "cmp_fee_amount, cmp_refund_fee, ",
        "bill_create_time, create_time, ",
        "status, pay_channel_id, ",
        "pay_channel, balance_status, ",
        "bussiness_balance_status, trade_type, ",
        "refund_status, body)",
        "values (#{myCreateTime,jdbcType=TIMESTAMP}, #{myCompare,jdbcType=INTEGER}, ",
        "#{id,jdbcType=BIGINT}, #{sid,jdbcType=VARCHAR}, #{billId,jdbcType=VARCHAR}, ",
        "#{accountId,jdbcType=VARCHAR}, #{mchId,jdbcType=VARCHAR}, ",
        "#{appId,jdbcType=BIGINT}, #{subject,jdbcType=VARCHAR}, #{outTradeNo,jdbcType=VARCHAR}, ",
        "#{cmpOutTradeNo,jdbcType=VARCHAR}, #{totalAmount,jdbcType=BIGINT}, ",
        "#{receiptAmount,jdbcType=BIGINT}, #{feeAmount,jdbcType=BIGINT}, ",
        "#{cmpTotalAmount,jdbcType=BIGINT}, #{cmpReceiptAmount,jdbcType=BIGINT}, ",
        "#{cmpFeeAmount,jdbcType=BIGINT}, #{cmpRefundFee,jdbcType=BIGINT}, ",
        "#{billCreateTime,jdbcType=TIMESTAMP}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=INTEGER}, #{payChannelId,jdbcType=INTEGER}, ",
        "#{payChannel,jdbcType=VARCHAR}, #{balanceStatus,jdbcType=INTEGER}, ",
        "#{bussinessBalanceStatus,jdbcType=INTEGER}, #{tradeType,jdbcType=VARCHAR}, ",
        "#{refundStatus,jdbcType=INTEGER}, #{body,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="myId", before=false, resultType=Long.class)
    int insert(PaySettlementDetail record);

    @InsertProvider(type=PaySettlementDetailSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="myId", before=false, resultType=Long.class)
    int insertSelective(PaySettlementDetail record);

    @SelectProvider(type=PaySettlementDetailSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="my_id", property="myId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="my_create_time", property="myCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="my_compare", property="myCompare", jdbcType=JdbcType.INTEGER),
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="sid", property="sid", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="mch_id", property="mchId", jdbcType=JdbcType.VARCHAR),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.BIGINT),
        @Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="cmp_out_trade_no", property="cmpOutTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="receipt_amount", property="receiptAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="fee_amount", property="feeAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="cmp_total_amount", property="cmpTotalAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="cmp_receipt_amount", property="cmpReceiptAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="cmp_fee_amount", property="cmpFeeAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="cmp_refund_fee", property="cmpRefundFee", jdbcType=JdbcType.BIGINT),
        @Result(column="bill_create_time", property="billCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_channel_id", property="payChannelId", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.VARCHAR),
        @Result(column="balance_status", property="balanceStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="bussiness_balance_status", property="bussinessBalanceStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="trade_type", property="tradeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="refund_status", property="refundStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="body", property="body", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<PaySettlementDetail> selectByExampleWithBLOBs(PaySettlementDetailExample example);

    @SelectProvider(type=PaySettlementDetailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="my_id", property="myId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="my_create_time", property="myCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="my_compare", property="myCompare", jdbcType=JdbcType.INTEGER),
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="sid", property="sid", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="mch_id", property="mchId", jdbcType=JdbcType.VARCHAR),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.BIGINT),
        @Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="cmp_out_trade_no", property="cmpOutTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="receipt_amount", property="receiptAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="fee_amount", property="feeAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="cmp_total_amount", property="cmpTotalAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="cmp_receipt_amount", property="cmpReceiptAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="cmp_fee_amount", property="cmpFeeAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="cmp_refund_fee", property="cmpRefundFee", jdbcType=JdbcType.BIGINT),
        @Result(column="bill_create_time", property="billCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_channel_id", property="payChannelId", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.VARCHAR),
        @Result(column="balance_status", property="balanceStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="bussiness_balance_status", property="bussinessBalanceStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="trade_type", property="tradeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="refund_status", property="refundStatus", jdbcType=JdbcType.INTEGER)
    })
    List<PaySettlementDetail> selectByExample(PaySettlementDetailExample example);

    @Select({
        "select",
        "my_id, my_create_time, my_compare, id, sid, bill_id, account_id, mch_id, app_id, ",
        "subject, out_trade_no, cmp_out_trade_no, total_amount, receipt_amount, fee_amount, ",
        "cmp_total_amount, cmp_receipt_amount, cmp_fee_amount, cmp_refund_fee, bill_create_time, ",
        "create_time, status, pay_channel_id, pay_channel, balance_status, bussiness_balance_status, ",
        "trade_type, refund_status, body",
        "from pay_settlement_detail",
        "where my_id = #{myId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="my_id", property="myId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="my_create_time", property="myCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="my_compare", property="myCompare", jdbcType=JdbcType.INTEGER),
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="sid", property="sid", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="mch_id", property="mchId", jdbcType=JdbcType.VARCHAR),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.BIGINT),
        @Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="cmp_out_trade_no", property="cmpOutTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="receipt_amount", property="receiptAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="fee_amount", property="feeAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="cmp_total_amount", property="cmpTotalAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="cmp_receipt_amount", property="cmpReceiptAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="cmp_fee_amount", property="cmpFeeAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="cmp_refund_fee", property="cmpRefundFee", jdbcType=JdbcType.BIGINT),
        @Result(column="bill_create_time", property="billCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_channel_id", property="payChannelId", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.VARCHAR),
        @Result(column="balance_status", property="balanceStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="bussiness_balance_status", property="bussinessBalanceStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="trade_type", property="tradeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="refund_status", property="refundStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="body", property="body", jdbcType=JdbcType.LONGVARCHAR)
    })
    PaySettlementDetail selectByPrimaryKey(Long myId);

    @UpdateProvider(type=PaySettlementDetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PaySettlementDetail record, @Param("example") PaySettlementDetailExample example);

    @UpdateProvider(type=PaySettlementDetailSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") PaySettlementDetail record, @Param("example") PaySettlementDetailExample example);

    @UpdateProvider(type=PaySettlementDetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PaySettlementDetail record, @Param("example") PaySettlementDetailExample example);

    @UpdateProvider(type=PaySettlementDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PaySettlementDetail record);

    @Update({
        "update pay_settlement_detail",
        "set my_create_time = #{myCreateTime,jdbcType=TIMESTAMP},",
          "my_compare = #{myCompare,jdbcType=INTEGER},",
          "id = #{id,jdbcType=BIGINT},",
          "sid = #{sid,jdbcType=VARCHAR},",
          "bill_id = #{billId,jdbcType=VARCHAR},",
          "account_id = #{accountId,jdbcType=VARCHAR},",
          "mch_id = #{mchId,jdbcType=VARCHAR},",
          "app_id = #{appId,jdbcType=BIGINT},",
          "subject = #{subject,jdbcType=VARCHAR},",
          "out_trade_no = #{outTradeNo,jdbcType=VARCHAR},",
          "cmp_out_trade_no = #{cmpOutTradeNo,jdbcType=VARCHAR},",
          "total_amount = #{totalAmount,jdbcType=BIGINT},",
          "receipt_amount = #{receiptAmount,jdbcType=BIGINT},",
          "fee_amount = #{feeAmount,jdbcType=BIGINT},",
          "cmp_total_amount = #{cmpTotalAmount,jdbcType=BIGINT},",
          "cmp_receipt_amount = #{cmpReceiptAmount,jdbcType=BIGINT},",
          "cmp_fee_amount = #{cmpFeeAmount,jdbcType=BIGINT},",
          "cmp_refund_fee = #{cmpRefundFee,jdbcType=BIGINT},",
          "bill_create_time = #{billCreateTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "pay_channel_id = #{payChannelId,jdbcType=INTEGER},",
          "pay_channel = #{payChannel,jdbcType=VARCHAR},",
          "balance_status = #{balanceStatus,jdbcType=INTEGER},",
          "bussiness_balance_status = #{bussinessBalanceStatus,jdbcType=INTEGER},",
          "trade_type = #{tradeType,jdbcType=VARCHAR},",
          "refund_status = #{refundStatus,jdbcType=INTEGER},",
          "body = #{body,jdbcType=LONGVARCHAR}",
        "where my_id = #{myId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(PaySettlementDetail record);

    @Update({
        "update pay_settlement_detail",
        "set my_create_time = #{myCreateTime,jdbcType=TIMESTAMP},",
          "my_compare = #{myCompare,jdbcType=INTEGER},",
          "id = #{id,jdbcType=BIGINT},",
          "sid = #{sid,jdbcType=VARCHAR},",
          "bill_id = #{billId,jdbcType=VARCHAR},",
          "account_id = #{accountId,jdbcType=VARCHAR},",
          "mch_id = #{mchId,jdbcType=VARCHAR},",
          "app_id = #{appId,jdbcType=BIGINT},",
          "subject = #{subject,jdbcType=VARCHAR},",
          "out_trade_no = #{outTradeNo,jdbcType=VARCHAR},",
          "cmp_out_trade_no = #{cmpOutTradeNo,jdbcType=VARCHAR},",
          "total_amount = #{totalAmount,jdbcType=BIGINT},",
          "receipt_amount = #{receiptAmount,jdbcType=BIGINT},",
          "fee_amount = #{feeAmount,jdbcType=BIGINT},",
          "cmp_total_amount = #{cmpTotalAmount,jdbcType=BIGINT},",
          "cmp_receipt_amount = #{cmpReceiptAmount,jdbcType=BIGINT},",
          "cmp_fee_amount = #{cmpFeeAmount,jdbcType=BIGINT},",
          "cmp_refund_fee = #{cmpRefundFee,jdbcType=BIGINT},",
          "bill_create_time = #{billCreateTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "pay_channel_id = #{payChannelId,jdbcType=INTEGER},",
          "pay_channel = #{payChannel,jdbcType=VARCHAR},",
          "balance_status = #{balanceStatus,jdbcType=INTEGER},",
          "bussiness_balance_status = #{bussinessBalanceStatus,jdbcType=INTEGER},",
          "trade_type = #{tradeType,jdbcType=VARCHAR},",
          "refund_status = #{refundStatus,jdbcType=INTEGER}",
        "where my_id = #{myId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PaySettlementDetail record);
}