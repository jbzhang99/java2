package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.BizApplyOrder;
import com.rfchina.community.persistence.model.BizApplyOrderExample;
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

public interface BizApplyOrderMapper extends Serializable {
    @SelectProvider(type=BizApplyOrderSqlProvider.class, method="countByExample")
    long countByExample(BizApplyOrderExample example);

    @DeleteProvider(type=BizApplyOrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(BizApplyOrderExample example);

    @Delete({
        "delete from biz_apply_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into biz_apply_order (trade_no, tsk_code, ",
        "community_id, master_id, ",
        "master_child_id, uid, ",
        "contact, phone, ",
        "title, order_type, ",
        "order_status, pay_status, ",
        "pay_type, pay_price, ",
        "pay_amount, pay_time, ",
        "attachment, apply_time, ",
        "apply_num, apply_address, ",
        "obtain_address, obtain_time, ",
        "audit_status, audit_reason, ",
        "audit_time, validation_code, ",
        "issue_tsk_code, issue_body, ",
        "rfpay_bill_id, rfpay_trade_no, ",
        "rfpay_body, rfpay_type, ",
        "rfpay_create_time, rfpay_close_time, ",
        "rfpay_account, rfpay_fee_rate, ",
        "rfpay_clearing_fee, rfpay_actual_clearing_fee, ",
        "create_time, update_time)",
        "values (#{tradeNo,jdbcType=VARCHAR}, #{tskCode,jdbcType=VARCHAR}, ",
        "#{communityId,jdbcType=INTEGER}, #{masterId,jdbcType=BIGINT}, ",
        "#{masterChildId,jdbcType=BIGINT}, #{uid,jdbcType=BIGINT}, ",
        "#{contact,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, ",
        "#{title,jdbcType=VARCHAR}, #{orderType,jdbcType=INTEGER}, ",
        "#{orderStatus,jdbcType=INTEGER}, #{payStatus,jdbcType=INTEGER}, ",
        "#{payType,jdbcType=VARCHAR}, #{payPrice,jdbcType=DECIMAL}, ",
        "#{payAmount,jdbcType=DECIMAL}, #{payTime,jdbcType=TIMESTAMP}, ",
        "#{attachment,jdbcType=VARCHAR}, #{applyTime,jdbcType=TIMESTAMP}, ",
        "#{applyNum,jdbcType=INTEGER}, #{applyAddress,jdbcType=VARCHAR}, ",
        "#{obtainAddress,jdbcType=VARCHAR}, #{obtainTime,jdbcType=TIMESTAMP}, ",
        "#{auditStatus,jdbcType=INTEGER}, #{auditReason,jdbcType=VARCHAR}, ",
        "#{auditTime,jdbcType=TIMESTAMP}, #{validationCode,jdbcType=VARCHAR}, ",
        "#{issueTskCode,jdbcType=VARCHAR}, #{issueBody,jdbcType=VARCHAR}, ",
        "#{rfpayBillId,jdbcType=VARCHAR}, #{rfpayTradeNo,jdbcType=VARCHAR}, ",
        "#{rfpayBody,jdbcType=VARCHAR}, #{rfpayType,jdbcType=VARCHAR}, ",
        "#{rfpayCreateTime,jdbcType=TIMESTAMP}, #{rfpayCloseTime,jdbcType=TIMESTAMP}, ",
        "#{rfpayAccount,jdbcType=VARCHAR}, #{rfpayFeeRate,jdbcType=DECIMAL}, ",
        "#{rfpayClearingFee,jdbcType=DECIMAL}, #{rfpayActualClearingFee,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(BizApplyOrder record);

    @InsertProvider(type=BizApplyOrderSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(BizApplyOrder record);

    @SelectProvider(type=BizApplyOrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="trade_no", property="tradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="tsk_code", property="tskCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT),
        @Result(column="master_child_id", property="masterChildId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_type", property="orderType", jdbcType=JdbcType.INTEGER),
        @Result(column="order_status", property="orderStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_type", property="payType", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_price", property="payPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="pay_amount", property="payAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="attachment", property="attachment", jdbcType=JdbcType.VARCHAR),
        @Result(column="apply_time", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="apply_num", property="applyNum", jdbcType=JdbcType.INTEGER),
        @Result(column="apply_address", property="applyAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="obtain_address", property="obtainAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="obtain_time", property="obtainTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_reason", property="auditReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validation_code", property="validationCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="issue_tsk_code", property="issueTskCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="issue_body", property="issueBody", jdbcType=JdbcType.VARCHAR),
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
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BizApplyOrder> selectByExample(BizApplyOrderExample example);

    @Select({
        "select",
        "id, trade_no, tsk_code, community_id, master_id, master_child_id, uid, contact, ",
        "phone, title, order_type, order_status, pay_status, pay_type, pay_price, pay_amount, ",
        "pay_time, attachment, apply_time, apply_num, apply_address, obtain_address, ",
        "obtain_time, audit_status, audit_reason, audit_time, validation_code, issue_tsk_code, ",
        "issue_body, rfpay_bill_id, rfpay_trade_no, rfpay_body, rfpay_type, rfpay_create_time, ",
        "rfpay_close_time, rfpay_account, rfpay_fee_rate, rfpay_clearing_fee, rfpay_actual_clearing_fee, ",
        "create_time, update_time",
        "from biz_apply_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="trade_no", property="tradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="tsk_code", property="tskCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT),
        @Result(column="master_child_id", property="masterChildId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_type", property="orderType", jdbcType=JdbcType.INTEGER),
        @Result(column="order_status", property="orderStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_type", property="payType", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_price", property="payPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="pay_amount", property="payAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="attachment", property="attachment", jdbcType=JdbcType.VARCHAR),
        @Result(column="apply_time", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="apply_num", property="applyNum", jdbcType=JdbcType.INTEGER),
        @Result(column="apply_address", property="applyAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="obtain_address", property="obtainAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="obtain_time", property="obtainTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_reason", property="auditReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validation_code", property="validationCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="issue_tsk_code", property="issueTskCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="issue_body", property="issueBody", jdbcType=JdbcType.VARCHAR),
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
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    BizApplyOrder selectByPrimaryKey(Long id);

    @UpdateProvider(type=BizApplyOrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BizApplyOrder record, @Param("example") BizApplyOrderExample example);

    @UpdateProvider(type=BizApplyOrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BizApplyOrder record, @Param("example") BizApplyOrderExample example);

    @UpdateProvider(type=BizApplyOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BizApplyOrder record);

    @Update({
        "update biz_apply_order",
        "set trade_no = #{tradeNo,jdbcType=VARCHAR},",
          "tsk_code = #{tskCode,jdbcType=VARCHAR},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "master_id = #{masterId,jdbcType=BIGINT},",
          "master_child_id = #{masterChildId,jdbcType=BIGINT},",
          "uid = #{uid,jdbcType=BIGINT},",
          "contact = #{contact,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "order_type = #{orderType,jdbcType=INTEGER},",
          "order_status = #{orderStatus,jdbcType=INTEGER},",
          "pay_status = #{payStatus,jdbcType=INTEGER},",
          "pay_type = #{payType,jdbcType=VARCHAR},",
          "pay_price = #{payPrice,jdbcType=DECIMAL},",
          "pay_amount = #{payAmount,jdbcType=DECIMAL},",
          "pay_time = #{payTime,jdbcType=TIMESTAMP},",
          "attachment = #{attachment,jdbcType=VARCHAR},",
          "apply_time = #{applyTime,jdbcType=TIMESTAMP},",
          "apply_num = #{applyNum,jdbcType=INTEGER},",
          "apply_address = #{applyAddress,jdbcType=VARCHAR},",
          "obtain_address = #{obtainAddress,jdbcType=VARCHAR},",
          "obtain_time = #{obtainTime,jdbcType=TIMESTAMP},",
          "audit_status = #{auditStatus,jdbcType=INTEGER},",
          "audit_reason = #{auditReason,jdbcType=VARCHAR},",
          "audit_time = #{auditTime,jdbcType=TIMESTAMP},",
          "validation_code = #{validationCode,jdbcType=VARCHAR},",
          "issue_tsk_code = #{issueTskCode,jdbcType=VARCHAR},",
          "issue_body = #{issueBody,jdbcType=VARCHAR},",
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
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BizApplyOrder record);
}