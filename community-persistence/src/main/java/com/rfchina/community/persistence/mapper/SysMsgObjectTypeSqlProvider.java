package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysMsgObjectType;
import com.rfchina.community.persistence.model.SysMsgObjectTypeExample.Criteria;
import com.rfchina.community.persistence.model.SysMsgObjectTypeExample.Criterion;
import com.rfchina.community.persistence.model.SysMsgObjectTypeExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SysMsgObjectTypeSqlProvider {

    public String countByExample(SysMsgObjectTypeExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_msg_object_type");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SysMsgObjectTypeExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_msg_object_type");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SysMsgObjectType record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_msg_object_type");
        
        if (record.getOtObjectType() != null) {
            sql.VALUES("ot_object_type", "#{otObjectType,jdbcType=VARCHAR}");
        }
        
        if (record.getOtTitle() != null) {
            sql.VALUES("ot_title", "#{otTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getOtTargetPf() != null) {
            sql.VALUES("ot_target_pf", "#{otTargetPf,jdbcType=VARCHAR}");
        }
        
        if (record.getOtOpenType() != null) {
            sql.VALUES("ot_open_type", "#{otOpenType,jdbcType=VARCHAR}");
        }
        
        if (record.getOtContent() != null) {
            sql.VALUES("ot_content", "#{otContent,jdbcType=VARCHAR}");
        }
        
        if (record.getOtResource() != null) {
            sql.VALUES("ot_resource", "#{otResource,jdbcType=INTEGER}");
        }
        
        if (record.getOtSourcePf() != null) {
            sql.VALUES("ot_source_pf", "#{otSourcePf,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SysMsgObjectTypeExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("ot_object_type");
        } else {
            sql.SELECT("ot_object_type");
        }
        sql.SELECT("ot_title");
        sql.SELECT("ot_target_pf");
        sql.SELECT("ot_open_type");
        sql.SELECT("ot_content");
        sql.SELECT("ot_resource");
        sql.SELECT("ot_source_pf");
        sql.FROM("sys_msg_object_type");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysMsgObjectType record = (SysMsgObjectType) parameter.get("record");
        SysMsgObjectTypeExample example = (SysMsgObjectTypeExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_msg_object_type");
        
        if (record.getOtObjectType() != null) {
            sql.SET("ot_object_type = #{record.otObjectType,jdbcType=VARCHAR}");
        }
        
        if (record.getOtTitle() != null) {
            sql.SET("ot_title = #{record.otTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getOtTargetPf() != null) {
            sql.SET("ot_target_pf = #{record.otTargetPf,jdbcType=VARCHAR}");
        }
        
        if (record.getOtOpenType() != null) {
            sql.SET("ot_open_type = #{record.otOpenType,jdbcType=VARCHAR}");
        }
        
        if (record.getOtContent() != null) {
            sql.SET("ot_content = #{record.otContent,jdbcType=VARCHAR}");
        }
        
        if (record.getOtResource() != null) {
            sql.SET("ot_resource = #{record.otResource,jdbcType=INTEGER}");
        }
        
        if (record.getOtSourcePf() != null) {
            sql.SET("ot_source_pf = #{record.otSourcePf,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_msg_object_type");
        
        sql.SET("ot_object_type = #{record.otObjectType,jdbcType=VARCHAR}");
        sql.SET("ot_title = #{record.otTitle,jdbcType=VARCHAR}");
        sql.SET("ot_target_pf = #{record.otTargetPf,jdbcType=VARCHAR}");
        sql.SET("ot_open_type = #{record.otOpenType,jdbcType=VARCHAR}");
        sql.SET("ot_content = #{record.otContent,jdbcType=VARCHAR}");
        sql.SET("ot_resource = #{record.otResource,jdbcType=INTEGER}");
        sql.SET("ot_source_pf = #{record.otSourcePf,jdbcType=VARCHAR}");
        
        SysMsgObjectTypeExample example = (SysMsgObjectTypeExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysMsgObjectType record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_msg_object_type");
        
        if (record.getOtTitle() != null) {
            sql.SET("ot_title = #{otTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getOtTargetPf() != null) {
            sql.SET("ot_target_pf = #{otTargetPf,jdbcType=VARCHAR}");
        }
        
        if (record.getOtOpenType() != null) {
            sql.SET("ot_open_type = #{otOpenType,jdbcType=VARCHAR}");
        }
        
        if (record.getOtContent() != null) {
            sql.SET("ot_content = #{otContent,jdbcType=VARCHAR}");
        }
        
        if (record.getOtResource() != null) {
            sql.SET("ot_resource = #{otResource,jdbcType=INTEGER}");
        }
        
        if (record.getOtSourcePf() != null) {
            sql.SET("ot_source_pf = #{otSourcePf,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("ot_object_type = #{otObjectType,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SysMsgObjectTypeExample example, boolean includeExamplePhrase) {
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