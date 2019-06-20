package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.PaySettlementInfo;
import com.rfchina.community.persistence.model.PaySettlementInfoExample;
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
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PaySettlementInfoMapper extends Serializable {
    @SelectProvider(type=PaySettlementInfoSqlProvider.class, method="countByExample")
    long countByExample(PaySettlementInfoExample example);

    @DeleteProvider(type=PaySettlementInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(PaySettlementInfoExample example);

    @Delete({
        "delete from pay_settlement_info",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into pay_settlement_info (id, my_id, ",
        "my_type, my_create_time, ",
        "my_status, mch_id, ",
        "mch_name, mch_account_id, ",
        "create_time, app_id, ",
        "app_name, title, ",
        "status, confirm_time, ",
        "revoke_time, from_bill_date, ",
        "to_bill_date, confirm_comment, ",
        "revoke_comment, confirm_status, ",
        "start_time, end_time, ",
        "error_msg, trade_total, ",
        "trade_total_amount, trade_receipt_amount, ",
        "trade_bussiness_receipt_amount, trade_fee_amount, ",
        "deposit_name, deposit_bank, ",
        "bank_account, trade_refund_total, ",
        "trade_refund_fee, bussiness_settle_amount)",
        "values (#{id,jdbcType=VARCHAR}, #{myId,jdbcType=VARCHAR}, ",
        "#{myType,jdbcType=VARCHAR}, #{myCreateTime,jdbcType=TIMESTAMP}, ",
        "#{myStatus,jdbcType=INTEGER}, #{mchId,jdbcType=VARCHAR}, ",
        "#{mchName,jdbcType=VARCHAR}, #{mchAccountId,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{appId,jdbcType=VARCHAR}, ",
        "#{appName,jdbcType=VARCHAR}, #{title,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{confirmTime,jdbcType=TIMESTAMP}, ",
        "#{revokeTime,jdbcType=TIMESTAMP}, #{fromBillDate,jdbcType=VARCHAR}, ",
        "#{toBillDate,jdbcType=VARCHAR}, #{confirmComment,jdbcType=VARCHAR}, ",
        "#{revokeComment,jdbcType=VARCHAR}, #{confirmStatus,jdbcType=INTEGER}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=VARCHAR}, ",
        "#{errorMsg,jdbcType=VARCHAR}, #{tradeTotal,jdbcType=INTEGER}, ",
        "#{tradeTotalAmount,jdbcType=BIGINT}, #{tradeReceiptAmount,jdbcType=BIGINT}, ",
        "#{tradeBussinessReceiptAmount,jdbcType=BIGINT}, #{tradeFeeAmount,jdbcType=BIGINT}, ",
        "#{depositName,jdbcType=VARCHAR}, #{depositBank,jdbcType=VARCHAR}, ",
        "#{bankAccount,jdbcType=VARCHAR}, #{tradeRefundTotal,jdbcType=BIGINT}, ",
        "#{tradeRefundFee,jdbcType=BIGINT}, #{bussinessSettleAmount,jdbcType=BIGINT})"
    })
    int insert(PaySettlementInfo record);

    @InsertProvider(type=PaySettlementInfoSqlProvider.class, method="insertSelective")
    int insertSelective(PaySettlementInfo record);

    @SelectProvider(type=PaySettlementInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="my_id", property="myId", jdbcType=JdbcType.VARCHAR),
        @Result(column="my_type", property="myType", jdbcType=JdbcType.VARCHAR),
        @Result(column="my_create_time", property="myCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="my_status", property="myStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="mch_id", property="mchId", jdbcType=JdbcType.VARCHAR),
        @Result(column="mch_name", property="mchName", jdbcType=JdbcType.VARCHAR),
        @Result(column="mch_account_id", property="mchAccountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="app_name", property="appName", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="confirm_time", property="confirmTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="revoke_time", property="revokeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="from_bill_date", property="fromBillDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="to_bill_date", property="toBillDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="confirm_comment", property="confirmComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="revoke_comment", property="revokeComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="confirm_status", property="confirmStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="error_msg", property="errorMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_total", property="tradeTotal", jdbcType=JdbcType.INTEGER),
        @Result(column="trade_total_amount", property="tradeTotalAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="trade_receipt_amount", property="tradeReceiptAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="trade_bussiness_receipt_amount", property="tradeBussinessReceiptAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="trade_fee_amount", property="tradeFeeAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="deposit_name", property="depositName", jdbcType=JdbcType.VARCHAR),
        @Result(column="deposit_bank", property="depositBank", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_account", property="bankAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_refund_total", property="tradeRefundTotal", jdbcType=JdbcType.BIGINT),
        @Result(column="trade_refund_fee", property="tradeRefundFee", jdbcType=JdbcType.BIGINT),
        @Result(column="bussiness_settle_amount", property="bussinessSettleAmount", jdbcType=JdbcType.BIGINT)
    })
    List<PaySettlementInfo> selectByExample(PaySettlementInfoExample example);

    @Select({
        "select",
        "id, my_id, my_type, my_create_time, my_status, mch_id, mch_name, mch_account_id, ",
        "create_time, app_id, app_name, title, status, confirm_time, revoke_time, from_bill_date, ",
        "to_bill_date, confirm_comment, revoke_comment, confirm_status, start_time, end_time, ",
        "error_msg, trade_total, trade_total_amount, trade_receipt_amount, trade_bussiness_receipt_amount, ",
        "trade_fee_amount, deposit_name, deposit_bank, bank_account, trade_refund_total, ",
        "trade_refund_fee, bussiness_settle_amount",
        "from pay_settlement_info",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="my_id", property="myId", jdbcType=JdbcType.VARCHAR),
        @Result(column="my_type", property="myType", jdbcType=JdbcType.VARCHAR),
        @Result(column="my_create_time", property="myCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="my_status", property="myStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="mch_id", property="mchId", jdbcType=JdbcType.VARCHAR),
        @Result(column="mch_name", property="mchName", jdbcType=JdbcType.VARCHAR),
        @Result(column="mch_account_id", property="mchAccountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="app_name", property="appName", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="confirm_time", property="confirmTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="revoke_time", property="revokeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="from_bill_date", property="fromBillDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="to_bill_date", property="toBillDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="confirm_comment", property="confirmComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="revoke_comment", property="revokeComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="confirm_status", property="confirmStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="error_msg", property="errorMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_total", property="tradeTotal", jdbcType=JdbcType.INTEGER),
        @Result(column="trade_total_amount", property="tradeTotalAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="trade_receipt_amount", property="tradeReceiptAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="trade_bussiness_receipt_amount", property="tradeBussinessReceiptAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="trade_fee_amount", property="tradeFeeAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="deposit_name", property="depositName", jdbcType=JdbcType.VARCHAR),
        @Result(column="deposit_bank", property="depositBank", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_account", property="bankAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_refund_total", property="tradeRefundTotal", jdbcType=JdbcType.BIGINT),
        @Result(column="trade_refund_fee", property="tradeRefundFee", jdbcType=JdbcType.BIGINT),
        @Result(column="bussiness_settle_amount", property="bussinessSettleAmount", jdbcType=JdbcType.BIGINT)
    })
    PaySettlementInfo selectByPrimaryKey(String id);

    @UpdateProvider(type=PaySettlementInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PaySettlementInfo record, @Param("example") PaySettlementInfoExample example);

    @UpdateProvider(type=PaySettlementInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PaySettlementInfo record, @Param("example") PaySettlementInfoExample example);

    @UpdateProvider(type=PaySettlementInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PaySettlementInfo record);

    @Update({
        "update pay_settlement_info",
        "set my_id = #{myId,jdbcType=VARCHAR},",
          "my_type = #{myType,jdbcType=VARCHAR},",
          "my_create_time = #{myCreateTime,jdbcType=TIMESTAMP},",
          "my_status = #{myStatus,jdbcType=INTEGER},",
          "mch_id = #{mchId,jdbcType=VARCHAR},",
          "mch_name = #{mchName,jdbcType=VARCHAR},",
          "mch_account_id = #{mchAccountId,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "app_id = #{appId,jdbcType=VARCHAR},",
          "app_name = #{appName,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "confirm_time = #{confirmTime,jdbcType=TIMESTAMP},",
          "revoke_time = #{revokeTime,jdbcType=TIMESTAMP},",
          "from_bill_date = #{fromBillDate,jdbcType=VARCHAR},",
          "to_bill_date = #{toBillDate,jdbcType=VARCHAR},",
          "confirm_comment = #{confirmComment,jdbcType=VARCHAR},",
          "revoke_comment = #{revokeComment,jdbcType=VARCHAR},",
          "confirm_status = #{confirmStatus,jdbcType=INTEGER},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=VARCHAR},",
          "error_msg = #{errorMsg,jdbcType=VARCHAR},",
          "trade_total = #{tradeTotal,jdbcType=INTEGER},",
          "trade_total_amount = #{tradeTotalAmount,jdbcType=BIGINT},",
          "trade_receipt_amount = #{tradeReceiptAmount,jdbcType=BIGINT},",
          "trade_bussiness_receipt_amount = #{tradeBussinessReceiptAmount,jdbcType=BIGINT},",
          "trade_fee_amount = #{tradeFeeAmount,jdbcType=BIGINT},",
          "deposit_name = #{depositName,jdbcType=VARCHAR},",
          "deposit_bank = #{depositBank,jdbcType=VARCHAR},",
          "bank_account = #{bankAccount,jdbcType=VARCHAR},",
          "trade_refund_total = #{tradeRefundTotal,jdbcType=BIGINT},",
          "trade_refund_fee = #{tradeRefundFee,jdbcType=BIGINT},",
          "bussiness_settle_amount = #{bussinessSettleAmount,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(PaySettlementInfo record);
}