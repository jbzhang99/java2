package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.BaseSettlementApply;
import com.rfchina.community.persistence.model.BaseSettlementApplyExample.Criteria;
import com.rfchina.community.persistence.model.BaseSettlementApplyExample.Criterion;
import com.rfchina.community.persistence.model.BaseSettlementApplyExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class BaseSettlementApplySqlProvider {

    public String countByExample(BaseSettlementApplyExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("base_settlement_apply");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(BaseSettlementApplyExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("base_settlement_apply");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(BaseSettlementApply record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("base_settlement_apply");
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStartTime() != null) {
            sql.VALUES("start_time", "#{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.VALUES("end_time", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getPayAccount() != null) {
            sql.VALUES("pay_account", "#{payAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantId() != null) {
            sql.VALUES("merchant_id", "#{merchantId,jdbcType=VARCHAR}");
        }
        
        if (record.getSettleId() != null) {
            sql.VALUES("settle_id", "#{settleId,jdbcType=VARCHAR}");
        }
        
        if (record.getSettleStatus() != null) {
            sql.VALUES("settle_status", "#{settleStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCheckTime() != null) {
            sql.VALUES("check_time", "#{checkTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCheckText() != null) {
            sql.VALUES("check_text", "#{checkText,jdbcType=VARCHAR}");
        }
        
        if (record.getApproveComment() != null) {
            sql.VALUES("approve_comment", "#{approveComment,jdbcType=VARCHAR}");
        }
        
        if (record.getApproveTime() != null) {
            sql.VALUES("approve_time", "#{approveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApproveStatus() != null) {
            sql.VALUES("approve_status", "#{approveStatus,jdbcType=INTEGER}");
        }
        
        if (record.getImage() != null) {
            sql.VALUES("image", "#{image,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateUid() != null) {
            sql.VALUES("create_uid", "#{createUid,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(BaseSettlementApplyExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("community_id");
        sql.SELECT("create_time");
        sql.SELECT("start_time");
        sql.SELECT("end_time");
        sql.SELECT("status");
        sql.SELECT("pay_account");
        sql.SELECT("merchant_id");
        sql.SELECT("settle_id");
        sql.SELECT("settle_status");
        sql.SELECT("check_time");
        sql.SELECT("check_text");
        sql.SELECT("approve_comment");
        sql.SELECT("approve_time");
        sql.SELECT("approve_status");
        sql.SELECT("image");
        sql.SELECT("create_uid");
        sql.FROM("base_settlement_apply");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BaseSettlementApply record = (BaseSettlementApply) parameter.get("record");
        BaseSettlementApplyExample example = (BaseSettlementApplyExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("base_settlement_apply");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getPayAccount() != null) {
            sql.SET("pay_account = #{record.payAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantId() != null) {
            sql.SET("merchant_id = #{record.merchantId,jdbcType=VARCHAR}");
        }
        
        if (record.getSettleId() != null) {
            sql.SET("settle_id = #{record.settleId,jdbcType=VARCHAR}");
        }
        
        if (record.getSettleStatus() != null) {
            sql.SET("settle_status = #{record.settleStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCheckTime() != null) {
            sql.SET("check_time = #{record.checkTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCheckText() != null) {
            sql.SET("check_text = #{record.checkText,jdbcType=VARCHAR}");
        }
        
        if (record.getApproveComment() != null) {
            sql.SET("approve_comment = #{record.approveComment,jdbcType=VARCHAR}");
        }
        
        if (record.getApproveTime() != null) {
            sql.SET("approve_time = #{record.approveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApproveStatus() != null) {
            sql.SET("approve_status = #{record.approveStatus,jdbcType=INTEGER}");
        }
        
        if (record.getImage() != null) {
            sql.SET("image = #{record.image,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateUid() != null) {
            sql.SET("create_uid = #{record.createUid,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("base_settlement_apply");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("pay_account = #{record.payAccount,jdbcType=VARCHAR}");
        sql.SET("merchant_id = #{record.merchantId,jdbcType=VARCHAR}");
        sql.SET("settle_id = #{record.settleId,jdbcType=VARCHAR}");
        sql.SET("settle_status = #{record.settleStatus,jdbcType=INTEGER}");
        sql.SET("check_time = #{record.checkTime,jdbcType=TIMESTAMP}");
        sql.SET("check_text = #{record.checkText,jdbcType=VARCHAR}");
        sql.SET("approve_comment = #{record.approveComment,jdbcType=VARCHAR}");
        sql.SET("approve_time = #{record.approveTime,jdbcType=TIMESTAMP}");
        sql.SET("approve_status = #{record.approveStatus,jdbcType=INTEGER}");
        sql.SET("image = #{record.image,jdbcType=VARCHAR}");
        sql.SET("create_uid = #{record.createUid,jdbcType=BIGINT}");
        
        BaseSettlementApplyExample example = (BaseSettlementApplyExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(BaseSettlementApply record) {
        SQL sql = new SQL();
        sql.UPDATE("base_settlement_apply");
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getPayAccount() != null) {
            sql.SET("pay_account = #{payAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantId() != null) {
            sql.SET("merchant_id = #{merchantId,jdbcType=VARCHAR}");
        }
        
        if (record.getSettleId() != null) {
            sql.SET("settle_id = #{settleId,jdbcType=VARCHAR}");
        }
        
        if (record.getSettleStatus() != null) {
            sql.SET("settle_status = #{settleStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCheckTime() != null) {
            sql.SET("check_time = #{checkTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCheckText() != null) {
            sql.SET("check_text = #{checkText,jdbcType=VARCHAR}");
        }
        
        if (record.getApproveComment() != null) {
            sql.SET("approve_comment = #{approveComment,jdbcType=VARCHAR}");
        }
        
        if (record.getApproveTime() != null) {
            sql.SET("approve_time = #{approveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApproveStatus() != null) {
            sql.SET("approve_status = #{approveStatus,jdbcType=INTEGER}");
        }
        
        if (record.getImage() != null) {
            sql.SET("image = #{image,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateUid() != null) {
            sql.SET("create_uid = #{createUid,jdbcType=BIGINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, BaseSettlementApplyExample example, boolean includeExamplePhrase) {
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