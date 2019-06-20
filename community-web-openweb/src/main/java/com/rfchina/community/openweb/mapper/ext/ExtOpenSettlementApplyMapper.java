package com.rfchina.community.openweb.mapper.ext;

import com.rfchina.community.openweb.entity.ExtOpenSettlementApply;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.util.Date;
import java.util.Map;

public interface ExtOpenSettlementApplyMapper {

	@SelectProvider(type = ExtOpenSettlementApplySqlProvider.class, method = "pageByCondition")
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "service_id", property = "serviceId", jdbcType = JdbcType.INTEGER),
			@Result(column = "settlement_id", property = "settlementId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "order_amount_count", property = "orderAmountCount", jdbcType = JdbcType.DECIMAL),
			@Result(column = "platform_poundage_amount", property = "platformPoundageAmount", jdbcType = JdbcType.DECIMAL),
			@Result(column = "platform_commission_amount", property = "platformCommissionAmount", jdbcType = JdbcType.DECIMAL),
			@Result(column = "platform_think_amount", property = "platformThinkAmount", jdbcType = JdbcType.DECIMAL),
			@Result(column = "settlement_amount_count", property = "settlementAmountCount", jdbcType = JdbcType.DECIMAL),
			@Result(column = "paid_settlement_amount", property = "paidSettlementAmount", jdbcType = JdbcType.DECIMAL),
			@Result(column = "refund_money", property = "refundMoney", jdbcType = JdbcType.DECIMAL),
			@Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "audit_time", property = "auditTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "order_count", property = "orderCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "invoice_title", property = "invoiceTitle", jdbcType = JdbcType.VARCHAR),
			@Result(column = "contacts_name", property = "contactsName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "contacts_phone", property = "contactsPhone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "mailing_address", property = "mailingAddress", jdbcType = JdbcType.VARCHAR),
			@Result(column = "invoice_status", property = "invoiceStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "settlement_start_time", property = "settlementStartTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "settlement_end_time", property = "settlementEndTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "audit_comment", property = "auditComment", jdbcType = JdbcType.VARCHAR),
			@Result(column = "merchant_id", property = "merchantId", jdbcType = JdbcType.INTEGER),
			@Result(column = "invoice_type", property = "invoiceType", jdbcType = JdbcType.INTEGER),
			@Result(column = "company_name", property = "companyName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "taxpayer_code", property = "taxpayerCode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "company_address", property = "companyAddress", jdbcType = JdbcType.VARCHAR),
			@Result(column = "company_phone", property = "companyPhone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "bank_name", property = "bankName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "bank_account", property = "bankAccount", jdbcType = JdbcType.VARCHAR),
			@Result(column = "type", property = "type", jdbcType = JdbcType.INTEGER),
			@Result(column = "community_id", property = "communityId", jdbcType = JdbcType.INTEGER),
			@Result(column = "service_name", property = "serviceName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "audit_comment", property = "auditComment", jdbcType = JdbcType.VARCHAR),
			@Result(column = "merchant_id", property = "merchantId", jdbcType = JdbcType.INTEGER),
			@Result(column = "platform_settlement_id", property = "platformSettlementId", jdbcType = JdbcType.VARCHAR) })
	public PageList<ExtOpenSettlementApply> pageByCondition(Map<String, Object> param, PageBounds pageBounds);

	@Select(value = {
			"select count(1) as count,SUM(service_charge) as service_charge,sum(total_amount) as total_amount,"
					+ " sum(platform_charge) as platform_charge,sum(refund_money) as refund_money ,sum(receipt_amount) as receipt_amount ",
			" from open_order where bill_status=2 and type in (1,4) and service_id=#{service_id} ",
			" and  bill_finished_time>=#{startDate} and bill_finished_time<=#{endDate} group by service_id " })
	@Deprecated
	public Map<String, Object> totelServiceSettlement(@Param("service_id") int service_id,
			@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	//拆单时间,就是入账时间,现在需要根据入账时间来查询
	@Select(value = {
			"select count(1) as count,SUM(service_charge) as service_charge,sum(total_amount) as total_amount,"
					+ " sum(platform_charge) as platform_charge,sum(think_charge) as think_charge,sum(refund_money) as refund_money ,sum(receipt_amount) as receipt_amount ",
			" from open_order where bill_status=2 and type in(1,4,5) and service_id=#{service_id} ",
			" and  bill_split_time>=#{startDate} and bill_split_time<=#{endDate} group by service_id " })
	public Map<String, Object> totelServiceSettlementNew(@Param("service_id") int service_id,
			@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	@Select(value = { "select count(*) as count ",
			" from open_order where bill_status=2 and type in(1,4) and service_id=#{service_id} ",
			" and  bill_finished_time>=#{startDate} and bill_finished_time<=#{endDate} and refund_status=1 group by service_id " })
	public Long countServiceRefund(@Param("service_id") int service_id, @Param("startDate") Date startDate,
			@Param("endDate") Date endDate);

	// 退款失败,没有拆单的数量
	@Select(value = { "select count(*) as count ",
			" from open_order where bill_status=2 and type in (1,4) and service_id=#{service_id} ",
			" and  bill_finished_time>=#{startDate} and bill_finished_time<=#{endDate} and refund_status=3 and bill_split_status=2 group by service_id " })
	public Long countServiceRefundNotSplit(@Param("service_id") int service_id, @Param("startDate") Date startDate,
			@Param("endDate") Date endDate);

	// 是否能提现
	@Select(value = { "select count(*) as count ",
			" from open_order where bill_status=2 and type in (1,4) and service_id=#{service_id} ",
			" and  bill_finished_time>=#{startDate} and bill_finished_time<=#{endDate} and withdraw_status!=2 group by service_id " })
	public Long countServiceNotSplit(@Param("service_id") int serviceId, @Param("startDate") Date startTime,
			@Param("endDate") Date endTime);
}
