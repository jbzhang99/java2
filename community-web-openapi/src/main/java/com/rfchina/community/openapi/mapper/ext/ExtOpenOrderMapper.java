package com.rfchina.community.openapi.mapper.ext;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import com.rfchina.community.openapi.entity.ExtOpenOrder;
import com.rfchina.community.openapi.entity.ExtOpenOrderCount;
import com.rfchina.community.persistence.model.OpenOrder;

public interface ExtOpenOrderMapper {

	
	@SelectProvider(type=ExtOpenOrderSqlProvider.class , method = "pageByCondition")
	@Results({
		@Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.BIGINT),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.BIGINT),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
        @Result(column="body", property="body", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR),
        @Result(column="client_ip", property="clientIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="project_type", property="projectType", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_type", property="tradeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="weixin_open_id", property="weixinOpenId", jdbcType=JdbcType.VARCHAR),
        @Result(column="expire_time", property="expireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="bussiness_type", property="bussinessType", jdbcType=JdbcType.INTEGER),
        @Result(column="goods_detail", property="goodsDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="bill_status", property="billStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="service_status", property="serviceStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_create_time", property="billCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="community_trade_no", property="communityTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_finished_time", property="billFinishedTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="refund_status", property="refundStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="withdraw_status", property="withdrawStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="platform_charge", property="platformCharge", jdbcType=JdbcType.DECIMAL),
        @Result(column="service_charge", property="serviceCharge", jdbcType=JdbcType.DECIMAL),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="service_charge_status", property="serviceChargeStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="balance_status", property="balanceStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="platform_charge_rate", property="platformChargeRate", jdbcType=JdbcType.DOUBLE),
        @Result(column="service_charge_rate", property="serviceChargeRate", jdbcType=JdbcType.DOUBLE),
        @Result(column="service_charge_bill_id", property="serviceChargeBillId", jdbcType=JdbcType.VARCHAR),
        @Result(column="merchant_bill_id", property="merchantBillId", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_split_status", property="billSplitStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="receipt_amount", property="receiptAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="refund_id", property="refundId", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_name", property="serviceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_name", property="communityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="merchant_name", property="merchantName", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR)
    })
	public PageList<ExtOpenOrder> pageByCondition(Map<String, Object> param , PageBounds pageBounds);
	
	
	@SelectProvider(type=ExtOpenOrderSqlProvider.class , method = "getOpenOrderCount")
	@Results({
        @Result(column="order_count", property="orderCount", jdbcType=JdbcType.INTEGER),
        @Result(column="order_amount_count", property="orderAmountCount", jdbcType=JdbcType.DECIMAL),
        @Result(column="platform_poundage_amount", property="platformPoundageAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="platform_commission_amount", property="platformCommissionAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="settlement_amount_count", property="settlementAmountCount", jdbcType=JdbcType.DECIMAL),
    })
	public ExtOpenOrderCount getOpenOrderCount(Map<String, Object> param);
	
	@SelectProvider(type=ExtOpenOrderSqlProvider.class , method = "getPlatformChargeCount")
	@Results({
        @Result(column="order_count", property="orderCount", jdbcType=JdbcType.INTEGER),
        @Result(column="order_amount_count", property="orderAmountCount", jdbcType=JdbcType.DECIMAL),
        @Result(column="platform_poundage_amount", property="platformPoundageAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="platform_commission_amount", property="platformCommissionAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="settlement_amount_count", property="settlementAmountCount", jdbcType=JdbcType.DECIMAL),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.INTEGER)
    })
	public List<ExtOpenOrderCount> getPlatformChargeCount(Map<String, Object> param);
	
	@SelectProvider(type=ExtOpenOrderSqlProvider.class , method = "getServiceChargeCount")
	@Results({
        @Result(column="order_count", property="orderCount", jdbcType=JdbcType.INTEGER),
        @Result(column="order_amount_count", property="orderAmountCount", jdbcType=JdbcType.DECIMAL),
        @Result(column="platform_poundage_amount", property="platformPoundageAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="platform_commission_amount", property="platformCommissionAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="settlement_amount_count", property="settlementAmountCount", jdbcType=JdbcType.DECIMAL),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.INTEGER)
    })
	public List<ExtOpenOrderCount> getServiceChargeCount(Map<String, Object> param);
	
	@SelectProvider(type=ExtOpenOrderSqlProvider.class , method = "getOpenOrderGroupByCommunity")
	@Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.BIGINT),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.BIGINT),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
        @Result(column="body", property="body", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR),
        @Result(column="client_ip", property="clientIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="project_type", property="projectType", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_type", property="tradeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="weixin_open_id", property="weixinOpenId", jdbcType=JdbcType.VARCHAR),
        @Result(column="expire_time", property="expireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="bussiness_type", property="bussinessType", jdbcType=JdbcType.INTEGER),
        @Result(column="goods_detail", property="goodsDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="bill_status", property="billStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="service_status", property="serviceStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_create_time", property="billCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="community_trade_no", property="communityTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_finished_time", property="billFinishedTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="refund_status", property="refundStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="withdraw_status", property="withdrawStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="platform_charge", property="platformCharge", jdbcType=JdbcType.DECIMAL),
        @Result(column="service_charge", property="serviceCharge", jdbcType=JdbcType.DECIMAL),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="service_charge_status", property="serviceChargeStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="balance_status", property="balanceStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="platform_charge_rate", property="platformChargeRate", jdbcType=JdbcType.DOUBLE),
        @Result(column="service_charge_rate", property="serviceChargeRate", jdbcType=JdbcType.DOUBLE),
        @Result(column="service_charge_bill_id", property="serviceChargeBillId", jdbcType=JdbcType.VARCHAR),
        @Result(column="merchant_bill_id", property="merchantBillId", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_split_status", property="billSplitStatus", jdbcType=JdbcType.INTEGER)
    })
	public List<OpenOrder> getOpenOrderGroupByCommunity(Map<String, Object> param);
	
}
