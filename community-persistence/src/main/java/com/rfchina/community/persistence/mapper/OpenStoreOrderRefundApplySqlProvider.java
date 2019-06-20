package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreOrderRefundApply;
import com.rfchina.community.persistence.model.OpenStoreOrderRefundApplyExample.Criteria;
import com.rfchina.community.persistence.model.OpenStoreOrderRefundApplyExample.Criterion;
import com.rfchina.community.persistence.model.OpenStoreOrderRefundApplyExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenStoreOrderRefundApplySqlProvider {

    public String countByExample(OpenStoreOrderRefundApplyExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_store_order_refund_apply");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenStoreOrderRefundApplyExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_store_order_refund_apply");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenStoreOrderRefundApply record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_store_order_refund_apply");
        
        if (record.getRefundSource() != null) {
            sql.VALUES("refund_source", "#{refundSource,jdbcType=CHAR}");
        }
        
        if (record.getStoreOrderId() != null) {
            sql.VALUES("store_order_id", "#{storeOrderId,jdbcType=INTEGER}");
        }
        
        if (record.getBillId() != null) {
            sql.VALUES("bill_id", "#{billId,jdbcType=VARCHAR}");
        }
        
        if (record.getReasonCertificate() != null) {
            sql.VALUES("reason_certificate", "#{reasonCertificate,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountType() != null) {
            sql.VALUES("account_type", "#{accountType,jdbcType=INTEGER}");
        }
        
        if (record.getAccountNo() != null) {
            sql.VALUES("account_no", "#{accountNo,jdbcType=VARCHAR}");
        }
        
        if (record.getDepositBank() != null) {
            sql.VALUES("deposit_bank", "#{depositBank,jdbcType=VARCHAR}");
        }
        
        if (record.getConfirmLetter() != null) {
            sql.VALUES("confirm_letter", "#{confirmLetter,jdbcType=VARCHAR}");
        }
        
        if (record.getIdCardFront() != null) {
            sql.VALUES("id_card_front", "#{idCardFront,jdbcType=VARCHAR}");
        }
        
        if (record.getIdCardRear() != null) {
            sql.VALUES("id_card_rear", "#{idCardRear,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountPic() != null) {
            sql.VALUES("account_pic", "#{accountPic,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenStoreOrderRefundApplyExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("refund_source");
        sql.SELECT("store_order_id");
        sql.SELECT("bill_id");
        sql.SELECT("reason_certificate");
        sql.SELECT("name");
        sql.SELECT("account_type");
        sql.SELECT("account_no");
        sql.SELECT("deposit_bank");
        sql.SELECT("confirm_letter");
        sql.SELECT("id_card_front");
        sql.SELECT("id_card_rear");
        sql.SELECT("account_pic");
        sql.SELECT("create_time");
        sql.FROM("open_store_order_refund_apply");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenStoreOrderRefundApply record = (OpenStoreOrderRefundApply) parameter.get("record");
        OpenStoreOrderRefundApplyExample example = (OpenStoreOrderRefundApplyExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_store_order_refund_apply");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getRefundSource() != null) {
            sql.SET("refund_source = #{record.refundSource,jdbcType=CHAR}");
        }
        
        if (record.getStoreOrderId() != null) {
            sql.SET("store_order_id = #{record.storeOrderId,jdbcType=INTEGER}");
        }
        
        if (record.getBillId() != null) {
            sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        }
        
        if (record.getReasonCertificate() != null) {
            sql.SET("reason_certificate = #{record.reasonCertificate,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountType() != null) {
            sql.SET("account_type = #{record.accountType,jdbcType=INTEGER}");
        }
        
        if (record.getAccountNo() != null) {
            sql.SET("account_no = #{record.accountNo,jdbcType=VARCHAR}");
        }
        
        if (record.getDepositBank() != null) {
            sql.SET("deposit_bank = #{record.depositBank,jdbcType=VARCHAR}");
        }
        
        if (record.getConfirmLetter() != null) {
            sql.SET("confirm_letter = #{record.confirmLetter,jdbcType=VARCHAR}");
        }
        
        if (record.getIdCardFront() != null) {
            sql.SET("id_card_front = #{record.idCardFront,jdbcType=VARCHAR}");
        }
        
        if (record.getIdCardRear() != null) {
            sql.SET("id_card_rear = #{record.idCardRear,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountPic() != null) {
            sql.SET("account_pic = #{record.accountPic,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_order_refund_apply");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("refund_source = #{record.refundSource,jdbcType=CHAR}");
        sql.SET("store_order_id = #{record.storeOrderId,jdbcType=INTEGER}");
        sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        sql.SET("reason_certificate = #{record.reasonCertificate,jdbcType=VARCHAR}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("account_type = #{record.accountType,jdbcType=INTEGER}");
        sql.SET("account_no = #{record.accountNo,jdbcType=VARCHAR}");
        sql.SET("deposit_bank = #{record.depositBank,jdbcType=VARCHAR}");
        sql.SET("confirm_letter = #{record.confirmLetter,jdbcType=VARCHAR}");
        sql.SET("id_card_front = #{record.idCardFront,jdbcType=VARCHAR}");
        sql.SET("id_card_rear = #{record.idCardRear,jdbcType=VARCHAR}");
        sql.SET("account_pic = #{record.accountPic,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        OpenStoreOrderRefundApplyExample example = (OpenStoreOrderRefundApplyExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenStoreOrderRefundApply record) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_order_refund_apply");
        
        if (record.getRefundSource() != null) {
            sql.SET("refund_source = #{refundSource,jdbcType=CHAR}");
        }
        
        if (record.getStoreOrderId() != null) {
            sql.SET("store_order_id = #{storeOrderId,jdbcType=INTEGER}");
        }
        
        if (record.getBillId() != null) {
            sql.SET("bill_id = #{billId,jdbcType=VARCHAR}");
        }
        
        if (record.getReasonCertificate() != null) {
            sql.SET("reason_certificate = #{reasonCertificate,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountType() != null) {
            sql.SET("account_type = #{accountType,jdbcType=INTEGER}");
        }
        
        if (record.getAccountNo() != null) {
            sql.SET("account_no = #{accountNo,jdbcType=VARCHAR}");
        }
        
        if (record.getDepositBank() != null) {
            sql.SET("deposit_bank = #{depositBank,jdbcType=VARCHAR}");
        }
        
        if (record.getConfirmLetter() != null) {
            sql.SET("confirm_letter = #{confirmLetter,jdbcType=VARCHAR}");
        }
        
        if (record.getIdCardFront() != null) {
            sql.SET("id_card_front = #{idCardFront,jdbcType=VARCHAR}");
        }
        
        if (record.getIdCardRear() != null) {
            sql.SET("id_card_rear = #{idCardRear,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountPic() != null) {
            sql.SET("account_pic = #{accountPic,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenStoreOrderRefundApplyExample example, boolean includeExamplePhrase) {
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