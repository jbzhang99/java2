package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.PaySettlementInfo;
import com.rfchina.community.persistence.model.PaySettlementInfoExample.Criteria;
import com.rfchina.community.persistence.model.PaySettlementInfoExample.Criterion;
import com.rfchina.community.persistence.model.PaySettlementInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class PaySettlementInfoSqlProvider {

    public String countByExample(PaySettlementInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("pay_settlement_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(PaySettlementInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("pay_settlement_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(PaySettlementInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("pay_settlement_info");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getMyId() != null) {
            sql.VALUES("my_id", "#{myId,jdbcType=VARCHAR}");
        }
        
        if (record.getMyType() != null) {
            sql.VALUES("my_type", "#{myType,jdbcType=VARCHAR}");
        }
        
        if (record.getMyCreateTime() != null) {
            sql.VALUES("my_create_time", "#{myCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMyStatus() != null) {
            sql.VALUES("my_status", "#{myStatus,jdbcType=INTEGER}");
        }
        
        if (record.getMchId() != null) {
            sql.VALUES("mch_id", "#{mchId,jdbcType=VARCHAR}");
        }
        
        if (record.getMchName() != null) {
            sql.VALUES("mch_name", "#{mchName,jdbcType=VARCHAR}");
        }
        
        if (record.getMchAccountId() != null) {
            sql.VALUES("mch_account_id", "#{mchAccountId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAppId() != null) {
            sql.VALUES("app_id", "#{appId,jdbcType=VARCHAR}");
        }
        
        if (record.getAppName() != null) {
            sql.VALUES("app_name", "#{appName,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getConfirmTime() != null) {
            sql.VALUES("confirm_time", "#{confirmTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRevokeTime() != null) {
            sql.VALUES("revoke_time", "#{revokeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFromBillDate() != null) {
            sql.VALUES("from_bill_date", "#{fromBillDate,jdbcType=VARCHAR}");
        }
        
        if (record.getToBillDate() != null) {
            sql.VALUES("to_bill_date", "#{toBillDate,jdbcType=VARCHAR}");
        }
        
        if (record.getConfirmComment() != null) {
            sql.VALUES("confirm_comment", "#{confirmComment,jdbcType=VARCHAR}");
        }
        
        if (record.getRevokeComment() != null) {
            sql.VALUES("revoke_comment", "#{revokeComment,jdbcType=VARCHAR}");
        }
        
        if (record.getConfirmStatus() != null) {
            sql.VALUES("confirm_status", "#{confirmStatus,jdbcType=INTEGER}");
        }
        
        if (record.getStartTime() != null) {
            sql.VALUES("start_time", "#{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.VALUES("end_time", "#{endTime,jdbcType=VARCHAR}");
        }
        
        if (record.getErrorMsg() != null) {
            sql.VALUES("error_msg", "#{errorMsg,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeTotal() != null) {
            sql.VALUES("trade_total", "#{tradeTotal,jdbcType=INTEGER}");
        }
        
        if (record.getTradeTotalAmount() != null) {
            sql.VALUES("trade_total_amount", "#{tradeTotalAmount,jdbcType=BIGINT}");
        }
        
        if (record.getTradeReceiptAmount() != null) {
            sql.VALUES("trade_receipt_amount", "#{tradeReceiptAmount,jdbcType=BIGINT}");
        }
        
        if (record.getTradeBussinessReceiptAmount() != null) {
            sql.VALUES("trade_bussiness_receipt_amount", "#{tradeBussinessReceiptAmount,jdbcType=BIGINT}");
        }
        
        if (record.getTradeFeeAmount() != null) {
            sql.VALUES("trade_fee_amount", "#{tradeFeeAmount,jdbcType=BIGINT}");
        }
        
        if (record.getDepositName() != null) {
            sql.VALUES("deposit_name", "#{depositName,jdbcType=VARCHAR}");
        }
        
        if (record.getDepositBank() != null) {
            sql.VALUES("deposit_bank", "#{depositBank,jdbcType=VARCHAR}");
        }
        
        if (record.getBankAccount() != null) {
            sql.VALUES("bank_account", "#{bankAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeRefundTotal() != null) {
            sql.VALUES("trade_refund_total", "#{tradeRefundTotal,jdbcType=BIGINT}");
        }
        
        if (record.getTradeRefundFee() != null) {
            sql.VALUES("trade_refund_fee", "#{tradeRefundFee,jdbcType=BIGINT}");
        }
        
        if (record.getBussinessSettleAmount() != null) {
            sql.VALUES("bussiness_settle_amount", "#{bussinessSettleAmount,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(PaySettlementInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("my_id");
        sql.SELECT("my_type");
        sql.SELECT("my_create_time");
        sql.SELECT("my_status");
        sql.SELECT("mch_id");
        sql.SELECT("mch_name");
        sql.SELECT("mch_account_id");
        sql.SELECT("create_time");
        sql.SELECT("app_id");
        sql.SELECT("app_name");
        sql.SELECT("title");
        sql.SELECT("status");
        sql.SELECT("confirm_time");
        sql.SELECT("revoke_time");
        sql.SELECT("from_bill_date");
        sql.SELECT("to_bill_date");
        sql.SELECT("confirm_comment");
        sql.SELECT("revoke_comment");
        sql.SELECT("confirm_status");
        sql.SELECT("start_time");
        sql.SELECT("end_time");
        sql.SELECT("error_msg");
        sql.SELECT("trade_total");
        sql.SELECT("trade_total_amount");
        sql.SELECT("trade_receipt_amount");
        sql.SELECT("trade_bussiness_receipt_amount");
        sql.SELECT("trade_fee_amount");
        sql.SELECT("deposit_name");
        sql.SELECT("deposit_bank");
        sql.SELECT("bank_account");
        sql.SELECT("trade_refund_total");
        sql.SELECT("trade_refund_fee");
        sql.SELECT("bussiness_settle_amount");
        sql.FROM("pay_settlement_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PaySettlementInfo record = (PaySettlementInfo) parameter.get("record");
        PaySettlementInfoExample example = (PaySettlementInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("pay_settlement_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getMyId() != null) {
            sql.SET("my_id = #{record.myId,jdbcType=VARCHAR}");
        }
        
        if (record.getMyType() != null) {
            sql.SET("my_type = #{record.myType,jdbcType=VARCHAR}");
        }
        
        if (record.getMyCreateTime() != null) {
            sql.SET("my_create_time = #{record.myCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMyStatus() != null) {
            sql.SET("my_status = #{record.myStatus,jdbcType=INTEGER}");
        }
        
        if (record.getMchId() != null) {
            sql.SET("mch_id = #{record.mchId,jdbcType=VARCHAR}");
        }
        
        if (record.getMchName() != null) {
            sql.SET("mch_name = #{record.mchName,jdbcType=VARCHAR}");
        }
        
        if (record.getMchAccountId() != null) {
            sql.SET("mch_account_id = #{record.mchAccountId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{record.appId,jdbcType=VARCHAR}");
        }
        
        if (record.getAppName() != null) {
            sql.SET("app_name = #{record.appName,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getConfirmTime() != null) {
            sql.SET("confirm_time = #{record.confirmTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRevokeTime() != null) {
            sql.SET("revoke_time = #{record.revokeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFromBillDate() != null) {
            sql.SET("from_bill_date = #{record.fromBillDate,jdbcType=VARCHAR}");
        }
        
        if (record.getToBillDate() != null) {
            sql.SET("to_bill_date = #{record.toBillDate,jdbcType=VARCHAR}");
        }
        
        if (record.getConfirmComment() != null) {
            sql.SET("confirm_comment = #{record.confirmComment,jdbcType=VARCHAR}");
        }
        
        if (record.getRevokeComment() != null) {
            sql.SET("revoke_comment = #{record.revokeComment,jdbcType=VARCHAR}");
        }
        
        if (record.getConfirmStatus() != null) {
            sql.SET("confirm_status = #{record.confirmStatus,jdbcType=INTEGER}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{record.endTime,jdbcType=VARCHAR}");
        }
        
        if (record.getErrorMsg() != null) {
            sql.SET("error_msg = #{record.errorMsg,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeTotal() != null) {
            sql.SET("trade_total = #{record.tradeTotal,jdbcType=INTEGER}");
        }
        
        if (record.getTradeTotalAmount() != null) {
            sql.SET("trade_total_amount = #{record.tradeTotalAmount,jdbcType=BIGINT}");
        }
        
        if (record.getTradeReceiptAmount() != null) {
            sql.SET("trade_receipt_amount = #{record.tradeReceiptAmount,jdbcType=BIGINT}");
        }
        
        if (record.getTradeBussinessReceiptAmount() != null) {
            sql.SET("trade_bussiness_receipt_amount = #{record.tradeBussinessReceiptAmount,jdbcType=BIGINT}");
        }
        
        if (record.getTradeFeeAmount() != null) {
            sql.SET("trade_fee_amount = #{record.tradeFeeAmount,jdbcType=BIGINT}");
        }
        
        if (record.getDepositName() != null) {
            sql.SET("deposit_name = #{record.depositName,jdbcType=VARCHAR}");
        }
        
        if (record.getDepositBank() != null) {
            sql.SET("deposit_bank = #{record.depositBank,jdbcType=VARCHAR}");
        }
        
        if (record.getBankAccount() != null) {
            sql.SET("bank_account = #{record.bankAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeRefundTotal() != null) {
            sql.SET("trade_refund_total = #{record.tradeRefundTotal,jdbcType=BIGINT}");
        }
        
        if (record.getTradeRefundFee() != null) {
            sql.SET("trade_refund_fee = #{record.tradeRefundFee,jdbcType=BIGINT}");
        }
        
        if (record.getBussinessSettleAmount() != null) {
            sql.SET("bussiness_settle_amount = #{record.bussinessSettleAmount,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("pay_settlement_info");
        
        sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        sql.SET("my_id = #{record.myId,jdbcType=VARCHAR}");
        sql.SET("my_type = #{record.myType,jdbcType=VARCHAR}");
        sql.SET("my_create_time = #{record.myCreateTime,jdbcType=TIMESTAMP}");
        sql.SET("my_status = #{record.myStatus,jdbcType=INTEGER}");
        sql.SET("mch_id = #{record.mchId,jdbcType=VARCHAR}");
        sql.SET("mch_name = #{record.mchName,jdbcType=VARCHAR}");
        sql.SET("mch_account_id = #{record.mchAccountId,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("app_id = #{record.appId,jdbcType=VARCHAR}");
        sql.SET("app_name = #{record.appName,jdbcType=VARCHAR}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("confirm_time = #{record.confirmTime,jdbcType=TIMESTAMP}");
        sql.SET("revoke_time = #{record.revokeTime,jdbcType=TIMESTAMP}");
        sql.SET("from_bill_date = #{record.fromBillDate,jdbcType=VARCHAR}");
        sql.SET("to_bill_date = #{record.toBillDate,jdbcType=VARCHAR}");
        sql.SET("confirm_comment = #{record.confirmComment,jdbcType=VARCHAR}");
        sql.SET("revoke_comment = #{record.revokeComment,jdbcType=VARCHAR}");
        sql.SET("confirm_status = #{record.confirmStatus,jdbcType=INTEGER}");
        sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        sql.SET("end_time = #{record.endTime,jdbcType=VARCHAR}");
        sql.SET("error_msg = #{record.errorMsg,jdbcType=VARCHAR}");
        sql.SET("trade_total = #{record.tradeTotal,jdbcType=INTEGER}");
        sql.SET("trade_total_amount = #{record.tradeTotalAmount,jdbcType=BIGINT}");
        sql.SET("trade_receipt_amount = #{record.tradeReceiptAmount,jdbcType=BIGINT}");
        sql.SET("trade_bussiness_receipt_amount = #{record.tradeBussinessReceiptAmount,jdbcType=BIGINT}");
        sql.SET("trade_fee_amount = #{record.tradeFeeAmount,jdbcType=BIGINT}");
        sql.SET("deposit_name = #{record.depositName,jdbcType=VARCHAR}");
        sql.SET("deposit_bank = #{record.depositBank,jdbcType=VARCHAR}");
        sql.SET("bank_account = #{record.bankAccount,jdbcType=VARCHAR}");
        sql.SET("trade_refund_total = #{record.tradeRefundTotal,jdbcType=BIGINT}");
        sql.SET("trade_refund_fee = #{record.tradeRefundFee,jdbcType=BIGINT}");
        sql.SET("bussiness_settle_amount = #{record.bussinessSettleAmount,jdbcType=BIGINT}");
        
        PaySettlementInfoExample example = (PaySettlementInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(PaySettlementInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("pay_settlement_info");
        
        if (record.getMyId() != null) {
            sql.SET("my_id = #{myId,jdbcType=VARCHAR}");
        }
        
        if (record.getMyType() != null) {
            sql.SET("my_type = #{myType,jdbcType=VARCHAR}");
        }
        
        if (record.getMyCreateTime() != null) {
            sql.SET("my_create_time = #{myCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMyStatus() != null) {
            sql.SET("my_status = #{myStatus,jdbcType=INTEGER}");
        }
        
        if (record.getMchId() != null) {
            sql.SET("mch_id = #{mchId,jdbcType=VARCHAR}");
        }
        
        if (record.getMchName() != null) {
            sql.SET("mch_name = #{mchName,jdbcType=VARCHAR}");
        }
        
        if (record.getMchAccountId() != null) {
            sql.SET("mch_account_id = #{mchAccountId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{appId,jdbcType=VARCHAR}");
        }
        
        if (record.getAppName() != null) {
            sql.SET("app_name = #{appName,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getConfirmTime() != null) {
            sql.SET("confirm_time = #{confirmTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRevokeTime() != null) {
            sql.SET("revoke_time = #{revokeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFromBillDate() != null) {
            sql.SET("from_bill_date = #{fromBillDate,jdbcType=VARCHAR}");
        }
        
        if (record.getToBillDate() != null) {
            sql.SET("to_bill_date = #{toBillDate,jdbcType=VARCHAR}");
        }
        
        if (record.getConfirmComment() != null) {
            sql.SET("confirm_comment = #{confirmComment,jdbcType=VARCHAR}");
        }
        
        if (record.getRevokeComment() != null) {
            sql.SET("revoke_comment = #{revokeComment,jdbcType=VARCHAR}");
        }
        
        if (record.getConfirmStatus() != null) {
            sql.SET("confirm_status = #{confirmStatus,jdbcType=INTEGER}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{endTime,jdbcType=VARCHAR}");
        }
        
        if (record.getErrorMsg() != null) {
            sql.SET("error_msg = #{errorMsg,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeTotal() != null) {
            sql.SET("trade_total = #{tradeTotal,jdbcType=INTEGER}");
        }
        
        if (record.getTradeTotalAmount() != null) {
            sql.SET("trade_total_amount = #{tradeTotalAmount,jdbcType=BIGINT}");
        }
        
        if (record.getTradeReceiptAmount() != null) {
            sql.SET("trade_receipt_amount = #{tradeReceiptAmount,jdbcType=BIGINT}");
        }
        
        if (record.getTradeBussinessReceiptAmount() != null) {
            sql.SET("trade_bussiness_receipt_amount = #{tradeBussinessReceiptAmount,jdbcType=BIGINT}");
        }
        
        if (record.getTradeFeeAmount() != null) {
            sql.SET("trade_fee_amount = #{tradeFeeAmount,jdbcType=BIGINT}");
        }
        
        if (record.getDepositName() != null) {
            sql.SET("deposit_name = #{depositName,jdbcType=VARCHAR}");
        }
        
        if (record.getDepositBank() != null) {
            sql.SET("deposit_bank = #{depositBank,jdbcType=VARCHAR}");
        }
        
        if (record.getBankAccount() != null) {
            sql.SET("bank_account = #{bankAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeRefundTotal() != null) {
            sql.SET("trade_refund_total = #{tradeRefundTotal,jdbcType=BIGINT}");
        }
        
        if (record.getTradeRefundFee() != null) {
            sql.SET("trade_refund_fee = #{tradeRefundFee,jdbcType=BIGINT}");
        }
        
        if (record.getBussinessSettleAmount() != null) {
            sql.SET("bussiness_settle_amount = #{bussinessSettleAmount,jdbcType=BIGINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, PaySettlementInfoExample example, boolean includeExamplePhrase) {
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