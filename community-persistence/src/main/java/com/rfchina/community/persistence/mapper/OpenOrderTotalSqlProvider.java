package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenOrderTotal;
import com.rfchina.community.persistence.model.OpenOrderTotalExample.Criteria;
import com.rfchina.community.persistence.model.OpenOrderTotalExample.Criterion;
import com.rfchina.community.persistence.model.OpenOrderTotalExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenOrderTotalSqlProvider {

    public String countByExample(OpenOrderTotalExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_order_total");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenOrderTotalExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_order_total");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenOrderTotal record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_order_total");
        
        if (record.getAccountId() != null) {
            sql.VALUES("account_id", "#{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityAccountId() != null) {
            sql.VALUES("community_account_id", "#{communityAccountId,jdbcType=VARCHAR}");
        }
        
        if (record.getThinkAccountId() != null) {
            sql.VALUES("think_account_id", "#{thinkAccountId,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=BIGINT}");
        }
        
        if (record.getExpireTime() != null) {
            sql.VALUES("expire_time", "#{expireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getBillId() != null) {
            sql.VALUES("bill_id", "#{billId,jdbcType=VARCHAR}");
        }
        
        if (record.getBillStatus() != null) {
            sql.VALUES("bill_status", "#{billStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBillFinishedTime() != null) {
            sql.VALUES("bill_finished_time", "#{billFinishedTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommunityTradeNo() != null) {
            sql.VALUES("community_trade_no", "#{communityTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.VALUES("total_amount", "#{totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalPlatformCharge() != null) {
            sql.VALUES("total_platform_charge", "#{totalPlatformCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalToServiceCharge() != null) {
            sql.VALUES("total_to_service_charge", "#{totalToServiceCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalServiceCharge() != null) {
            sql.VALUES("total_service_charge", "#{totalServiceCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalToReceiptAmount() != null) {
            sql.VALUES("total_to_receipt_amount", "#{totalToReceiptAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalReceiptAmount() != null) {
            sql.VALUES("total_receipt_amount", "#{totalReceiptAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalThinkToAmount() != null) {
            sql.VALUES("total_think_to_amount", "#{totalThinkToAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalThinkAmount() != null) {
            sql.VALUES("total_think_amount", "#{totalThinkAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalRefundMoney() != null) {
            sql.VALUES("total_refund_money", "#{totalRefundMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getRefundCount() != null) {
            sql.VALUES("refund_count", "#{refundCount,jdbcType=INTEGER}");
        }
        
        if (record.getStoreCount() != null) {
            sql.VALUES("store_count", "#{storeCount,jdbcType=INTEGER}");
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
        
        if (record.getPfBalanceStatus() != null) {
            sql.VALUES("pf_balance_status", "#{pfBalanceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPfBussinessBalanceStatus() != null) {
            sql.VALUES("pf_bussiness_balance_status", "#{pfBussinessBalanceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPfPayStatus() != null) {
            sql.VALUES("pf_pay_status", "#{pfPayStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPfRefundStatus() != null) {
            sql.VALUES("pf_refund_status", "#{pfRefundStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSubject() != null) {
            sql.VALUES("subject", "#{subject,jdbcType=VARCHAR}");
        }
        
        if (record.getPayChannel() != null) {
            sql.VALUES("pay_channel", "#{payChannel,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenOrderTotalExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("account_id");
        sql.SELECT("community_id");
        sql.SELECT("community_account_id");
        sql.SELECT("think_account_id");
        sql.SELECT("uid");
        sql.SELECT("expire_time");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("type");
        sql.SELECT("bill_id");
        sql.SELECT("bill_status");
        sql.SELECT("bill_finished_time");
        sql.SELECT("community_trade_no");
        sql.SELECT("total_amount");
        sql.SELECT("total_platform_charge");
        sql.SELECT("total_to_service_charge");
        sql.SELECT("total_service_charge");
        sql.SELECT("total_to_receipt_amount");
        sql.SELECT("total_receipt_amount");
        sql.SELECT("total_think_to_amount");
        sql.SELECT("total_think_amount");
        sql.SELECT("total_refund_money");
        sql.SELECT("refund_count");
        sql.SELECT("store_count");
        sql.SELECT("bill_split_status");
        sql.SELECT("bill_split_time");
        sql.SELECT("split_amount");
        sql.SELECT("pf_balance_status");
        sql.SELECT("pf_bussiness_balance_status");
        sql.SELECT("pf_pay_status");
        sql.SELECT("pf_refund_status");
        sql.SELECT("subject");
        sql.SELECT("pay_channel");
        sql.FROM("open_order_total");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenOrderTotal record = (OpenOrderTotal) parameter.get("record");
        OpenOrderTotalExample example = (OpenOrderTotalExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_order_total");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getAccountId() != null) {
            sql.SET("account_id = #{record.accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityAccountId() != null) {
            sql.SET("community_account_id = #{record.communityAccountId,jdbcType=VARCHAR}");
        }
        
        if (record.getThinkAccountId() != null) {
            sql.SET("think_account_id = #{record.thinkAccountId,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        }
        
        if (record.getExpireTime() != null) {
            sql.SET("expire_time = #{record.expireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=INTEGER}");
        }
        
        if (record.getBillId() != null) {
            sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        }
        
        if (record.getBillStatus() != null) {
            sql.SET("bill_status = #{record.billStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBillFinishedTime() != null) {
            sql.SET("bill_finished_time = #{record.billFinishedTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommunityTradeNo() != null) {
            sql.SET("community_trade_no = #{record.communityTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.SET("total_amount = #{record.totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalPlatformCharge() != null) {
            sql.SET("total_platform_charge = #{record.totalPlatformCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalToServiceCharge() != null) {
            sql.SET("total_to_service_charge = #{record.totalToServiceCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalServiceCharge() != null) {
            sql.SET("total_service_charge = #{record.totalServiceCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalToReceiptAmount() != null) {
            sql.SET("total_to_receipt_amount = #{record.totalToReceiptAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalReceiptAmount() != null) {
            sql.SET("total_receipt_amount = #{record.totalReceiptAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalThinkToAmount() != null) {
            sql.SET("total_think_to_amount = #{record.totalThinkToAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalThinkAmount() != null) {
            sql.SET("total_think_amount = #{record.totalThinkAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalRefundMoney() != null) {
            sql.SET("total_refund_money = #{record.totalRefundMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getRefundCount() != null) {
            sql.SET("refund_count = #{record.refundCount,jdbcType=INTEGER}");
        }
        
        if (record.getStoreCount() != null) {
            sql.SET("store_count = #{record.storeCount,jdbcType=INTEGER}");
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
        
        if (record.getPfBalanceStatus() != null) {
            sql.SET("pf_balance_status = #{record.pfBalanceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPfBussinessBalanceStatus() != null) {
            sql.SET("pf_bussiness_balance_status = #{record.pfBussinessBalanceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPfPayStatus() != null) {
            sql.SET("pf_pay_status = #{record.pfPayStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPfRefundStatus() != null) {
            sql.SET("pf_refund_status = #{record.pfRefundStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSubject() != null) {
            sql.SET("subject = #{record.subject,jdbcType=VARCHAR}");
        }
        
        if (record.getPayChannel() != null) {
            sql.SET("pay_channel = #{record.payChannel,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_order_total");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("account_id = #{record.accountId,jdbcType=VARCHAR}");
        sql.SET("community_id = #{record.communityId,jdbcType=BIGINT}");
        sql.SET("community_account_id = #{record.communityAccountId,jdbcType=VARCHAR}");
        sql.SET("think_account_id = #{record.thinkAccountId,jdbcType=VARCHAR}");
        sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        sql.SET("expire_time = #{record.expireTime,jdbcType=TIMESTAMP}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("type = #{record.type,jdbcType=INTEGER}");
        sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        sql.SET("bill_status = #{record.billStatus,jdbcType=INTEGER}");
        sql.SET("bill_finished_time = #{record.billFinishedTime,jdbcType=TIMESTAMP}");
        sql.SET("community_trade_no = #{record.communityTradeNo,jdbcType=VARCHAR}");
        sql.SET("total_amount = #{record.totalAmount,jdbcType=DECIMAL}");
        sql.SET("total_platform_charge = #{record.totalPlatformCharge,jdbcType=DECIMAL}");
        sql.SET("total_to_service_charge = #{record.totalToServiceCharge,jdbcType=DECIMAL}");
        sql.SET("total_service_charge = #{record.totalServiceCharge,jdbcType=DECIMAL}");
        sql.SET("total_to_receipt_amount = #{record.totalToReceiptAmount,jdbcType=DECIMAL}");
        sql.SET("total_receipt_amount = #{record.totalReceiptAmount,jdbcType=DECIMAL}");
        sql.SET("total_think_to_amount = #{record.totalThinkToAmount,jdbcType=DECIMAL}");
        sql.SET("total_think_amount = #{record.totalThinkAmount,jdbcType=DECIMAL}");
        sql.SET("total_refund_money = #{record.totalRefundMoney,jdbcType=DECIMAL}");
        sql.SET("refund_count = #{record.refundCount,jdbcType=INTEGER}");
        sql.SET("store_count = #{record.storeCount,jdbcType=INTEGER}");
        sql.SET("bill_split_status = #{record.billSplitStatus,jdbcType=INTEGER}");
        sql.SET("bill_split_time = #{record.billSplitTime,jdbcType=TIMESTAMP}");
        sql.SET("split_amount = #{record.splitAmount,jdbcType=DECIMAL}");
        sql.SET("pf_balance_status = #{record.pfBalanceStatus,jdbcType=INTEGER}");
        sql.SET("pf_bussiness_balance_status = #{record.pfBussinessBalanceStatus,jdbcType=INTEGER}");
        sql.SET("pf_pay_status = #{record.pfPayStatus,jdbcType=INTEGER}");
        sql.SET("pf_refund_status = #{record.pfRefundStatus,jdbcType=INTEGER}");
        sql.SET("subject = #{record.subject,jdbcType=VARCHAR}");
        sql.SET("pay_channel = #{record.payChannel,jdbcType=VARCHAR}");
        
        OpenOrderTotalExample example = (OpenOrderTotalExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenOrderTotal record) {
        SQL sql = new SQL();
        sql.UPDATE("open_order_total");
        
        if (record.getAccountId() != null) {
            sql.SET("account_id = #{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityAccountId() != null) {
            sql.SET("community_account_id = #{communityAccountId,jdbcType=VARCHAR}");
        }
        
        if (record.getThinkAccountId() != null) {
            sql.SET("think_account_id = #{thinkAccountId,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=BIGINT}");
        }
        
        if (record.getExpireTime() != null) {
            sql.SET("expire_time = #{expireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getBillId() != null) {
            sql.SET("bill_id = #{billId,jdbcType=VARCHAR}");
        }
        
        if (record.getBillStatus() != null) {
            sql.SET("bill_status = #{billStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBillFinishedTime() != null) {
            sql.SET("bill_finished_time = #{billFinishedTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommunityTradeNo() != null) {
            sql.SET("community_trade_no = #{communityTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.SET("total_amount = #{totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalPlatformCharge() != null) {
            sql.SET("total_platform_charge = #{totalPlatformCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalToServiceCharge() != null) {
            sql.SET("total_to_service_charge = #{totalToServiceCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalServiceCharge() != null) {
            sql.SET("total_service_charge = #{totalServiceCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalToReceiptAmount() != null) {
            sql.SET("total_to_receipt_amount = #{totalToReceiptAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalReceiptAmount() != null) {
            sql.SET("total_receipt_amount = #{totalReceiptAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalThinkToAmount() != null) {
            sql.SET("total_think_to_amount = #{totalThinkToAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalThinkAmount() != null) {
            sql.SET("total_think_amount = #{totalThinkAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalRefundMoney() != null) {
            sql.SET("total_refund_money = #{totalRefundMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getRefundCount() != null) {
            sql.SET("refund_count = #{refundCount,jdbcType=INTEGER}");
        }
        
        if (record.getStoreCount() != null) {
            sql.SET("store_count = #{storeCount,jdbcType=INTEGER}");
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
        
        if (record.getPfBalanceStatus() != null) {
            sql.SET("pf_balance_status = #{pfBalanceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPfBussinessBalanceStatus() != null) {
            sql.SET("pf_bussiness_balance_status = #{pfBussinessBalanceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPfPayStatus() != null) {
            sql.SET("pf_pay_status = #{pfPayStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPfRefundStatus() != null) {
            sql.SET("pf_refund_status = #{pfRefundStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSubject() != null) {
            sql.SET("subject = #{subject,jdbcType=VARCHAR}");
        }
        
        if (record.getPayChannel() != null) {
            sql.SET("pay_channel = #{payChannel,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenOrderTotalExample example, boolean includeExamplePhrase) {
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