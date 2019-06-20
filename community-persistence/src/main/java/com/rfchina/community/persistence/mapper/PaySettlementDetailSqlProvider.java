package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.PaySettlementDetail;
import com.rfchina.community.persistence.model.PaySettlementDetailExample.Criteria;
import com.rfchina.community.persistence.model.PaySettlementDetailExample.Criterion;
import com.rfchina.community.persistence.model.PaySettlementDetailExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class PaySettlementDetailSqlProvider {

    public String countByExample(PaySettlementDetailExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("pay_settlement_detail");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(PaySettlementDetailExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("pay_settlement_detail");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(PaySettlementDetail record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("pay_settlement_detail");
        
        if (record.getMyCreateTime() != null) {
            sql.VALUES("my_create_time", "#{myCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMyCompare() != null) {
            sql.VALUES("my_compare", "#{myCompare,jdbcType=INTEGER}");
        }
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getSid() != null) {
            sql.VALUES("sid", "#{sid,jdbcType=VARCHAR}");
        }
        
        if (record.getBillId() != null) {
            sql.VALUES("bill_id", "#{billId,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountId() != null) {
            sql.VALUES("account_id", "#{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getMchId() != null) {
            sql.VALUES("mch_id", "#{mchId,jdbcType=VARCHAR}");
        }
        
        if (record.getAppId() != null) {
            sql.VALUES("app_id", "#{appId,jdbcType=BIGINT}");
        }
        
        if (record.getSubject() != null) {
            sql.VALUES("subject", "#{subject,jdbcType=VARCHAR}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.VALUES("out_trade_no", "#{outTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCmpOutTradeNo() != null) {
            sql.VALUES("cmp_out_trade_no", "#{cmpOutTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.VALUES("total_amount", "#{totalAmount,jdbcType=BIGINT}");
        }
        
        if (record.getReceiptAmount() != null) {
            sql.VALUES("receipt_amount", "#{receiptAmount,jdbcType=BIGINT}");
        }
        
        if (record.getFeeAmount() != null) {
            sql.VALUES("fee_amount", "#{feeAmount,jdbcType=BIGINT}");
        }
        
        if (record.getCmpTotalAmount() != null) {
            sql.VALUES("cmp_total_amount", "#{cmpTotalAmount,jdbcType=BIGINT}");
        }
        
        if (record.getCmpReceiptAmount() != null) {
            sql.VALUES("cmp_receipt_amount", "#{cmpReceiptAmount,jdbcType=BIGINT}");
        }
        
        if (record.getCmpFeeAmount() != null) {
            sql.VALUES("cmp_fee_amount", "#{cmpFeeAmount,jdbcType=BIGINT}");
        }
        
        if (record.getCmpRefundFee() != null) {
            sql.VALUES("cmp_refund_fee", "#{cmpRefundFee,jdbcType=BIGINT}");
        }
        
        if (record.getBillCreateTime() != null) {
            sql.VALUES("bill_create_time", "#{billCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getPayChannelId() != null) {
            sql.VALUES("pay_channel_id", "#{payChannelId,jdbcType=INTEGER}");
        }
        
        if (record.getPayChannel() != null) {
            sql.VALUES("pay_channel", "#{payChannel,jdbcType=VARCHAR}");
        }
        
        if (record.getBalanceStatus() != null) {
            sql.VALUES("balance_status", "#{balanceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBussinessBalanceStatus() != null) {
            sql.VALUES("bussiness_balance_status", "#{bussinessBalanceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getTradeType() != null) {
            sql.VALUES("trade_type", "#{tradeType,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundStatus() != null) {
            sql.VALUES("refund_status", "#{refundStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBody() != null) {
            sql.VALUES("body", "#{body,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(PaySettlementDetailExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("my_id");
        } else {
            sql.SELECT("my_id");
        }
        sql.SELECT("my_create_time");
        sql.SELECT("my_compare");
        sql.SELECT("id");
        sql.SELECT("sid");
        sql.SELECT("bill_id");
        sql.SELECT("account_id");
        sql.SELECT("mch_id");
        sql.SELECT("app_id");
        sql.SELECT("subject");
        sql.SELECT("out_trade_no");
        sql.SELECT("cmp_out_trade_no");
        sql.SELECT("total_amount");
        sql.SELECT("receipt_amount");
        sql.SELECT("fee_amount");
        sql.SELECT("cmp_total_amount");
        sql.SELECT("cmp_receipt_amount");
        sql.SELECT("cmp_fee_amount");
        sql.SELECT("cmp_refund_fee");
        sql.SELECT("bill_create_time");
        sql.SELECT("create_time");
        sql.SELECT("status");
        sql.SELECT("pay_channel_id");
        sql.SELECT("pay_channel");
        sql.SELECT("balance_status");
        sql.SELECT("bussiness_balance_status");
        sql.SELECT("trade_type");
        sql.SELECT("refund_status");
        sql.SELECT("body");
        sql.FROM("pay_settlement_detail");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(PaySettlementDetailExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("my_id");
        } else {
            sql.SELECT("my_id");
        }
        sql.SELECT("my_create_time");
        sql.SELECT("my_compare");
        sql.SELECT("id");
        sql.SELECT("sid");
        sql.SELECT("bill_id");
        sql.SELECT("account_id");
        sql.SELECT("mch_id");
        sql.SELECT("app_id");
        sql.SELECT("subject");
        sql.SELECT("out_trade_no");
        sql.SELECT("cmp_out_trade_no");
        sql.SELECT("total_amount");
        sql.SELECT("receipt_amount");
        sql.SELECT("fee_amount");
        sql.SELECT("cmp_total_amount");
        sql.SELECT("cmp_receipt_amount");
        sql.SELECT("cmp_fee_amount");
        sql.SELECT("cmp_refund_fee");
        sql.SELECT("bill_create_time");
        sql.SELECT("create_time");
        sql.SELECT("status");
        sql.SELECT("pay_channel_id");
        sql.SELECT("pay_channel");
        sql.SELECT("balance_status");
        sql.SELECT("bussiness_balance_status");
        sql.SELECT("trade_type");
        sql.SELECT("refund_status");
        sql.FROM("pay_settlement_detail");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PaySettlementDetail record = (PaySettlementDetail) parameter.get("record");
        PaySettlementDetailExample example = (PaySettlementDetailExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("pay_settlement_detail");
        
        if (record.getMyId() != null) {
            sql.SET("my_id = #{record.myId,jdbcType=BIGINT}");
        }
        
        if (record.getMyCreateTime() != null) {
            sql.SET("my_create_time = #{record.myCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMyCompare() != null) {
            sql.SET("my_compare = #{record.myCompare,jdbcType=INTEGER}");
        }
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getSid() != null) {
            sql.SET("sid = #{record.sid,jdbcType=VARCHAR}");
        }
        
        if (record.getBillId() != null) {
            sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountId() != null) {
            sql.SET("account_id = #{record.accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getMchId() != null) {
            sql.SET("mch_id = #{record.mchId,jdbcType=VARCHAR}");
        }
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{record.appId,jdbcType=BIGINT}");
        }
        
        if (record.getSubject() != null) {
            sql.SET("subject = #{record.subject,jdbcType=VARCHAR}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.SET("out_trade_no = #{record.outTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCmpOutTradeNo() != null) {
            sql.SET("cmp_out_trade_no = #{record.cmpOutTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.SET("total_amount = #{record.totalAmount,jdbcType=BIGINT}");
        }
        
        if (record.getReceiptAmount() != null) {
            sql.SET("receipt_amount = #{record.receiptAmount,jdbcType=BIGINT}");
        }
        
        if (record.getFeeAmount() != null) {
            sql.SET("fee_amount = #{record.feeAmount,jdbcType=BIGINT}");
        }
        
        if (record.getCmpTotalAmount() != null) {
            sql.SET("cmp_total_amount = #{record.cmpTotalAmount,jdbcType=BIGINT}");
        }
        
        if (record.getCmpReceiptAmount() != null) {
            sql.SET("cmp_receipt_amount = #{record.cmpReceiptAmount,jdbcType=BIGINT}");
        }
        
        if (record.getCmpFeeAmount() != null) {
            sql.SET("cmp_fee_amount = #{record.cmpFeeAmount,jdbcType=BIGINT}");
        }
        
        if (record.getCmpRefundFee() != null) {
            sql.SET("cmp_refund_fee = #{record.cmpRefundFee,jdbcType=BIGINT}");
        }
        
        if (record.getBillCreateTime() != null) {
            sql.SET("bill_create_time = #{record.billCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getPayChannelId() != null) {
            sql.SET("pay_channel_id = #{record.payChannelId,jdbcType=INTEGER}");
        }
        
        if (record.getPayChannel() != null) {
            sql.SET("pay_channel = #{record.payChannel,jdbcType=VARCHAR}");
        }
        
        if (record.getBalanceStatus() != null) {
            sql.SET("balance_status = #{record.balanceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBussinessBalanceStatus() != null) {
            sql.SET("bussiness_balance_status = #{record.bussinessBalanceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getTradeType() != null) {
            sql.SET("trade_type = #{record.tradeType,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundStatus() != null) {
            sql.SET("refund_status = #{record.refundStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBody() != null) {
            sql.SET("body = #{record.body,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("pay_settlement_detail");
        
        sql.SET("my_id = #{record.myId,jdbcType=BIGINT}");
        sql.SET("my_create_time = #{record.myCreateTime,jdbcType=TIMESTAMP}");
        sql.SET("my_compare = #{record.myCompare,jdbcType=INTEGER}");
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("sid = #{record.sid,jdbcType=VARCHAR}");
        sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        sql.SET("account_id = #{record.accountId,jdbcType=VARCHAR}");
        sql.SET("mch_id = #{record.mchId,jdbcType=VARCHAR}");
        sql.SET("app_id = #{record.appId,jdbcType=BIGINT}");
        sql.SET("subject = #{record.subject,jdbcType=VARCHAR}");
        sql.SET("out_trade_no = #{record.outTradeNo,jdbcType=VARCHAR}");
        sql.SET("cmp_out_trade_no = #{record.cmpOutTradeNo,jdbcType=VARCHAR}");
        sql.SET("total_amount = #{record.totalAmount,jdbcType=BIGINT}");
        sql.SET("receipt_amount = #{record.receiptAmount,jdbcType=BIGINT}");
        sql.SET("fee_amount = #{record.feeAmount,jdbcType=BIGINT}");
        sql.SET("cmp_total_amount = #{record.cmpTotalAmount,jdbcType=BIGINT}");
        sql.SET("cmp_receipt_amount = #{record.cmpReceiptAmount,jdbcType=BIGINT}");
        sql.SET("cmp_fee_amount = #{record.cmpFeeAmount,jdbcType=BIGINT}");
        sql.SET("cmp_refund_fee = #{record.cmpRefundFee,jdbcType=BIGINT}");
        sql.SET("bill_create_time = #{record.billCreateTime,jdbcType=TIMESTAMP}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("pay_channel_id = #{record.payChannelId,jdbcType=INTEGER}");
        sql.SET("pay_channel = #{record.payChannel,jdbcType=VARCHAR}");
        sql.SET("balance_status = #{record.balanceStatus,jdbcType=INTEGER}");
        sql.SET("bussiness_balance_status = #{record.bussinessBalanceStatus,jdbcType=INTEGER}");
        sql.SET("trade_type = #{record.tradeType,jdbcType=VARCHAR}");
        sql.SET("refund_status = #{record.refundStatus,jdbcType=INTEGER}");
        sql.SET("body = #{record.body,jdbcType=LONGVARCHAR}");
        
        PaySettlementDetailExample example = (PaySettlementDetailExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("pay_settlement_detail");
        
        sql.SET("my_id = #{record.myId,jdbcType=BIGINT}");
        sql.SET("my_create_time = #{record.myCreateTime,jdbcType=TIMESTAMP}");
        sql.SET("my_compare = #{record.myCompare,jdbcType=INTEGER}");
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("sid = #{record.sid,jdbcType=VARCHAR}");
        sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        sql.SET("account_id = #{record.accountId,jdbcType=VARCHAR}");
        sql.SET("mch_id = #{record.mchId,jdbcType=VARCHAR}");
        sql.SET("app_id = #{record.appId,jdbcType=BIGINT}");
        sql.SET("subject = #{record.subject,jdbcType=VARCHAR}");
        sql.SET("out_trade_no = #{record.outTradeNo,jdbcType=VARCHAR}");
        sql.SET("cmp_out_trade_no = #{record.cmpOutTradeNo,jdbcType=VARCHAR}");
        sql.SET("total_amount = #{record.totalAmount,jdbcType=BIGINT}");
        sql.SET("receipt_amount = #{record.receiptAmount,jdbcType=BIGINT}");
        sql.SET("fee_amount = #{record.feeAmount,jdbcType=BIGINT}");
        sql.SET("cmp_total_amount = #{record.cmpTotalAmount,jdbcType=BIGINT}");
        sql.SET("cmp_receipt_amount = #{record.cmpReceiptAmount,jdbcType=BIGINT}");
        sql.SET("cmp_fee_amount = #{record.cmpFeeAmount,jdbcType=BIGINT}");
        sql.SET("cmp_refund_fee = #{record.cmpRefundFee,jdbcType=BIGINT}");
        sql.SET("bill_create_time = #{record.billCreateTime,jdbcType=TIMESTAMP}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("pay_channel_id = #{record.payChannelId,jdbcType=INTEGER}");
        sql.SET("pay_channel = #{record.payChannel,jdbcType=VARCHAR}");
        sql.SET("balance_status = #{record.balanceStatus,jdbcType=INTEGER}");
        sql.SET("bussiness_balance_status = #{record.bussinessBalanceStatus,jdbcType=INTEGER}");
        sql.SET("trade_type = #{record.tradeType,jdbcType=VARCHAR}");
        sql.SET("refund_status = #{record.refundStatus,jdbcType=INTEGER}");
        
        PaySettlementDetailExample example = (PaySettlementDetailExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(PaySettlementDetail record) {
        SQL sql = new SQL();
        sql.UPDATE("pay_settlement_detail");
        
        if (record.getMyCreateTime() != null) {
            sql.SET("my_create_time = #{myCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMyCompare() != null) {
            sql.SET("my_compare = #{myCompare,jdbcType=INTEGER}");
        }
        
        if (record.getId() != null) {
            sql.SET("id = #{id,jdbcType=BIGINT}");
        }
        
        if (record.getSid() != null) {
            sql.SET("sid = #{sid,jdbcType=VARCHAR}");
        }
        
        if (record.getBillId() != null) {
            sql.SET("bill_id = #{billId,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountId() != null) {
            sql.SET("account_id = #{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getMchId() != null) {
            sql.SET("mch_id = #{mchId,jdbcType=VARCHAR}");
        }
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{appId,jdbcType=BIGINT}");
        }
        
        if (record.getSubject() != null) {
            sql.SET("subject = #{subject,jdbcType=VARCHAR}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.SET("out_trade_no = #{outTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCmpOutTradeNo() != null) {
            sql.SET("cmp_out_trade_no = #{cmpOutTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.SET("total_amount = #{totalAmount,jdbcType=BIGINT}");
        }
        
        if (record.getReceiptAmount() != null) {
            sql.SET("receipt_amount = #{receiptAmount,jdbcType=BIGINT}");
        }
        
        if (record.getFeeAmount() != null) {
            sql.SET("fee_amount = #{feeAmount,jdbcType=BIGINT}");
        }
        
        if (record.getCmpTotalAmount() != null) {
            sql.SET("cmp_total_amount = #{cmpTotalAmount,jdbcType=BIGINT}");
        }
        
        if (record.getCmpReceiptAmount() != null) {
            sql.SET("cmp_receipt_amount = #{cmpReceiptAmount,jdbcType=BIGINT}");
        }
        
        if (record.getCmpFeeAmount() != null) {
            sql.SET("cmp_fee_amount = #{cmpFeeAmount,jdbcType=BIGINT}");
        }
        
        if (record.getCmpRefundFee() != null) {
            sql.SET("cmp_refund_fee = #{cmpRefundFee,jdbcType=BIGINT}");
        }
        
        if (record.getBillCreateTime() != null) {
            sql.SET("bill_create_time = #{billCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getPayChannelId() != null) {
            sql.SET("pay_channel_id = #{payChannelId,jdbcType=INTEGER}");
        }
        
        if (record.getPayChannel() != null) {
            sql.SET("pay_channel = #{payChannel,jdbcType=VARCHAR}");
        }
        
        if (record.getBalanceStatus() != null) {
            sql.SET("balance_status = #{balanceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBussinessBalanceStatus() != null) {
            sql.SET("bussiness_balance_status = #{bussinessBalanceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getTradeType() != null) {
            sql.SET("trade_type = #{tradeType,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundStatus() != null) {
            sql.SET("refund_status = #{refundStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBody() != null) {
            sql.SET("body = #{body,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("my_id = #{myId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, PaySettlementDetailExample example, boolean includeExamplePhrase) {
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