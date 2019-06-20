package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenFeeOrderPay;
import com.rfchina.community.persistence.model.OpenFeeOrderPayExample.Criteria;
import com.rfchina.community.persistence.model.OpenFeeOrderPayExample.Criterion;
import com.rfchina.community.persistence.model.OpenFeeOrderPayExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenFeeOrderPaySqlProvider {

    public String countByExample(OpenFeeOrderPayExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_fee_order_pay");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenFeeOrderPayExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_fee_order_pay");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenFeeOrderPay record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_fee_order_pay");
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.VALUES("out_trade_no", "#{outTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBillId() != null) {
            sql.VALUES("bill_id", "#{billId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayStatus() != null) {
            sql.VALUES("pay_status", "#{payStatus,jdbcType=CHAR}");
        }
        
        if (record.getPayType() != null) {
            sql.VALUES("pay_type", "#{payType,jdbcType=CHAR}");
        }
        
        if (record.getPayAmount() != null) {
            sql.VALUES("pay_amount", "#{payAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayTime() != null) {
            sql.VALUES("pay_time", "#{payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOpenId() != null) {
            sql.VALUES("open_id", "#{openId,jdbcType=BIGINT}");
        }
        
        if (record.getImgLink() != null) {
            sql.VALUES("img_link", "#{imgLink,jdbcType=VARCHAR}");
        }
        
        if (record.getPayChannel() != null) {
            sql.VALUES("pay_channel", "#{payChannel,jdbcType=VARCHAR}");
        }
        
        if (record.getRejectReason() != null) {
            sql.VALUES("reject_reason", "#{rejectReason,jdbcType=VARCHAR}");
        }
        
        if (record.getPlatformCharge() != null) {
            sql.VALUES("platform_charge", "#{platformCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getServiceCharge() != null) {
            sql.VALUES("service_charge", "#{serviceCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getAuditUid() != null) {
            sql.VALUES("audit_uid", "#{auditUid,jdbcType=BIGINT}");
        }
        
        if (record.getAuditPhone() != null) {
            sql.VALUES("audit_phone", "#{auditPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditName() != null) {
            sql.VALUES("audit_name", "#{auditName,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditTime() != null) {
            sql.VALUES("audit_time", "#{auditTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenFeeOrderPayExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("service_id");
        sql.SELECT("out_trade_no");
        sql.SELECT("bill_id");
        sql.SELECT("create_time");
        sql.SELECT("pay_status");
        sql.SELECT("pay_type");
        sql.SELECT("pay_amount");
        sql.SELECT("pay_time");
        sql.SELECT("open_id");
        sql.SELECT("img_link");
        sql.SELECT("pay_channel");
        sql.SELECT("reject_reason");
        sql.SELECT("platform_charge");
        sql.SELECT("service_charge");
        sql.SELECT("community_id");
        sql.SELECT("audit_uid");
        sql.SELECT("audit_phone");
        sql.SELECT("audit_name");
        sql.SELECT("audit_time");
        sql.FROM("open_fee_order_pay");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenFeeOrderPay record = (OpenFeeOrderPay) parameter.get("record");
        OpenFeeOrderPayExample example = (OpenFeeOrderPayExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_fee_order_pay");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.SET("out_trade_no = #{record.outTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBillId() != null) {
            sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayStatus() != null) {
            sql.SET("pay_status = #{record.payStatus,jdbcType=CHAR}");
        }
        
        if (record.getPayType() != null) {
            sql.SET("pay_type = #{record.payType,jdbcType=CHAR}");
        }
        
        if (record.getPayAmount() != null) {
            sql.SET("pay_amount = #{record.payAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayTime() != null) {
            sql.SET("pay_time = #{record.payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOpenId() != null) {
            sql.SET("open_id = #{record.openId,jdbcType=BIGINT}");
        }
        
        if (record.getImgLink() != null) {
            sql.SET("img_link = #{record.imgLink,jdbcType=VARCHAR}");
        }
        
        if (record.getPayChannel() != null) {
            sql.SET("pay_channel = #{record.payChannel,jdbcType=VARCHAR}");
        }
        
        if (record.getRejectReason() != null) {
            sql.SET("reject_reason = #{record.rejectReason,jdbcType=VARCHAR}");
        }
        
        if (record.getPlatformCharge() != null) {
            sql.SET("platform_charge = #{record.platformCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getServiceCharge() != null) {
            sql.SET("service_charge = #{record.serviceCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getAuditUid() != null) {
            sql.SET("audit_uid = #{record.auditUid,jdbcType=BIGINT}");
        }
        
        if (record.getAuditPhone() != null) {
            sql.SET("audit_phone = #{record.auditPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditName() != null) {
            sql.SET("audit_name = #{record.auditName,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditTime() != null) {
            sql.SET("audit_time = #{record.auditTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_fee_order_pay");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("out_trade_no = #{record.outTradeNo,jdbcType=VARCHAR}");
        sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("pay_status = #{record.payStatus,jdbcType=CHAR}");
        sql.SET("pay_type = #{record.payType,jdbcType=CHAR}");
        sql.SET("pay_amount = #{record.payAmount,jdbcType=DECIMAL}");
        sql.SET("pay_time = #{record.payTime,jdbcType=TIMESTAMP}");
        sql.SET("open_id = #{record.openId,jdbcType=BIGINT}");
        sql.SET("img_link = #{record.imgLink,jdbcType=VARCHAR}");
        sql.SET("pay_channel = #{record.payChannel,jdbcType=VARCHAR}");
        sql.SET("reject_reason = #{record.rejectReason,jdbcType=VARCHAR}");
        sql.SET("platform_charge = #{record.platformCharge,jdbcType=DECIMAL}");
        sql.SET("service_charge = #{record.serviceCharge,jdbcType=DECIMAL}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("audit_uid = #{record.auditUid,jdbcType=BIGINT}");
        sql.SET("audit_phone = #{record.auditPhone,jdbcType=VARCHAR}");
        sql.SET("audit_name = #{record.auditName,jdbcType=VARCHAR}");
        sql.SET("audit_time = #{record.auditTime,jdbcType=TIMESTAMP}");
        
        OpenFeeOrderPayExample example = (OpenFeeOrderPayExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenFeeOrderPay record) {
        SQL sql = new SQL();
        sql.UPDATE("open_fee_order_pay");
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.SET("out_trade_no = #{outTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBillId() != null) {
            sql.SET("bill_id = #{billId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayStatus() != null) {
            sql.SET("pay_status = #{payStatus,jdbcType=CHAR}");
        }
        
        if (record.getPayType() != null) {
            sql.SET("pay_type = #{payType,jdbcType=CHAR}");
        }
        
        if (record.getPayAmount() != null) {
            sql.SET("pay_amount = #{payAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayTime() != null) {
            sql.SET("pay_time = #{payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOpenId() != null) {
            sql.SET("open_id = #{openId,jdbcType=BIGINT}");
        }
        
        if (record.getImgLink() != null) {
            sql.SET("img_link = #{imgLink,jdbcType=VARCHAR}");
        }
        
        if (record.getPayChannel() != null) {
            sql.SET("pay_channel = #{payChannel,jdbcType=VARCHAR}");
        }
        
        if (record.getRejectReason() != null) {
            sql.SET("reject_reason = #{rejectReason,jdbcType=VARCHAR}");
        }
        
        if (record.getPlatformCharge() != null) {
            sql.SET("platform_charge = #{platformCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getServiceCharge() != null) {
            sql.SET("service_charge = #{serviceCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getAuditUid() != null) {
            sql.SET("audit_uid = #{auditUid,jdbcType=BIGINT}");
        }
        
        if (record.getAuditPhone() != null) {
            sql.SET("audit_phone = #{auditPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditName() != null) {
            sql.SET("audit_name = #{auditName,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditTime() != null) {
            sql.SET("audit_time = #{auditTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenFeeOrderPayExample example, boolean includeExamplePhrase) {
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