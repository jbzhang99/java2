package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenSettlementApply;
import com.rfchina.community.persistence.model.OpenSettlementApplyExample;
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

public interface OpenSettlementApplyMapper extends Serializable {
    @SelectProvider(type=OpenSettlementApplySqlProvider.class, method="countByExample")
    long countByExample(OpenSettlementApplyExample example);

    @DeleteProvider(type=OpenSettlementApplySqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenSettlementApplyExample example);

    @Delete({
        "delete from open_settlement_apply",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into open_settlement_apply (service_id, settlement_id, ",
        "order_amount_count, platform_poundage_amount, ",
        "platform_commission_amount, platform_think_amount, ",
        "settlement_amount_count, paid_settlement_amount, ",
        "refund_money, status, ",
        "create_time, audit_time, ",
        "order_count, invoice_title, ",
        "contacts_name, contacts_phone, ",
        "mailing_address, invoice_status, ",
        "settlement_start_time, settlement_end_time, ",
        "audit_comment, merchant_id, ",
        "invoice_type, company_name, ",
        "taxpayer_code, company_address, ",
        "company_phone, bank_name, ",
        "bank_account, type, ",
        "community_id, platform_settlement_id, ",
        "mch_id, account_id, ",
        "title, pf_status, ",
        "audit_phone, audit_name, ",
        "settle_success_time)",
        "values (#{serviceId,jdbcType=INTEGER}, #{settlementId,jdbcType=VARCHAR}, ",
        "#{orderAmountCount,jdbcType=DECIMAL}, #{platformPoundageAmount,jdbcType=DECIMAL}, ",
        "#{platformCommissionAmount,jdbcType=DECIMAL}, #{platformThinkAmount,jdbcType=DECIMAL}, ",
        "#{settlementAmountCount,jdbcType=DECIMAL}, #{paidSettlementAmount,jdbcType=DECIMAL}, ",
        "#{refundMoney,jdbcType=DECIMAL}, #{status,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{auditTime,jdbcType=TIMESTAMP}, ",
        "#{orderCount,jdbcType=INTEGER}, #{invoiceTitle,jdbcType=VARCHAR}, ",
        "#{contactsName,jdbcType=VARCHAR}, #{contactsPhone,jdbcType=VARCHAR}, ",
        "#{mailingAddress,jdbcType=VARCHAR}, #{invoiceStatus,jdbcType=INTEGER}, ",
        "#{settlementStartTime,jdbcType=TIMESTAMP}, #{settlementEndTime,jdbcType=TIMESTAMP}, ",
        "#{auditComment,jdbcType=VARCHAR}, #{merchantId,jdbcType=BIGINT}, ",
        "#{invoiceType,jdbcType=INTEGER}, #{companyName,jdbcType=VARCHAR}, ",
        "#{taxpayerCode,jdbcType=VARCHAR}, #{companyAddress,jdbcType=VARCHAR}, ",
        "#{companyPhone,jdbcType=VARCHAR}, #{bankName,jdbcType=VARCHAR}, ",
        "#{bankAccount,jdbcType=VARCHAR}, #{type,jdbcType=INTEGER}, ",
        "#{communityId,jdbcType=INTEGER}, #{platformSettlementId,jdbcType=VARCHAR}, ",
        "#{mchId,jdbcType=VARCHAR}, #{accountId,jdbcType=VARCHAR}, ",
        "#{title,jdbcType=VARCHAR}, #{pfStatus,jdbcType=INTEGER}, ",
        "#{auditPhone,jdbcType=VARCHAR}, #{auditName,jdbcType=VARCHAR}, ",
        "#{settleSuccessTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(OpenSettlementApply record);

    @InsertProvider(type=OpenSettlementApplySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(OpenSettlementApply record);

    @SelectProvider(type=OpenSettlementApplySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="settlement_id", property="settlementId", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_amount_count", property="orderAmountCount", jdbcType=JdbcType.DECIMAL),
        @Result(column="platform_poundage_amount", property="platformPoundageAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="platform_commission_amount", property="platformCommissionAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="platform_think_amount", property="platformThinkAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="settlement_amount_count", property="settlementAmountCount", jdbcType=JdbcType.DECIMAL),
        @Result(column="paid_settlement_amount", property="paidSettlementAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="refund_money", property="refundMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="order_count", property="orderCount", jdbcType=JdbcType.INTEGER),
        @Result(column="invoice_title", property="invoiceTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacts_name", property="contactsName", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacts_phone", property="contactsPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="mailing_address", property="mailingAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="invoice_status", property="invoiceStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="settlement_start_time", property="settlementStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="settlement_end_time", property="settlementEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_comment", property="auditComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.BIGINT),
        @Result(column="invoice_type", property="invoiceType", jdbcType=JdbcType.INTEGER),
        @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="taxpayer_code", property="taxpayerCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_address", property="companyAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_phone", property="companyPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_name", property="bankName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_account", property="bankAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="platform_settlement_id", property="platformSettlementId", jdbcType=JdbcType.VARCHAR),
        @Result(column="mch_id", property="mchId", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="pf_status", property="pfStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_phone", property="auditPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_name", property="auditName", jdbcType=JdbcType.VARCHAR),
        @Result(column="settle_success_time", property="settleSuccessTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenSettlementApply> selectByExample(OpenSettlementApplyExample example);

    @Select({
        "select",
        "id, service_id, settlement_id, order_amount_count, platform_poundage_amount, ",
        "platform_commission_amount, platform_think_amount, settlement_amount_count, ",
        "paid_settlement_amount, refund_money, status, create_time, audit_time, order_count, ",
        "invoice_title, contacts_name, contacts_phone, mailing_address, invoice_status, ",
        "settlement_start_time, settlement_end_time, audit_comment, merchant_id, invoice_type, ",
        "company_name, taxpayer_code, company_address, company_phone, bank_name, bank_account, ",
        "type, community_id, platform_settlement_id, mch_id, account_id, title, pf_status, ",
        "audit_phone, audit_name, settle_success_time",
        "from open_settlement_apply",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="settlement_id", property="settlementId", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_amount_count", property="orderAmountCount", jdbcType=JdbcType.DECIMAL),
        @Result(column="platform_poundage_amount", property="platformPoundageAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="platform_commission_amount", property="platformCommissionAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="platform_think_amount", property="platformThinkAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="settlement_amount_count", property="settlementAmountCount", jdbcType=JdbcType.DECIMAL),
        @Result(column="paid_settlement_amount", property="paidSettlementAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="refund_money", property="refundMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="order_count", property="orderCount", jdbcType=JdbcType.INTEGER),
        @Result(column="invoice_title", property="invoiceTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacts_name", property="contactsName", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacts_phone", property="contactsPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="mailing_address", property="mailingAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="invoice_status", property="invoiceStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="settlement_start_time", property="settlementStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="settlement_end_time", property="settlementEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_comment", property="auditComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.BIGINT),
        @Result(column="invoice_type", property="invoiceType", jdbcType=JdbcType.INTEGER),
        @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="taxpayer_code", property="taxpayerCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_address", property="companyAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_phone", property="companyPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_name", property="bankName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_account", property="bankAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="platform_settlement_id", property="platformSettlementId", jdbcType=JdbcType.VARCHAR),
        @Result(column="mch_id", property="mchId", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="pf_status", property="pfStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_phone", property="auditPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_name", property="auditName", jdbcType=JdbcType.VARCHAR),
        @Result(column="settle_success_time", property="settleSuccessTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenSettlementApply selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OpenSettlementApplySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenSettlementApply record, @Param("example") OpenSettlementApplyExample example);

    @UpdateProvider(type=OpenSettlementApplySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenSettlementApply record, @Param("example") OpenSettlementApplyExample example);

    @UpdateProvider(type=OpenSettlementApplySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenSettlementApply record);

    @Update({
        "update open_settlement_apply",
        "set service_id = #{serviceId,jdbcType=INTEGER},",
          "settlement_id = #{settlementId,jdbcType=VARCHAR},",
          "order_amount_count = #{orderAmountCount,jdbcType=DECIMAL},",
          "platform_poundage_amount = #{platformPoundageAmount,jdbcType=DECIMAL},",
          "platform_commission_amount = #{platformCommissionAmount,jdbcType=DECIMAL},",
          "platform_think_amount = #{platformThinkAmount,jdbcType=DECIMAL},",
          "settlement_amount_count = #{settlementAmountCount,jdbcType=DECIMAL},",
          "paid_settlement_amount = #{paidSettlementAmount,jdbcType=DECIMAL},",
          "refund_money = #{refundMoney,jdbcType=DECIMAL},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "audit_time = #{auditTime,jdbcType=TIMESTAMP},",
          "order_count = #{orderCount,jdbcType=INTEGER},",
          "invoice_title = #{invoiceTitle,jdbcType=VARCHAR},",
          "contacts_name = #{contactsName,jdbcType=VARCHAR},",
          "contacts_phone = #{contactsPhone,jdbcType=VARCHAR},",
          "mailing_address = #{mailingAddress,jdbcType=VARCHAR},",
          "invoice_status = #{invoiceStatus,jdbcType=INTEGER},",
          "settlement_start_time = #{settlementStartTime,jdbcType=TIMESTAMP},",
          "settlement_end_time = #{settlementEndTime,jdbcType=TIMESTAMP},",
          "audit_comment = #{auditComment,jdbcType=VARCHAR},",
          "merchant_id = #{merchantId,jdbcType=BIGINT},",
          "invoice_type = #{invoiceType,jdbcType=INTEGER},",
          "company_name = #{companyName,jdbcType=VARCHAR},",
          "taxpayer_code = #{taxpayerCode,jdbcType=VARCHAR},",
          "company_address = #{companyAddress,jdbcType=VARCHAR},",
          "company_phone = #{companyPhone,jdbcType=VARCHAR},",
          "bank_name = #{bankName,jdbcType=VARCHAR},",
          "bank_account = #{bankAccount,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=INTEGER},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "platform_settlement_id = #{platformSettlementId,jdbcType=VARCHAR},",
          "mch_id = #{mchId,jdbcType=VARCHAR},",
          "account_id = #{accountId,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "pf_status = #{pfStatus,jdbcType=INTEGER},",
          "audit_phone = #{auditPhone,jdbcType=VARCHAR},",
          "audit_name = #{auditName,jdbcType=VARCHAR},",
          "settle_success_time = #{settleSuccessTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenSettlementApply record);
}