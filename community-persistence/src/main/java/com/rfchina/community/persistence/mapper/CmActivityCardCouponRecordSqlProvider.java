package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CmActivityCardCouponRecord;
import com.rfchina.community.persistence.model.CmActivityCardCouponRecordExample.Criteria;
import com.rfchina.community.persistence.model.CmActivityCardCouponRecordExample.Criterion;
import com.rfchina.community.persistence.model.CmActivityCardCouponRecordExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CmActivityCardCouponRecordSqlProvider {

    public String countByExample(CmActivityCardCouponRecordExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("cm_activity_card_coupon_record");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CmActivityCardCouponRecordExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("cm_activity_card_coupon_record");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CmActivityCardCouponRecord record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("cm_activity_card_coupon_record");
        
        if (record.getActivityId() != null) {
            sql.VALUES("activity_id", "#{activityId,jdbcType=BIGINT}");
        }
        
        if (record.getCardCouponId() != null) {
            sql.VALUES("card_coupon_id", "#{cardCouponId,jdbcType=BIGINT}");
        }
        
        if (record.getCouponId() != null) {
            sql.VALUES("coupon_id", "#{couponId,jdbcType=BIGINT}");
        }
        
        if (record.getCouponSn() != null) {
            sql.VALUES("coupon_sn", "#{couponSn,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=BIGINT}");
        }
        
        if (record.getValidFromDate() != null) {
            sql.VALUES("valid_from_date", "#{validFromDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getValidToDate() != null) {
            sql.VALUES("valid_to_date", "#{validToDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCouponType() != null) {
            sql.VALUES("coupon_type", "#{couponType,jdbcType=INTEGER}");
        }
        
        if (record.getItemType() != null) {
            sql.VALUES("item_type", "#{itemType,jdbcType=INTEGER}");
        }
        
        if (record.getUseChannel() != null) {
            sql.VALUES("use_channel", "#{useChannel,jdbcType=INTEGER}");
        }
        
        if (record.getSource() != null) {
            sql.VALUES("source", "#{source,jdbcType=INTEGER}");
        }
        
        if (record.getConfirmStatus() != null) {
            sql.VALUES("confirm_status", "#{confirmStatus,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getConfirmCode() != null) {
            sql.VALUES("confirm_code", "#{confirmCode,jdbcType=VARCHAR}");
        }
        
        if (record.getConfirmTime() != null) {
            sql.VALUES("confirm_time", "#{confirmTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getConfirmUid() != null) {
            sql.VALUES("confirm_uid", "#{confirmUid,jdbcType=BIGINT}");
        }
        
        if (record.getIdcardNo() != null) {
            sql.VALUES("idcard_no", "#{idcardNo,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOperatorName() != null) {
            sql.VALUES("operator_name", "#{operatorName,jdbcType=VARCHAR}");
        }
        
        if (record.getOperatorPhone() != null) {
            sql.VALUES("operator_phone", "#{operatorPhone,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CmActivityCardCouponRecordExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("activity_id");
        sql.SELECT("card_coupon_id");
        sql.SELECT("coupon_id");
        sql.SELECT("coupon_sn");
        sql.SELECT("uid");
        sql.SELECT("valid_from_date");
        sql.SELECT("valid_to_date");
        sql.SELECT("coupon_type");
        sql.SELECT("item_type");
        sql.SELECT("use_channel");
        sql.SELECT("source");
        sql.SELECT("confirm_status");
        sql.SELECT("remark");
        sql.SELECT("confirm_code");
        sql.SELECT("confirm_time");
        sql.SELECT("confirm_uid");
        sql.SELECT("idcard_no");
        sql.SELECT("status");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("operator_name");
        sql.SELECT("operator_phone");
        sql.FROM("cm_activity_card_coupon_record");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CmActivityCardCouponRecord record = (CmActivityCardCouponRecord) parameter.get("record");
        CmActivityCardCouponRecordExample example = (CmActivityCardCouponRecordExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("cm_activity_card_coupon_record");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getActivityId() != null) {
            sql.SET("activity_id = #{record.activityId,jdbcType=BIGINT}");
        }
        
        if (record.getCardCouponId() != null) {
            sql.SET("card_coupon_id = #{record.cardCouponId,jdbcType=BIGINT}");
        }
        
        if (record.getCouponId() != null) {
            sql.SET("coupon_id = #{record.couponId,jdbcType=BIGINT}");
        }
        
        if (record.getCouponSn() != null) {
            sql.SET("coupon_sn = #{record.couponSn,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        }
        
        if (record.getValidFromDate() != null) {
            sql.SET("valid_from_date = #{record.validFromDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getValidToDate() != null) {
            sql.SET("valid_to_date = #{record.validToDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCouponType() != null) {
            sql.SET("coupon_type = #{record.couponType,jdbcType=INTEGER}");
        }
        
        if (record.getItemType() != null) {
            sql.SET("item_type = #{record.itemType,jdbcType=INTEGER}");
        }
        
        if (record.getUseChannel() != null) {
            sql.SET("use_channel = #{record.useChannel,jdbcType=INTEGER}");
        }
        
        if (record.getSource() != null) {
            sql.SET("source = #{record.source,jdbcType=INTEGER}");
        }
        
        if (record.getConfirmStatus() != null) {
            sql.SET("confirm_status = #{record.confirmStatus,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getConfirmCode() != null) {
            sql.SET("confirm_code = #{record.confirmCode,jdbcType=VARCHAR}");
        }
        
        if (record.getConfirmTime() != null) {
            sql.SET("confirm_time = #{record.confirmTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getConfirmUid() != null) {
            sql.SET("confirm_uid = #{record.confirmUid,jdbcType=BIGINT}");
        }
        
        if (record.getIdcardNo() != null) {
            sql.SET("idcard_no = #{record.idcardNo,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOperatorName() != null) {
            sql.SET("operator_name = #{record.operatorName,jdbcType=VARCHAR}");
        }
        
        if (record.getOperatorPhone() != null) {
            sql.SET("operator_phone = #{record.operatorPhone,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("cm_activity_card_coupon_record");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("activity_id = #{record.activityId,jdbcType=BIGINT}");
        sql.SET("card_coupon_id = #{record.cardCouponId,jdbcType=BIGINT}");
        sql.SET("coupon_id = #{record.couponId,jdbcType=BIGINT}");
        sql.SET("coupon_sn = #{record.couponSn,jdbcType=VARCHAR}");
        sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        sql.SET("valid_from_date = #{record.validFromDate,jdbcType=TIMESTAMP}");
        sql.SET("valid_to_date = #{record.validToDate,jdbcType=TIMESTAMP}");
        sql.SET("coupon_type = #{record.couponType,jdbcType=INTEGER}");
        sql.SET("item_type = #{record.itemType,jdbcType=INTEGER}");
        sql.SET("use_channel = #{record.useChannel,jdbcType=INTEGER}");
        sql.SET("source = #{record.source,jdbcType=INTEGER}");
        sql.SET("confirm_status = #{record.confirmStatus,jdbcType=INTEGER}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("confirm_code = #{record.confirmCode,jdbcType=VARCHAR}");
        sql.SET("confirm_time = #{record.confirmTime,jdbcType=TIMESTAMP}");
        sql.SET("confirm_uid = #{record.confirmUid,jdbcType=BIGINT}");
        sql.SET("idcard_no = #{record.idcardNo,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("operator_name = #{record.operatorName,jdbcType=VARCHAR}");
        sql.SET("operator_phone = #{record.operatorPhone,jdbcType=VARCHAR}");
        
        CmActivityCardCouponRecordExample example = (CmActivityCardCouponRecordExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CmActivityCardCouponRecord record) {
        SQL sql = new SQL();
        sql.UPDATE("cm_activity_card_coupon_record");
        
        if (record.getActivityId() != null) {
            sql.SET("activity_id = #{activityId,jdbcType=BIGINT}");
        }
        
        if (record.getCardCouponId() != null) {
            sql.SET("card_coupon_id = #{cardCouponId,jdbcType=BIGINT}");
        }
        
        if (record.getCouponId() != null) {
            sql.SET("coupon_id = #{couponId,jdbcType=BIGINT}");
        }
        
        if (record.getCouponSn() != null) {
            sql.SET("coupon_sn = #{couponSn,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=BIGINT}");
        }
        
        if (record.getValidFromDate() != null) {
            sql.SET("valid_from_date = #{validFromDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getValidToDate() != null) {
            sql.SET("valid_to_date = #{validToDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCouponType() != null) {
            sql.SET("coupon_type = #{couponType,jdbcType=INTEGER}");
        }
        
        if (record.getItemType() != null) {
            sql.SET("item_type = #{itemType,jdbcType=INTEGER}");
        }
        
        if (record.getUseChannel() != null) {
            sql.SET("use_channel = #{useChannel,jdbcType=INTEGER}");
        }
        
        if (record.getSource() != null) {
            sql.SET("source = #{source,jdbcType=INTEGER}");
        }
        
        if (record.getConfirmStatus() != null) {
            sql.SET("confirm_status = #{confirmStatus,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getConfirmCode() != null) {
            sql.SET("confirm_code = #{confirmCode,jdbcType=VARCHAR}");
        }
        
        if (record.getConfirmTime() != null) {
            sql.SET("confirm_time = #{confirmTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getConfirmUid() != null) {
            sql.SET("confirm_uid = #{confirmUid,jdbcType=BIGINT}");
        }
        
        if (record.getIdcardNo() != null) {
            sql.SET("idcard_no = #{idcardNo,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOperatorName() != null) {
            sql.SET("operator_name = #{operatorName,jdbcType=VARCHAR}");
        }
        
        if (record.getOperatorPhone() != null) {
            sql.SET("operator_phone = #{operatorPhone,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CmActivityCardCouponRecordExample example, boolean includeExamplePhrase) {
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