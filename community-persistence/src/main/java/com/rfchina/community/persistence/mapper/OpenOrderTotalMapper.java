package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenOrderTotal;
import com.rfchina.community.persistence.model.OpenOrderTotalExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

public interface OpenOrderTotalMapper extends BaseMapper<OpenOrderTotal, OpenOrderTotalExample,Long> {
    @SelectProvider(type=OpenOrderTotalSqlProvider.class, method="countByExample")
    long countByExample(OpenOrderTotalExample example);

    @DeleteProvider(type=OpenOrderTotalSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenOrderTotalExample example);

    @Delete({
        "delete from open_order_total",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_order_total (account_id, community_id, ",
        "community_account_id, think_account_id, ",
        "uid, expire_time, ",
        "create_time, update_time, ",
        "type, bill_id, bill_status, ",
        "bill_finished_time, community_trade_no, ",
        "total_amount, total_platform_charge, ",
        "total_to_service_charge, total_service_charge, ",
        "total_to_receipt_amount, total_receipt_amount, ",
        "total_think_to_amount, total_think_amount, ",
        "total_refund_money, refund_count, ",
        "store_count, bill_split_status, ",
        "bill_split_time, split_amount, ",
        "pf_balance_status, pf_bussiness_balance_status, ",
        "pf_pay_status, pf_refund_status, ",
        "subject, pay_channel)",
        "values (#{accountId,jdbcType=VARCHAR}, #{communityId,jdbcType=BIGINT}, ",
        "#{communityAccountId,jdbcType=VARCHAR}, #{thinkAccountId,jdbcType=VARCHAR}, ",
        "#{uid,jdbcType=BIGINT}, #{expireTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{type,jdbcType=INTEGER}, #{billId,jdbcType=VARCHAR}, #{billStatus,jdbcType=INTEGER}, ",
        "#{billFinishedTime,jdbcType=TIMESTAMP}, #{communityTradeNo,jdbcType=VARCHAR}, ",
        "#{totalAmount,jdbcType=DECIMAL}, #{totalPlatformCharge,jdbcType=DECIMAL}, ",
        "#{totalToServiceCharge,jdbcType=DECIMAL}, #{totalServiceCharge,jdbcType=DECIMAL}, ",
        "#{totalToReceiptAmount,jdbcType=DECIMAL}, #{totalReceiptAmount,jdbcType=DECIMAL}, ",
        "#{totalThinkToAmount,jdbcType=DECIMAL}, #{totalThinkAmount,jdbcType=DECIMAL}, ",
        "#{totalRefundMoney,jdbcType=DECIMAL}, #{refundCount,jdbcType=INTEGER}, ",
        "#{storeCount,jdbcType=INTEGER}, #{billSplitStatus,jdbcType=INTEGER}, ",
        "#{billSplitTime,jdbcType=TIMESTAMP}, #{splitAmount,jdbcType=DECIMAL}, ",
        "#{pfBalanceStatus,jdbcType=INTEGER}, #{pfBussinessBalanceStatus,jdbcType=INTEGER}, ",
        "#{pfPayStatus,jdbcType=INTEGER}, #{pfRefundStatus,jdbcType=INTEGER}, ",
        "#{subject,jdbcType=VARCHAR}, #{payChannel,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenOrderTotal record);

    @InsertProvider(type=OpenOrderTotalSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenOrderTotal record);

    @SelectProvider(type=OpenOrderTotalSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.BIGINT),
        @Result(column="community_account_id", property="communityAccountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="think_account_id", property="thinkAccountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="expire_time", property="expireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_status", property="billStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_finished_time", property="billFinishedTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="community_trade_no", property="communityTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_platform_charge", property="totalPlatformCharge", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_to_service_charge", property="totalToServiceCharge", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_service_charge", property="totalServiceCharge", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_to_receipt_amount", property="totalToReceiptAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_receipt_amount", property="totalReceiptAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_think_to_amount", property="totalThinkToAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_think_amount", property="totalThinkAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_refund_money", property="totalRefundMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="refund_count", property="refundCount", jdbcType=JdbcType.INTEGER),
        @Result(column="store_count", property="storeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_split_status", property="billSplitStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_split_time", property="billSplitTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="split_amount", property="splitAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="pf_balance_status", property="pfBalanceStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pf_bussiness_balance_status", property="pfBussinessBalanceStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pf_pay_status", property="pfPayStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pf_refund_status", property="pfRefundStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.VARCHAR)
    })
    List<OpenOrderTotal> selectByExample(OpenOrderTotalExample example);

    @Select({
        "select",
        "id, account_id, community_id, community_account_id, think_account_id, uid, expire_time, ",
        "create_time, update_time, type, bill_id, bill_status, bill_finished_time, community_trade_no, ",
        "total_amount, total_platform_charge, total_to_service_charge, total_service_charge, ",
        "total_to_receipt_amount, total_receipt_amount, total_think_to_amount, total_think_amount, ",
        "total_refund_money, refund_count, store_count, bill_split_status, bill_split_time, ",
        "split_amount, pf_balance_status, pf_bussiness_balance_status, pf_pay_status, ",
        "pf_refund_status, subject, pay_channel",
        "from open_order_total",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.BIGINT),
        @Result(column="community_account_id", property="communityAccountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="think_account_id", property="thinkAccountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="expire_time", property="expireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_status", property="billStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_finished_time", property="billFinishedTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="community_trade_no", property="communityTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_platform_charge", property="totalPlatformCharge", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_to_service_charge", property="totalToServiceCharge", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_service_charge", property="totalServiceCharge", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_to_receipt_amount", property="totalToReceiptAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_receipt_amount", property="totalReceiptAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_think_to_amount", property="totalThinkToAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_think_amount", property="totalThinkAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_refund_money", property="totalRefundMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="refund_count", property="refundCount", jdbcType=JdbcType.INTEGER),
        @Result(column="store_count", property="storeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_split_status", property="billSplitStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_split_time", property="billSplitTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="split_amount", property="splitAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="pf_balance_status", property="pfBalanceStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pf_bussiness_balance_status", property="pfBussinessBalanceStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pf_pay_status", property="pfPayStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pf_refund_status", property="pfRefundStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.VARCHAR)
    })
    OpenOrderTotal selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenOrderTotalSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenOrderTotal record, @Param("example") OpenOrderTotalExample example);

    @UpdateProvider(type=OpenOrderTotalSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenOrderTotal record, @Param("example") OpenOrderTotalExample example);

    @UpdateProvider(type=OpenOrderTotalSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenOrderTotal record);

    @Update({
        "update open_order_total",
        "set account_id = #{accountId,jdbcType=VARCHAR},",
          "community_id = #{communityId,jdbcType=BIGINT},",
          "community_account_id = #{communityAccountId,jdbcType=VARCHAR},",
          "think_account_id = #{thinkAccountId,jdbcType=VARCHAR},",
          "uid = #{uid,jdbcType=BIGINT},",
          "expire_time = #{expireTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "type = #{type,jdbcType=INTEGER},",
          "bill_id = #{billId,jdbcType=VARCHAR},",
          "bill_status = #{billStatus,jdbcType=INTEGER},",
          "bill_finished_time = #{billFinishedTime,jdbcType=TIMESTAMP},",
          "community_trade_no = #{communityTradeNo,jdbcType=VARCHAR},",
          "total_amount = #{totalAmount,jdbcType=DECIMAL},",
          "total_platform_charge = #{totalPlatformCharge,jdbcType=DECIMAL},",
          "total_to_service_charge = #{totalToServiceCharge,jdbcType=DECIMAL},",
          "total_service_charge = #{totalServiceCharge,jdbcType=DECIMAL},",
          "total_to_receipt_amount = #{totalToReceiptAmount,jdbcType=DECIMAL},",
          "total_receipt_amount = #{totalReceiptAmount,jdbcType=DECIMAL},",
          "total_think_to_amount = #{totalThinkToAmount,jdbcType=DECIMAL},",
          "total_think_amount = #{totalThinkAmount,jdbcType=DECIMAL},",
          "total_refund_money = #{totalRefundMoney,jdbcType=DECIMAL},",
          "refund_count = #{refundCount,jdbcType=INTEGER},",
          "store_count = #{storeCount,jdbcType=INTEGER},",
          "bill_split_status = #{billSplitStatus,jdbcType=INTEGER},",
          "bill_split_time = #{billSplitTime,jdbcType=TIMESTAMP},",
          "split_amount = #{splitAmount,jdbcType=DECIMAL},",
          "pf_balance_status = #{pfBalanceStatus,jdbcType=INTEGER},",
          "pf_bussiness_balance_status = #{pfBussinessBalanceStatus,jdbcType=INTEGER},",
          "pf_pay_status = #{pfPayStatus,jdbcType=INTEGER},",
          "pf_refund_status = #{pfRefundStatus,jdbcType=INTEGER},",
          "subject = #{subject,jdbcType=VARCHAR},",
          "pay_channel = #{payChannel,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenOrderTotal record);


    @Select({
            "select DISTINCT ot.* from open_order o,open_order_total ot where ot.bill_status=2 and refund_count>0 and o.total_id=ot.id and o.refund_status in (2,3) ",
            "and ot.bill_split_status = 2 and ot.create_time <= #{createTime,jdbcType=TIMESTAMP}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.BIGINT),
            @Result(column="community_account_id", property="communityAccountId", jdbcType=JdbcType.VARCHAR),
            @Result(column="think_account_id", property="thinkAccountId", jdbcType=JdbcType.VARCHAR),
            @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
            @Result(column="expire_time", property="expireTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
            @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
            @Result(column="bill_status", property="billStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="bill_finished_time", property="billFinishedTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="community_trade_no", property="communityTradeNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="total_platform_charge", property="totalPlatformCharge", jdbcType=JdbcType.DECIMAL),
            @Result(column="total_to_service_charge", property="totalToServiceCharge", jdbcType=JdbcType.DECIMAL),
            @Result(column="total_service_charge", property="totalServiceCharge", jdbcType=JdbcType.DECIMAL),
            @Result(column="total_to_receipt_amount", property="totalToReceiptAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="total_receipt_amount", property="totalReceiptAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="total_think_to_amount", property="totalThinkToAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="total_think_amount", property="totalThinkAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="total_refund_money", property="totalRefundMoney", jdbcType=JdbcType.DECIMAL),
            @Result(column="refund_count", property="refundCount", jdbcType=JdbcType.INTEGER),
            @Result(column="store_count", property="storeCount", jdbcType=JdbcType.INTEGER),
            @Result(column="bill_split_status", property="billSplitStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="bill_split_time", property="billSplitTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="split_amount", property="splitAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="pf_balance_status", property="pfBalanceStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="pf_bussiness_balance_status", property="pfBussinessBalanceStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="pf_pay_status", property="pfPayStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="pf_refund_status", property="pfRefundStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
            @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.VARCHAR)
    })
    List<OpenOrderTotal> findRefundOrderTotal(Date createTime);
}