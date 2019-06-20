package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.BonusPointActionRule;
import com.rfchina.community.persistence.model.BonusPointActionRuleExample.Criteria;
import com.rfchina.community.persistence.model.BonusPointActionRuleExample.Criterion;
import com.rfchina.community.persistence.model.BonusPointActionRuleExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class BonusPointActionRuleSqlProvider {

    public String countByExample(BonusPointActionRuleExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("bonus_point_action_rule");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(BonusPointActionRuleExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("bonus_point_action_rule");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(BonusPointActionRule record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("bonus_point_action_rule");
        
        if (record.getAction() != null) {
            sql.VALUES("action", "#{action,jdbcType=VARCHAR}");
        }
        
        if (record.getBpRule() != null) {
            sql.VALUES("bp_rule", "#{bpRule,jdbcType=VARCHAR}");
        }
        
        if (record.getBpValue() != null) {
            sql.VALUES("bp_value", "#{bpValue,jdbcType=INTEGER}");
        }
        
        if (record.getBpRuleDesc() != null) {
            sql.VALUES("bp_rule_desc", "#{bpRuleDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getRewardRule() != null) {
            sql.VALUES("reward_rule", "#{rewardRule,jdbcType=VARCHAR}");
        }
        
        if (record.getRewardValue() != null) {
            sql.VALUES("reward_value", "#{rewardValue,jdbcType=INTEGER}");
        }
        
        if (record.getStartActiveTime() != null) {
            sql.VALUES("start_active_time", "#{startActiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndActiveTime() != null) {
            sql.VALUES("end_active_time", "#{endActiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getActive() != null) {
            sql.VALUES("active", "#{active,jdbcType=BIT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(BonusPointActionRuleExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("action");
        sql.SELECT("bp_rule");
        sql.SELECT("bp_value");
        sql.SELECT("bp_rule_desc");
        sql.SELECT("reward_rule");
        sql.SELECT("reward_value");
        sql.SELECT("start_active_time");
        sql.SELECT("end_active_time");
        sql.SELECT("active");
        sql.FROM("bonus_point_action_rule");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BonusPointActionRule record = (BonusPointActionRule) parameter.get("record");
        BonusPointActionRuleExample example = (BonusPointActionRuleExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("bonus_point_action_rule");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getAction() != null) {
            sql.SET("action = #{record.action,jdbcType=VARCHAR}");
        }
        
        if (record.getBpRule() != null) {
            sql.SET("bp_rule = #{record.bpRule,jdbcType=VARCHAR}");
        }
        
        if (record.getBpValue() != null) {
            sql.SET("bp_value = #{record.bpValue,jdbcType=INTEGER}");
        }
        
        if (record.getBpRuleDesc() != null) {
            sql.SET("bp_rule_desc = #{record.bpRuleDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getRewardRule() != null) {
            sql.SET("reward_rule = #{record.rewardRule,jdbcType=VARCHAR}");
        }
        
        if (record.getRewardValue() != null) {
            sql.SET("reward_value = #{record.rewardValue,jdbcType=INTEGER}");
        }
        
        if (record.getStartActiveTime() != null) {
            sql.SET("start_active_time = #{record.startActiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndActiveTime() != null) {
            sql.SET("end_active_time = #{record.endActiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getActive() != null) {
            sql.SET("active = #{record.active,jdbcType=BIT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("bonus_point_action_rule");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("action = #{record.action,jdbcType=VARCHAR}");
        sql.SET("bp_rule = #{record.bpRule,jdbcType=VARCHAR}");
        sql.SET("bp_value = #{record.bpValue,jdbcType=INTEGER}");
        sql.SET("bp_rule_desc = #{record.bpRuleDesc,jdbcType=VARCHAR}");
        sql.SET("reward_rule = #{record.rewardRule,jdbcType=VARCHAR}");
        sql.SET("reward_value = #{record.rewardValue,jdbcType=INTEGER}");
        sql.SET("start_active_time = #{record.startActiveTime,jdbcType=TIMESTAMP}");
        sql.SET("end_active_time = #{record.endActiveTime,jdbcType=TIMESTAMP}");
        sql.SET("active = #{record.active,jdbcType=BIT}");
        
        BonusPointActionRuleExample example = (BonusPointActionRuleExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(BonusPointActionRule record) {
        SQL sql = new SQL();
        sql.UPDATE("bonus_point_action_rule");
        
        if (record.getAction() != null) {
            sql.SET("action = #{action,jdbcType=VARCHAR}");
        }
        
        if (record.getBpRule() != null) {
            sql.SET("bp_rule = #{bpRule,jdbcType=VARCHAR}");
        }
        
        if (record.getBpValue() != null) {
            sql.SET("bp_value = #{bpValue,jdbcType=INTEGER}");
        }
        
        if (record.getBpRuleDesc() != null) {
            sql.SET("bp_rule_desc = #{bpRuleDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getRewardRule() != null) {
            sql.SET("reward_rule = #{rewardRule,jdbcType=VARCHAR}");
        }
        
        if (record.getRewardValue() != null) {
            sql.SET("reward_value = #{rewardValue,jdbcType=INTEGER}");
        }
        
        if (record.getStartActiveTime() != null) {
            sql.SET("start_active_time = #{startActiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndActiveTime() != null) {
            sql.SET("end_active_time = #{endActiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getActive() != null) {
            sql.SET("active = #{active,jdbcType=BIT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, BonusPointActionRuleExample example, boolean includeExamplePhrase) {
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