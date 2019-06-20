package com.rfchina.community.open.bridge.mapper.ext;

import com.rfchina.community.open.bridge.entity.ExtOpenSettlementApply;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.util.List;
import java.util.Map;

public interface ExtOpenSettlementApplyMapper {

	
	@SelectProvider(type=ExtOpenSettlementApplySqlProvider.class , method="pageByCondition")
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
			@Result(column="settle_success_time", property="settleSuccessTime", jdbcType=JdbcType.TIMESTAMP),
			@Result(column="service_name", property="serviceName", jdbcType=JdbcType.VARCHAR),
			@Result(column="merchant_name", property="merchantName", jdbcType=JdbcType.VARCHAR),
			@Result(column="platform_fee", property="platformFee", jdbcType=JdbcType.INTEGER),
			@Result(column="think_rate", property="thinkRate", jdbcType=JdbcType.INTEGER),
			@Result(column="service_category", property="serviceCategory", jdbcType=JdbcType.VARCHAR),
			@Result(column="community_rate", property="communityRate", jdbcType=JdbcType.INTEGER),
			@Result(column="merchant_type", property="merchantType", jdbcType=JdbcType.INTEGER),
			@Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),

	})
	public PageList<ExtOpenSettlementApply> pageByCondition(Map<String, Object> param , PageBounds pageBounds);
	
	@SelectProvider(type=ExtOpenSettlementApplySqlProvider.class , method="pageByCondition")
	@Results({

			@Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
			@Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
			@Result(column="settlement_id", property="settlementId", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_amount_count", property="orderAmountCount", jdbcType=JdbcType.DECIMAL),
			@Result(column="platform_poundage_amount", property="platformPoundageAmount", jdbcType=JdbcType.DECIMAL),
			@Result(column="platform_commission_amount", property="platformCommissionAmount", jdbcType=JdbcType.DECIMAL),
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
	public List<ExtOpenSettlementApply> getOpenSettlementApplyList(Map<String, Object> param);
}
