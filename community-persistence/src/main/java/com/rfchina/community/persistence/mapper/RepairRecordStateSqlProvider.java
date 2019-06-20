package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.RepairRecordState;
import com.rfchina.community.persistence.model.RepairRecordStateExample.Criteria;
import com.rfchina.community.persistence.model.RepairRecordStateExample.Criterion;
import com.rfchina.community.persistence.model.RepairRecordStateExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class RepairRecordStateSqlProvider {

    public String countByExample(RepairRecordStateExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("repair_record_state");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(RepairRecordStateExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("repair_record_state");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(RepairRecordState record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("repair_record_state");
        
        if (record.getTskCode() != null) {
            sql.VALUES("tsk_code", "#{tskCode,jdbcType=VARCHAR}");
        }
        
        if (record.getTskState() != null) {
            sql.VALUES("tsk_state", "#{tskState,jdbcType=VARCHAR}");
        }
        
        if (record.getTskIstate() != null) {
            sql.VALUES("tsk_istate", "#{tskIstate,jdbcType=INTEGER}");
        }
        
        if (record.getTskComplete() != null) {
            sql.VALUES("tsk_complete", "#{tskComplete,jdbcType=INTEGER}");
        }
        
        if (record.getTskDesc() != null) {
            sql.VALUES("tsk_desc", "#{tskDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getTskCompleteTime() != null) {
            sql.VALUES("tsk_complete_time", "#{tskCompleteTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFormType() != null) {
            sql.VALUES("form_type", "#{formType,jdbcType=INTEGER}");
        }
        
        if (record.getOutReason() != null) {
            sql.VALUES("out_reason", "#{outReason,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(RepairRecordStateExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("tsk_code");
        sql.SELECT("tsk_state");
        sql.SELECT("tsk_istate");
        sql.SELECT("tsk_complete");
        sql.SELECT("tsk_desc");
        sql.SELECT("tsk_complete_time");
        sql.SELECT("form_type");
        sql.SELECT("out_reason");
        sql.SELECT("create_time");
        sql.FROM("repair_record_state");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        RepairRecordState record = (RepairRecordState) parameter.get("record");
        RepairRecordStateExample example = (RepairRecordStateExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("repair_record_state");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getTskCode() != null) {
            sql.SET("tsk_code = #{record.tskCode,jdbcType=VARCHAR}");
        }
        
        if (record.getTskState() != null) {
            sql.SET("tsk_state = #{record.tskState,jdbcType=VARCHAR}");
        }
        
        if (record.getTskIstate() != null) {
            sql.SET("tsk_istate = #{record.tskIstate,jdbcType=INTEGER}");
        }
        
        if (record.getTskComplete() != null) {
            sql.SET("tsk_complete = #{record.tskComplete,jdbcType=INTEGER}");
        }
        
        if (record.getTskDesc() != null) {
            sql.SET("tsk_desc = #{record.tskDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getTskCompleteTime() != null) {
            sql.SET("tsk_complete_time = #{record.tskCompleteTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFormType() != null) {
            sql.SET("form_type = #{record.formType,jdbcType=INTEGER}");
        }
        
        if (record.getOutReason() != null) {
            sql.SET("out_reason = #{record.outReason,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("repair_record_state");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("tsk_code = #{record.tskCode,jdbcType=VARCHAR}");
        sql.SET("tsk_state = #{record.tskState,jdbcType=VARCHAR}");
        sql.SET("tsk_istate = #{record.tskIstate,jdbcType=INTEGER}");
        sql.SET("tsk_complete = #{record.tskComplete,jdbcType=INTEGER}");
        sql.SET("tsk_desc = #{record.tskDesc,jdbcType=VARCHAR}");
        sql.SET("tsk_complete_time = #{record.tskCompleteTime,jdbcType=TIMESTAMP}");
        sql.SET("form_type = #{record.formType,jdbcType=INTEGER}");
        sql.SET("out_reason = #{record.outReason,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        RepairRecordStateExample example = (RepairRecordStateExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RepairRecordState record) {
        SQL sql = new SQL();
        sql.UPDATE("repair_record_state");
        
        if (record.getTskCode() != null) {
            sql.SET("tsk_code = #{tskCode,jdbcType=VARCHAR}");
        }
        
        if (record.getTskState() != null) {
            sql.SET("tsk_state = #{tskState,jdbcType=VARCHAR}");
        }
        
        if (record.getTskIstate() != null) {
            sql.SET("tsk_istate = #{tskIstate,jdbcType=INTEGER}");
        }
        
        if (record.getTskComplete() != null) {
            sql.SET("tsk_complete = #{tskComplete,jdbcType=INTEGER}");
        }
        
        if (record.getTskDesc() != null) {
            sql.SET("tsk_desc = #{tskDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getTskCompleteTime() != null) {
            sql.SET("tsk_complete_time = #{tskCompleteTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFormType() != null) {
            sql.SET("form_type = #{formType,jdbcType=INTEGER}");
        }
        
        if (record.getOutReason() != null) {
            sql.SET("out_reason = #{outReason,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, RepairRecordStateExample example, boolean includeExamplePhrase) {
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