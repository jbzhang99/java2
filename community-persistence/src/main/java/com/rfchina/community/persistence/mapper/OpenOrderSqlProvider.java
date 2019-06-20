package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenOrder;
import com.rfchina.community.persistence.model.OpenOrderExample.Criteria;
import com.rfchina.community.persistence.model.OpenOrderExample.Criterion;
import com.rfchina.community.persistence.model.OpenOrderExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenOrderSqlProvider {

    public String countByExample(OpenOrderExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenOrderExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenOrder record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_order");
        
        if (record.getTotalId() != null) {
            sql.VALUES("total_id", "#{totalId,jdbcType=BIGINT}");
        }
        
        if (record.getAccountId() != null) {
            sql.VALUES("account_id", "#{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getThinkAccountId() != null) {
            sql.VALUES("think_account_id", "#{thinkAccountId,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=BIGINT}");
        }
        
        if (record.getAppId() != null) {
            sql.VALUES("app_id", "#{appId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=BIGINT}");
        }
        
        if (record.getCautionId() != null) {
            sql.VALUES("caution_id", "#{cautionId,jdbcType=BIGINT}");
        }
        
        if (record.getPayChannel() != null) {
            sql.VALUES("pay_channel", "#{payChannel,jdbcType=VARCHAR}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.VALUES("out_trade_no", "#{outTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getClientIp() != null) {
            sql.VALUES("client_ip", "#{clientIp,jdbcType=VARCHAR}");
        }
        
        if (record.getProjectType() != null) {
            sql.VALUES("project_type", "#{projectType,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeType() != null) {
            sql.VALUES("trade_type", "#{tradeType,jdbcType=VARCHAR}");
        }
        
        if (record.getWeixinOpenId() != null) {
            sql.VALUES("weixin_open_id", "#{weixinOpenId,jdbcType=VARCHAR}");
        }
        
        if (record.getExpireTime() != null) {
            sql.VALUES("expire_time", "#{expireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBussinessType() != null) {
            sql.VALUES("bussiness_type", "#{bussinessType,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBillStatus() != null) {
            sql.VALUES("bill_status", "#{billStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBillId() != null) {
            sql.VALUES("bill_id", "#{billId,jdbcType=VARCHAR}");
        }
        
        if (record.getBillCreateTime() != null) {
            sql.VALUES("bill_create_time", "#{billCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommunityTradeNo() != null) {
            sql.VALUES("community_trade_no", "#{communityTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBillFinishedTime() != null) {
            sql.VALUES("bill_finished_time", "#{billFinishedTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.VALUES("total_amount", "#{totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformCharge() != null) {
            sql.VALUES("platform_charge", "#{platformCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformChargeRate() != null) {
            sql.VALUES("platform_charge_rate", "#{platformChargeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getServiceCharge() != null) {
            sql.VALUES("service_charge", "#{serviceCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getServiceChargeRate() != null) {
            sql.VALUES("service_charge_rate", "#{serviceChargeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getReceiptAmount() != null) {
            sql.VALUES("receipt_amount", "#{receiptAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getThinkChargeRate() != null) {
            sql.VALUES("think_charge_rate", "#{thinkChargeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getThinkCharge() != null) {
            sql.VALUES("think_charge", "#{thinkCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getTixianThrid() != null) {
            sql.VALUES("tixian_thrid", "#{tixianThrid,jdbcType=VARCHAR}");
        }
        
        if (record.getTixianCommunity() != null) {
            sql.VALUES("tixian_community", "#{tixianCommunity,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundStatus() != null) {
            sql.VALUES("refund_status", "#{refundStatus,jdbcType=INTEGER}");
        }
        
        if (record.getRefundReason() != null) {
            sql.VALUES("refund_reason", "#{refundReason,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundId() != null) {
            sql.VALUES("refund_id", "#{refundId,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundRemark() != null) {
            sql.VALUES("refund_remark", "#{refundRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundCreateTime() != null) {
            sql.VALUES("refund_create_time", "#{refundCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRefundMoney() != null) {
            sql.VALUES("refund_money", "#{refundMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getRefundBillId() != null) {
            sql.VALUES("refund_bill_id", "#{refundBillId,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundSubBillId() != null) {
            sql.VALUES("refund_sub_bill_id", "#{refundSubBillId,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundAccountId() != null) {
            sql.VALUES("refund_account_id", "#{refundAccountId,jdbcType=VARCHAR}");
        }
        
        if (record.getSameWay() != null) {
            sql.VALUES("same_way", "#{sameWay,jdbcType=INTEGER}");
        }
        
        if (record.getWithdrawStatus() != null) {
            sql.VALUES("withdraw_status", "#{withdrawStatus,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getServiceChargeStatus() != null) {
            sql.VALUES("service_charge_status", "#{serviceChargeStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBalanceStatus() != null) {
            sql.VALUES("balance_status", "#{balanceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getServiceChargeBillId() != null) {
            sql.VALUES("service_charge_bill_id", "#{serviceChargeBillId,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceAccount() != null) {
            sql.VALUES("service_account", "#{serviceAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceAccountMchid() != null) {
            sql.VALUES("service_account_mchid", "#{serviceAccountMchid,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantBillId() != null) {
            sql.VALUES("merchant_bill_id", "#{merchantBillId,jdbcType=VARCHAR}");
        }
        
        if (record.getThinkBillId() != null) {
            sql.VALUES("think_bill_id", "#{thinkBillId,jdbcType=VARCHAR}");
        }
        
        if (record.getBillSplitStatus() != null) {
            sql.VALUES("bill_split_status", "#{billSplitStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBillSplitTime() != null) {
            sql.VALUES("bill_split_time", "#{billSplitTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSplitAmount() != null) {
            sql.VALUES("split_amount", "#{splitAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getOpenId() != null) {
            sql.VALUES("open_id", "#{openId,jdbcType=VARCHAR}");
        }
        
        if (record.getOutStatus() != null) {
            sql.VALUES("out_status", "#{outStatus,jdbcType=INTEGER}");
        }
        
        if (record.getOutStatusContent() != null) {
            sql.VALUES("out_status_content", "#{outStatusContent,jdbcType=VARCHAR}");
        }
        
        if (record.getSettleId() != null) {
            sql.VALUES("settle_id", "#{settleId,jdbcType=VARCHAR}");
        }
        
        if (record.getPfBalanceStatus() != null) {
            sql.VALUES("pf_balance_status", "#{pfBalanceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPfBussinessBalanceStatus() != null) {
            sql.VALUES("pf_bussiness_balance_status", "#{pfBussinessBalanceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPfRefundStatus() != null) {
            sql.VALUES("pf_refund_status", "#{pfRefundStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPfRefundTime() != null) {
            sql.VALUES("pf_refund_time", "#{pfRefundTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSubject() != null) {
            sql.VALUES("subject", "#{subject,jdbcType=VARCHAR}");
        }
        
        if (record.getBody() != null) {
            sql.VALUES("body", "#{body,jdbcType=VARCHAR}");
        }
        
        if (record.getDetail() != null) {
            sql.VALUES("detail", "#{detail,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskId() != null) {
            sql.VALUES("task_id", "#{taskId,jdbcType=BIGINT}");
        }
        
        if (record.getEmpGuid() != null) {
            sql.VALUES("emp_guid", "#{empGuid,jdbcType=VARCHAR}");
        }
        
        if (record.getEmpPhone() != null) {
            sql.VALUES("emp_phone", "#{empPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmpName() != null) {
            sql.VALUES("emp_name", "#{empName,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRelId() != null) {
            sql.VALUES("task_rel_id", "#{taskRelId,jdbcType=BIGINT}");
        }
        
        if (record.getGoodsDetail() != null) {
            sql.VALUES("goods_detail", "#{goodsDetail,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(OpenOrderExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("total_id");
        sql.SELECT("account_id");
        sql.SELECT("think_account_id");
        sql.SELECT("community_id");
        sql.SELECT("app_id");
        sql.SELECT("service_id");
        sql.SELECT("uid");
        sql.SELECT("caution_id");
        sql.SELECT("pay_channel");
        sql.SELECT("out_trade_no");
        sql.SELECT("client_ip");
        sql.SELECT("project_type");
        sql.SELECT("trade_type");
        sql.SELECT("weixin_open_id");
        sql.SELECT("expire_time");
        sql.SELECT("bussiness_type");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("bill_status");
        sql.SELECT("bill_id");
        sql.SELECT("bill_create_time");
        sql.SELECT("community_trade_no");
        sql.SELECT("bill_finished_time");
        sql.SELECT("total_amount");
        sql.SELECT("platform_charge");
        sql.SELECT("platform_charge_rate");
        sql.SELECT("service_charge");
        sql.SELECT("service_charge_rate");
        sql.SELECT("receipt_amount");
        sql.SELECT("think_charge_rate");
        sql.SELECT("think_charge");
        sql.SELECT("tixian_thrid");
        sql.SELECT("tixian_community");
        sql.SELECT("refund_status");
        sql.SELECT("refund_reason");
        sql.SELECT("refund_id");
        sql.SELECT("refund_remark");
        sql.SELECT("refund_create_time");
        sql.SELECT("refund_money");
        sql.SELECT("refund_bill_id");
        sql.SELECT("refund_sub_bill_id");
        sql.SELECT("refund_account_id");
        sql.SELECT("same_way");
        sql.SELECT("withdraw_status");
        sql.SELECT("type");
        sql.SELECT("service_charge_status");
        sql.SELECT("balance_status");
        sql.SELECT("service_charge_bill_id");
        sql.SELECT("service_account");
        sql.SELECT("service_account_mchid");
        sql.SELECT("merchant_bill_id");
        sql.SELECT("think_bill_id");
        sql.SELECT("bill_split_status");
        sql.SELECT("bill_split_time");
        sql.SELECT("split_amount");
        sql.SELECT("open_id");
        sql.SELECT("out_status");
        sql.SELECT("out_status_content");
        sql.SELECT("settle_id");
        sql.SELECT("pf_balance_status");
        sql.SELECT("pf_bussiness_balance_status");
        sql.SELECT("pf_refund_status");
        sql.SELECT("pf_refund_time");
        sql.SELECT("subject");
        sql.SELECT("body");
        sql.SELECT("detail");
        sql.SELECT("task_id");
        sql.SELECT("emp_guid");
        sql.SELECT("emp_phone");
        sql.SELECT("emp_name");
        sql.SELECT("task_rel_id");
        sql.SELECT("goods_detail");
        sql.FROM("open_order");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenOrderExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("total_id");
        sql.SELECT("account_id");
        sql.SELECT("think_account_id");
        sql.SELECT("community_id");
        sql.SELECT("app_id");
        sql.SELECT("service_id");
        sql.SELECT("uid");
        sql.SELECT("caution_id");
        sql.SELECT("pay_channel");
        sql.SELECT("out_trade_no");
        sql.SELECT("client_ip");
        sql.SELECT("project_type");
        sql.SELECT("trade_type");
        sql.SELECT("weixin_open_id");
        sql.SELECT("expire_time");
        sql.SELECT("bussiness_type");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("bill_status");
        sql.SELECT("bill_id");
        sql.SELECT("bill_create_time");
        sql.SELECT("community_trade_no");
        sql.SELECT("bill_finished_time");
        sql.SELECT("total_amount");
        sql.SELECT("platform_charge");
        sql.SELECT("platform_charge_rate");
        sql.SELECT("service_charge");
        sql.SELECT("service_charge_rate");
        sql.SELECT("receipt_amount");
        sql.SELECT("think_charge_rate");
        sql.SELECT("think_charge");
        sql.SELECT("tixian_thrid");
        sql.SELECT("tixian_community");
        sql.SELECT("refund_status");
        sql.SELECT("refund_reason");
        sql.SELECT("refund_id");
        sql.SELECT("refund_remark");
        sql.SELECT("refund_create_time");
        sql.SELECT("refund_money");
        sql.SELECT("refund_bill_id");
        sql.SELECT("refund_sub_bill_id");
        sql.SELECT("refund_account_id");
        sql.SELECT("same_way");
        sql.SELECT("withdraw_status");
        sql.SELECT("type");
        sql.SELECT("service_charge_status");
        sql.SELECT("balance_status");
        sql.SELECT("service_charge_bill_id");
        sql.SELECT("service_account");
        sql.SELECT("service_account_mchid");
        sql.SELECT("merchant_bill_id");
        sql.SELECT("think_bill_id");
        sql.SELECT("bill_split_status");
        sql.SELECT("bill_split_time");
        sql.SELECT("split_amount");
        sql.SELECT("open_id");
        sql.SELECT("out_status");
        sql.SELECT("out_status_content");
        sql.SELECT("settle_id");
        sql.SELECT("pf_balance_status");
        sql.SELECT("pf_bussiness_balance_status");
        sql.SELECT("pf_refund_status");
        sql.SELECT("pf_refund_time");
        sql.SELECT("subject");
        sql.SELECT("body");
        sql.SELECT("detail");
        sql.SELECT("task_id");
        sql.SELECT("emp_guid");
        sql.SELECT("emp_phone");
        sql.SELECT("emp_name");
        sql.SELECT("task_rel_id");
        sql.FROM("open_order");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenOrder record = (OpenOrder) parameter.get("record");
        OpenOrderExample example = (OpenOrderExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_order");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getTotalId() != null) {
            sql.SET("total_id = #{record.totalId,jdbcType=BIGINT}");
        }
        
        if (record.getAccountId() != null) {
            sql.SET("account_id = #{record.accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getThinkAccountId() != null) {
            sql.SET("think_account_id = #{record.thinkAccountId,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=BIGINT}");
        }
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{record.appId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        }
        
        if (record.getCautionId() != null) {
            sql.SET("caution_id = #{record.cautionId,jdbcType=BIGINT}");
        }
        
        if (record.getPayChannel() != null) {
            sql.SET("pay_channel = #{record.payChannel,jdbcType=VARCHAR}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.SET("out_trade_no = #{record.outTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getClientIp() != null) {
            sql.SET("client_ip = #{record.clientIp,jdbcType=VARCHAR}");
        }
        
        if (record.getProjectType() != null) {
            sql.SET("project_type = #{record.projectType,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeType() != null) {
            sql.SET("trade_type = #{record.tradeType,jdbcType=VARCHAR}");
        }
        
        if (record.getWeixinOpenId() != null) {
            sql.SET("weixin_open_id = #{record.weixinOpenId,jdbcType=VARCHAR}");
        }
        
        if (record.getExpireTime() != null) {
            sql.SET("expire_time = #{record.expireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBussinessType() != null) {
            sql.SET("bussiness_type = #{record.bussinessType,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBillStatus() != null) {
            sql.SET("bill_status = #{record.billStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBillId() != null) {
            sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        }
        
        if (record.getBillCreateTime() != null) {
            sql.SET("bill_create_time = #{record.billCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommunityTradeNo() != null) {
            sql.SET("community_trade_no = #{record.communityTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBillFinishedTime() != null) {
            sql.SET("bill_finished_time = #{record.billFinishedTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.SET("total_amount = #{record.totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformCharge() != null) {
            sql.SET("platform_charge = #{record.platformCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformChargeRate() != null) {
            sql.SET("platform_charge_rate = #{record.platformChargeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getServiceCharge() != null) {
            sql.SET("service_charge = #{record.serviceCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getServiceChargeRate() != null) {
            sql.SET("service_charge_rate = #{record.serviceChargeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getReceiptAmount() != null) {
            sql.SET("receipt_amount = #{record.receiptAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getThinkChargeRate() != null) {
            sql.SET("think_charge_rate = #{record.thinkChargeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getThinkCharge() != null) {
            sql.SET("think_charge = #{record.thinkCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getTixianThrid() != null) {
            sql.SET("tixian_thrid = #{record.tixianThrid,jdbcType=VARCHAR}");
        }
        
        if (record.getTixianCommunity() != null) {
            sql.SET("tixian_community = #{record.tixianCommunity,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundStatus() != null) {
            sql.SET("refund_status = #{record.refundStatus,jdbcType=INTEGER}");
        }
        
        if (record.getRefundReason() != null) {
            sql.SET("refund_reason = #{record.refundReason,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundId() != null) {
            sql.SET("refund_id = #{record.refundId,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundRemark() != null) {
            sql.SET("refund_remark = #{record.refundRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundCreateTime() != null) {
            sql.SET("refund_create_time = #{record.refundCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRefundMoney() != null) {
            sql.SET("refund_money = #{record.refundMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getRefundBillId() != null) {
            sql.SET("refund_bill_id = #{record.refundBillId,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundSubBillId() != null) {
            sql.SET("refund_sub_bill_id = #{record.refundSubBillId,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundAccountId() != null) {
            sql.SET("refund_account_id = #{record.refundAccountId,jdbcType=VARCHAR}");
        }
        
        if (record.getSameWay() != null) {
            sql.SET("same_way = #{record.sameWay,jdbcType=INTEGER}");
        }
        
        if (record.getWithdrawStatus() != null) {
            sql.SET("withdraw_status = #{record.withdrawStatus,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=INTEGER}");
        }
        
        if (record.getServiceChargeStatus() != null) {
            sql.SET("service_charge_status = #{record.serviceChargeStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBalanceStatus() != null) {
            sql.SET("balance_status = #{record.balanceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getServiceChargeBillId() != null) {
            sql.SET("service_charge_bill_id = #{record.serviceChargeBillId,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceAccount() != null) {
            sql.SET("service_account = #{record.serviceAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceAccountMchid() != null) {
            sql.SET("service_account_mchid = #{record.serviceAccountMchid,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantBillId() != null) {
            sql.SET("merchant_bill_id = #{record.merchantBillId,jdbcType=VARCHAR}");
        }
        
        if (record.getThinkBillId() != null) {
            sql.SET("think_bill_id = #{record.thinkBillId,jdbcType=VARCHAR}");
        }
        
        if (record.getBillSplitStatus() != null) {
            sql.SET("bill_split_status = #{record.billSplitStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBillSplitTime() != null) {
            sql.SET("bill_split_time = #{record.billSplitTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSplitAmount() != null) {
            sql.SET("split_amount = #{record.splitAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getOpenId() != null) {
            sql.SET("open_id = #{record.openId,jdbcType=VARCHAR}");
        }
        
        if (record.getOutStatus() != null) {
            sql.SET("out_status = #{record.outStatus,jdbcType=INTEGER}");
        }
        
        if (record.getOutStatusContent() != null) {
            sql.SET("out_status_content = #{record.outStatusContent,jdbcType=VARCHAR}");
        }
        
        if (record.getSettleId() != null) {
            sql.SET("settle_id = #{record.settleId,jdbcType=VARCHAR}");
        }
        
        if (record.getPfBalanceStatus() != null) {
            sql.SET("pf_balance_status = #{record.pfBalanceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPfBussinessBalanceStatus() != null) {
            sql.SET("pf_bussiness_balance_status = #{record.pfBussinessBalanceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPfRefundStatus() != null) {
            sql.SET("pf_refund_status = #{record.pfRefundStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPfRefundTime() != null) {
            sql.SET("pf_refund_time = #{record.pfRefundTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSubject() != null) {
            sql.SET("subject = #{record.subject,jdbcType=VARCHAR}");
        }
        
        if (record.getBody() != null) {
            sql.SET("body = #{record.body,jdbcType=VARCHAR}");
        }
        
        if (record.getDetail() != null) {
            sql.SET("detail = #{record.detail,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskId() != null) {
            sql.SET("task_id = #{record.taskId,jdbcType=BIGINT}");
        }
        
        if (record.getEmpGuid() != null) {
            sql.SET("emp_guid = #{record.empGuid,jdbcType=VARCHAR}");
        }
        
        if (record.getEmpPhone() != null) {
            sql.SET("emp_phone = #{record.empPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmpName() != null) {
            sql.SET("emp_name = #{record.empName,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRelId() != null) {
            sql.SET("task_rel_id = #{record.taskRelId,jdbcType=BIGINT}");
        }
        
        if (record.getGoodsDetail() != null) {
            sql.SET("goods_detail = #{record.goodsDetail,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_order");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("total_id = #{record.totalId,jdbcType=BIGINT}");
        sql.SET("account_id = #{record.accountId,jdbcType=VARCHAR}");
        sql.SET("think_account_id = #{record.thinkAccountId,jdbcType=VARCHAR}");
        sql.SET("community_id = #{record.communityId,jdbcType=BIGINT}");
        sql.SET("app_id = #{record.appId,jdbcType=BIGINT}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        sql.SET("caution_id = #{record.cautionId,jdbcType=BIGINT}");
        sql.SET("pay_channel = #{record.payChannel,jdbcType=VARCHAR}");
        sql.SET("out_trade_no = #{record.outTradeNo,jdbcType=VARCHAR}");
        sql.SET("client_ip = #{record.clientIp,jdbcType=VARCHAR}");
        sql.SET("project_type = #{record.projectType,jdbcType=VARCHAR}");
        sql.SET("trade_type = #{record.tradeType,jdbcType=VARCHAR}");
        sql.SET("weixin_open_id = #{record.weixinOpenId,jdbcType=VARCHAR}");
        sql.SET("expire_time = #{record.expireTime,jdbcType=TIMESTAMP}");
        sql.SET("bussiness_type = #{record.bussinessType,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("bill_status = #{record.billStatus,jdbcType=INTEGER}");
        sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        sql.SET("bill_create_time = #{record.billCreateTime,jdbcType=TIMESTAMP}");
        sql.SET("community_trade_no = #{record.communityTradeNo,jdbcType=VARCHAR}");
        sql.SET("bill_finished_time = #{record.billFinishedTime,jdbcType=TIMESTAMP}");
        sql.SET("total_amount = #{record.totalAmount,jdbcType=DECIMAL}");
        sql.SET("platform_charge = #{record.platformCharge,jdbcType=DECIMAL}");
        sql.SET("platform_charge_rate = #{record.platformChargeRate,jdbcType=DECIMAL}");
        sql.SET("service_charge = #{record.serviceCharge,jdbcType=DECIMAL}");
        sql.SET("service_charge_rate = #{record.serviceChargeRate,jdbcType=DECIMAL}");
        sql.SET("receipt_amount = #{record.receiptAmount,jdbcType=DECIMAL}");
        sql.SET("think_charge_rate = #{record.thinkChargeRate,jdbcType=DECIMAL}");
        sql.SET("think_charge = #{record.thinkCharge,jdbcType=DECIMAL}");
        sql.SET("tixian_thrid = #{record.tixianThrid,jdbcType=VARCHAR}");
        sql.SET("tixian_community = #{record.tixianCommunity,jdbcType=VARCHAR}");
        sql.SET("refund_status = #{record.refundStatus,jdbcType=INTEGER}");
        sql.SET("refund_reason = #{record.refundReason,jdbcType=VARCHAR}");
        sql.SET("refund_id = #{record.refundId,jdbcType=VARCHAR}");
        sql.SET("refund_remark = #{record.refundRemark,jdbcType=VARCHAR}");
        sql.SET("refund_create_time = #{record.refundCreateTime,jdbcType=TIMESTAMP}");
        sql.SET("refund_money = #{record.refundMoney,jdbcType=DECIMAL}");
        sql.SET("refund_bill_id = #{record.refundBillId,jdbcType=VARCHAR}");
        sql.SET("refund_sub_bill_id = #{record.refundSubBillId,jdbcType=VARCHAR}");
        sql.SET("refund_account_id = #{record.refundAccountId,jdbcType=VARCHAR}");
        sql.SET("same_way = #{record.sameWay,jdbcType=INTEGER}");
        sql.SET("withdraw_status = #{record.withdrawStatus,jdbcType=INTEGER}");
        sql.SET("type = #{record.type,jdbcType=INTEGER}");
        sql.SET("service_charge_status = #{record.serviceChargeStatus,jdbcType=INTEGER}");
        sql.SET("balance_status = #{record.balanceStatus,jdbcType=INTEGER}");
        sql.SET("service_charge_bill_id = #{record.serviceChargeBillId,jdbcType=VARCHAR}");
        sql.SET("service_account = #{record.serviceAccount,jdbcType=VARCHAR}");
        sql.SET("service_account_mchid = #{record.serviceAccountMchid,jdbcType=VARCHAR}");
        sql.SET("merchant_bill_id = #{record.merchantBillId,jdbcType=VARCHAR}");
        sql.SET("think_bill_id = #{record.thinkBillId,jdbcType=VARCHAR}");
        sql.SET("bill_split_status = #{record.billSplitStatus,jdbcType=INTEGER}");
        sql.SET("bill_split_time = #{record.billSplitTime,jdbcType=TIMESTAMP}");
        sql.SET("split_amount = #{record.splitAmount,jdbcType=DECIMAL}");
        sql.SET("open_id = #{record.openId,jdbcType=VARCHAR}");
        sql.SET("out_status = #{record.outStatus,jdbcType=INTEGER}");
        sql.SET("out_status_content = #{record.outStatusContent,jdbcType=VARCHAR}");
        sql.SET("settle_id = #{record.settleId,jdbcType=VARCHAR}");
        sql.SET("pf_balance_status = #{record.pfBalanceStatus,jdbcType=INTEGER}");
        sql.SET("pf_bussiness_balance_status = #{record.pfBussinessBalanceStatus,jdbcType=INTEGER}");
        sql.SET("pf_refund_status = #{record.pfRefundStatus,jdbcType=INTEGER}");
        sql.SET("pf_refund_time = #{record.pfRefundTime,jdbcType=TIMESTAMP}");
        sql.SET("subject = #{record.subject,jdbcType=VARCHAR}");
        sql.SET("body = #{record.body,jdbcType=VARCHAR}");
        sql.SET("detail = #{record.detail,jdbcType=VARCHAR}");
        sql.SET("task_id = #{record.taskId,jdbcType=BIGINT}");
        sql.SET("emp_guid = #{record.empGuid,jdbcType=VARCHAR}");
        sql.SET("emp_phone = #{record.empPhone,jdbcType=VARCHAR}");
        sql.SET("emp_name = #{record.empName,jdbcType=VARCHAR}");
        sql.SET("task_rel_id = #{record.taskRelId,jdbcType=BIGINT}");
        sql.SET("goods_detail = #{record.goodsDetail,jdbcType=LONGVARCHAR}");
        
        OpenOrderExample example = (OpenOrderExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_order");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("total_id = #{record.totalId,jdbcType=BIGINT}");
        sql.SET("account_id = #{record.accountId,jdbcType=VARCHAR}");
        sql.SET("think_account_id = #{record.thinkAccountId,jdbcType=VARCHAR}");
        sql.SET("community_id = #{record.communityId,jdbcType=BIGINT}");
        sql.SET("app_id = #{record.appId,jdbcType=BIGINT}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        sql.SET("caution_id = #{record.cautionId,jdbcType=BIGINT}");
        sql.SET("pay_channel = #{record.payChannel,jdbcType=VARCHAR}");
        sql.SET("out_trade_no = #{record.outTradeNo,jdbcType=VARCHAR}");
        sql.SET("client_ip = #{record.clientIp,jdbcType=VARCHAR}");
        sql.SET("project_type = #{record.projectType,jdbcType=VARCHAR}");
        sql.SET("trade_type = #{record.tradeType,jdbcType=VARCHAR}");
        sql.SET("weixin_open_id = #{record.weixinOpenId,jdbcType=VARCHAR}");
        sql.SET("expire_time = #{record.expireTime,jdbcType=TIMESTAMP}");
        sql.SET("bussiness_type = #{record.bussinessType,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("bill_status = #{record.billStatus,jdbcType=INTEGER}");
        sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        sql.SET("bill_create_time = #{record.billCreateTime,jdbcType=TIMESTAMP}");
        sql.SET("community_trade_no = #{record.communityTradeNo,jdbcType=VARCHAR}");
        sql.SET("bill_finished_time = #{record.billFinishedTime,jdbcType=TIMESTAMP}");
        sql.SET("total_amount = #{record.totalAmount,jdbcType=DECIMAL}");
        sql.SET("platform_charge = #{record.platformCharge,jdbcType=DECIMAL}");
        sql.SET("platform_charge_rate = #{record.platformChargeRate,jdbcType=DECIMAL}");
        sql.SET("service_charge = #{record.serviceCharge,jdbcType=DECIMAL}");
        sql.SET("service_charge_rate = #{record.serviceChargeRate,jdbcType=DECIMAL}");
        sql.SET("receipt_amount = #{record.receiptAmount,jdbcType=DECIMAL}");
        sql.SET("think_charge_rate = #{record.thinkChargeRate,jdbcType=DECIMAL}");
        sql.SET("think_charge = #{record.thinkCharge,jdbcType=DECIMAL}");
        sql.SET("tixian_thrid = #{record.tixianThrid,jdbcType=VARCHAR}");
        sql.SET("tixian_community = #{record.tixianCommunity,jdbcType=VARCHAR}");
        sql.SET("refund_status = #{record.refundStatus,jdbcType=INTEGER}");
        sql.SET("refund_reason = #{record.refundReason,jdbcType=VARCHAR}");
        sql.SET("refund_id = #{record.refundId,jdbcType=VARCHAR}");
        sql.SET("refund_remark = #{record.refundRemark,jdbcType=VARCHAR}");
        sql.SET("refund_create_time = #{record.refundCreateTime,jdbcType=TIMESTAMP}");
        sql.SET("refund_money = #{record.refundMoney,jdbcType=DECIMAL}");
        sql.SET("refund_bill_id = #{record.refundBillId,jdbcType=VARCHAR}");
        sql.SET("refund_sub_bill_id = #{record.refundSubBillId,jdbcType=VARCHAR}");
        sql.SET("refund_account_id = #{record.refundAccountId,jdbcType=VARCHAR}");
        sql.SET("same_way = #{record.sameWay,jdbcType=INTEGER}");
        sql.SET("withdraw_status = #{record.withdrawStatus,jdbcType=INTEGER}");
        sql.SET("type = #{record.type,jdbcType=INTEGER}");
        sql.SET("service_charge_status = #{record.serviceChargeStatus,jdbcType=INTEGER}");
        sql.SET("balance_status = #{record.balanceStatus,jdbcType=INTEGER}");
        sql.SET("service_charge_bill_id = #{record.serviceChargeBillId,jdbcType=VARCHAR}");
        sql.SET("service_account = #{record.serviceAccount,jdbcType=VARCHAR}");
        sql.SET("service_account_mchid = #{record.serviceAccountMchid,jdbcType=VARCHAR}");
        sql.SET("merchant_bill_id = #{record.merchantBillId,jdbcType=VARCHAR}");
        sql.SET("think_bill_id = #{record.thinkBillId,jdbcType=VARCHAR}");
        sql.SET("bill_split_status = #{record.billSplitStatus,jdbcType=INTEGER}");
        sql.SET("bill_split_time = #{record.billSplitTime,jdbcType=TIMESTAMP}");
        sql.SET("split_amount = #{record.splitAmount,jdbcType=DECIMAL}");
        sql.SET("open_id = #{record.openId,jdbcType=VARCHAR}");
        sql.SET("out_status = #{record.outStatus,jdbcType=INTEGER}");
        sql.SET("out_status_content = #{record.outStatusContent,jdbcType=VARCHAR}");
        sql.SET("settle_id = #{record.settleId,jdbcType=VARCHAR}");
        sql.SET("pf_balance_status = #{record.pfBalanceStatus,jdbcType=INTEGER}");
        sql.SET("pf_bussiness_balance_status = #{record.pfBussinessBalanceStatus,jdbcType=INTEGER}");
        sql.SET("pf_refund_status = #{record.pfRefundStatus,jdbcType=INTEGER}");
        sql.SET("pf_refund_time = #{record.pfRefundTime,jdbcType=TIMESTAMP}");
        sql.SET("subject = #{record.subject,jdbcType=VARCHAR}");
        sql.SET("body = #{record.body,jdbcType=VARCHAR}");
        sql.SET("detail = #{record.detail,jdbcType=VARCHAR}");
        sql.SET("task_id = #{record.taskId,jdbcType=BIGINT}");
        sql.SET("emp_guid = #{record.empGuid,jdbcType=VARCHAR}");
        sql.SET("emp_phone = #{record.empPhone,jdbcType=VARCHAR}");
        sql.SET("emp_name = #{record.empName,jdbcType=VARCHAR}");
        sql.SET("task_rel_id = #{record.taskRelId,jdbcType=BIGINT}");
        
        OpenOrderExample example = (OpenOrderExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenOrder record) {
        SQL sql = new SQL();
        sql.UPDATE("open_order");
        
        if (record.getTotalId() != null) {
            sql.SET("total_id = #{totalId,jdbcType=BIGINT}");
        }
        
        if (record.getAccountId() != null) {
            sql.SET("account_id = #{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getThinkAccountId() != null) {
            sql.SET("think_account_id = #{thinkAccountId,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=BIGINT}");
        }
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{appId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=BIGINT}");
        }
        
        if (record.getCautionId() != null) {
            sql.SET("caution_id = #{cautionId,jdbcType=BIGINT}");
        }
        
        if (record.getPayChannel() != null) {
            sql.SET("pay_channel = #{payChannel,jdbcType=VARCHAR}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.SET("out_trade_no = #{outTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getClientIp() != null) {
            sql.SET("client_ip = #{clientIp,jdbcType=VARCHAR}");
        }
        
        if (record.getProjectType() != null) {
            sql.SET("project_type = #{projectType,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeType() != null) {
            sql.SET("trade_type = #{tradeType,jdbcType=VARCHAR}");
        }
        
        if (record.getWeixinOpenId() != null) {
            sql.SET("weixin_open_id = #{weixinOpenId,jdbcType=VARCHAR}");
        }
        
        if (record.getExpireTime() != null) {
            sql.SET("expire_time = #{expireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBussinessType() != null) {
            sql.SET("bussiness_type = #{bussinessType,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBillStatus() != null) {
            sql.SET("bill_status = #{billStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBillId() != null) {
            sql.SET("bill_id = #{billId,jdbcType=VARCHAR}");
        }
        
        if (record.getBillCreateTime() != null) {
            sql.SET("bill_create_time = #{billCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommunityTradeNo() != null) {
            sql.SET("community_trade_no = #{communityTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBillFinishedTime() != null) {
            sql.SET("bill_finished_time = #{billFinishedTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.SET("total_amount = #{totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformCharge() != null) {
            sql.SET("platform_charge = #{platformCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformChargeRate() != null) {
            sql.SET("platform_charge_rate = #{platformChargeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getServiceCharge() != null) {
            sql.SET("service_charge = #{serviceCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getServiceChargeRate() != null) {
            sql.SET("service_charge_rate = #{serviceChargeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getReceiptAmount() != null) {
            sql.SET("receipt_amount = #{receiptAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getThinkChargeRate() != null) {
            sql.SET("think_charge_rate = #{thinkChargeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getThinkCharge() != null) {
            sql.SET("think_charge = #{thinkCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getTixianThrid() != null) {
            sql.SET("tixian_thrid = #{tixianThrid,jdbcType=VARCHAR}");
        }
        
        if (record.getTixianCommunity() != null) {
            sql.SET("tixian_community = #{tixianCommunity,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundStatus() != null) {
            sql.SET("refund_status = #{refundStatus,jdbcType=INTEGER}");
        }
        
        if (record.getRefundReason() != null) {
            sql.SET("refund_reason = #{refundReason,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundId() != null) {
            sql.SET("refund_id = #{refundId,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundRemark() != null) {
            sql.SET("refund_remark = #{refundRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundCreateTime() != null) {
            sql.SET("refund_create_time = #{refundCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRefundMoney() != null) {
            sql.SET("refund_money = #{refundMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getRefundBillId() != null) {
            sql.SET("refund_bill_id = #{refundBillId,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundSubBillId() != null) {
            sql.SET("refund_sub_bill_id = #{refundSubBillId,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundAccountId() != null) {
            sql.SET("refund_account_id = #{refundAccountId,jdbcType=VARCHAR}");
        }
        
        if (record.getSameWay() != null) {
            sql.SET("same_way = #{sameWay,jdbcType=INTEGER}");
        }
        
        if (record.getWithdrawStatus() != null) {
            sql.SET("withdraw_status = #{withdrawStatus,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getServiceChargeStatus() != null) {
            sql.SET("service_charge_status = #{serviceChargeStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBalanceStatus() != null) {
            sql.SET("balance_status = #{balanceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getServiceChargeBillId() != null) {
            sql.SET("service_charge_bill_id = #{serviceChargeBillId,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceAccount() != null) {
            sql.SET("service_account = #{serviceAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceAccountMchid() != null) {
            sql.SET("service_account_mchid = #{serviceAccountMchid,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantBillId() != null) {
            sql.SET("merchant_bill_id = #{merchantBillId,jdbcType=VARCHAR}");
        }
        
        if (record.getThinkBillId() != null) {
            sql.SET("think_bill_id = #{thinkBillId,jdbcType=VARCHAR}");
        }
        
        if (record.getBillSplitStatus() != null) {
            sql.SET("bill_split_status = #{billSplitStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBillSplitTime() != null) {
            sql.SET("bill_split_time = #{billSplitTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSplitAmount() != null) {
            sql.SET("split_amount = #{splitAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getOpenId() != null) {
            sql.SET("open_id = #{openId,jdbcType=VARCHAR}");
        }
        
        if (record.getOutStatus() != null) {
            sql.SET("out_status = #{outStatus,jdbcType=INTEGER}");
        }
        
        if (record.getOutStatusContent() != null) {
            sql.SET("out_status_content = #{outStatusContent,jdbcType=VARCHAR}");
        }
        
        if (record.getSettleId() != null) {
            sql.SET("settle_id = #{settleId,jdbcType=VARCHAR}");
        }
        
        if (record.getPfBalanceStatus() != null) {
            sql.SET("pf_balance_status = #{pfBalanceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPfBussinessBalanceStatus() != null) {
            sql.SET("pf_bussiness_balance_status = #{pfBussinessBalanceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPfRefundStatus() != null) {
            sql.SET("pf_refund_status = #{pfRefundStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPfRefundTime() != null) {
            sql.SET("pf_refund_time = #{pfRefundTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSubject() != null) {
            sql.SET("subject = #{subject,jdbcType=VARCHAR}");
        }
        
        if (record.getBody() != null) {
            sql.SET("body = #{body,jdbcType=VARCHAR}");
        }
        
        if (record.getDetail() != null) {
            sql.SET("detail = #{detail,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskId() != null) {
            sql.SET("task_id = #{taskId,jdbcType=BIGINT}");
        }
        
        if (record.getEmpGuid() != null) {
            sql.SET("emp_guid = #{empGuid,jdbcType=VARCHAR}");
        }
        
        if (record.getEmpPhone() != null) {
            sql.SET("emp_phone = #{empPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmpName() != null) {
            sql.SET("emp_name = #{empName,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRelId() != null) {
            sql.SET("task_rel_id = #{taskRelId,jdbcType=BIGINT}");
        }
        
        if (record.getGoodsDetail() != null) {
            sql.SET("goods_detail = #{goodsDetail,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenOrderExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}