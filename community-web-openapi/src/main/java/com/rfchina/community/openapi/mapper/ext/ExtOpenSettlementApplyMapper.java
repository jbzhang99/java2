package com.rfchina.community.openapi.mapper.ext;

import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import com.rfchina.community.openapi.entity.ExtOpenSettlementApply;

public interface ExtOpenSettlementApplyMapper {

	
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
        @Result(column="service_name", property="serviceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_comment", property="auditComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.INTEGER)
    })
	public PageList<ExtOpenSettlementApply> pageByCondition(Map<String, Object> param , PageBounds pageBounds);
}
