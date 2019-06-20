package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenXfsjSignUpInfo;
import com.rfchina.community.persistence.model.OpenXfsjSignUpInfoExample.Criteria;
import com.rfchina.community.persistence.model.OpenXfsjSignUpInfoExample.Criterion;
import com.rfchina.community.persistence.model.OpenXfsjSignUpInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenXfsjSignUpInfoSqlProvider {

    public String countByExample(OpenXfsjSignUpInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_xfsj_sign_up_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenXfsjSignUpInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_xfsj_sign_up_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenXfsjSignUpInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_xfsj_sign_up_info");
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=BIGINT}");
        }
        
        if (record.getXfsjId() != null) {
            sql.VALUES("xfsj_id", "#{xfsjId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getBillId() != null) {
            sql.VALUES("bill_id", "#{billId,jdbcType=VARCHAR}");
        }
        
        if (record.getBillStatus() != null) {
            sql.VALUES("bill_status", "#{billStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBillCreateTime() != null) {
            sql.VALUES("bill_create_time", "#{billCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getServiceFee() != null) {
            sql.VALUES("service_fee", "#{serviceFee,jdbcType=DECIMAL}");
        }
        
        if (record.getRefuseContent() != null) {
            sql.VALUES("refuse_content", "#{refuseContent,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOrderId() != null) {
            sql.VALUES("order_id", "#{orderId,jdbcType=BIGINT}");
        }
        
        if (record.getPlatformChargeRate() != null) {
            sql.VALUES("platform_charge_rate", "#{platformChargeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformCharge() != null) {
            sql.VALUES("platform_charge", "#{platformCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getReceiptAmount() != null) {
            sql.VALUES("receipt_amount", "#{receiptAmount,jdbcType=DECIMAL}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenXfsjSignUpInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("uid");
        sql.SELECT("xfsj_id");
        sql.SELECT("service_id");
        sql.SELECT("bill_id");
        sql.SELECT("bill_status");
        sql.SELECT("bill_create_time");
        sql.SELECT("service_fee");
        sql.SELECT("refuse_content");
        sql.SELECT("status");
        sql.SELECT("create_time");
        sql.SELECT("order_id");
        sql.SELECT("platform_charge_rate");
        sql.SELECT("platform_charge");
        sql.SELECT("receipt_amount");
        sql.FROM("open_xfsj_sign_up_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenXfsjSignUpInfo record = (OpenXfsjSignUpInfo) parameter.get("record");
        OpenXfsjSignUpInfoExample example = (OpenXfsjSignUpInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_xfsj_sign_up_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        }
        
        if (record.getXfsjId() != null) {
            sql.SET("xfsj_id = #{record.xfsjId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getBillId() != null) {
            sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        }
        
        if (record.getBillStatus() != null) {
            sql.SET("bill_status = #{record.billStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBillCreateTime() != null) {
            sql.SET("bill_create_time = #{record.billCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getServiceFee() != null) {
            sql.SET("service_fee = #{record.serviceFee,jdbcType=DECIMAL}");
        }
        
        if (record.getRefuseContent() != null) {
            sql.SET("refuse_content = #{record.refuseContent,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOrderId() != null) {
            sql.SET("order_id = #{record.orderId,jdbcType=BIGINT}");
        }
        
        if (record.getPlatformChargeRate() != null) {
            sql.SET("platform_charge_rate = #{record.platformChargeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformCharge() != null) {
            sql.SET("platform_charge = #{record.platformCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getReceiptAmount() != null) {
            sql.SET("receipt_amount = #{record.receiptAmount,jdbcType=DECIMAL}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_xfsj_sign_up_info");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        sql.SET("xfsj_id = #{record.xfsjId,jdbcType=BIGINT}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        sql.SET("bill_status = #{record.billStatus,jdbcType=INTEGER}");
        sql.SET("bill_create_time = #{record.billCreateTime,jdbcType=TIMESTAMP}");
        sql.SET("service_fee = #{record.serviceFee,jdbcType=DECIMAL}");
        sql.SET("refuse_content = #{record.refuseContent,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("order_id = #{record.orderId,jdbcType=BIGINT}");
        sql.SET("platform_charge_rate = #{record.platformChargeRate,jdbcType=DECIMAL}");
        sql.SET("platform_charge = #{record.platformCharge,jdbcType=DECIMAL}");
        sql.SET("receipt_amount = #{record.receiptAmount,jdbcType=DECIMAL}");
        
        OpenXfsjSignUpInfoExample example = (OpenXfsjSignUpInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenXfsjSignUpInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("open_xfsj_sign_up_info");
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=BIGINT}");
        }
        
        if (record.getXfsjId() != null) {
            sql.SET("xfsj_id = #{xfsjId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getBillId() != null) {
            sql.SET("bill_id = #{billId,jdbcType=VARCHAR}");
        }
        
        if (record.getBillStatus() != null) {
            sql.SET("bill_status = #{billStatus,jdbcType=INTEGER}");
        }
        
        if (record.getBillCreateTime() != null) {
            sql.SET("bill_create_time = #{billCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getServiceFee() != null) {
            sql.SET("service_fee = #{serviceFee,jdbcType=DECIMAL}");
        }
        
        if (record.getRefuseContent() != null) {
            sql.SET("refuse_content = #{refuseContent,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOrderId() != null) {
            sql.SET("order_id = #{orderId,jdbcType=BIGINT}");
        }
        
        if (record.getPlatformChargeRate() != null) {
            sql.SET("platform_charge_rate = #{platformChargeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformCharge() != null) {
            sql.SET("platform_charge = #{platformCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getReceiptAmount() != null) {
            sql.SET("receipt_amount = #{receiptAmount,jdbcType=DECIMAL}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenXfsjSignUpInfoExample example, boolean includeExamplePhrase) {
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