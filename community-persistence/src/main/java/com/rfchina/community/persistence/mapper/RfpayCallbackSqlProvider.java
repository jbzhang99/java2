package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.RfpayCallback;
import com.rfchina.community.persistence.model.RfpayCallbackExample.Criteria;
import com.rfchina.community.persistence.model.RfpayCallbackExample.Criterion;
import com.rfchina.community.persistence.model.RfpayCallbackExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class RfpayCallbackSqlProvider {

    public String countByExample(RfpayCallbackExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("rfpay_callback");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(RfpayCallbackExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("rfpay_callback");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(RfpayCallback record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("rfpay_callback");
        
        if (record.getNotifyId() != null) {
            sql.VALUES("notify_id", "#{notifyId,jdbcType=VARCHAR}");
        }
        
        if (record.getNotifyTime() != null) {
            sql.VALUES("notify_time", "#{notifyTime,jdbcType=VARCHAR}");
        }
        
        if (record.getBillId() != null) {
            sql.VALUES("bill_id", "#{billId,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountId() != null) {
            sql.VALUES("account_id", "#{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getAppId() != null) {
            sql.VALUES("app_id", "#{appId,jdbcType=VARCHAR}");
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
        
        if (record.getTotalAmount() != null) {
            sql.VALUES("total_amount", "#{totalAmount,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiptAmount() != null) {
            sql.VALUES("receipt_amount", "#{receiptAmount,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundFee() != null) {
            sql.VALUES("refund_fee", "#{refundFee,jdbcType=VARCHAR}");
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
        
        if (record.getTradeStatus() != null) {
            sql.VALUES("trade_status", "#{tradeStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getTimestamp() != null) {
            sql.VALUES("timestamp", "#{timestamp,jdbcType=VARCHAR}");
        }
        
        if (record.getSign() != null) {
            sql.VALUES("sign", "#{sign,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(RfpayCallbackExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("notify_id");
        sql.SELECT("notify_time");
        sql.SELECT("bill_id");
        sql.SELECT("account_id");
        sql.SELECT("app_id");
        sql.SELECT("pay_channel");
        sql.SELECT("out_trade_no");
        sql.SELECT("client_ip");
        sql.SELECT("total_amount");
        sql.SELECT("receipt_amount");
        sql.SELECT("refund_fee");
        sql.SELECT("subject");
        sql.SELECT("body");
        sql.SELECT("detail");
        sql.SELECT("trade_status");
        sql.SELECT("timestamp");
        sql.SELECT("sign");
        sql.SELECT("create_time");
        sql.FROM("rfpay_callback");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        RfpayCallback record = (RfpayCallback) parameter.get("record");
        RfpayCallbackExample example = (RfpayCallbackExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("rfpay_callback");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getNotifyId() != null) {
            sql.SET("notify_id = #{record.notifyId,jdbcType=VARCHAR}");
        }
        
        if (record.getNotifyTime() != null) {
            sql.SET("notify_time = #{record.notifyTime,jdbcType=VARCHAR}");
        }
        
        if (record.getBillId() != null) {
            sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountId() != null) {
            sql.SET("account_id = #{record.accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{record.appId,jdbcType=VARCHAR}");
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
        
        if (record.getTotalAmount() != null) {
            sql.SET("total_amount = #{record.totalAmount,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiptAmount() != null) {
            sql.SET("receipt_amount = #{record.receiptAmount,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundFee() != null) {
            sql.SET("refund_fee = #{record.refundFee,jdbcType=VARCHAR}");
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
        
        if (record.getTradeStatus() != null) {
            sql.SET("trade_status = #{record.tradeStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getTimestamp() != null) {
            sql.SET("timestamp = #{record.timestamp,jdbcType=VARCHAR}");
        }
        
        if (record.getSign() != null) {
            sql.SET("sign = #{record.sign,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("rfpay_callback");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("notify_id = #{record.notifyId,jdbcType=VARCHAR}");
        sql.SET("notify_time = #{record.notifyTime,jdbcType=VARCHAR}");
        sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        sql.SET("account_id = #{record.accountId,jdbcType=VARCHAR}");
        sql.SET("app_id = #{record.appId,jdbcType=VARCHAR}");
        sql.SET("pay_channel = #{record.payChannel,jdbcType=VARCHAR}");
        sql.SET("out_trade_no = #{record.outTradeNo,jdbcType=VARCHAR}");
        sql.SET("client_ip = #{record.clientIp,jdbcType=VARCHAR}");
        sql.SET("total_amount = #{record.totalAmount,jdbcType=VARCHAR}");
        sql.SET("receipt_amount = #{record.receiptAmount,jdbcType=VARCHAR}");
        sql.SET("refund_fee = #{record.refundFee,jdbcType=VARCHAR}");
        sql.SET("subject = #{record.subject,jdbcType=VARCHAR}");
        sql.SET("body = #{record.body,jdbcType=VARCHAR}");
        sql.SET("detail = #{record.detail,jdbcType=VARCHAR}");
        sql.SET("trade_status = #{record.tradeStatus,jdbcType=VARCHAR}");
        sql.SET("timestamp = #{record.timestamp,jdbcType=VARCHAR}");
        sql.SET("sign = #{record.sign,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        RfpayCallbackExample example = (RfpayCallbackExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RfpayCallback record) {
        SQL sql = new SQL();
        sql.UPDATE("rfpay_callback");
        
        if (record.getNotifyId() != null) {
            sql.SET("notify_id = #{notifyId,jdbcType=VARCHAR}");
        }
        
        if (record.getNotifyTime() != null) {
            sql.SET("notify_time = #{notifyTime,jdbcType=VARCHAR}");
        }
        
        if (record.getBillId() != null) {
            sql.SET("bill_id = #{billId,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountId() != null) {
            sql.SET("account_id = #{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{appId,jdbcType=VARCHAR}");
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
        
        if (record.getTotalAmount() != null) {
            sql.SET("total_amount = #{totalAmount,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiptAmount() != null) {
            sql.SET("receipt_amount = #{receiptAmount,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundFee() != null) {
            sql.SET("refund_fee = #{refundFee,jdbcType=VARCHAR}");
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
        
        if (record.getTradeStatus() != null) {
            sql.SET("trade_status = #{tradeStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getTimestamp() != null) {
            sql.SET("timestamp = #{timestamp,jdbcType=VARCHAR}");
        }
        
        if (record.getSign() != null) {
            sql.SET("sign = #{sign,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, RfpayCallbackExample example, boolean includeExamplePhrase) {
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