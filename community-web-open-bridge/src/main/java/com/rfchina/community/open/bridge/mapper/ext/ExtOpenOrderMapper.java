package com.rfchina.community.open.bridge.mapper.ext;

import com.rfchina.community.open.bridge.entity.ExtOpenOrder;
import com.rfchina.community.open.bridge.entity.ExtOpenOrderTotal;
import com.rfchina.community.persistence.model.ext.EmpGuidOrderStat;
import com.rfchina.community.persistence.model.ext.OperatorOrder;
import com.rfchina.community.persistence.model.ext.TaskOrder;
import com.rfchina.community.persistence.model.ext.TaskOrderStat;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ExtOpenOrderMapper {

	
	@SelectProvider(type=ExtOpenOrderSqlProvider.class , method = "pageByCondition")
	@Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="expire_time", property="expireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
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
        @Result(column="total_refund_money", property="totalRefundMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="refund_count", property="refundCount", jdbcType=JdbcType.INTEGER),
        @Result(column="store_count", property="storeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_split_status", property="billSplitStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_split_time", property="billSplitTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pf_balance_status", property="pfBalanceStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pf_bussiness_balance_status", property="pfBussinessBalanceStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pf_refund_status", property="pfRefundStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_name", property="communityName", jdbcType=JdbcType.VARCHAR),
		@Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
		@Result(column="total_think_amount", property="totalThinkAmount", jdbcType=JdbcType.DECIMAL),
		@Result(column="total_think_to_amount", property="totalThinkToAmount", jdbcType=JdbcType.DECIMAL)
    })
	public PageList<ExtOpenOrderTotal> pageByCondition(Map<String, Object> param , PageBounds pageBounds);
	
	
	 @SelectProvider(type = ExtOpenOrderSqlProvider.class, method = "pageByAdminCondition")
	    @Results({
	            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
	            @Result(column = "account_id", property = "accountId", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "community_id", property = "communityId", jdbcType = JdbcType.BIGINT),
	            @Result(column = "app_id", property = "appId", jdbcType = JdbcType.BIGINT),
	            @Result(column = "service_id", property = "serviceId", jdbcType = JdbcType.INTEGER),
	            @Result(column = "uid", property = "uid", jdbcType = JdbcType.BIGINT),
	            @Result(column = "pay_channel", property = "payChannel", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "out_trade_no", property = "outTradeNo", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "client_ip", property = "clientIp", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "project_type", property = "projectType", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "trade_type", property = "tradeType", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "weixin_open_id", property = "weixinOpenId", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "expire_time", property = "expireTime", jdbcType = JdbcType.TIMESTAMP),
	            @Result(column = "bussiness_type", property = "bussinessType", jdbcType = JdbcType.INTEGER),
	            @Result(column = "goods_detail", property = "goodsDetail", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
	            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
	            @Result(column = "bill_status", property = "billStatus", jdbcType = JdbcType.INTEGER),
	            @Result(column = "bill_id", property = "billId", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "bill_create_time", property = "billCreateTime", jdbcType = JdbcType.TIMESTAMP),
	            @Result(column = "community_trade_no", property = "communityTradeNo", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "bill_finished_time", property = "billFinishedTime", jdbcType = JdbcType.TIMESTAMP),
	            @Result(column = "total_amount", property = "totalAmount", jdbcType = JdbcType.DECIMAL),
	            @Result(column = "platform_charge", property = "platformCharge", jdbcType = JdbcType.DECIMAL),
	            @Result(column = "platform_charge_rate", property = "platformChargeRate", jdbcType = JdbcType.DOUBLE),
	            @Result(column = "service_charge", property = "serviceCharge", jdbcType = JdbcType.DECIMAL),
	            @Result(column = "service_charge_rate", property = "serviceChargeRate", jdbcType = JdbcType.DOUBLE),
	            @Result(column = "receipt_amount", property = "receiptAmount", jdbcType = JdbcType.DECIMAL),
	            @Result(column = "refund_status", property = "refundStatus", jdbcType = JdbcType.INTEGER),
	            @Result(column = "refund_reason", property = "refundReason", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "refund_id", property = "refundId", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "refund_remark", property = "refundRemark", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "refund_money", property = "refundMoney", jdbcType = JdbcType.DECIMAL),
	            @Result(column = "withdraw_status", property = "withdrawStatus", jdbcType = JdbcType.INTEGER),
	            @Result(column = "type", property = "type", jdbcType = JdbcType.INTEGER),
	            @Result(column = "service_charge_status", property = "serviceChargeStatus", jdbcType = JdbcType.INTEGER),
	            @Result(column = "balance_status", property = "balanceStatus", jdbcType = JdbcType.INTEGER),
	            @Result(column = "service_charge_bill_id", property = "serviceChargeBillId", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "service_account", property = "serviceAccount", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "service_account_mchid", property = "serviceAccountMchid", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "merchant_bill_id", property = "merchantBillId", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "bill_split_status", property = "billSplitStatus", jdbcType = JdbcType.INTEGER),
	            @Result(column = "bill_split_time", property = "billSplitTime", jdbcType = JdbcType.TIMESTAMP),
	            @Result(column = "open_id", property = "openId", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "out_status", property = "outStatus", jdbcType = JdbcType.INTEGER),
	            @Result(column = "out_status_content", property = "outStatusContent", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "settle_id", property = "settleId", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "pf_balance_status", property = "pfBalanceStatus", jdbcType = JdbcType.INTEGER),
	            @Result(column = "pf_bussiness_balance_status", property = "pfBussinessBalanceStatus", jdbcType = JdbcType.INTEGER),
	            @Result(column = "pf_refund_status", property = "pfRefundStatus", jdbcType = JdbcType.INTEGER),
	            @Result(column = "pf_refund_time", property = "pfRefundTime", jdbcType = JdbcType.TIMESTAMP),
	            @Result(column = "subject", property = "subject", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "body", property = "body", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "detail", property = "detail", jdbcType = JdbcType.VARCHAR),

	            @Result(column = "service_name", property = "serviceName", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "community_name", property = "communityName", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "merchant_name", property = "merchantName", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR)
	    })
	    public PageList<ExtOpenOrder> pageByAdminCondition(Map<String, Object> param, PageBounds pageBounds);

		@SelectProvider(type=ExtOpenOrderSqlProvider.class, method="sumAmount")
	 	public BigDecimal sumAmount(Map<String, Object> param);

	@SelectProvider(type=ExtOpenOrderSqlProvider.class, method="taskOrderStat")
	@Results({
			@Result(column = "total_amount", property = "totalAmount", jdbcType = JdbcType.DECIMAL),
			@Result(column = "refund_amount", property = "refundAmount", jdbcType = JdbcType.DECIMAL),
			@Result(column = "no_refund_amount", property = "noRefundAmount", jdbcType = JdbcType.DECIMAL),
			@Result(column = "order_amount", property = "orderAmount", jdbcType = JdbcType.INTEGER)
	})
	public TaskOrderStat taskOrderStat(Map<String, Object> param);


	@SelectProvider(type=ExtOpenOrderSqlProvider.class, method="taskOrderList")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "out_trade_no", property = "outTradeNo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "total_amount", property = "totalAmount", jdbcType = JdbcType.DECIMAL),
			@Result(column = "bill_finished_time", property = "billFinishedTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "refund_status", property = "refundStatus", jdbcType = JdbcType.INTEGER)
	})
	public PageList<TaskOrder> taskOrderList(Map<String, Object> param, PageBounds pageBounds);

	@Select({"<script> SELECT emp_guid,count(*) emp_count,"+
			" (SELECT sum(_order.total_amount)FROM open_order _order WHERE _order.bill_status = 2 AND _order.emp_guid = _rel.emp_guid) emp_total" +
			" FROM open_operator_task_rel _rel WHERE _rel.emp_guid in <foreach collection=\"empGuidList\" item=\"item\""
			+ " index=\"index\" open=\"(\" close=\")\"" + " separator=\",\">", "#{item}",
			"</foreach> group by emp_guid </script>"
	})
	@Results({
			@Result(column = "emp_guid", property = "empGuid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "emp_total", property = "empTotal", jdbcType = JdbcType.DECIMAL),
			@Result(column = "emp_count", property = "empCount", jdbcType = JdbcType.INTEGER)
	})
	public List<EmpGuidOrderStat> getOperatorStat(@Param("empGuidList") List<String> empGuidList);

	@SelectProvider(type=ExtOpenOrderSqlProvider.class, method="listOperatorOrder")
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "emp_guid", property = "empGuid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "emp_phone", property = "empPhone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "emp_name", property = "empName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "out_trade_no", property = "outTradeNo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "total_amount", property = "totalAmount", jdbcType = JdbcType.DECIMAL),
			@Result(column = "task_id", property = "taskId", jdbcType = JdbcType.BIGINT),
			@Result(column = "service_name", property = "serviceName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "bill_finished_time", property = "billFinishedTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "refund_status", property = "refundStatus", jdbcType = JdbcType.INTEGER)
	})
	public PageList<OperatorOrder> listOperatorOrder(Map<String, Object> param, PageBounds pageBounds);

	@SelectProvider(type=ExtOpenOrderSqlProvider.class , method = "pageCondition")
	@Results({

			@Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
			@Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
			@Result(column="community_id", property="communityId", jdbcType=JdbcType.BIGINT),
			@Result(column="app_id", property="appId", jdbcType=JdbcType.BIGINT),
			@Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
			@Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
			@Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.VARCHAR),
			@Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
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
			@Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
			@Result(column="bill_create_time", property="billCreateTime", jdbcType=JdbcType.TIMESTAMP),
			@Result(column="community_trade_no", property="communityTradeNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="bill_finished_time", property="billFinishedTime", jdbcType=JdbcType.TIMESTAMP),
			@Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
			@Result(column="platform_charge", property="platformCharge", jdbcType=JdbcType.DECIMAL),
			@Result(column="platform_charge_rate", property="platformChargeRate", jdbcType=JdbcType.DOUBLE),
			@Result(column="service_charge", property="serviceCharge", jdbcType=JdbcType.DECIMAL),
			@Result(column="service_charge_rate", property="serviceChargeRate", jdbcType=JdbcType.DOUBLE),
			@Result(column="think_charge", property="thinkCharge", jdbcType=JdbcType.DECIMAL),
			@Result(column="think_charge_rate", property="thinkChargeRate", jdbcType=JdbcType.DOUBLE),
			@Result(column="receipt_amount", property="receiptAmount", jdbcType=JdbcType.DECIMAL),
			@Result(column="refund_status", property="refundStatus", jdbcType=JdbcType.INTEGER),
			@Result(column="refund_reason", property="refundReason", jdbcType=JdbcType.VARCHAR),
			@Result(column="refund_id", property="refundId", jdbcType=JdbcType.VARCHAR),
			@Result(column="refund_remark", property="refundRemark", jdbcType=JdbcType.VARCHAR),
			@Result(column="refund_money", property="refundMoney", jdbcType=JdbcType.DECIMAL),
			@Result(column="withdraw_status", property="withdrawStatus", jdbcType=JdbcType.INTEGER),
			@Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
			@Result(column="service_charge_status", property="serviceChargeStatus", jdbcType=JdbcType.INTEGER),
			@Result(column="balance_status", property="balanceStatus", jdbcType=JdbcType.INTEGER),
			@Result(column="service_charge_bill_id", property="serviceChargeBillId", jdbcType=JdbcType.VARCHAR),
			@Result(column="service_account", property="serviceAccount", jdbcType=JdbcType.VARCHAR),
			@Result(column="service_account_mchid", property="serviceAccountMchid", jdbcType=JdbcType.VARCHAR),
			@Result(column="merchant_bill_id", property="merchantBillId", jdbcType=JdbcType.VARCHAR),
			@Result(column="bill_split_status", property="billSplitStatus", jdbcType=JdbcType.INTEGER),
			@Result(column="bill_split_time", property="billSplitTime", jdbcType=JdbcType.TIMESTAMP),
			@Result(column="open_id", property="openId", jdbcType=JdbcType.VARCHAR),
			@Result(column="out_status", property="outStatus", jdbcType=JdbcType.INTEGER),
			@Result(column="out_status_content", property="outStatusContent", jdbcType=JdbcType.VARCHAR),
			@Result(column="settle_id", property="settleId", jdbcType=JdbcType.VARCHAR),
			@Result(column="pf_balance_status", property="pfBalanceStatus", jdbcType=JdbcType.INTEGER),
			@Result(column="pf_bussiness_balance_status", property="pfBussinessBalanceStatus", jdbcType=JdbcType.INTEGER),
			@Result(column="pf_refund_status", property="pfRefundStatus", jdbcType=JdbcType.INTEGER),
			@Result(column="pf_refund_time", property="pfRefundTime", jdbcType=JdbcType.TIMESTAMP),
			@Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
			@Result(column="body", property="body", jdbcType=JdbcType.VARCHAR),
			@Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR),
			@Result(column="service_name", property="serviceName", jdbcType=JdbcType.VARCHAR),
			@Result(column="community_name", property="communityName", jdbcType=JdbcType.VARCHAR),
			@Result(column="merchant_name", property="merchantName", jdbcType=JdbcType.VARCHAR),
			@Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
			@Result(column="city_name", property="cityName", jdbcType=JdbcType.VARCHAR)
	})
	public List<ExtOpenOrder> getOpenOrderList(Map<String, Object> param);



}
